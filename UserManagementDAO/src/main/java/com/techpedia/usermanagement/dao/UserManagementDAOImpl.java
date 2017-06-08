package com.techpedia.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techpedia.chiper.ChiperEncryptException;
import com.techpedia.usermanagement.dataobject.AddNewReviewerResponse;
import com.techpedia.usermanagement.dataobject.CityListDO;
import com.techpedia.usermanagement.dataobject.CollegeDataDo;
import com.techpedia.usermanagement.dataobject.CollegeFacultyInfo;
import com.techpedia.usermanagement.dataobject.CollegeListDO;
import com.techpedia.usermanagement.dataobject.DegreeListDO;
import com.techpedia.usermanagement.dataobject.Mentor1n2Details;
import com.techpedia.usermanagement.dataobject.PasswordResetVo;
import com.techpedia.usermanagement.dataobject.PopularMentorsDO;
import com.techpedia.usermanagement.dataobject.RecentNewsDO;
import com.techpedia.usermanagement.dataobject.ReviewerDO;
import com.techpedia.usermanagement.dataobject.ReviewerDetailsDO;
import com.techpedia.usermanagement.dataobject.SaveUserPhoto;
import com.techpedia.usermanagement.dataobject.SearchCityDO;
import com.techpedia.usermanagement.dataobject.SearchCollegeDO;
import com.techpedia.usermanagement.dataobject.SearchCriteriaDO;
import com.techpedia.usermanagement.dataobject.SearchForMentorListDO;
import com.techpedia.usermanagement.dataobject.SignInVo;
import com.techpedia.usermanagement.dataobject.StateListDO;
import com.techpedia.usermanagement.dataobject.UniversityListDO;
import com.techpedia.usermanagement.dataobject.UpdateUserPhotoDO;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.dataobject.UserRecentComments;
import com.techpedia.usermanagement.dataobject.UserTeamListDO;
import com.techpedia.usermanagement.dataobject.UsrAccessDetails;
import com.techpedia.usermanagement.exception.AddNewReviewerException;
import com.techpedia.usermanagement.exception.CityFetchException;
import com.techpedia.usermanagement.exception.CollegeInformationException;
import com.techpedia.usermanagement.exception.CollegeRecentNewsException;
import com.techpedia.usermanagement.exception.CollegesFetchException;
import com.techpedia.usermanagement.exception.CreateProfileException;
import com.techpedia.usermanagement.exception.CurrentPasswordFetchException;
import com.techpedia.usermanagement.exception.DegreeFetchException;
import com.techpedia.usermanagement.exception.EmailExistException;
import com.techpedia.usermanagement.exception.GetCollegeFacultyException;
import com.techpedia.usermanagement.exception.GetRecentNewsException;
import com.techpedia.usermanagement.exception.GetReviewerException;
import com.techpedia.usermanagement.exception.LoginException;
import com.techpedia.usermanagement.exception.MentorSearchException;
import com.techpedia.usermanagement.exception.PasswordExpiryException;
import com.techpedia.usermanagement.exception.PasswordMismatchException;
import com.techpedia.usermanagement.exception.PasswordResetException;
import com.techpedia.usermanagement.exception.PopularMentorsFetchException;
import com.techpedia.usermanagement.exception.ProfileFetchException;
import com.techpedia.usermanagement.exception.ProfileNotFoundException;
import com.techpedia.usermanagement.exception.ProfileSearchException;
import com.techpedia.usermanagement.exception.ProfileUpdateException;
import com.techpedia.usermanagement.exception.ProjectNotFoundException;
import com.techpedia.usermanagement.exception.ReviewerStatusException;
import com.techpedia.usermanagement.exception.SaveUserPhotoException;
import com.techpedia.usermanagement.exception.StateFetchException;
import com.techpedia.usermanagement.exception.SuggestableReviewersException;
import com.techpedia.usermanagement.exception.UniversitiesFetchException;
import com.techpedia.usermanagement.exception.UserExistException;
import com.techpedia.usermanagement.exception.UserFunctionsNotDefinedException;
import com.techpedia.usermanagement.exception.UserInactiveException;
import com.techpedia.usermanagement.exception.UserNotFoundException;
import com.techpedia.usermanagement.exception.UserRecentCommentsFetchException;
import com.techpedia.usermanagement.exception.UserRoleNotDefinedException;
import com.techpedia.usermanagement.exception.UserRoleNotMappedException;
import com.techpedia.usermanagement.exception.UserRoleNotMappedWithFunctionIdsException;
import com.techpedia.usermanagement.exception.UserTeamListFetchException;
import com.techpedia.usermanagement.helper.UserManagementDAOHelper;

