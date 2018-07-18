/*
 * File: GooglyEyes.java
 * -----------------
 * A program that draws a face whose pupils follow the
 * user's mouse as it moves up and down.
 * 
 * This program requires instance variables to store the
 * eye pupils so that we can move them in the mouseMoved method.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class GooglyEyes extends GraphicsProgram {
	
	private static final int EYE_SIZE = 100;
	private static final int PUPIL_SIZE = 20;
	
	private GOval leftPupil;
	private GOval rightPupil;

	public void run() {
		setBackground(Color.cyan);
		leftPupil = drawEye(getWidth() / 2.0 - EYE_SIZE);
		rightPupil = drawEye(getWidth() / 2.0);
	}
	
	/* Draws a single eye centered vertically, with the upper-left located at xCoordinate. */
	private GOval drawEye(double xCoordinate) {
		double yCoordinate = getHeight() / 2.0 - EYE_SIZE / 2.0;
		GOval eye = new GOval(xCoordinate, yCoordinate, EYE_SIZE, EYE_SIZE);
		eye.setFilled(true);
		eye.setFillColor(Color.white);
		add(eye);
		
		GOval pupil = makePupil(xCoordinate);
		add(pupil);
		return pupil;
	}
	
	/* Returns a single pupil, inside the eye located at eyeXCoordinate. */
	private GOval makePupil(double eyeXCoordinate) {
		double xCoordinate = eyeXCoordinate + EYE_SIZE / 2.0 - PUPIL_SIZE / 2.0;
		double yCoordinate = getHeight() / 2.0 - EYE_SIZE / 2.0;
		GOval pupil = new GOval(xCoordinate, yCoordinate, PUPIL_SIZE, PUPIL_SIZE);
		pupil.setFilled(true);
		pupil.setColor(Color.black);
		return pupil;
	}
	
	/* Called whenever the mouse is moved. */
	public void mouseMoved(MouseEvent e) {
		// Figure out the x coordinates of the pupils
		double leftPupilX = getWidth() / 2.0 - EYE_SIZE / 2.0 - PUPIL_SIZE / 2.0;
		double rightPupilX = leftPupilX + EYE_SIZE;
		
		// Figure out the y coordinates of the pupils
		double pupilsY;
		if (e.getY() < getHeight() / 2.0 - EYE_SIZE / 2.0) {
			pupilsY = getHeight() / 2.0 - EYE_SIZE / 2.0;
		} else if (e.getY() > getHeight() / 2.0 + EYE_SIZE / 2.0) {
			pupilsY = getHeight() / 2.0 + EYE_SIZE / 2.0 - PUPIL_SIZE;
		} else {
			pupilsY = getHeight() / 2.0 - PUPIL_SIZE / 2.0;
		}
		
		leftPupil.setLocation(leftPupilX, pupilsY);
		rightPupil.setLocation(rightPupilX, pupilsY);
	}
}
