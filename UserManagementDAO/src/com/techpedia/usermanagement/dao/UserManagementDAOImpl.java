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
import com.techpedia.usermanagement.helper.UserManagementDAOHelper;


public class UserManagementDAOImpl implements UserManagementDAO{


	public boolean createProfile(UserProfileDO userprofile) throws CreateProfileException,ChiperEncryptException,UserExistException, EmailExistException {
		return UserManagementDAOHelper.createProfileHelper(userprofile);

	}

	public boolean updateProfile(UserProfileDO userprofile) throws ProfileNotFoundException, ProfileUpdateException,ChiperEncryptException,EmailExistException {

		return UserManagementDAOHelper.updateProfileHelper(userprofile);
	}

	public boolean deactivateProfile(String userId) throws ProfileNotFoundException,ProfileUpdateException{

		return UserManagementDAOHelper.deactivateProfileHelper(userId);
	}

	public boolean activateProfile(String userId) throws ProfileNotFoundException,ProfileUpdateException{

		return UserManagementDAOHelper.activateProfileHelper(userId);
	}

	public  UserProfileDO getUserProfile(Long RegisterID) throws ProfileNotFoundException,ProfileFetchException {
		return UserManagementDAOHelper.getUserProfileHelper(RegisterID);


	}

	public boolean passwordReset(PasswordResetVo pwdResetVo) throws PasswordResetException, UserNotFoundException {
		return UserManagementDAOHelper.passwordResetHelper(pwdResetVo);
	}

	public boolean authenticate(String userid, String pwd) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException {
		return UserManagementDAOHelper.authenticateHelper(userid, pwd);
	}

	public UserProfileDO singIn(SignInVo signInVo) throws UserNotFoundException, LoginException, PasswordMismatchException, PasswordExpiryException, PasswordResetException, ProfileFetchException, UserInactiveException {

		return UserManagementDAOHelper.signInHelper(signInVo);
	}

	public boolean updatePhoto(UpdateUserPhotoDO updateUserPhotoDO) throws ProfileNotFoundException, ProfileUpdateException {

		return UserManagementDAOHelper.updatePhotoHelper(updateUserPhotoDO);
	}

	public List<UserProfileDO> searchUserProfiles(SearchCriteriaDO scDo)throws ProfileSearchException {

		return UserManagementDAOHelper.searchUserProfilesHelper(scDo);
	}

	public UserProfileDO emailIdVerification(String emailId) throws UserNotFoundException, ProfileFetchException  {

		return UserManagementDAOHelper.emailIdVerificationHelper(emailId);
	}


	public UsrAccessDetails getUserRolePermissions(Long RegisterID) throws UserNotFoundException, UserRoleNotMappedException, UserRoleNotMappedWithFunctionIdsException, UserRoleNotDefinedException, UserFunctionsNotDefinedException {
		return UserManagementDAOHelper.getUsrRolePermissions(RegisterID);
	}

	public List<UserTeamListDO> getUserTeamList(Long RegisterID) throws UserTeamListFetchException {
		return UserManagementDAOHelper.getUserTeamList(RegisterID);
	}

	public List<UserRecentComments> getUserRecentComments(Long RegisterID) throws UserRecentCommentsFetchException {
		return UserManagementDAOHelper.getUserRecentComments(RegisterID);
	}

	public List<PopularMentorsDO> getPopularMentorList() throws PopularMentorsFetchException {
		return UserManagementDAOHelper.getPopularMentorList();
	}

	public String forgotPassword(String email) throws UserNotFoundException,CurrentPasswordFetchException {
		return UserManagementDAOHelper.forgotPassword(email);
	}
	
	public List<SearchForMentorListDO> searchForMentors(Long i,Long id) throws MentorSearchException
	{
		return UserManagementDAOHelper.getSearchListOfMentors(i,id);
	}
	
	public List<Mentor1n2Details> getMentorsOfProject(Long projId) throws ProjectNotFoundException
	{
		return UserManagementDAOHelper.getMentorsOfProject(projId);
	}
	
	
	public List<CollegeListDO> getCollegesList(String cName) throws CollegesFetchException {

		return UserManagementDAOHelper.getCollegesList(cName);
	}

	
	public List<UniversityListDO> getUniversitiesList(String uName)
			throws UniversitiesFetchException {

		return UserManagementDAOHelper.getUniversitiesList(uName);
	}

	@Override
	public boolean validateAdmin(Long RegisterID)
			throws UserNotFoundException, ProfileFetchException {
		
		return UserManagementDAOHelper.validateAdmin(RegisterID);
	}
	
	public boolean updateAddFacultyProfileHelper(UserProfileDO userprofile) throws ProfileNotFoundException, ProfileUpdateException,ChiperEncryptException,EmailExistException {

		return UserManagementDAOHelper.updateAddFacultyProfileHelper(userprofile);
	}	
	


}
