package com.techpedia.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

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

public interface UserManagementDAO {

	// profile related operations
	public String uploadUserPhoto(SaveUserPhoto saveUserPhoto)
			throws SaveUserPhotoException ;
	
	public boolean createNewProfile(UserProfileDO userprofile)
			throws CreateProfileException, ChiperEncryptException,
			UserExistException, EmailExistException;
	
	public boolean createProfile(UserProfileDO userprofile)
			throws CreateProfileException, ChiperEncryptException,
			UserExistException, EmailExistException;

	public boolean updateProfile(UserProfileDO userprofile)
			throws ProfileNotFoundException, ProfileUpdateException,
			ChiperEncryptException,EmailExistException;

	public boolean deactivateProfile(String userID)
			throws ProfileNotFoundException, ProfileUpdateException;

	public UserProfileDO getUserProfile(Long registerID)
			throws ProfileNotFoundException, ProfileFetchException;
	
	public UserProfileDO getUserProfileNew(Long registerID)
			throws ProfileNotFoundException, ProfileFetchException;

	public boolean updatePhoto(UpdateUserPhotoDO updateUserPhotoDO)
			throws ProfileNotFoundException, ProfileUpdateException;

	public boolean activateProfile(String userID)
			throws ProfileNotFoundException, ProfileUpdateException;

	// public boolean addFaculty(AddFaculty faculty) throws
	// CreateProfileException,,UserExistException;

	// authentication related operations
	public UserProfileDO singIn(SignInVo signInVo)
			throws UserNotFoundException, LoginException,
			PasswordMismatchException, PasswordExpiryException,
			PasswordResetException, ProfileFetchException,UserInactiveException;
	
	public UserProfileDO socialSignInHelper(String email)
			throws UserNotFoundException, LoginException,
			ProfileFetchException, UserInactiveException;

	public boolean authenticate(String userid, String pwd)
			throws UserNotFoundException, LoginException,
			PasswordMismatchException, PasswordExpiryException,
			PasswordResetException;

	public boolean passwordReset(PasswordResetVo pwdResetVo)
			throws UserNotFoundException, PasswordResetException;

	// authorization related operations
	public UsrAccessDetails getUserRolePermissions(Long registerID)
			throws UserNotFoundException, UserRoleNotMappedException,
			UserRoleNotMappedWithFunctionIdsException,
			UserRoleNotDefinedException, UserFunctionsNotDefinedException;

	// search profile operations
	public List<UserProfileDO> searchUserProfiles(SearchCriteriaDO scDo)
			throws ProfileSearchException;

	// public List<UserProfile> getColleges() throws CollegesFetchException;

	public boolean emailIdVerification(String emailId)
			throws UserNotFoundException, ProfileFetchException;

	public List<UserTeamListDO> getUserTeamList(Long registerID)
			throws UserTeamListFetchException;

	public List<UserRecentComments> getUserRecentComments(Long registerID)
			throws UserRecentCommentsFetchException;

	public List<PopularMentorsDO> getPopularMentorList()
			throws PopularMentorsFetchException;

	public String forgotPassword(String email) throws UserNotFoundException,
			CurrentPasswordFetchException;

	public List<SearchForMentorListDO> searchForMentors(Long long1,
			Long registerID) throws MentorSearchException;

	public List<Mentor1n2Details> getMentorsOfProject(Long projId)
			throws ProjectNotFoundException;

	public List<StateListDO> getStateList(String sName)
			throws StateFetchException;
	
	public List<CityListDO> getCityList(SearchCityDO searchCityDO)
			throws CityFetchException;
	
	public List<CollegeListDO> getCollegesList(SearchCollegeDO searchCollege)
			throws CollegesFetchException;
	
	public List<CollegeListDO> getCollegesListHeader(SearchCollegeDO searchCollege)
			throws CollegesFetchException;
	
	public List<CollegeListDO> getCollegesListUser(String cName)
			throws CollegesFetchException;

	public List<UniversityListDO> getUniversitiesList(String uName)
			throws UniversitiesFetchException;

	public boolean validateAdmin(Long registerID) throws UserNotFoundException,
			ProfileFetchException;
	public boolean updateAddFacultyProfileHelper(UserProfileDO userprofile)
			throws ProfileNotFoundException, ProfileUpdateException,
			ChiperEncryptException,EmailExistException;
	
	public ArrayList<RecentNewsDO> getRecentNews() throws GetRecentNewsException;
	
	public ArrayList<RecentNewsDO> getCollegeRecentNews(String collegeName) throws CollegeRecentNewsException;
	
	public ArrayList<RecentNewsDO> getCollegeRecentNewsAdmin(String collegeName) throws CollegeRecentNewsException;
	
	public ArrayList<CollegeFacultyInfo> getCollegeFaculty(String collegeName) throws GetCollegeFacultyException;
	
	public String addCollegeRecentNews(RecentNewsDO recentNewsDO) throws CollegeRecentNewsException;
	
	public String deleteCollegeRecentNews(String newsId) throws CollegeRecentNewsException;
	
	public String activateCollegeRecentNews(String newsId) throws CollegeRecentNewsException;

	public ArrayList<RecentNewsDO> getActiveCollegerecentNewsAdmin(String collegeName) throws CollegeRecentNewsException;
	
	public ArrayList<RecentNewsDO> getInActiveCollegerecentNewsAdmin(String collegeName) throws CollegeRecentNewsException;

	public AddNewReviewerResponse addNewReviewer(ReviewerDO reviewerDO) throws AddNewReviewerException;
	
	public boolean activateReviewerProfile(String userID) throws ProfileNotFoundException, ProfileUpdateException;
	
	public boolean deActivateReviewerProfile(String userID) throws ProfileNotFoundException, ProfileUpdateException;
	
	public ReviewerDO reviewerSignIn(SignInVo signInVo) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException, ProfileFetchException, UserInactiveException;
	
	public ReviewerDetailsDO getReviewerProfile(String revEmailId) throws ProfileNotFoundException, ProfileFetchException;
	
	public boolean reviewerAuthenticate(String userid, String pwd) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException;
	
	public ArrayList<ReviewerDO> getAllReviewer() throws GetReviewerException;
	
	public ArrayList<ReviewerDO> getActiveReviewers() throws ReviewerStatusException;
	
	public ArrayList<ReviewerDO> getDeactiveReviewers() throws ReviewerStatusException;
	
	public ArrayList<ReviewerDO> getSuggestableReviewers(long projId) throws SuggestableReviewersException;
	
	public boolean editReviewerProfile(ReviewerDO reviewer) throws ProfileNotFoundException, ProfileUpdateException;
	
	public List<DegreeListDO> getDegreeList(String searchTerm) throws DegreeFetchException;
	
	public String reviewerForgotPassword(String email) throws UserNotFoundException, CurrentPasswordFetchException;
	
	public boolean reviewerPasswordReset(PasswordResetVo pwdResetVo) throws UserNotFoundException, PasswordResetException;

	public CollegeDataDo getCollegeInforamtion(String collegeName)throws CollegeInformationException;

	public boolean notifySuggestedReviewer(String suggestedReviewerEmail)throws UserNotFoundException, CurrentPasswordFetchException;

	public boolean sendMoreInfoRequestToTeamLeader(String emailId)throws UserNotFoundException, CurrentPasswordFetchException;

}
