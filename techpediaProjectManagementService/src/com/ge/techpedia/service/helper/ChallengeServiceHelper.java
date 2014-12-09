package com.ge.techpedia.service.helper;

import java.util.ArrayList;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.ge.techpedia.service.response.ChallengeServiceResponse;
import com.google.gson.Gson;
import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.ChallengeTypeMasterVO;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.dao.ChallengeDao;
import com.techpedia.projectmanagement.dao.impl.ChallengeDaoImpl;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.UploadChallengeDocException;

public class ChallengeServiceHelper {

static ChallengeDao challengeDao = null;
static ChallengeServiceResponse response = null;
static Gson gson = null;
	
	
	/**
	 * @param challenge
	 * @return
	 */
	public static String createChallenge(Challenge challenge) throws CreateChallengeException{

		String returnVal = null;
		response = new ChallengeServiceResponse();
		try {
			returnVal = getChallengeDao().createChallenge(challenge);
			if(returnVal == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (CreateChallengeException e) {
			throw e;
		}		
	}
	
	/**
	 * @param iterationCount
	 * @return
	 */
	public static String getAllChallenge(String iterationCount) throws GetAllChallengeException{

		ArrayList<Challenge> challenges = null;		
		try {
			challenges = getChallengeDao().getAllChallenge(iterationCount);
			if(challenges != null){
				gson = new Gson();
				return gson.toJson(challenges);
			}
		} catch (GetAllChallengeException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param term
	 * @return
	 */
	public static String getSuggestedChallenges(String term) throws SuggestedChallengeNotFoundException{
		ArrayList<ChallengeTypeMasterVO> suggestedChallenges = null;
		try {
			suggestedChallenges = getChallengeDao().getSuggestedChallenges(term);
			if(suggestedChallenges != null){
				gson = new Gson();
				return gson.toJson(suggestedChallenges);
			}
		} catch (SuggestedChallengeNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	public static String getChallenge(String rgstrId) throws GetChallengeException{
		ArrayList<Challenge> challenges = null;
		try {
			challenges = getChallengeDao().getChallenge(rgstrId);
			if(challenges != null){
				gson = new Gson();
				return gson.toJson(challenges);
			}
		} catch (GetChallengeException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param searchByKeyVO
	 * @return
	 */
	public static String searchChallengeByTitle(SearchByKeyVO searchByKeyVO) throws SearchChallengeException{
		ArrayList<Challenge> challenges = null;
		try {
			challenges = getChallengeDao().searchChallengeByTitle(searchByKeyVO);
			if(challenges != null){
				gson = new Gson();
				return gson.toJson(challenges);
			}
		} catch (SearchChallengeException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param ChallengeId
	 * @return
	 */
	public static String getChallengeDetail(String ChallengeId) throws GetChallengeDetailException{
		Challenge challenge = null;
		try {
			challenge = getChallengeDao().getChallengeDetail(ChallengeId);
			if(challenge != null){
				gson = new Gson();
				return gson.toJson(challenge);
			}
		} catch (GetChallengeDetailException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	/**
	 * @param uploadChallDocVO
	 * @return
	 */	
	public static String uploadChallengeDocument(UploadChallDocVO uploadChallDocVO) throws UploadChallengeDocException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().uploadChallengeDocument(uploadChallDocVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_UPDATE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_UPDATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (UploadChallengeDocException e) {			
			throw e;
		}		
	}
	
	/**
	 * @param challengeDocVO
	 * @return
	 */	
	public static String downloadChallengeDocument(DownChallengeDocVO challengeDocVO) throws DownloadChallengeDocException{
		ArrayList<ProjectDocument> projectDocuments = null;
		try {
			projectDocuments = getChallengeDao().downloadChallengeDocument(challengeDocVO);
			if(projectDocuments != null){
				gson = new Gson();
				return gson.toJson(projectDocuments);
			}
		} catch (DownloadChallengeDocException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */	
	public static String getChallengesByLoggedInUser(String rgstrId) throws ChallengesByLoggedInUserException{
		ArrayList<Challenge> challenges = null;
		try {
			challenges = getChallengeDao().getChallengesByLoggedInUser(rgstrId);
			if(challenges != null){
				gson = new Gson();
				return gson.toJson(challenges);
			}
		} catch (ChallengesByLoggedInUserException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
		
	public static String acceptChallenge(Project project) throws AcceptChallengeException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().acceptChallenge(project);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_ACCEPT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_ACCEPT_FAILURE);
				return gson.toJson(response);
			}
		} catch (AcceptChallengeException e) {			
			throw e;
		}		
	}
		
	public static String deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO) throws DeleteDocumentException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().deleteChallengeDocument(deleteChallDocVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_DOC_DELETE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_DOC_DELETE_FAILURE);
				return gson.toJson(response);
			}
		} catch (DeleteDocumentException e) {			
			throw e;
		}		
	}
	
	private static ChallengeDao getChallengeDao() {
		
		if (challengeDao == null) {
			challengeDao = new ChallengeDaoImpl();
		}
		return challengeDao;
	}
}
