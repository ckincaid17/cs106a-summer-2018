/*
 * File: Anagrams.java
 * ---------------------
 * This program reads in a dictionary text file to calculate
 * words that are anagrams, and then prompts the user for words
 * for each one printing out all anagrams of that word. 
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class Anagrams extends ConsoleProgram {
	public void run() {
		HashMap<String, ArrayList<String>> anagrams = createAnagramsMap();
		
		// prompt user for words and look up anagrams in map
		String word = readLine("Type a word [Enter to quit]: ");
		while (word.length() > 0) {
		    String sorted = sortLetters(word.toLowerCase());
		    if (anagrams.containsKey(sorted)) {
		        println("Anagrams of " + word + ":");
		        println(anagrams.get(sorted));
		    } else {
		        println("No anagrams for " + word + ".");
		    }
		    word = readLine("Type a word [Enter to quit]: ");
		}
	}
	
	/*
	 * This method reads in the dictionary.txt file and creates a map from
	 * a sorted string of characters to all words made up of those characters.
	 * e.g. “acers” -> {“scare”, “cares”,...}
	 */
	private HashMap<String, ArrayList<String>> createAnagramsMap() {
		HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
		
		try {
			Scanner scanner = new Scanner(new File("res/dictionary.txt"));
			while (scanner.hasNext()) {
				String word = scanner.next();
				String sorted = sortLetters(word);
				
				// Either get the current word list, or make a new empty one
				ArrayList<String> words;
				if (anagrams.containsKey(sorted)) {
					words = anagrams.get(sorted);
				} else {
					words = new ArrayList<>();
				}
				
				// Update the list with our new word
				words.add(word);
				anagrams.put(sorted, words);
			}
			scanner.close();
		} catch (IOException ex) {
			println("Error reading file.");
		}
		
		return anagrams;
	}
	
	/*
	 * Arranges the letters of the given string into sorted order.
	 * For example, sortLetters("sacred") returns "acders".
	 * Note: this method was provided for you in this problem.
	 */
	private String sortLetters(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}

