/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.List;

/**
 * @author 455959
 *
 */
public class GetAllReviewsByLoggedInReviewerAndOthersResponse {
	
	private List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByLoggedInReviewer;
	private List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByOtherReviewers;
	/**
	 * @return the overallCalculatedReviewRatingsByLoggedInReviewer
	 */
	public List<OverallCalculatedReviewRatingVO> getOverallCalculatedReviewRatingsByLoggedInReviewer() {
		return overallCalculatedReviewRatingsByLoggedInReviewer;
	}
	/**
	 * @param overallCalculatedReviewRatingsByLoggedInReviewer the overallCalculatedReviewRatingsByLoggedInReviewer to set
	 */
	public void setOverallCalculatedReviewRatingsByLoggedInReviewer(
			List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByLoggedInReviewer) {
		this.overallCalculatedReviewRatingsByLoggedInReviewer = overallCalculatedReviewRatingsByLoggedInReviewer;
	}
	/**
	 * @return the overallCalculatedReviewRatingsByOtherReviewers
	 */
	public List<OverallCalculatedReviewRatingVO> getOverallCalculatedReviewRatingsByOtherReviewers() {
		return overallCalculatedReviewRatingsByOtherReviewers;
	}
	/**
	 * @param overallCalculatedReviewRatingsByOtherReviewers the overallCalculatedReviewRatingsByOtherReviewers to set
	 */
	public void setOverallCalculatedReviewRatingsByOtherReviewers(
			List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByOtherReviewers) {
		this.overallCalculatedReviewRatingsByOtherReviewers = overallCalculatedReviewRatingsByOtherReviewers;
	}
	
	

}
