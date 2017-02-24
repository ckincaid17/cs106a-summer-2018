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

public class KeyboardAdvanced extends GraphicsProgram {
	/* A nice window size. */
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 235;

	/* The file containing the keyboard layout. */
	private static final String KEYBOARD_FILE = "keyboardC.txt";

	String[] COL_NAMES = {"noteName","x","y","width","height","isWhite","computerKey"};
	

	private HashMap<GRect, AudioClip> noteMap = 
			new HashMap<GRect, AudioClip>();

	private HashMap<Character, GRect> compKeyMap =
			new HashMap<Character, GRect>();

	private HashMap<GRect, Integer> fadeTime =
			new HashMap<GRect, Integer>();

	public void run() {
		loadKeyboard();
		addMouseListeners();
		addKeyListeners();
		while(true) {
			fadeKeys();
			pause(100);
		}
	}

	private void fadeKeys() {
		for(GRect key : fadeTime.keySet()) {
			int timeToLive = fadeTime.get(key);
			if(timeToLive > 0) {
				timeToLive -= 1;
				fadeTime.put(key, timeToLive);
				if(timeToLive == 0) {
					if(isWhiteKey(key)) {
						key.setFilled(false);
					} else {
						key.setFillColor(Color.BLACK);
					}
				}
			}
		}
	}

	private boolean isWhiteKey(GRect key) {
		if(key.getFillColor() == Color.BLUE) return true;
		if(key.isFilled() == false) return true;
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char ch = Character.toUpperCase(e.getKeyChar());
		println(ch + " pressed");
		if(compKeyMap.containsKey(ch)) {
			GRect key = compKeyMap.get(ch);
			playKey(key);
		}
	}

	public void mousePressed(MouseEvent e) {
		GRect hit = (GRect) getElementAt(e.getX(), e.getY());
		if (hit != null) {
			playKey(hit);
		}
	}

	private void playKey(GRect hit) {
		AudioClip note = noteMap.get(hit);
		note.stop();
		note.play();
		if(isWhiteKey(hit)) {
			hit.setFilled(true);
			hit.setFillColor(Color.BLUE);	
		} else {
			hit.setFillColor(Color.GREEN);
		}
		fadeTime.put(hit, 3);
	}

	private void loadKeyboard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(KEYBOARD_FILE));

			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				Map<String,String> lineValues = parseLine(line);
				String noteName = lineValues.get("noteName");
				char compKey = lineValues.get("computerKey").charAt(0);
				
				GRect key = new GRect(
						Double.parseDouble(lineValues.get("x")),
						Double.parseDouble(lineValues.get("y")),
						Double.parseDouble(lineValues.get("width")),
						Double.parseDouble(lineValues.get("height")));
				if (lineValues.get("isWhite").equals("false")) {
					key.setFilled(true);
				}

				add(key);

				noteMap.put(key, MediaTools.loadAudioClip(noteName));
				compKeyMap.put(compKey, key);
			}
			br.close();			
		} catch (IOException e) {
			println("Duh duh duh duhhhhhh.");
		}
	}
	
	private Map<String, String> parseLine(String line) {
		String[] elems = line.split(",");
		Map<String, String> values = new HashMap<String, String>();
		for(int i = 0; i < COL_NAMES.length; i++) {
			values.put(COL_NAMES[i], elems[i]);
		}
		return values;
	}
}
