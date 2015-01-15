package com.techpedia.projectmanagement.bean;



public class ProjectDocument {
	
	private String docName;
	private String docLink;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectDocPathTxn [docName=" + docName + ", docLink=" + docLink
				+ "]";
	}
	
}
