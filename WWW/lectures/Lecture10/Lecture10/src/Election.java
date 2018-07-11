/*
 * CS 106A, Week 3, File Processing
 * 
 * This program computes leader in presidential polls, using
 * an input file such as: 
 * AK 42 53 3 Oct Ivan Moore Research
 * AZ 71 26 6 Sep University of Arizona McKale Center
 */

import acm.program.*;
import java.io.*;    // for File
import java.util.*;  // for Scanner

public class Election extends ConsoleProgram {
	public void run() {
		String filename = promptUserForFile("Polls filename? ", "res");
		
		try {
			Scanner input = new Scanner(new File(filename));
			int candidate1TotalVotes = 0;
			int candidate2TotalVotes = 0;
			while (input.hasNextLine()) {
				// e.g. "AL 34 54 9 Oct Capital Survey"
				String line = input.nextLine();
				
				// Make a new scanner to help parse this one line
				Scanner tokens = new Scanner(line);
				tokens.next();   // State abbreviation (do nothing with this)
				int candidate1Percent = tokens.nextInt();   // e.g. 34
				int candidate2Percent = tokens.nextInt();   // e.g. 54
				int electoralVotes    = tokens.nextInt();   // e.g. 9
				if (candidate1Percent > candidate2Percent) {
					candidate1TotalVotes += electoralVotes;
				} else {
					candidate2TotalVotes += electoralVotes;
				}
				// Ignore the remaining tokens
			}
			input.close();

			println("Candidate 1 earned " + candidate1TotalVotes + " votes.");
			println("Candidate 2 earned " + candidate2TotalVotes + " votes.");
		} catch (FileNotFoundException ex) {
			println("Error reading file: " + ex);
		}
	}
}
