package com.techpedia.usermanagement.exception;

	public class GetCollegeFacultyException extends Exception{

		  public GetCollegeFacultyException()
		    {
		    }

		    public GetCollegeFacultyException(String msg)
		    {
		        super(msg);
		    }

		    private static final long serialVersionUID = 0xbdeb49c6d2241b5aL;
		    private String exceptionCode;
			private String exceptionMessage;
			private String exceptionDetails;
			
			
			/**
			 * @param exceptionCode
			 * @param exceptionMessage
			 * @param exceptionDetails
			 */
			public GetCollegeFacultyException(String exceptionCode,
					String exceptionMessage, String exceptionDetails) {
				super();
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

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "GetRecentNewsException [exceptionCode=" + exceptionCode
						+ ", exceptionMessage=" + exceptionMessage
						+ ", exceptionDetails=" + exceptionDetails + "]";
			}
			
	}