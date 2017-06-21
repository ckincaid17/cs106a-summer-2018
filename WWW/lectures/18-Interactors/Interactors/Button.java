/*
 * File: XKCDColors.java
 * ========================================================
 * A program to plot colors from the xkcd colors file.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class Button extends ConsoleProgram {

	
	/* Sets up interactors. */
	public void init() {
		setFont("Courier-24");
		JButton button = new JButton("Press me");
		add(button, SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		println("Tehehe");
	}
	
	
}