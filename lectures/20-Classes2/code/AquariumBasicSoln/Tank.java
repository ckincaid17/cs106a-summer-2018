/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import java.util.ArrayList;

import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.*;

public class Tank extends GCanvas {
	
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	
	private ArrayList<Fish> fishes = new ArrayList<Fish>();

	public void init() {
		addBackground();
		addFishes();
	}
	
	private void addBackground() {
		GImage img = new GImage("background.jpg");
		img.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		add(img);
	}

	private void addFishes() {
		for(int i = 0; i < 3; i++) {
			Fish fish = new Fish();
			// put the fish on the screen
			add(fish.getImage());
			// put the fish into an arraylist (for animation)
			fishes.add(fish);
		}
	}

	public void heartbeat() {
		for(Fish fish : fishes) {
			fish.heartbeat();
		}
	}
	
}

