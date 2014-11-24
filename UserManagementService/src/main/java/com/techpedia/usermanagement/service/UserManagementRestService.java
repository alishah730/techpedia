package com.techpedia.usermanagement.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.techpedia.usermanagement.dataobject.SearchCriteriaDO;
import com.techpedia.usermanagement.dataobject.UpdateUserPhotoDO;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.service.exception.UserManagementServiceException;
import com.techpedia.usermanagement.service.helper.UserManagementRestServiceHelper;

@Path("/usermanagementservice")
public class UserManagementRestService {
	
	

	@POST
	@Path("/createProfile")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response createProfile(UserProfileDO userprofileDO) throws UserManagementServiceException{

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.createProfile(userprofileDO)).type("application/json").build();

	}
	
	@POST
	@Path("/updateProfile")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response updateProfile(UserProfileDO userprofileDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.updateProfile(userprofileDO)).type("application/json").build();

	}
	
	@POST
	@Path("/deactivateProfile")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response deactivateProfile(String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.deactivateProfile(userID)).type("application/json").build();

	}
	
	@POST
	@Path("/getUserDetails")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response getUserDetails(String registerID) throws UserManagementServiceException {
		
		return Response.ok().status(200).entity(UserManagementRestServiceHelper.getUserDetails(registerID)).type("application/json").build();

	}
	
	@POST
	@Path("/signIn")
	@Consumes("application/json")
	@Produces("application/json")
	public Response signIn(@QueryParam("userName") String userID,@QueryParam("password") String password) throws UserManagementServiceException {
		
		return Response.ok().status(200).entity(UserManagementRestServiceHelper.signIn(userID,password)).type("application/json").build();

	}
	
	@POST
	@Path("/authenticate")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response authenticate(@QueryParam("userName") String userID,@QueryParam("password") String password) throws UserManagementServiceException {
		
		return Response.ok().status(200).entity(UserManagementRestServiceHelper.authenticate(userID,password)).type("application/json").build();

	}
	
	@POST
	@Path("/passwordReset")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response passwordReset(@QueryParam("userName") String userid, @QueryParam("oldpassword") String oldpwd,@QueryParam("newpassword") String newpwd) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.passwordReset(userid,oldpwd,newpwd)).type("application/json").build();

	}
	
	@POST
	@Path("/updatePhoto")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response updatePhoto(UpdateUserPhotoDO updateUserPhotoDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.updatePhoto(updateUserPhotoDO)).type("application/json").build();

	}
	
	@POST
	@Path("/activateProfile")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response activateProfile(@QueryParam("userID") String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.activateProfile(userID)).type("application/json").build();

	}
	
	@POST
	@Path("/emailVerification")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response emailVerification(@QueryParam("email") String email) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.emailVerification(email)).type("application/json").build();

	}
	
	@POST
	@Path("/getUserTeamList")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response getUserTeamList(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.getUserTeamList(registerID)).type("application/json").build();

	}
	
	@POST
	@Path("/getUserRolePermissions")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response getUserRolePermissions(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.getUserRolePermissions(registerID)).type("application/json").build();

	}
	
	@POST
	@Path("/getUserRecentComments")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response getUserRecentComments(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.getUserRecentComments(registerID)).type("application/json").build();

	}
	
	@POST
	@Path("/searchUserProfiles")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response searchUserProfiles(SearchCriteriaDO searchCriteriaDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.searchUserProfiles(searchCriteriaDO)).type("application/json").build();

	}
	
	@POST
	@Path("/getPopularMentorList")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response getPopularMentorList() throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.getPopularMentorList()).type("application/json").build();

	}
	
	@POST
	@Path("/forgotPassword")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response forgotPassword(@QueryParam("email") String email) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.forgotPassword(email)).type("application/json").build();

	}
	
	@POST
	@Path("/searchForMentors")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response searchForMentors(@QueryParam("projId") String projId) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.searchForMentors(projId)).type("application/json").build();

	}

	
	@POST
	@Path("/mentorsOfProject")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response mentorsOfProject(@QueryParam("projId") String projId) throws UserManagementServiceException {

		return Response.ok().status(200).entity(UserManagementRestServiceHelper.mentorsOfProject(projId)).type("application/json").build();

	}

}