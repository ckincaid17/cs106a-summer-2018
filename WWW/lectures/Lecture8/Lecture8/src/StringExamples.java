/*
 * File: StringExamples.java
 * -------------------------
 * This program shows some examples of using Strings in Java.
 */

import acm.program.*;

public class StringExamples extends ConsoleProgram {
	
	public void run() {
		String line = readLine("Enter string: ");
		println("\"" + line + "\" has " + countUpperCase(line) + 
				" uppercase characters.");
		println("\"" + line + "\" reversed is " + reverseString(line));
		println("Is \"" + line + "\" a palindrome? " + simplePalindrome(line));
	}
	
	// Returns the number of uppercase characters in string str.
	private int countUpperCase(String str) {
		int uppercaseCount = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				uppercaseCount++;
			}
		}
		return uppercaseCount;
	}

	// Returns a reversed version of the string Str
	private String reverseString(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++ ) {
			result = str.charAt(i) + result;
		}
		return result;
	}

	// Returns true if str is a palidrome, false otherwise.
	private boolean simplePalindrome(String str) {
		return str.equals(reverseString(str));
	}


	// Returns true if str is a palidrome, false otherwise.
	private boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != 
					str.charAt(str.length() - (i + 1))) {
				return false;
			}
		}
		return true;
	}	
}
