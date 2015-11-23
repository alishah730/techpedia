package com.techpedia.projectmanagement.exception;

public class GetChallengeTypeException extends Exception {

	private static final long serialVersionUID = 7316448332565167481L;
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
	public GetChallengeTypeException(String exceptionCode,
			String exceptionMessage, String exceptionDetails) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
	}
	public GetChallengeTypeException(String message) {
		super(message);		
	}
	
}
