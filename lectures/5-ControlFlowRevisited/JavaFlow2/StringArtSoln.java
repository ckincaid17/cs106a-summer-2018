/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.graphics.*;
import acm.program.*;

public class StringArtSoln extends GraphicsProgram {
	
	private static final int NUM_STRINGS = 10;
	
	public static final int APPLICATION_WIDTH = 600;
	public static final int APPLICATION_HEIGHT = 600;
	
	public void run() {
		double gap = getHeight() / NUM_STRINGS;
		for(int i = 0; i < NUM_STRINGS; i++) {
			double delta = i * gap;
			GLine l = new GLine(0, delta, delta, getHeight());
			double dX = delta;
			double dY = getHeight() - delta;
			double length = Math.sqrt(dX * dX + dY * dY);
			println(length);
			add(l);
		}
	}

}
