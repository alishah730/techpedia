package com.ge.techpedia.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ge.techpedia.service.helper.ChallengeServiceHelper;
import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeTypeException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.UploadChallengeDocException;

@Path("challengeservice")
public class ChallengeService {
	
	/**
	 * @param challenge
	 * @return
	 */
	@POST
	@Path("createChallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response createChallenge(Challenge challenge) throws CreateChallengeException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.createChallenge(challenge)).type("application/json").build();
	}
	
	/**
	 * @param iterationCount
	 * @return
	 */
	@POST
	@Path("getallchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getAllChallenge(String iterationCount) throws GetAllChallengeException{
		return Response.ok().status(200).entity(ChallengeServiceHelper.getAllChallenge(iterationCount)).type("application/json").build();
	}
	
	/**
	 * @param term
	 * @return
	 */
	@POST
	@Path("getsuggestedchallenges")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getSuggestedChallenges(String term) throws SuggestedChallengeNotFoundException{
		return Response.ok().status(200).entity(ChallengeServiceHelper.getSuggestedChallenges(term)).type("application/json").build();
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getChallenge(String rgstrId) throws GetChallengeException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.getChallenge(rgstrId)).type("application/json").build();
	}
	
	/**
	 * @param searchByKeyVO
	 * @return
	 */
	@POST
	@Path("searchchallengebytitle")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response searchChallengeByTitle(SearchByKeyVO searchByKeyVO) throws SearchChallengeException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.searchChallengeByTitle(searchByKeyVO)).type("application/json").build();
	}
	
	/**
	 * @param ChallengeId
	 * @return
	 */
	@POST
	@Path("getchallengedetail")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getChallengeDetail(String ChallengeId) throws GetChallengeDetailException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.getChallengeDetail(ChallengeId)).type("application/json").build();
	}

	/**
	 * @param uploadChallDocVO
	 * @return
	 */
	@POST
	@Path("uploadchallengedocument")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response uploadChallengeDocument(UploadChallDocVO uploadChallDocVO) throws UploadChallengeDocException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.uploadChallengeDocument(uploadChallDocVO)).type("application/json").build();
	}
	
	/**
	 * @param challengeDocVO
	 * @return
	 */
	@POST
	@Path("downloadchallengedocument")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response downloadChallengeDocument(DownChallengeDocVO challengeDocVO) throws DownloadChallengeDocException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.downloadChallengeDocument(challengeDocVO)).type("application/json").build();
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getchallengesbyloggedinuser")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getChallengesByLoggedInUser(String rgstrId) throws ChallengesByLoggedInUserException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.getChallengesByLoggedInUser(rgstrId)).type("application/json").build();
	}
	
	@POST
	@Path("acceptchallenge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response acceptChallenge(Project project) throws AcceptChallengeException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.acceptChallenge(project)).type("application/json").build();
	}
	
	@POST
	@Path("deletechallengedocument")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO) throws DeleteDocumentException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.deleteChallengeDocument(deleteChallDocVO)).type("application/json").build();
	}
	
	@POST
	@Path("getchallengetype")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getChallengeType() throws GetChallengeTypeException{		
		return Response.ok().status(200).entity(ChallengeServiceHelper.getChallengeType()).type("application/json").build();
	}

}
