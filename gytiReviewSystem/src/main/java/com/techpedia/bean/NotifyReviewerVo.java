package com.techpedia.bean;

public class NotifyReviewerVo {
	private String suggestedReviewerEmail;
	private String suggestedReviewerName;
	private String loggedInReviewerEmail;
	private String projectTitle;
	private String projectAbstract;
	/**
	 * @return the suggestedReviewerEmail
	 */
	public String getSuggestedReviewerEmail() {
		return suggestedReviewerEmail;
	}
	/**
	 * @param suggestedReviewerEmail the suggestedReviewerEmail to set
	 */
	public void setSuggestedReviewerEmail(String suggestedReviewerEmail) {
		this.suggestedReviewerEmail = suggestedReviewerEmail;
	}
	/**
	 * @return the loggedInReviewerEmail
	 */
	
	public String getLoggedInReviewerEmail() {
		return loggedInReviewerEmail;
	}
	/**
	 * @return the suggestedReviewerName
	 */
	public String getSuggestedReviewerName() {
		return suggestedReviewerName;
	}
	/**
	 * @param suggestedReviewerName the suggestedReviewerName to set
	 */
	public void setSuggestedReviewerName(String suggestedReviewerName) {
		this.suggestedReviewerName = suggestedReviewerName;
	}
	/**
	 * @param loggedInReviewerEmail the loggedInReviewerEmail to set
	 */
	public void setLoggedInReviewerEmail(String loggedInReviewerEmail) {
		this.loggedInReviewerEmail = loggedInReviewerEmail;
	}
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NotifyReviewerVo [suggestedReviewerEmail=" + suggestedReviewerEmail + ", suggestedReviewerName="
				+ suggestedReviewerName + ", loggedInReviewerEmail=" + loggedInReviewerEmail + ", projectTitle="
				+ projectTitle + ", projectAbstract=" + projectAbstract + "]";
	}
	public NotifyReviewerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

