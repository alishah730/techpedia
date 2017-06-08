package com.ge.techpedia.service.helper;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.email.util.TechPediaEmailFunction;
import com.techpedia.projectmanagement.bean.AddNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberResponseVO;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberVO;
import com.techpedia.projectmanagement.bean.FacRejectProjResponse;
import com.techpedia.projectmanagement.bean.FacultyMarkedProjectAsCompletedResponse;
import com.techpedia.projectmanagement.bean.FacultyVO;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyVO;

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
	
	public static void sendFacultyRejectedProjectEmail(FacRejectProjResponse facRejectProjResponse)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		
		subject = "Kind attention: Your inputs required for the Techpedia project :"+facRejectProjResponse.getProjTitle();			
		messageBody.append("Dear "+facRejectProjResponse.getTeamLeaderFname()+" "+facRejectProjResponse.getTeamLeaderMname()+" "+facRejectProjResponse.getTeamLeaderMname()+", <br>");
		messageBody.append("Your Project has been rejected by your faculty. "+" <br>");
		messageBody.append("Reason : "+facRejectProjResponse.getRejectReason()+" <br>");
		messageBody.append("Please get in touch with "+facRejectProjResponse.getFacultyFname()+" "+facRejectProjResponse.getFacultyMname()+" "+facRejectProjResponse.getFacultyMname()+" for the changes required and resubmit it. <br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(facRejectProjResponse.getTeamLeaderEmailId(), facRejectProjResponse.getFacultyEmailId(), subject, messageBody.toString());
	}
	
	public static void sendFacultyRejectedProjectAtClosureEmail(FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompleteResponse)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		
		subject = "Kind attention: Your inputs required for the Techpedia project :"+facultyMarkedProjectAsCompleteResponse.getProjTitle();			
		messageBody.append("Dear "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderFname()+" "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderMname()+" "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderMname()+", <br>");
		messageBody.append("Your Project has been rejected by your faculty. "+" <br>");
		messageBody.append("Reason : "+facultyMarkedProjectAsCompleteResponse.getRejectReason()+" <br>");
		messageBody.append("Please get in touch with "+facultyMarkedProjectAsCompleteResponse.getFacultyFname()+" "+facultyMarkedProjectAsCompleteResponse.getFacultyMname()+" "+facultyMarkedProjectAsCompleteResponse.getFacultyMname()+" for the changes required and resubmit it. <br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(facultyMarkedProjectAsCompleteResponse.getTeamLeaderEmailId(), facultyMarkedProjectAsCompleteResponse.getFacultyEmailId(), subject, messageBody.toString());
	}
	
	public static void sendFacultyMarkedProjectAsCompleteEmail(FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompleteResponse)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		
		subject = "Congratuations: Your Techpedia project : "+facultyMarkedProjectAsCompleteResponse.getProjTitle()+" has been Marked As Complete";			
		messageBody.append("Dear "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderFname()+" "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderMname()+" "+facultyMarkedProjectAsCompleteResponse.getTeamLeaderMname()+", <br>");
		messageBody.append("Your Project has been marked as complete by your faculty "+facultyMarkedProjectAsCompleteResponse.getFacultyFname()+" "+facultyMarkedProjectAsCompleteResponse.getFacultyMname()+" "+facultyMarkedProjectAsCompleteResponse.getFacultyMname()+" <br>");
		messageBody.append("Grade : "+facultyMarkedProjectAsCompleteResponse.getProjGrade()+" <br>");
		messageBody.append("Comments : "+facultyMarkedProjectAsCompleteResponse.getProjFacNotes()+" <br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(facultyMarkedProjectAsCompleteResponse.getTeamLeaderEmailId(), facultyMarkedProjectAsCompleteResponse.getFacultyEmailId(), subject, messageBody.toString());
	}
	
	public static void sendEmail(AddNewTeamMemberVO addNewTeamMemberVO, AddNewTeamMemberResponseVO addNewTeamMemberResponseVO)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		/*New Faculty*/
		subject = "Invitation for TechPedia registration as Team Member";			
		messageBody.append("Dear "+addNewTeamMemberVO.getfName()+" "+addNewTeamMemberVO.getmName()+" "+addNewTeamMemberVO.getlName()+", <br>");
		messageBody.append("You have been added as a team member by one of registered student of Techpedia. To View the details you are required to complete the registration. <br>");
		messageBody.append("To complete your registration please click on below link <br>");
		messageBody.append("<a href ='"+ProjectManagementServiceConstant.EMAIL_TEAM_MEMBER_URL+addNewTeamMemberResponseVO.getRgstrId()+"&usrName="+addNewTeamMemberResponseVO.getUserId()+"'>Click Here</a> <br><br>");
		messageBody.append("NOTE: Till you register and activate your profile you will not be able to login to TechPedia, or view the project(s) align with you as team member. <br><br><br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(addNewTeamMemberVO.getEmailId(), "", subject, messageBody.toString());
	}
	
	public static void sendEmailToRegisterFaculty(RegisterNewFacultyVO registerNewFacultyVO, RegisterNewFacultyResponseVO registerNewFacultyResponseVO)
		    throws EmailServiceException
		  {
		String subject = "";
		StringBuffer messageBody = new StringBuffer();
		/*New Faculty*/
		subject = "Invitation for TechPedia registration as Faculty";			
		messageBody.append("Dear "+registerNewFacultyVO.getfName()+" "+registerNewFacultyVO.getmName()+" "+registerNewFacultyVO.getlName()+", <br>");
		messageBody.append("You have been added as a faculty by one of registered student of Techpedia. To View the details you are required to complete the registration. <br>");
		messageBody.append("To complete your registration please click on below link <br>");
		messageBody.append("<a href ='"+ProjectManagementServiceConstant.EMAIL_URL+registerNewFacultyResponseVO.getRgstrId()+"&usrName="+registerNewFacultyResponseVO.getUserId()+"'>Click Here</a> <br><br>");
		messageBody.append("NOTE: Till you register and activate your profile you will not be able to login to TechPedia, or view the project(s) align with you as faculty. <br><br><br>");
		messageBody.append("Kind regards, <br>");
		messageBody.append("TechPedia Admin <br> <br>");
		messageBody.append("*** PLEASE DO NOT REPLY TO THIS MESSAGE ***");

		TechPediaEmailFunction.sendMail(registerNewFacultyVO.getEmailId(), "", subject, messageBody.toString());
	}
}
