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
            # IMPORTANT NOTE: This uses lowercase letters. The program
            # that checks attendance should be case-insensitive.
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
        for sunetHash, lectureNums in assignmentsByHash.iteritems():
            hashedAssignmentFile.write('%s: %s\n' % (sunetHash, lectureNums))

if __name__ == '__main__':
    main()