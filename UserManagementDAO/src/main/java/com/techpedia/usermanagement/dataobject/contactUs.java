package com.techpedia.usermanagement.dataobject;

public class contactUs {

	private String username;
	private String emailId;
	private String message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "contactUs [username=" + username + ", emailId=" + emailId
				+ ", message=" + message + "]";
	}

	public contactUs() {
		super();
		// TODO Auto-generated constructor stub
	}
}
