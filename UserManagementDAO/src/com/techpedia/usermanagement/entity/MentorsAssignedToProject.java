package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentorsAssignedToProject {
	
	@Id
	@Column (name = "PROJ_ID")
	private long projId;
	
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

	@Column (name = "PROJ_MENTOR1_ID")
	private long mentorId1;
	
	@Column (name = "PROJ_MENTOR2_ID")
	private long mentorId2;

	/**
	 * @return the mentorId1
	 */
	public long getMentorId1() {
		return mentorId1;
	}

	/**
	 * @param mentorId1 the mentorId1 to set
	 */
	public void setMentorId1(long mentorId1) {
		this.mentorId1 = mentorId1;
	}

	/**
	 * @return the mentorId2
	 */
	public long getMentorId2() {
		return mentorId2;
	}

	/**
	 * @param mentorId2 the mentorId2 to set
	 */
	public void setMentorId2(long mentorId2) {
		this.mentorId2 = mentorId2;
	}
	
	

}
