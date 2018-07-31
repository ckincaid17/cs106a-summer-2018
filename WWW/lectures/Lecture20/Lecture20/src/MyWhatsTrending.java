/*
 * File: WhatsTrending.java
 * -----------------------
 * This program uses a HashMap to store and output
 * the top trending tweets in a given text file.
 * It works by taking tweets that look like:
 *	
 *		I love CS 106A! #java #kareltherobot
 *
 * and mapping them to frequencies like:
 *
 *		#java ---> 1
 *		#kareltherobot ---> 1
 * -----------------------
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class MyWhatsTrending extends ConsoleProgram {
	public void run() {
		String filename = promptUserForFile("Tweets file: ", "res");
		// create hashtag frequency map using readTweets method
		
		// Print out hashtags that occur at least 15 times
	}

	// Returns a map from hashtags to their frequency in the given file
	private HashMap<String, Integer> readTweets(String filename) {
		// TODO create hashtag frequency map
		
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNext()) {
				String word = input.next().toLowerCase();

				// skip if not a hashtag
				if (word.charAt(0) == '#') {
					// TODO record hashtag in the frequency map
				}
			}
		} catch (IOException ex) {
			println("Error reading file: " + ex);
		}
		
		// TODO return the frequency map
		return null;
	}
}

