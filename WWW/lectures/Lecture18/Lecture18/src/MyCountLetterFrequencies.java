/* File: CountLetterFrequencies.java
 * --------------------
 * This program counts the frequency of letters in user-entered text.
 */

import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

/**
 * This program creates a table of the letter frequencies in a
 * paragraph of input text terminated by a blank line.
 */
public class MyCountLetterFrequencies extends GraphicsProgram {
	
	private static final int ALPHABET_LEN = 26;
	
	public void run() {
		println("This program counts letter frequencies.");
		println("Enter a blank line to indicate the end of the text.");
		// create frequency table
		while (true) {
			String line = readLine();
			if (line.length() == 0) break;
			 countLetterFrequencies(line /*, frequencyTable*/);
		}
		 printFrequencyTable(/*frequencyTable*/);
	}

	/* Counts the letter frequencies in a line of text */
	private void countLetterFrequencies(String line /*, frequencyTable*/) {
		// TODO
	}

	/* Displays the frequency table */
	private void printFrequencyTable(/*frequencyTable*/) {
		// TODO
	}
}
