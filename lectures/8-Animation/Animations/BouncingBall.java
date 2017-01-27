/*
 * File: GravityBall.java
 * -----------------------------
 * Has a ball bounce around the screen and applies a downward
 * force on the ball (gravity).
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BouncingBall extends GraphicsProgram {

	/* How many ms to pause between "heartbeats" */
	private static final int DELAY = 2;
	/* Initial speed in the x direction */
	private static final double INITIAL_VY = 2;
	/* Initial speed in the y direction */
	private static final double INITIAL_VX = 2;
	/* The size of the ball (in pixels) */
	private static final int BALL_RADIUS = 15;
	/* The color of the ball */
	private static final Color BALL_COLOR = Color.BLUE;

	public void run() {	
		// setup
		while(true) {
			// update world
			
			// pause
			pause(DELAY);
		}
	}
}
