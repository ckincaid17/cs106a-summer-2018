/*
 * File: GuessMyNumber.java
 * ---------------------
 * This program is a game that prompts the user to guess my secret
 * number, and prints out hints each time until they guess correctly.
 */

import acm.program.*;

public class GuessMyNumber extends ConsoleProgram {

	private static final int SECRET_NUMBER = 42;

	public void run() {
		println("I am thinking of a number between 0 and 99...");
		int guess = readInt("Enter your guess: ");

		while (guess != SECRET_NUMBER) {
			if (guess < SECRET_NUMBER) {
				println("Your guess is too low.");
			} else {
				println("Your guess is too high.");
			}

			guess = readInt("Enter your guess: ");
		}

		println("You got it!  The secret number was " + SECRET_NUMBER);
	}
}
