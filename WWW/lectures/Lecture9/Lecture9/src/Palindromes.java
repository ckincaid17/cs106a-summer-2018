/*
 * File: Palindromes.java
 * -------------------------
 * This program prints out whether the entered text is a palindrome
 * or not (same forwards and backwards).
 */

import acm.program.*;

public class Palindromes extends ConsoleProgram {
	
	public void run() {
		String line = readLine("Enter string: ");
		if (isPalindrome(line)) {
			println("That is a palindrome!");
		} else {
			println("That is not a palindrome.");
		}
	}
	
	// Returns true if str is a palindrome, false otherwise.
	private boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; i++) {
			char leftChar = str.charAt(i);
			int rightIndex = str.length() - i - 1;
			char rightChar = str.charAt(rightIndex);
			if (leftChar != rightChar) {
				return false;
			}
		}
		return true;
	}
	
	// Returns true if str is a palindrome, false otherwise.
	private boolean simplePalindrome(String str) {
		return str.equals(reverseString(str));
	}
	
	// Returns a reversed version of the string str
	private String reverseString(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++ ) {
			result = str.charAt(i) + result;
		}
		return result;
	}
}