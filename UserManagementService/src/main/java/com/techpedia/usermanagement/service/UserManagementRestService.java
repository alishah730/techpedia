package com.techpedia.usermanagement.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.usermanagement.dataobject.MoreInfoRequiredDO;
import com.techpedia.usermanagement.dataobject.NotifyReviewerVo;
import com.techpedia.usermanagement.dataobject.PasswordResetVo;
import com.techpedia.usermanagement.dataobject.RecentNewsDO;
import com.techpedia.usermanagement.dataobject.ReviewerDO;
import com.techpedia.usermanagement.dataobject.SaveUserPhoto;
import com.techpedia.usermanagement.dataobject.SearchCityDO;
import com.techpedia.usermanagement.dataobject.SearchCollegeDO;
import com.techpedia.usermanagement.dataobject.SearchCriteriaDO;
import com.techpedia.usermanagement.dataobject.SignInVo;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.dataobject.contactUs;
import com.techpedia.usermanagement.exception.AddNewReviewerException;
import com.techpedia.usermanagement.exception.CityFetchException;
import com.techpedia.usermanagement.exception.CollegeRecentNewsException;
import com.techpedia.usermanagement.exception.CollegesFetchException;
import com.techpedia.usermanagement.exception.GetCollegeFacultyException;
import com.techpedia.usermanagement.exception.GetReviewerException;
import com.techpedia.usermanagement.exception.ReviewerStatusException;
import com.techpedia.usermanagement.exception.SaveUserPhotoException;
import com.techpedia.usermanagement.exception.StateFetchException;
import com.techpedia.usermanagement.exception.SuggestableReviewersException;
import com.techpedia.usermanagement.exception.UniversitiesFetchException;
import com.techpedia.usermanagement.service.exception.UserManagementServiceException;
import com.techpedia.usermanagement.service.helper.UserManagementRestServiceHelper;

