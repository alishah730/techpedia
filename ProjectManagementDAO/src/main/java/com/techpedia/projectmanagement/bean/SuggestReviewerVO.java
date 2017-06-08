/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author charan_teja
 *
 */
public class SuggestReviewerVO {

	private long projId;
	private long revRgstrId;
	private long assignedBy;
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
	 * @return the revRgstrId
	 */
	public long getRevRgstrId() {
		return revRgstrId;
	}
	/**
	 * @param revRgstrId the revRgstrId to set
	 */
	public void setRevRgstrId(long revRgstrId) {
		this.revRgstrId = revRgstrId;
	}
	/**
	 * @return the assignedBy
	 */
	public long getAssignedBy() {
		return assignedBy;
	}
	/**
	 * @param assignedBy the assignedBy to set
	 */
	public void setAssignedBy(long assignedBy) {
		this.assignedBy = assignedBy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuggestReviewerVO [projId=" + projId + ", revRgstrId=" + revRgstrId + ", assignedBy=" + assignedBy
				+ "]";
	}

	
}
