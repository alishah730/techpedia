package com.techpedia.usermanagement.service.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.usermanagement.dataobject.NotifyReviewerVo;
import com.techpedia.usermanagement.dataobject.ReviewerDO;
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
	public static void sendContactUs(String email, String username, String message)
			throws EmailServiceException {
		String subject = "User Message";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear Admin," + "<br>");
		messageBody
				.append("Please find messge given by user "+ username+ " as below,"
						+ "<br><br>");
		messageBody.append("Message : " + "<br>");
		messageBody.append(message);
		messageBody.append("Kind regards," + "<br>");
		messageBody.append(username + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(email, "", subject,
				messageBody.toString());

	}
	
	public static void sendEmail(ReviewerDO reviewerDO) throws EmailServiceException {

		String subject = "TechPedia Registration";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear " + reviewerDO.getRevLname() + " " + reviewerDO.getRevFname() + ", <br>");
		messageBody.append("Conratulations!! " + "<br>");
		messageBody.append("You have been registered as Reviewer for GYTI Awards with TechPedia." + "<br>");
		messageBody.append("Your Account Details are:" + "<br>");
		messageBody.append("User ID : " + reviewerDO.getRevEmailId() + "<br>");
		messageBody.append("Password : " + reviewerDO.getRevPassword()+ "<br><br>");
		messageBody.append("To activate your account, click here." + "<br><br>");
		messageBody.append("<a href ='"+ UserManagementServiceConstant.EMAIL_ACTIVATE_REVIEWER_URL+ reviewerDO.getRevUsrId() + "&&Email="+reviewerDO.getRevEmailId()+"'>Click Here</a> <br><br>");
		messageBody.append("This is a system generated password. Please change the password after login."+ "<br>");
		messageBody.append("NOTE: Your account is not active until you click on the button in this email."+ "<br>");
		messageBody.append("Kind regards," + "<br>");
		messageBody.append("TechPedia Admin" + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(reviewerDO.getRevEmailId(), "", subject, messageBody.toString());

	}
	
	public static void notifySuggestedReviewer(NotifyReviewerVo notifyReviewerVo)
			throws EmailServiceException {
		String subject = "Notify Reviewer";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear User," + "<br>");
		messageBody
				.append("You have been suggested to review the below project,"
						+ "<br><br>");
		messageBody.append("Project Title : " + notifyReviewerVo.getProjectTitle() + "<br>");
		messageBody.append("Project Abstract : " + notifyReviewerVo.getProjectAbstract() + "<br>");
		messageBody.append("Kind regards," + "<br>");
		messageBody.append("TechPedia Admin" + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(notifyReviewerVo.getSuggestedReviewerEmail(),notifyReviewerVo.getLoggedInReviewerEmail(), subject,
				messageBody.toString());

	}
	
	public static void sendMoreInfoRequestToTeamLeader(String emailId,String comments,String projTitle,String projAbstract)
			throws EmailServiceException {
		String subject = "Request For More Information About Project";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear User," + "<br>");
		messageBody
				.append(comments
						+ "<br><br>");
		messageBody.append("Project Title : " + projTitle + "<br>");
		messageBody.append("Project Abstract : " + projAbstract + "<br>");
		messageBody.append("Kind regards," + "<br>");
		messageBody.append("TechPedia Admin" + "<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(emailId,"", subject,
				messageBody.toString());

	}
}
