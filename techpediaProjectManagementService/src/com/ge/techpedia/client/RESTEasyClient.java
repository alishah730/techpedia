package com.ge.techpedia.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.ge.techpedia.bean.AddCommVO;
import com.ge.techpedia.bean.Challenge;
import com.ge.techpedia.bean.DeleteChallDocVO;
import com.ge.techpedia.bean.DeleteCommVO;
import com.ge.techpedia.bean.DeleteDocVO;
import com.ge.techpedia.bean.DisplayTeamCommVO;
import com.ge.techpedia.bean.DownChallengeDocVO;
import com.ge.techpedia.bean.DownloadDocVO;
import com.ge.techpedia.bean.FacInitProjVO;
import com.ge.techpedia.bean.FacultyVO;
import com.ge.techpedia.bean.FollowProjectVO;
import com.ge.techpedia.bean.MentorVO;
import com.ge.techpedia.bean.ProjFollowVO;
import com.ge.techpedia.bean.ProjSubmit;
import com.ge.techpedia.bean.Project;
import com.ge.techpedia.bean.SearchByKeyVO;
import com.ge.techpedia.bean.TeamMember;
import com.ge.techpedia.bean.UploadChallDocVO;
import com.ge.techpedia.bean.UploadProjDocVO;
import com.ge.techpedia.bean.UserProfileVO;
import com.google.gson.Gson;

public class RESTEasyClient {

