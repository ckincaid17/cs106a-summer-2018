
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class GreenScreen extends GraphicsProgram {
	
	private static final int GREEN_THRESHOLD = 50;
	private static final int N_ROWS = 450;
	private static final int N_COLS = 800;
	
	public void run() {	
		GImage foreground = new GImage("greenForeground.jpg");
		GImage background = new GImage("greenBackground.jpg");
		
		add(background);
		waitForClick();
		add(foreground);
		waitForClick();
		
		// your code here...
	}
	
	private boolean isGreen(int pixel) {
		Color c = new Color(pixel);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		return 2 * g - r - b > GREEN_THRESHOLD;
	}

	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 450;

}
