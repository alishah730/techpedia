package com.techpedia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import javax.json.stream.JsonGenerationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.techpedia.bean.AddColgRecentNews;
import com.techpedia.bean.Challenge;
import com.techpedia.bean.PasswordResetVo;
import com.techpedia.bean.Project;
import com.techpedia.bean.SignInVo;
import com.techpedia.bean.SubmitAcademicProjectGyti;
import com.techpedia.bean.SubmitInnovationToGyti;
import com.techpedia.bean.UserProfileVO;
import com.techpedia.util.TechpediaConstants;

@SuppressWarnings("unchecked")
// Using legacy API
@Service
public class DataFetch {

	private static final Logger logger = Logger.getLogger(DataFetch.class);
	public String RegisterID;

	public String fetchJson(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String deleteChallengeDocument(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String getChallengeDocuments(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String projectSpotlight(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	//macro branch datafetch
	public String projectMacrobranchLoad(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}
	public String recentProjectSpotlight(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String challengeDetailsLoad(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String uploadChallengeDocument(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String submitProject(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String getPopularity(String serviceURL, String id) {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String addTeamMember(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String removeTeamMember(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String replaceTeamLead(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String getTeamsListForOneUser(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}


	/*Filter project code starts here*/

	public String statusCompleted(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");

	}
	public String statusWorking(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");

	}
	public String getAllGytiProjects(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");

	}

	/*Filter project code ends here*/

	public String fetchteamDetails(String serviceURL, String id, ModelMap model) throws Exception {
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String getChallengeListForOneUser(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}

	public String getProjectListForOneUser(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}

	public String projectsIFollow(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}

	public String getChallengeTeams(String serviceURL, String challengeId) {
		return restServiceClient(serviceURL, challengeId, "application/json");
	}

	public String challengesIFollow(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}

	public String deleteProject(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}

	public String activateProfile(String serviceURL, String registerId) {
		return restServiceClient(serviceURL, registerId, "application/json");
	}



	public String doesUserFollowProject(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String followProject(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String unfollowProject(String serviceURL, String json) {
		return restServiceClient(serviceURL, json, "application/json");
	}

	public String getTeamComments(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("GET TEAM COMMENTS RESPONSE: " + response);
		return response;
	}

	public String getPublicComments(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("getPublicComments RESPONSE: " + response);
		return response;
	}

	public String postComment(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("postComment RESPONSE: " + response);
		return response;
	}

	public String deleteComment(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("deleteComment RESPONSE: " + response);
		return response;
	}

	public String searchProjectByKeyword(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("searchProjectByKeyword RESPONSE: " + response);
		return response;
	}

	public String getAllProjectsByMacroBranch(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("getAllProjectsByMacroBranch RESPONSE: " + response);
		return response;
	}
	public String searchChallengeByTitle(String serviceURL, String json) {
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("searchChallengeByTitle RESPONSE: " + response);
		return response;
	}

	public String fetchManageProjects(String serviceURL, String registerId) {
		String response = restServiceClient(serviceURL, registerId, "application/json");
		System.err.println("fetchManageProjects RESPONSE: " + response);
		return response;
	}

	public String emailVerification(String serviceURL, String emailId) {
		String response = restServiceClient(serviceURL, emailId, "application/json");
		System.err.println("fetchemailVerification RESPONSE: " + response);
		return response;
	}

	public String addChallengeRequest(Challenge challenge, String serviceURL) {
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		try {
			/*challenge.setChallengStartDate("1410261148400");
			challenge.setChallengCloseDate("1410261148400");*/
			challenge.setChallengYear(challenge.getChallengStartDate().getYear()+1900);
			challenge.setChallengCommentsPublish("Y");
			System.out.println("challengevalues" + challenge.getChallengTypeId());
			String json = mapper.writeValueAsString(challenge);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in addProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}

	public String fetchMentorDetails(String serviceURL, ModelMap model, String id) throws Exception {
		// TODO Auto-generated method stub
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String fetchfacultyDetails(String serviceURL, ModelMap model, String id) throws Exception {
		// TODO Auto-generated method stub
		return restServiceClient(serviceURL, id, "application/json");
	}
	public String fetchStudentDetails(String serviceURL, ModelMap model, String id) throws Exception {
		// TODO Auto-generated method stub
		return restServiceClient(serviceURL, id, "application/json");
	}

	public String fetchMentors(String serviceURL, ModelMap model, String set) throws Exception {
		// TODO Auto-generated method stub
		String response = restServiceClient(serviceURL, set, "application/json");
		return response;
	}

	public String fetchEditProfile(String serviceURL, ModelMap model, String registerID) throws Exception {
		RegisterID=registerID;
		String jsonResponse = restServiceClient(serviceURL, registerID, "application/json");
		return jsonResponse;
	}

	public String editProfileRequest(UserProfileVO editProfile, String serviceURL) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String response = "";
		try {
			String json = mapper.writeValueAsString(editProfile);
			logger.debug(json);
			System.out.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in editProfileRequest@DataFetch.java - " + e.toString());
		}
		return response;
	}


	public String newFacultyRequest(UserProfileVO editProfile, String serviceURL) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String response = "";
		try {
			String json = mapper.writeValueAsString(editProfile);
			System.err.println("for new service for new Faculty"+json);
			logger.debug(json);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in newFacultyRequest@DataFetch.java - " + e.toString());
		}
		return response;
	}


	public String changePassword(String serviceURL, PasswordResetVo changePassword) {
		//String jsonResponse = restServiceClient(serviceURL + "?userName=" + changePassword.getUserName() + "&oldpassword=" + changePassword.getOldPassword() + "&newpassword=" + changePassword.getNewPassword(), "", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String jsonResponse="";
		try {
			String json = mapper.writeValueAsString(changePassword);
			logger.debug(json);
			jsonResponse = restServiceClient(serviceURL,json,"application/json");
			logger.debug(jsonResponse);
		} catch (Exception e) {

		}

		System.err.println("changePassword Response - " + jsonResponse);
		return jsonResponse;
	}




	public String setPasswordFac(String serviceURL, PasswordResetVo changePassword) {
		//String jsonResponse = restServiceClient(serviceURL + "?userName=" + changePassword.getUserName() + "&oldpassword=" + changePassword.getOldPassword() + "&newpassword=" + changePassword.getNewPassword(), "", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String jsonResponse="";
		try {
			String json = mapper.writeValueAsString(changePassword);
			logger.debug(json);
			jsonResponse = restServiceClient(serviceURL,json,"application/json");
			logger.debug(jsonResponse);
		} catch (Exception e) {

		}


		System.err.println("setPassswordFac Response - " + jsonResponse);
		return jsonResponse;
	}



	public String signIn(String serviceURL,SignInVo login) {
		//String hitURL = serviceURL + "?userName=" + login.getUsername() + "&" + "password=" + login.getPassword();
		//System.err.println("SI1: " + hitURL);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String jsonResponse="";
		try {
			String json = mapper.writeValueAsString(login);
			logger.debug(json);
			System.out.println("Login" + json);
			jsonResponse = restServiceClient(serviceURL,json,"application/json");
			logger.debug(jsonResponse);
		} catch (Exception e) {
			logger.debug("Exception in signIn@DataFetch.java - " + e.toString());
		}

		System.err.println("SI2: " + jsonResponse);
		return jsonResponse;
	}

	public String socialSignIn(String serviceURL, String emailId) {
		String jsonResponse="";
		try {
			jsonResponse = restServiceClient(serviceURL,emailId,"application/json");
			logger.debug(jsonResponse);
		} catch (Exception e) {
			logger.debug("Exception in socialsignIn@DataFetch.java - " + e.toString());
		}

		System.err.println("fetchsocialSignIn RESPONSE: " + jsonResponse);
		return jsonResponse;

	}

	public String getSuggestedFaculty(String serviceURL, String q) throws Exception {
		String jsonResponse = restServiceClient(serviceURL, q, "application/json");
		return jsonResponse;
	}
	public String getsuggestedchallenges(String serviceURL, String post) {
		String jsonResponse = restServiceClient(serviceURL, post, "application/json");
		System.err.println(jsonResponse);
		return jsonResponse;
	}

	public String getSuggestedKeywords(String serviceURL, String q) throws Exception {
		ArrayList<String> parts = new ArrayList<String>();
		Collections.addAll(parts, q.split(","));

		Iterator<String> iterator = parts.iterator();
		String jsonRequest = "";
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			string = string.trim();
			if (string != null) {
				if (!string.equals("")) {
					jsonRequest += "\"" + string + "\",";
				}
			}
		}
		jsonRequest = "[" + jsonRequest + "]";
		jsonRequest = jsonRequest.replace(",]", "]");
		String jsonResponse = restServiceClient(serviceURL, jsonRequest, "application/json");
		return jsonResponse;
	}
	public String addProjectRequest(Project project, String serviceURL,String registerID) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);


		if (("undefined".equalsIgnoreCase(project.getChallengId())) || (project.getChallengId() == null ))
		{
			project.setChallengId(null);
			project.setProjIsForChallenge("N");
		}

		else{
			project.setProjIsForChallenge("Y");

		}    
		String response = "";
		try {

			//ProjectTeamLead Id set...........
			long projectTeamLeadId=Long.parseLong(registerID);
			project.setProjTeamLeaderId(projectTeamLeadId);
			// PART OF FIX
			String[] parts = project.getProjBranchesString().split(",");
			Integer[] intArray = new Integer[parts.length];
			System.err.println("Length 1 : " + parts.length);
			for (int n = 0; n < parts.length; n++) {
				intArray[n] = Integer.parseInt(parts[n]);
			}
			ArrayList<Integer> intArrList = new ArrayList<Integer>();
			Collections.addAll(intArrList, intArray);
			project.setProjBranches(intArrList);
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, project.getProjKeywordsString().split(","));

			project.setProjKeywords(strArrList);
			// ------------------------------------------
			String teamMembers=project.getProjTeamMembersString();
			if(teamMembers.length()!=0){
				String[] parts2 = project.getProjTeamMembersString().split(",");
				String[] subPrts2=parts2;

				for(int i=0;i<parts2.length;i++){
					String newValue=parts2[i];
					subPrts2[i]=newValue.substring(newValue.lastIndexOf("-") + 1).trim();

				}
				/*Long[] longArray = new Long[parts2.length];

		System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
				/*System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
				Long[] longArray = new Long[subPrts2.length];

				System.err.println("Length 2 of subprts : " + subPrts2.length);
				for (int n = 0; n < subPrts2.length; n++) {
					longArray[n] = Long.parseLong(subPrts2[n]);
				}
				ArrayList<Long> longArrList = new ArrayList<Long>();
				longArrList.add(project.getProjTeamLeaderId());
				Collections.addAll(longArrList, longArray);
				project.setProjTeamMembers(longArrList);
			}
			else{
				ArrayList<Long> longArrList1 = new ArrayList<Long>();
				project.setProjTeamMembers(longArrList1);
			}
			// END PART OF FIX

			System.err.println(project.getProjTeamId());
			String json = mapper.writeValueAsString(project);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in addProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}



	public String submitProjectToGytiRequest(SubmitInnovationToGyti submitInnovationToGyti, String serviceURL,String registerID) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);


		/*if (("undefined".equalsIgnoreCase(project.getChallengId())) || (project.getChallengId() == null ))
		{
			project.setChallengId(null);
		   project.setProjIsForChallenge("N");
		   }

		   else{
		    project.setProjIsForChallenge("Y");

		}    */
		String response = "";
		try {

			//ProjectTeamLead Id set...........
			long projectTeamLeadId=Long.parseLong(registerID);
			submitInnovationToGyti.setProjTeamLeaderId(projectTeamLeadId);
			// PART OF FIX
			String[] parts = submitInnovationToGyti.getProjBranchesString().split(",");
			Integer[] intArray = new Integer[parts.length];
			System.err.println("Length 1 : " + parts.length);
			for (int n = 0; n < parts.length; n++) {
				intArray[n] = Integer.parseInt(parts[n]);
			}
			ArrayList<Integer> intArrList = new ArrayList<Integer>();
			Collections.addAll(intArrList, intArray);
			submitInnovationToGyti.setProjBranches(intArrList);
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, submitInnovationToGyti.getProjKeywordsString().split(","));

			submitInnovationToGyti.setProjKeywords(strArrList);

			//System.out.println("project status info===="+submitInnovationToGyti.getProjStatusInfo());
			/*ArrayList<String> strArrList1 = new ArrayList<String>();
		Collections.addAll(strArrList1, submitInnovationToGyti.getProjStatusInfo().split(","));

		submitInnovationToGyti.setProjKeywords(strArrList1);*/


			// ------------------------------------------
			String teamMembers=submitInnovationToGyti.getProjTeamMembersString();
			if(teamMembers.length()!=0){
				String[] parts2 = submitInnovationToGyti.getProjTeamMembersString().split(",");
				System.out.println("parts2 length===="+parts2.length+"=="+parts2);
				for(int j=0;j<parts2.length;j++){
					System.out.println("parts2 value===="+"j=="+j+"="+parts2[j]);
				}

				String[] subPrts2=parts2;

				for(int i=0;i<parts2.length;i++){
					String newValue=parts2[i];
					subPrts2[i]=newValue.substring(newValue.lastIndexOf("-") + 1).trim();

				}
				/*Long[] longArray = new Long[parts2.length];

		System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
				/*System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
				Long[] longArray = new Long[subPrts2.length];

				System.err.println("Length 2 of subprts : " + subPrts2.length);
				for (int n = 0; n < subPrts2.length; n++) {
					longArray[n] = Long.parseLong(subPrts2[n]);
				}
				ArrayList<Long> longArrList = new ArrayList<Long>();
				longArrList.add(submitInnovationToGyti.getProjTeamLeaderId());
				Collections.addAll(longArrList, longArray);
				submitInnovationToGyti.setProjTeamMembers(longArrList);
			}
			else{
				ArrayList<Long> longArrList1 = new ArrayList<Long>();
				submitInnovationToGyti.setProjTeamMembers(longArrList1);
			}
			// END PART OF FIX

			System.err.println(submitInnovationToGyti.getProjTeamId());
			String json = mapper.writeValueAsString(submitInnovationToGyti);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in addProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}


	public String editProjectRequest(Project edit, String serviceURL,String registerID) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);


		String response = "";
		try {

			//ProjectTeamLead Id set...........
			long projectTeamLeadId=Long.parseLong(registerID);
			edit.setProjTeamLeaderId(projectTeamLeadId);




			// PART OF FIX
			/*	String[] parts = edit.getProjBranchesString().split(",");
		Integer[] intArray = new Integer[parts.length];
		System.err.println("Length 1 : " + parts.length);
		for (int n = 0; n < parts.length; n++) {
		intArray[n] = Integer.parseInt(parts[n]);
		}
		ArrayList<Integer> intArrList = new ArrayList<Integer>();
		Collections.addAll(intArrList, intArray);
		edit.setProjBranches(intArrList);*/
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, edit.getProjKeywordsString().split(","));

			edit.setProjKeywords(strArrList);
			// ------------------------------------------
			/*String[] parts2 = edit.getProjTeamMembersString().split(",");
				String[] subPrts2=parts2;*/

			/*for(int i=0;i<parts2.length;i++){
			String newValue=parts2[i];
			subPrts2[i]=newValue.substring(newValue.lastIndexOf("-") + 1).trim();

		}*/
			/*Long[] longArray = new Long[parts2.length];

		System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
			/*System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
			/*	Long[] longArray = new Long[subPrts2.length];

		System.err.println("Length 2 of subprts : " + subPrts2.length);
		for (int n = 0; n < subPrts2.length; n++) {
		longArray[n] = Long.parseLong(subPrts2[n]);
		}
		ArrayList<Long> longArrList = new ArrayList<Long>();
		longArrList.add(edit.getProjTeamLeaderId());
		Collections.addAll(longArrList, longArray);
		edit.setProjTeamMembers(longArrList);
		// END PART OF FIX
			 */
			System.err.println(edit.getProjTeamId());
			String json1 = mapper.writeValueAsString(edit.getProjTeamId());
			String json = mapper.writeValueAsString(edit);
			System.err.println(json1);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			System.out.println(response+"---sdfsdf----");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in editProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}






	public String editInnovationRequest(SubmitInnovationToGyti submitInnovationToGyti, String serviceURL,String registerID) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);


		String response = "";
		try {

			//ProjectTeamLead Id set...........
			long projectTeamLeadId=Long.parseLong(registerID);
			submitInnovationToGyti.setProjTeamLeaderId(projectTeamLeadId);




			// PART OF FIX
			/*	String[] parts = edit.getProjBranchesString().split(",");
		Integer[] intArray = new Integer[parts.length];
		System.err.println("Length 1 : " + parts.length);
		for (int n = 0; n < parts.length; n++) {
		intArray[n] = Integer.parseInt(parts[n]);
		}
		ArrayList<Integer> intArrList = new ArrayList<Integer>();
		Collections.addAll(intArrList, intArray);
		edit.setProjBranches(intArrList);*/
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, submitInnovationToGyti.getProjKeywordsString().split(","));

			submitInnovationToGyti.setProjKeywords(strArrList);
			// ------------------------------------------
			/*String[] parts2 = edit.getProjTeamMembersString().split(",");
				String[] subPrts2=parts2;*/

			/*for(int i=0;i<parts2.length;i++){
			String newValue=parts2[i];
			subPrts2[i]=newValue.substring(newValue.lastIndexOf("-") + 1).trim();

		}*/
			/*Long[] longArray = new Long[parts2.length];

		System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
			/*System.err.println("Length 2 : " + parts2.length);
		for (int n = 0; n < parts2.length; n++) {
		longArray[n] = Long.parseLong(parts2[n]);
		}*/
			/*	Long[] longArray = new Long[subPrts2.length];

		System.err.println("Length 2 of subprts : " + subPrts2.length);
		for (int n = 0; n < subPrts2.length; n++) {
		longArray[n] = Long.parseLong(subPrts2[n]);
		}
		ArrayList<Long> longArrList = new ArrayList<Long>();
		longArrList.add(edit.getProjTeamLeaderId());
		Collections.addAll(longArrList, longArray);
		edit.setProjTeamMembers(longArrList);
		// END PART OF FIX
			 */
			System.err.println(submitInnovationToGyti.getProjTeamId());
			String json1 = mapper.writeValueAsString(submitInnovationToGyti.getProjTeamId());
			String json = mapper.writeValueAsString(submitInnovationToGyti);
			System.err.println(json1);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			System.out.println("---editInnovation Request----"+response);
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in editProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}










	/*	public String addProjectRequest(Project project, String serviceURL,long registerID) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		long regID = Long.parseLong(RegisterID);
	   System.out.println("uuuuuuuuuu"+regID);
		project.setProjTeamLeaderId(regID);
		if ("undefined".equalsIgnoreCase(project.getChallengId()))
			{project.setChallengId(null);
		    project.setProjIsForChallenge("N");
		    }

		    else{
		    	 project.setProjIsForChallenge("Y");

	}		    
		String response = "";
		try {
			// PART OF FIX
			//set Team Leader ID

			long projectTeamLeadId=Long.parseLong(registerID);
			project.setProjTeamLeaderId(projectTeamLeadId);
			String[] parts = project.getProjBranchesString().split(",");
			Integer[] intArray = new Integer[parts.length];
			System.err.println("Length 1 : " + parts.length);
			for (int n = 0; n < parts.length; n++) {
				intArray[n] = Integer.parseInt(parts[n]);
			}
			ArrayList<Integer> intArrList = new ArrayList<Integer>();
			Collections.addAll(intArrList, intArray);
			project.setProjBranches(intArrList);
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, project.getProjKeywordsString().split(","));
			project.setProjKeywords(strArrList);
			// ------------------------------------------
			String[] parts2 = project.getProjTeamMembersString().split(",");
			Long[] longArray = new Long[parts2.length];
			System.err.println("Length 2 : " + parts2.length);
			for (int n = 0; n < parts2.length; n++) {
				longArray[n] = Long.parseLong(parts2[n]);
			}
			ArrayList<Long> longArrList = new ArrayList<Long>();
			longArrList.add(project.getProjTeamLeaderId());
			Collections.addAll(longArrList, longArray);
			project.setProjTeamMembers(longArrList);
			// END PART OF FIX
			String json = mapper.writeValueAsString(project);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in addProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}*/

	public String acceptChallengeRequest(Project project, String serviceURL) {
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		try {
			// PART OF FIX
			String[] parts = project.getProjBranchesString().split(",");
			Integer[] intArray = new Integer[parts.length];
			System.err.println("Length 1 : " + parts.length);
			for (int n = 0; n < parts.length; n++) {
				intArray[n] = Integer.parseInt(parts[n]);
			}
			ArrayList<Integer> intArrList = new ArrayList<Integer>();
			Collections.addAll(intArrList, intArray);
			project.setProjBranches(intArrList);
			// ------------------------------------------
			ArrayList<String> strArrList = new ArrayList<String>();
			Collections.addAll(strArrList, project.getProjKeywordsString().split(","));
			project.setProjKeywords(strArrList);
			// ------------------------------------------
			String[] parts2 = project.getProjTeamMembersString().split(",");
			Long[] longArray = new Long[parts2.length];
			System.err.println("Length 2 : " + parts2.length);
			for (int n = 0; n < parts2.length; n++) {
				longArray[n] = Long.parseLong(parts2[n]);
			}
			ArrayList<Long> longArrList = new ArrayList<Long>();
			Collections.addAll(longArrList, longArray);
			project.setProjTeamMembers(longArrList);
			// END PART OF FIX
			String json = mapper.writeValueAsString(project);
			System.err.println(json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in addProjectRequest@DataFetch.java - " + e.toString());
			e.printStackTrace();
		}
		return response;
	}

	public String registerRequest(UserProfileVO register, String serviceURL) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
		String response = "";
		try {
			String json = mapper.writeValueAsString(register);
			logger.info("Request" + json);
			response = restServiceClient(serviceURL, json, "application/json");
			logger.debug(response);
		} catch (Exception e) {
			logger.debug("Exception in registerRequest@DataFetch.java - " + e.toString());
		}
		return response;
	}

	public ModelMap fetchFooter(ModelMap model, String url) throws Exception {
		/*model = fetchHomePageEntrepreneurs(url + "/fakejson/homeEntrepreneurs.abc", model);
		model = fetchHomePagePartners(url + "/fakejson/homePartners.abc", model);*/
		return model;
	}

	public ModelMap fetchHomePageMentors(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData1 = new ArrayList<String>();
		ArrayList<String> actualData2 = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String imageURL = (String) loopObject.get("imageURL");
			String imageClickURL = (String) loopObject.get("imageClickURL");
			actualData1.add(imageURL);
			actualData2.add(imageClickURL);
		}
		model.addAttribute("mentors", actualData1);
		model.addAttribute("mentorsURL", actualData2);
		return model;
	}

	/*	public ModelMap fetchHomePageEntrepreneurs(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String imageURL = (String) loopObject.get("imageURL");
			actualData.add(imageURL);
		}
		model.addAttribute("entrepreneurs", actualData);
		return model;
	}*/

	public String fetchProjects(String serviceURL, ModelMap model, String set) throws Exception {
		String response = restServiceClient(serviceURL, set, "application/json");
		return response;
	}

	public ModelMap fetchMentors(String serviceURL, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String mentorName = (String) loopObject.get("mentorName");
			String mentorDesignation = (String) loopObject.get("mentorDesignation");
			String mentorImage = (String) loopObject.get("mentorImage");

			actualData.add(mentorName);
			actualData.add(mentorDesignation);
			actualData.add(mentorImage);
		}
		model.addAttribute("viewMentors", actualData);
		return model;
	}

	public ModelMap fetchCollaborate(String serviceURL, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String userName = (String) loopObject.get("userName");
			String type = (String) loopObject.get("type");
			String userImage = (String) loopObject.get("userImage");

			actualData.add(userName);
			actualData.add(type);
			actualData.add(userImage);
		}
		model.addAttribute("viewCollaborate", actualData);
		return model;
	}

	public ModelMap fetchAdditionalCollaborate(String serviceURL, ModelMap model, String set) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();

		JSONObject jsonObject = (JSONObject) parser.parse(restClient(serviceURL, set, "post"));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String userName = (String) loopObject.get("userName");
			String type = (String) loopObject.get("type");
			String userImage = (String) loopObject.get("userImage");

			actualData.add(userName);
			actualData.add(type);
			actualData.add(userImage);
		}
		model.addAttribute("additionalCollaborate", actualData);
		return model;
	}

	public String fetchChallenges(String serviceURL, ModelMap model, String set) throws Exception {
		// TODO Auto-generated method stub
		String response = restServiceClient(serviceURL, set, "application/json");
		return response;
	}

	public String restClient(String url, String data, String type) {
		String output = "";
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("set", data));

			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				output += line;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(output);
		return output;
	}

	public String restServiceClient(String url, String data, String type) {
		String responseString = "";
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			StringEntity input = new StringEntity(data);
			input.setContentType(type);
			post.setEntity(input);
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				responseString += line;
			}
		} catch (Exception e) {
			logger.debug("Exception in REST SERVICE CLIENT " + e.toString());
			e.printStackTrace();
		}
		return responseString;
	}

	public ModelMap fetchMentorDetails(String serviceURL, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String mentorName = (String) loopObject.get("mentorName");
			String mentorAddress = (String) loopObject.get("mentorAddress");
			String mentorPersonal = (String) loopObject.get("mentorPersonal");
			String mentorCity = (String) loopObject.get("mentorCity");
			String mentorState = (String) loopObject.get("mentorState");
			String mentorCountry = (String) loopObject.get("mentorCountry");
			String mentorZipcode = (String) loopObject.get("mentorZipcode");
			String mentorPosition = (String) loopObject.get("mentorPosition");
			String mentorDegree = (String) loopObject.get("mentorDegree");
			String mentorAssociation = (String) loopObject.get("mentorAssociation");
			String mentorExperience = (String) loopObject.get("mentorExperience");
			String mentorSocieties = (String) loopObject.get("mentorSocieties");
			String mentorAlumni = (String) loopObject.get("mentorAlumni");
			String mentorImage = (String) loopObject.get("mentorImage");

			actualData.add(mentorName);
			actualData.add(mentorAddress);
			actualData.add(mentorPersonal);
			actualData.add(mentorCity);
			actualData.add(mentorState);
			actualData.add(mentorCountry);
			actualData.add(mentorZipcode);
			actualData.add(mentorPosition);
			actualData.add(mentorDegree);
			actualData.add(mentorAssociation);
			actualData.add(mentorExperience);
			actualData.add(mentorSocieties);
			actualData.add(mentorAlumni);
			actualData.add(mentorImage);
		}
		model.addAttribute("viewMentorDetails", actualData);
		return model;
	}

	public ModelMap fetchHomePageTestimonials(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String testimonial = (String) loopObject.get("testimonial");
			String cite = (String) loopObject.get("cite");
			actualData.add(testimonial);
			actualData.add(cite);
		}
		model.addAttribute("testimonials", actualData);
		return model;
	}

	public ModelMap fetchHomePageProjectSpotlight(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String name = (String) loopObject.get("name");
			String image = (String) loopObject.get("image");
			String description = (String) loopObject.get("description");

			if (image.trim().equalsIgnoreCase("")) {
				image = "images/project.png";
			}

			actualData.add(name);
			actualData.add(image);
			actualData.add(description);
		}
		model.addAttribute("projectSpotlights", actualData);
		return model;
	}

