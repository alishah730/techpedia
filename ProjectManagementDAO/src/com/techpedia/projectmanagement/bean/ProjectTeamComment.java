package com.techpedia.projectmanagement.bean;


public class ProjectTeamComment {
	
	private long commentId;
	private String projComment;
	private long projId;
	private long regstrId;
	private long projTeamLeaderId;
	private String fName;
	private String mName;
	private String lName;
	private long projGuideId;
	private long projMentor1Id;
	private long projMentor2Id;
	
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
	 * @return the projComment
	 */
	public String getProjComment() {
		return projComment;
	}
	/**
	 * @param projComment the projComment to set
	 */
	public void setProjComment(String projComment) {
		this.projComment = projComment;
	}
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
	 * @return the projTeamLeaderId
	 */
	public long getProjTeamLeaderId() {
		return projTeamLeaderId;
	}
	/**
	 * @param projTeamLeaderId the projTeamLeaderId to set
	 */
	public void setProjTeamLeaderId(long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}
	/**
	 * @return the projGuideId
	 */
	public long getProjGuideId() {
		return projGuideId;
	}
	/**
	 * @param projGuideId the projGuideId to set
	 */
	public void setProjGuideId(long projGuideId) {
		this.projGuideId = projGuideId;
	}
	/**
	 * @return the projMentor1Id
	 */
	public long getProjMentor1Id() {
		return projMentor1Id;
	}
	/**
	 * @param projMentor1Id the projMentor1Id to set
	 */
	public void setProjMentor1Id(long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}
	/**
	 * @return the projMentor2Id
	 */
	public long getProjMentor2Id() {
		return projMentor2Id;
	}
	/**
	 * @param projMentor2Id the projMentor2Id to set
	 */
	public void setProjMentor2Id(long projMentor2Id) {
		this.projMentor2Id = projMentor2Id;
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
		return "ProjectTeamComment [commentId=" + commentId + ", projComment="
				+ projComment + ", projId=" + projId + ", regstrId=" + regstrId
				+ ", projTeamLeaderId=" + projTeamLeaderId + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + ", projGuideId="
				+ projGuideId + ", projMentor1Id=" + projMentor1Id
				+ ", projMentor2Id=" + projMentor2Id + "]";
	}
	
	
	
}
