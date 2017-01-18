/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class CarbonDating extends ConsoleProgram {

	// measured in years
	private static final int HALF_LIFE = 5730;
	// measured in dpm per gram
	private static final double LIVING_C14 = 13.6;

	public void run() {
		// print some introduction information
		println("Radioactive molecule = C14");
		println("Halflife = " + HALF_LIFE + " years");
		println("C14 in living organisms = " + LIVING_C14 + " dpm");
		println("-----");
		println(""); // adds an extra new-line

		while(true) {
			// calculate age of sample
			double left = readDouble("Amount of C14 in your sample: ");
			double age = Math.log(left / LIVING_C14) / Math.log(0.5) * HALF_LIFE;
			age = Math.round(age);
			println("Age of your sample = " + age);
			
			println("");
		}

	}













	/**
	 * Method: Init
	 * ------------
	 * This is some special code I added so that the font in
	 * the programs is larger. You can ignore it, and you don't
	 * need an init in your programs!
	 */
	public void init() {
		// used to make the font visible in lecture...
		setFont("Courier-24");
	}
}

