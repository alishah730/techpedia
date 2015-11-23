package com.techpedia.email.util;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.logger.TechPediaLogger;

public class TechPediaEmailFunction {

	private static TechPediaLogger LOGGER = TechPediaLogger
			.getLogger(TechPediaEmailFunction.class.getName());

	private TechPediaEmailFunction() {
		LOGGER.info("this is a constructor");
	}

	public static void sendMail(String to, String cc, String subject,
			String body) throws EmailServiceException {
		LOGGER.info("TechPediaEmailFunction sendMail: START");
	//	LOGGER.info("values of to is : "+to +" cc is : "+cc+" subject is : "+ " body is : "+body);
		final ResourceBundle rbundle = ResourceBundle.getBundle("email");
		System.out.println("bundle property :"
				+ rbundle.getString("FROM_ADMIN"));

		Properties props = System.getProperties();
		props.setProperty("mail.smtp.port", rbundle.getString("PORT"));
		props.setProperty("mail.smtp.socketFactory.port",
				rbundle.getString("PORT"));
		props.setProperty("mail.smtp.host", rbundle.getString("MAIL_SMTP_HOST"));
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.auth", "true");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(rbundle
								.getString("USERNAME"), rbundle
								.getString("PASSWORD"));
					}
				});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(rbundle.getString("FROM_ADMIN")));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(cc));
			message.setSubject(subject);
			message.setContent(body, "text/html");// added by Anil
			//message.setText(body);
			Transport.send(message);
		//	LOGGER.info("before the successful tbr");
			LOGGER.info("Mail has been sent successfully....");

		} catch (MessagingException e) {
			//LOGGER.info("inside the catch block of MessagingException tbr");
			e.printStackTrace();
			throw new EmailServiceException("UM-EX013","EmailServiceException", " Error while sending Email");
			// throw new RuntimeException(e);
		/*	if ("TechPedia Registration".equalsIgnoreCase(subject)) {
			//	LOGGER.info("inside the if block tbr");
				throw new EmailServiceException(
						"UM-EX013",
						"EmailServiceException",
						"Registration completed successfully! Could not send the email - please check your email address");
			} else{
				//LOGGER.info("inside the else block tbr");
			
			}*/	
		}

	}

}
