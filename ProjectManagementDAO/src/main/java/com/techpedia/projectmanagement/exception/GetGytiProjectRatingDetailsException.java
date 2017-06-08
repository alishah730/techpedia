package com.techpedia.projectmanagement.exception;
/**
 * @author charan_teja
 *
 */
public class GetGytiProjectRatingDetailsException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2512410519341024701L;
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
	/**
	 * @param exceptionMessage
	 * @param exceptionDetails
	 */
	public GetGytiProjectRatingDetailsException(String exceptionMessage, String exceptionDetails) {
		this.exceptionMessage = exceptionMessage;
		this.exceptionDetails = exceptionDetails;
	}
	/**
	 * @param message
	 */
	public GetGytiProjectRatingDetailsException(String message) {
		super(message);		
	}
	
}
