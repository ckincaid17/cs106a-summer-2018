# Feedback assignment script originally written by Colin Kincaid, Summer 2018
#
# Input:
#   A list of students' SUNet IDs: sunets.txt
#
# Outputs:
#   A list of lecture days and their assigned SUNets: daily-assignments.txt
#   A list of SUNet hashes and their assigned lectures: hashed-assignments.txt
#
# Privacy: DO NOT include sunets.txt or daily-assignments.txt in the Git repo.
#
# This script uses some Python 2 methods. Sorry.

from copy import copy
from collections import defaultdict
import random
import hashlib
import ast

# set to True if some lectures already assigned
reassign = True
# NUM_LECTURES must be divisible by NUM_FEEDBACK_OCCURENCES
OFFSET = 8 if reassign else 0
NUM_LECTURES = 28 - OFFSET
NUM_FEEDBACK_OCCURENCES = 2
NUM_LECTURES_PER_ROUND = NUM_LECTURES / NUM_FEEDBACK_OCCURENCES
INSTRUCTIONS = "You can locate yourself in this list by going to http://passwordsgenerator.net/md5-hash-generator/ and entering your SUNet ID (e.g., ckincaid). Search for the MD5 hash result in this list to find the numbers of the lectures for which you should give feedback. Refer to the schedule (cs106a.stanford.edu/schedule) to see the date that corresponds to each lecture number. If you cannot find your hash in this list, please go to https://cs198.stanford.edu/cs198/auth/Profile.aspx to confirm that the SUNet ID that we have on file for you is the one you tried to use. If you still cannot find yourself, please email the head TA.\n\nOn your assigned lecture days (and other days if you feel so inclined), please submit feedback at https://goo.gl/forms/B4r5slzkdJxpdrEf1.\n\n"

DAILY = "daily-assignments.txt"
HASHED = "hashed-assignments.txt"

def assignLectures(i, sunetList, assignmentsByDay, assignmentsByHash):
    lecturesLeftToAssign = NUM_LECTURES_PER_ROUND
    while lecturesLeftToAssign > 0:
        lectureNum = i * NUM_LECTURES_PER_ROUND + lecturesLeftToAssign + OFFSET
        numStudentsToAssign = int(len(sunetList) / lecturesLeftToAssign)
        chosenStudents = random.sample(sunetList, numStudentsToAssign)
        for student in chosenStudents:
            assignmentsByDay[lectureNum].append(student)

            m = hashlib.md5()
            m.update(student)
            sunetHashStr = m.digest()
            sunetHash = ''.join(c.encode('hex') for c in sunetHashStr)
            # store hash as all-uppercase
            sunetHash = sunetHash.upper()
            assignmentsByHash[sunetHash].append(lectureNum)

            sunetList.remove(student)
        lecturesLeftToAssign -= 1

def removeDroppedStudents(sunets_new, assignmentsByDay, assignmentsByHash):
    with open(DAILY) as dailyAssignmentFile:
        lectureNum = 1
        for line in dailyAssignmentFile:
            sunets = ast.literal_eval(line[line.find(':')+2:])
            assignmentsByDay[lectureNum] = [x for x in sunets if x in sunets_new]
            lectureNum += 1

    hashes = []
    for student in sunets_new:
        m = hashlib.md5()
        m.update(student)
        sunetHashStr = m.digest()
        sunetHash = ''.join(c.encode('hex') for c in sunetHashStr)
        hashes.append(sunetHash.upper())

    with open(HASHED) as hashedAssignmentFile:
        skip = 1
        for line in hashedAssignmentFile:
            if skip < 5: # lol jankily skipping the intro text
                skip += 1
                continue
            sunetHash = line[:line.find(':')]
            if sunetHash in hashes:
                assignmentsByHash[sunetHash] = ast.literal_eval(line[line.find(':') + 2:])

def main():
    sunets = []
    with open('sunets.txt', 'r') as sunetFile:
        for line in sunetFile:
            sunets.append(line.strip())

    assignmentsByDay = defaultdict(list)
    assignmentsByHash = defaultdict(list)
    if reassign:
        sunets_new = []
        with open('sunets-final.txt', 'r') as sunetFile:
            for line in sunetFile:
                sunets_new.append(line.strip())
        removeDroppedStudents(sunets_new, assignmentsByDay, assignmentsByHash)
        # assign only new students to lectures
        for i in range(NUM_FEEDBACK_OCCURENCES):
            assignLectures(i, list(set(sunets_new) - set(sunets)), assignmentsByDay, assignmentsByHash)
    else:
        for i in range(NUM_FEEDBACK_OCCURENCES):
            assignLectures(i, copy(sunets), assignmentsByDay, assignmentsByHash)

    print 'enrollment:', len(assignmentsByHash)
    with open(DAILY, 'w') as dailyAssignmentFile:
        for lectureNum, students in sorted(assignmentsByDay.iteritems()):
            dailyAssignmentFile.write('%d: %s\n' % (lectureNum, students))

    with open(HASHED, 'w') as hashedAssignmentFile:
        hashedAssignmentFile.write(INSTRUCTIONS)
        for sunetHash, lectureNums in assignmentsByHash.iteritems():
            hashedAssignmentFile.write('%s: %s\n' % (sunetHash, lectureNums))

if __name__ == '__main__':
    main()
