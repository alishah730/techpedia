/**
 * 
 */
package com.techpedia.projectmanagement.exception;

/**
 * @author nishikant.singh
 *
 */
public class ReplaceTeamLeadException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3535765969068282433L;
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
	 * @param exceptionCode
	 * @param exceptionMessage
	 * @param exceptionDetails
	 */
	public ReplaceTeamLeadException(String exceptionCode, String exceptionMessage, String exceptionDetails) {
		this.exceptionCode = exceptionCode;
	    this.exceptionMessage = exceptionMessage;
	    this.exceptionDetails = exceptionDetails;
	}

	/**
	 * @param message
	 */
	public ReplaceTeamLeadException(String message) {
		super(message);
	}

	
}
