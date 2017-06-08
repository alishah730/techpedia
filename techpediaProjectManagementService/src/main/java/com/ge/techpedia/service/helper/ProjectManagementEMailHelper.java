package com.ge.techpedia.service.helper;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.projectmanagement.bean.ApproveOrDeclineMentorRequestResponse;
import com.techpedia.projectmanagement.bean.CreateProjectResponseVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.RequestToBeMentorResponse;
import com.techpedia.projectmanagement.bean.ResubmitProjectResponse;

public class ProjectManagementEMailHelper {
	public static void sendEmail(Project project, CreateProjectResponseVO createProjectResponseVO)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		
		/*Create new Project*/
		subject = "Kind attn: Your inputs required for the Techpedia project: "+project.getProjTitle();			
		messageBody.append("Dear Sir/Madam, <br>");
		messageBody.append("It is to update that following project has been submitted for your approval.<br>");
		messageBody.append("The basic details of the project submitted are listed below:<br>");
		messageBody.append("Project Title: " + project.getProjTitle() + " <br>");
		messageBody.append("Project Description: " + project.getProjDescription() + " <br>");
		messageBody.append("Project submitted by : " + project.getProjTeamLeaderName() + " <br>");
		messageBody.append("Project submission date: " + project.getProjSubmitionDate() + " <br>");
		messageBody.append("For further details of the project, you may visit the hyperlink : <a href ='"+ProjectManagementServiceConstant.TECHPEDIA_URL+"'>"+ProjectManagementServiceConstant.TECHPEDIA_URL+"</a> <br>");
		messageBody.append("Regards, <br>");
		messageBody.append("Techpedia moderator <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
			
		/*Submit the Project*/
		/*if(token == "1"){			
			subject = "Kind attn: Your inputs required for the Techpedia project :"+project.getProjTitle();			
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
		}
		Approve the Project
		else if(token == "2"){
			subject = "Kind attn: Your submitted project "+project.getProjTitle()+" in Techpedia has been approved by the faculty.";			
			messageBody.append("Dear Student, <br>");
			messageBody.append("It is to update that your project "+project.getProjTitle()+" submitted to faculty <faculty name><br>");
			messageBody.append("on <date of submission> has been approved.<br>");
			messageBody.append("You may continue with the process of mentor selection and further project work. <br>");			
			messageBody.append("For further details of the project, you may visit the hyperlink : http://techpedia.com <br>");
			messageBody.append("Regards, <br>");
			messageBody.append("Techpedia moderator <br> <br>");
			messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
		}*/	
			

		TechPediaEmailFunction.sendMail(createProjectResponseVO.getFacultyEMailId(), createProjectResponseVO.getTeamTeaderEMailId(), subject, messageBody.toString());
	}
	
	public static void sendEmail(Project project)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
			
		/*Submit the Project*/
		subject = "Kind attn: Your inputs required for the Techpedia project :"+project.getProjTitle();			
		messageBody.append("Dear Sir/Madam, <br>");
		messageBody.append("It is to update that following project has been submitted for your approval.<br>");
		messageBody.append("The basic details of the project submitted are listed below:<br>");
		messageBody.append("Project Title: " + project.getProjTitle() + " <br>");
		messageBody.append("Project Description: " + project.getProjDescription() + " <br>");
		messageBody.append("Project submitted by : " + project.getProjTeamLeaderName() + " <br>");
		messageBody.append("Project submission date: " + project.getProjSubmitionDate() + " <br>");
		messageBody.append("For further details of the project, you may visit the hyperlink : <a href ='"+ProjectManagementServiceConstant.TECHPEDIA_URL+"'>"+ProjectManagementServiceConstant.TECHPEDIA_URL+"</a> <br>");
		messageBody.append("Regards, <br>");
		messageBody.append("Techpedia moderator <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");			
			
		
		/*Approve the Project
		else if(token == "2"){
			subject = "Kind attn: Your submitted project "+project.getProjTitle()+" in Techpedia has been approved by the faculty.";			
			messageBody.append("Dear Student, <br>");
			messageBody.append("It is to update that your project "+project.getProjTitle()+" submitted to faculty <faculty name><br>");
			messageBody.append("on <date of submission> has been approved.<br>");
			messageBody.append("You may continue with the process of mentor selection and further project work. <br>");			
			messageBody.append("For further details of the project, you may visit the hyperlink : http://techpedia.com <br>");
			messageBody.append("Regards, <br>");
			messageBody.append("Techpedia moderator <br> <br>");
			messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
		}*/	
			

