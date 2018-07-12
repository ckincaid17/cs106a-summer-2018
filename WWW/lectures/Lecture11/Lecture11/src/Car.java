/*
 * File: Car.java
 * --------------
 * A graphics program that draws a car with a body, 2 wheels,
 * and a windshield, on a yellow background.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Car extends GraphicsProgram {
	public void run() {
		setBackground(Color.YELLOW);

		GRect body = new GRect(10, 30, 100, 50);
		body.setFilled(true);
		body.setFillColor(Color.BLUE);
		add(body);
		
		// Add the wheel *after* the body so it appears on top
		GOval wheel1 = new GOval(20, 70, 20, 20);
		wheel1.setFilled(true);
		wheel1.setFillColor(Color.RED);
		add(wheel1);

		// We can't add the same wheel 2x; we need to make a new one
		GOval wheel2 = new GOval(80, 70, 20, 20);
		wheel2.setFilled(true);
		wheel2.setFillColor(Color.RED);
		add(wheel2);

		GRect windshield = new GRect(80, 40, 30, 20);
		windshield.setFilled(true);
		windshield.setFillColor(Color.CYAN);
		add(windshield);
	}
}