	public ModelMap fetchHomePagePartners(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData1 = new ArrayList<String>();
		ArrayList<String> actualData2 = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String imageURL = (String) loopObject.get("imageURL");
			String imageClickURL = (String) loopObject.get("imageClickURL");
			actualData1.add(imageURL);
			actualData2.add(imageClickURL);
		}
		model.addAttribute("partners", actualData1);
		model.addAttribute("partnersURL", actualData2);
		return model;
	}

	public ModelMap fetchRegisterPageRecentRegistrations(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String name = (String) loopObject.get("name");
			String image = (String) loopObject.get("image");
			actualData.add(name);
			actualData.add(image);
		}
		model.addAttribute("recentRegistrations", actualData);
		return model;
	}

	public ModelMap fetchSuggestedKeywords(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String keyword = (String) loopObject.get("keyword");
			actualData.add(keyword);
		}
		model.addAttribute("keywords", actualData);
		return model;
	}

	public ModelMap fetchSuggestedColleges(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String place = (String) loopObject.get("place");
			String college = (String) loopObject.get("college");
			actualData.add(college);
			actualData.add(place);
		}
		model.addAttribute("name", actualData);
		return model;
	}

	public String fetchSuggestedTeamMembers(String serviceURL, UserProfileVO search) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		String json = mapper.writeValueAsString(search);
		System.err.println("fetchSuggestedTeamMembers: request:" + json);
		String jsonResponse = restServiceClient(serviceURL, json, "application/json");
		return jsonResponse;
	}

	public String fetchSuggestedTeamMembersOld(String serviceURL, UserProfileVO search) throws Exception {
		ModelMap model= new ModelMap();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		String json = mapper.writeValueAsString(search);
		System.err.println(json);
		JSONParser parser = new JSONParser();
		String jsonResponse = restServiceClient(serviceURL, json, "application/json");
		System.err.println(jsonResponse);
		JSONArray dataArray = (JSONArray) parser.parse(jsonResponse);
		Iterator<JSONArray> iterator = dataArray.iterator();
		ArrayList<Project>actualData=new ArrayList<Project>();
		Project projbj=new Project();
		String responseHTML = "";
		while (iterator.hasNext()) {
			JSONArray loopObject = (JSONArray) iterator.next();
			Long memberID = (Long) loopObject.get(0);
			String memberName = (String) loopObject.get(1);
			//responseHTML += "<option value=\"" + memberID + "\">" + memberName + " - " + memberID + "</option>";
			responseHTML += "<option value=\"" + memberName +"-"+ memberID+ "\">" + memberName + " - " + memberID + "</option>";

			System.out.println("response of fetched TEam from DB"+responseHTML);
		}
		/*while (iterator.hasNext()) {

			JSONArray loopObject = (JSONArray) iterator.next();
			Long memberID = (Long) loopObject.get(0);
			String memberName = (String) loopObject.get(1);
			//responseHTML += "<option value=\"" + memberID + "\">" + memberName + " - " + memberID + "</option>";
			responseHTML += "<option value=\"" + memberName + "\">" + memberName + " - " + memberID + "</option>";

projbj.setProjTeamId(memberID);
projbj.setProjTeamMembersString(memberName);
actualData.add(projbj);
			System.out.println("response of fetched TEam from DB"+responseHTML);
		}

		model.addAttribute("addedTeamMembers", actualData);
		return model;*/
		return responseHTML;
	}

	public ModelMap fetchAddProjectFaculty(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String name = (String) loopObject.get("name");
			String designation = (String) loopObject.get("designation");
			String branch = (String) loopObject.get("branch");
			actualData.add(name);
			actualData.add(designation);
			actualData.add(branch);
		}
		model.addAttribute("addProjectFaculty", actualData);
		return model;
	}

	public ModelMap fetchAddProjectBranches(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String branch = (String) loopObject.get("branch");
			actualData.add(branch);
		}
		model.addAttribute("branches", actualData);
		return model;
	}

	public String readURL(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public ModelMap fetchChallengesDetails(String serviceURL, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String challengeKeywords = (String) loopObject.get("challengeKeywords");
			String challengeTitle = (String) loopObject.get("challengeTitle");
			String challengePersonalInfo = (String) loopObject.get("challengePersonalInfo");
			String challengeField = (String) loopObject.get("challengeField");

			String cCollegeName = (String) loopObject.get("cCollegeName");

			String challengeDescription = (String) loopObject.get("challengeDescription");
			String challengeReferences = (String) loopObject.get("challengeReferences");
			String challengeImage = (String) loopObject.get("challengeImage");
			actualData.add(challengeKeywords);
			actualData.add(challengeTitle);
			actualData.add(challengePersonalInfo);
			actualData.add(challengeField);
			actualData.add(cCollegeName);
			actualData.add(challengeDescription);
			actualData.add(challengeReferences);
			actualData.add(challengeImage);
		}
		model.addAttribute("challengedetails", actualData);
		return model;
	}

	public String fetchProjectDetail(String serviceURL, String id) throws Exception {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		String model1 = restServiceClient(serviceURL, id, "application/json");
		/*ObjectMapper mapper = new ObjectMapper();
		Project project = mapper.readValue(jsonObject.toJSONString(), Project.class);
		System.out.println(project);
		model1.addAttribute("projectdetails", project);*/
		System.out.println("project details are: " + model1);
		return model1;
	}

	public String getSuggestedBranches(String serviceURL, String post) {
		String jsonResponse = restServiceClient(serviceURL, post, "application/json");
		System.err.println(jsonResponse);
		return jsonResponse;
	}

	public String getUniversityList(String serviceURL, String post) {
		String jsonResponse = restServiceClient(serviceURL, post, "application/json");
		logger.info(jsonResponse);
		return jsonResponse;
	}

	public String getCollegeList(String serviceURL, String postParams){
		String jsonResponse = restServiceClient(serviceURL, postParams, TechpediaConstants.SERVICE_RETURN_TYPE);
		logger.info(jsonResponse);
		return jsonResponse;
	}

	public String getStateList(String serviceURL, String postParams){
		String jsonResponse = restServiceClient(serviceURL, postParams, TechpediaConstants.SERVICE_RETURN_TYPE);
		logger.info(jsonResponse);
		return jsonResponse;
	}
	public String getCityList(String serviceURL, String json){
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("getCityList RESPONSE: " + response);
		return response;
	}





	public ModelMap fetchprojectComments(String serviceURL, ModelMap model) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(readURL(serviceURL));
		JSONArray dataArray = (JSONArray) jsonObject.get("array");
		Iterator<JSONObject> iterator = dataArray.iterator();
		ArrayList<String> actualData = new ArrayList<String>();
		while (iterator.hasNext()) {
			JSONObject loopObject = (JSONObject) iterator.next();
			String name = (String) loopObject.get("name");
			String comment = (String) loopObject.get("comment");
			actualData.add(name);
			actualData.add(comment);

		}
		model.addAttribute("comments", actualData);
		return model;
	}

	public String submitAcademicProjectToGyti(String serviceURL, SubmitAcademicProjectGyti submitAcademicProjectToGyti) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		try {
			json = mapper.writeValueAsString(submitAcademicProjectToGyti);
			System.out.println("GYTI"+ json);
			response = restServiceClient(serviceURL, json, "application/json");
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.err.println("submitAcademicProjectToGyti RESPONSE: " + response);
		return response;
	} 
	public String addColgRecentNews(String serviceURl, AddColgRecentNews addColgRcntNews){

		Date currentDate= new Date();
		long lnMilliseconds = currentDate.getTime();
		String milliseconds = String.valueOf(lnMilliseconds);
		System.out.println("College Name::"+addColgRcntNews.getColgName());
		System.out.println("Current date::"+currentDate+" and Date in millisecond ::"+milliseconds);
		addColgRcntNews.setNewsDate(milliseconds);
		ObjectMapper mapper=new ObjectMapper();
		String json;
		String response="";
		try {
			json=mapper.writeValueAsString(addColgRcntNews);
			System.out.println("JSON request to add college recent news ::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
			System.out.println("Response from datafectch::"+response);
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;	
	}

	public String getTotalGytiProjectsByCategory(String serviceURl) {
		String jsonResponse=restServiceClient(serviceURl,"","application/json");
		return jsonResponse;
	}
	
	public String getDegreeList(String serviceURL, String postParams){
		String jsonResponse = restServiceClient(serviceURL, postParams, "application/json");
		logger.info(jsonResponse);
		return jsonResponse;
	}


}