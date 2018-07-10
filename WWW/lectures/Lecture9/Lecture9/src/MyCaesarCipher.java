/*
 * File: MyCaesarCipher.java
 * -----------------------
 * This program translates a line of text into its Caesar cipher
 * form, and then decrypts it.
 */

import acm.program.*;

public class MyCaesarCipher extends ConsoleProgram {

	public void run() {
		println("This program uses a Caesar cipher for encryption.");
		int key = readInt("Enter encryption key: ");
		String plaintext = readLine("Plaintext:  ");
		
		String ciphertext = encryptCaesar(plaintext, key);
		println("Ciphertext: " + ciphertext);
		
		// TODO: figure out how to decrypt (hint: write encryptCaesar first)
	}
	
	// TODO: write encryptCaesar method
}
