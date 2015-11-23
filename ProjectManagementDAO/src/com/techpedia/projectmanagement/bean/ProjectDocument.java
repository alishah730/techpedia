package com.techpedia.projectmanagement.bean;



public class ProjectDocument {
	
	private String docName;
	private String docLink;
	private long regstrId;
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
	
	public long getRegstrId() {
		return regstrId;
	}
	public void setRegstrId(long regstrId) {
		this.regstrId = regstrId;
	}
	@Override
	public String toString() {
		return "ProjectDocument [docName=" + docName + ", docLink=" + docLink
				+ ", regstrId=" + regstrId + "]";
	}
	
}
