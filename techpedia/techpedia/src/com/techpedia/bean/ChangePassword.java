package com.techpedia.bean;

public class ChangePassword {
	String username;
	String oldPassword;
	String newPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [username=" + username + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
}
