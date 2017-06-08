package com.techpedia.projectmanagement.bean;

public class DeleteChallengeCommVO {

	private long challengeId;
	private long commentId;
	private long rgstrId;
	/**
	 * @return the projectId
	 */
	public long getChallengeId() {
		return challengeId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setChallengeId(long challengeId) {
		this.challengeId = challengeId;
	}
	/**
	 * @return the commentId
	 */
	public long getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
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
	
}
