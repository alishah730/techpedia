package com.techpedia.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.techpedia.bean.AddColgRecentNews;
import com.techpedia.bean.AddNewFaculty;
import com.techpedia.bean.AddNewTeamMember;
import com.techpedia.bean.Challenge;
import com.techpedia.bean.PasswordResetVo;
import com.techpedia.bean.Project;
import com.techpedia.bean.RegisterNewFaculty;
import com.techpedia.bean.SignInVo;
import com.techpedia.bean.SubmitAcademicProjectGyti;
//import com.techpedia.bean.SubmitAcademicProjectGyti;
import com.techpedia.bean.SubmitInnovationToGyti;
import com.techpedia.bean.UMServiceResponse;
import com.techpedia.bean.UserProfileVO;
import com.techpedia.service.DataFetch;
import com.techpedia.util.TechpediaConstants;

@Controller
public class NavigationController {

	private static final Logger logger = Logger.getLogger(NavigationController.class);

	@Value("${ip}")
	private String ip;

	@Value("${portNo}")
	private String portNo;
	
	@Value("${archive.url}")
	private String archiveUrl;

	@Autowired
	DataFetch dataFetch;

	//private String ip = "3.235.228.22";
	//private String ip = "localhost";

	//private String portNo = "8080";
	//private String portNo = "8081";

	String url = "http://"+ip+":"+portNo+"/techpedia";
	//String url = "http://localhost:8080/techpedia";

	VerifyRecaptcha verifyRecaptcha;
	String username, password;
	public String userName;
	public String regid;
	
