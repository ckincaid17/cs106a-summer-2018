from __future__ import division

from collections import defaultdict
import csv
import pickle

FILES = [
	'facebook_congress_responses',
	'facebook_wiki_responses',
	'ted_responses',
	'reddit_responses',
	'fitocracy_responses'
]

normalize = False

adjsF_all = defaultdict(dict)
adjsM_all = defaultdict(dict)
for filename in FILES:
	print('loading', filename)
	adjsF, adjsM = pickle.load(open('out-simple-' + filename + '.pkl', 'rb'))
	if normalize:
		reader = csv.DictReader(open(filename + '.csv'))
		gender = [r['op_gender'] for r in reader]
		numF = gender.count('W') * 1000000 / len(gender)
		numM = gender.count('M') * 1000000 / len(gender)
		print(numF, numM)
	print(len(adjsF), len(adjsM))
	for adj, count in adjsF.items():
		if adj not in adjsM:
			continue
		adjsF_all[adj][filename] = count
		adjsM_all[adj][filename] = adjsM[adj]
		if normalize and numF < numM:
			adjsF_all[adj][filename] = int(count * numM / numF)
		elif normalize:
			adjsM_all[adj][filename] = int(adjsM[adj] * numF / numM)

print(len(adjsF_all), len(adjsM_all))

out = open('data-simple-processed.txt', 'w')

for adj, adjsF in adjsF_all.items():
	if adj not in adjsM_all or len(adjsF) < 3 or len(adjsM_all[adj]) < 3:
		continue
	countsF = []
	countsM = []
	for filename in FILES:
		countsF.append(str(adjsF[filename]) if filename in adjsF else '0')
		countsM.append(str(adjsM_all[adj][filename]) if filename in adjsM_all[adj] else '0')
	out.write(' '.join([adj, 'W', ' '.join(countsF), 'M', ' '.join(countsM)]) + '\n')