@Path("/usermanagementservice")
@Service
public class UserManagementRestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementRestService.class.getName());

	@Autowired
	private UserManagementRestServiceHelper userManagementRestServiceHelper;

	@POST
	@Path("/UploadUserPhoto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response uploadUserPhoto(SaveUserPhoto saveUserPhoto) throws UserManagementServiceException{

		return Response.ok().status(200).entity(userManagementRestServiceHelper.uploadUserPhoto(saveUserPhoto)).type("application/json").build();

	}

	@POST
	@Path("/createNewProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createNewProfile(UserProfileDO userprofileDO) throws UserManagementServiceException{

		return Response.ok().status(200).entity(userManagementRestServiceHelper.createNewProfile(userprofileDO)).type("application/json").build();

	}

	@POST
	@Path("/createProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createProfile(UserProfileDO userprofileDO) throws UserManagementServiceException{

		return Response.ok().status(200).entity(userManagementRestServiceHelper.createProfile(userprofileDO)).type("application/json").build();

	}

	@POST
	@Path("/updateProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateProfile(UserProfileDO userprofileDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.updateProfile(userprofileDO)).type("application/json").build();

	}

	@POST
	@Path("/deactivateProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response deactivateProfile(String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.deactivateProfile(userID)).type("application/json").build();

	}

	@POST
	@Path("/getUserDetailsNew")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserDetailsNew(String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUserDetailsNew(registerID)).type("application/json").build();

	}

	@POST
	@Path("/getUserDetails")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserDetails(String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUserDetails(registerID)).type("application/json").build();

	}

	@POST
	@Path("/signIn")
	@Consumes("application/json")
	@Produces("application/json")
	public Response signIn(SignInVo signInVO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.signIn(signInVO)).type("application/json").build();

	}

	@POST
	@Path("/socialSignIn")
	@Consumes("application/json")
	@Produces("application/json")
	public Response socialSignIn(@QueryParam("email") String emailId) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.socialSignInHelper(emailId)).type("application/json").build();

	}

	@POST
	@Path("/authenticate")
	@Consumes("application/json")
	@Produces("application/json")
	public Response authenticate(@QueryParam("userName") String userID,@QueryParam("password") String password) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.authenticate(userID,password)).type("application/json").build();

	}

	@POST
	@Path("/passwordReset")
	@Consumes("application/json")
	@Produces("application/json")
	public Response passwordReset(PasswordResetVo pwdResetVo) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.passwordReset(pwdResetVo)).type("application/json").build();

	}

	@POST
	@Path("/updatePhoto")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updatePhoto(SaveUserPhoto saveUserPhoto) throws UserManagementServiceException, SaveUserPhotoException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.updatePhoto(saveUserPhoto)).type("application/json").build();

	}

	@POST
	@Path("/activateProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response activateProfile(@QueryParam("userID") String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.activateProfile(userID)).type("application/json").build();

	}

	@POST
	@Path("/emailVerification")
	@Consumes("application/json")
	@Produces("application/json")
	public Response emailVerification(@QueryParam("email") String email) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.emailVerification(email)).type("application/json").build();

	}

	@POST
	@Path("/contactUs")
	@Consumes("application/json")
	@Produces("application/json")
	public Response contactUs(contactUs contactUs) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.contactUs(contactUs)).type("application/json").build();

	}

	@POST
	@Path("/getUserTeamList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserTeamList(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUserTeamList(registerID)).type("application/json").build();

	}

	@POST
	@Path("/getUserRolePermissions")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserRolePermissions(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUserRolePermissions(registerID)).type("application/json").build();

	}

	@POST
	@Path("/getUserRecentComments")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUserRecentComments(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUserRecentComments(registerID)).type("application/json").build();

	}

	@POST
	@Path("/searchUserProfiles")
	@Consumes("application/json")
	@Produces("application/json")
	public Response searchUserProfiles(SearchCriteriaDO searchCriteriaDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.searchUserProfiles(searchCriteriaDO)).type("application/json").build();

	}

	@POST
	@Path("/getPopularMentorList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getPopularMentorList() throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getPopularMentorList()).type("application/json").build();

	}

	@POST
	@Path("/forgotPassword")
	@Consumes("application/json")
	@Produces("application/json")
	public Response forgotPassword(@QueryParam("email") String email) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.forgotPassword(email)).type("application/json").build();

	}

	@POST
	@Path("/searchForMentors")
	@Consumes("application/json")
	@Produces("application/json")
	public Response searchForMentors(@QueryParam("projId") String projId,@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.searchForMentors(projId,registerID)).type("application/json").build();

	}


	@POST
	@Path("/mentorsOfProject")
	@Consumes("application/json")
	@Produces("application/json")
	public Response mentorsOfProject(@QueryParam("projId") String projId) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.mentorsOfProject(projId)).type("application/json").build();

	}

	@POST
	@Path("/getStateList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getStateList(@QueryParam("sName") String sName) throws StateFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getStateList(sName)).type("application/json").build();

	}

	@POST
	@Path("/getCityList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCityList(SearchCityDO searchCityDO) throws CityFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCityList(searchCityDO)).type("application/json").build();

	}

	@POST
	@Path("/getCollegeList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegeList(SearchCollegeDO searchCollege) throws CollegesFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegesList(searchCollege)).type("application/json").build();

	}
	
	@POST
	@Path("/getRegisteredCollegeList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegeListHeader(SearchCollegeDO searchCollege) throws CollegesFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegesListHeader(searchCollege)).type("application/json").build();

	}

	@POST
	@Path("/getCollegeListUser")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegesListUser(@QueryParam("cName") String cName) throws CollegesFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegesListUser(cName)).type("application/json").build();

	}

	@POST
	@Path("/getUniversityList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getUniversityList(@QueryParam("uName") String uName) throws UniversitiesFetchException, UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getUniversitiesList(uName)).type("application/json").build();

	}

	@POST
	@Path("/validateAdmin")
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateAdmin(@QueryParam("registerID") String registerID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.validateAdmin(registerID)).type("application/json").build();

	}

	@POST
	@Path("/updateAddFacultyProfileHelper")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateAddFacultyProfileHelper(UserProfileDO userprofileDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.updateAddFacultyProfileHelper(userprofileDO)).type("application/json").build();

	}


	@POST
	@Path("/getRecentNews")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getRecentNews1() throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getRecentNews()).type("application/json").build();

	}

	@POST
	@Path("/getcollegeFacultyList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getcollegeFacultyList(@QueryParam("cName") String collegeName) throws UserManagementServiceException, GetCollegeFacultyException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.collegeFacultyList(collegeName)).type("application/json").build();

	}

	@POST
	@Path("/getCollegeRecentNews")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegeRecentNews(String collegeName) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegeRecentNews(collegeName)).type("application/json").build();

	}

	@POST
	@Path("/addCollegeRecentNews")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addCollegeRecentNews(RecentNewsDO recentNewsDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.addCollegeRecentNews(recentNewsDO)).type("application/json").build();

	}

	@POST
	@Path("/deleteCollegeNews")
	@Consumes("application/json")
	@Produces("application/json")
	public Response deleteCollegeNews(String newsId) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.deleteCollegeNews(newsId)).type("application/json").build();

	}
	@POST
	@Path("/getCollegeRecentNewsAdmin")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegeRecentNewsAdmin(String collegeName) throws CollegeRecentNewsException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegeRecentNewsAdmin(collegeName)).type("application/json").build();

	}

	@POST
	@Path("/activateCollegeNews")
	@Consumes("application/json")
	@Produces("application/json")
	public Response activateCollegeNews(String newsId) throws CollegeRecentNewsException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.activateCollegeNews(newsId)).type("application/json").build();

	}
	
	@POST
	@Path("/addNewReviewer")
	@Consumes("application/json")
	 @Produces("application/json")
	public Response addNewReviewer(ReviewerDO reviewerDO) throws AddNewReviewerException, EmailServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.addNewReviewer(reviewerDO)).type("application/json").build();

	}

	@POST
	@Path("/getActiveCollegeRecentNewsAdmin")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getActiveCollegeRecentNewsAdmin(String collegeName) throws CollegeRecentNewsException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getActiveCollegeRecentNewsAdmin(collegeName)).type("application/json").build();

	}

	@POST
	@Path("/getInActiveCollegeRecentNewsAdmin")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getInActiveCollegeRecentNewsAdmin(String collegeName) throws CollegeRecentNewsException{
		return Response.ok().status(200).entity(userManagementRestServiceHelper.getInActiveCollegeRecentNewsAdmin(collegeName)).type("application/json").build();
	}
	@POST
	@Path("/activateReviewerProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response activateReviewerProfile(@QueryParam("userID") String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.activateReviewerProfile(userID)).type("application/json").build();

	}
	
	@POST
	@Path("/deActivateReviewerProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response deActivateReviewerProfile(@QueryParam("userID") String userID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.deActivateReviewerProfile(userID)).type("application/json").build();

	}

	@POST
	@Path("/reviewerAuthenticate")
	@Consumes("application/json")
	@Produces("application/json")
	public Response reviewerAuthenticate(@QueryParam("userName") String userID,@QueryParam("password") String password) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.reviewerAuthenticate(userID,password)).type("application/json").build();

	}
	
	@POST
	@Path("/reviewerSignIn")
	@Consumes("application/json")
	@Produces("application/json")
	public Response reviewerSignIn(SignInVo signInVO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.reviewerSignIn(signInVO)).type("application/json").build();

	}
	
	@POST
	@Path("/getReviewerDetails")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getReviewerDetails(String emailID) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getReviewerDetails(emailID)).type("application/json").build();

	}
	
	@POST
	@Path("/getAllReviewer")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getAllReviewer() throws GetReviewerException{				
		return Response.ok().status(200).entity(userManagementRestServiceHelper.getAllReviewer()).type("application/json").build();
	}
	
	@POST
	@Path("/getActiveReviewers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getActiveReviewers() throws ReviewerStatusException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getActiveReviewers()).type("application/json").build();

	}
	
	@POST
	@Path("/getDeactiveReviewers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getDeactiveReviewers() throws ReviewerStatusException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getDeactiveReviewers()).type("application/json").build();

	}
	
	@POST
	@Path("/getSuggestableReviewers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getSuggestableReviewers(long projId) throws SuggestableReviewersException{

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getSuggestableReviewers(projId)).type("application/json").build();

	}
	
	@POST
	@Path("/editReviewerProfile")
	@Consumes("application/json")
	@Produces("application/json")
	public Response editReviewerProfile(ReviewerDO reviewer) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.editReviewerProfile(reviewer)).type("application/json").build();

	}
	
	@POST
	@Path("/getDegreeList")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getDegreeList(String searchTerm) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getDegreeList(searchTerm)).type("application/json").build();

	}
	
	@POST
	@Path("/reviewerForgotPassword")
	@Consumes("application/json")
	@Produces("application/json")
	public Response reviewerForgotPassword(String email) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.reviewerForgotPassword(email)).type("application/json").build();

	}
	
	@POST
	@Path("/reviewerPasswordReset")
	@Consumes("application/json")
	@Produces("application/json")
	public Response reviewerPasswordReset(PasswordResetVo pwdResetVo) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.reviewerPasswordReset(pwdResetVo)).type("application/json").build();

	}
	
	@POST
	@Path("/getCollegeInforamtion")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCollegeInforamtion(String collegeName) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.getCollegeInforamtion(collegeName)).type("application/json").build();

	}
	
	
	@POST
	@Path("/notifySuggestedReviewer")
	@Consumes("application/json")
	@Produces("application/json")
	public Response notifySuggestedReviewer(NotifyReviewerVo notifyReviewerVo) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.notifySuggestedReviewer(notifyReviewerVo)).type("application/json").build();
		
	}
	
	@POST
	@Path("/sendMoreInfoRequestToTeamLeader")
	@Consumes("application/json")
	@Produces("application/json")
	public Response sendMoreInfoRequestToTeamLeader(MoreInfoRequiredDO moreInfoRequiredDO) throws UserManagementServiceException {

		return Response.ok().status(200).entity(userManagementRestServiceHelper.sendMoreInfoRequestToTeamLeader(moreInfoRequiredDO)).type("application/json").build();
		
	}
}