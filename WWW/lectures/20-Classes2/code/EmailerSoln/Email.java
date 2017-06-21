
import java.util.ArrayList;


import acm.util.RandomGenerator;


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
		this.text = "Email body is blank (sortof)";
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
		EmailSender sender = new EmailSender();
		sender.send(toAddress, subject, text);
	}

	// generate text for the email
	public void generateSocialEmailText(String studentName, ArrayList<StudentEmail> allStudents) {
		text = "";
		text += "Dear " + studentName + ",\n\n";
		text += "I hope this email finds you well.\n\n";
		text += "As you know, CS106A is a huge class with many wonderful people in it. ";
		text += "In lecture today we built a program to help you meet a few fellow students. ";
		text += "Here are five random people in CS106A. ";
		text += "You can (optionally) introduce yourself:\n";

		RandomGenerator rg = RandomGenerator.getInstance();
		for(int i = 0; i < 5; i++) {
			int studentIndex = rg.nextInt(allStudents.size());
			StudentEmail other = allStudents.get(studentIndex);
			text += " " + other.getName() + ", " + other.getEmail() + "\n";
		}

		text += "\n";
		text += "All the best,\n";
		text += "Chris";
		text += "\n\n";
		text += "P.S. Today we covered 'classes' which introduces a whole new way of thinking about programs";
	}

}