package com.techpedia.projectmanagement.bean;

public class UploadProjDocVO {

	private long rgstrId;
	private long projId;
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
		return "uploadProjDocVO [rgstrId=" + rgstrId + ", projId=" + projId
				+ ", docName=" + docName + ", docByteArray=" + docByteArray
				+ "]";
	}
}
