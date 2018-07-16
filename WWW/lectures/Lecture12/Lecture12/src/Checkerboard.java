/*
 * File: Checkerboard.java
 * -----------------
 * A program that draws a checkerboard with
 * alternating black and white tiles.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Checkerboard extends GraphicsProgram {	

	/* The length of a side of a single square on the board */
	private static final int SIDE_LENGTH = 50;
	
	/* Number of rows */
	private static final int NROWS = 8;
	
	/* Number of cols */
	private static final int NCOLS = 8;

	public void run() {
		for (int row = 0; row < NROWS; row++) {
			for (int col = 0; col < NCOLS; col++) {
				double x = col * SIDE_LENGTH;
				double y = row * SIDE_LENGTH;
				GRect square = new GRect(x, y, SIDE_LENGTH, SIDE_LENGTH);
				// In this line we evaluate a boolean which we pass
				// to setFilled. True if the row + col is odd
				square.setFilled((row + col) % 2 == 0);
				add(square);
			}
		}
	}
}
