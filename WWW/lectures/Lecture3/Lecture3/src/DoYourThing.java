import stanford.karel.*;

// This is Roomba without comments or decomposition. Which do you like better?
public class DoYourThing extends SuperKarel {

	public void run() {
		if (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
			}
		}
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		while (leftIsClear()) {
			turnLeft();
			move();
			turnRight();
			if (beepersPresent()) {
				pickBeeper();
			}
			while (frontIsClear()) {
				move();
				if (beepersPresent()) {
					pickBeeper();
				}
			}
			turnAround();
			while (frontIsClear()) {
				move();
			}
			turnAround();
		}
	}
}
