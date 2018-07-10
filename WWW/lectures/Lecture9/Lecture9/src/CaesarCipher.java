/*
 * File: CaesarCipher.java
 * -----------------------
 * This program translates a line of text into its Caesar cipher
 * form, and then decrypts it.
 */

import acm.program.*;

public class CaesarCipher extends ConsoleProgram {
	
	private static int ALPHABET_LENGTH = 26;

	public void run() {
		println("This program uses a Caesar cipher for encryption.");
		int key = readInt("Enter encryption key: ");
		String plaintext = readLine("Plaintext:  ");
		
		String ciphertext = encryptCaesar(plaintext, key);
		println("Ciphertext: " + ciphertext);
		
		String decrypted = encryptCaesar(ciphertext, -key);
		println("Decrypted text: " + decrypted);
	}

	/*
	 * Encrypts a string by adding the value of key to each letter.
	 */
	private String encryptCaesar(String str, int key) {
		// Make sure that the value by which we shift is positive.
		if (key < 0) {
			// Note that -(n - 1) <= key % n <= 0 if key is negative.
			key = ALPHABET_LENGTH + (key % ALPHABET_LENGTH);
		}
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = encryptCharacter(str.charAt(i), key);
			result += ch;
		}
		return result;
	}

	/*
	 * Encrypts a single character using the key given. This
	 * method assumes the key is non-negative. Non-letter
	 * characters are returned unchanged.
	 */
	private char encryptCharacter(char ch, int key) {
		if (Character.isLetter(ch)) {
			ch = (char)('A' + 
					(Character.toUpperCase(ch) - 'A' + key) % ALPHABET_LENGTH);
		}
		return ch;
	}
}
