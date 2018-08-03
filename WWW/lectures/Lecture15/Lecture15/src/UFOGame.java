/*
 * File: UfoGame.java
 * ------------------
 * This program plays a game where the user tries to
 * shoot a UFO before the UFO "lands".
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class UFOGame extends GraphicsProgram {

	/* Speed of UFO */
	private static final int UFO_SPEED = 7;

	/* Size and speed of bullets */
	private static final int BULLET_SPEED = 10;
	private static final int BULLET_DIAM = 5;
	
	/* Animation cycle delay */
	private static final int DELAY = 10;
	
	/* private instance variables */
	private GImage ufo;
	private GOval bullet;
	private boolean ufoToLeft; 	// when true, UFO is moving to left
	
	
	public void run() {
		setup();
		while (!gameOver()) {
			moveUFO();
			moveBullet();
			checkForCollisions();
			pause(DELAY);
		}
	}

	/* set up initial UFO and initial game state */
	private void setup() {
		// UFO starts at top right
		ufo = new GImage("res/ufo.png", getWidth(), 0);
		add(ufo); 
		ufoToLeft = true;
	}

	/* determines if game is over -- true if either
	 * the UFO is destroyed or if the UFO lands
	 */
	private boolean gameOver() {
		return (ufo == null) || (ufo.getY() >= getHeight() - ufo.getHeight());
	}

	/* when mouse is clicked create bullet, unless a bullet
	 * already exists.
	 */
	public void mouseClicked(MouseEvent e) {
		if (bullet == null) {
			double bulletX = (getWidth() - BULLET_DIAM) / 2.0;
			double bulletY = getHeight() - BULLET_DIAM;
			bullet = new GOval(bulletX, bulletY, BULLET_DIAM,BULLET_DIAM);
			bullet.setFilled(true);
			bullet.setColor(Color.RED);
			add(bullet);
		}
	}

	/* moves UFO, if UFO has moved to edge of screen, moves
	 * UFO down and changes UFO direction.
	 */
	private void moveUFO() {
		if (ufoToLeft) {
			ufo.move(-UFO_SPEED, 0);
			if (ufo.getX() <= 0) {
				ufoToLeft = false;
				ufo.move(0, ufo.getHeight());
			}
		} else {
			ufo.move(UFO_SPEED, 0);
			if (ufo.getX() >= getWidth() - ufo.getWidth()) {
				ufoToLeft = true;
				ufo.move(0, ufo.getHeight());
			}
		}
	}

	/* if there is a bullet, moves it by BULLET_SPPED */
	private void moveBullet() {
		if (bullet != null) {
			bullet.move(0, -BULLET_SPEED);
		}
	}

	/* checks for bullet interaction with the world
	 * (either colliding with the UFO or moving offscreen)
	 */
	private void checkForCollisions() {
		checkCollideWithUFO();
		checkMoveOffScreen();
	}

	/* checks to see if UFO and bullet collide, if so
	 * bullet and UFO are removed and both variables are
	 * set to null.
	 */
	private void checkCollideWithUFO() {
		if (bullet != null) {
			GObject collObj = getElementAt(bullet.getX(), bullet.getY());
			if (collObj == ufo) {
				remove(ufo);
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}

	/* determines if bullet has moved of screen,
	 * if it has, removes bullet, sets variable to null
	 */
	private void checkMoveOffScreen() {
		if (bullet != null) {
			if (bullet.getY() <= -BULLET_DIAM) {
				remove(bullet);
				bullet = null;
			}
		}
	}
}