package com.techpedia.usermanagement.dataobject;

public class UserRecentComments {
	
	private String projectID;
	private String projectTitle;
	private String projectComment;
	private String projectCommentID;
	/**
	 * @return the projectID
	 */
	public String getProjectID() {
		return projectID;
	}
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(String projectID) {
		this.projectID = projectID;
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
	 * @return the projectComment
	 */
	public String getProjectComment() {
		return projectComment;
	}
	/**
	 * @param projectComment the projectComment to set
	 */
	public void setProjectComment(String projectComment) {
		this.projectComment = projectComment;
	}
	/**
	 * @return the projectCommentID
	 */
	public String getProjectCommentID() {
		return projectCommentID;
	}
	/**
	 * @param projectCommentID the projectCommentID to set
	 */
	public void setProjectCommentID(String projectCommentID) {
		this.projectCommentID = projectCommentID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRecentComments [projectID=" + projectID + ", projectTitle="
				+ projectTitle + ", projectComment=" + projectComment
				+ ", projectCommentID=" + projectCommentID + "]";
	}
	public UserRecentComments() {
		super();
	}
	public UserRecentComments(String projectID, String projectTitle,
			String projectComment, String projectCommentID) {
		super();
		this.projectID = projectID;
		this.projectTitle = projectTitle;
		this.projectComment = projectComment;
		this.projectCommentID = projectCommentID;
	}

	
}
