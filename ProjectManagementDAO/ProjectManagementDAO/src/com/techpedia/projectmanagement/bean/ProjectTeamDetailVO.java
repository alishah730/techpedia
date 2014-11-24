package com.techpedia.projectmanagement.bean;


/**
 * @author nishikant.singh
 *
 */
public class ProjectTeamDetailVO {
	
	private long teamMemRegstrId;
	private String teamMemFName;
	private String teamMemMName;
	private String teamMemLName;
	private String photo;
	private long teamLeaderId;
	private String projTeamName;
	private String state;
	private String country;
	private String college;
	private long projId;
	private String projTitle;
	/**
	 * @return the teamMemFName
	 */
	public String getTeamMemFName() {
		return teamMemFName;
	}
	/**
	 * @param teamMemFName the teamMemFName to set
	 */
	public void setTeamMemFName(String teamMemFName) {
		this.teamMemFName = teamMemFName;
	}
	/**
	 * @return the teamMemMName
	 */
	public String getTeamMemMName() {
		return teamMemMName;
	}
	/**
	 * @param teamMemMName the teamMemMName to set
	 */
	public void setTeamMemMName(String teamMemMName) {
		this.teamMemMName = teamMemMName;
	}
	/**
	 * @return the teamMemLName
	 */
	public String getTeamMemLName() {
		return teamMemLName;
	}
	/**
	 * @param teamMemLName the teamMemLName to set
	 */
	public void setTeamMemLName(String teamMemLName) {
		this.teamMemLName = teamMemLName;
	}
	/**
	 * @return the teamLeaderId
	 */
	public long getTeamLeaderId() {
		return teamLeaderId;
	}
	/**
	 * @param teamLeaderId the teamLeaderId to set
	 */
	public void setTeamLeaderId(long teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	/**
	 * @return the teamMemRegstrId
	 */
	public long getTeamMemRegstrId() {
		return teamMemRegstrId;
	}
	/**
	 * @param teamMemRegstrId the teamMemRegstrId to set
	 */
	public void setTeamMemRegstrId(long teamMemRegstrId) {
		this.teamMemRegstrId = teamMemRegstrId;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the projTeamName
	 */
	public String getProjTeamName() {
		return projTeamName;
	}
	/**
	 * @param projTeamName the projTeamName to set
	 */
	public void setProjTeamName(String projTeamName) {
		this.projTeamName = projTeamName;
	}
	/**
	 * @return the projId
	 */
	public long getProjId() {
		return projId;
	}
	/**
	 * @param projId the projId to set
	 */
	public void setProjId(long projId) {
		this.projId = projId;
	}
	/**
	 * @return the projTitle
	 */
	public String getProjTitle() {
		return projTitle;
	}
	/**
	 * @param projTitle the projTitle to set
	 */
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
}
