/*
 * File: CatchMeIfYouCan.java
 * -----------------------------
 * Makes a program with one magic blue square and many
 * distractors. The user tries (in vain) to touch the
 * blue square with her mouse.
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class CatchMeIfYouCan extends GraphicsProgram {

	private static final int DISTRACTOR_SIZE = 40;
	private static final int SQ_SIZE = 45;
	private static final int N_DISTRACTORS = 50;
	
	private RandomGenerator rg = new RandomGenerator();
	
	public void run() {
		addDistractors();
		addMouseListeners();
	}
	
	private void addDistractors() {
		for(int i = 0; i < N_DISTRACTORS; i++) {
			addDistractor();
		}
	}

	private void addDistractor() {
		GRect r = new GRect(DISTRACTOR_SIZE, DISTRACTOR_SIZE);
		r.setFilled(true);
		int x = getRandomX(DISTRACTOR_SIZE);
		int y = getRandomY(DISTRACTOR_SIZE);
		add(r, x, y);
	}
	
	private int getRandomX(int size) {
		int maxX = getWidth() - size;
		return rg.nextInt(maxX);
	}

	private int getRandomY(int size) {
		int maxY = getHeight() - size;
		return rg.nextInt(maxY);
	}
}
