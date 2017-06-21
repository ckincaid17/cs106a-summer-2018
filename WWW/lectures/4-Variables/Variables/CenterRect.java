/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CenterRect extends GraphicsProgram {	
	
	private static final int WIDTH = 350;
	private static final int HEIGHT = 270;
	
	public void run() {
		GRect centered = new GRect(WIDTH, HEIGHT);
		centered.setColor(Color.BLUE);
		centered.setFilled(true);
		double x = (getWidth() - WIDTH)/2;
		double y = (getHeight() - HEIGHT)/2;
		add(centered, x, y);
	}

	
}
