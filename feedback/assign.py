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
import random
import hashlib

# NUM_LECTURES must be divisible by NUM_FEEDBACK_OCCURENCES
NUM_LECTURES = 28
NUM_FEEDBACK_OCCURENCES = 2
NUM_LECTURES_PER_ROUND = NUM_LECTURES / NUM_FEEDBACK_OCCURENCES
INSTRUCTIONS = "You can locate yourself in this list by going to http://passwordsgenerator.net/md5-hash-generator/ and entering your SUNet ID (e.g., ckincaid). Search for the MD5 hash result in this list to find the numbers of the lectures for which you should give feedback. Refer to the schedule (cs106a.stanford.edu/schedule) to see the date that corresponds to each lecture number. If you cannot find your hash in this list, please go to https://cs198.stanford.edu/cs198/auth/Profile.aspx to confirm that the SUNet ID that we have on file for you is the one you tried to use. If you still cannot find yourself, please email the head TA.\n\nOn your assigned lecture days (and other days if you feel so inclined), please submit feedback at https://goo.gl/forms/B4r5slzkdJxpdrEf1.\n\n"

def assignLectures(i, sunetList, assignmentsByDay, assignmentsByHash):
    lecturesLeftToAssign = NUM_LECTURES_PER_ROUND
    while lecturesLeftToAssign > 0:
        lectureNum = i * NUM_LECTURES_PER_ROUND + lecturesLeftToAssign
        numStudentsToAssign = int(len(sunetList) / lecturesLeftToAssign)
        chosenStudents = random.sample(sunetList, numStudentsToAssign)
        for student in chosenStudents:                        
            if lectureNum not in assignmentsByDay:
                assignmentsByDay[lectureNum] = [student]
            else:
                assignmentsByDay[lectureNum].append(student)

            m = hashlib.md5()
            m.update(student)
            sunetHashStr = m.digest()
            sunetHash = ''.join(c.encode('hex') for c in sunetHashStr)
            # store hash as all-uppercase
            sunetHash = sunetHash.upper()
            if sunetHash not in assignmentsByHash:
                assignmentsByHash[sunetHash] = [lectureNum]
            else:
                assignmentsByHash[sunetHash].append(lectureNum)

            sunetList.remove(student)
        lecturesLeftToAssign -= 1

def main():
    sunets = []
    with open('sunets.txt', 'r') as sunetFile:
        for line in sunetFile:
            sunets.append(line.strip())

    assignmentsByDay = {}
    assignmentsByHash = {}
    for i in range(NUM_FEEDBACK_OCCURENCES):
        assignLectures(i, copy(sunets), assignmentsByDay, assignmentsByHash)

    with open('daily-assignments.txt', 'w') as dailyAssignmentFile:
        for lectureNum, students in sorted(assignmentsByDay.iteritems()):
            dailyAssignmentFile.write('%d: %s\n' % (lectureNum, students))

    with open('hashed-assignments.txt', 'w') as hashedAssignmentFile:
        hashedAssignmentFile.write(INSTRUCTIONS)
        for sunetHash, lectureNums in assignmentsByHash.iteritems():
            hashedAssignmentFile.write('%s: %s\n' % (sunetHash, lectureNums))

if __name__ == '__main__':
    main()