	@RequestMapping(value = "/ajax/contactUs")
	@ResponseBody
	public String contactUs(ModelMap model, @RequestParam String username, @RequestParam String emailId, @RequestParam String message) throws Exception {
		String jsonRequest = "{\"username\":\"" + username + "\",\"emailId\":\"" + emailId + "\",\"message\":\"" + message + "\"}";
		logger.info("--Request for Contact Us--"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/contactUs", jsonRequest);
		logger.info("---Contact Us--json response-"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeTeams", method = RequestMethod.POST)
	public @ResponseBody
	String getChallengeTeams(ModelMap model, @RequestParam String challengeID) throws Exception {
		String jsonResponse = dataFetch.getChallengeTeams("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getChallengeTeams", challengeID);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/facultyInitiateProject")
	@ResponseBody
	public String facultyInitiateProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\"}";
		logger.info("---faculty initiate project--json Request-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/facultyinitiatedproject", jsonRequest);
		logger.info("---faculty initiate project--json response-"+response);
		return response;
	}


	@RequestMapping(value = "/ajax/facultyRejectedProject")
	@ResponseBody
	public String facultyRejectedProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus,@RequestParam String rejectReason) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\",\"rejectReason\":\"" + rejectReason +"\"}";
		logger.info("---faculty Reject project--json Request-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/facultyRejectedProject", jsonRequest);
		logger.info("---faculty Reject project--json response-"+response);
		return response;
	}

	/*@RequestMapping(value = "/ajax/facultyCloseProject")
	@ResponseBody
	public String facultyCloseProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\"}";
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/facultyclosedproject", jsonRequest);
		return response;
	}*/

	@RequestMapping(value = "/ajax/facultyMarkedProjectAsCompleted")
	@ResponseBody
	public String facultyCloseProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus,@RequestParam String projectGrade,@RequestParam String projectNotes) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\",\"projGrade\":\"" + projectGrade + "\",\"projFacNotes\":\"" + projectNotes + "\"}";
		logger.info("-facultyMarkedProjectAsCompleted-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/facultyMarkedProjectAsCompleted", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/requestToBeMentor")
	@ResponseBody
	public String requestToBeMentor(ModelMap model, @RequestParam String projId, @RequestParam String teamId, @RequestParam String mentorRegstrId,@RequestParam String mentorEmailId,@RequestParam String mentorFirstName,@RequestParam String mentorLastName) throws Exception {
		String jsonRequest = "{\"projId\":\"" + projId + "\",\"teamId\":\"" + teamId + "\",\"mentorRegstrId\":\"" + mentorRegstrId + "\",\"mentorEmailId\":\"" + mentorEmailId + "\",\"mentorFirstName\":\"" + mentorFirstName +   "\",\"mentorLastName\":\"" + mentorLastName + "\"}";
		logger.info("-requestToBeMentor-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/requestToBeMentor", jsonRequest);
		logger.info("-requestToBeMentor response-"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/approveMentorRequest")
	@ResponseBody
	public String approveMentorRequest(ModelMap model, @RequestParam String approvalStatus, @RequestParam String projId, @RequestParam String teamId,@RequestParam String mentorRegstrId,@RequestParam String mentorEmailId,@RequestParam String mentorFirstName,@RequestParam String mentorLastName,@RequestParam String teamLeaderEmailId,@RequestParam String teamLeaderFname,@RequestParam String teamLeaderMname,@RequestParam String teamLeaderLname,@RequestParam String declineComments) throws Exception {
		String jsonRequest = "{\"approvalStatus\":\"" + approvalStatus + "\",\"projId\":\"" + projId + "\",\"teamId\":\"" + teamId + "\",\"mentorRegstrId\":\"" + mentorRegstrId + "\",\"mentorEmailId\":\"" + mentorEmailId + "\",\"mentorFirstName\":\"" + mentorFirstName + "\",\"mentorLastName\":\"" + mentorLastName + "\",\"teamLeaderEmailId\":\"" + teamLeaderEmailId + 
				"\",\"teamLeaderFname\":\"" + teamLeaderFname + "\",\"teamLeaderMname\":\"" + teamLeaderMname + "\",\"teamLeaderLname\":\"" + teamLeaderLname + "\",\"declineComments\":\"" + declineComments +"\"}";
		logger.info("-approveMentorRequest-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/approveOrDeclineMentorRequest", jsonRequest);
		logger.info("-approveMentorRequest response-"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/declineMentorRequest")
	@ResponseBody
	public String declineMentorRequest(ModelMap model, @RequestParam String approvalStatus, @RequestParam String projId, @RequestParam String teamId,@RequestParam String mentorRegstrId,@RequestParam String mentorEmailId,@RequestParam String mentorFirstName,@RequestParam String mentorLastName,@RequestParam String teamLeaderEmailId,@RequestParam String teamLeaderFname,@RequestParam String teamLeaderMname,@RequestParam String teamLeaderLname,@RequestParam String declineComments) throws Exception {
		String jsonRequest = "{\"approvalStatus\":\"" + approvalStatus + "\",\"projId\":\"" + projId + "\",\"teamId\":\"" + teamId + "\",\"mentorRegstrId\":\"" + mentorRegstrId + "\",\"mentorEmailId\":\"" + mentorEmailId + "\",\"mentorFirstName\":\"" + mentorFirstName + "\",\"mentorLastName\":\"" + mentorLastName + "\",\"teamLeaderEmailId\":\"" + teamLeaderEmailId + 
				"\",\"teamLeaderFname\":\"" + teamLeaderFname + "\",\"teamLeaderMname\":\"" + teamLeaderMname + "\",\"teamLeaderLname\":\"" + teamLeaderLname + "\",\"declineComments\":\"" + declineComments +"\"}";
		logger.info("-DeclineMentorRequest-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/approveOrDeclineMentorRequest", jsonRequest);
		logger.info("-DeclineMentorRequest response-"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/modifyProjectReason")
	@ResponseBody
	public String modifyProjectReason(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus,String rejectReason) throws Exception {
		logger.info("-Reason-"+rejectReason);
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus  + "\",\"rejectReason\":\"" + rejectReason + "\"}";
		logger.info("-modifyProjectReason-"+jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/facultyMarkedProjectAsCompleted", jsonRequest);
		return response;
	}

	/*Filter project according to status starts here*/


	@RequestMapping(value="/filterProjectcompleted",method = RequestMethod.POST)
	@ResponseBody
	public String filterProject(ModelMap model,@RequestParam String regstrId,HttpServletRequest request) throws Exception{
		//String json="{\"regstrId\":" + regstrId+"}";
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));

		String jsonResponse=dataFetch.statusCompleted("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getCompletedProjectByLoggedInUser",registerId);
		return jsonResponse;
	}
	@RequestMapping(value="/filterProjectworking",method = RequestMethod.POST)
	@ResponseBody
	public String filterProjectworking(ModelMap model,@RequestParam String regstrId,HttpServletRequest request) throws Exception{
		//String json="{\"regstrId\":" + regstrId+"}";
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));

		String jsonResponse=dataFetch.statusWorking("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getWorkingProjectByLoggedInUser",registerId);
		return jsonResponse;
	}

	/*Filter project according to status ends here*/



	@RequestMapping(value = "/ajax/changeImage")
	@ResponseBody
	public String changeImage(ModelMap model, @RequestParam String registerId, @RequestParam String imageName ,@RequestParam String photoByteArray) throws Exception {
		String jsonRequest = "{\"registerId\": \"" + registerId + "\",\"imgName\":\"" + imageName +  "\",\"imgByteArray\":\"" + photoByteArray + "\"}";
		logger.info("saveImage="+jsonRequest);
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updatePhoto", jsonRequest);

		if (jsonResponse.contains("success"))
			return "Y";
		else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
	}

	@RequestMapping(value = "/ajax/changeFacImage")
	@ResponseBody
	public String changeFacImage(ModelMap model, @RequestParam String photoByteArray) throws Exception {


		String jsonRequest = "{\"registerID\": \"" + regid + "\",\"photoByteStream\":\"" + photoByteArray + "\"}";
		logger.info("fac Change Imafe"+jsonRequest);
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updatePhoto", jsonRequest);
		if (jsonResponse.contains("success"))
			return "Y";
		else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
	}


	@RequestMapping(value = "/ajax/forgotPassword")
	@ResponseBody
	public String forgotPassword(ModelMap model, @RequestParam String token) throws Exception {
		logger.info("forgotPassword: token:" + token);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/forgotPassword?email=" + token, "");
		logger.info(response);
		return response;
	}

	@RequestMapping(value = "/ajax/getProjectMentors")
	@ResponseBody
	public String getProjectMentors(ModelMap model, @RequestParam String projectId) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/mentorsOfProject?projId=" + projectId, "");
		return response;
	}

	@RequestMapping(value = "/ajax/getcollegeFacultyList")
	@ResponseBody
	public String getcollegeFacultyList(ModelMap model, @RequestParam String collegeName) throws Exception {
		String college = collegeName;
		college = URLEncoder.encode(college, "UTF-8"); 
		logger.info("encoded getcollegeFacultyList college=="+college);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getcollegeFacultyList?cName=" +college, "");
		logger.info("faculties data==="+response);
		return response;
	}

	@RequestMapping(value = "/ajax/deleteMentorFromProject")
	@ResponseBody
	public String deleteMentorFromProject(ModelMap model, @RequestParam String projectId, @RequestParam String mentorId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"mentorRgstrId\":" + mentorId + "}";
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/deletementor", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/addMentorToProject")
	@ResponseBody
	public String addMentorToProject(ModelMap model, @RequestParam String projectId, @RequestParam String mentorId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"mentorRgstrId\":" + mentorId + "}";
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/addnewmentor", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/pitchProjectSearch")
	@ResponseBody
	public String pitchProjectSearch(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/searchForMentors?projId=" + projectId +"&registerID=" +registerId, "");
		logger.info("----pitch project Response---"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/fetchHomePageMentors")
	@ResponseBody
	public String fetchHomePageMentors(ModelMap model) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getPopularMentorList", "");
		return response;
	}

	@RequestMapping(value = "/ajax/deleteProjectDocument")
	@ResponseBody
	public String deleteProjectDocument(ModelMap model, @RequestParam String projectId, @RequestParam String registerId, @RequestParam String documentName) throws Exception {
		String jsonRequest = "{\"regstrId\":" + registerId + ",\"projId\":" + projectId + ",\"docName\":\"" + documentName + "\"}";

		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/deleteprojectdocument", jsonRequest);

		return response;
	}

	@RequestMapping(value = "/ajax/getRecentNews")
	@ResponseBody
	public String getRecentNews(ModelMap model) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getRecentNews", "");
		return response;
	}

	@RequestMapping(value = "/ajax/getCollegeRecentNews")
	@ResponseBody
	public String getCollegeRecentNews(ModelMap model,HttpServletRequest request,@RequestParam String collegeName) throws Exception {
		logger.info("collegeName=="+collegeName);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCollegeRecentNews", collegeName);
		logger.info("collegeName response==="+response);
		return response;
	}

	/*@RequestMapping(value = "/ajax/activateProfile")
	@ResponseBody
	public String activateProfile(ModelMap model, @RequestParam String userID) throws Exception {


		String response = dataFetch.activateProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/activateProfile?userID="+userID,userID);

		return "activateProfile";
	}
	 */
	@RequestMapping(value = "/activateProfile")

	public String activateUserProfile(ModelMap model, @RequestParam String userID) throws Exception {

		//model = dataFetch.fetchFooter(model, url);
		model.addAttribute("result","Activated succesfully");
		String response = dataFetch.activateProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/activateProfile?userID="+userID,userID);
		if (response.contains("success"))
		{
			model.addAttribute("result","Congratulations!! Your Profile has been Activated succesfully");

		}
		else 
		{
			model.addAttribute("result","Failed to activate , please visit after sometime!!");
		}
		return "activateProfile";
	}



	@RequestMapping(value = "/ajax/getProjectDocuments")
	@ResponseBody
	public String getProjectDocuments(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + "}";
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/downloadprojectdocument", jsonRequest);
		logger.info("getProjectDocuments----" + response );
		return response;
	}

	@RequestMapping(value = "/ajax/deleteChallengeDocument")
	@ResponseBody
	public String deleteChallengeDocument(ModelMap model, @RequestParam String challengeId, @RequestParam String registerId, @RequestParam String documentName) throws Exception {
		String jsonRequest = "{\"regstrId\":" + registerId + ",\"challengeId\":" + challengeId + ",\"docName\":\"" + documentName + "\"}";
		String response = dataFetch.deleteChallengeDocument("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/deletechallengedocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeDocuments")
	@ResponseBody
	public String getChallengeDocuments(ModelMap model, @RequestParam String challengeId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"regstrId\":" + registerId + "}";
		String response = dataFetch.getChallengeDocuments("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/downloadchallengedocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeComments", method = RequestMethod.POST)
	public @ResponseBody
	String getChallengeComments(ModelMap model, @RequestParam String challengeId, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"challengeId\":\"" + challengeId + "\",\"iterationCount\":\"" + set + "\"}";
		logger.info("getChallengeComments==="+jsonRequest);
		String jsonResponse = dataFetch.getPublicComments("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getChallengeComments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/checkChallengeFollow ", method = RequestMethod.POST)
	public @ResponseBody
	String checkChallengeFollow(ModelMap model, @RequestParam String challengeId, @RequestParam String userRgstrNo) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"userRgstrNo\":" + userRgstrNo + "}";
		String jsonResponse = dataFetch.doesUserFollowProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/checkChallengeFollow", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/followthechallenge", method = RequestMethod.POST)
	public @ResponseBody
	String followthechallenge(ModelMap model, @RequestParam String challengeId, @RequestParam String userRgstrNo) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"userRgstrNo\":" + userRgstrNo + "}";
		String jsonResponse = dataFetch.followProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/followthechallenge", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/removeChallengeFollow", method = RequestMethod.POST)
	public @ResponseBody
	String removeChallengeFollow(ModelMap model, @RequestParam String challengeId, @RequestParam String userRgstrNo) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"userRgstrNo\":" + userRgstrNo + "}";
		String jsonResponse = dataFetch.followProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/removeChallengeFollow", jsonRequest);
		return jsonResponse;
	}


	@RequestMapping(value = "/ajax/addcomment ", method = RequestMethod.POST)
	public @ResponseBody
	String addcomment (ModelMap model, @RequestParam String challengeId, @RequestParam String registerId, @RequestParam String comment) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"regstrId\":" + registerId + ",\"challengeComment\":\"" + comment + "\"}";
		String jsonResponse = dataFetch.postComment("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/addcomment", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/deleteChallengeComments", method = RequestMethod.POST)
	public @ResponseBody
	String deleteChallengeComments(ModelMap model, @RequestParam String challengeId, @RequestParam String commentId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"commentId\":" + commentId + ",\"rgstrId\":" + registerId + "}";
		logger.info("delete comment request:---" + jsonRequest);
		String jsonResponse = dataFetch.deleteComment("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/deleteChallengeComments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/projectSpotlightLoad", method = RequestMethod.POST)
	public @ResponseBody
	String projectSpotlight(ModelMap model) throws Exception {
		String jsonResponse = dataFetch.projectSpotlight("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectfollowers", "");
		return jsonResponse;
	}

	//project macro branches load
	@RequestMapping(value = "/projectsMacroBranchesLoad", method = RequestMethod.POST)
	public @ResponseBody
	String projectMacroBranchesLoad(ModelMap model) throws Exception {
		String jsonResponse = dataFetch.projectMacrobranchLoad("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getProjectMacroBranch", "");
		logger.info("macro branch responce==::"+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/recentProjectSpotlightLoad", method = RequestMethod.POST)
	public @ResponseBody
	String recentProjectSpotlightLoad(ModelMap model) throws Exception {
		String jsonResponse = dataFetch.recentProjectSpotlight("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getRecentproject", "");
		return jsonResponse;
	}

	@RequestMapping(value = "/latestProjectSpotlightLoad", method = RequestMethod.POST)
	public @ResponseBody
	String latestProjectSpotlightLoad(ModelMap model) throws Exception {
		logger.info("latestProjectSpotlightLoad");
		String jsonResponse = dataFetch.recentProjectSpotlight("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getLatestproject", "");
		return jsonResponse;
	}

	@RequestMapping(value = "ajax/getCollegeRecentProjects", method = RequestMethod.POST)
	public @ResponseBody
	String getCollegeRecentProjects(ModelMap model,HttpServletRequest request,@RequestParam String collegeName) throws Exception {
		logger.info("encoded getCollegeRecentProjects collegeName=="+collegeName);
		String jsonResponse = dataFetch.recentProjectSpotlight("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getCollegeRecentProjects",collegeName );
		logger.info("getCollegeRecentProjects response=="+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public String teams(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "teams";
	}

	// JsonRequest
	@RequestMapping(value = "/ajax/uploadProjectDocument", method = RequestMethod.POST)
	public @ResponseBody
	String uploadProjectDocument(ModelMap model, @RequestParam String registerId, @RequestParam String projectId, @RequestParam String documentName, @RequestParam String documentBase64) throws Exception {
		String jsonRequest = "{\"rgstrId\":" + registerId + ",\"projId\":" + projectId + ",\"docName\":\"" + documentName + "\",\"docByteArray\":\"" + documentBase64 + "\"}";
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/uploadprojectdocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/uploadChallengeDocument", method = RequestMethod.POST)
	public @ResponseBody
	String uploadChallengeDocument(ModelMap model, @RequestParam String registerId, @RequestParam String challengeId, @RequestParam String documentName, @RequestParam String documentBase64) throws Exception {
		String jsonRequest = "{\"rgstrId\":" + registerId + ",\"challengeId\":" + challengeId + ",\"docName\":\"" + documentName + "\",\"docByteArray\":\"" + documentBase64 + "\"}";
		String jsonResponse = dataFetch.uploadChallengeDocument("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/uploadchallengedocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/submitProject", method = RequestMethod.POST)
	public @ResponseBody
	String submitProject(ModelMap model, @RequestParam String projectId, @RequestParam String status) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"status\":" + status + "}";
		String jsonResponse = dataFetch.submitProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/submitproject", jsonRequest);
		logger.info("submit---"+ jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/resubmitProject", method = RequestMethod.POST)
	public @ResponseBody
	String resubmitProject(ModelMap model, @RequestParam String projectId) throws Exception {
		logger.info("resubmit projectId---"+ projectId);
		String jsonResponse = dataFetch.submitProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/resubmitProject", projectId);
		logger.info("resubmit response---"+ jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getPopularity", method = RequestMethod.POST)
	public @ResponseBody
	String getPopularity(ModelMap model, @RequestParam String registerId) throws Exception {
		String jsonResponse = dataFetch.getPopularity("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getpopularity", registerId);
		if (jsonResponse.equalsIgnoreCase("N")) {
			jsonResponse = "0";
		}
		jsonResponse = "90";
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/addTeamMember", method = RequestMethod.POST)
	public @ResponseBody
	String addTeamMember(ModelMap model, @RequestParam String registerId, @RequestParam String projectId, @RequestParam String teamId) throws Exception {
		String json = "[{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"teamId\":" + teamId + "}]";
		String jsonResponse = dataFetch.addTeamMember("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/addteammembers", json);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/removeTeamMember", method = RequestMethod.POST)
	public @ResponseBody
	String removeTeamMember(ModelMap model, @RequestParam String registerId, @RequestParam String projectId, @RequestParam String teamId) throws Exception {
		String json = "[{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"teamId\":" + teamId + "}]";
		String jsonResponse = dataFetch.removeTeamMember("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/removeteammembers", json);
		return jsonResponse;
	}

	@RequestMapping(value = "/repalceTeamLead", method = RequestMethod.POST)
	public @ResponseBody
	String replaceTeamLead(ModelMap model, @RequestParam String teamId, @RequestParam String regstrId) throws Exception{
		logger.info(" Replace Inside navigation");
		String json="{\"teamId\":"+teamId+",\"regstrId\":" + regstrId+"}";
		logger.info("Inside navigation"+teamId);

		logger.info("JSON value===="+json);

		String jsonResponse=dataFetch.replaceTeamLead("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/replaceTeamLead",json);

		logger.info("Replace response -------" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getTeamsListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getTeamsListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String url = "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserTeamList?registerID=" + registerId;
		String jsonResponse = dataFetch.getTeamsListForOneUser(url, "");
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/emailVerification", method = RequestMethod.POST)
	@ResponseBody
	public String emailVerification(ModelMap model,@RequestParam String emailId, HttpServletRequest request) throws Exception {
		logger.info("email" + emailId);
		String url = "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/emailVerification?email=" + emailId;
		String response = dataFetch.emailVerification(url,emailId);
		String statusmsg ="";
		logger.info("---response of email Verification---"+response);
		if(response.contains("success")){
			String loginurl = "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/socialSignIn?email="+emailId;
			String jsonResponse = dataFetch.socialSignIn(loginurl,"");
			logger.info("User Profile data: " + jsonResponse);
			logger.info("result of exception==="+jsonResponse.contains("exception"));
			if (!jsonResponse.contains("exception")) {
				logger.info("inside if.....");
				HttpSession session = request.getSession(true);
				ObjectMapper mapper = new ObjectMapper();
				UserProfileVO user = mapper.readValue(jsonResponse, UserProfileVO.class);
				logger.info("Login response mapped to java object : " + user.toString());
				session.setAttribute("usertype", user.getUserType());
				session.setAttribute("username", user.getUserName());
				session.setAttribute("firstname", user.getFirstName());
				session.setAttribute("lastname", user.getLastName());
				session.setAttribute("id", user.getRgstrId());
				String photo = user.getPhoto();
				boolean isEmpty = photo == null || photo.trim().length() == 0;
				if (isEmpty)
					session.setAttribute("photo", "images/UserDefault.jpg");
				else {
					if (photo.contains("data:"))
						session.setAttribute("photo", photo);
					else
						session.setAttribute("photo", "data:image/jpeg;base64," + photo);
				}
				statusmsg= "success";
			} else {
				logger.info("inside else.....");
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				statusmsg = serviceResponse.getExceptionDetails();
			}

		}else if(response.contains("exception")){
			logger.info("inside main else.....");
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(response, UMServiceResponse.class);
			statusmsg = serviceResponse.getExceptionDetails();
		}
		logger.info("statusmsg===="+statusmsg);
		return statusmsg;

	}

	@RequestMapping(value = "/teamDetails{id}")
	public String teamDetails(ModelMap model, @PathVariable int id, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("teamId", String.valueOf(id));

		return "teamDetails";
	}

	@RequestMapping(value = "/ajax/teamDetailsLoad")
	public @ResponseBody
	String teamDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String teamId = (String) session.getAttribute("teamId");
		String response = dataFetch.fetchteamDetails("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getdetailofteam", teamId, model);
		logger.info("---response of team Details---"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/teamDetailsLoadfordownload")
	public @ResponseBody
	String teamDetailsLoadfordownload(ModelMap model, @RequestParam String teamId, HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();
		//String teamId = (String) session.getAttribute("teamId");
		String response = dataFetch.fetchteamDetails("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getdetailofteam", teamId, model);
		logger.info("---response of team DetailsteamDetailsLoadfordownload---"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getChallengeListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.getChallengeListForOneUser("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getchallengesbyloggedinuser", registerId);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getProjectListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getProjectListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.getProjectListForOneUser("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectsbyLoggedinuser", registerId);
		logger.info("pitch -----:"+ jsonResponse );
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getAllGytiProjectByLoggedInUser ", method = RequestMethod.POST)
	public @ResponseBody
	String getAllGytiProjectByLoggedInUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.getProjectListForOneUser("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getAllGytiProjectByLoggedInUser", registerId);
		logger.info("LoggedIn User Gyti Projects -----:"+ jsonResponse );
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/projectsIFollow", method = RequestMethod.POST)
	public @ResponseBody
	String projectsIFollow(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.projectsIFollow("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getallfollowedproject", registerId);
		return jsonResponse;
	}


	@RequestMapping(value = "/ajax/challengesIFollow", method = RequestMethod.POST)
	public @ResponseBody
	String challengesIFollow(ModelMap model, HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		logger.info("ID "+ session.getAttribute("id"));
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.challengesIFollow("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getAllFollowedChallenges", registerId);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/deleteProject", method = RequestMethod.POST)
	public @ResponseBody
	String deleteProject(ModelMap model, @RequestParam String id) throws Exception {
		String jsonResponse = dataFetch.deleteProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/deleteproject", id);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/doesFollow", method = RequestMethod.POST)
	public @ResponseBody
	String doesUserFollowProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"rgstrId\":" + registerId + "}";
		String jsonResponse = dataFetch.doesUserFollowProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/checkprojectfollow", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/followProject", method = RequestMethod.POST)
	public @ResponseBody
	String followProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"userRgstrNo\":" + registerId + "}";
		String jsonResponse = dataFetch.followProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/followtheproject", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/unfollowProject", method = RequestMethod.POST)
	public @ResponseBody
	String unfollowProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"rgstrId\":" + registerId + "}";
		String jsonResponse = dataFetch.followProject("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/removeprojectfollow", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getTeamComments", method = RequestMethod.POST)
	public @ResponseBody
	String getTeamComments(ModelMap model, @RequestParam String projectId, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"projId\":\"" + projectId + "\",\"iterationCount\":\"" + set + "\"}";
		String jsonResponse = dataFetch.getTeamComments("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/displayteamcomments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getPublicComments", method = RequestMethod.POST)
	public @ResponseBody
	String getPublicComments(ModelMap model, @RequestParam String projectId, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"projId\":\"" + projectId + "\",\"iterationCount\":\"" + set + "\"}";
		logger.info("getpubliccomments=="+jsonRequest);
		String jsonResponse = dataFetch.getPublicComments("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/displayothercomments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/postComment", method = RequestMethod.POST)
	public @ResponseBody
	String postComment(ModelMap model,HttpServletRequest request, @RequestParam String projectId, @RequestParam String registerId, @RequestParam String comment,@RequestParam String CaptchaValue) throws Exception {

		String jsonRequest = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"projComment\":\"" + comment + "\"}";
		String jsonResponse=null;
		logger.info("Comment==="+comment+" "+"Captcha Value==="+CaptchaValue);

		logger.info("response==="+CaptchaValue);
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, CaptchaValue);
		logger.info("boolean"+captchaPassed);
		if(captchaPassed){
			jsonResponse = dataFetch.postComment("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/addcomment", jsonRequest);
			logger.info("Captcha passed");
			logger.info("Comment Response"+jsonResponse);
		}else{
			jsonResponse="Invalid Captcha";
			logger.info("Captcha failed");
		}

		logger.info("post public comment response=="+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/deleteComment", method = RequestMethod.POST)
	public @ResponseBody
	String deleteComment(ModelMap model, @RequestParam String projectId, @RequestParam String commentId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"commentId\":" + commentId + ",\"rgstrId\":" + registerId + "}";
		logger.info("delete comment request:---" + jsonRequest);
		String jsonResponse = dataFetch.deleteComment("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/deletecomment", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/searchProjectByKeyword", method = RequestMethod.POST)
	public @ResponseBody
	String searchProjectByKeyword(ModelMap model, @RequestParam String term, @RequestParam String set,@RequestParam String branch) throws Exception {
		String jsonRequest = "{\"term\":\"" + term + "\",\"iterationCount\":\"" + set + "\",\"branch\":\""+branch+"\"}";
		logger.info("request"+jsonRequest);
		String jsonResponse = dataFetch.searchProjectByKeyword("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/searchprojectbykeyword", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/searchChallengeByTitle", method = RequestMethod.POST)
	public @ResponseBody
	String searchChallengeByTitle(ModelMap model, @RequestParam String term, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"term\":\"" + term + "\",\"iterationCount\":\"" + set + "\"}";
		String jsonResponse = dataFetch.searchChallengeByTitle("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/searchchallengebytitle", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/addChallengeRequest")
	public @ResponseBody
	String addChallengeRequest(ModelMap model, @ModelAttribute Challenge challenge, HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		HttpSession session = request.getSession();
		logger.info("res=="+queryParam);

		String jsonResponse;
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		if (captchaPassed) {

			challenge.setRgstrId(String.valueOf((Long) session.getAttribute("id")));

			jsonResponse = dataFetch.addChallengeRequest(challenge, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/createChallenge");
			logger.info("Add CHALLENGE RESPONSE : " + jsonResponse);
			if (jsonResponse.equalsIgnoreCase("Y")) {
				return jsonResponse;
			} else if(jsonResponse.contains("success")) {
				return jsonResponse;
			}else{
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionMessage();
			}

		} else {
			jsonResponse= "Invalid Captcha";
		}
		return jsonResponse;

	}

	@RequestMapping(value = "/manageProjects")
	public String manageProjects(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "manageProjects";
	}

	@RequestMapping(value = "/manageProjectsLoad")
	@ResponseBody
	public String manageProjectsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = (String) session.getAttribute("id");
		return dataFetch.fetchManageProjects("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectsbyLoggedinuser", registerId);
	}

	@RequestMapping(value = "/changePassword")
	@ResponseBody
	public String changePassword(ModelMap model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute PasswordResetVo changePassword) throws Exception {
		HttpSession session = request.getSession(false);

		String username = (String) session.getAttribute("username");
		changePassword.setUserName(username);


		logger.info(changePassword.toString());

		if (username != null) {
			String jsonResponse = dataFetch.changePassword("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/passwordReset", changePassword);
			logger.info("CHANGE PWD RESPONSE - " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return "success";
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionDetails();
			}
		} else {
			logger.info("CHANGE PASSWORD - USERNAME NULL");
			response.sendRedirect("loginagain");
		}
		return "faliure";
	}




	@RequestMapping(value = "/setPasswordFac")
	@ResponseBody
	public String setPasswordFac(ModelMap model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute PasswordResetVo changePassword) throws Exception {



		changePassword.setUserName(userName);
		changePassword.setOldpassword("welcome12#");
		logger.info(changePassword.toString());

		if (userName != null) {
			String jsonResponse = dataFetch.setPasswordFac("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/passwordReset", changePassword);
			logger.info("SET FACULTY PWD RESPONSE - " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return "success";
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionDetails();
			}
		} else {
			logger.info("SET FACULTY PASSWORD - USERNAME NULL");
			response.sendRedirect("loginagain");
		}
		return "faliure";
	}







	@RequestMapping(value = "/getSuggestedFaculty", method = RequestMethod.GET)
	@ResponseBody
	public String getSuggestedFaculty(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		String q = (String) session.getAttribute("username");
		String response = dataFetch.getSuggestedFaculty("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getsuggestedfaculty", q);
		return response;
	}


	@RequestMapping(value = "/getSuggestedKeywords", method = RequestMethod.POST)
	@ResponseBody
	public String getSuggestedKeywords(ModelMap model, @RequestParam String q) throws Exception {
		String response = dataFetch.getSuggestedKeywords("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getsuggestedkeywords", q);
		logger.info("getSuggestedKeywords---" + response);
		return response;
	}

	@RequestMapping(value = "/getSuggestedBranches", method = RequestMethod.GET)
	@ResponseBody
	public String getSuggestedBranches(ModelMap model, @RequestParam String q) throws Exception {
		String response = dataFetch.getSuggestedBranches("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getsuggestedbranches", q);
		return response;
	}


	@RequestMapping(value = "/getUniversityList", method = RequestMethod.GET)
	public @ResponseBody String getUniversityList(ModelMap model, @RequestParam("q") String queryParam) throws Exception {
		String response = dataFetch.getUniversityList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUniversityList?uName="+queryParam, TechpediaConstants.BLANK_STRING);
		logger.info("response :"+response);
		return response;
	}

	@RequestMapping(value = "/getSuggestedCollegeList", method = RequestMethod.GET)
	public @ResponseBody String getCollegeList(ModelMap model, @RequestParam("q") String queryParam) throws Exception {
		String response = dataFetch.getCollegeList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCollegeListUser?cName="+queryParam, TechpediaConstants.BLANK_STRING);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = "/getStateList", method = RequestMethod.GET)
	public @ResponseBody String getStateList(ModelMap model, @RequestParam("q") String queryParam) throws Exception {
		logger.info("state list service call="+queryParam);
		String response = dataFetch.getStateList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getStateList?sName="+queryParam, TechpediaConstants.BLANK_STRING);
		logger.info("response : " + response);
		return response;
	}
	@RequestMapping(value = "/gytiReviewSystem/getStateList", method = RequestMethod.GET)
	public @ResponseBody String getStateListReviewSystem(ModelMap model, @RequestParam("q") String queryParam) throws Exception {
		logger.info("state list service call="+queryParam);
		String response = dataFetch.getStateList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getStateList?sName="+queryParam, TechpediaConstants.BLANK_STRING);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = "/getCityList",  method = RequestMethod.POST)
	public @ResponseBody String getCityList(ModelMap model,  @RequestParam("q") String cityText,@RequestParam("statename") String stateId) throws Exception {
		logger.info("text : " + cityText);
		logger.info("statename : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		String response = dataFetch.getCityList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCityList",json);
		logger.info("response : " + response);
		return response;
	}
	
	@RequestMapping(value = "/gytiReviewSystem/getCityList",  method = RequestMethod.POST)
	public @ResponseBody String getCityListReviewSystem(ModelMap model,  @RequestParam("q") String cityText,@RequestParam("statename") String stateId) throws Exception {
		logger.info("text : " + cityText);
		logger.info("statename : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		String response = dataFetch.getCityList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCityList",json);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = "/getCollegeList",  method = RequestMethod.POST)
	public @ResponseBody String getCollegeList(ModelMap model,  @RequestParam("q") String cityText,@RequestParam("statename") String stateId) throws Exception {
		logger.info("text==== : " + cityText);
		logger.info("statename==== : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		logger.info("getCollegeList JSON Request==== : " + json);
		String response = dataFetch.getCityList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCollegeList",json);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = "/getsuggestedchallenges", method = RequestMethod.GET)
	@ResponseBody
	public String getsuggestedchallenges(ModelMap model, @RequestParam String q) throws Exception {

		String response = dataFetch.getsuggestedchallenges("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getsuggestedchallenges", q);

		return response;
	}
	/*	@RequestMapping(value = "/addProjectRequest", method=RequestMethod.POST)
	public @ResponseBody
	String addProjectRequest(ModelMap model, @ModelAttribute Project project,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		long rgstrId = (Long) session.getAttribute("id");
		return dataFetch.addProjectRequest(project, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/createproject",rgstrId);
	}*/

	@SuppressWarnings("unused")
	@RequestMapping(value = "/addProjectRequest", method=RequestMethod.POST)
	public @ResponseBody
	String addProjectRequest(ModelMap model, @ModelAttribute Project project,HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		HttpSession session = request.getSession();

		logger.info("queryParam=="+queryParam);

		String registerID = (String) String.valueOf(session.getAttribute("id"));
		logger.info("-request-"+request);
		logger.info("project---" + project);
		String imageByteArray=project.getImgByteArray();
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);

		if (captchaPassed) {
			return dataFetch.addProjectRequest(project, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/createproject",registerID);
		} else {

			return "Invalid Captcha";

		}


		//boolean verify = VerifyRecaptcha.verify(queryParam);
		//System.out.println("VerifyRecaptcha===="+verify);

		/*if(verify){
			String registerID = (String) String.valueOf(session.getAttribute("id"));
			System.out.println("-ffsdfsd--------------"+request);
			System.out.println("project---" + project);
			return dataFetch.addProjectRequest(project, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/createproject",registerID);
		}else{
			return "Captcha Invalid";
		}*/
	}

	@RequestMapping(value = "/submitProjectToGytiRequest", method=RequestMethod.POST)
	public @ResponseBody
	String submitProjectToGytiRequest(ModelMap model, @ModelAttribute SubmitInnovationToGyti submitInnovationToGyti,HttpServletRequest request, @RequestParam("res") String queryParam) throws Exception {
		HttpSession session = request.getSession();

		String jsonResponse;
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		logger.info("captcha::"+queryParam);
		if (captchaPassed) {
			String registerID = (String) String.valueOf(session.getAttribute("id"));
			logger.info("submitInnovationToGyti request---" + submitInnovationToGyti);

			jsonResponse = dataFetch.submitProjectToGytiRequest(submitInnovationToGyti, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/submitProjectToGyti",registerID);
			logger.info("submitInnovationToGyti Response"+jsonResponse);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readValue(jsonResponse, JsonNode.class);
			JsonNode jprojId = node.get("projId");
			String projId = jprojId.asText();
			logger.info("submitInnovationToGyti projId="+projId);
			session.setAttribute("projId", projId);

		} else {

			jsonResponse="Invalid Captcha";

		}	
		return jsonResponse;
	}

	@RequestMapping(value = "/addProject", method=RequestMethod.POST)
	public @ResponseBody
	String addProject(ModelMap model, @ModelAttribute Project addProject,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();


		String registerID = (String) String.valueOf(session.getAttribute("id"));
		logger.info("-registerdID-"+registerID);
		logger.info("-request-"+request);
		logger.info("-project-" + addProject);
		return dataFetch.addProjectRequest(addProject, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/createprojectnew",registerID);


	}

	@RequestMapping(value = "/editProjectRequest", method=RequestMethod.POST)
	public @ResponseBody
	String editProjectRequest(ModelMap model, @ModelAttribute Project edit,HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("queryParam="+queryParam);
		/*boolean verify = VerifyRecaptcha.verify(queryParam);
		System.out.println("VerifyRecaptcha===="+verify);*/

		/*if(verify){
			String registerID = (String) String.valueOf(session.getAttribute("id"));
			long editprojId=Long.parseLong((String) session.getAttribute("editProjectId"));
			edit.setProjId(editprojId);

			System.out.println("-to check only request--------------"+edit);
			return dataFetch.editProjectRequest(edit, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/updateproject",registerID);
		}else{
			return "Captcha Invalid";
		}*/

		String registerID = (String) String.valueOf(session.getAttribute("id"));
		long editprojId=Long.parseLong((String) session.getAttribute("editProjectId"));
		edit.setProjId(editprojId);
		/*Date projEndDate = edit.getProjEndDate();
		System.out.println("edit projEndDate**"+projEndDate);*/

		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);

		if (captchaPassed) {
			return dataFetch.editProjectRequest(edit, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/updateproject",registerID);
		} else {

			return "Invalid Captcha";

		}
		/*	

		System.out.println("-to check only request--------------"+edit);
		return dataFetch.editProjectRequest(edit, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/updateproject",registerID);
	}*/
	}


	@RequestMapping(value = "/editNewInnovationRequest", method=RequestMethod.POST)
	public @ResponseBody
	String editNewInnovationRequest(ModelMap model, @ModelAttribute SubmitInnovationToGyti submitInnovationToGyti,HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		logger.info("====editInnovationRequest=========="+submitInnovationToGyti.getProjTitle());
		HttpSession session = request.getSession();
		String response;
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		if (captchaPassed) {
			String registerID = (String) String.valueOf(session.getAttribute("id"));
			long editprojId=Long.parseLong((String) session.getAttribute("editGytiProjectId"));
			submitInnovationToGyti.setProjId(editprojId);
			logger.info("-to check only editInnovationRequest--------------"+submitInnovationToGyti);
			response = dataFetch.editInnovationRequest(submitInnovationToGyti, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/updateGytiProject",registerID);
			logger.info("-to check only editInnovation Response--------------"+response);

		} else {
			response="Invalid Captcha";
		}
		return response;
	}



	@RequestMapping(value = "/acceptChallengeRequest")
	public @ResponseBody
	String acceptChallengeRequest(ModelMap model, @ModelAttribute Project project,HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		HttpSession session = request.getSession();
		logger.info("queryParam="+queryParam);
		boolean verify = VerifyRecaptcha.verify(queryParam);
		logger.info("VerifyRecaptcha===="+verify);

		if(verify){
			String registerID = (String) String.valueOf(session.getAttribute("id"));
			logger.info("acceptChallengeRequest"+project);
			return dataFetch.addProjectRequest(project, "http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/acceptchallenge",registerID);
		}else{
			return "Captcha Invalid";
		}
	}
	@RequestMapping(value =  {"/","/index"})
	public String index(ModelMap model, HttpServletRequest request) throws Exception {
		logger.debug("Inside Index");
		model = dataFetch.fetchFooter(model, url);
		return "index";
	}

	@RequestMapping(value = "/editProfile")
	public String editProfile(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "editProfile";
	}

	@RequestMapping(value = "/newInnovation")
	public String newInnovation(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "newInnovation";
	}


	@RequestMapping(value = "/projectByBranches")
	public String projectByBranches(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "projectByBranches";
	}



	@RequestMapping(value = "/newFaculty")
	public String newFaculty(ModelMap model, HttpServletRequest request, @RequestParam String regID,@RequestParam String usrName ) throws Exception {
		regid=regID;
		userName=usrName;
		logger.info("-userName-"+userName);
		model = dataFetch.fetchFooter(model, url);
		return "newFaculty";
	}




	@RequestMapping(value = "/editProject")
	public String editProject(ModelMap model, HttpServletRequest request, @RequestParam String id) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("editProjectId", id);
		return "editProject";
	}

	@RequestMapping(value = "/editNewInnovation")
	public String editGytiProject(ModelMap model, HttpServletRequest request, @RequestParam String id) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("editGytiProjectId", id);
		return "editNewInnovation";
	}

	@RequestMapping(value = "/editProjectLoad")
	@ResponseBody
	public String editProjectLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("editProjectId");


		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectdetails", id);
		logger.info("--edit Project ID--"+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/editGytiProjectLoad")
	@ResponseBody
	public String editGytiProjectLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("editGytiProjectId");
		logger.info("--edit Gyti Project ID--"+id);

		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getGytiProjectDetails", id);
		logger.info("--edit Gyti Project response--"+jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "ajax/editProfileLoad")
	@ResponseBody
	public String editProfileLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String registerID = (String) String.valueOf(session.getAttribute("id"));
		String response = dataFetch.fetchEditProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetailsNew", model, registerID);
		logger.info("editProfileloaddata====="+response);
		return response;
	}
	
	@RequestMapping(value = "ajax/editNewTeamMemberProfileLoad")
	@ResponseBody
	public String editNewTeamMemberProfileLoad(ModelMap model, HttpServletRequest request) throws Exception {
		logger.info("editNewTeamMemberProfileLoad regid====="+regid);
		String registerID = regid;
		String response = dataFetch.fetchEditProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, registerID);
		logger.info("editNewTeamMemberProfileLoad====="+response);
		return response;
	}

	@RequestMapping(value = "/newFacultyLoad")
	@ResponseBody
	public String newFacultyLoad(ModelMap model, HttpServletRequest request) throws Exception {


		String response = dataFetch.fetchEditProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, regid);
		return response;
	}
	@RequestMapping(value = "/editProfileRequest")
	public @ResponseBody
	String editProfileRequest(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO editProfile,@RequestParam("res") String queryParam) throws Exception {
		/*
		 * String userType = editProfile.getUserType();
		 * if(userType.equalsIgnoreCase("college")) {
		 * editProfile.setWebpage(editProfile
		 * .getWebpage().split(",")[0].toString()); } else if
		 * (userType.equalsIgnoreCase("mentor")) {
		 * editProfile.setWebpage(editProfile
		 * .getWebpage().split(",")[0].toString()); } else {
		 * editProfile.setWebpage(""); } editProfile.setPhoto("");
		 */

		/*long regId = Long.parseLong(regid);
         editProfile.setRgstrId(regId);*/
		/*		System.out.println("res=="+queryParam);
		boolean verify = VerifyRecaptcha.verify(queryParam);
		System.out.println("VerifyRecaptcha===="+verify);

		if(verify){
			HttpSession session = request.getSession(true);
			Long rgstrId = (Long) session.getAttribute("id");
			editProfile.setRgstrId(rgstrId);
			String jsonResponse = dataFetch.editProfileRequest(editProfile, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updateProfile");
			logger.info("EDIT PROFILE RESPONSE : " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return "success";
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionMessage();
			}
		}else{
			return "Captcha Invalid";
		}*/

		HttpSession session = request.getSession(true);
		Long rgstrId = (Long) session.getAttribute("id");
		editProfile.setRgstrId(rgstrId);
		String jsonResponse;
		logger.info("Captcha value::"+queryParam);
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		logger.info("editProfile Request**====="+editProfile);
		if (captchaPassed) {
			jsonResponse = dataFetch.editProfileRequest(editProfile, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updateProfile");
			logger.info("EDIT PROFILE RESPONSE : " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return jsonResponse;
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionMessage();
			}

		} else {
			jsonResponse="Invalid Captcha";
		}
		return jsonResponse;
	}


	@RequestMapping(value = "/newFacultyRequest")
	public @ResponseBody
	String newFacultyRequest(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO editProfile) throws Exception {

		/** String userType = editProfile.getUserType();
		 * if(userType.equalsIgnoreCase("college")) {
		 * editProfile.setWebpage(editProfile
		 * .getWebpage().split(",")[0].toString()); } else if
		 * (userType.equalsIgnoreCase("mentor")) {
		 * editProfile.setWebpage(editProfile
		 * .getWebpage().split(",")[0].toString()); } else {
		 * editProfile.setWebpage(""); } editProfile.setPhoto("");*/


		long regId = Long.parseLong(regid);
		editProfile.setRgstrId(regId);
		/*HttpSession session = request.getSession(true);
		Long rgstrId = (Long) session.getAttribute("id");
		editProfile.setRgstrId(rgstrId);*/
		logger.info(editProfile);
		String jsonResponse = dataFetch.newFacultyRequest(editProfile, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updateAddFacultyProfileHelper");
		logger.info("NEW FACULTY PROFILE RESPONSE : " + jsonResponse);
		if (jsonResponse.contains("success")) {
			return "success";
		} else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
	}





	@RequestMapping(value = "/IEError")
	public String IEError(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);

		return "IEError";
	} 
	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@ModelAttribute SignInVo login, HttpServletRequest request) throws Exception {
		String response = dataFetch.signIn("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/signIn", login);
		logger.info("Ajax Login request: " + login);
		logger.info("Ajax Login Response: " + response);
		if (!response.contains("exception")) {
			HttpSession session = request.getSession(true);
			ObjectMapper mapper = new ObjectMapper();
			UserProfileVO user = mapper.readValue(response, UserProfileVO.class);
			logger.info("Login response mapped to java object : " + user.toString());
			session.setAttribute("usertype", user.getUserType());
			session.setAttribute("username", user.getUserName());
			session.setAttribute("firstname", user.getFirstName());
			session.setAttribute("lastname", user.getLastName());
			session.setAttribute("middlename", user.getMidName());
			session.setAttribute("id", user.getRgstrId());
			session.setAttribute("emailid",user.getEmail());
			session.setAttribute("photopath",user.getPhotoPath());
			if(user.getUserType().equalsIgnoreCase("college")){
				session.setAttribute("collegeName", user.getCollegeName());
			}
			logger.info("Login response mapped to java object : " + session.getAttribute("usertype"));
			String photo = user.getPhoto();
			boolean isEmpty = photo == null || photo.trim().length() == 0;
			if (isEmpty)
				session.setAttribute("photo", "images/UserDefault.jpg");
			else {
				if (photo.contains("data:"))
					session.setAttribute("photo", photo);
				else
					session.setAttribute("photo", "data:image/jpeg;base64," + photo);
			}
			logger.info(user.getUserType() +"user.getUserType()");
			if(user.getUserType().equalsIgnoreCase("college")){
				return "collegeAdmin";
			}
			if(user.getUserType().equalsIgnoreCase("admin")){
				return "techAdmin";
			}
			else{
				return "success";
			}
		} else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(response, UMServiceResponse.class);
			return serviceResponse.getExceptionDetails();
		}

	}

	@RequestMapping(value = "/getId")
	@ResponseBody
	public String getRegisterIdFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return String.valueOf((Long) session.getAttribute("id"));
	}

	@RequestMapping(value = "/getUserType")
	@ResponseBody
	public String getUserTypeFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("usertype");
	}

	@RequestMapping(value = "/getUsername")
	@ResponseBody
	public String getUsernameFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}

	@RequestMapping(value = "/getFirstname")
	@ResponseBody
	public String getFirstnameFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}
	@RequestMapping(value = "/getLastname")
	@ResponseBody
	public String getLastnameFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}
	@RequestMapping(value = "/getTeamId")
	@ResponseBody
	public String getTeamIdFromSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("teamId");
	}

	/*@RequestMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "index";
	}*/

	@RequestMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession(false);
		if(session !=null){
			logger.info("session Id :: "+session.getId());
			logger.info("session Creation time 3 :: "+session.getCreationTime());
		}
		session.invalidate();
		if(session !=null){
			session = null;
		}
		return "index";
	}
	
	@RequestMapping(value = "/reviewerLogout")
	public String reviewerLogout(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession(false);
		if(session !=null){
			logger.info("session Id :: "+session.getId());
			logger.info("session Creation time 3 :: "+session.getCreationTime());
		}
		session.invalidate();
		if(session !=null){
			session = null;
		}
		return "gytiReviewSystem/reviewerLogin";
	}

	@RequestMapping(value = "/loginagain")
	public String loginagain(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "loginagain";
	}
	@RequestMapping(value = "ajax/DownloadFileLink",method = RequestMethod.POST)
	@ResponseBody
	public String DownloadFileLink( HttpServletRequest request,@RequestParam String documentLink) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("docLink", documentLink);
		//session.setAttribute("docLink", "C:/Users/826862/Desktop/edit proj1.png");

		logger.info("documentLink" + documentLink);
		return "success";
	}
	@RequestMapping(value = "/DownloadFile" )
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		/**
		 * Size of a byte buffer to read/write file
		 */
		int BUFFER_SIZE = 4096;

		/**
		 * Path of the file to be downloaded, relative to application's directory
		 */
		HttpSession session = request.getSession();
		String filePath =(String) session.getAttribute("docLink");

		logger.info("-path-" + filePath);

		/**
		 * Method for handling file download request from client
		 */
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getServerInfo();

		logger.info("appPath = " + appPath);

		// construct the complete absolute path of the file
		String fullPath =  filePath;		
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		logger.info("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}


	@RequestMapping(value = "/forgotPassword")
	public String forgotPassword(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "forgotPassword";
	}

	@RequestMapping(value = "ajax/addNewFaculty")
	@ResponseBody
	public String ajaxAddNewFaculty(ModelMap model, HttpServletRequest request, @ModelAttribute AddNewFaculty newFaculty) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequest = mapper.writeValueAsString(newFaculty);
		logger.info("ajaxAddNewFaculty: request: " + jsonRequest);
		return dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/addnewfaculty", jsonRequest);
	}

	@RequestMapping(value = "ajax/searchTeamMembers")
	@ResponseBody
	public String ajaxSearchTeamMembers(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO search) throws Exception {

		logger.info("Searchteam"+ request);
		String response = dataFetch.fetchSuggestedTeamMembers("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getsuggestedteammembers", search);
		return response;
	}

	@RequestMapping(value = "ajax/searchTeamMembersOld")
	@ResponseBody
	public String searchTeamMembersOld(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO search) throws Exception {
		String response = dataFetch.fetchSuggestedTeamMembersOld("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getsuggestedteammembers", search);
		return response;
	}

	@RequestMapping(value = "/aboutus")
	public String aboutus(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "aboutus";
	}
	@RequestMapping(value = "/collegeDetails")
	public String collegeDetails(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "collegeDetails";
	}
	/*@RequestMapping(value = "/showMentorDetails")
	public String showMentorDetails(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "showMentorDetails";
	}
	 */


	@RequestMapping(value = "/Colaboration")
	public String colaboration(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "Colaboration";
	}
	@RequestMapping(value = "/collegeAdmin")
	public String collegeAdmin(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "collegeAdmin";
	}


	/*@RequestMapping(value = "/testfb")
	public String testfb(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "testfb";
	}

	/*@RequestMapping(value = "/googleplus")
	public String googleplus(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "googleplus";
	}*/
	@RequestMapping(value = "/Error")
	public String Error(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "Error";
	}

	@RequestMapping(value = "/LinkedIn")
	public String testfb(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "LinkedIn";
	}


	/*@RequestMapping(value = "/userFetchData")
	public String userFetchData(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "userFetchData";
	}*/

	@RequestMapping(value = "/projects")
	public String projects(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "projects";
	}

	@RequestMapping(value = "/gytiProjects")
	public String gytiProjects(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "gytiProjects";
	}

	@RequestMapping(value = "/projectsFetch")
	@ResponseBody
	public String projectsFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		logger.info("iterationcount"+set);
		String response = dataFetch.fetchProjects("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getallproject", model, set);
		logger.info("Iteration count==="+set+" "+"Projects response=="+response);
		return response;
	}

	@RequestMapping(value = "/ajax/gytiProjectsFetch")
	@ResponseBody
	public String gytiProjectsFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		logger.info("iterationcount"+set);
		String response = dataFetch.fetchProjects("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getAllGytiProject", model, set);
		logger.info("Gyti Projects Fetch Response"+response);
		return response;
	}


	/*@RequestMapping(value = "/projectsDataFetch")
	@ResponseBody
	public String projectsDataFetch(ModelMap model, @RequestParam String projTeamLeaderId) throws Exception {
		String response = dataFetch.fetchEditProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, projTeamLeaderId);
		return response;
	}*/



	@RequestMapping(value = "/challenges")
	public String challenges(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "challenges";
	}

	@RequestMapping(value = "/challengesFetch")
	@ResponseBody
	public String challengesFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		String response = dataFetch.fetchChallenges("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getallchallenge", model, set);
		return response;
	}

	@RequestMapping(value = "/challengeDetails{id}")
	public String challengeDetails(ModelMap model, HttpServletRequest request, @PathVariable String id) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("challengeId", id);
		return "challengeDetails";
	}

	@RequestMapping(value = "/challengeDetailsLoad")
	public @ResponseBody
	String challengeDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String challengeId = (String) session.getAttribute("challengeId");
		String jsonResponse = dataFetch.challengeDetailsLoad("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/challengeservice/getchallengedetail", challengeId);
		return jsonResponse;
	}

	@RequestMapping(value = "/mentors")
	public String mentors(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "mentors";
	}

	@RequestMapping(value = "/mentorsFetch")
	@ResponseBody
	public String mentorsFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		String response = dataFetch.fetchMentors("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getallmentors", model, set);
		return response;
	}

	@RequestMapping(value = "/collegeDetails{name}")
	public String collegeDetails(ModelMap model, HttpServletRequest request, @PathVariable String name) throws Exception {
		//String collegeName = request.getParameter("CollegeNamesHeader");
		//ModelAndView mav =new ModelAndView("collegeDetails");
		//mav.addObject("collegeName", collegeName);
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("collegeName", name.replace("-", " "));
		return "collegeDetails";
	}

	@RequestMapping(value = "/projectByBranches{branchName}")
	public String projectByBranches(ModelMap model, @PathVariable String branchName, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("branchName", branchName);
		return "projectByBranches";
	}

	@RequestMapping(value = "/ajax/macroBranchProjectsLoad")
	public @ResponseBody
	String macroBranchProjectsLoad(ModelMap model, HttpServletRequest request,@RequestParam String set) throws Exception {
		HttpSession session = request.getSession();
		String branchName = (String) session.getAttribute("branchName");
		logger.info("macroBranchProjectsLoad branch name==" + branchName);
		/*String encodedBranchName =URLEncoder.encode(branchName, "UTF-8"); 
		logger.info("encoded macroBranchProjectsLoad branch name="+encodedBranchName);*/
		String jsonRequest = "{\"branchName\":\"" + branchName + "\",\"iterationCount\":\"" + set + "\"}";
		logger.info("macroBranchProjectsLoad request=="+jsonRequest);
		String response = dataFetch.getAllProjectsByMacroBranch("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getAllProjectsByMacroBranch",jsonRequest);
		logger.info("macroBranchProjectsLoad response" + response);
		return response;
	}

	@RequestMapping(value = "/mentorDetails{id}")
	public String mentorDetails(ModelMap model, @PathVariable String id, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("mentorId", id);
		return "mentorDetails";
	}

	@RequestMapping(value = "/ajax/mentorDetailsLoad")
	public @ResponseBody
	String mentorDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mentorId");
		String response = dataFetch.fetchMentorDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, id);
		logger.info("mentors details" + response);
		return response;
	}

	@RequestMapping(value = "/facultyDetails{id}")
	public String facultyDetails(ModelMap model, @PathVariable String id, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("facultyId", id);
		return "facultyDetails";
	}

	@RequestMapping(value = "/ajax/facultyDetailsLoad")
	public @ResponseBody
	String facultyDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("facultyId");
		String response = dataFetch.fetchfacultyDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, id);
		logger.info("faculty details" + response);
		return response;
	}
	//Student details
	@RequestMapping(value = "/studentDetails{id}")
	public String studentDetails(ModelMap model, @PathVariable String id, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("studentId", id);
		return "studentDetails";
	}

	@RequestMapping(value = "/ajax/studentDetailsLoad")
	public @ResponseBody
	String studentDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("studentId");
		String response = dataFetch.fetchStudentDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, id);
		logger.info("Student details" + response);
		return response;
	}

	@RequestMapping(value = "/showMentorDetails")
	public String showMentorDetails(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		String mentorregstrID=request.getParameter("registerID");
		String projregstrID=request.getParameter("projId");
		logger.info("projregstrID from ="+projregstrID);
		session.setAttribute("mentorId", mentorregstrID);
		session.setAttribute("projId", projregstrID);

		return "showMentorDetails";
	}
	@RequestMapping(value = "/ajax/showMentorDetailsLoad")
	public @ResponseBody
	String showMentorDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String mentorid = (String) session.getAttribute("mentorId");
		String projid = (String) session.getAttribute("projId");
		logger.info("mentor ID="+mentorid);
		logger.info("project ID="+projid);
		String response = dataFetch.fetchMentorDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", model, mentorid);
		logger.info("mentors details" + response);

		return response;
	}	

	/*@RequestMapping(value = "/showMentorDetails")
	public String showProjectDetails(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();

		String projregstrID=request.getParameter("projId");
		//System.out.println("mentorregstrID="+mentorregstrID);
		System.out.println("projregstrID from ="+projregstrID);


		session.setAttribute("projId", projregstrID);

		return "showMentorDetails";
	}*/


	@RequestMapping(value = "/showProjectDetailsLoad")
	public @ResponseBody
	String showprojectDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String projectId = (String) session.getAttribute("projId");
		logger.info("ProjectId="+projectId);
		String jsonResponse = dataFetch.fetchProjectDetail("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectdetails", projectId);
		logger.info("Show project details" + jsonResponse);
		return jsonResponse;
	}



	/*show mentor and project ends details*/


	@RequestMapping(value = "/dashboard")
	public String dashboard(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "dashboard";
	}
	@RequestMapping(value = "/Creativity")
	public String Creativity(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "Creativity";
	}

	@RequestMapping(value = "/Compassion")
	public String Compassion(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "Compassion";
	}
	@RequestMapping(value = "/addProject")
	public String addProject(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		model.addAttribute("project", new Project());
		return "addProject";
	}

	@RequestMapping(value = "/acceptChallenge", method = RequestMethod.GET)
	public String acceptChallenge(ModelMap model, @RequestParam String challengeId, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		model.addAttribute("project", new Project());

		request.setAttribute("challengeId", challengeId);

		return "addProject";
	}

	@RequestMapping(value = "/addChallenge")
	public String addChallenge(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		model.addAttribute("challenge", new Challenge());
		return "addChallenge";
	}
	@RequestMapping(value = "/manageChallenge")
	public String manageChallenge(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "manageChallenge";
	}

	@RequestMapping(value = "/register")
	public String register(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		model.addAttribute("register", new UserProfileVO());
		return "register";
	}

	@RequestMapping(value = "/socialRegister")
	public String socialRegister(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		model.addAttribute("register", new UserProfileVO());
		return "socialRegister";
	}



	@RequestMapping(value = "/registerRequest")
	public @ResponseBody
	String registerRequest(ModelMap model,HttpServletRequest request, @ModelAttribute UserProfileVO register,@RequestParam("res") String queryParam) throws Exception {
		logger.info("queryParam="+queryParam);
		String jsonResponse;
		String userType = register.getUserType();
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);

		if(captchaPassed){
			if (userType.equalsIgnoreCase("college")) {
				register.setWebpage(register.getWebpage().split(",")[0].toString());
			} else if (userType.equalsIgnoreCase("mentor")) {
				register.setWebpage(register.getWebpage().split(",")[0].toString());
			} else {
				register.setWebpage("");
			}
			logger.info("User Profile request:= "+register);
			jsonResponse = dataFetch.registerRequest(register, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/createNewProfile");
			logger.info("REGISTER PROFILE RESPONSE : " + jsonResponse);
			if (jsonResponse.contains("already")) {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionDetails();
			}
			/*jsonResponse ="success";*/
		}
		else{

			jsonResponse="Invalid Captcha";
		}
		return jsonResponse;

	}

	/*boolean verify = VerifyRecaptcha.verify(queryParam);
		System.out.println("VerifyRecaptcha===="+verify);

		if(verify){
			String userType = register.getUserType();
			if (userType.equalsIgnoreCase("college")) {
				register.setWebpage(register.getWebpage().split(",")[0].toString());
			} else if (userType.equalsIgnoreCase("mentor")) {
				register.setWebpage(register.getWebpage().split(",")[0].toString());
			} else {
				register.setWebpage("");
			}
			logger.info("User Profile request:= "+register);
			String jsonResponse = dataFetch.registerRequest(register, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/createNewProfile");
			logger.info("REGISTER PROFILE RESPONSE : " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return "success";
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionDetails();
			}

		}else{
			return "Captcha Invalid";
		}

	}

	/*codes for project photo upload starts here*/

	/*@RequestMapping(value="/uploadProjectphoto")
	public ResponseBody

	 String uploadProjectphoto(ModelMap model, @ModelAttribute Project project,@RequestParam("res") String queryParam) throws Exception{

		String jsonResponse= dataFetch.uploadProjectphoto(project,"http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/createprojectnew",registerID);	

	return jsonResponse;
	}*/



	/*codes for project photo upload ends here*/







	@RequestMapping(value = "/projectDetails{id}")
	public String detail(ModelMap model, @PathVariable String id, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("projectId", id);
		model = dataFetch.fetchFooter(model, url);
		return "detail";
	}
	@RequestMapping(value = "/projectDetailsLoad")
	public @ResponseBody
	String projectDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String projectId = (String) session.getAttribute("projectId");
		String jsonResponse = dataFetch.fetchProjectDetail("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getprojectdetails", projectId);
		logger.info("details" + jsonResponse);
		return jsonResponse;
	}


	@RequestMapping(value = "/test")
	public String test(ModelMap model) throws Exception {
		return "test";
	}

	@RequestMapping(value = "/result")
	public String result(ModelMap model) throws Exception {
		return "result";
	}

	@RequestMapping(value = "/projectId")
	@ResponseBody
	public String getProjectIdFromSession(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("projectId");
	}

	@RequestMapping(value = "ajax/BulkUploadTempDownloadFileLink",method = RequestMethod.POST)
	@ResponseBody
	public String BulkUploadTempDownloadFileLink( HttpServletRequest request) throws Exception {

		ResourceBundle rBundle = ResourceBundle.getBundle("config");
		String downloadTemplatePath = rBundle.getString("downloadTemplatePath");
		HttpSession session = request.getSession();
		session.setAttribute("docLink", downloadTemplatePath);

		logger.info("documentLink" + session.getAttribute("docLink"));
		return "success";
	}
	@RequestMapping(value = "/BulkUploadTempDownloadFile" )
	public void BulkUploadTempdoDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		/**
		 * Size of a byte buffer to read/write file
		 */
		int BUFFER_SIZE = 4096;

		/**
		 * Path of the file to be downloaded, relative to application's directory
		 */
		HttpSession session = request.getSession();
		String filePath =(String) session.getAttribute("docLink");

		logger.info("-path-" + filePath);

		/**
		 * Method for handling file download request from client
		 */
		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getServerInfo();

		logger.info("appPath = " + appPath);

		// construct the complete absolute path of the file
		String fullPath =  filePath;		
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		logger.info("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}

	@RequestMapping(value = "/bulkUploadProjectDocumentByColgAdmn", method = RequestMethod.POST)
	public @ResponseBody
	String bulkUploadByColgAdmin(ModelMap model, @RequestParam String bulkDocumentBase64) throws Exception {
		//String jsonRequest = "{\"rgstrId\":" + registerId + ",\"projId\":" + projectId + ",\"docName\":\"" + documentName + "\",\"Base64 exlByteArray\":\"" + documentBase64 + "\"}";
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/bulkuploadproject", bulkDocumentBase64);
		logger.info("Bulk uplaod response::"+jsonResponse);
		return jsonResponse;
	}


	@RequestMapping(value = "/ajax/getCollegeRecentNewsAdmin")
	@ResponseBody
	public String getCollegeRecentNewsAdmin(ModelMap model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String collegeName = (String) session.getAttribute("collegeName");
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCollegeRecentNewsAdmin", collegeName);
		logger.info("College News response"+response);
		return response;
	}

	@RequestMapping(value="/ajax/deletCollegeRecentNewsAdmin")
	@ResponseBody
	public String deleteCollegeNewsAdmin(ModelMap model,HttpServletRequest request,@RequestParam String newsId){
		String newsID=newsId;
		logger.info("NavigationController.deleteCollegeNewsAdmin() news ID::"+ newsId);
		String response=dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/deleteCollegeNews", newsID);
		logger.info("Response of delete news::"+response);
		return response;
	}

	@RequestMapping(value="/ajax/addCollegeRecentNewsAdmin", method = RequestMethod.POST)
	@ResponseBody
	public String addCollegeNewsAdmin(ModelMap model,@ModelAttribute AddColgRecentNews addColgRcntNews,HttpServletRequest request){
		HttpSession session = request.getSession();
		String collegeName = (String) session.getAttribute("collegeName");
		addColgRcntNews.setColgName(collegeName);
		logger.info("NavigationController.addCollegeNewsAdmin() news ID ::"+ addColgRcntNews);
		String response=dataFetch.addColgRecentNews("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/addCollegeRecentNews", addColgRcntNews);
		logger.info("Response of adding news::"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/getActiveCollegeRecentNewsAdmin")
	@ResponseBody
	public String getActiveCollegeRecentNewsAdmin(ModelMap model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String collegeName = (String) session.getAttribute("collegeName");
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getActiveCollegeRecentNewsAdmin", collegeName);
		logger.info("College active News response"+response);
		return response;
	}

	@RequestMapping(value = "/ajax/getInActiveCollegeRecentNewsAdmin")
	@ResponseBody
	public String getInActiveCollegeRecentNewsAdmin(ModelMap model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String collegeName = (String) session.getAttribute("collegeName");
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getInActiveCollegeRecentNewsAdmin", collegeName);
		logger.info("College Inactive News response"+response);
		return response;
	}

	@RequestMapping(value = "/additionalInfoGyti")
	public String additionalInfoGyti(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);

		return "additionalInfoGyti";
	}
	@RequestMapping(value = "/additionalInfoGyti{projId}")
	public String additionalInfoGyti(ModelMap model, @PathVariable String projId, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("projId", projId);
		return "additionalInfoGyti";
	}

	@RequestMapping(value = "/submitAcademicProjectToGytiservice", method = RequestMethod.POST)
	public @ResponseBody
	String submitAcademicProjectToGyti (ModelMap model,@ModelAttribute SubmitAcademicProjectGyti submitAcademicProjectToGyti,HttpServletRequest request,@RequestParam("res") String queryParam) throws Exception {
		logger.info("Inside anvigation controller:::111");
		HttpSession session = request.getSession();
		String projId=session.getAttribute("projId").toString();
		submitAcademicProjectToGyti.setProjId(projId);
		String jsonRequest = "{\"submitAcademicProjectToGyti\":\"" +submitAcademicProjectToGyti + "\"}";
		logger.info("Inside anvigation controller:::"+jsonRequest);
		String jsonResponse;
		logger.info("Inside anvigation controller captcha value:::"+queryParam);
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		if (captchaPassed) {
			jsonResponse = dataFetch.submitAcademicProjectToGyti("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/submitAcademicProjectToGyti", submitAcademicProjectToGyti);
			logger.info("Response::"+jsonResponse);
		}else{
			jsonResponse="Invalid Captcha";
			logger.info("captcha failed");
		}
		return jsonResponse;	
	}

	@RequestMapping(value = "/ajax/uploadMultipleProjectDocument", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleProjectDocument(ModelMap model,HttpServletRequest request, @RequestParam String registerId, @RequestParam String documentMap) throws Exception {
		HttpSession session = request.getSession();
		String projectId =(String) session.getAttribute("projId");
		String jsonRequest = "{\"rgstrId\":" + registerId + ",\"projId\":" + projectId + ",\"documentMap\":" + documentMap + "}";
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/uploadMultipleProjectDocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/uploadMultipleProjectDocumentForManageProject", method = RequestMethod.POST)
	public @ResponseBody
	String uploadMultipleProjectDocumentForManageProject(ModelMap model,@RequestParam String registerId,@RequestParam String projectId, @RequestParam StringBuffer documentMap) throws Exception {
		String jsonRequest = "{\"rgstrId\":" + registerId + ",\"projId\":" + projectId + ",\"documentMap\":" + documentMap + "}";
		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/uploadMultipleProjectDocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getLatestGytiProject", method = RequestMethod.POST)
	public @ResponseBody
	String getLatestGytiProject(ModelMap model) throws Exception {
	logger.info("getLatestGytiProject");
	String jsonResponse = dataFetch.recentProjectSpotlight("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getLatestGytiProject", "");
	logger.info("getLatestGytiProject::"+jsonResponse);
	return jsonResponse;
	}
	
	@RequestMapping(value="/techAdmin")
	public ModelAndView techAdmin( ModelMap model){
		ModelAndView mav=new ModelAndView("techAdmin");
		return mav;
		
	}
	
	@RequestMapping(value="/techpediaArchive")
	public ModelAndView gytiArchive(ModelMap model , HttpServletRequest request){
		ModelAndView mav=new ModelAndView("techpediaArchive");
			mav.addObject("archiveUrl",archiveUrl);
			return mav;
	
	}

	@RequestMapping(value ="/techpediaArchiveData" , method=RequestMethod.GET)
	@ResponseBody
	public List<String> gytiArchive(HttpServletRequest request, HttpServletResponse response) throws Exception {
		File folder = new File(archiveUrl);
		File[] listOfFiles = folder.listFiles();
		List<String> fileNames = new ArrayList<String>();
		logger.info("Files List" + listOfFiles);
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  fileNames.add(listOfFiles[i].getName());
		        //logger.info("File " + listOfFiles[i].getName());
		      } /*else if (listOfFiles[i].isDirectory()) {
		        logger.info("Directory " + listOfFiles[i].getName());
		      }*/
		    }
	    logger.info("Files List :: " + fileNames);
		return fileNames;
	}
	@RequestMapping(value="/techpediaArchiveDataDownloadFileName")
	public @ResponseBody
	String DownloadFileLinkTechArchive( HttpServletRequest request,@RequestParam("fileName") String fileName ) throws Exception {
		logger.info("file name :: "+fileName);
		HttpSession session = request.getSession(false);
		session.setAttribute("fileName", fileName);
		logger.info("documentLink" + fileName);
		return "\"\"";
	}
	
	
	@RequestMapping(value="/downloadTechpediaArchiveFile")
	
	public void techpediaArchiveDownload(HttpServletRequest request,HttpServletResponse response ) throws Exception{
		/**
				 * Size of a byte buffer to read/write file
				 */
				int BUFFER_SIZE = 4096;

				/**
				 * Method for handling file download request from client
				 */
				HttpSession session = request.getSession(false);

				String fileName =(String) session.getAttribute("fileName");
				// get absolute path of the application
				ServletContext context = request.getServletContext();
				String appPath = context.getServerInfo();

				logger.info("appPath = " + appPath);

				// construct the complete absolute path of the file
				String fullPath = archiveUrl +"/"+fileName;		
				File downloadFile = new File(fullPath);
				FileInputStream inputStream = new FileInputStream(downloadFile);

				// get MIME type of the file
				String mimeType = context.getMimeType(fullPath);
				if (mimeType == null) {
					// set to binary type if MIME mapping not found
					mimeType = "application/octet-stream";
				}
				logger.info("MIME type: " + mimeType);

				// set content attributes for the response
				response.setContentType(mimeType);
				response.setContentLength((int) downloadFile.length());

				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"",
						downloadFile.getName());
				response.setHeader(headerKey, headerValue);

				// get output stream of the response
				OutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				// write bytes read from the input stream into the output stream
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inputStream.close();
				outStream.close();
	}
	
	@RequestMapping(value = "/getDegreeList", method = RequestMethod.GET)
	public @ResponseBody String getDegreeList(ModelMap model, @RequestParam("q") String queryParam) throws Exception {
		logger.info("getDegreeList service call="+queryParam);
		String response = dataFetch.getDegreeList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getDegreeList", queryParam);
		logger.info("getDegreeList response : " + response);
		return response;
	}
	
	@RequestMapping(value = "ajax/addNewTeamMember")
	@ResponseBody
	public String ajaxAddNewTeamMember(ModelMap model, HttpServletRequest request, @ModelAttribute AddNewTeamMember newTeamMember) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequest = mapper.writeValueAsString(newTeamMember);
		logger.info("addNewTeamMember: request: " + jsonRequest);
		return dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/addNewTeamMember", jsonRequest);
		
	}
	
	@RequestMapping(value = "ajax/registerNewFaculty")
	@ResponseBody
	public String registerNewFaculty(ModelMap model, HttpServletRequest request, @ModelAttribute RegisterNewFaculty newFaculty) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequest = mapper.writeValueAsString(newFaculty);
		logger.info("registerNewFaculty: request: " + jsonRequest);
		return dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/registerNewFaculty", jsonRequest);
		
	}
	
	
	
	@RequestMapping(value = "/newTeamMember")
	public String newTeamMember(ModelMap model, HttpServletRequest request, @RequestParam String regID,@RequestParam String usrName ) throws Exception {
		regid=regID;
		userName=usrName;
		logger.info("-userName-"+userName);
		model = dataFetch.fetchFooter(model, url);
		return "newTeamMember";
	}
	
	@RequestMapping(value = "/editTeamMemberProfileRequest")
	public @ResponseBody
	String editTeamMemberProfileRequest(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO editProfile,@RequestParam("res") String queryParam) throws Exception {
		logger.info("register Id::"+editProfile.getRgstrId());
		//editProfile.setRgstrId(editProfile.getRgstrId());
		String jsonResponse;
		logger.info("Captcha value::"+queryParam);
		boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, queryParam);
		logger.info("editProfile Request**====="+editProfile);
		if (captchaPassed) {
			jsonResponse = dataFetch.editProfileRequest(editProfile, "http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/updateProfile");
			logger.info("EDIT PROFILE RESPONSE : " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return jsonResponse;
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionMessage();
			}

		} else {
			jsonResponse="Invalid Captcha";
		}
		return jsonResponse;
	}
	
	@RequestMapping(value = "/getRegisteredCollegeList",  method = RequestMethod.POST)
	public @ResponseBody String getRegisteredCollegeList(ModelMap model,  @RequestParam("q") String cityText,@RequestParam("statename") String stateId) throws Exception {
		logger.info("getRegisteredCollegeList text==== : " + cityText);
		logger.info("getRegisteredCollegeList statename==== : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		logger.info("getRegisteredCollegeList JSON Request==== : " + json);
		String response = dataFetch.getCityList("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getRegisteredCollegeList",json);
		logger.info("response : " + response);
		return response;
	}
	
	@RequestMapping(value = "/ajax/getCollegeInforamtion")
	@ResponseBody
	public String getCollegeInforamtion(ModelMap model,HttpServletRequest request,@RequestParam String collegeName) throws Exception {
		logger.info("getCollegeInforamtion collegeName ::"+collegeName);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getCollegeInforamtion", collegeName);
		logger.info("getCollegeInforamtion collegeData response ::"+response);
		return response;
	}
	

	

		
}