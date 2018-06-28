/*
 * File: Roomba.java
 * -----------------------
 * Karel starts at (1, 1) facing east and cleans up any
 * beepers scattered throughout his world.
 */

import stanford.karel.*;

public class Roomba extends SuperKarel {

	// Karel cleans up a field of beepers, one row at a time.
	public void run() {
		sweep();
		while (leftIsClear()) {
			moveUp();
			sweep();
		}
	}
	
	/* 
	 * Karel cleans up all beepers in a single row.
	 * Pre-condition: Karel is at the beginning of a row.
	 * Post-condition: Karel is at the beginning of the
	 * 				   same row, but has cleaned up all
	 * 				   beepers in that row.
	 */
	private void sweep() {
		safePickBeeper();
		while (frontIsClear()) {
			move();
			safePickBeeper();
		}
		returnHome();
	}
	
	/*
	 * Karel returns to the start of the row it is in.
	 * Pre-condition: Karel is facing east at the end of a row.
	 * Post-condition: Karel is facing east at the beginning
	 * 				   of that row.
	 */
	private void returnHome() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	/*
	 * Karel safely picks up a beeper only if there is one
	 * on this corner.
	 * Pre-condition: None
	 * Post-condition: Karel has picked up a beeper on the
	 * 				   current square if one was present.
	 */
	private void safePickBeeper() {
		if (beepersPresent()) {
			pickBeeper();
		}
	}

	/* 
	 * Karel moves up to the start of the next row.
	 * Pre-condition: Karel is facing east at the beginning
	 * 				  of a row.
	 * Post-condition: Karel is facing east at the start of
	 * 				   the next row above it.
	 */
	private void moveUp() {
		turnLeft();
		move();
		turnRight();
	}
}
