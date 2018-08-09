import acm.program.*;
import stanford.cs106.net.*;
import java.awt.event.*;
import javax.swing.*;

/* File: Trivia.java
 * -----------------
 * This file is the client program for a Trivia game. It displays
 * 4 buttons for A/B/C/D and when the user clicks one of them, it
 * sends a request over the Internet to the main game program with
 * our vote. 
 */
public class PollClient extends ConsoleProgram {
	
	// The URL where the host program is running
	// Currently, this program is set up so that you can run both a server
	// and a client on your own computer. During class, you can replace this
	// URL with the one I show you, and then you can interact with me!
	private static final String HOST = "http://localhost:8080";
	
	// The client object we use to send Requests over the Internet
	private SimpleClient client;
	
	public void init() {
		client = new SimpleClient(HOST);
		
		// Add interactors
		add(new JLabel("Your answer: "), SOUTH);
		add(new JButton("A"), SOUTH);
		add(new JButton("B"), SOUTH);
		add(new JButton("C"), SOUTH);
		add(new JButton("D"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent event) {
		// When the user clicks a button, send a new Request with our vote.
		Request request = new Request("vote");
		request.addParam("answer", event.getActionCommand());
		String response = client.makeRequest(request);
		println(response);
	}
}
