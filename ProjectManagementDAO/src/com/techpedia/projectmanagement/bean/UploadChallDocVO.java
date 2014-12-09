package com.techpedia.projectmanagement.bean;

public class UploadChallDocVO {
	
	private long rgstrId;
	private long challengeId;
	private String docName;
	private String docByteArray;
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
	 * @return the docByteArray
	 */
	public String getDocByteArray() {
		return docByteArray;
	}
	/**
	 * @param docByteArray the docByteArray to set
	 */
	public void setDocByteArray(String docByteArray) {
		this.docByteArray = docByteArray;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UploadChallDocVO [rgstrId=" + rgstrId + ", challengeId="
				+ challengeId + ", docName=" + docName + ", docByteArray="
				+ docByteArray + "]";
	}

}
