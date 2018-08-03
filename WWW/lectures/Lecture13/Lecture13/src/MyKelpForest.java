/*
 * File: MyKelpForest.java
 * -----------------
 * A program that grows a kelp forest by dropping kelp fronds on the sea floor.
 * (This is not a biologically accurate simulation of how kelp forests grow,
 *  but Stanford has a great Kelp Forest Ecology class if you're interested!)
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class MyKelpForest extends GraphicsProgram {
	
	/* Number of fronds to drop */
	private static final int N_FRONDS = 500;
	
	/* The delay between frames. */
	private static final double PAUSE_TIME = 0.1;
	
	/* How fast the fronds fall. */
	private static final double Y_VELOCITY = 5;
	
	/* The color of a frond. */
	private static final Color KELP_COLOR = new Color(34,139,34);
	
	/* The color of the sea. */
	private static final Color SEA_COLOR = Color.CYAN;
	
	/* The diameter of a frond. */
	private static final int FROND_SIZE = 20;

	
	public void run() {
		// TODO
	}
}