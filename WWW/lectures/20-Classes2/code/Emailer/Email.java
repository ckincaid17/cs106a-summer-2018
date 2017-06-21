
// This file defines a new variable type!!!
public class Email {

	// every email has an address
	private String toAddress;
	
	// every email has a subject
	private String subject;
	
	// every email has text
	private String text;

	// this is how you make a new email
	public Email(String toAddress, String subject) {
		this.toAddress = toAddress;
		this.subject = subject;
		text = "Email body is blank (sortof)";
	}
	
	// this sets the text of an email.
	public void setText(String emailBody) {
		this.text = emailBody;
	}

	// for testing purposes it is useful to have a "toString" method
	public String toString() {
		String str = "";
		str += "To: " + toAddress + "\n";
		str += "Subject: " + subject + "\n";
		str += "Text:\n" + text;
		return str;
	}

	// warning: actually sends an email!
	public void send() {
		EmailSender.send(toAddress, subject, text);
	}

	

}