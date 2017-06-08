package com.techpedia.usermanagement.service.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.techpedia.chiper.ChiperEncryptException;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.usermanagement.dao.UserManagementDAO;
import com.techpedia.usermanagement.dataobject.AddNewReviewerResponse;
import com.techpedia.usermanagement.dataobject.CityListDO;
import com.techpedia.usermanagement.dataobject.CollegeDataDo;
import com.techpedia.usermanagement.dataobject.CollegeFacultyInfo;
import com.techpedia.usermanagement.dataobject.CollegeListDO;
import com.techpedia.usermanagement.dataobject.DegreeListDO;
import com.techpedia.usermanagement.dataobject.Mentor1n2Details;
import com.techpedia.usermanagement.dataobject.MoreInfoRequiredDO;
import com.techpedia.usermanagement.dataobject.NotifyReviewerVo;
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
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.dataobject.UserRecentComments;
import com.techpedia.usermanagement.dataobject.UserTeamListDO;
import com.techpedia.usermanagement.dataobject.UsrAccessDetails;
import com.techpedia.usermanagement.dataobject.contactUs;
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
import com.techpedia.usermanagement.service.constant.UserManagementServiceConstant;
import com.techpedia.usermanagement.service.exception.UserManagementServiceException;
import com.techpedia.usermanagement.service.response.UMServiceResponse;

//import com.techpedia.usermanagement.dataobject.ProfileSearchCriteriaDO;

@Service
public class UserManagementRestServiceHelper {

