package com.techpedia.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.techpedia.bean.AddReviewer;
import com.techpedia.bean.MoreInfoRequiredVO;
import com.techpedia.bean.NotifyReviewerVo;
import com.techpedia.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.bean.PasswordResetVo;
import com.techpedia.bean.ReviewRatingVO;
import com.techpedia.bean.SignInVo;
import com.techpedia.bean.SubmitInnovationToGytiForPdfVO;
import com.techpedia.bean.UMServiceResponse;
import com.techpedia.manager.PdfManager;
import com.techpedia.manager.XlsManager;
import com.techpedia.service.DataFetch;
import com.techpedia.util.TechpediaConstants;

@Controller
public class NavigationController {

	private static final Logger logger = Logger.getLogger(NavigationController.class);

	@Value("${ip}")
	private String ip;

	@Value("${portNo}")
	private String portNo;
	
	@Value("${techpedia.url}")
	private String techpediaUrl;

	@Value("${archive.url}")
	private String archiveUrl;
	
	@Autowired
	DataFetch dataFetch;

	// private String ip = "3.235.228.22";
	// private String ip = "localhost";

	// private String portNo = "8080";
	// private String portNo = "8081";

	//String url = "http://" + ip + ":" + portNo + "/techpedia";
	// String url = "http://localhost:8080/techpedia";

	VerifyRecaptcha verifyRecaptcha;
	String username, password;
	public String userName;
	public String regid;

