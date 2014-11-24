package com.ge.techpedia.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ge.techpedia.bean.Challenge;
import com.ge.techpedia.bean.ChallengeTypeMasterVO;
import com.ge.techpedia.bean.DeleteChallDocVO;
import com.ge.techpedia.bean.DownChallengeDocVO;
import com.ge.techpedia.bean.Project;
import com.ge.techpedia.bean.ProjectDocument;
import com.ge.techpedia.bean.SearchByKeyVO;
import com.ge.techpedia.bean.UploadChallDocVO;
import com.ge.techpedia.dao.ChallengeDao;
import com.ge.techpedia.dao.impl.ChallengeDaoImpl;
import com.ge.techpedia.exception.AcceptChallengeException;
import com.ge.techpedia.exception.ChallengesByLoggedInUserException;
import com.ge.techpedia.exception.CreateChallengeException;
import com.ge.techpedia.exception.DeleteDocumentException;
import com.ge.techpedia.exception.DownloadChallengeDocException;
import com.ge.techpedia.exception.GetAllChallengeException;
import com.ge.techpedia.exception.GetChallengeDetailException;
import com.ge.techpedia.exception.GetChallengeException;
import com.ge.techpedia.exception.SearchChallengeException;
import com.ge.techpedia.exception.SuggestedChallengeNotFoundException;
import com.ge.techpedia.exception.UploadChallengeDocException;

@Path("challengeservice")
public class ChallengeService {

	ChallengeDao challengeDao = null;
	
	
	/**
	 * @param challenge
	 * @return
	 */
	@POST
	@Path("createChallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response createChallenge(Challenge challenge) {

		String returnVal = null;
		
		try {
			returnVal = getChallengeDao().createChallenge(challenge);
		} catch (CreateChallengeException e) {
			returnVal = e.getMessage();
		}
		return Response.status(200).entity(returnVal).build();
	}
	
	/**
	 * @param iterationCount
	 * @return
	 */
	@POST
	@Path("getallchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<Challenge> getAllChallenge(String iterationCount) {

		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		
		try {
			challenges = getChallengeDao().getAllChallenge(iterationCount);
		} catch (GetAllChallengeException e) {
			e.getMessage();
		}
		return challenges;
	}
	
	/**
	 * @param term
	 * @return
	 */
	@POST
	@Path("getsuggestedchallenges")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<ChallengeTypeMasterVO> getSuggestedChallenges(String term){
		ArrayList<ChallengeTypeMasterVO> suggestedChallenges = new ArrayList<ChallengeTypeMasterVO>();
		try {
			suggestedChallenges = getChallengeDao().getSuggestedChallenges(term);
		} catch (SuggestedChallengeNotFoundException e) {
			e.getMessage();
		}
		return suggestedChallenges;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<Challenge> getChallenge(String rgstrId){
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			challenges = getChallengeDao().getChallenge(rgstrId);
		} catch (GetChallengeException e) {
			e.getMessage();
		}
		return challenges;
	}
	
	/**
	 * @param searchByKeyVO
	 * @return
	 */
	@POST
	@Path("searchchallengebytitle")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<Challenge> searchChallengeByTitle(SearchByKeyVO searchByKeyVO){
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			challenges = getChallengeDao().searchChallengeByTitle(searchByKeyVO);
		} catch (SearchChallengeException e) {
			e.getMessage();
		}
		return challenges;
	}
	
	/**
	 * @param ChallengeId
	 * @return
	 */
	@POST
	@Path("getchallengedetail")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Challenge getChallengeDetail(String ChallengeId){
		Challenge challenge = new Challenge();
		try {
			challenge = getChallengeDao().getChallengeDetail(ChallengeId);
		} catch (GetChallengeDetailException e) {
			e.getMessage();
		}
		return challenge;
	}

	/**
	 * @param uploadChallDocVO
	 * @return
	 */
	@POST
	@Path("uploadchallengedocument")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public String uploadChallengeDocument(UploadChallDocVO uploadChallDocVO){
		String result = null;
		try {
			result = getChallengeDao().uploadChallengeDocument(uploadChallDocVO);
		} catch (UploadChallengeDocException e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @param challengeDocVO
	 * @return
	 */
	@POST
	@Path("downloadchallengedocument")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<ProjectDocument> downloadChallengeDocument(DownChallengeDocVO challengeDocVO){
		ArrayList<ProjectDocument> projectDocuments = new ArrayList<ProjectDocument>();
		try {
			projectDocuments = getChallengeDao().downloadChallengeDocument(challengeDocVO);
		} catch (DownloadChallengeDocException e) {			
			e.printStackTrace();
		}
		return projectDocuments;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getchallengesbyloggedinuser")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public ArrayList<Challenge> getChallengesByLoggedInUser(String rgstrId){
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			challenges = getChallengeDao().getChallengesByLoggedInUser(rgstrId);
		} catch (ChallengesByLoggedInUserException e) {			
			e.printStackTrace();
		}
		return challenges;
	}
	
	@POST
	@Path("acceptchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public String acceptChallenge(Project project){
		String result = null;
		try {
			result = getChallengeDao().acceptChallenge(project);
		} catch (AcceptChallengeException e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	@POST
	@Path("deletechallengedocument")
	@Consumes("application/json")
	@Produces({"application/json"})
	public String deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO){
		String result = null;
		try {
			result = getChallengeDao().deleteChallengeDocument(deleteChallDocVO);
		} catch (DeleteDocumentException e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	private ChallengeDao getChallengeDao() {
		
		if (this.challengeDao == null) {
			this.challengeDao = new ChallengeDaoImpl();
		}
		return this.challengeDao;
	}

}