		TechPediaEmailFunction.sendMail(project.getProjFacEmailId(), project.getProjTeamLeaderEMailId(), subject, messageBody.toString());
	}
	
	public static void sendResubmitProjectEmail(Project project, ResubmitProjectResponse resubmitProjectResponse) throws EmailServiceException {
		
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		
		/*Create new Project*/
		subject = "Kind attention: Your inputs required for the Techpedia project: "+project.getProjTitle();			
		messageBody.append("Dear Sir/Madam, <br>");
		messageBody.append("It is to update that following project has been re-submitted for your approval.<br>");
		messageBody.append("The basic details of the project submitted are listed below:<br>");
		messageBody.append("Project Title: " + project.getProjTitle() + " <br>");
		messageBody.append("Project Description: " + project.getProjDescription() + " <br>");
		messageBody.append("Project submitted by : " + project.getProjTeamLeaderName() + " <br>");
		messageBody.append("Project submission date: " + project.getProjSubmitionDate() + " <br>");
		messageBody.append("For further details of the project, you may visit the hyperlink : <a href ='"+ProjectManagementServiceConstant.TECHPEDIA_URL+"'>"+ProjectManagementServiceConstant.TECHPEDIA_URL+"</a> <br>");
		messageBody.append("Regards, <br>");
		messageBody.append("Techpedia moderator <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE *** ");
			
		TechPediaEmailFunction.sendMail(resubmitProjectResponse.getFacultyEmailId(), resubmitProjectResponse.getTeamLeaderEmailId(), subject, messageBody.toString());
	}
	
	public static boolean sendRequestToBeMentorEmail(RequestToBeMentorResponse requestToBeMentorResponse) throws EmailServiceException{
		
		boolean mailSentStatus = false;
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		/*Request to be Mentor*/
		subject = "Kind attention: Your inputs required for the Techpedia project :"+requestToBeMentorResponse.getProjTitle();		
		messageBody.append("Dear "+requestToBeMentorResponse.getTeamLeaderFname()+" "+requestToBeMentorResponse.getTeamLeaderMname()+" "+requestToBeMentorResponse.getTeamLeaderLname()+", <br>");
		messageBody.append("Mr/Ms "+requestToBeMentorResponse.getMentorFname()+" "+requestToBeMentorResponse.getMentorLname()+"has requested to be mentor for your team. To Approve/Decline,  please click on below link <br>");
		messageBody.append("<a href ='"+ProjectManagementServiceConstant.EMAIL_APPROVE_OR_DECLINE_MENTOR_REQUEST_URL+requestToBeMentorResponse.getMentorRegstrId()+"&projId="+requestToBeMentorResponse.getProjId()+"'>Click Here</a> <br><br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(requestToBeMentorResponse.getTeamLeaderEmailId(), requestToBeMentorResponse.getMentorEmailId(), subject, messageBody.toString());
		mailSentStatus = true;
		return mailSentStatus;
	}
	
	public static boolean sendApproveOrDeclineMentorRequestEmail(ApproveOrDeclineMentorRequestResponse approveOrDeclineMentorRequestResponse) throws EmailServiceException{
		
		boolean mailSentStatus = false;
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		/*Request to be Mentor*/
		subject = "Kind attention: Your inputs required for the Techpedia project :"+approveOrDeclineMentorRequestResponse.getProjTitle();		
		messageBody.append("Dear "+approveOrDeclineMentorRequestResponse.getMentorFname()+" "+approveOrDeclineMentorRequestResponse.getMentorLname()+", <br>");
		messageBody.append("Mr/Ms "+approveOrDeclineMentorRequestResponse.getTeamLeaderFname()+" "+approveOrDeclineMentorRequestResponse.getTeamLeaderLname()+"has declined your Request to be Mentor for his/her project. <br>");
		messageBody.append("Project Title : "+approveOrDeclineMentorRequestResponse.getProjTitle()+"<br>");
		messageBody.append("Comments : "+approveOrDeclineMentorRequestResponse.getDeclineComments()+"<br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(approveOrDeclineMentorRequestResponse.getMentorEmailId(), approveOrDeclineMentorRequestResponse.getTeamLeaderEmailId(), subject, messageBody.toString());
		mailSentStatus = true;
		return mailSentStatus;
	}
}
