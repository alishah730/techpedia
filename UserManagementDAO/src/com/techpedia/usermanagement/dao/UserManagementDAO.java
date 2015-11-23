package com.techpedia.usermanagement.dao;

import java.util.List;

import com.techpedia.chiper.ChiperEncryptException;
import com.techpedia.usermanagement.dataobject.CollegeListDO;
import com.techpedia.usermanagement.dataobject.Mentor1n2Details;
import com.techpedia.usermanagement.dataobject.PasswordResetVo;
import com.techpedia.usermanagement.dataobject.PopularMentorsDO;
import com.techpedia.usermanagement.dataobject.SearchCriteriaDO;
import com.techpedia.usermanagement.dataobject.SearchForMentorListDO;
import com.techpedia.usermanagement.dataobject.SignInVo;
import com.techpedia.usermanagement.dataobject.UniversityListDO;
import com.techpedia.usermanagement.dataobject.UpdateUserPhotoDO;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.dataobject.UserRecentComments;
import com.techpedia.usermanagement.dataobject.UserTeamListDO;
import com.techpedia.usermanagement.dataobject.UsrAccessDetails;
import com.techpedia.usermanagement.exception.CollegesFetchException;
import com.techpedia.usermanagement.exception.CreateProfileException;
import com.techpedia.usermanagement.exception.CurrentPasswordFetchException;
import com.techpedia.usermanagement.exception.EmailExistException;
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
	public boolean createProfile(UserProfileDO userprofile)
			throws CreateProfileException, ChiperEncryptException,
			UserExistException, EmailExistException;

	public boolean updateProfile(UserProfileDO userprofile)
			throws ProfileNotFoundException, ProfileUpdateException,
			ChiperEncryptException,EmailExistException;

	public boolean deactivateProfile(String userID)
			throws ProfileNotFoundException, ProfileUpdateException;

	public UserProfileDO getUserProfile(Long RegisterID)
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

	public boolean authenticate(String userid, String pwd)
			throws UserNotFoundException, LoginException,
			PasswordMismatchException, PasswordExpiryException,
			PasswordResetException;

	public boolean passwordReset(PasswordResetVo pwdResetVo)
			throws UserNotFoundException, PasswordResetException;

	// authorization related operations
	public UsrAccessDetails getUserRolePermissions(Long RegisterID)
			throws UserNotFoundException, UserRoleNotMappedException,
			UserRoleNotMappedWithFunctionIdsException,
			UserRoleNotDefinedException, UserFunctionsNotDefinedException;

	// search profile operations
	public List<UserProfileDO> searchUserProfiles(SearchCriteriaDO scDo)
			throws ProfileSearchException;

	// public List<UserProfile> getColleges() throws CollegesFetchException;

	public UserProfileDO emailIdVerification(String emailId)
			throws UserNotFoundException, ProfileFetchException;

	public List<UserTeamListDO> getUserTeamList(Long RegisterID)
			throws UserTeamListFetchException;

	public List<UserRecentComments> getUserRecentComments(Long RegisterID)
			throws UserRecentCommentsFetchException;

	public List<PopularMentorsDO> getPopularMentorList()
			throws PopularMentorsFetchException;

	public String forgotPassword(String email) throws UserNotFoundException,
			CurrentPasswordFetchException;

	public List<SearchForMentorListDO> searchForMentors(Long long1,
			Long registerID) throws MentorSearchException;

	public List<Mentor1n2Details> getMentorsOfProject(Long projId)
			throws ProjectNotFoundException;

	public List<CollegeListDO> getCollegesList(String cName)
			throws CollegesFetchException;

	public List<UniversityListDO> getUniversitiesList(String uName)
			throws UniversitiesFetchException;

	public boolean validateAdmin(Long RegisterID) throws UserNotFoundException,
			ProfileFetchException;
	public boolean updateAddFacultyProfileHelper(UserProfileDO userprofile)
			throws ProfileNotFoundException, ProfileUpdateException,
			ChiperEncryptException,EmailExistException;
}
