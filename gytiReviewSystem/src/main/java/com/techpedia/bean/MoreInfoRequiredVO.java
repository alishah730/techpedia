package com.techpedia.bean;

public class MoreInfoRequiredVO {
	private String teamLeaderEmailId;
	private String reviewerComments;
	private String projectTitle;
	private String projectAbstract;
	/**
	 * @return the projectTitle
	 */
	public String getProjectTitle() {
		return projectTitle;
	}
	/**
	 * @param projectTitle the projectTitle to set
	 */
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	/**
	 * @return the projectAbstract
	 */
	public String getProjectAbstract() {
		return projectAbstract;
	}
	/**
	 * @param projectAbstract the projectAbstract to set
	 */
	public void setProjectAbstract(String projectAbstract) {
		this.projectAbstract = projectAbstract;
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
	 * @return the reviewerComments
	 */
	public String getReviewerComments() {
		return reviewerComments;
	}
	/**
	 * @param reviewerComments the reviewerComments to set
	 */
	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoreInfoRequiredVO [teamLeaderEmailId=" + teamLeaderEmailId + ", reviewerComments=" + reviewerComments
				+ ", projectTitle=" + projectTitle + ", projectAbstract=" + projectAbstract + "]";
	}
	public MoreInfoRequiredVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
