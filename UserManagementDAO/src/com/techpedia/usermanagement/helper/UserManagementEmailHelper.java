package com.techpedia.usermanagement.helper;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.usermanagement.dataobject.UserProfileDO;

public class UserManagementEmailHelper {
	
	public static void sendEmailFromDAO(UserProfileDO userprofileDO) throws EmailServiceException{

		
		
		String subject = "TechPedia Registration";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear "+userprofileDO.getLastName()+" "+userprofileDO.getFirstName()+", <br>");
		messageBody.append("Thank you for registering with TechPedia."+"<br>");
		messageBody.append("Your Account Details are:"+"<br>");
		messageBody.append("User ID : " +userprofileDO.getUserName()+"<br>");
		messageBody.append("Password : " +userprofileDO.getPassword()+"<br><br>");
		messageBody.append("To activate your account, click here."+"<br><br>");
		messageBody.append("<a href ='"+"www.google.com"+userprofileDO.getUserName()+"'>Click Here</a> <br><br>");
		messageBody.append("NOTE: Your account is not active until you click on the button in this email."+"<br>");
		messageBody.append("Kind regards,"+"<br>");
		messageBody.append("TechPedia Admin"+"<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
	
		TechPediaEmailFunction.sendMail(userprofileDO.getEmail(),"",subject,
				messageBody.toString());

	
		
	}

	public static void sendPasswordFromDAO(String email,String currentPassword) throws EmailServiceException {
		
		String subject = "Forgot Password";
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear User,"+ "<br>");
		messageBody.append("Please find your account password details as below,"+"<br>");
		messageBody.append("Current Password : "+currentPassword+"<br>");
		messageBody.append("Kind regards,"+"<br>");
		messageBody.append("TechPedia Admin"+"<br><br><br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
	
		TechPediaEmailFunction.sendMail(email,"",subject,messageBody.toString());
		
	}

}
