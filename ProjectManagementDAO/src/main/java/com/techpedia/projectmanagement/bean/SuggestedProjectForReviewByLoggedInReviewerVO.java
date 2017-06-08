/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Date;
import java.util.List;

/**
 * @author charan_teja
 *
 */
public class SuggestedProjectForReviewByLoggedInReviewerVO {
	
	//project info
	private long projId;
	private String projTitle;
	private List<String> projBranchList;
	
	//review info
	private long ratingId;
	private long assignedBy;
	private String assignedByName;
	private long revRgstrId;
	private String reviewerName;
	private Date reviewStartDate;
	private Date reviewEndDate;
	private float revRatingPercentage;
	private String status;
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
	 * @return the projTitle
	 */
	public String getProjTitle() {
		return projTitle;
	}
	/**
	 * @param projTitle the projTitle to set
	 */
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
	/**
	 * @return the projBranchList
	 */
	public List<String> getProjBranchList() {
		return projBranchList;
	}
	/**
	 * @param projBranches the projBranchList to set
	 */
	public void setProjBranchList(List<String> projBranches) {
		this.projBranchList = projBranches;
	}
	/**
	 * @return the ratingId
	 */
	public long getRatingId() {
		return ratingId;
	}
	/**
	 * @param ratingId the ratingId to set
	 */
	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
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
	/**
	 * @return the assignedByName
	 */
	public String getAssignedByName() {
		return assignedByName;
	}
	/**
	 * @param assignedByName the assignedByName to set
	 */
	public void setAssignedByName(String assignedByName) {
		this.assignedByName = assignedByName;
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
	 * @return the reviewerName
	 */
	public String getReviewerName() {
		return reviewerName;
	}
	/**
	 * @param reviewerName the reviewerName to set
	 */
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	/**
	 * @return the reviewStartDate
	 */
	public Date getReviewStartDate() {
		return reviewStartDate;
	}
	/**
	 * @param reviewStartDate the reviewStartDate to set
	 */
	public void setReviewStartDate(Date reviewStartDate) {
		this.reviewStartDate = reviewStartDate;
	}
	/**
	 * @return the reviewEndDate
	 */
	public Date getReviewEndDate() {
		return reviewEndDate;
	}
	/**
	 * @param reviewEndDate the reviewEndDate to set
	 */
	public void setReviewEndDate(Date reviewEndDate) {
		this.reviewEndDate = reviewEndDate;
	}
	/**
	 * @return the revRatingPercentage
	 */
	public float getRevRatingPercentage() {
		return revRatingPercentage;
	}
	/**
	 * @param revRatingPercentage the revRatingPercentage to set
	 */
	public void setRevRatingPercentage(float revRatingPercentage) {
		this.revRatingPercentage = revRatingPercentage;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuggestedProjectForReviewByLoggedInReviewerVO [projId=" + projId + ", projTitle=" + projTitle
				+ ", projBranchList=" + projBranchList + ", ratingId=" + ratingId + ", assignedBy=" + assignedBy
				+ ", assignedByName=" + assignedByName + ", revRgstrId=" + revRgstrId + ", reviewerName=" + reviewerName
				+ ", reviewStartDate=" + reviewStartDate + ", reviewEndDate=" + reviewEndDate + ", revRatingPercentage="
				+ revRatingPercentage + ", status=" + status + "]";
	}
	
	

}
