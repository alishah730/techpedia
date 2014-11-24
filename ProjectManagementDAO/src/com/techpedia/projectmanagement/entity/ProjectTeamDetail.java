package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author nishikant.singh
 *
 */
@Entity
public class ProjectTeamDetail{
	
	@Id
	@Column(name="RGSTR_ID")
	private long rgstrId;
	
	@Column(name="FNAME")
	private String teamMemFName;
	
	@Column(name="MNAME")
	private String teamMemMName;
	
	@Column(name="LNAME")
	private String teamMemLName;
	
	@Column(name="PHOTO")
	private String photo;
	
	@Column(name="PROJ_ID")
	private long projId;
	
	@Column(name="PROJ_TITLE")
	private String projTitle;
	
	@Column(name="PROJ_TEAM_LEADER_ID")
	private long teamLeaderId;
	
	@Column(name="PROJ_TEAM_DESC")	
	private String projTeamName;
	
	@Column(name="STATE")	
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="COLLEGE")
	private String college;
	
	
	/**
	 * @return the rgstrId
	 */
	public long getRgstrId() {
		return rgstrId;
	}
	/**
	 * @param rgstrId the rgstrId to set
	 */
	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}
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
