package com.techpedia.projectmanagement.bean;

public class DeleteChallDocVO {
	
	private long regstrId;
	private long challengeId;
	private String docName;
	private String docLink;
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
	 * @return the docName
	 */
	public String getDocName() {
		return docName;
	}
	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	/**
	 * @return the docLink
	 */
	public String getDocLink() {
		return docLink;
	}
	/**
	 * @param docLink the docLink to set
	 */
	public void setDocLink(String docLink) {
		this.docLink = docLink;
	}
	

}
