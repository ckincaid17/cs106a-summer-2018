/*
 * File: DeleteDuplicates.java
 * ---------------------
 * This class contains code for both implementations of deleteDuplicates
 * from the lecture slides, as well as a tiny bit of code to test the
 * functionality of those methods.
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import acm.program.*;

public class DeleteDuplicates extends ConsoleProgram {
	
	private static final String[] DUPLICATES_LIST = {"be", "be", "is", "not", "or", "question",
													 "that", "the", "to", "to"};
	private static final String[] UNIQUE_LIST = {"be", "is", "not", "or", "question",
			 									 "that", "the", "to"};
	
	public void run() {
		// Turn the static constant lists above into ArrayLists that can be modified
		ArrayList<String> duplicatesList = new ArrayList<String>(Arrays.asList(DUPLICATES_LIST));
		ArrayList<String> duplicatesReverseList = new ArrayList<String>(Arrays.asList(DUPLICATES_LIST));
		ArrayList<String> uniqueList = new ArrayList<String>(Arrays.asList(UNIQUE_LIST));
		
		deleteDuplicates(duplicatesList);
		if (duplicatesList.equals(uniqueList)) {
			println("deleteDuplicates works properly!");
		} else {
			println("deleteDuplicates has bugs!", Color.RED);
		}
		
		deleteDuplicatesReverse(duplicatesReverseList);
		if (duplicatesReverseList.equals(uniqueList)) {
			println("deleteDuplicatesReverse works properly!");
		} else {
			println("deleteDuplicatesReverse has bugs!", Color.RED);
		}
	}
	
	/*
	 * Iterates through the provided ArrayList, removes any duplicate
	 * String so that only unique elements remain.
	 * Assumes that the list is sorted, that is, equal strings have
	 * adjacent indices.
	 */
	private void deleteDuplicates(ArrayList<String> list) {
	   for (int i = 0; i < list.size() - 1; i++) {
	       String elem = list.get(i);
	       // If two adjacent elements are equal
	       if (list.get(i + 1).equals(elem)) {
	           list.remove(i);
	           i--;
	       }
	   }
	}
	
	/*
	 * Does the same thing as deleteDuplicates, but iterates through
	 * the list in reverse order from back to front.
	 */
	private void deleteDuplicatesReverse(ArrayList<String> list) {
	   for (int i = list.size() - 1; i > 0; i--) {
	       String elem = list.get(i);
	       // If two adjacent elements are equal
	       if (list.get(i - 1).equals(elem)) {
	           list.remove(i);
	       }
	   }
	}
}

