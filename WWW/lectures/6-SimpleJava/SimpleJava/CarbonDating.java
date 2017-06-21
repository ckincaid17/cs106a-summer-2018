/*
 * File: CarbonDating.java
 * --------------------
 * This program calculates the age of a sample based on how much
 * Carbon-14 is remaining. See:
 * http://hyperphysics.phy-astr.gsu.edu/hbase/Nuclear/cardat.html
 */
import acm.program.*;

public class CarbonDating extends ConsoleProgram {

	public void run() {
		// used to make the font visible in lecture...
		setFont("Courier-24");

		// get amount of c14 in the sample
		double amount = readDouble("How much c14 is in your sample? ");
		
		// calculate the age of the sample
		double age = Math.log(amount / 13.6) / Math.log(0.5) * 5730;
		
		// print the result
		println("Your sample is " + age + " years old");
	}
}

