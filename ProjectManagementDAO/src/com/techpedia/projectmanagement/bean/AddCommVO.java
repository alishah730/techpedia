package com.techpedia.projectmanagement.bean;

public class AddCommVO {
	
	private long projId;
	private long regstrId;
	private String projComment;
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
	
}
