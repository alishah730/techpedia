package com.techpedia.usermanagement.exception;

public class UserInactiveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1411221323667769131L;

	public UserInactiveException(String msg) {
		super(msg);
	}

	private String exceptionCode;
	private String exceptionMessage;
	private String exceptionDetails;

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

	public UserInactiveException(String exceptionCode, String exceptionMessage,
			String exceptionDetails) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
	}

}
