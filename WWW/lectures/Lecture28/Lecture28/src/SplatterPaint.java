/* File: SplatterPaint.java
 * ------------------------
 * This program uses interactors and a custom
 * canvas to allow the user to draw "splatters"
 * of paint of different sizes and colors onscreen.
 */

import acm.program.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SplatterPaint extends Program {
	
	// The number of characters wide the diameter field should be
	private static final int DIAMETER_FIELD_WIDTH = 15;
	
	// The text field where the user types in the splatter diameter
	private JTextField diameterField;
	
	// The custom canvas that displays all splatters
	private SplatterPaintCanvas canvas;
	
	public void init() {
		canvas = new SplatterPaintCanvas();
		add(canvas);
		
		// Add the text field
		add(new JLabel("Diameter: "), SOUTH);
		diameterField = new JTextField(DIAMETER_FIELD_WIDTH);
		diameterField.setActionCommand("Yellow");
		diameterField.addActionListener(this);
		add(diameterField, SOUTH);
		
		// Add the buttons
		add(new JButton("Yellow"), SOUTH);
		add(new JButton("Orange"), SOUTH);
		add(new JButton("Randomize"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Yellow")) {
			// Add a yellow circle
			int diameter = Integer.parseInt(diameterField.getText());
			canvas.addSplatter(diameter, Color.yellow);
		} else if (e.getActionCommand().equals("Orange")) {
			// Add an orange circle
			int diameter = Integer.parseInt(diameterField.getText());
			canvas.addSplatter(diameter, Color.orange);
		} else if (e.getActionCommand().equals("Randomize")) {
			// Randomize all existing splatters
			canvas.randomizeColors();
		}
	}
}
