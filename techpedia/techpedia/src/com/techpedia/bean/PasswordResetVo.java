package com.techpedia.bean;

public class PasswordResetVo {
	private String userName;
	private String oldpassword;
	private String newpassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	@Override
	public String toString() {
		return "PasswordResetVo [userName=" + userName + ", oldpassword="
				+ oldpassword + ", newpassword=" + newpassword + "]";
	}

	public PasswordResetVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
