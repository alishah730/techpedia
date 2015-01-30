package com.techpedia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techpedia.bean.AddNewFaculty;
import com.techpedia.bean.Challenge;
import com.techpedia.bean.ChangePassword;
import com.techpedia.bean.Login;
import com.techpedia.bean.Project;
import com.techpedia.bean.UMServiceResponse;
import com.techpedia.bean.UserProfileVO;
import com.techpedia.service.DataFetch;

@Controller
public class NavigationController {
	@Autowired
	DataFetch dataFetch;
	String username, password;
	String url = "http://localhost:8080/techpedia";
	private static final Logger logger = Logger.getLogger(NavigationController.class);

	/*
	 * @Resource(name = "config") private Properties prop;
	 */

	String IP = "3.235.228.22";

	/*
	 * @PostConstruct public void initLoad() throws IOException { // IP =
	 * prop.getProperty("ip"); }
	 */

	@RequestMapping(value = "/ajax/facultyInitiateProject")
	@ResponseBody
	public String facultyInitiateProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\"}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/facultyinitiatedproject", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/facultyCloseProject")
	@ResponseBody
	public String facultyCloseProject(ModelMap model, @RequestParam String projectId, @RequestParam String facultyId, @RequestParam String approvalStatus) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"projGuideId\":" + facultyId + ",\"approvalStatus\":\"" + approvalStatus + "\"}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/facultyclosedproject", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/changeImage")
	@ResponseBody
	public String changeImage(ModelMap model, @RequestParam String registerId, @RequestParam String photoByteArray) throws Exception {
		String jsonRequest = "{\"registerID\": \"" + registerId + "\",\"photoByteStream\":\"" + photoByteArray + "\"}";
		String jsonResponse = dataFetch.fetchJson("http://" + IP + ":8080/UserManagementService/usermanagementservice/updatePhoto", jsonRequest);
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
		System.err.println("forgotPassword: token:" + token);
		String response = dataFetch.fetchJson("http://" + IP + ":8080/UserManagementService/usermanagementservice/forgotPassword?email=" + token, "");
		return response;
	}

	@RequestMapping(value = "/ajax/getProjectMentors")
	@ResponseBody
	public String getProjectMentors(ModelMap model, @RequestParam String projectId) throws Exception {
		String response = dataFetch.fetchJson("http://" + IP + ":8080/UserManagementService/usermanagementservice/mentorsOfProject?projId=" + projectId, "");
		return response;
	}

