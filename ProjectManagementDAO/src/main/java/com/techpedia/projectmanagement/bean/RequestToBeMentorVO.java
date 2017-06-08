/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author 455959
 *
 */
public class RequestToBeMentorVO {
	
	
	private long projId;
	private long teamId;
	private long mentorRegstrId;
	private String mentorEmailId;
	private String mentorFirstName;
	private String mentorLastName;
	/**
	 * @return the mentorRegstrId
	 */
	public long getMentorRegstrId() {
		return mentorRegstrId;
	}
	/**
	 * @param mentorRegstrId the mentorRegstrId to set
	 */
	public void setMentorRegstrId(long mentorRegstrId) {
		this.mentorRegstrId = mentorRegstrId;
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
	 * @return the teamId
	 */
	public long getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the mentorEmailId
	 */
	public String getMentorEmailId() {
		return mentorEmailId;
	}
	/**
	 * @param mentorEmailId the mentorEmailId to set
	 */
	public void setMentorEmailId(String mentorEmailId) {
		this.mentorEmailId = mentorEmailId;
	}
	/**
	 * @return the mentorFirstName
	 */
	public String getMentorFirstName() {
		return mentorFirstName;
	}
	/**
	 * @param mentorFirstName the mentorFirstName to set
	 */
	public void setMentorFirstName(String mentorFirstName) {
		this.mentorFirstName = mentorFirstName;
	}
	/**
	 * @return the mentorLastName
	 */
	public String getMentorLastName() {
		return mentorLastName;
	}
	/**
	 * @param mentorLastName the mentorLastName to set
	 */
	public void setMentorLastName(String mentorLastName) {
		this.mentorLastName = mentorLastName;
	}
	
	

}
