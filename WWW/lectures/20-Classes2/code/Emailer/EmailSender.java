import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	
	// all emails are sent form this gmail account.
	private static final String SENDER = "cs106a.winter.16@gmail.com";
	
	/************************************************************************
	 *  WARNING: This class is not for the faint of heart. It uses a few    *
	 *  concepts not covered in CS106A, such as the "static" keyword and of *
	 *  course, email sending! Proceed at your own peril.                   *
	 ************************************************************************/
	
	// static means that there is only one version of this variable which is shared.
	private static Session session = logIn();

	// This is top secret code. But you can check out the "API"
	public static void send(String recipient, String subject, String text) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SENDER));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			System.out.println("Email sent to: " + recipient);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	// you gotta log in if you wanna send that mail...
	private static Session logIn() {
		System.out.println("Logging in...");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SENDER,getTopSecretPassword());
			}
		});
		return session;
	}

	// that real-deal high security password encryper
	private static String getTopSecretPassword() {
		return ":-)";
	}
}
