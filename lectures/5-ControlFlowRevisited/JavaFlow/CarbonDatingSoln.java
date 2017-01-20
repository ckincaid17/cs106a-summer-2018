/*
 * File: CarbonDatingSoln.java
 * --------------------
 * This program calculates the age of a sample based on how much
 * Carbon-14 is remaining. See:
 * http://hyperphysics.phy-astr.gsu.edu/hbase/Nuclear/cardat.html
 */

import acm.program.*;

public class CarbonDatingSoln extends ConsoleProgram {

	private static final double LIVING_C14 = 13.6;
	private static final int HALF_LIFE = 5730;

	public void run() {
		// print some introduction information
		println("Radioactive molecule = C14");
		println("Halflife = " + HALF_LIFE + " years");
		println("C14 in living organisms = " + LIVING_C14 + " dpm");
		println("-----");
		println(""); // adds an extra new-line

		// read the amount of C14 from the user
		double amount = readDouble("Amount of C14 in your sample: ");

		// use the half life formula to calculate the age
		double age = Math.log(amount / LIVING_C14) / Math.log(0.5) * HALF_LIFE;
		// this is called a cast. It forces the expression to become an int
		int roundedAge = (int)(age / 100) * 100;
		println("Your sample is: " + roundedAge +" years old.");

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

