/* 
 * File: HurdleJumper.java
 * -----------------------
 * Karel runs a set of hurdles that are 9 avenues long.
 * Hurdles are of arbitrary height and placement.
 */

import stanford.karel.*;

public class HurdleJumper extends SuperKarel {
	
	/*
	 * To run a race that is 9 avenues long, we need
	 * to move forward or jump hurdles 8 times.
	 */
	public void run() {
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			} else {
				jumpHurdle();
			}
		}
	}


	/*
	 * Karel jumps over one hurdle of arbitrary height.
	 * Pre-condition:  Karel is facing east next to a hurdle.
	 * Post-condition: Karel is facing east at the bottom of 
	 * 				   the other side of the hurdle.
	 */
	private void jumpHurdle() {
		ascendHurdle();
		move();
		descendHurdle();
	}
	

	/*
	 * Karel climbs up the side of a hurdle.
	 * Pre-condition:  Karel is facing east at the bottom of
	 * 				   a hurdle.
	 * Post-condition: Karel is facing east above and immediately
	 * 				   before a hurdle.
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
	 * Pre-condition: Karel is facing east above and
	 * 				  immediately after a hurdle.
	 * Post-condition: Karel is facing east at the bottom of
	 * 				   the hurdle.
	 */
	private void descendHurdle() {
		turnRight();
		moveToWall();
		turnLeft();
	}

	/* Karel moves until it reaches a wall.
	 * Pre-condition:  none
	 * Post-condition: Karel is facing a wall in whichever 
     * 				   direction Karel was facing previously.
	 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
}
