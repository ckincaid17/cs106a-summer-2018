/*
 * File: FunWithStrings.java
 * -------------------------
 * This program shows some examples of using Strings in Java.
 */

import acm.program.*;

public class FunWithStrings extends ConsoleProgram {
	
	public void run() {
		String line = readLine("Enter string: ");
		println("\"" + line + "\" has " + countUpperCase(line) + 
				" uppercase characters.");
	}
	
	// Returns the number of uppercase characters in string str.
	private int countUpperCase(String str) {
		return 0;
	}
}