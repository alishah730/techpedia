package com.techpedia.usermanagement.service.helper;

import java.util.List;

import com.google.gson.Gson;
import com.techpedia.chiper.ChiperEncryptException;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.logger.TechPediaLogger;
import com.techpedia.usermanagement.dao.UserManagementDAO;
import com.techpedia.usermanagement.dao.UserManagementDAOImpl;
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
import com.techpedia.usermanagement.service.constant.UserManagementServiceConstant;
import com.techpedia.usermanagement.service.exception.UserManagementServiceException;
import com.techpedia.usermanagement.service.response.UMServiceResponse;

//import com.techpedia.usermanagement.dataobject.ProfileSearchCriteriaDO;

public class UserManagementRestServiceHelper {

	private static TechPediaLogger log = TechPediaLogger
			.getLogger(UserManagementRestServiceHelper.class.getName());

	static UserManagementDAO userMgmtDao = null;
	static UMServiceResponse response = null;
	static Gson gson = null;
	UserManagementServiceException userMgmtException = null;

	public static String createProfile(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper createProfile:Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().createProfile(userprofileDO);
			if (val == true) {

				UserManagementEmailHelper.sendEmail(userprofileDO);

				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
			}

		} catch (CreateProfileException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ChiperEncryptException e) {
			return e.toString();
		} catch (UserExistException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (EmailServiceException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (EmailExistException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String updateProfile(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper updateProfile:Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().updateProfile(userprofileDO);
			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_UPDATE_SUCCESS);
				return gson.toJson(response);
			}
		} catch (ProfileUpdateException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ChiperEncryptException e) {
			return e.toString();
		} catch (EmailExistException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String deactivateProfile(String userID)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper deactivateProfile : Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().deactivateProfile(userID);
			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_DEACTIVATE_SUCCESS);
				return gson.toJson(response);
			}
		} catch (ProfileUpdateException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getUserDetails(String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getUserDetails : Start");
		UserProfileDO userprofileDO = null;
		response = new UMServiceResponse();
		try {
			userprofileDO = getUserManagementDAO().getUserProfile(
					new Long(registerID));

			if (userprofileDO != null) {
				gson = new Gson();
				return gson.toJson(userprofileDO);
			}

		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String signIn(SignInVo signInVo)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper signIn : Start");
		UserProfileDO userprofileDO = null;
		response = new UMServiceResponse();
		try {
			userprofileDO = getUserManagementDAO().singIn(signInVo);

			if (userprofileDO != null) {
				gson = new Gson();
				return gson.toJson(userprofileDO);
			}

		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (LoginException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordMismatchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (UserInactiveException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}catch (PasswordExpiryException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordResetException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String authenticate(String userID, String password)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper authenticate : Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().authenticate(userID, password);

			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.AUTHENTICATION_SUCCESS);
				return gson.toJson(response);
			}

		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (LoginException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordMismatchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordExpiryException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordResetException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String passwordReset(PasswordResetVo pwdResetVo) throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper passwordReset : Start");

		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().passwordReset(pwdResetVo);

			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PASSWORD_RESET_SUCCESS);
				return gson.toJson(response);
			}

		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (PasswordResetException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String updatePhoto(UpdateUserPhotoDO updateUserPhotoDO)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper updatePhoto: Start");

		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().updatePhoto(updateUserPhotoDO);

			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PHOTO_UPDATE_SUCCESS);
				return gson.toJson(response);
			}

		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileUpdateException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String activateProfile(String userID)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper activateProfile : Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().activateProfile(userID);
			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_ACTIVATE_SUCCESS);
				return gson.toJson(response);
			}
		} catch (ProfileUpdateException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String emailVerification(String email)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper emailVerification : Start");

		UserProfileDO userprofileDO = null;
		try {
			userprofileDO = getUserManagementDAO().emailIdVerification(email);

			if (userprofileDO != null) {
				gson = new Gson();
				return gson.toJson(userprofileDO);
			}
		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getUserTeamList(String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getUserTeamList : Start");

		try {
			List<UserTeamListDO> userTeamList = getUserManagementDAO()
					.getUserTeamList(new Long(registerID));

			if (userTeamList != null) {
				gson = new Gson();
				return gson.toJson(userTeamList);
			}
		} catch (UserTeamListFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	/*
	 * public static String searchUserProfiles(ProfileSearchCriteriaDO
	 * searchCriteriaDO) throws UserManagementServiceException{
	 * 
	 * log.debug("UserManagementRestServiceHelper searchUserProfiles : Start");
	 * response = new UMServiceResponse(); try { boolean val =
	 * getUserManagementDAO().searchUserProfiles(searchCriteriaDO); if(val ==
	 * true){ gson = new Gson();
	 * response.setStatus(UserManagementServiceConstant.SUCCESS);
	 * response.setDescription
	 * (UserManagementServiceConstant.PROFILE_ACTIVATE_SUCCESS); return
	 * gson.toJson(response); } } catch (ProfileUpdateException e) { throw new
	 * UserManagementServiceException
	 * (e.getExceptionCode(),e.getExceptionMessage(),e.getExceptionDetails());
	 * }catch (ProfileNotFoundException e) { throw new
	 * UserManagementServiceException
	 * (e.getExceptionCode(),e.getExceptionMessage(),e.getExceptionDetails()); }
	 * 
	 * return UserManagementServiceConstant.EMPTY_STRING; }
	 */

	private static UserManagementDAO getUserManagementDAO() {
		if (userMgmtDao == null) {
			userMgmtDao = new UserManagementDAOImpl();
		}
		return userMgmtDao;

	}

	public static String getUserRolePermissions(String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getUserRolePermissions : Start");

		try {
			UsrAccessDetails usrAccessDetails = getUserManagementDAO()
					.getUserRolePermissions(new Long(registerID));

			if (usrAccessDetails != null) {
				gson = new Gson();
				return gson.toJson(usrAccessDetails);
			}
		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (UserRoleNotMappedException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (UserRoleNotMappedWithFunctionIdsException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (UserRoleNotDefinedException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (UserFunctionsNotDefinedException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getUserRecentComments(String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getUserRecentComments : Start");

		try {
			List<UserRecentComments> userRecentComments = getUserManagementDAO()
					.getUserRecentComments(new Long(registerID));

			if (userRecentComments != null) {
				gson = new Gson();
				return gson.toJson(userRecentComments);
			}
		} catch (UserRecentCommentsFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String searchUserProfiles(SearchCriteriaDO searchCriteriaDO)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper searchUserProfiles : Start");

		try {
			List<UserProfileDO> userProfiles = getUserManagementDAO()
					.searchUserProfiles(searchCriteriaDO);

			if (userProfiles != null) {
				gson = new Gson();
				return gson.toJson(userProfiles);
			}
		} catch (ProfileSearchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getPopularMentorList()
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getPopularMentorList : Start");
		try {
			List<PopularMentorsDO> popularMentors = getUserManagementDAO()
					.getPopularMentorList();
			if (popularMentors != null) {
				gson = new Gson();
				return gson.toJson(popularMentors);
			}
		} catch (PopularMentorsFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String forgotPassword(String email)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper forgotPassword : Start");
		response = new UMServiceResponse();
		try {
			String currentPassword = getUserManagementDAO().forgotPassword(
					email);
			if (currentPassword != null) {
				gson = new Gson();
				UserManagementEmailHelper.sendPassword(email, currentPassword);
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PASSWORD_SENT_SUCCESS);
				// System.out.println("response :"+response);
				// System.out.println("response1 :"+gson.toJson(response));
				return gson.toJson(response);
			}
		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (CurrentPasswordFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (EmailServiceException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String searchForMentors(String projId, String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper searchForMentors : Start");

		try {
			List<SearchForMentorListDO> mentorsList = getUserManagementDAO()
					.searchForMentors(new Long(projId), new Long(registerID));

			if (mentorsList != null) {
				gson = new Gson();
				return gson.toJson(mentorsList);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MentorSearchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String mentorsOfProject(String projId)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper mentorsOfProject : Start");

		try {
			List<Mentor1n2Details> mentorDetails = getUserManagementDAO()
					.getMentorsOfProject(new Long(projId));

			if (mentorDetails != null) {
				gson = new Gson();
				return gson.toJson(mentorDetails);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ProjectNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getCollegesList(String cName)
			throws CollegesFetchException, UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getCollegesList : Start");
		try {
			List<CollegeListDO> collegeList = getUserManagementDAO()
					.getCollegesList(cName);
			if (collegeList != null) {
				gson = new Gson();
				return gson.toJson(collegeList);
			}
		} catch (CollegesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String getUniversitiesList(String uName)
			throws UniversitiesFetchException, UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper getUniversitiesList : Start");
		try {
			List<UniversityListDO> universityList = getUserManagementDAO()
					.getUniversitiesList(uName);

			if (universityList != null) {
				gson = new Gson();
				return gson.toJson(universityList);
			}
		} catch (UniversitiesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public static String validateAdmin(String registerID)
			throws UserManagementServiceException {
		log.debug("UserManagementRestServiceHelper validateAdmin : Start");
		response = new UMServiceResponse();
		boolean flag = false;
		try {
			flag = getUserManagementDAO().validateAdmin(new Long(registerID));

			gson = new Gson();
			return gson.toJson(flag);

		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

	}
	
	public static String updateAddFacultyProfileHelper(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		log.debug("UserManagementRestServiceHelper updateAddFacultyProfileHelper:Start");
		response = new UMServiceResponse();
		try {
			boolean val = getUserManagementDAO().updateAddFacultyProfileHelper(userprofileDO);
			if (val == true) {
				gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_UPDATE_SUCCESS);
				return gson.toJson(response);
			}
		} catch (ProfileUpdateException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ChiperEncryptException e) {
			return e.toString();
		} catch (EmailExistException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

}
