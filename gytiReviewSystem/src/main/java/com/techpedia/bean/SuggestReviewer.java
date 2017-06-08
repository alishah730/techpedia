package com.techpedia.bean;

public class SuggestReviewer {

	private long projId;
	private long revRgstrId;
	private long assignedBy;
	
	public long getProjId() {
		return projId;
	}
	
	public void setProjId(long projId) {
		this.projId = projId;
	}
	
	public long getRevRgstrId() {
		return revRgstrId;
	}
	
	public void setRevRgstrId(long revRgstrId) {
		this.revRgstrId = revRgstrId;
	}
	
	public long getAssignedBy() {
		return assignedBy;
	}
	
	public void setAssignedBy(long assignedBy) {
		this.assignedBy = assignedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuggestReviewer [projId=" + projId + ", revRgstrId=" + revRgstrId + ", assignedBy=" + assignedBy + "]";
	}

	/**
	 * @param projId
	 * @param revRgstrId
	 * @param assignedBy
	 */
	public SuggestReviewer(long projId, long revRgstrId, long assignedBy) {
		super();
		this.projId = projId;
		this.revRgstrId = revRgstrId;
		this.assignedBy = assignedBy;
	}
	


	
}

