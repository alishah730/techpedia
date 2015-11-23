package com.techpedia.usermanagement.service.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.service.constant.UserManagementServiceConstant;

public class UserManagementEmailHelper {

	public static String getEmailUrl() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = UserManagementEmailHelper.class.getClassLoader()
					.getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find the " + filename);
				return null;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty("EMAIL_URL");
	}

	public static void sendEmail(UserProfileDO userprofileDO)
			throws EmailServiceException {

		String subject = "TechPedia Registration";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear " + userprofileDO.getLastName() + " "
				+ userprofileDO.getFirstName() + ", <br>");
		messageBody
				.append("Thank you for registering with TechPedia." + "<br>");
		messageBody.append("Your Account Details are:" + "<br>");
		messageBody.append("User ID : " + userprofileDO.getUserName() + "<br>");
		messageBody.append("Password : " + userprofileDO.getPassword()
				+ "<br><br>");
		messageBody
				.append("To activate your account, click here." + "<br><br>");
		messageBody.append("<a href ='"
				+ UserManagementServiceConstant.EMAIL_URL
				+ userprofileDO.getUserName() + "'>Click Here</a> <br><br>");
		messageBody
				.append("NOTE: Your account is not active until you click on the button in this email."
						+ "<br>");
		messageBody.append("Kind regards," + "<br>");
		messageBody.append("TechPedia Admin" + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(userprofileDO.getEmail(), "", subject,
				messageBody.toString());

	}

	public static void sendPassword(String email, String currentPassword)
			throws EmailServiceException {
		String subject = "Forgot Password";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear User," + "<br>");
		messageBody
				.append("Please find your account password details as below,"
						+ "<br><br>");
		messageBody.append("Current Password : " + currentPassword + "<br>");
		messageBody.append("Kind regards," + "<br>");
		messageBody.append("TechPedia Admin" + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(email, "", subject,
				messageBody.toString());

	}

}
