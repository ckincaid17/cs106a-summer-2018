

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class GreenScreenSoln extends GraphicsProgram {
	
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
		
		int[][] foregroundPixels = foreground.getPixelArray();
		int[][] backgroundPixels = background.getPixelArray();
		
		int[][] newPixels = new int[N_ROWS][N_COLS];
		for(int r = 0; r < N_ROWS; r++) {
			for(int c = 0; c < N_COLS; c++) {
				int pixel = foregroundPixels[r][c];
				if(isGreen(pixel)) {
					newPixels[r][c] = backgroundPixels[r][c];
				} else {
					newPixels[r][c] = foregroundPixels[r][c];
				}
			}
		}
		
		GImage composed = new GImage(newPixels);
		add(composed);
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
