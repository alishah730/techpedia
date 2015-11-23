package com.ge.techpedia.service.helper;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.projectmanagement.bean.AddNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.FacultyVO;

public class FacultyEMailHelper {
	public static void sendEmail(FacultyVO facultyVO, AddNewFacultyResponseVO addNewFacultyResponseVO)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		/*New Faculty*/
		subject = "Invitation for TechPedia registration as faculty";			
		messageBody.append("Dear "+facultyVO.getFirstName()+" "+facultyVO.getMiddleName()+" "+facultyVO.getLastName()+", <br>");
		messageBody.append("You have been added as faculty by one of registered student of Techpedia. To View the details you are required to complete the registration. <br>");
		messageBody.append("To complete your registration please click on below link <br>");
		messageBody.append("<a href ='"+ProjectManagementServiceConstant.EMAIL_URL+addNewFacultyResponseVO.getRgstrId()+"&usrName="+addNewFacultyResponseVO.getUserID()+"'>Click Here</a> <br><br>");
		messageBody.append("NOTE: Till you register and activate your profile you will not be able to login to TechPedia, or view the project(s) align with you as faculty. <br><br><br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(facultyVO.getEmail(), "", subject, messageBody.toString());
	}
}
