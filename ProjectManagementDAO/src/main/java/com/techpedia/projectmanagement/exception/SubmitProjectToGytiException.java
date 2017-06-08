/**
 * 
 */
package com.techpedia.projectmanagement.exception;

/**
 * @author charan_teja
 *
 */
public class SubmitProjectToGytiException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1735865764229248668L;
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
	 * @param message
	 */
	public SubmitProjectToGytiException(String message) {
		super(message);
	}
	
	/**
	 * @param exceptionCode
	 * @param exceptionMessage
	 * @param exceptionDetails
	 */
	public SubmitProjectToGytiException(String exceptionCode, String exceptionMessage, String exceptionDetails) {
		this.exceptionCode = exceptionCode;
	    this.exceptionMessage = exceptionMessage;
	    this.exceptionDetails = exceptionDetails;
	}
	/**
	 * @param exceptionCode
	 * @param exceptionMessage
	 * @param exceptionDetails
	 */
	public SubmitProjectToGytiException(String exceptionMessage, String exceptionDetails) {
	    this.exceptionMessage = exceptionMessage;
	    this.exceptionDetails = exceptionDetails;
	}

}
