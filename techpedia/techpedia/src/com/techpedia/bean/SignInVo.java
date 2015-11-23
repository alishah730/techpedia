package com.techpedia.bean;

import org.springframework.stereotype.Component;

@Component
public class SignInVo {
	
	private String username;
	private String password;
	private String emailId;
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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