	@Autowired
	@Qualifier("userManagementDAO")
	UserManagementDAO userManagementDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementRestServiceHelper.class.getName());

	//static UserManagementDAO userMgmtDao = null;
	//static UMServiceResponse response = null;
	//static Gson gson = null;
	//UserManagementServiceException userMgmtException = null;
	
	/**
	 * @param uploadProjDocVO
	 * @return
	 */
	public String uploadUserPhoto(SaveUserPhoto saveUserPhoto) throws UserManagementServiceException{
		String result = null;
		LOGGER.debug("UserManagementRestServiceHelper UploadUserPhoto:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			result = userManagementDAO.uploadUserPhoto(saveUserPhoto);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.FAILURE);
				return gson.toJson(response);
			}
		} catch (SaveUserPhotoException e) {			
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}		
	}
	
	public String createNewProfile(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper createNewProfile:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.createNewProfile(userprofileDO);
			if (val == true && userprofileDO.getiSactive().equalsIgnoreCase("N") && userprofileDO.getIsPhoto().equalsIgnoreCase("N")) {
				
				UserManagementEmailHelper.sendEmail(userprofileDO);
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
			}
			else if(val == true && userprofileDO.getiSactive().equalsIgnoreCase("N") && userprofileDO.getIsPhoto().equalsIgnoreCase("Y")){
				SaveUserPhoto saveUserPhoto =new SaveUserPhoto();
				saveUserPhoto.setRegisterId(userprofileDO.getRgstrId());
				saveUserPhoto.setImgName(userprofileDO.getImgName());
				saveUserPhoto.setImgByteArray(userprofileDO.getImgByteArray());
				String result = userManagementDAO.uploadUserPhoto(saveUserPhoto);
				if(result == "Y"){	
				UserManagementEmailHelper.sendEmail(userprofileDO);
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
				}
				else{
					Gson gson = new Gson();
					response.setStatus(UserManagementServiceConstant.FAILURE);
					return gson.toJson(response);
				}
			}
			else if(val == true && userprofileDO.getiSactive().equalsIgnoreCase("Y") && userprofileDO.getIsPhoto().equalsIgnoreCase("N")) {
					
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
				
			}
			else if(val == true && userprofileDO.getiSactive().equalsIgnoreCase("Y") && userprofileDO.getIsPhoto().equalsIgnoreCase("Y")) {
				SaveUserPhoto saveUserPhoto =new SaveUserPhoto();
				saveUserPhoto.setRegisterId(userprofileDO.getRgstrId());
				saveUserPhoto.setImgName(userprofileDO.getImgName());
				saveUserPhoto.setImgByteArray(userprofileDO.getImgByteArray());
				String result = userManagementDAO.uploadUserPhoto(saveUserPhoto);
				if(result == "Y"){	
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
				}
				else{
					Gson gson = new Gson();
					response.setStatus(UserManagementServiceConstant.FAILURE);
					return gson.toJson(response);
				}
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
			LOGGER.error("An unexpected EmailServiceException occured while addNewReviewer Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(UserManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(UserManagementServiceConstant.ADD_NEW_USER_SUCCESS_MAIL_FAILURE);
			return gson.toJson(response);
		} catch (EmailExistException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (SaveUserPhotoException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String createProfile(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper createProfile:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.createProfile(userprofileDO);
			if (val == true && userprofileDO.getiSactive().equalsIgnoreCase("N")) {

				UserManagementEmailHelper.sendEmail(userprofileDO);

				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PROFILE_CREATE_SUCCESS);
				return gson.toJson(response);
			}
			else if(val == true && userprofileDO.getiSactive().equalsIgnoreCase("Y")) {
				Gson gson = new Gson();
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

	public String updateProfile(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper updateProfile:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.updateProfile(userprofileDO);
			if (val == true) {
				Gson gson = new Gson();
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

	public String deactivateProfile(String userID)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper deactivateProfile : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.deactivateProfile(userID);
			if (val == true) {
				Gson gson = new Gson();
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
	
	public String getUserDetailsNew(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserDetails : Start");
		UserProfileDO userprofileDO = null;
		try {
			userprofileDO = userManagementDAO.getUserProfileNew(
					new Long(registerID));

			if (userprofileDO != null) {
				Gson gson = new Gson();
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

	public String getUserDetails(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserDetails : Start");
		UserProfileDO userprofileDO = null;
		try {
			userprofileDO = userManagementDAO.getUserProfile(
					new Long(registerID));

			if (userprofileDO != null) {
				Gson gson = new Gson();
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

	public String socialSignInHelper(String email)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper socialSignIn : Start");
		UserProfileDO userprofileDO = null;
		try {
			userprofileDO = userManagementDAO.socialSignInHelper(email);
			
			if (userprofileDO != null) {
				Gson gson = new Gson();
				return gson.toJson(userprofileDO);
			}
		}catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (LoginException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}catch (UserInactiveException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

		return UserManagementServiceConstant.EMPTY_STRING;
		
	}
	
	public String signIn(SignInVo signInVo)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper signIn : Start");
		UserProfileDO userprofileDO = null;
		try {
			userprofileDO = userManagementDAO.singIn(signInVo);

			if (userprofileDO != null) {
				Gson gson = new Gson();
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

	public String authenticate(String userID, String password)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper authenticate : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.authenticate(userID, password);

			if (val == true) {
				Gson gson = new Gson();
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

	public String passwordReset(PasswordResetVo pwdResetVo) throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper passwordReset : Start");

		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.passwordReset(pwdResetVo);

			if (val == true) {
				Gson gson = new Gson();
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

	public String updatePhoto(SaveUserPhoto saveUserPhoto)
			throws UserManagementServiceException, SaveUserPhotoException {
		LOGGER.debug("UserManagementRestServiceHelper updatePhoto: Start");

		UMServiceResponse response = new UMServiceResponse();
		try {
			String val = userManagementDAO.uploadUserPhoto(saveUserPhoto);

			if (val == "Y") {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PHOTO_UPDATE_SUCCESS);
				return gson.toJson(response);
			}

		} catch (SaveUserPhotoException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} 

		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String activateProfile(String userID)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper activateProfile : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.activateProfile(userID);
			if (val == true) {
				Gson gson = new Gson();
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

	public String emailVerification(String email)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper emailVerification : Start " + email);
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val=  userManagementDAO.emailIdVerification(email);
			 if (val == true) {
					Gson gson = new Gson();
					response.setStatus(UserManagementServiceConstant.SUCCESS);
					response.setDescription(UserManagementServiceConstant.EMAIL_FETCH_SUCCESS);
					return gson.toJson(response);
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

	public String getUserTeamList(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserTeamList : Start");

		try {
			List<UserTeamListDO> userTeamList = userManagementDAO
					.getUserTeamList(new Long(registerID));

			if (userTeamList != null) {
				Gson gson = new Gson();
				return gson.toJson(userTeamList);
			}
		} catch (UserTeamListFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	/*
	 * public String searchUserProfiles(ProfileSearchCriteriaDO
	 * searchCriteriaDO) throws UserManagementServiceException{
	 * 
	 * LOGGER.debug("UserManagementRestServiceHelper searchUserProfiles : Start");
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

	/*private static UserManagementDAO getUserManagementDAO() {
		if (userMgmtDao == null) {
			userMgmtDao = new UserManagementDAOImpl();
		}
		return userMgmtDao;

	}*/

	public String getUserRolePermissions(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserRolePermissions : Start");

		try {
			UsrAccessDetails usrAccessDetails = userManagementDAO
					.getUserRolePermissions(new Long(registerID));

			if (usrAccessDetails != null) {
				Gson gson = new Gson();
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

	public String getUserRecentComments(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserRecentComments : Start");

		try {
			List<UserRecentComments> userRecentComments = userManagementDAO
					.getUserRecentComments(new Long(registerID));

			if (userRecentComments != null) {
				Gson gson = new Gson();
				return gson.toJson(userRecentComments);
			}
		} catch (UserRecentCommentsFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String searchUserProfiles(SearchCriteriaDO searchCriteriaDO)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper searchUserProfiles : Start");

		try {
			List<UserProfileDO> userProfiles = userManagementDAO
					.searchUserProfiles(searchCriteriaDO);

			if (userProfiles != null) {
				Gson gson = new Gson();
				return gson.toJson(userProfiles);
			}
		} catch (ProfileSearchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String getPopularMentorList()
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getPopularMentorList : Start");
		try {
			List<PopularMentorsDO> popularMentors = userManagementDAO
					.getPopularMentorList();
			if (popularMentors != null) {
				Gson gson = new Gson();
				return gson.toJson(popularMentors);
			}
		} catch (PopularMentorsFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String contactUs(contactUs contactUs)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper contactUs : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String email = contactUs.getEmailId();
			String username = contactUs.getUsername();
			String message = contactUs.getMessage();
				Gson gson = new Gson();
				UserManagementEmailHelper.sendContactUs(email, username, message);
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription("Email sent succesfully");
				// System.out.println("response :"+response);
				// System.out.println("response1 :"+gson.toJson(response));
				return gson.toJson(response);
				
		} catch (EmailServiceException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
	}

	public String forgotPassword(String email)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper forgotPassword : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String currentPassword = userManagementDAO.forgotPassword(
					email);
			if (currentPassword != null) {
				Gson gson = new Gson();
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

	public String searchForMentors(String projId, String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper searchForMentors : Start");

		try {
			List<SearchForMentorListDO> mentorsList = userManagementDAO
					.searchForMentors(new Long(projId), new Long(registerID));

			if (mentorsList != null) {
				Gson gson = new Gson();
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

	public String mentorsOfProject(String projId)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper mentorsOfProject : Start");

		try {
			List<Mentor1n2Details> mentorDetails = userManagementDAO
					.getMentorsOfProject(new Long(projId));

			if (mentorDetails != null) {
				Gson gson = new Gson();
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

	public String getStateList(String sName)
			throws StateFetchException, UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getStateList : Start");
		try {
			List<StateListDO> stateList = userManagementDAO
					.getStateList(sName);
			if (stateList != null) {
				Gson gson = new Gson();
				return gson.toJson(stateList);
			}
		} catch (StateFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getCityList(SearchCityDO searchCityDO)
			throws UserManagementServiceException, CityFetchException {
		LOGGER.debug("UserManagementRestServiceHelper getCityList : Start " + searchCityDO.getTerm()+ "  " + searchCityDO.getStateName());
		try {
			List<CityListDO> cityList = userManagementDAO
					.getCityList(searchCityDO);
			if (cityList != null) {
				Gson gson = new Gson();
				return gson.toJson(cityList);
			}
		} catch (CityFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getCollegesList(SearchCollegeDO searchCollege)
			throws CollegesFetchException, UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getCollegesList : Start");
		try {
			List<CollegeListDO> collegeList = userManagementDAO
					.getCollegesList(searchCollege);
			if (collegeList != null) {
				Gson gson = new Gson();
				return gson.toJson(collegeList);
			}
		} catch (CollegesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getCollegesListHeader(SearchCollegeDO searchCollege)
			throws CollegesFetchException, UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getCollegesList : Start");
		try {
			List<CollegeListDO> collegeList = userManagementDAO
					.getCollegesListHeader(searchCollege);
			if (collegeList != null) {
				Gson gson = new Gson();
				return gson.toJson(collegeList);
			}
		} catch (CollegesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String getCollegesListUser(String cName)
			throws CollegesFetchException, UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getCollegesListUser : Start");
		try {
			List<CollegeListDO> collegeList = userManagementDAO
					.getCollegesListUser(cName);
			if (collegeList != null) {
				Gson gson = new Gson();
				return gson.toJson(collegeList);
			}
		} catch (CollegesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	
	public String getUniversitiesList(String uName)
			throws UniversitiesFetchException, UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUniversitiesList : Start");
		try {
			List<UniversityListDO> universityList = userManagementDAO
					.getUniversitiesList(uName);

			if (universityList != null) {
				Gson gson = new Gson();
				return gson.toJson(universityList);
			}
		} catch (UniversitiesFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	public String validateAdmin(String registerID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper validateAdmin : Start");
		UMServiceResponse response = new UMServiceResponse();
		boolean flag = false;
		try {
			flag = userManagementDAO.validateAdmin(new Long(registerID));

			Gson gson = new Gson();
			return gson.toJson(flag);

		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (ProfileFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}

	}
	
	public String updateAddFacultyProfileHelper(UserProfileDO userprofileDO)
			throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper updateAddFacultyProfileHelper:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.updateAddFacultyProfileHelper(userprofileDO);
			if (val == true) {
				Gson gson = new Gson();
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
	
	public String getRecentNews()
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper spring getRecentNews:Start");
		try {
			List<RecentNewsDO> recentNewsList = userManagementDAO.getRecentNews();

			if (recentNewsList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(recentNewsList);
			}
		} catch (GetRecentNewsException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String collegeFacultyList(String collegeName)
			throws UserManagementServiceException, GetCollegeFacultyException {
		LOGGER.debug("UserManagementRestServiceHelper spring collegFacultyList:Start");
		try {
			List<CollegeFacultyInfo> facultyList = userManagementDAO.getCollegeFaculty(collegeName);

			if (facultyList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(facultyList);
			}
		} catch (GetCollegeFacultyException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getCollegeRecentNews(String collegeName)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper spring getRecentNews:Start");
		try {
			List<RecentNewsDO> recentNewsList = userManagementDAO.getCollegeRecentNews(collegeName);

			if (recentNewsList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(recentNewsList);
			}
		} catch (CollegeRecentNewsException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	
	public String addCollegeRecentNews(RecentNewsDO recentNewsDO) throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper spring addCollegeRecentNews:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String result = userManagementDAO.addCollegeRecentNews(recentNewsDO);

			if (result == "Y") {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.ADD_COLLEGE_RECENT_NEWS_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.FAILURE);
				response.setDescription(UserManagementServiceConstant.ADD_COLLEGE_RECENT_NEWS_FAILURE);
				return gson.toJson(response);
			}
		} catch (CollegeRecentNewsException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
	}
	
	public String deleteCollegeNews(String newsId) throws UserManagementServiceException {
		//LOGGER.debug("UserManagementRestServiceHelper spring deleteCollegeNews:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String result = userManagementDAO.deleteCollegeRecentNews(newsId);

			if (result == "Y") {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.DELETE_COLLEGE_RECENT_NEWS_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.FAILURE);
				response.setDescription(UserManagementServiceConstant.DELETE_COLLEGE_RECENT_NEWS_FAILURE);
				return gson.toJson(response);
			}
		} catch (CollegeRecentNewsException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
	}
	
	public String getCollegeRecentNewsAdmin(String collegeName)
			throws CollegeRecentNewsException {
		LOGGER.debug("UserManagementRestServiceHelper spring getRecentNews:Start");
		try {
			List<RecentNewsDO> recentNewsList = userManagementDAO.getCollegeRecentNewsAdmin(collegeName);

			if (recentNewsList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(recentNewsList);
			}
		} catch (CollegeRecentNewsException e) {
			throw new CollegeRecentNewsException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String activateCollegeNews(String newsId) throws CollegeRecentNewsException {
		//LOGGER.debug("UserManagementRestServiceHelper spring deleteCollegeNews:Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String result = userManagementDAO.activateCollegeRecentNews(newsId);

			if (result == "Y") {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.ACTIVATE_COLLEGE_RECENT_NEWS_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.FAILURE);
				response.setDescription(UserManagementServiceConstant.ACTIVATE_COLLEGE_RECENT_NEWS_FAILURE);
				return gson.toJson(response);
			}
		} catch (CollegeRecentNewsException e) {
			throw new CollegeRecentNewsException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
	}

	public String getActiveCollegeRecentNewsAdmin(String collegeName)
			throws CollegeRecentNewsException {
		LOGGER.debug("UserManagementRestServiceHelper spring getRecentNews:Start");
		try {
			List<RecentNewsDO> recentNewsList = userManagementDAO.getActiveCollegerecentNewsAdmin(collegeName);

			if (recentNewsList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(recentNewsList);
			}
		} catch (CollegeRecentNewsException e) {
			throw new CollegeRecentNewsException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getInActiveCollegeRecentNewsAdmin(String collegeName)
			throws CollegeRecentNewsException {
		LOGGER.debug("UserManagementRestServiceHelper spring getRecentNews:Start");
		try {
			List<RecentNewsDO> recentNewsList = userManagementDAO.getInActiveCollegerecentNewsAdmin(collegeName);

			if (recentNewsList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(recentNewsList);
			}
		} catch (CollegeRecentNewsException e) {
			throw new CollegeRecentNewsException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}


	public String addNewReviewer(ReviewerDO reviewerDO) throws AddNewReviewerException, EmailServiceException {
		UMServiceResponse response = new UMServiceResponse();
		AddNewReviewerResponse addNewReviewerResponse = new AddNewReviewerResponse();
		try {
			addNewReviewerResponse = userManagementDAO.addNewReviewer(reviewerDO);

			if (addNewReviewerResponse.getStatus() == "Y") {
				UserManagementEmailHelper.sendEmail(addNewReviewerResponse.getReviewerDO());
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.ADD_NEW_REVIEWER_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.FAILURE);
				response.setDescription(UserManagementServiceConstant.ADD_NEW_REVIEWER_FAILURE);
				return gson.toJson(response);
			}
		} 
		catch (AddNewReviewerException e) {
			LOGGER.error("An unexpected AddNewReviewerException occured while addNewReviewer Ex :: ", e);
			throw new AddNewReviewerException(e.getExceptionCode(),e.getExceptionMessage(), e.getExceptionDetails());
		}
		catch (EmailServiceException e) {
			LOGGER.error("An unexpected EmailServiceException occured while addNewReviewer Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(UserManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(UserManagementServiceConstant.ADD_NEW_REVIEWER_SUCCESS_MAIL_FAILURE);
			return gson.toJson(response);
		}
		catch (Exception e) {
			LOGGER.error("An unexpected Exception occured while addNewReviewer Ex :: ", e);
			throw e;
		}
	}
	public String activateReviewerProfile(String userID) throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper activateProfile : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.activateReviewerProfile(userID);
			if (val == true) {
				Gson gson = new Gson();
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
	
	public String deActivateReviewerProfile(String userID) throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper deActivateReviewerProfile : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.deActivateReviewerProfile(userID);
			if (val == true) {
				Gson gson = new Gson();
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
	
	public String reviewerAuthenticate(String userID, String password)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper Reviewer authenticate : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.reviewerAuthenticate(userID, password);

			if (val == true) {
				Gson gson = new Gson();
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

	
	public String reviewerSignIn(SignInVo signInVo)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper signIn : Start");
		ReviewerDO reviewerProfileDO = null;
		try {
			reviewerProfileDO = userManagementDAO.reviewerSignIn(signInVo);

			if (reviewerProfileDO != null) {
				Gson gson = new Gson();
				return gson.toJson(reviewerProfileDO);
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
	
	public String getReviewerDetails(String emailID)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getUserDetails : Start");
		ReviewerDetailsDO reviewerprofileDO = null;
		try {
			reviewerprofileDO = userManagementDAO.getReviewerProfile(emailID);

			if (reviewerprofileDO != null) {
				Gson gson = new Gson();
				return gson.toJson(reviewerprofileDO);
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
	
	public Object getAllReviewer() throws GetReviewerException{
		ArrayList<ReviewerDO> reviewers =null;
		try {
			reviewers = userManagementDAO.getAllReviewer();
			if(reviewers != null){
				Gson gson = new Gson();
				return gson.toJson(reviewers);
			}
		} catch (GetReviewerException e) {
			throw e;
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getActiveReviewers()
			throws ReviewerStatusException {
		LOGGER.debug("UserManagementRestServiceHelper spring getActiveReviewers:Start");
		try {
			List<ReviewerDO> ActiveReviewersList = userManagementDAO.getActiveReviewers();

			if (ActiveReviewersList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(ActiveReviewersList);
			}
		} catch (ReviewerStatusException e) {
			throw new ReviewerStatusException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String getDeactiveReviewers()
			throws ReviewerStatusException {
		LOGGER.debug("UserManagementRestServiceHelper spring getDeactiveReviewers");
		try {
			List<ReviewerDO> DeactiveReviewersList = userManagementDAO.getDeactiveReviewers();

			if (DeactiveReviewersList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(DeactiveReviewersList);
			}
		} catch (ReviewerStatusException e) {
			throw new ReviewerStatusException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}

	
	@SuppressWarnings("unused")
	public String getSuggestableReviewers(long projId) throws SuggestableReviewersException{
		LOGGER.debug("UserManagementRestServiceHelper :: getSuggestableReviewers start");
		List<ReviewerDO> suggestableReviewersList = null;
		UMServiceResponse response=new UMServiceResponse();
		try {
			suggestableReviewersList = userManagementDAO.getSuggestableReviewers(projId);

			if (suggestableReviewersList != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(suggestableReviewersList);
			}
			else if (suggestableReviewersList == null) {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.NO_SUGGESTABLE_REVIEWERS);
				return gson.toJson(response);
			}
		} catch (SuggestableReviewersException e) {
			Gson gson = new Gson();
			response.setStatus(UserManagementServiceConstant.FAILURE);
			response.setDescription(UserManagementServiceConstant.SUGGESTABLE_REVIEWERS_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String editReviewerProfile(ReviewerDO reviewer) throws UserManagementServiceException {

		LOGGER.debug("UserManagementRestServiceHelper editProfile : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.editReviewerProfile(reviewer);
			if (val == true) {
				Gson gson = new Gson();
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.REVIEWER_PROFILE_UPDATE_SUCCESS);
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
	
	public String getDegreeList(String searchTerm) throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getCollegesListUser : Start");
		try {
			List<DegreeListDO> DegreeList = userManagementDAO.getDegreeList(searchTerm);
			if (DegreeList != null) {
				Gson gson = new Gson();
				return gson.toJson(DegreeList);
			}
		} catch (DegreeFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String reviewerForgotPassword(String email)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper reviewerForgotPassword : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String currentPassword = userManagementDAO.reviewerForgotPassword(email);
			if (currentPassword != null) {
				Gson gson = new Gson();
				UserManagementEmailHelper.sendPassword(email, currentPassword);
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.PASSWORD_SENT_SUCCESS);
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
	
	public String reviewerPasswordReset(PasswordResetVo pwdResetVo) throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper reviewerPasswordReset : Start");

		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean val = userManagementDAO.reviewerPasswordReset(pwdResetVo);

			if (val == true) {
				Gson gson = new Gson();
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
	
	public String getCollegeInforamtion(String collegeName)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper getCollegeInforamtion : Start");
		
		try {
			CollegeDataDo collegeDataDo= userManagementDAO.getCollegeInforamtion(collegeName);
			LOGGER.info("response :: "+collegeDataDo.toString());

			if (collegeDataDo != null) {
				Gson gson = new Gson();
				return gson.toJson(collegeDataDo);
			}

		}catch (CollegeInformationException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String notifySuggestedReviewer(NotifyReviewerVo notifyReviewerVo)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper notifySuggestedReviewer : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			boolean userFound = userManagementDAO.notifySuggestedReviewer(notifyReviewerVo.getSuggestedReviewerEmail());
			LOGGER.info("User Found or Not? ==="+userFound);
			if (userFound == true) {
				Gson gson = new Gson();
				UserManagementEmailHelper.notifySuggestedReviewer(notifyReviewerVo);
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.NOTIFY_REVIEWER);
				return gson.toJson(response);
			}
		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (CurrentPasswordFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (EmailServiceException e) {
			Gson gson = new Gson();
			response.setStatus(UserManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(UserManagementServiceConstant.NOTIFY_REVIEWER_SUCCESS_MAIL_FAILURE);
			return gson.toJson(response);
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
	
	public String sendMoreInfoRequestToTeamLeader(MoreInfoRequiredDO moreInfoRequiredDO)
			throws UserManagementServiceException {
		LOGGER.debug("UserManagementRestServiceHelper notifySuggestedReviewer : Start");
		UMServiceResponse response = new UMServiceResponse();
		try {
			String comments=null;
			boolean userFound = userManagementDAO.sendMoreInfoRequestToTeamLeader(moreInfoRequiredDO.getTeamLeaderEmailId());
			LOGGER.info("User Found or Not? ==="+userFound);
			LOGGER.info("Reviewer Comments? ==="+moreInfoRequiredDO.getReviewerComments());
			if(moreInfoRequiredDO.getReviewerComments().isEmpty() || moreInfoRequiredDO.getReviewerComments() == "" || moreInfoRequiredDO.getReviewerComments() == null){
				comments = "Projects details are not sufficient for review. Please provide the more information about the following project:.";
			}else{
				comments = moreInfoRequiredDO.getReviewerComments();
			}
			LOGGER.info("Comments? ==="+comments);
			if (userFound == true) {
				Gson gson = new Gson();
				UserManagementEmailHelper.sendMoreInfoRequestToTeamLeader(moreInfoRequiredDO.getTeamLeaderEmailId(),comments,moreInfoRequiredDO.getProjectTitle(),moreInfoRequiredDO.getProjectAbstract());
				response.setStatus(UserManagementServiceConstant.SUCCESS);
				response.setDescription(UserManagementServiceConstant.MORE_INFO_REQUIRED);
				return gson.toJson(response);
			}
		} catch (UserNotFoundException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (CurrentPasswordFetchException e) {
			throw new UserManagementServiceException(e.getExceptionCode(),
					e.getExceptionMessage(), e.getExceptionDetails());
		} catch (EmailServiceException e) {
			Gson gson = new Gson();
			response.setStatus(UserManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(UserManagementServiceConstant.NOTIFY_REVIEWER_SUCCESS_MAIL_FAILURE);
			return gson.toJson(response);
		}
		return UserManagementServiceConstant.EMPTY_STRING;
	}
}
