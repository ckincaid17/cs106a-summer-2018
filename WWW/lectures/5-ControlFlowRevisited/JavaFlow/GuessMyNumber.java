/*
 * File: GuessMyNumber.java
 * --------------------
 * Has the user try and guess a number between 0 and 100.
 * Tells the user if their guess was too high or too low.
 */

import acm.program.*;

public class GuessMyNumber extends ConsoleProgram {

	public void run() {		
		int secretNumber = getHeight() % 100;
		println("I am thinking of a number between 0 and 99...");
		// gets a first guess...
		int guess = readInt("Enter a guess: ");
		while(guess < 0 || guess > 99) {
			println("WOOOTTT??!");
			guess = readInt("New guess: ");
		}

		while(secretNumber != guess) {

			// report if the guess was too high or too low
			if(guess < secretNumber) {
				println("Your guess was too low");
			} else {
				println("Your guess was too high");
			}

			// ask for a new guess
			guess = readInt("Enter a guess: ");
			while(guess < 0 || guess > 99) {
				println("WOOOTTT??!");
				guess = readInt("New guess: ");
			}
		}

		println("Congrats the number was: " + secretNumber);

	}

















	/**
	 * Method: Init
	 * ------------
	 * This is some special code I added so that the font in
	 * the programs is larger. You can ignore it, and you don't
	 * need an init in your programs!
	 */
	public void init() {
		// this makes the font viewable in lecture
		setFont("Courier-24");
	}

}
