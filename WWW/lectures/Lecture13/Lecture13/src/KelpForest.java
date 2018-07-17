/*
 * File: KelpForest.java
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

public class KelpForest extends GraphicsProgram {
	
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
		for (int i = 0; i < N_FRONDS; i++) {
			dropOneFrond();
		}
		// Do this after the animation so the background doesn't flicker
		setBackground(SEA_COLOR);
	}
	
	/*
	 * Simulates dropping one frond until it hits another, or hits the
	 * bottom of the screen.
	 */
	private void dropOneFrond() {
		GOval frond = makeFrond();
		add(frond);
		
		/* Move the frond until it hits something. */
		while (!hasHitBottom(frond) && !hasHitSomethingElse(frond)) {
			frond.move(0, Y_VELOCITY);
			pause(PAUSE_TIME);
		}
	}
	
	/*
	 * Creates and returns a new frond with a random
	 * on-screen X and a Y of 0.
	 */
	private GOval makeFrond() {
		int xMax = getWidth() - FROND_SIZE;
		int randomX = RandomGenerator.getInstance().nextInt(0, xMax);
		GOval newFrond = new GOval(randomX, 0, FROND_SIZE, FROND_SIZE);
		newFrond.setFilled(true);
		newFrond.setColor(KELP_COLOR);
		return newFrond;
	}
	
	/*
	 * Given a frond, returns whether that frond has hit the
	 * bottom of the screen.
	 */
	private boolean hasHitBottom(GOval frond) {
		double bottomY = frond.getY() + frond.getHeight();
		return bottomY >= getHeight();
	}
	
	/*
	 * Given a frond, returns whether that frond has collided
	 * with any other objects on screen.
	 */
	private boolean hasHitSomethingElse(GOval frond) {
		double checkX = frond.getX() + frond.getWidth() / 2.0;
		double checkY = frond.getY() + frond.getHeight();
		GObject hit = getElementAt(checkX, checkY);
		return hit != null;
	}
}