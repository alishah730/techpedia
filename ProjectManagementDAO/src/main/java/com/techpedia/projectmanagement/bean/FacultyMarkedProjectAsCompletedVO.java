/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author 455959
 *
 */
public class FacultyMarkedProjectAsCompletedVO {
	
	private long projId;
	private long projGuideId;
	private String approvalStatus;
	private String projGrade;
	private String projFacNotes;
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
	 * @return the projGrade
	 */
	public String getProjGrade() {
		return projGrade;
	}
	/**
	 * @param projGrade the projGrade to set
	 */
	public void setProjGrade(String projGrade) {
		this.projGrade = projGrade;
	}
	/**
	 * @return the projFacNotes
	 */
	public String getProjFacNotes() {
		return projFacNotes;
	}
	/**
	 * @param projFacNotes the projFacNotes to set
	 */
	public void setProjFacNotes(String projFacNotes) {
		this.projFacNotes = projFacNotes;
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