	@RequestMapping(value = "/ajax/forgotPassword")
	@ResponseBody
	public String forgotPassword(ModelMap model, @RequestParam String token) throws Exception {
		System.err.println("forgotPassword: token:" + token);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo
				+ "/UserManagementService/usermanagementservice/forgotPassword?email=" + token, "");
		logger.info(response);
		return response;
	}

	@RequestMapping(value = "/getStateList", method = RequestMethod.GET)
	public @ResponseBody String getStateListReviewSystem(ModelMap model, @RequestParam("q") String queryParam)
			throws Exception {
		logger.info("state list service call=" + queryParam);
		String response = dataFetch.getStateList("http://" + ip + ":" + portNo+ "/UserManagementService/usermanagementservice/getStateList?sName=" + queryParam,TechpediaConstants.BLANK_STRING);
		logger.info("response : " + response);
		return response;
	}

	

	@RequestMapping(value = "/getCityList", method = RequestMethod.POST)
	public @ResponseBody String getCityListReviewSystem(ModelMap model, @RequestParam("q") String cityText,
			@RequestParam("statename") String stateId) throws Exception {
		logger.info("text : " + cityText);
		logger.info("statename : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		String response = dataFetch.getCityList("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getCityList", json);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = "/getCollegeList", method = RequestMethod.POST)
	public @ResponseBody String getCollegeList(ModelMap model, @RequestParam("q") String cityText,
			@RequestParam("statename") String stateId) throws Exception {
		logger.info("text : " + cityText);
		logger.info("statename : " + stateId);
		String json = "{\"term\":\"" + cityText + "\",\"stateName\":\"" + stateId + "\"}";
		String response = dataFetch.getCityList("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getCollegeList", json);
		logger.info("response : " + response);
		return response;
	}

	@RequestMapping(value = {"/","/index"})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Inside Index");
		HttpSession session=request.getSession(false);
		ModelAndView mav = new ModelAndView();
		//if(session ==null){
			logger.info("inside if");
			mav = new ModelAndView("index");
		//}
		
		/*else if(session !=null){
			logger.info("inside else :: "+session.getId());
			if(((String) session.getAttribute("revUsrId")).equalsIgnoreCase("TrsAdmin")){
				mav = new ModelAndView("adminDashboard");
			}
			else{
				mav = new ModelAndView("reviewDashboard");
			}
		}*/
		
		mav.addObject("techpediaUrl", techpediaUrl);
		return mav;
	}

	@RequestMapping(value = "/editGytiProjectLoad")
	@ResponseBody
	public String editGytiProjectLoad(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("editGytiProjectId");
		logger.info("--edit Gyti Project ID--" + id);

		String jsonResponse = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getGytiProjectDetails", id);
		logger.info("--edit Gyti Project response--" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/IEError")
	public ModelAndView IEError(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("IEError");
		return mav;
	}

	@RequestMapping(value = "/reviewerLogout")
	public ModelAndView reviewerLogout(HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView("index");
		HttpSession session = request.getSession(false);
		if (session != null) {
			logger.info("session Id :: " + session.getId());
			logger.info("session Creation time 3 :: " + session.getCreationTime());
			session.invalidate();
			session = null;
		}
		mav.addObject("techpediaUrl", techpediaUrl);
		return mav;
	}


	@RequestMapping(value = "/Error")
	public ModelAndView Error(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("Error");
		return mav;
	}



	@RequestMapping(value = "/reviewDashboard")
	public ModelAndView reviewDashboardAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		ModelAndView mav = new ModelAndView("reviewDashboard");
		return mav;
	}

	@RequestMapping(value = "/reviewerStatus")
	public ModelAndView reviewerStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("reviewerStatus");
		return mav;
	}

	@RequestMapping(value = "/reviewerLogin")
	public ModelAndView reviewerLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("reviewerLogin");
		mav.addObject("techpediaUrl", techpediaUrl);
		return mav;
	}

	@RequestMapping(value = "/getTotalGytiProjectsByCategory")
	@ResponseBody
	public String getTotalGytiProjectsByCategory(ModelMap model) throws Exception {
		logger.info("inside navigation....");
		String response = dataFetch.getTotalGytiProjectsByCategory("http://" + ip + ":" + portNo
				+ "/techpediaProjectManagementService/projectservice/getTotalGytiProjectsByCategory");
		logger.info("getTotalGytiProjectsByCategory::" + response);
		return response;
	}


	@RequestMapping(value = "/addReviewer")
	public ModelAndView addReviewer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView("addReviewer");
		return mav;
	}

	@RequestMapping(value = "/AddReviwerByAdmin", method = RequestMethod.POST)
	public @ResponseBody String addReviewerbyAdmin(ModelMap model, @ModelAttribute AddReviewer addReviewer,
			HttpServletRequest request) throws Exception {

		String jsonRequest = "{\"addReviewerbyAdmin\":\"" + addReviewer + "\"}";
		logger.info("Inside navigation controller:: " + jsonRequest);
		String jsonResponse = dataFetch.addReviewerbyAdmin("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/addNewReviewer", addReviewer);
		logger.info("Response :: " + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/reviewInnovation{projId}")
	public ModelAndView reviewInnovationGYTI(@PathVariable int projId, HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView("reviewInnovation");
		HttpSession session = request.getSession(false);
		session.setAttribute("GYTIReviweprojId", String.valueOf(projId));
		logger.info("project id::" + session.getAttribute("GYTIReviweprojId"));
		return mav;
	}

	@RequestMapping(value = "/getGytiProjectDetailforReview", method = RequestMethod.POST)
	public @ResponseBody String getGytiProjectDetail(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String projId = (String) session.getAttribute("GYTIReviweprojId");
		String jsonResponse = dataFetch.fetchProjectDetailGYTI("http://" + ip + ":" + portNo
				+ "/techpediaProjectManagementService/projectservice/getGytiProjectDetails", projId, model);
		logger.info("project details GYTI::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/getGytiProjectDetailView", method = RequestMethod.POST)
	public @ResponseBody String getGytiProjectDetailView(ModelMap model, HttpServletRequest request, @RequestParam String projId) throws Exception {
		String jsonResponse = dataFetch.fetchProjectDetailGYTI("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getGytiProjectDetails", projId, model);
		logger.info("project details GYTI view::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/submitReviewRating", method = RequestMethod.POST)
	@ResponseBody
	public String submitReviewRating(ModelMap model, @ModelAttribute ReviewRatingVO reviewRating, HttpServletRequest request) throws Exception {
		logger.info("submitReviewRating Request::" + reviewRating);
		logger.info("rev reg id::" + reviewRating.getRevRgstrId());

		HttpSession session = request.getSession(false);
		long revRgstrId = (Long) session.getAttribute("revRgstrId");
		reviewRating.setRevRgstrId(revRgstrId);
		logger.info("rev reg id UI::" + reviewRating.getRevRgstrId());
		logger.info("submitReviewRating Request::" + reviewRating);
		String jsonResponse = dataFetch.submitReviewRating("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/submitReviewRating", reviewRating);
		logger.info("submitReviewRating Response::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/getAllReviewer")
	@ResponseBody
	public String getAllReviewer(ModelMap model) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getAllReviewer", "");
		logger.info("getAllReviewer Response==" + response);
		return response;
	}

	@RequestMapping(value = "/getActiveReviewers")
	@ResponseBody
	public String getActiveReviewers(ModelMap model, HttpServletRequest request) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getActiveReviewers", "");
		logger.info("getActiveReviewers Response==" + response);
		return response;
	}

	@RequestMapping(value = "/getDeactiveReviewers")
	@ResponseBody
	public String getDeactiveReviewers(ModelMap model, HttpServletRequest request) throws Exception {
		logger.info("Inside getDeactiveReviewers controller:::");
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getDeactiveReviewers", "");
		logger.info("getDeactiveReviewers Response :: " + response);
		return response;
	}

	@RequestMapping(value = "/reviewerLoginRequest", method = RequestMethod.POST)
	@ResponseBody
	public String reviewerLogin(@ModelAttribute SignInVo login, HttpServletRequest request) throws Exception {
		logger.info("Ajax reviewerLogin request: " + login.getEmailId());
		logger.info("Ajax reviewerLogin request: " + login.getPassword());
		String response = dataFetch.signIn("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/reviewerSignIn", login);
		logger.info("Ajax reviewerLogin request: " + login.getEmailId());
		logger.info("Ajax reviewerLogin Response: " + response);
		if (!response.contains("exception")) {
			HttpSession session = request.getSession(true);
			ObjectMapper mapper = new ObjectMapper();
			AddReviewer user = mapper.readValue(response, AddReviewer.class);
			logger.info("reviewerLogin response mapped to java object : " + user.toString());
			session.setAttribute("emailID", user.getRevEmailId());
			session.setAttribute("revfirstName", user.getRevFname());
			session.setAttribute("revLname", user.getRevLname());
			// session.setAttribute("revMname",user.getRevMname());
			session.setAttribute("speciality", user.getRevSpeciality());
			session.setAttribute("revRgstrId", user.getRevRgstrId());
			session.setAttribute("revUsrId", user.getRevUsrId());
			session.setAttribute("techpediaUrl", techpediaUrl);

			logger.info("Session Id::" + session.getId());
			logger.info("Rev Rgstr ID::" + session.getAttribute("revRgstrId"));
			logger.info("Rev Rgstr email::" + session.getAttribute("emailID"));
			logger.info("Rev Rgstr fName::" + session.getAttribute("revfirstName"));
			logger.info("Rev Rgstr Speciality::" + session.getAttribute("speciality"));
			
				return response;
			
			
		} else {
			ObjectMapper mapper = new ObjectMapper();
			UMServiceResponse serviceResponse = mapper.readValue(response, UMServiceResponse.class);
			String jsonError = mapper.writeValueAsString(serviceResponse);
			return jsonError ;
		}

	}

	@RequestMapping(value = "/activateReviewerProfile")
	@ResponseBody
	public String activateReviewerProfile(ModelMap model, @RequestParam String revUserId) throws Exception {
		logger.info("activateReviewerProfile: revUserId:" + revUserId);
		String userId = revUserId;
		userId = URLEncoder.encode(userId, "UTF-8");
		logger.info("activateReviewerProfile==" + userId);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo+ "/UserManagementService/usermanagementservice/activateReviewerProfile?userID=" + userId, "");
		logger.info(response);
		return response;
	}

	@RequestMapping(value = "/deActivateReviewerProfile")
	@ResponseBody
	public String deActivateReviewerProfile(ModelMap model, @RequestParam String revUserId) throws Exception {
		System.err.println("deActivateReviewerProfile: revUserId:" + revUserId);
		String userId = revUserId;
		userId = URLEncoder.encode(userId, "UTF-8");
		logger.info("deActivateReviewerProfile==" + userId);
		String response = dataFetch.fetchJson(
				"http://" + ip + ":" + portNo
						+ "/UserManagementService/usermanagementservice/deActivateReviewerProfile?userID=" + userId,
				"");
		logger.info(response);
		return response;
	}

	@RequestMapping(value = "/getAllGYTIProjetcByLoggdinReviewer")
	@ResponseBody
	public String getAllGYTIProjetcByLoggdinReviewer(ModelMap model, HttpServletRequest request,@RequestParam String year) throws Exception {
		// System.err.println("deActivateReviewerProfile: revUserId:" +
		// revUserId);
		logger.info("Inside controller::::Current Year==="+year);
		HttpSession sessionReviewer = request.getSession(false);
		String revRegstrId = String.valueOf((long) sessionReviewer.getAttribute("revRgstrId"));
		// userId = URLEncoder.encode(userId, "UTF-8");
		logger.info("ReviewerProfile==" + revRegstrId);
		String response = dataFetch.fetchJson(
				"http://" + ip + ":" + portNo
						+ "/techpediaProjectManagementService/projectservice/getAllGytiProjectByLoggedInReviewer/"+year+"",
				revRegstrId);
		logger.info("all projects==="+response);
		return response;
	}
	
	@RequestMapping(value = "/reviewGYTIProjects")
	public ModelAndView reviewGITYProjects(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("reviewGYTIProjects");
		return mav;
	}

	@RequestMapping(value = "/forwardProjectToReviewer{projId}")
	public ModelAndView forwardProjectToReviewer(HttpServletRequest request, HttpServletResponse response, @PathVariable int projId)
			throws Exception {
		ModelAndView mav = new ModelAndView("forwardProjectToReviewer");
		HttpSession session = request.getSession(false);
		session.setAttribute("GYTIReviweProjIdToForward", String.valueOf(projId));
		logger.info("project id::" + session.getAttribute("GYTIReviweProjIdToForward"));
		return mav;
	}

	@RequestMapping(value = "/forwardProjectToReviewer")
	public @ResponseBody String forwardProjectToReviewer(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String projId = (String) session.getAttribute("GYTIReviweProjIdToForward");
		logger.info("GYTIReviwe ProjId To Forward::" + projId);
		String response = dataFetch.fetchJson(
				"http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/getSuggestableReviewers",
				projId);
		logger.info("Reviwer Details" + response);
		return response;
	}

	@RequestMapping(value = "/editReviewAndRating{projId}")
	public ModelAndView editReviewAndrating(HttpServletResponse response, @PathVariable int projId, HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView("editReviewAndRating");
		HttpSession session = request.getSession(false);
		session.setAttribute("GYTIReviweProjIdToEditReview", String.valueOf(projId));
		logger.info("project id::" + session.getAttribute("GYTIReviweProjIdToEditReview"));
		return mav;
	}

	@RequestMapping(value = "/editProjectReviewRating")
	public @ResponseBody String editProjectReviewRating(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String projId = (String) session.getAttribute("GYTIReviweProjIdToEditReview");
		logger.info("GYTIReviwe ProjId To Forward" + projId);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getGytiProjectDetails", projId);
		logger.info("Reviwe proejct Details" + response);
		return response;
	}

	@RequestMapping(value = "/getGytiProjectReviewDetailforEdit")
	public @ResponseBody String getGytiProjectReviewDetailforEdit(ModelMap model, HttpServletRequest request)
			throws Exception {

		logger.info("inside naviagtion");

		HttpSession session = request.getSession(false);
		String revRegstrId = String.valueOf((long) session.getAttribute("revRgstrId"));
		logger.info("GYTIReviwe ProjId To Forward::" + revRegstrId);
		String projId = (String) session.getAttribute("GYTIReviweProjIdToEditReview");
		logger.info("GYTIReviwe ProjId To Forward::" + projId);
		String jsonRequest = "{\"projId\":" + projId + ",\"revRgstrId\":" + revRegstrId + "}";
		logger.info("GYTIReviwe ProjId To Edit Request::" + jsonRequest);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getgytiProjectReviewDetails", jsonRequest);
		logger.info("Reviwe and Rating edit Details" + response);
		return response;
	}

	@RequestMapping(value = "/getAllReviews")
	public ModelAndView getAllReviews(ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("getAllReviews");
		return mav;
	}

	@RequestMapping(value = "/getAllReviewsByAdmin")
	public @ResponseBody String getAllReviewsByAdmin(ModelMap model,@RequestParam String year) throws Exception {
		logger.info("inside getAllReviewsByAdmin navigation controller");
		logger.info("Inside getAllReviewsByAdmin controller::::Current Year==="+year);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getAllReviews/"+year+"", "");
		logger.info("All review details" + response);
		return response;
	}

	@RequestMapping(value = "/getGytiProjectDetails", method = RequestMethod.POST)
	public @ResponseBody String getGytiProjectDetails(ModelMap model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		String projId = (String) session.getAttribute("GYTIReviweProjIdToForward");
		String jsonResponse = dataFetch.fetchProjectDetailGYTI("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getGytiProjectDetails", projId, model);
		logger.info("project details GYTI view::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/suggestReviewer")
	public @ResponseBody
	String suggestReviewer(ModelMap model,@RequestParam String allSuggestedReviewers) throws Exception {
	logger.info("suggestReviewer===" +allSuggestedReviewers);
	String response = dataFetch.fetchReviewerDetails("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/suggestReviewer", model, allSuggestedReviewers);
	logger.info("suggestReviewer===" +response);
	return response;
	}
	
	@RequestMapping(value = "/getReviewerDetails")
	public @ResponseBody
	String getReviewerDetails(ModelMap model,@RequestParam String reviewerEmailId) throws Exception {
		String response = dataFetch.fetchReviewerDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getReviewerDetails", model, reviewerEmailId);
		logger.info("getReviewerDetails" + response);
		return response;
	}
	

	@RequestMapping(value = "/updateReviewRating", method = RequestMethod.POST)
	@ResponseBody
	public String updateReviewRating(ModelMap model, @ModelAttribute ReviewRatingVO reviewRating,
			HttpServletRequest request) throws Exception {
		logger.info("Inside navigation controller");
		logger.info("submitReviewRating Requst::" + reviewRating);
		logger.info("rev reg id::" + reviewRating.getRevRgstrId());
		logger.info("updateReviewRating Request::" + reviewRating);
		String jsonResponse = dataFetch.submitReviewRating("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/updateGytiProjectReviewRating",
				reviewRating);
		logger.info("submitReviewRating Response::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/getReviewsAndRatingByReviewer", method = RequestMethod.POST)
	public @ResponseBody String getReviewsAndRatingByReviewer(ModelMap model, @RequestParam String ratingId)
			throws Exception {
		String jsonResponse = dataFetch.fetchReviewRating("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getRatingDetailsByReviwer",ratingId, model);
		logger.info("review details according to reviewer::" + jsonResponse);
		return jsonResponse;
	}

	@RequestMapping(value = "/getSuggestedBranches", method = RequestMethod.GET)
	@ResponseBody
	public String getSuggestedBranchesReviewSystem(ModelMap model, @RequestParam String q) throws Exception {
		String response = dataFetch.getSuggestedBranches("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getsuggestedbranches", q);
		return response;
	}

	
	@RequestMapping(value = "/suggestedReviewersByLoggedInReviewer")
	public ModelAndView suggestedReviewersByLoggedInReviewer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("suggestedReviewersByLoggedInReviewer");
		return mav;
	}
	
	@RequestMapping(value = "/getSuggestedReviewersByLoggedInReviewer")
	@ResponseBody
	public String getSuggestedReviewersByLoggedInReviewer(ModelMap model,HttpServletRequest request) throws Exception {
		HttpSession sessionReviewer=request.getSession(false);
		String revRegstrId=String.valueOf((long) sessionReviewer.getAttribute("revRgstrId"));
		logger.info("suggestedReviewersByLoggedInReviewer reviewerId =="+revRegstrId);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/getSuggestedReviewersByLoggedInReviewer",revRegstrId);
		logger.info("getSuggestedReviewersByLoggedInReviewer==" + response);
		return response;
	}
	
	@RequestMapping(value = "/adminGetAllSuggestedReviewers")
	public ModelAndView adminGetAllSuggestedReviewers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("adminGetAllSuggestedReviewers");
		return mav;
	}
	
	@RequestMapping(value = "/adminGetAllSuggestedReviewersList")
	@ResponseBody
	public String adminGetAllSuggestedReviewersList(ModelMap model,HttpServletRequest request) throws Exception {
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/adminGetAllSuggestedReviewersList","");
		logger.info("adminGetAllSuggestedReviewersList==" + response);
		return response;
	}
	
	
	@RequestMapping(value = "/allReviewsForLoggedInReviewer")
	public ModelAndView allReviewsForLoggedInReviewer(ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("allReviewsForLoggedInReviewer");
		return mav;
	}

	
	@RequestMapping(value = "/rejectSuggestedProjectForReview", method = RequestMethod.POST)
	public @ResponseBody String rejectSuggestedProjectForReview(ModelMap model,HttpServletRequest request, @RequestParam String projId) throws Exception {
		logger.info("rejectSuggestedProjectForReview projId===" + projId);
		HttpSession sessionReviewer=request.getSession(false);
		String revRegstrId=String.valueOf((long) sessionReviewer.getAttribute("revRgstrId"));
		logger.info("rejectSuggestedProjectForReview reviewerId =="+revRegstrId);
		String json = "{\"projId\":" + projId + ",\"revRgstrId\":" + revRegstrId+ "}";
		logger.info(" rejectSuggestedProjectForReview json === " + json);
		String response = dataFetch.rejectSuggestedProjectForReview("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/rejectSuggestedProjectForReview", json);
		logger.info(" rejectSuggestedProjectForReview response === " + response);
		return response;
	}
	
	@RequestMapping(value = "/editReviewerProfile")
	public ModelAndView editReviewerProfile(ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("editReviewerProfile");
		return mav;
	}
	
	@RequestMapping(value = "/editReviewerProfileLoad")
	public @ResponseBody
	String editReviewerProfileLoad(ModelMap model,HttpServletRequest request) throws Exception {
		HttpSession sessionReviewer=request.getSession(false);
		String reviewerEmailId=(String) sessionReviewer.getAttribute("emailID");
		logger.info("editReviewerProfileLoad reviewerEmailId =="+reviewerEmailId);
		String response = dataFetch.fetchReviewerDetails("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getReviewerDetails", model, reviewerEmailId);
		logger.info("editReviewerProfileLoad" + response);
		return response;
	}
	
	

	@RequestMapping(value = "/getAllReviewsByLoggedInReviewerAndOthers")
	public @ResponseBody String getAllReviewsByLoggedInRevAndOthers(ModelMap model,HttpServletRequest request,@RequestParam String year) throws Exception {
		logger.info("inside navigation controller");
		logger.info("Inside getAllReviewsByLoggedInReviewerAndOthers controller::::Current Year==="+year);
		HttpSession sessionReviewer=request.getSession(false);
		String revRegstrId=String.valueOf((long) sessionReviewer.getAttribute("revRgstrId"));
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getAllReviewsByLoggedInReviewerAndOthers/"+year+"", revRegstrId);
		logger.info("All review details" + response);
		return response;
	}
	
	@RequestMapping(value = "/getAllReviewsPdf", method = RequestMethod.POST)
	@ResponseBody
 	public String getAllReviewsPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String ngOverallCalculatedReviewRatings ) {
		
		ByteArrayOutputStream byteArrayOutputStream = null;
		PdfManager pdfManager = new PdfManager();
		
		Gson gson = new Gson();
		List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingVOs = null;
		try {
			overallCalculatedReviewRatingVOs = gson.fromJson(ngOverallCalculatedReviewRatings, new TypeToken<List<OverallCalculatedReviewRatingVO>>(){}.getType());
			byteArrayOutputStream = pdfManager.createGetAllReviewsPdf(overallCalculatedReviewRatingVOs, request);
			HttpSession session = request.getSession(false);
			session.setAttribute("byteArrayOutputStream", byteArrayOutputStream);

		    } catch (Exception e){
		    	logger.error("Unexpected exception occured in getAllReviewsPdf method :: ",e);
		    }
		return "\"\"";
		}
	
	@RequestMapping(value = "/downloadFile" )
	public void doDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileName) {
		
		logger.info("fileName :: "+fileName);
		ByteArrayOutputStream byteArrayOutputStream = null;
		HttpSession session = request.getSession(false);

		// construct the complete absolute path of the file
		byteArrayOutputStream = (ByteArrayOutputStream)session.getAttribute("byteArrayOutputStream");

		// get MIME type of the file
		String mimeType = "application/pdf";

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength(byteArrayOutputStream.size());
		
		Date currentDate = new Date();
		DateFormat df = new SimpleDateFormat("MMM_dd_YYYY");
		String formattedDate = df.format(currentDate);

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",fileName+"["+ formattedDate+"].pdf");
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			outStream.write(byteArrayOutputStream.toByteArray());
			outStream.close();
		} catch (Exception e) {
			logger.error("Unexpected exception occured in doDownload method :: ",e);
		}
	}
	
	@RequestMapping(value = "/getGytiProjectDetailsPdf", method = RequestMethod.POST)
	@ResponseBody
 	public String getgytiProjectDetailsPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String gytiProjectDetails ) {
		
		ByteArrayOutputStream byteArrayOutputStream = null;
		PdfManager pdfManager = new PdfManager();
		
		Gson gson = new Gson();
		SubmitInnovationToGytiForPdfVO gytiProjectDetail = null;
		try {
			gytiProjectDetail = gson.fromJson(gytiProjectDetails, SubmitInnovationToGytiForPdfVO.class);
			byteArrayOutputStream = pdfManager.createGetGytiProjectDetailsPdf(gytiProjectDetail, request);
			HttpSession session = request.getSession(false);
			session.setAttribute("byteArrayOutputStream", byteArrayOutputStream);

		    } catch (Exception e){
		    	logger.error("Unexpected exception occured in getAllReviewsPdf method :: ",e);
		    }
		return "\"\"";
		}
	
	@RequestMapping(value = "/UpdateReviwerByAdmin", method = RequestMethod.POST)
	public @ResponseBody String UpdateReviwerByAdmin(ModelMap model, @ModelAttribute AddReviewer editReviewer,
			HttpServletRequest request) throws Exception {
		logger.info("::UpdateReviwerByAdmin::");
		String jsonResponse = dataFetch.UpdateReviwerByAdmin("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/editReviewerProfile", editReviewer);
		logger.info(" UpdateReviwerByAdmin Response :: " + jsonResponse);
		return jsonResponse;
	}


	
	@RequestMapping(value = "/downloadProjectSpecificReviewsPdf", method = RequestMethod.POST)
	@ResponseBody
	public String downloadProjectSpecificReviewsPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String projId) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		PdfManager pdfManager = new PdfManager();
		String jsonVal = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/getAllReviewsForSpecificProject", projId);
		
		Gson gson = new Gson();
		OverallCalculatedReviewRatingVO overallCalculatedReviewRating = null;
		try {
			overallCalculatedReviewRating = gson.fromJson(jsonVal, OverallCalculatedReviewRatingVO.class);
			byteArrayOutputStream = pdfManager.createGetAllReviewsForSpecificProjectPdf(overallCalculatedReviewRating, request);
			HttpSession session = request.getSession(false);
			session.setAttribute("byteArrayOutputStream", byteArrayOutputStream);
		    }catch (Exception e){
		    	logger.error("Unexpected exception occured in downloadProjectSpecificPdf method :: ",e);
		    }
		return "\"\"";
	}
	@RequestMapping(value = "/studentDetailsLoadforReview")
	public @ResponseBody
	String studentDetailsLoad(ModelMap model, HttpServletRequest request,@RequestParam String teamLeaderId ) throws Exception {
		logger.info("team leader Id :: "+teamLeaderId);
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetails", teamLeaderId);
		logger.info("Student details" + response);
		return response;
	}
	@RequestMapping(value="/gytiArchive")
	public ModelAndView gytiArchive(ModelMap model){
		ModelAndView mav=new ModelAndView("gytiArchive");
		mav.addObject("archiveUrl",archiveUrl);
		return mav;
	}

	@RequestMapping(value ="/gytiArchiveData" , method=RequestMethod.GET)
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
	@RequestMapping(value="/gytiArchiveDataDownloadFileName")
	public @ResponseBody
	String DownloadFileLink( HttpServletRequest request,@RequestParam("fileName") String fileName ) throws Exception {
		logger.info("file name :: "+fileName);
		HttpSession session = request.getSession(false);
		session.setAttribute("fileName", fileName);
		logger.info("documentLink" + fileName);
		return "\"\"";
	}
	
	
	@RequestMapping(value="/downloadGytiArchiveFile")
	
	public void gytiArchiveDownload(HttpServletRequest request,HttpServletResponse response ) throws Exception{
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
	@RequestMapping(value = "/getAllReviewsXls", method = RequestMethod.POST)
	@ResponseBody
 	public String getAllReviewsXls(HttpServletRequest request, HttpServletResponse response, @RequestParam String ngOverallCalculatedReviewRatings ) {
		
		logger.info("Entered the controller" );
		ByteArrayOutputStream byteArrayOutputStream = null;
		XlsManager xlsManager = new XlsManager();
		
		Gson gson = new Gson();
		List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingVOs = null;
		try {
			overallCalculatedReviewRatingVOs = gson.fromJson(ngOverallCalculatedReviewRatings, new TypeToken<List<OverallCalculatedReviewRatingVO>>(){}.getType());
			byteArrayOutputStream = xlsManager.createGetAllReviewsXls(overallCalculatedReviewRatingVOs, request);
			HttpSession session = request.getSession(false);
			session.setAttribute("byteArrayOutputStream", byteArrayOutputStream);

		    } catch (Exception e){
		    	logger.error("Unexpected exception occured in getAllReviewsXls method :: ",e);
		    }
		return "\"\"";
		}
	
	@RequestMapping(value = "/downloadXlsFile" )
	public void downloadXlsFile(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileName) {
		
		logger.info("fileName :: "+fileName);
		ByteArrayOutputStream byteArrayOutputStream = null;
		HttpSession session = request.getSession(false);

		// construct the complete absolute path of the file
		byteArrayOutputStream = (ByteArrayOutputStream)session.getAttribute("byteArrayOutputStream");

		// get MIME type of the file
		String mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength(byteArrayOutputStream.size());
		
		Date currentDate = new Date();
		DateFormat df = new SimpleDateFormat("MMM_dd_YYYY");
		String formattedDate = df.format(currentDate);

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",fileName+"["+ formattedDate+"].xlsx");
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = null;
		try {
			outStream = response.getOutputStream();
			outStream.write(byteArrayOutputStream.toByteArray());
			outStream.close();
		} catch (Exception e) {
			logger.error("Unexpected exception occured in downloadXlsFile method :: ",e);
		}
	}
	
	
	@RequestMapping(value = "/activateReviwerProfileViaEmail")

	public String activateUserProfile(ModelMap model, @RequestParam String userID) throws Exception {

		String response =dataFetch.fetchJson("http://" + ip + ":" + portNo+ "/UserManagementService/usermanagementservice/activateReviewerProfile?userID=" + userID, "");
		if (response.contains("success"))
		{
			model.addAttribute("result","Congratulations, Your Profile has been Activated succesfully");
		}
		else 
		{	
			model.addAttribute("result","Failed to activate , Please visit after sometime");
		}
		return "activateReviwerProfileViaEmail";
	}
	@RequestMapping(value ="/adminDashboard")
	public ModelAndView adminDashboard(ModelMap model){
		
		ModelAndView mav=new ModelAndView("adminDashboard");
		return mav;
		
	}
	
	/*@RequestMapping( value = "/totalProjectsStatistics")
	@RequestBody
	public String totalProjectsStatistics(ModelMap model) throws Exception{
		logger.info("Inside navigation");
		String response=dataFetch.gettotalProjectsStatistics("http://" + ip + ":" + portNo+ "/techpediaProjectManagementService/projectservice/totalProjectsStatistics");
		return response;
	}*/
	@RequestMapping(value = "/totalProjectsStatistics")
	@ResponseBody
	public String totalProjectsStatistics(ModelMap model) throws Exception {
		logger.info("inside navigation....");
		String response=dataFetch.getTotalProjectsStatistics("http://" + ip + ":" + portNo+ "/techpediaProjectManagementService/projectservice/totalProjectsStatistics");
		logger.info("totalProjectsStatistics::" + response);
		return response;
	}
	
	@RequestMapping(value = "/totalProjectsYearWiseStatistics")
	@ResponseBody
	public String totalProjectsYearWiseStatistics(ModelMap model) throws Exception {
		logger.info("inside navigation....");
		String response=dataFetch.getTotalProjectsYearWiseStatistics("http://" + ip + ":" + portNo+ "/techpediaProjectManagementService/projectservice/totalProjectsYearWiseStatistics");
		logger.info("totalProjectsYearWiseStatistics::" + response);
		return response;
	}
	@RequestMapping(value ="/totalProjectsForParticularYearStatistics")
	@ResponseBody
	public String totalProjectsForParticularYearStatistics(ModelMap model,@RequestParam("year") String year){
		logger.info("inside navigation...."+year);
		String response=dataFetch.getTotalProjectsForParticularYearStatistics("http://" + ip + ":" + portNo+ "/techpediaProjectManagementService/projectservice/totalProjectsForParticularYearStatistics",year);
		logger.info("totalProjectsForParticularYearStatistics::" + response);
		return response;
	}
	
	@RequestMapping(value = "/reviewerForgotPassword")
	@ResponseBody
	public String reviewerForgotPassword(ModelMap model,HttpServletRequest request,@RequestParam String emailId) throws Exception {
		logger.info("inside navigation controller");
		logger.info("Inside reviewerForgotPassword controller::::Email Id==="+emailId);
		String response = dataFetch.fetchJson("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/reviewerForgotPassword", emailId);
		logger.info("reviewerForgotPassword Response==" + response);
		return response;
	}
	
	@RequestMapping(value = "/saveReviewRating", method = RequestMethod.POST)
	@ResponseBody
	public String saveReviewRating(ModelMap model, @ModelAttribute ReviewRatingVO reviewRating, HttpServletRequest request) throws Exception {
		logger.info("saveReviewRating Request::" + reviewRating.toString());
		logger.info("rev reg id::" + reviewRating.getRevRgstrId());
		logger.info("project id::" + reviewRating.getProjId());
		logger.info("team leader id::" + reviewRating.getProjteamLeaderId());
		HttpSession session = request.getSession(false);
		long revRgstrId = (Long) session.getAttribute("revRgstrId");
		reviewRating.setRevRgstrId(revRgstrId);
		logger.info("rev reg id UI::" + reviewRating.getRevRgstrId());
		logger.info("saveReviewRating Request::" + reviewRating);
		String jsonResponse = dataFetch.submitReviewRating("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/saveReviewRating", reviewRating);
		logger.info("saveReviewRating Response::" + jsonResponse);
		return jsonResponse;
	}
	
	@RequestMapping(value = "/acceptSuggestedProjectForReview", method = RequestMethod.POST)
	public @ResponseBody String acceptSuggestedProjectForReview(ModelMap model,HttpServletRequest request, @RequestParam String projId) throws Exception {
		logger.info("acceptSuggestedProjectForReview projId===" + projId);
		HttpSession sessionReviewer=request.getSession(false);
		String revRegstrId=String.valueOf((long) sessionReviewer.getAttribute("revRgstrId"));
		logger.info("acceptSuggestedProjectForReview reviewerId =="+revRegstrId);
		String json = "{\"projId\":" + projId + ",\"revRgstrId\":" + revRegstrId+ "}";
		logger.info(" acceptSuggestedProjectForReview json === " + json);
		String response = dataFetch.rejectSuggestedProjectForReview("http://" + ip + ":" + portNo + "/techpediaProjectManagementService/projectservice/acceptSuggestedProjectForReview", json);
		logger.info(" acceptSuggestedProjectForReview response === " + response);
		return response;
	}
	
	@RequestMapping(value = "/notifySuggestedReviewer", method = RequestMethod.POST)
	@ResponseBody
	public String notifySuggestedReviewer(ModelMap model, @ModelAttribute NotifyReviewerVo notifyReviewerVo, HttpServletRequest request) throws Exception {
		logger.info("notifySuggestedReviewer Request1::" + notifyReviewerVo.toString());
		HttpSession sessionReviewer=request.getSession(false);
		String loggedInReviewerEmail=(String) sessionReviewer.getAttribute("emailID");
		notifyReviewerVo.setLoggedInReviewerEmail(loggedInReviewerEmail);
		logger.info("notifySuggestedReviewer Request2::" + notifyReviewerVo.toString());
		String jsonResponse = dataFetch.notifySuggestedReviewer("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/notifySuggestedReviewer", notifyReviewerVo);
		logger.info("notifySuggestedReviewer Response::" + jsonResponse);
		return jsonResponse;
	}
	
	@RequestMapping(value = "ajax/teamLeaderProfileLoad")
	@ResponseBody
	public String teamLeaderProfileLoad(ModelMap model, HttpServletRequest request,@RequestParam String projTeamLeaderId) throws Exception {
		String response = dataFetch.fetchProfile("http://" + ip + ":"+portNo+"/UserManagementService/usermanagementservice/getUserDetailsNew", model, projTeamLeaderId);
		logger.info("editProfileloaddata====="+response);
		return response;
	}
	
	@RequestMapping(value = "/sendMoreInfoRequestToTeamLeader", method = RequestMethod.POST)
	@ResponseBody
	public String sendMoreInfoRequestToTeamLeader(ModelMap model, @ModelAttribute MoreInfoRequiredVO moreInfoRequiredVO, HttpServletRequest request) throws Exception {
		logger.info("sendMoreInfoRequestToTeamLeader Request::" + moreInfoRequiredVO.toString());
		String jsonResponse = dataFetch.sendMoreInfoRequestToTeamLeader("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/sendMoreInfoRequestToTeamLeader", moreInfoRequiredVO);
		logger.info("sendMoreInfoRequestToTeamLeader Response::" + jsonResponse);
		return jsonResponse;
	}
	
	@RequestMapping(value = "/reviewerPasswordReset", method = RequestMethod.POST)
	@ResponseBody
	public String reviewerPasswordReset(ModelMap model, @ModelAttribute PasswordResetVo passwordResetVo, HttpServletRequest request) throws Exception {
		logger.info("reviewerPasswordReset Request1::" + passwordResetVo.toString());
		logger.info("reviewerPasswordReset Request2::" + passwordResetVo.toString());
		String jsonResponse = dataFetch.reviewerPasswordReset("http://" + ip + ":" + portNo + "/UserManagementService/usermanagementservice/reviewerPasswordReset", passwordResetVo);
		logger.info("reviewerPasswordReset Response::" + jsonResponse);
		return jsonResponse;
	}
	
	@RequestMapping(value = "getGytiProjectDocuments")
	@ResponseBody
	public String getGytiProjectDocuments(ModelMap model, @RequestParam String projectId) throws Exception {
		String rgstr = null;
		String jsonRequest = "{\"projId\":" + projectId + ",\"regstrId\":" + rgstr + "}";
		String response = dataFetch.fetchJson("http://" + ip + ":"+portNo+"/techpediaProjectManagementService/projectservice/downloadprojectdocument", jsonRequest);
		logger.info("getGytiProjectDocuments----" + response );
		return response;
	}
	
	@RequestMapping(value = "DownloadZipFile",method = RequestMethod.POST)
	@ResponseBody
	public String DownloadZipFile( HttpServletRequest request,@RequestParam String documentZipLink,@RequestParam String projTitle) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("documentLink", documentZipLink);
		session.setAttribute("projTitle", projTitle);
		//session.setAttribute("docLink", "C:/Users/826862/Desktop/edit proj1.png");

		logger.info("documentLink" + documentZipLink);
		return "\"\"";
	}
	
	@RequestMapping(value = "/DownloadZip" )
	public void DownloadZip(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String filenamestring =(String) session.getAttribute("documentLink");
		String projectTitle = (String) session.getAttribute("projTitle");
		String[] filesLinks = filenamestring.split(",");
		List<String> files = new ArrayList<String>();
		
		for(int i=0;i<filesLinks.length;i++){
			files.add(filesLinks[i]);
		}
		
		FileOutputStream fos = null;
	    ZipOutputStream zipOut = null;
	    FileInputStream fis = null;
	    
	        try {
	        	File zipfile = new File(projectTitle+".zip");
	            fos = new FileOutputStream(zipfile);
	            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
	            byte[] tmp = new byte[1024];
	           
	            for(String filePath:files){
	                File input = new File(filePath);
	                fis = new FileInputStream(input);
	                ZipEntry ze = new ZipEntry(input.getName());
	                zipOut.putNextEntry(ze);
	               
	                int size=0;
	                while((size = fis.read(tmp)) > 0) {
	                    zipOut.write(tmp, 0, size);
	                }
	                zipOut.closeEntry();
	                fis.close();
	            }
	          zipOut.flush();
	          zipOut.close();
              
              
              int BUFFER_SIZE = (int) zipfile.length();
              ServletContext context = request.getServletContext();
			  String appPath = context.getServerInfo();

			  // construct the complete absolute path of the file
			  String fullPath =zipfile.getAbsolutePath();		
			  File downloadFile = new File(fullPath);
			  FileInputStream inputStream = new FileInputStream(downloadFile);

			  // get MIME type of the file
			  String mimeType = context.getMimeType(fullPath);
			  if (mimeType == null) {
					// set to binary type if MIME mapping not found
					mimeType = "application/octet-stream";
			  }
				
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
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally{
	            try{
	                if(fos != null) fos.close();
	            } catch(Exception ex){
	                 
	            }
	        }
		
		
		
	}
}