@Component(value="userManagementDAO")
public class UserManagementDAOImpl implements UserManagementDAO{

	@Autowired
	UserManagementDAOHelper userManagementDAOHelper;
	
	public String uploadUserPhoto(SaveUserPhoto saveUserPhoto) throws SaveUserPhotoException {
		return userManagementDAOHelper.uploadUserPhoto(saveUserPhoto);
	}
	
	public boolean createNewProfile(UserProfileDO userprofile) throws CreateProfileException,ChiperEncryptException,UserExistException, EmailExistException {
		return userManagementDAOHelper.createProfileHelperNew(userprofile);

	}
	
	public boolean createProfile(UserProfileDO userprofile) throws CreateProfileException,ChiperEncryptException,UserExistException, EmailExistException {
		return userManagementDAOHelper.createProfileHelper(userprofile);

	}

	public boolean updateProfile(UserProfileDO userprofile) throws ProfileNotFoundException, ProfileUpdateException,ChiperEncryptException,EmailExistException {

		return userManagementDAOHelper.updateProfileHelper(userprofile);
	}

	public boolean deactivateProfile(String userId) throws ProfileNotFoundException,ProfileUpdateException{

		return userManagementDAOHelper.deactivateProfileHelper(userId);
	}

	public boolean activateProfile(String userId) throws ProfileNotFoundException,ProfileUpdateException{

		return userManagementDAOHelper.activateProfileHelper(userId);
	}

	public  UserProfileDO getUserProfile(Long registerID) throws ProfileNotFoundException,ProfileFetchException {
		return userManagementDAOHelper.getUserProfileHelper(registerID);


	}
	
	public  UserProfileDO getUserProfileNew(Long registerID) throws ProfileNotFoundException,ProfileFetchException {
		return userManagementDAOHelper.getUserProfileHelperNew(registerID);


	}

	public boolean passwordReset(PasswordResetVo pwdResetVo) throws PasswordResetException, UserNotFoundException {
		return userManagementDAOHelper.passwordResetHelper(pwdResetVo);
	}

	public boolean authenticate(String userid, String pwd) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException {
		return userManagementDAOHelper.authenticateHelper(userid, pwd);
	}

	public UserProfileDO singIn(SignInVo signInVo) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException, ProfileFetchException, UserInactiveException {

		return userManagementDAOHelper.signInHelper(signInVo);
	}
	
	public UserProfileDO socialSignInHelper(String email) throws UserNotFoundException, LoginException, ProfileFetchException, UserInactiveException {
		return userManagementDAOHelper.socialSignInHelper(email);
	}

	public boolean updatePhoto(UpdateUserPhotoDO updateUserPhotoDO) throws ProfileNotFoundException, ProfileUpdateException {

		return userManagementDAOHelper.updatePhotoHelper(updateUserPhotoDO);
	}

	public List<UserProfileDO> searchUserProfiles(SearchCriteriaDO scDo)throws ProfileSearchException {

		return userManagementDAOHelper.searchUserProfilesHelper(scDo);
	}

	public boolean emailIdVerification(String emailId) throws UserNotFoundException, ProfileFetchException  {

		return userManagementDAOHelper.emailIdVerificationHelper(emailId);
	}


	public UsrAccessDetails getUserRolePermissions(Long registerID) throws UserNotFoundException, UserRoleNotMappedException, UserRoleNotMappedWithFunctionIdsException, UserRoleNotDefinedException, UserFunctionsNotDefinedException {
		return userManagementDAOHelper.getUsrRolePermissions(registerID);
	}

