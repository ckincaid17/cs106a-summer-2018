/*
 * File: DictionaryLookup.java
 * -----------------------
 * This program reads an input file containing a series of pairs of lines,
 * where each pair consists of a word and its definition on two separate lines.
 * The program stores the word/definition pairs in a HashMap, and then prompts
 * the user to type a word, after which the program prints out the definition.
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class DictionaryLookup extends ConsoleProgram {
	
	private static final String DICTIONARY_FILE = "res/dictionary.txt";
	
	public void run() {
		HashMap<String, String> dictionary = new HashMap<>(); 
		try {
			// each pair of lines in the file is a word followed by definition:
			// abrogate	  
			// repeal or annul by authority
			Scanner input = new Scanner(new File(DICTIONARY_FILE));
			while (input.hasNextLine()) {
				String word = input.nextLine();
				String definition = input.nextLine();
				
				dictionary.put(word, definition);
			}
		} catch (IOException e) {
			println("file error: " + e);
		}

		// look up words in the dictionary
		String word = readLine("Word to look up (or Enter to quit)? ");
		while (!word.equals("")) {
			if (dictionary.containsKey(word)) {
				String definition = dictionary.get(word);
				println("Definition: " + definition);
			} else {
				println("I don't know that word!");
			}
			
			word = readLine("Word to look up (or Enter to quit)? ");
		}
	}
}
