/**
 * 
 */
package com.techpedia.usermanagement.exception;

/**
 * @author charan_teja
 *
 */

public class SuggestableReviewersException extends Exception{


	  
	    /**
	 * 
	 */
	private static final long serialVersionUID = 7223354595012554733L;
		private String exceptionCode;
		private String exceptionMessage;
		private String exceptionDetails;
		
		  public SuggestableReviewersException(String msg)
		    {
		        super(msg);
		    }
		
		/**
		 * @param exceptionCode
		 * @param exceptionMessage
		 * @param exceptionDetails
		 */
		public SuggestableReviewersException(String exceptionCode,
				String exceptionMessage, String exceptionDetails) {
			super(exceptionDetails);
			this.exceptionCode = exceptionCode;
			this.exceptionMessage = exceptionMessage;
			this.exceptionDetails = exceptionDetails;
		}

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
		public SuggestableReviewersException(String exceptionMessage, String exceptionDetails) {
			this.exceptionMessage = exceptionMessage;
			this.exceptionDetails = exceptionDetails;
		}
}
