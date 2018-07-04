/*
 * File: Boxes.java
 * ---------------------
 * This program prints out "star boxes" of various different sizes
 * using a "drawBox" method that can print a star box of a given width and
 * height.
 */

import acm.program.*;

public class Boxes extends ConsoleProgram {
	public void run() {
		drawBox(10, 5);
		drawBox(5, 4);
	}

	/*
	 * This method draws a box perimeter of asterisks, the
	 * size of which is specified by the width and height parameters.
	 */
	private void drawBox(int width, int height) {  
		line(width);                          
		for (int line = 0; line < height - 2; line++) {
			boxSide(width);
		}
		line(width);
	}

	/*
	 * This method draws a line of asterisks that is
	 * 'count' long.
	 */
	private void line(int count) {            
		for (int i = 0; i < count; i++) {   
			print("*");                      
		}
		println();
	}

	/*
	 * This method draws a line that is 'width'
	 * spaces long, and makes the first and last
	 * characters in that line asterisks.
	 */
	private void boxSide(int width) {
		print("*");
		for (int i = 0; i < width - 2; i++) {
			print(" ");
		}
		println("*");
	}
}

