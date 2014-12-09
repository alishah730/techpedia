package com.techpedia.projectmanagement.bean;

public class MentorVO {

	private long projId;
	private long mentorRgstrId;
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
	 * @return the mentorRgstrId
	 */
	public long getMentorRgstrId() {
		return mentorRgstrId;
	}
	/**
	 * @param mentorRgstrId the mentorRgstrId to set
	 */
	public void setMentorRgstrId(long mentorRgstrId) {
		this.mentorRgstrId = mentorRgstrId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorVO [projId=" + projId + ", mentorRgstrId="
				+ mentorRgstrId + "]";
	}
	
	
}
