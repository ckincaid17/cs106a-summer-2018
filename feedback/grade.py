# Feedback credit script originally written by Colin Kincaid, Summer 2018
#
# Input:
#   A list of response identifiers (mostly hashes, some SUNets): submissions.txt
#   A list of students' first names, last names, SUNet IDs: names_sunets.csv
#
# Outputs:
#   A list of SUNet hashes and the number of lectures for which they submitted

from collections import Counter
import hashlib

def main():
    submissionCounter = Counter()
    with open('submissions.txt', 'r') as submissions:
        for line in submissions:
            submissionCounter[line.strip()] += 1
    sunetCounter = Counter()
    with open('names_sunets.csv', 'r') as names:
        for line in names:
            tokens = line.split(',')
            name = ('%s %s' % (tokens[0], tokens[1])).strip()
            sunet = tokens[2].strip()
            # Be nice to people who did not follow instructions
            for alias in [name, sunet]:
                m = hashlib.md5()
                m.update(alias)
                hashStr = m.digest()
                encodedHash = (''.join(c.encode('hex') for c in hashStr)).upper()
                sunetCounter[sunet] += submissionCounter[alias] + submissionCounter[encodedHash]
    # socrative.csv to match Marty's grademagick script, which I do not recommend (sorry, Marty!)
    with open('socrative.csv', 'w') as outfile:
        for sunet, count in sunetCounter.most_common():
            outfile.write('%s,%d\n' % (sunet, count))

if __name__ == '__main__':
    main()
