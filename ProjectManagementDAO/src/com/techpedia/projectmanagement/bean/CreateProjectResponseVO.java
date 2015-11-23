package com.techpedia.projectmanagement.bean;

public class CreateProjectResponseVO {

	private String status;
	
	private String facultyEMailId;
	
	private String teamTeaderEMailId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFacultyEMailId() {
		return facultyEMailId;
	}

	public void setFacultyEMailId(String facultyEMailId) {
		this.facultyEMailId = facultyEMailId;
	}

	public String getTeamTeaderEMailId() {
		return teamTeaderEMailId;
	}

	public void setTeamTeaderEMailId(String teamTeaderEMailId) {
		this.teamTeaderEMailId = teamTeaderEMailId;
	}
	
	
}
