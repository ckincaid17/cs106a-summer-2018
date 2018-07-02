/*
 * File: BuggyRoomba.java
 * -----------------------
 * An alternative implementation of Roomba, but with a bug!
 */

import stanford.karel.*;

public class BuggyRoomba extends SuperKarel {

	// Karel cleans up a field of beepers, one row at a time.
	public void run() {
		sweep();
		int i = 0;
		while (leftIsClear()) {
			i = i + 1;
			moveUpRight();
			sweep();
			if (rightIsClear()) {
				moveUpLeft();
				sweep();
			}
		}
	}
	
	/* 
	 * Karel cleans up all beepers in a single row.
	 * Pre-condition: Karel is at the beginning of a row.
	 * Post-condition: Karel is at the end of the
	 * 				   same row, but has cleaned up all
	 * 				   beepers in that row.
	 */
	private void sweep() {
		safePickBeeper();
		while (frontIsClear()) {
			move();
			safePickBeeper();
		}
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
	 * Karel moves up on the right to the start of 
	 * the next row.
	 * Pre-condition: Karel is facing east at the
	 * 				  end of a row.
	 * Post-condition: Karel is facing west at the
	 * 				   beginning of the next row. 
	 */
	private void moveUpRight() {
		turnLeft();
		move();
		turnLeft();
	}
	
	/*
	 * Karel moves up on the left to the start of 
	 * the next row.
	 * Pre-condition: Karel is facing west at the
	 * 				  end of a row.
	 * Post-condition: Karel is facing east at the
	 * 				   beginning of the next row. 
	 */
	private void moveUpLeft() {
		turnRight();
		move();
		turnRight();
	}
}
