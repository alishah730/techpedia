package com.techpedia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

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
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.techpedia.bean.AddReviewer;
import com.techpedia.bean.MoreInfoRequiredVO;
import com.techpedia.bean.NotifyReviewerVo;
import com.techpedia.bean.PasswordResetVo;
import com.techpedia.bean.ReviewRatingVO;
import com.techpedia.bean.SignInVo;
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

		logger.info("SI2: " + jsonResponse);
		return jsonResponse;
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
	
	public String rejectSuggestedProjectForReview(String serviceURL, String json){
		String response = restServiceClient(serviceURL, json, "application/json");
		System.err.println("rejectSuggestedProjectForReview RESPONSE: " + response);
		return response;
	}



	public String getTotalGytiProjectsByCategory(String serviceURl) {
		String jsonResponse=restServiceClient(serviceURl,"","application/json");
		return jsonResponse;
	}

	public String addReviewerbyAdmin(String serviceURl, AddReviewer addReviewer) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		String[] parts = addReviewer.getBranchIdString().split(",");
		String[] intArray = new String[parts.length];
		System.err.println("Length 1 : " + parts.length);
		for (int n = 0; n < parts.length; n++) {
			intArray[n] =parts[n];
		}
		ArrayList<String> intArrList = new ArrayList<String>();
		Collections.addAll(intArrList, intArray);
		addReviewer.setBranchIds(intArrList);
		try {
			json=mapper.writeValueAsString(addReviewer);
			response=restServiceClient(serviceURl, json, "application/json");
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public String submitReviewRating(String serviceURl, ReviewRatingVO reviewRating) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		
		try {
			json=mapper.writeValueAsString(reviewRating);
			logger.info("rating JSON Request::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public String fetchProjectDetailGYTI(String serviceURL, String projId,ModelMap model) {
		
		return restServiceClient(serviceURL, projId, "application/json");
	}

	public String fetchReviewRating(String serviceURL, String ratingId, ModelMap model) {
		
		return restServiceClient(serviceURL, ratingId, "application/json");
	}
	
	public String UpdateReviwerByAdmin(String serviceURl, AddReviewer addReviewer) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		String branchString=addReviewer.getBranchIdString();
		System.out.println("branchString length====="+branchString);
		if(branchString!=null){
		String[] parts = addReviewer.getBranchIdString().split(",");
		String[] intArray = new String[parts.length];
		System.err.println("Length 1 : " + parts.length);
		for (int n = 0; n < parts.length; n++) {
			intArray[n] =parts[n];
		}
		ArrayList<String> intArrList = new ArrayList<String>();
		Collections.addAll(intArrList, intArray);
		System.out.println("edit profile branchids====="+intArrList);
		addReviewer.setBranchIds(intArrList);
		}else{
			//System.out.println("else branchString length====="+branchString.length());
			ArrayList<String> intArrList1 = new ArrayList<String>();
			addReviewer.setBranchIds(intArrList1);
		}
		System.out.println("edit profile branch ids JSON Request::"+addReviewer.getBranchIds());
		try {
			json=mapper.writeValueAsString(addReviewer);
			
			System.out.println("edit profile JSON Request::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public String fetchReviewerDetails(String serviceURL, ModelMap model, String id) throws Exception {

		return restServiceClient(serviceURL, id, "application/json");
	}

	public String activateProfile(String serviceURL, String userID) {
		
		return restServiceClient(serviceURL, userID, "application/json");
	}

	public String getTotalProjectsStatistics(String serviceURL) {
		
		return restServiceClient(serviceURL, "", "application/json");
	}

	public String getTotalProjectsYearWiseStatistics (String serviceURL) {

		return restServiceClient(serviceURL, "", "application/json");
	}

	public String getTotalProjectsForParticularYearStatistics(String serviceURL, String year) {
		
		return restServiceClient(serviceURL, year, "application/json");
	}
	
	public String notifySuggestedReviewer(String serviceURl,NotifyReviewerVo notifyReviewerVo) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		
		try {
			json=mapper.writeValueAsString(notifyReviewerVo);
			logger.info("notifyReviewerVo JSON Request::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public String fetchProfile(String serviceURL, ModelMap model, String registerID) throws Exception {
		RegisterID=registerID;
		String jsonResponse = restServiceClient(serviceURL, registerID, "application/json");
		return jsonResponse;
	}
	
	public String sendMoreInfoRequestToTeamLeader(String serviceURl,MoreInfoRequiredVO moreInfoRequiredVO) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		
		try {
			json=mapper.writeValueAsString(moreInfoRequiredVO);
			logger.info("notifyReviewerVo JSON Request::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public String reviewerPasswordReset(String serviceURl, PasswordResetVo passwordResetVo) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		String response="";
		
		try {
			json=mapper.writeValueAsString(passwordResetVo);
			logger.info("notifyReviewerVo JSON Request::"+json);
			response=restServiceClient(serviceURl, json, "application/json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}