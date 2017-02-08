
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class MPedigree extends ConsoleProgram {

	private static final int N_BOXES = 10999;
	private static final int ID_LEN = 4;
	private static final int RAND_LEN = 6;
	
	private RandomGenerator rg = new RandomGenerator();
	

	public void run() {
		setFont("Courier-24");
		for(int i = 0; i < N_BOXES; i++) {
			String code = makeCode(i);
			println(code);
		}
	}

	/**
	 * Makes a code to put on a pill box that is both (1) unique and
	 * (2) unguessable. The code will always be of length 10.
	 */
	private String makeCode(int uniqueId) {
		// create a string version of the unique Id
		String idPart = makeStringOfLength(uniqueId, ID_LEN);
		
		// create a string version of a random number
		int randNum = rg.nextInt(1000000);
		String randomPart = makeStringOfLength(randNum, RAND_LEN);
		
		// concat the two strings!
		return randomPart + idPart;
	}

	/**
	 * Turns the input "num" into a string. Padds the string with
	 * zeros until it is of length strLength.
	 */
	private String makeStringOfLength(int num, int strLength) {
		String str = Integer.toString(num);
		if(str.length() > strLength) {
			throw new RuntimeException("This number doesn't fit in so few digits");
		}
		while(str.length() < strLength) {
			str = "0" + str;
		}
		return str;
	}

}
