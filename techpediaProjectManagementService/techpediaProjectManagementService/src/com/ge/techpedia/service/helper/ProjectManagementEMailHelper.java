package com.ge.techpedia.service.helper;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.projectmanagement.bean.Project;

public class ProjectManagementEMailHelper {
	public static void sendEmail(Project project)
		    throws EmailServiceException
		  {
		String subject = "Kind attn: Your inputs required for the Techpedia project :"+project.getProjTitle();
		StringBuffer messageBody = new StringBuffer();
		messageBody.append("Dear Sir/Madam, <br>");
		messageBody.append("It is to update that following project has been submitted for your approval.<br>");
		messageBody.append("The basic details of the project submitted are listed below:<br>");
		messageBody.append("Project Title: " + project.getProjTitle() + " <br>");
		messageBody.append("Project Description: " + project.getProjDescription() + " <br>");
		messageBody.append("Project submitted by : " + project.getProjTeamLeaderName() + " <br>");
		messageBody.append("Project submission date: " + project.getProjSubmitionDate() + " <br>");
		messageBody.append("For further details of the project, you may visit the hyperlink : http://techpedia.com <br>");
		messageBody.append("Regards, <br>");
		messageBody.append("Techpedia moderator <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");

		TechPediaEmailFunction.sendMail(project.getProjFacEMailId(), project.getProjTeamLeaderEMailId(), subject, messageBody.toString());
	}
}
