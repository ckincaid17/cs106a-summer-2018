/*
 * File: MyPalindromes.java
 * -------------------------
 * This program prints out whether the entered text is a palindrome
 * or not (same forwards and backwards).
 */

import acm.program.*;

public class MyPalindromes extends ConsoleProgram {
	
	public void run() {
		String line = readLine("Enter string: ");
		if (isPalindrome(line)) {
			println("That is a palindrome!");
		} else {
			println("That is not a palindrome.");
		}
	}
	
	// TODO write isPalindrome method
}