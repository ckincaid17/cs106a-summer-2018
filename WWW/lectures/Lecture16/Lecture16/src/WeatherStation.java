/* File: WeatherStation
 * --------------------
 * This program shows how we can use arrays to do
 * more complex data manipulation.  It prompts the user
 * for a variable number of daily temperatures, and then prints
 * out all the entered temperatures along with statistics such as
 * the average, number of days above average,
 * and the hottest and coldest days.
 * --------------------
 */

import acm.program.*;
import java.util.*;

public class WeatherStation extends ConsoleProgram {
	public void run() {
		// 1) Read in temperatures from the user
		int[] temps = readTemperatures();
		println("Temperatures: " + Arrays.toString(temps));
		println();
		
		// 2) Calculate statistics with average
		double average = computeAverage(temps);
		println("Average temp = " + average);
		int aboveAverageCount = countAboveAverage(temps, average);
		println(aboveAverageCount + " days above average.");

		// 3) Print out two coldest and two hottest days
		Arrays.sort(temps);  // Sorts "in place"!
		println("Two coldest days: " + temps[0] + ", " + temps[1]);
		int hottest = temps[temps.length - 1];
		int nextHottest = temps[temps.length - 2];
		println("Two hottest days: " + hottest + ", " + nextHottest);		
	}
	
	/* Reads in daily temperatures from the user.
	 * Returns an array of all entered temperatures.
	 */
	private int[] readTemperatures() {
	    int days = readInt("How many days' temperatures? ");
	    int[] temps = new int[days];
	    for (int i = 0; i < days; i++) {
	        temps[i] = readInt("Day " + (i + 1) + "'s high temp: ");
	    }
	    return temps;
	}

	/* Returns the average value in the temperatures array.
	 */
	private double computeAverage(int[] temps) {
	    double sum = 0.0;
	    for (int i = 0; i < temps.length; i++) {
	        sum += temps[i];
	    }
	    return sum / temps.length;
	}

	/* Returns the number of temperatures above the given average.
	 */
	private int countAboveAverage(int[] temps, double average) {
	    int count = 0;
	    for (int i = 0; i < temps.length; i++) {
	        if (temps[i] > average) {
	            count++;
	        }
	    }
	    return count;
	}
}
