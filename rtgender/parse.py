from collections import defaultdict
import csv
import spacy

nlp = spacy.load('en')

FILE = 'ted_responses.csv'
FEMALE_TERMS = ['she', 'her', 'woman', 'girl', 'lady']
MALE_TERMS = ['he', 'him', 'man', 'boy', 'guy', 'dude']
simple = False

def parse_chunks(threshold):
	adjsF = defaultdict(int)
	adjsM = defaultdict(int)
	numlines = 0
	with open(FILE) as f:
		reader = csv.DictReader(f)
		for row in reader:
			if threshold > 0 and numlines > threshold:
				break
			if numlines % 100 == 0:
				print(numlines)

			response = row['response_text']
			doc = nlp(unicode(response, "utf-8"))
			for chunk in doc.noun_chunks:
				if chunk.root.lemma_ in FEMALE_TERMS:
					for child in chunk.root.children:
						if child.dep_=='amod':
							adjsF[child.lemma_] += 1
				elif chunk.root.lemma_ in MALE_TERMS:
					for child in chunk.root.children:
						if child.dep_=='amod':
							adjsM[child.lemma_] += 1
			numlines += 1
	return adjsF, adjsM

def read_file(gender, threshold):
	adjs = defaultdict(int)
	numlines = 0
	with open(FILE) as f:
		reader = csv.DictReader(f)
		for row in reader:
			if row['op_gender'] != gender:
				continue
			if threshold > 0 and numlines > threshold:
				break
			if numlines % 100 == 0:
				print(numlines)

			response = row['response_text']
			doc = nlp(unicode(response, "utf-8"))
			for token in doc:
				if token.pos_ == 'ADJ' and token.lemma_.isalpha():
						adjs[token.lemma_] += 1
			numlines += 1

	return adjs

if simple:
	adjsF = read_file('W', 10000)
	adjsM = read_file('M', 10000)
else:
	adjsF, adjsM = parse_chunks(-1)

print(len(adjsF), len(adjsM))

out = open('ted-data-chunks.txt', 'w')

for adj, count in adjsF.items():
	if adj not in adjsM:
		continue
	# if count + adjsM[count] < 50:
	# 	continue
	out.write(adj + ' ' + 'F' + ' ' + str(count) + '\n')
	out.write(adj + ' ' + 'M' + ' ' + str(adjsM[adj]) + '\n')
