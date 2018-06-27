/*
 * File: StepUp.java
 * ---------------------
 * This is our first Karel program!  Karel starts at (1, 1),
 * picks up a beeper in front of it and moves it to the
 * 2nd row, 5th column, while avoiding all walls.
 */

import stanford.karel.*;

public class StepUp extends SuperKarel {
	public void run() {
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		move();
		move();
		putBeeper();
		move();
	}
}

