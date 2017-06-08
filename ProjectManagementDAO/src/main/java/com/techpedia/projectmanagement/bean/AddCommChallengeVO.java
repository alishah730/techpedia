package com.techpedia.projectmanagement.bean;

public class AddCommChallengeVO {
	
	private long challengeId;
	private long regstrId;
	private String challengeComment;

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
	 * @return the projComment
	 */
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

}
