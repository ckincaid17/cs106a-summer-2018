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

public class SimpleRect extends GraphicsProgram {	
	
	public void run() {
		// makes a rectangle
		GRect myRect = new GRect(350, 270);
		myRect.setColor(Color.BLUE);
		myRect.setFilled(true);
		add(myRect, 40, 90);
		
		// makes an oval
		GOval myOval = new GOval(350, 270);
		myOval.setColor(Color.RED);
		myOval.setFilled(true);
		add(myOval, 70, 120);
	}

	
}
