/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author 455959
 *
 */
public class ResubmitProjectResponse {
	
	private String status;
	private String facultyEmailId;
	private String teamLeaderEmailId;
	private Project project;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the facultyEmailId
	 */
	public String getFacultyEmailId() {
		return facultyEmailId;
	}
	/**
	 * @param facultyEmailId the facultyEmailId to set
	 */
	public void setFacultyEmailId(String facultyEmailId) {
		this.facultyEmailId = facultyEmailId;
	}
	/**
	 * @return the teamLeaderEmailId
	 */
	public String getTeamLeaderEmailId() {
		return teamLeaderEmailId;
	}
	/**
	 * @param teamLeaderEmailId the teamLeaderEmailId to set
	 */
	public void setTeamLeaderEmailId(String teamLeaderEmailId) {
		this.teamLeaderEmailId = teamLeaderEmailId;
	}
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	

}
