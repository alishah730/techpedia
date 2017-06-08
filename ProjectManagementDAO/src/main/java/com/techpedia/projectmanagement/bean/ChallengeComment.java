package com.techpedia.projectmanagement.bean;


public class ChallengeComment {
	
	private long commentId;
	private String challengeComment;
	private long challengeId;
	private long regstrId;
	private long challengUserId;
	private String fName;
	private String mName;
	private String lName;

	
	
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
	 * @return the challengeComment
	 */
	public String getChallengeComment() {
		return challengeComment;
	}



	/**
	 * @param challengeComment the challengeComment to set
	 */
	public void setChallengeComment(String challengeComment) {
		this.challengeComment = challengeComment;
	}



	/**
	 * @return the challengeId
	 */
	public long getChallengeId() {
		return challengeId;
	}



	/**
	 * @param challengeId the challengeId to set
	 */
	public void setChallengeId(long challengeId) {
		this.challengeId = challengeId;
	}



	/**
	 * @return the regstrId
	 */
	public long getRegstrId() {
		return regstrId;
	}



	/**
	 * @param regstrId the regstrId to set
	 */
	public void setRegstrId(long regstrId) {
		this.regstrId = regstrId;
	}



	/**
	 * @return the challengUserId
	 */
	public long getChallengUserId() {
		return challengUserId;
	}



	/**
	 * @param challengUserId the challengUserId to set
	 */
	public void setChallengUserId(long challengUserId) {
		this.challengUserId = challengUserId;
	}



	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}



	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}



	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}



	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}



	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}



	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectTeamComment [commentId=" + commentId + ", challengeComment="
				+ challengeComment + ", challengeId=" + challengeId + ", regstrId=" + regstrId
				+ ", challengUserId=" + challengUserId + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + "]";
	}
	
	
	
}
