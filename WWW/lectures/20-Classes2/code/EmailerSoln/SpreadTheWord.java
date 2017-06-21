/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import acm.program.*;
import acm.util.RandomGenerator;

public class SpreadTheWord extends ConsoleProgram {
	
	private static final String TEST_EMAIL = "cs106a.winter.16@gmail.com";
	
	private ArrayList<StudentEmail> allStudents = new ArrayList<StudentEmail>();
	
	public void run() {
		loadEmails();
		for(StudentEmail student : allStudents) {
			Email email = new Email(student.getEmail(), "Hello from lecture");
			email.generateSocialEmailText(student.getName(), allStudents);
			println(email.toString());
			break;
			//email.send();
		}
	}

	private void loadEmails() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("emails.txt"));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				String[] cols = line.split(",");
				String name = cols[0];
				String address = cols[1];
				StudentEmail studentEmail = new StudentEmail(name, address); 
				allStudents.add(studentEmail);
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

