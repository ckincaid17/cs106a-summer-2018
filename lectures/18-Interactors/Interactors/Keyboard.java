/*
 * File: Keyboard.java
 * ======================================================================
 * A program that displays a keyboard that the user can play!
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.*;
import acm.graphics.*;

public class Keyboard extends GraphicsProgram {
	/* A nice window size. */
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 235;

	/* The file containing the keyboard layout. */
	private static final String KEYBOARD_FILE = "keyboardC.txt";

	public void run() {
		loadKeyboard();
	}

	private void loadKeyboard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(KEYBOARD_FILE));

			while (true) {
				String line = br.readLine();
				if (line == null) break;
				String[] parts = line.split(",");
			}
			br.close();			
		} catch (IOException e) {
			println("Duh duh duh duhhhhhh.");
		}
	}

	private GRect makeKey(String[] lineParts) {
		double x = Double.parseDouble(lineParts[1]);
		double y = Double.parseDouble(lineParts[2]);
		double width = Double.parseDouble(lineParts[3]);
		double height = Double.parseDouble(lineParts[4]);
		GRect key = new GRect(width, height);
		boolean isWhiteKey = lineParts[5].equals("true");
		if (isWhiteKey) {
			key.setFilled(true);
		} 
		add(key, x, y);
		return key;
	}

}
