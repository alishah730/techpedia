package com.techpedia.usermanagement.service.exception;

import java.io.Serializable;

import com.google.gson.Gson;
import com.techpedia.usermanagement.service.constant.UserManagementServiceConstant;

public class UserManagementServiceException extends Exception implements Serializable
{
	private static final long serialVersionUID = 1L;

	public UserManagementServiceException()
	{
		super();
	}
	
	private String exceptionCode;
	private String exceptionMessage;
	private String exceptionDetails;

	/**
	 * @return the exceptionCode
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * @param exceptionCode the exceptionCode to set
	 */
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * @return the exceptionDetails
	 */
	public String getExceptionDetails() {
		return exceptionDetails;
	}

	/**
	 * @param exceptionDetails the exceptionDetails to set
	 */
	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

	public UserManagementServiceException(String exceptionCode,
			String exceptionMessage, String exceptionDetails) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
	}

	
	@Override
	public String toString() {
		
		String userMgmtException = "{"+UserManagementServiceConstant.LEFT_SLASH+"exceptionCode"+UserManagementServiceConstant.LEFT_SLASH+":"+UserManagementServiceConstant.LEFT_SLASH+ exceptionCode+UserManagementServiceConstant.LEFT_SLASH+","+UserManagementServiceConstant.LEFT_SLASH+"exceptionMessage"+UserManagementServiceConstant.LEFT_SLASH+":"+UserManagementServiceConstant.LEFT_SLASH+exceptionMessage+UserManagementServiceConstant.LEFT_SLASH+","+UserManagementServiceConstant.LEFT_SLASH+"exceptionDetails"+UserManagementServiceConstant.LEFT_SLASH+":"+UserManagementServiceConstant.LEFT_SLASH+exceptionDetails+UserManagementServiceConstant.LEFT_SLASH+"}";
		return userMgmtException;
	}
	

	
	
}