	public List<UserTeamListDO> getUserTeamList(Long registerID) throws UserTeamListFetchException {
		return userManagementDAOHelper.getUserTeamList(registerID);
	}

	public List<UserRecentComments> getUserRecentComments(Long registerID) throws UserRecentCommentsFetchException {
		return userManagementDAOHelper.getUserRecentComments(registerID);
	}

	public List<PopularMentorsDO> getPopularMentorList() throws PopularMentorsFetchException {
		return userManagementDAOHelper.getPopularMentorList();
	}

	public String forgotPassword(String email) throws UserNotFoundException,CurrentPasswordFetchException {
		return userManagementDAOHelper.forgotPassword(email);
	}
	
	public List<SearchForMentorListDO> searchForMentors(Long i,Long id) throws MentorSearchException
	{
		return userManagementDAOHelper.getSearchListOfMentors(i,id);
	}
	
	public List<Mentor1n2Details> getMentorsOfProject(Long projId) throws ProjectNotFoundException
	{
		return userManagementDAOHelper.getMentorsOfProject(projId);
	}
	
	public List<StateListDO> getStateList(String sName) throws StateFetchException {

		return userManagementDAOHelper.getStateList(sName);
	}
	
	public List<CityListDO> getCityList(SearchCityDO searchCityDO) throws CityFetchException {

		return userManagementDAOHelper.getCityList(searchCityDO);
	}
	
	public List<CollegeListDO> getCollegesList(SearchCollegeDO searchCollege) throws CollegesFetchException {

		return userManagementDAOHelper.getCollegesList(searchCollege);
	}
	
	public List<CollegeListDO> getCollegesListHeader(SearchCollegeDO searchCollege) throws CollegesFetchException {

		return userManagementDAOHelper.getCollegesListHeader(searchCollege);
	}

	public List<CollegeListDO> getCollegesListUser(String cName) throws CollegesFetchException {

		return userManagementDAOHelper.getCollegesListUser(cName);
	}
	
	public List<UniversityListDO> getUniversitiesList(String uName)
			throws UniversitiesFetchException {

		return userManagementDAOHelper.getUniversitiesList(uName);
	}

	@Override
	public boolean validateAdmin(Long registerID)
			throws UserNotFoundException, ProfileFetchException {
		
		return userManagementDAOHelper.validateAdmin(registerID);
	}
	
	public boolean updateAddFacultyProfileHelper(UserProfileDO userprofile) throws ProfileNotFoundException, ProfileUpdateException,ChiperEncryptException,EmailExistException {

		return userManagementDAOHelper.updateAddFacultyProfileHelper(userprofile);
	}	
	
	public ArrayList<RecentNewsDO> getRecentNews() throws GetRecentNewsException{
		return userManagementDAOHelper.getRecentNews();
	}
	
	public ArrayList<RecentNewsDO> getCollegeRecentNews(String collegeName) throws CollegeRecentNewsException{
		return userManagementDAOHelper.getCollegeRecentNews(collegeName);
	}
	
	public ArrayList<CollegeFacultyInfo> getCollegeFaculty(String collegeName) throws GetCollegeFacultyException{
		return userManagementDAOHelper.getCollegeFaculty(collegeName);
	}
	
	public String addCollegeRecentNews(RecentNewsDO recentNewsDO) throws CollegeRecentNewsException {
		return userManagementDAOHelper.addCollegeRecentNews(recentNewsDO);
	}
	
	public String deleteCollegeRecentNews(String newsId) throws CollegeRecentNewsException {
		return userManagementDAOHelper.deleteCollegeRecentNews(newsId);
	}
	
	public ArrayList<RecentNewsDO> getCollegeRecentNewsAdmin(String collegeName ) throws CollegeRecentNewsException{
		return userManagementDAOHelper.getCollegeRecentNewsAdmin(collegeName);
	}
	public String activateCollegeRecentNews(String newsId) throws CollegeRecentNewsException {
		return userManagementDAOHelper.activateCollegeRecentNews(newsId);
	}

