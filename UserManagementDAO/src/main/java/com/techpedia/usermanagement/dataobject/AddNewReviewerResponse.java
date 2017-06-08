/**
 * 
 */
package com.techpedia.usermanagement.dataobject;


/**
 * @author 455959
 *
 */
public class AddNewReviewerResponse {
	
	private String status;
	private ReviewerDO reviewerDO;
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
	/**
	 * @return the reviewerDO
	 */
	public ReviewerDO getReviewerDO() {
		return reviewerDO;
	}
	/**
	 * @param reviewerDO the reviewerDO to set
	 */
	public void setReviewerDO(ReviewerDO reviewerDO) {
		this.reviewerDO = reviewerDO;
	}
	

}
