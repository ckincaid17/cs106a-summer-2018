/* 
 * File: HurdleJumper.java
 * -----------------------
 * Karel runs a set of hurdles that are 9 avenues long.
 * Hurdles are of arbitrary height and placement.
 */

import stanford.karel.*;

public class HurdleJumper extends SuperKarel {
	
	/*
	 * To run a race that is 9 avenues long,
	 * we need to move forward (possibly
	 * jumping hurdles along the way) 8 times.
	 */
	public void run() {
		for (int i = 0; i < 8; i++) {
			jumpHurdle();
		}
	}
	
	/*
	 * Karel jumps over one hurdle of arbitrary
	 * 						(possibly 0) height.
	 * Pre-condition:  Karel is in the first street facing
	 * 				   east, possibly blocked by a wall.
	 * Post-condition: Karel is facing east, one avenue
	 * 				   ahead of where they started.
	 */
	private void jumpHurdle() {
		ascendHurdle();
		move();
		descendHurdle();
	}
	
	/*
	 * Karel climbs up the side of a hurdle.
	 * Pre-condition:  Karel is in the first street facing
	 * 				   east, possibly blocked by a wall.
	 * Post-condition: Karel is facing east, not blocked by
	 * 				   a wall.
	 */
	private void ascendHurdle() {
		turnLeft();
		while (rightIsBlocked()) {
			move();
		}
		turnRight();
	}
	
	/*
	 * Karel climbs down the side of a hurdle.
	 * Pre-condition: Karel is facing east in an
	 * 				  arbitrary street
	 * Post-condition: Karel is facing east in the
	 * 				   first street.
	 */
	private void descendHurdle() {
		turnRight();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}
}
