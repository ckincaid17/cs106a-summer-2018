from collections import defaultdict
import csv
import spacy
import pickle
import random

nlp = spacy.load('en')

FILES = [
	'facebook_congress_responses.csv',
	'facebook_wiki_responses.csv',
	'ted_responses.csv',
	'fitocracy_responses.csv',
	'reddit_responses.csv'
]
FEMALE_TERMS = ['she', 'her', 'woman', 'girl', 'lady', 'actress', 'mom', 'mother', 'sister', 'aunt', 'wife', 'waitress']
MALE_TERMS = ['he', 'him', 'man', 'boy', 'guy', 'dude', 'actor', 'bachelor', 'dad', 'father', 'husband', 'uncle', 'waiter', 'brother']
simple = True

def parse_chunks(threshold, filename):
	adjsF = defaultdict(int)
	adjsM = defaultdict(int)
	numlines = 0
	totallines = len(open(filename).readlines())
	print('Selecting %d responses from %d total' % (threshold, totallines))
	indices = random.sample(range(totallines), threshold)

	with open(filename) as f:
		reader = csv.DictReader(f)
		for row in reader:
			numlines += 1
			if numlines % 100 == 0:
				print(numlines)
			if threshold > 0 and numlines not in indices:
				continue

			response = row['response_text']
			doc = nlp(response)
			for chunk in doc.noun_chunks:
				if chunk.root.lemma_ in FEMALE_TERMS:
					for child in chunk.root.children:
						if child.dep_=='amod':
							adjsF[child.lemma_] += 1
				elif chunk.root.lemma_ in MALE_TERMS:
					for child in chunk.root.children:
						if child.dep_=='amod':
							adjsM[child.lemma_] += 1
	return adjsF, adjsM

def read_file(threshold, filename):
	adjsF = defaultdict(int)
	adjsM = defaultdict(int)
	numlines = 0
	totallines = len(open(filename).readlines())
	print('Selecting %d responses from %d total' % (threshold, totallines))
	# indices = random.sample(range(totallines), threshold)

	with open(filename) as f:
		reader = csv.DictReader(f)
		for row in reader:
			if threshold > 0 and random.random() > (1.0*threshold/totallines):
				continue
			if numlines % 100 == 0:
				print(numlines)

			response = unicode(row['response_text'], 'utf-8')
			doc = nlp(response)
			for token in doc:
				if token.pos_ == 'ADJ' and token.lemma_.isalpha():
					if row['op_gender'] == 'W':
						adjsF[token.lemma_] += 1
					else:
						adjsM[token.lemma_] += 1
			numlines += 1

	return adjsF, adjsM

adjsF_all = defaultdict(dict)
adjsM_all = defaultdict(dict)
for filename in FILES:
	print('parsing', filename)
	if simple:
		adjsF, adjsM = read_file(100000, filename)
	else:
		adjsF, adjsM = parse_chunks(1000000, filename)
	print(len(adjsF), len(adjsM))
	for adj, count in adjsF.items():
		if adj not in adjsM:
			continue
		pickle.dump([adjsF, adjsM], open('out-' + filename[:-4] + '.pkl', 'wb'))
		adjsF_all[adj][filename] = count
		adjsM_all[adj][filename] = adjsM[adj]

print(len(adjsF_all), len(adjsM_all))

out = open('data-chunks-full.txt', 'w')

for adj, adjsF in adjsF_all.items():
	if adj not in adjsM_all:
		continue
	countsF = []
	countsM = []
	for filename in FILES:
		countsF.append(str(adjsF[filename]) if filename in adjsF else '0')
		countsM.append(str(adjsM_all[adj][filename]) if filename in adjsM_all[adj] else '0')
	out.write(' '.join([adj, 'W', ' '.join(countsF), 'M', ' '.join(countsM)]) + '\n')