	public static void main(String[] args) throws ParseException {

		Gson gson = new Gson();

		Project project = new Project();
		long projGuideId = 0;
		int projStatusId = 1;
		String projToFloat = "N";
		String projCommentsPublish = "N";
		long projTeamLeaderId = 5;
		String projIsMentorAvail = "";
		int projectTypeId = 1;
		String projectTitle = "Robotics project, IIT Kanpur client";
		ArrayList<Integer> projectBranches = new ArrayList<Integer>();
		projectBranches.add(1);
		projectBranches.add(2);
		projectBranches.add(3);
		projectBranches.add(4);
		projectBranches.add(5);
		ArrayList<String> projectKeywords = new ArrayList<String>();
		projectKeywords.add("Science");
		projectKeywords.add("Engineering");
		projectKeywords.add("Physics");
		projectKeywords.add("Energy");
		projectKeywords.add("Car");
		ArrayList<Long> projectTeamMembers = new ArrayList<Long>();
		projectTeamMembers.add(200931l);
		projectTeamMembers.add(200914l);
		projectTeamMembers.add(200938l);
		projectTeamMembers.add(200945l);
		projectTeamMembers.add(200937l);
		String projTeamDesc = "Computer Science team, IIT Kanpur";
		Calendar now = Calendar.getInstance();
		int projectYear = now.get(Calendar.YEAR);
		/*Date stdDate = now.getTime();
		Date endDate = now.getTime();*/
		int projectDuration = 6;
		String projectAbstract = "Robotics";
		String projectDescription = "Robotics project by IIT Kanpur";
		String projectCollege = "IIT Kanpur";
		String projectStudentId = "2009ECS31";
		long projectFaculty = 1;
		long projectEstimationCost = 100000;
		project.setProjGuideId(projGuideId);
		project.setProjStatusId(projStatusId);
		project.setProjToFloat(projToFloat);
		project.setProjCommentsPublish(projCommentsPublish);
		project.setProjTeamLeaderId(projTeamLeaderId);
		project.setProjIsMentorAvail(projIsMentorAvail);
		project.setProjTypeId(projectTypeId);
		project.setProjTitle(projectTitle);
		project.setProjBranches(projectBranches);
		project.setProjKeywords(projectKeywords);
		project.setProjTeamMembers(projectTeamMembers);
		project.setProjTeamDesc(projTeamDesc);
		project.setProjYear(projectYear);
		project.setProjStartDate(String.valueOf(now.getTimeInMillis()));
		project.setProjEndDate(String.valueOf(now.getTimeInMillis()));
		project.setProjDuration(projectDuration);
		project.setProjAbstract(projectAbstract);
		project.setProjDescription(projectDescription);
		project.setProjCollege(projectCollege);
		project.setProjStudentId(projectStudentId);
		project.setProjFaculty(projectFaculty);
		project.setProjEstimationCost(projectEstimationCost);
		project.setProjIsForChallenge("Y");
		
		ArrayList<String> branchIds = new ArrayList<String>();
		branchIds.add("1");
		branchIds.add("2");
		
		UserProfileVO userProfileVO = new UserProfileVO();
		userProfileVO.setFirstName("veerendra");
		//userProfileVO.setLastName("Tendulkar");
		userProfileVO.setStudentID("2");
		
		//String userId ="sehwag7102014";
		
		
		FacultyVO facultyVO = new FacultyVO();
		facultyVO.setFirstName("neal11");
		facultyVO.setMiddleName("sun");
		facultyVO.setLastName("joy");
		facultyVO.setEmail("neal.sun@ge.com");
		facultyVO.setCollege("DU");
		
		
		Challenge challenge = new Challenge();
		int  challengeTypeId = 1;
		String challengeTitle = "Global Warming";
		String challengeDescription = "Protect Earth from Global Warming";
		int challengYear = now.get(Calendar.YEAR);
		String challengeAbstract = "Ozone layer destroyed : reason Global Warming";
        String challengCommentsPublish = "Y";
    	challenge.setChallengTypeId(challengeTypeId);
    	challenge.setChallengTitle(challengeTitle);	
    	challenge.setChallengDescription(challengeDescription);
    	challenge.setChallengYear(challengYear);
	    challenge.setChallengAbstract(challengeAbstract);
		challenge. setChallengCommentsPublish(challengCommentsPublish);
		challenge.setChallengStartDate(String.valueOf(now.getTimeInMillis()));
		challenge.setChallengCloseDate(String.valueOf(now.getTimeInMillis()));;
		
		Project projectForUpdate = new Project();
		 
		 projectForUpdate.setProjId(195);
		 projectForUpdate.setProjTitle("Robotics project, IIT Kanpur Updated on 28");
		 projectForUpdate.setProjAbstract("Abstract updated on 28");
		 projectForUpdate.setProjDescription("Description updated on 28");
		 projectForUpdate.setProjYear(projectYear);
		 projectForUpdate.setProjDuration(5);
		 projectForUpdate.setProjEndDate(String.valueOf(now.getTimeInMillis()));
		 projectForUpdate.setProjEstimationCost(200000);
		 projectForUpdate.setProjFaculty(11);
		 projectForUpdate.setProjTeamId(189);
		 projectForUpdate.setProjTeamDesc("Computer Science team, IIT Kanpur updated on 28");
		 ArrayList<String> projectKeywords1 = new ArrayList<String>();
			projectKeywords1.add("Medicinee");
			projectKeywords1.add("Science  Engineeringg");
			projectKeywords1.add("Physics  chemistryy");
			projectKeywords1.add("Light  Energyy");
			projectKeywords1.add("Car  Bikee");
		projectForUpdate.setProjKeywords(projectKeywords1);
		
		ArrayList<TeamMember> teamMembers = new ArrayList<TeamMember>();
		TeamMember teamMember;
		for(int i=0; i<=3; i++){
			teamMember = new TeamMember();
			teamMember.setProjId(203);
			teamMember.setRegstrId(1000+i);
			//teamMember.setTeamId(198);
			teamMembers.add(teamMember);
		}
		
		MentorVO mentorVO = new MentorVO();
		mentorVO.setProjId(204);
		mentorVO.setMentorRgstrId(16);
		
		DisplayTeamCommVO displayTeamCommVO = new DisplayTeamCommVO();
		displayTeamCommVO.setIterationCount("1");
		displayTeamCommVO.setProjId("167");
		
		AddCommVO addCommVO = new AddCommVO();
		addCommVO.setProjId(167);
		addCommVO.setRegstrId(26);
		addCommVO.setProjComment("Abinash Test123");
		
		DeleteCommVO deleteCommVO = new DeleteCommVO();
		deleteCommVO.setCommentId(3);
		deleteCommVO.setProjectId(203);
		deleteCommVO.setRgstrId(1);
		
		ProjFollowVO followVO = new ProjFollowVO();
		followVO.setProjectId(203);
		followVO.setRgstrId(1);
		
		SearchByKeyVO searchByKeyVO = new SearchByKeyVO();
		searchByKeyVO.setIterationCount("1");
		searchByKeyVO.setTerm("car");
		
		FollowProjectVO followProjectVO = new FollowProjectVO();
		followProjectVO.setProjId(193);
		followProjectVO.setUserRgstrNo(180);
		
		ProjFollowVO projFollowVO = new ProjFollowVO();
		projFollowVO.setProjectId(204);
		projFollowVO.setRgstrId(1);
		
		String docByteArray = "VGhpcyBpcyB0ZXN0IGRvY3VtZW50IGZvciB1cGxvYWQ=";
		
		UploadChallDocVO uploadChallDocVO = new UploadChallDocVO();
		uploadChallDocVO.setDocByteArray(docByteArray);
		uploadChallDocVO.setDocName("upload_doc.txt");
		uploadChallDocVO.setChallengeId(3);
		uploadChallDocVO.setRgstrId(89);
		
		
		UploadProjDocVO uploadProjDocVO = new UploadProjDocVO();
		uploadProjDocVO.setDocByteArray(docByteArray);
		uploadProjDocVO.setDocName("upload_doc123.txt");
		uploadProjDocVO.setProjId(204);
		uploadProjDocVO.setRgstrId(2);
		
		DownChallengeDocVO challengeDocVO = new DownChallengeDocVO();
		challengeDocVO.setChallengeId(2);
		challengeDocVO.setRegstrId(2);
		
		ProjSubmit projSubmit = new ProjSubmit();
		projSubmit.setProjId(204);
		projSubmit.setStatus(3);
		
		String bulkUploadDocByteArray = "";
		
		DeleteDocVO deleteDocVO = new DeleteDocVO();
		deleteDocVO.setProjId(204);
		deleteDocVO.setRegstrId(2);
		deleteDocVO.setDocName("upload_doc123.txt");
		
		FacInitProjVO facInitProjVO = new FacInitProjVO();
		facInitProjVO.setProjId(204);
		facInitProjVO.setProjGuideId(1);
		facInitProjVO.setApprovalStatus("Y");
		
		DeleteChallDocVO deleteChallDocVO = new DeleteChallDocVO();
		deleteChallDocVO.setChallengeId(3);
		deleteChallDocVO.setRegstrId(89);
		deleteChallDocVO.setDocName("upload_doc_test.txt");
		
		DownloadDocVO downloadDocVO = new DownloadDocVO();
		downloadDocVO.setProjId(204);
		downloadDocVO.setRegstrId(2);
		
		try {

			//ClientRequest request = new ClientRequest(
		//"http://3.235.228.21:8080/techpediaProjectManagementService/projectservice/getpopularity");
			ClientRequest request = new ClientRequest(
					"http://localhost:8080/techpediaProjectManagementService/projectservice/getallmentors");
			
			String jsonOutput = gson.toJson(facultyVO);
			System.out.println("Input in JSON format :::::" + jsonOutput);
			//System.out.println("Input in JSON format 2 :::::" + strJson);
			request.body("application/json", "1");
			request.accept("application/json");

			ClientResponse<String> response = request.post(String.class);
			BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(((String) response.getEntity()).getBytes())));
			String output;
			while ((output = br.readLine()) != null) {
				System.out.println("Output in JSON format :::::"+output);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
	
