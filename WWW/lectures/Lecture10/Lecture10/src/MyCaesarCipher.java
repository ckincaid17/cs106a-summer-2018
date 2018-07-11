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
		do {
			println();
			int key = readInt("Enter encryption key: ");
			String plaintext = readLine("Plaintext:  ");

			String ciphertext = encryptCaesar(plaintext, key);
			println("Ciphertext: " + ciphertext);

			String decrypted = encryptCaesar(ciphertext, -key);
			println("Decrypted text: " + decrypted);
		} while (readBoolean("Encrypt another message?", "y", "n"));
		println();
		println("See you later!");
	}

	// TODO: write encryptCaesar method
}