
import acm.graphics.*;
import acm.program.*;

public class HumanGenome extends ConsoleProgram {
	

	public void run() {
		setFont("Courier-24");
		String strand1 = "ATGCCAGGAC";
		String strand2 = "GGACTTACATCCTT";
		String composed = compose(strand1, strand2);
		println("s1      : " + strand1);
		println("s2      : " + strand2);
		println("composed: " + composed);
	}
	
	/**
	 * Finds the overlap region between strand1 and strand2, assumes
	 * they form a longer sequence, and returns the longer sequence.
	 * For now, only works if strand1 is before strand2 in the longer
	 * sequence.
	 * @param strand1  DNA snippet
	 * @param strand2  DNA snippet
	 * @return A longer DNA snippet resulting from merging the inputs.
	 */
	private String compose(String strand1, String strand2) {
		String compose = "";
		for(int i = 0; i < strand1.length(); i++) {
			String rest = strand1.substring(i);
			if(overlaps(rest, strand2)) {
				return compose + strand2;
			}
			compose += strand1.charAt(i);
		}
		return compose;
	}

	/**
	 * Returns if the longString starts with the prefix String.
	 * @param prefix     a short string to look for
	 * @param longString  a long string to look within
	 * @return true if longString starts with prefix. Else false.
	 */
	private boolean overlaps(String prefix, String longString) {
		if(prefix.length() > longString.length()) return false;
		for(int i = 0; i < prefix.length(); i++) {
			if(longString.charAt(i) != prefix.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	
}
