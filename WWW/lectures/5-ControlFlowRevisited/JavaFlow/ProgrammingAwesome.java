/*
 * File: ProgrammingAwesome.java
 * --------------------
 * Draws some funky shapes.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgrammingAwesome extends GraphicsProgram {	
	
	
	public void run() {
		// half the height of the screen.
		double centerY = getHeight()/2;
		
		// make and add a blue square
		GRect blueSquare = new GRect(70, 70); // width and height are 70
		blueSquare.setColor(Color.BLUE); // make the square blue
		blueSquare.setFilled(true); // fill the square
		add(blueSquare, 80, 90); // add the square to the screen
		
		// make and add a purple background rect
		GRect blackRect = new GRect(200, 180);
		blackRect.setColor(Color.BLACK);
		blackRect.setFilled(true);
		add(blackRect, 120, centerY);
		
		// make and add a red oval in the exact same spot as the purple
		// rect above..
		GOval redOval = new GOval(200, 180);
		redOval.setColor(Color.RED);
		redOval.setFilled(true);
		add(redOval, 120, centerY);
		
		
		// add a long yellow rectangle (ohh yea aesthetic)
		GRect nick = new GRect(60, 300);
		nick.setColor(Color.YELLOW);
		nick.setFilled(true);
		add(nick, 550, 10);
		
		// add a graphical rendering of text
		GLabel label = new GLabel("Programming is Awesome!");
		label.setFont("Courier-52");
		add(label, 10, centerY);
		
		// add an underline for the text
		GLine l = new GLine(10, centerY, 10 + label.getWidth(), centerY);
		add(l);
		
		// this object is never added
		GRect dudeWheresMyRect = new GRect(600, 600);
		dudeWheresMyRect.setFilled(true);
		
		
	}

	
}
