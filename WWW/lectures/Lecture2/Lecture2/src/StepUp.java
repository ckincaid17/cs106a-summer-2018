/*
 * File: StepUp.java
 * ---------------------
 * This is our first Karel program!  Karel starts at (1, 1),
 * picks up a beeper in front of it, and moves it to the corner of
 * 2nd street and 5th avenue, while avoiding all walls.
 */

import stanford.karel.*;

public class StepUp extends Karel {
	public void run() {
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		move();
		putBeeper();
		move();
	}
	
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}

