/*
 * File: SplatterPaintCanvas.java
 * ------------------------------
 * This class is a GCanvas subclass that
 * can draw paint splatters of different sizes
 * and colors, and randomize the colors of
 * splatters already onscreen.
 */
import acm.graphics.*;
import java.awt.*;
import java.util.*;
import acm.util.*;

public class SplatterPaintCanvas extends GCanvas {
	// A list of all onscreen splatters
	ArrayList<GOval> splatters;
	
	public SplatterPaintCanvas() {
		splatters = new ArrayList<>();
	}
	
	/* This method adds a new splatter with the given diameter and color
	 * at a random location onscreen such that it is fully visible.
	 */
	public void addSplatter(int diameter, Color color) {
		int x = RandomGenerator.getInstance().nextInt(0, getWidth() - diameter);
		int y = RandomGenerator.getInstance().nextInt(0, getHeight() - diameter);
		GOval splatter = new GOval(x, y, diameter, diameter);
		splatter.setFilled(true);
		splatter.setColor(color);
		add(splatter);
		splatters.add(splatter);
	}
	
	// This method randomly changes the color of all onscreen paint splatters.
	public void randomizeColors() {
		for (GOval splatter : splatters) {
			Color newColor = RandomGenerator.getInstance().nextColor();
			splatter.setColor(newColor);
		}
	}
}
