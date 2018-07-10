/*
 * File: Palindromes.java
 * -------------------------
 * This program prints out whether the entered text is a palindrome
 * or not (same forwards and backwards).
 */

import acm.program.*;

public class ReverseString extends ConsoleProgram {
	
	public void run() {
		println("This program reverses a string.");
		String str = readLine("Enter string: ");
		String rev = reverseString(str);
		println(str + " spelled backwards is " + rev + ".");
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