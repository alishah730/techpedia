package com.techpedia.usermanagement.dataobject;

public class SignInVo {

	private String username;
	private String emailId;
	private String password;

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


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInVo [username=" + username + ", emailId=" + emailId
				+ ", password=" + password + "]";
	}

	public SignInVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
