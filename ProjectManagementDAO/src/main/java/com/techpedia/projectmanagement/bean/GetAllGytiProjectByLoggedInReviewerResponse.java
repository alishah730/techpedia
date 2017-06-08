/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.List;

/**
 * @author 455959
 *
 */
public class GetAllGytiProjectByLoggedInReviewerResponse {
	
	private List<GytiProjectVO> projectsProposedForReview;
	private List<GytiProjectVO> projectsOptionalForReview;
	private List<GytiProjectVO> projectsAlreadyReviewed;
	private List<GytiProjectVO> projectsInProgressForReview;
	private List<GytiProjectVO> projectsAcceptedForReview;
	/**
	 * @return the projectsProposedForReview
	 */
	public List<GytiProjectVO> getProjectsProposedForReview() {
		return projectsProposedForReview;
	}
	/**
	 * @param projectsProposedForReview the projectsProposedForReview to set
	 */
	public void setProjectsProposedForReview(
			List<GytiProjectVO> projectsProposedForReview) {
		this.projectsProposedForReview = projectsProposedForReview;
	}
	/**
	 * @return the projectsOptionalForReview
	 */
	public List<GytiProjectVO> getProjectsOptionalForReview() {
		return projectsOptionalForReview;
	}
	/**
	 * @param projectsOptionalForReview the projectsOptionalForReview to set
	 */
	public void setProjectsOptionalForReview(
			List<GytiProjectVO> projectsOptionalForReview) {
		this.projectsOptionalForReview = projectsOptionalForReview;
	}
	/**
	 * @return the projectsAlreadyReviewed
	 */
	public List<GytiProjectVO> getProjectsAlreadyReviewed() {
		return projectsAlreadyReviewed;
	}
	/**
	 * @param projectsAlreadyReviewed the projectsAlreadyReviewed to set
	 */
	public void setProjectsAlreadyReviewed(
			List<GytiProjectVO> projectsAlreadyReviewed) {
		this.projectsAlreadyReviewed = projectsAlreadyReviewed;
	}
	/**
	 * @return the projectsInProgressForReview
	 */
	public List<GytiProjectVO> getProjectsInProgressForReview() {
		return projectsInProgressForReview;
	}
	/**
	 * @param projectsInProgressForReview the projectsInProgressForReview to set
	 */
	public void setProjectsInProgressForReview(List<GytiProjectVO> projectsInProgressForReview) {
		this.projectsInProgressForReview = projectsInProgressForReview;
	}
	/**
	 * @return the projectsAcceptedForReview
	 */
	public List<GytiProjectVO> getProjectsAcceptedForReview() {
		return projectsAcceptedForReview;
	}
	/**
	 * @param projectsAcceptedForReview the projectsAcceptedForReview to set
	 */
	public void setProjectsAcceptedForReview(List<GytiProjectVO> projectsAcceptedForReview) {
		this.projectsAcceptedForReview = projectsAcceptedForReview;
	}
	

	
	

}