	@Transactional (rollbackFor = Exception.class)
	public AddNewReviewerResponse addNewReviewer(ReviewerDO reviewerDO) throws AddNewReviewerException {
		return userManagementDAOHelper.addNewReviewer(reviewerDO);
	}
	 
	 public ArrayList<RecentNewsDO> getActiveCollegerecentNewsAdmin(String collegeName) throws CollegeRecentNewsException{
		return userManagementDAOHelper.getActiveCollegeRecentNewsAdmin(collegeName);
		 
	 }
		
	public ArrayList<RecentNewsDO> getInActiveCollegerecentNewsAdmin(String collegeName) throws CollegeRecentNewsException{
		return userManagementDAOHelper.getInActiveCollegeRecentNewsAdmin(collegeName);	
	}
	
	public boolean activateReviewerProfile(String userId) throws ProfileNotFoundException,ProfileUpdateException{
		return userManagementDAOHelper.activateReviewerProfile(userId);
	}

	public ReviewerDO reviewerSignIn(SignInVo signInVo) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException, ProfileFetchException, UserInactiveException {
		return userManagementDAOHelper.reviewerSignInHelper(signInVo);
	}
	
	public ReviewerDetailsDO getReviewerProfile(String revEmailId) throws ProfileNotFoundException, ProfileFetchException {
        return userManagementDAOHelper.getReviewerProfileHelper(revEmailId);
	}
	
	public boolean reviewerAuthenticate(String userid, String pwd) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException {
		return userManagementDAOHelper.reviewerAuthenticateHelper(userid, pwd);
	}
	
	public ArrayList<ReviewerDO> getAllReviewer() throws GetReviewerException{
		
		return userManagementDAOHelper.getAllReviewer();
	}

	public ArrayList<ReviewerDO> getActiveReviewers()throws ReviewerStatusException {
		
		return userManagementDAOHelper.getActiveReviewers();
	}
	
	public ArrayList<ReviewerDO> getDeactiveReviewers()throws ReviewerStatusException {
		
		return userManagementDAOHelper.getDeactiveReviewers();
	}

	public boolean deActivateReviewerProfile(String userID) throws ProfileNotFoundException, ProfileUpdateException {
		return userManagementDAOHelper.deActivateReviewerProfile(userID);
	}
	
	public ArrayList<ReviewerDO> getSuggestableReviewers(long projId) throws SuggestableReviewersException {	
		return userManagementDAOHelper.getSuggestableReviewers(projId);
	}
	
	@Transactional (rollbackFor = Exception.class)
	public boolean editReviewerProfile(ReviewerDO reviewer) throws ProfileNotFoundException,ProfileUpdateException{
		return userManagementDAOHelper.editReviewerProfile(reviewer);
	}
	
	public List<DegreeListDO> getDegreeList(String searchTerm) throws DegreeFetchException {
		return userManagementDAOHelper.getDegreeList(searchTerm);
	}
	
	public String reviewerForgotPassword(String email) throws UserNotFoundException,CurrentPasswordFetchException {
		return userManagementDAOHelper.reviewerForgotPassword(email);
	}
	
	public boolean reviewerPasswordReset(PasswordResetVo pwdResetVo) throws PasswordResetException, UserNotFoundException {
		return userManagementDAOHelper.reviewerPasswordReset(pwdResetVo);
	}
	public  CollegeDataDo getCollegeInforamtion(String collegeName) throws CollegeInformationException {
		CollegeDataDo dataDo= userManagementDAOHelper.getCollegeInforamtion(collegeName);
		 
		System.out.println("data response :: "+dataDo.toString());
		return dataDo;


	}
	
	public boolean notifySuggestedReviewer(String suggestedReviewerEmail) throws UserNotFoundException, CurrentPasswordFetchException {
		return userManagementDAOHelper.notifySuggestedReviewer(suggestedReviewerEmail);
	}

	public boolean sendMoreInfoRequestToTeamLeader(String emailId) throws UserNotFoundException, CurrentPasswordFetchException {
		return userManagementDAOHelper.sendMoreInfoRequestToTeamLeader(emailId);
	}
}
