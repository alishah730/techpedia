/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author 455959
 *
 */
public class FacRejectProjVO {
	
	private long projId;
	private long projGuideId;
	private String approvalStatus;
	private String rejectReason;
	
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
	 * @return the approvalStatus
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}
	/**
	 * @param approvalStatus the approvalStatus to set
	 */
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}
	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
