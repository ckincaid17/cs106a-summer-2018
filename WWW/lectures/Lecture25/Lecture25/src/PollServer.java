/* File: Trivia.java
 * -----------------
 * This file is the server program for a Trivia game. It listens
 * for votes coming in over the network via Requests, and counts
 * up the votes it receives. It allows the user of this program
 * to reset the votes (by posting a new question) and display
 * the votes.
 */

import acm.program.*;
import stanford.cs106.net.*;
import javax.swing.*;
import java.awt.event.*;

public class PollServer extends ConsoleProgram implements SimpleServerListener {
	
	// The Server object that notifies us when we receive a Request
	private SimpleServer server;
	
	// The text field where the user enters questions
	private JTextField textField;
	
	// The length-4 array counting the votes for A/B/C/D
	int[] votes;
	
	public void init() {
		votes = new int[4];
		
		// Start listening for requests
		server = new SimpleServer(this, 8080);
		server.start();
		
		// Add interactors
		add(new JButton("Display Votes"), NORTH);
		textField = new JTextField(20);
		add(textField, SOUTH);
		add(new JButton("Post Question"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Display Votes")) {
			// Display the votes for A/B/C/D
			for (int i = 0; i < votes.length; i++) {
				char currentAnswer = (char)('A' + i);
				println("(" + currentAnswer + "): " + votes[i] + " votes");
			}
		} else if (event.getActionCommand().equals("Post Question")) {
			// Clear the screen and the vote counts for the new question
			clearConsole();
			votes = new int[4];
			println(textField.getText());
			println("Waiting for responses....");
			textField.setText("");
		}
	}
	
	// This method is called whenever a request is received.
	public Object requestMade(Request request) {
		if (request.getCommand().equals("vote")) {
			// Add one to our array of vote counts for their vote
			String vote = request.getParam("answer");
			votes[vote.charAt(0) - 'A']++;
			return "Vote \"" + vote + "\" received!";
		} else {
			return "Unknown command.";
		}
	}
}
