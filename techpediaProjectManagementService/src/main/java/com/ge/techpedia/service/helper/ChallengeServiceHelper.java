package com.ge.techpedia.service.helper;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.ge.techpedia.service.response.ChallengeServiceResponse;
import com.ge.techpedia.service.response.ProjectServiceResponse;
import com.google.gson.Gson;
import com.techpedia.projectmanagement.bean.AddCommChallengeVO;
import com.techpedia.projectmanagement.bean.AddCommVO;
import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.ChallengeComment;
import com.techpedia.projectmanagement.bean.ChallengeTeam;
import com.techpedia.projectmanagement.bean.ChallengeType;
import com.techpedia.projectmanagement.bean.ChallengeTypeMasterVO;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DeleteChallengeCommVO;
import com.techpedia.projectmanagement.bean.DeleteCommVO;
import com.techpedia.projectmanagement.bean.DisplayChallengeCommVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.FollowChallengeVO;
import com.techpedia.projectmanagement.bean.FollowProjectVO;
import com.techpedia.projectmanagement.bean.ProjFollowVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.SaveProjectPhotoVO;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.dao.ChallengeDao;
import com.techpedia.projectmanagement.dao.ProjectDao;
import com.techpedia.projectmanagement.dao.impl.ChallengeDaoImpl;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.AddCommentException;
import com.techpedia.projectmanagement.exception.ChallengeTeamNotFoundException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CheckChallengeFollowException;
import com.techpedia.projectmanagement.exception.CheckProjectFollowException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.FollowTheChallengeException;
import com.techpedia.projectmanagement.exception.FollowTheProjectException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetAllFollowedChallengeException;
import com.techpedia.projectmanagement.exception.GetAllFollowedProjectException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeTypeException;
import com.techpedia.projectmanagement.exception.RemoveChallengeFollowException;
import com.techpedia.projectmanagement.exception.RemoveCommentException;
import com.techpedia.projectmanagement.exception.SaveProjectPhotoException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.UploadChallengeDocException;
@Service
public class ChallengeServiceHelper {

	private static Logger log = LoggerFactory.getLogger(ChallengeServiceHelper.class.getName());
	
static ChallengeDao challengeDao = null;
static ProjectDao projectDao = null;
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
	public static String getChallengeDetail(String challengeId) throws GetChallengeDetailException{
		Challenge challenge = null;
		try {
			challenge = getChallengeDao().getChallengeDetail(challengeId);
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
		
	public static String acceptChallenge(Project project) throws AcceptChallengeException, SaveProjectPhotoException{
		String result = null;
		String flag = "N";
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().acceptChallenge(project);
			if(!(project.getImgName().equalsIgnoreCase("")&&project.getFooterImgName().equalsIgnoreCase(""))){
				SaveProjectPhotoVO saveProjectPhoto =new SaveProjectPhotoVO();
				saveProjectPhoto.setProjectId(project.getProjId());
				saveProjectPhoto.setImgName(project.getImgName());
				saveProjectPhoto.setImgByteArray(project.getImgByteArray());
				saveProjectPhoto.setFooterImgName(project.getFooterImgName());
				saveProjectPhoto.setFooterImgByteArray(project.getFooterImgByteArray());
				flag = projectDao.uploadProjectPhoto(saveProjectPhoto);
				}
			if(result == "Y" && project.getImgName().equalsIgnoreCase("") && project.getFooterImgName().equalsIgnoreCase("")){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_ACCEPT_SUCCESS);
				return gson.toJson(response);
			}
			else if(result == "Y" && flag == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHALLENGE_ACCEPT_SUCCESS);
				return gson.toJson(response);
			}
			else{
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
	
	public static String getChallengeType() throws GetChallengeTypeException{
		ArrayList<ChallengeType> challengeTypes = null;
		try {
			challengeTypes = getChallengeDao().getChallengeType();
			if(challengeTypes != null){
				gson = new Gson();
				return gson.toJson(challengeTypes);
			}
		} catch (GetChallengeTypeException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	
	public static String followTheChallenge(FollowChallengeVO followChallengeVO) throws FollowTheChallengeException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().followTheChallenge(followChallengeVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FOLLOW_CHALLENGE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FOLLOW_CHALLENGE_FAILURE);
				return gson.toJson(response);
			}
		} catch (FollowTheChallengeException e) {
			throw e;
		}		
	}
	
	
	public static String removeChallengeFollow(FollowChallengeVO followChallengeVO) throws RemoveChallengeFollowException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().removeChallengeFollow(followChallengeVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_FOLLOW_CHALLENGE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.DELETE_FOLLOW_CHALLENGE_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveChallengeFollowException e) {
			throw e;
		}		
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */	
	public static String getAllFollowedChallenges(String rgstrId) throws GetAllFollowedChallengeException{
		ArrayList<Challenge> challenges = null;
		try {
			challenges = getChallengeDao().getAllFollowedChallenges(rgstrId);
			if(challenges != null){
				gson = new Gson();
				return gson.toJson(challenges);
			}
		} catch (GetAllFollowedChallengeException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param followChallengeVO
	 * @return
	 * @throws CheckChallengeFollowException 
	 */
	public static String checkChallengeFollow(FollowChallengeVO followChallengeVO) throws CheckChallengeFollowException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().checkChallengeFollow(followChallengeVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHECK_FOLLOW_CHALLENGE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHECK_FOLLOW_CHALLENGE_FAILURE);
				return gson.toJson(response);
			}
		} catch (CheckChallengeFollowException e) {			
			throw e;
		}
	}
	
	public static String addComment(AddCommChallengeVO addCommChallengeVO) throws AddCommentException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().addComment(addCommChallengeVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.COMMENT_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.COMMENT_ADD_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddCommentException e) {
			throw e;
		}		
	}
	
	
	public static String getComments(DisplayChallengeCommVO displayChallengeComm) throws TeamCommentsNotFoundException{
		ArrayList<ChallengeComment> challengeComments = null;
		try {
			challengeComments = getChallengeDao().getComments(displayChallengeComm);
			if(challengeComments != null){
				gson = new Gson();
				return gson.toJson(challengeComments);
			}
		} catch (TeamCommentsNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public static String deleteChallengeComment(DeleteChallengeCommVO deleteChallengeCommVO) throws RemoveCommentException{
		String result = null;
		response = new ChallengeServiceResponse();
		try {
			result = getChallengeDao().deleteChallengeComment(deleteChallengeCommVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_COMMENT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.DELETE_COMMENT_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveCommentException e) {
			throw e;
		}		
	}
	
	public static String getChallengeTeamList(String challengId) throws ChallengeTeamNotFoundException {
		ArrayList<ChallengeTeam> challengeTeams = null;
		try {
			challengeTeams = getChallengeDao().getChallengeTeamList(challengId);
			if(challengeTeams != null){
				gson = new Gson();
				return gson.toJson(challengeTeams);
			}
		} catch (ChallengeTeamNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	private static ChallengeDao getChallengeDao() {
		
		if (challengeDao == null) {
			challengeDao = new ChallengeDaoImpl();
		}
		return challengeDao;
	}
	

}
