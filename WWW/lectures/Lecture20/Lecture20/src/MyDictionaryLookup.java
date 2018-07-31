/*
 * File: MyDictionaryLookup.java
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

public class MyDictionaryLookup extends ConsoleProgram {
private static final String DICTIONARY_FILE = "res/dictionary.txt";
	
	public void run() {
		// TODO create a HashMap to serve as our dictionary within the program
		try {
			// each pair of lines in the file is a word followed by definition:
			// abrogate	  
			// repeal or annul by authority
			Scanner input = new Scanner(new File(DICTIONARY_FILE));
			while (input.hasNextLine()) {
				String word = input.nextLine();
				String definition = input.nextLine();
				
				// TODO add word and definition to the dictionary HashMap
			}
		} catch (IOException e) {
			println("file error: " + e);
		}

		// look up words in the dictionary
		String word = readLine("Word to look up (or Enter to quit)? ");
		while (!word.equals("")) {
			// TODO if the word is in dictionary, print the definition.
			print("Definition: ");
			println("I don't know that word!");
			
			word = readLine("Word to look up (or Enter to quit)? ");
		}
	}
}