	@RequestMapping(value = "/ajax/deleteMentorFromProject")
	@ResponseBody
	public String deleteMentorFromProject(ModelMap model, @RequestParam String projectId, @RequestParam String mentorId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"mentorRgstrId\":" + mentorId + "}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/deletementor", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/addMentorToProject")
	@ResponseBody
	public String addMentorToProject(ModelMap model, @RequestParam String projectId, @RequestParam String mentorId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"mentorRgstrId\":" + mentorId + "}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/addnewmentor", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/pitchProjectSearch")
	@ResponseBody
	public String pitchProjectSearch(ModelMap model, @RequestParam String projectId) throws Exception {
		String response = dataFetch.fetchJson("http://" + IP + ":8080/UserManagementService/usermanagementservice/searchForMentors?projId=" + projectId, "");
		return response;
	}

	@RequestMapping(value = "/ajax/fetchHomePageMentors")
	@ResponseBody
	public String fetchHomePageMentors(ModelMap model) throws Exception {
		String response = dataFetch.fetchJson("http://" + IP + ":8080/UserManagementService/usermanagementservice/getPopularMentorList", "");
		return response;
	}

	@RequestMapping(value = "/ajax/deleteProjectDocument")
	@ResponseBody
	public String deleteProjectDocument(ModelMap model, @RequestParam String projectId, @RequestParam String registerId, @RequestParam String documentName) throws Exception {
		String jsonRequest = "{\"regstrId\":" + registerId + ",\"projId\":" + projectId + ",\"docName\":\"" + documentName + "\"}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/deleteprojectdocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/getProjectDocuments")
	@ResponseBody
	public String getProjectDocuments(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + "}";
		String response = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/downloadprojectdocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/deleteChallengeDocument")
	@ResponseBody
	public String deleteChallengeDocument(ModelMap model, @RequestParam String challengeId, @RequestParam String registerId, @RequestParam String documentName) throws Exception {
		String jsonRequest = "{\"regstrId\":" + registerId + ",\"challengeId\":" + challengeId + ",\"docName\":\"" + documentName + "\"}";
		String response = dataFetch.deleteChallengeDocument("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/deletechallengedocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeDocuments")
	@ResponseBody
	public String getChallengeDocuments(ModelMap model, @RequestParam String challengeId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"challengeId\":" + challengeId + ",\"regstrId\":" + registerId + "}";
		String response = dataFetch.getChallengeDocuments("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/downloadchallengedocument", jsonRequest);
		return response;
	}

	@RequestMapping(value = "/projectSpotlightLoad", method = RequestMethod.POST)
	public @ResponseBody
	String projectSpotlight(ModelMap model) throws Exception {
		String jsonResponse = dataFetch.projectSpotlight("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getprojectfollowers", "");
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
		String jsonResponse = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/uploadprojectdocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/uploadChallengeDocument", method = RequestMethod.POST)
	public @ResponseBody
	String uploadChallengeDocument(ModelMap model, @RequestParam String registerId, @RequestParam String challengeId, @RequestParam String documentName, @RequestParam String documentBase64) throws Exception {
		String jsonRequest = "{\"rgstrId\":" + registerId + ",\"challengeId\":" + challengeId + ",\"docName\":\"" + documentName + "\",\"docByteArray\":\"" + documentBase64 + "\"}";
		String jsonResponse = dataFetch.uploadChallengeDocument("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/uploadchallengedocument", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/submitProject", method = RequestMethod.POST)
	public @ResponseBody
	String submitProject(ModelMap model, @RequestParam String projectId, @RequestParam String status) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"status\":" + status + "}";
		String jsonResponse = dataFetch.submitProject("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/submitproject", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getPopularity", method = RequestMethod.POST)
	public @ResponseBody
	String getPopularity(ModelMap model, @RequestParam String registerId) throws Exception {
		String jsonResponse = dataFetch.getPopularity("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getpopularity", registerId);
		if (jsonResponse.equalsIgnoreCase("N")) {
			jsonResponse = "0";
		}
		jsonResponse = "90";
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/addTeamMember", method = RequestMethod.POST)
	public @ResponseBody
	String addTeamMember(ModelMap model, @RequestParam String registerId, @RequestParam String projectId, @RequestParam String teamId) throws Exception {
		String json = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"teamId\":" + teamId + "}";
		System.err.println("addTeamMember: request: " + json);
		String jsonResponse = dataFetch.addTeamMember("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/addteammembers", json);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/removeTeamMember", method = RequestMethod.POST)
	public @ResponseBody
	String removeTeamMember(ModelMap model, @RequestParam String registerId, @RequestParam String projectId, @RequestParam String teamId) throws Exception {
		String json = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"teamId\":" + teamId + "}";
		System.err.println("addTeamMember: request: " + json);
		String jsonResponse = dataFetch.removeTeamMember("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/removeteammembers", json);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getTeamsListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getTeamsListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String url = "http://" + IP + ":8080/UserManagementService/usermanagementservice/getUserTeamList?registerID=" + registerId;
		String jsonResponse = dataFetch.getTeamsListForOneUser(url, "");
		return jsonResponse;
	}

	@RequestMapping(value = "/teamDetails{id}")
	public String teamDetails(ModelMap model, @PathVariable int id, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		id = 167;
		HttpSession session = request.getSession();
		session.setAttribute("teamId", String.valueOf(id));
		return "teamDetails";
	}

	@RequestMapping(value = "/ajax/teamDetailsLoad")
	public @ResponseBody
	String teamDetailsLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String teamId = (String) session.getAttribute("teamId");
		String response = dataFetch.fetchteamDetails("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getdetailofteam", teamId, model);
		return response;
	}

	@RequestMapping(value = "/ajax/getChallengeListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getChallengeListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.getChallengeListForOneUser("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/getchallengesbyloggedinuser", registerId);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getProjectListForOneUser", method = RequestMethod.POST)
	public @ResponseBody
	String getProjectListForOneUser(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.getProjectListForOneUser("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getprojectsbyLoggedinuser", registerId);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/projectsIFollow", method = RequestMethod.POST)
	public @ResponseBody
	String projectsIFollow(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String registerId = String.valueOf((Long) session.getAttribute("id"));
		String jsonResponse = dataFetch.projectsIFollow("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getallfollowedproject", registerId);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/deleteProject", method = RequestMethod.POST)
	public @ResponseBody
	String deleteProject(ModelMap model, @RequestParam String id) throws Exception {
		String jsonResponse = dataFetch.deleteProject("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/deleteproject", id);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/doesFollow", method = RequestMethod.POST)
	public @ResponseBody
	String doesUserFollowProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"rgstrId\":" + registerId + "}";
		String jsonResponse = dataFetch.doesUserFollowProject("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/checkprojectfollow", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/followProject", method = RequestMethod.POST)
	public @ResponseBody
	String followProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"userRgstrNo\":" + registerId + "}";
		String jsonResponse = dataFetch.followProject("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/followtheproject", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/unfollowProject", method = RequestMethod.POST)
	public @ResponseBody
	String unfollowProject(ModelMap model, @RequestParam String projectId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"rgstrId\":" + registerId + "}";
		String jsonResponse = dataFetch.followProject("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/removeprojectfollow", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getTeamComments", method = RequestMethod.POST)
	public @ResponseBody
	String getTeamComments(ModelMap model, @RequestParam String projectId, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"projId\":\"" + projectId + "\",\"iterationCount\":\"" + set + "\"}";
		System.err.println("getTeamComments: request: " + jsonRequest);
		String jsonResponse = dataFetch.getTeamComments("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/displayteamcomments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/getPublicComments", method = RequestMethod.POST)
	public @ResponseBody
	String getPublicComments(ModelMap model, @RequestParam String projectId, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"projId\":\"" + projectId + "\",\"iterationCount\":\"" + set + "\"}";
		System.err.println("getPublicComments: request: " + jsonRequest);
		String jsonResponse = dataFetch.getPublicComments("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/displayothercomments", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/postComment", method = RequestMethod.POST)
	public @ResponseBody
	String postComment(ModelMap model, @RequestParam String projectId, @RequestParam String registerId, @RequestParam String comment) throws Exception {
		String jsonRequest = "{\"projId\":" + projectId + ",\"regstrId\":" + registerId + ",\"projComment\":\"" + comment + "\"}";
		System.err.println("PostTeamComments: request: " + jsonRequest);
		String jsonResponse = dataFetch.postComment("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/addcomment", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/deleteComment", method = RequestMethod.POST)
	public @ResponseBody
	String deleteComment(ModelMap model, @RequestParam String projectId, @RequestParam String commentId, @RequestParam String registerId) throws Exception {
		String jsonRequest = "{\"projectId\":" + projectId + ",\"commentId\":" + commentId + ",\"rgstrId\":" + registerId + "}";
		System.err.println("deleteComment: request: " + jsonRequest);
		String jsonResponse = dataFetch.deleteComment("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/deletecomment", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/searchProjectByKeyword", method = RequestMethod.POST)
	public @ResponseBody
	String searchProjectByKeyword(ModelMap model, @RequestParam String term, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"term\":\"" + term + "\",\"iterationCount\":\"" + set + "\"}";
		System.err.println("PostTeamComments: request: " + jsonRequest);
		String jsonResponse = dataFetch.searchProjectByKeyword("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/searchprojectbykeyword", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/ajax/searchChallengeByTitle", method = RequestMethod.POST)
	public @ResponseBody
	String searchChallengeByTitle(ModelMap model, @RequestParam String term, @RequestParam String set) throws Exception {
		String jsonRequest = "{\"term\":\"" + term + "\",\"iterationCount\":\"" + set + "\"}";
		System.err.println("searchChallengeByTitle: request: " + jsonRequest);
		String jsonResponse = dataFetch.searchChallengeByTitle("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/searchchallengebytitle", jsonRequest);
		return jsonResponse;
	}

	@RequestMapping(value = "/addChallengeRequest")
	public @ResponseBody
	String addChallengeRequest(ModelMap model, @ModelAttribute Challenge challenge, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		challenge.setRgstrId(String.valueOf((Long) session.getAttribute("id")));

		String jsonResponse = dataFetch.addChallengeRequest(challenge, "http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/createChallenge");
		logger.info("Add CHALLENGE RESPONSE : " + jsonResponse);
		if (jsonResponse.equalsIgnoreCase("Y")) {
			return "success";
		} else if(jsonResponse.contains("success")) {
			return "success";
		}else{
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
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
		return dataFetch.fetchManageProjects("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getprojectsbyLoggedinuser", registerId);
	}

	@RequestMapping(value = "/changePassword")
	@ResponseBody
	public String changePassword(ModelMap model, HttpServletRequest request, HttpServletResponse response, @ModelAttribute ChangePassword changePassword) throws Exception {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		changePassword.setUsername(username);
		System.err.println(changePassword.toString());

		if (username != null) {
			String jsonResponse = dataFetch.changePassword("http://" + IP + ":8080/UserManagementService/usermanagementservice/passwordReset", changePassword);
			System.err.println("CHANGE PWD RESPONSE - " + jsonResponse);
			if (jsonResponse.contains("success")) {
				return "success";
			} else {
				ObjectMapper mapper = new ObjectMapper();
				UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
				return serviceResponse.getExceptionDetails();
			}
		} else {
			System.err.println("CHANGE PASSWORD - USERNAME NULL");
			response.sendRedirect("loginagain");
		}
		return "faliure";
	}

	@RequestMapping(value = "/getSuggestedFaculty", method = RequestMethod.GET)
	@ResponseBody
	public String getSuggestedFaculty(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		String q = (String) session.getAttribute("username");
		String response = dataFetch.getSuggestedFaculty("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getsuggestedfaculty", q);
		return response;
	}
	

	@RequestMapping(value = "/getSuggestedKeywords", method = RequestMethod.POST)
	@ResponseBody
	public String getSuggestedKeywords(ModelMap model, @RequestParam String q) throws Exception {
		String response = dataFetch.getSuggestedKeywords("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getsuggestedkeywords", q);
		return response;
	}

	@RequestMapping(value = "/getSuggestedBranches", method = RequestMethod.GET)
	@ResponseBody
	public String getSuggestedBranches(ModelMap model, @RequestParam String q) throws Exception {
		String response = dataFetch.getSuggestedBranches("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getsuggestedbranches", q);
		return response;
	}
	@RequestMapping(value = "/getsuggestedchallenges", method = RequestMethod.GET)
	@ResponseBody
	public String getsuggestedchallenges(ModelMap model, @RequestParam String q) throws Exception {
	
		String response = dataFetch.getsuggestedchallenges("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/getsuggestedchallenges", q);
	
		return response;
	}
	@RequestMapping(value = "/addProjectRequest")
	public @ResponseBody
	String addProjectRequest(ModelMap model, @ModelAttribute Project project) throws Exception {
		return dataFetch.addProjectRequest(project, "http://" + IP + ":8080/techpediaProjectManagementService/projectservice/createproject");
	}

	@RequestMapping(value = "/acceptChallengeRequest")
	public @ResponseBody
	String acceptChallengeRequest(ModelMap model, @ModelAttribute Project project) throws Exception {
		return dataFetch.addProjectRequest(project, "http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/acceptchallenge");
		
	}

	@RequestMapping(value = "/")
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

	@RequestMapping(value = "/editProject")
	public String editProject(ModelMap model, HttpServletRequest request, @RequestParam String id) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession();
		session.setAttribute("editProjectId", id);
		return "editProject";
	}

	@RequestMapping(value = "/editProjectLoad")
	@ResponseBody
	public String editProjectLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("editProjectId");
		String jsonResponse = dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getprojectdetails", id);
		return jsonResponse;
	}

	@RequestMapping(value = "/editProfileLoad")
	@ResponseBody
	public String editProfileLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String registerID = (String) String.valueOf(session.getAttribute("id"));
		String response = dataFetch.fetchEditProfile("http://" + IP + ":8080/UserManagementService/usermanagementservice/getUserDetails", model, registerID);
		return response;
	}

	@RequestMapping(value = "/editProfileRequest")
	public @ResponseBody
	String editProfileRequest(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO editProfile) throws Exception {
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

		HttpSession session = request.getSession(true);
		Long rgstrId = (Long) session.getAttribute("id");
		editProfile.setRgstrId(rgstrId);
		String jsonResponse = dataFetch.editProfileRequest(editProfile, "http://" + IP + ":8080/UserManagementService/usermanagementservice/updateProfile");
		logger.info("EDIT PROFILE RESPONSE : " + jsonResponse);
		if (jsonResponse.contains("success")) {
			return "success";
		} else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
	}

	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST)
	@ResponseBody
	public String signIn(@ModelAttribute Login login, HttpServletRequest request) throws Exception {
		String response = dataFetch.signIn("http://" + IP + ":8080/UserManagementService/usermanagementservice/signIn", login);
		System.err.println("Ajax Login Response: " + response);
		if (!response.contains("exception")) {
			HttpSession session = request.getSession(true);
			ObjectMapper mapper = new ObjectMapper();
			UserProfileVO user = mapper.readValue(response, UserProfileVO.class);
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
			return "success";
		} else {
			logger.debug("login failed");
		}
		return "faliure";
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

	@RequestMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "/loginagain")
	public String loginagain(ModelMap model, HttpServletRequest request) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "loginagain";
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
		System.err.println("ajaxAddNewFaculty: request: " + jsonRequest);
		return dataFetch.fetchJson("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/addnewfaculty", jsonRequest);
	}

	@RequestMapping(value = "ajax/searchTeamMembers")
	@ResponseBody
	public String ajaxSearchTeamMembers(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO search) throws Exception {
		String response = dataFetch.fetchSuggestedTeamMembers("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getsuggestedteammembers", search);
		return response;
	}

	@RequestMapping(value = "ajax/searchTeamMembersOld")
	@ResponseBody
	public String searchTeamMembersOld(ModelMap model, HttpServletRequest request, @ModelAttribute UserProfileVO search) throws Exception {
		String response = dataFetch.fetchSuggestedTeamMembersOld("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getsuggestedteammembers", search);
		return response;
	}

	@RequestMapping(value = "/aboutus")
	public String aboutus(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "aboutus";
	}

	@RequestMapping(value = "/projects")
	public String projects(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "projects";
	}

	@RequestMapping(value = "/projectsFetch")
	@ResponseBody
	public String projectsFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		String response = dataFetch.fetchProjects("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getallproject", model, set);
		return response;
	}

	@RequestMapping(value = "/challenges")
	public String challenges(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "challenges";
	}

	@RequestMapping(value = "/challengesFetch")
	@ResponseBody
	public String challengesFetch(ModelMap model, @RequestParam("set") String set) throws Exception {
		String response = dataFetch.fetchChallenges("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/getallchallenge", model, set);
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
		String jsonResponse = dataFetch.challengeDetailsLoad("http://" + IP + ":8080/techpediaProjectManagementService/challengeservice/getchallengedetail", challengeId);
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
		String response = dataFetch.fetchMentors("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getallmentors", model, set);
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
		String response = dataFetch.fetchMentorDetails("http://" + IP + ":8080/UserManagementService/usermanagementservice/getUserDetails", model, id);
		return response;
	}

	@RequestMapping(value = "/dashboard")
	public String dashboard(ModelMap model) throws Exception {
		model = dataFetch.fetchFooter(model, url);
		return "dashboard";
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

	@RequestMapping(value = "/registerRequest")
	public @ResponseBody
	String registerRequest(ModelMap model, @ModelAttribute UserProfileVO register) throws Exception {
		String userType = register.getUserType();
		if (userType.equalsIgnoreCase("college")) {
			register.setWebpage(register.getWebpage().split(",")[0].toString());
		} else if (userType.equalsIgnoreCase("mentor")) {
			register.setWebpage(register.getWebpage().split(",")[0].toString());
		} else {
			register.setWebpage("");
		}

		String jsonResponse = dataFetch.registerRequest(register, "http://" + IP + ":8080/UserManagementService/usermanagementservice/createProfile");
		logger.info("REGISTER PROFILE RESPONSE : " + jsonResponse);
		if (jsonResponse.contains("success")) {
			return "success";
		} else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(jsonResponse, UMServiceResponse.class);
			return serviceResponse.getExceptionMessage();
		}
	}

	@RequestMapping(value = "/projectDetails{id}")
	public String detail(ModelMap model, @PathVariable String id, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("projectId", id);
		model = dataFetch.fetchFooter(model, url);
		model = dataFetch.fetchProjectDetail("http://" + IP + ":8080/techpediaProjectManagementService/projectservice/getprojectdetails", model, id);
		return "detail";
	}

	@RequestMapping(value = "/test")
	public String test(ModelMap model) throws Exception {
		return "test";
	}

	@RequestMapping(value = "/projectId")
	@ResponseBody
	public String getProjectIdFromSession(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("projectId");
	}
}
