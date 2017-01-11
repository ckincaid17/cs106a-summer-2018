/*
 * File: Place99Beepers.java
 * ----------------------------
 * This demo shows you how to repeat commands a fixed
 * number of times.
 */
import stanford.karel.*;

public class Place99Beepers extends SuperKarel {
	
	/**
	 * Method: Run
	 * ------------------
	 * Program execution starts here.
	 */
	public void run() {
		move();
		for(int i = 0; i < 99; i++) {
			putBeeper();
		}
		move();
	}
}
