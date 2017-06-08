/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author 455959
 *
 */
public class OverallCalculatedReviewRatingVO {
	
	/**
	 * 
	 */
	private long participantId; //projId As of Now
	private Date reviewedDate;
	private String projTitle;
	private String projAbstract;
	private List<String> projCategory;
	private Set<AssignedByAndReviewDoneByMapper> assignedByAndReviewDoneByMapperSet;
	private String totalAssignedReviewer;
	private String reviewStatus;
	private String averageRating;
	private String averageNoveltyRating;
	private String averageTechnicalRigorRating;
	private String averageFrugalityRating;
	private String averageSocialApplicationRating;
	/**
	 * @return the participantId
	 */
	public long getParticipantId() {
		return participantId;
	}
	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}
	/**
	 * @return the reviewedDate
	 */
	public Date getReviewedDate() {
		return reviewedDate;
	}
	/**
	 * @param reviewedDate the reviewedDate to set
	 */
	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
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
	 * @return the projAbstract
	 */
	public String getProjAbstract() {
		return projAbstract;
	}
	/**
	 * @param projAbstract the projAbstract to set
	 */
	public void setProjAbstract(String projAbstract) {
		this.projAbstract = projAbstract;
	}
	/**
	 * @return the projCategory
	 */
	public List<String> getProjCategory() {
		return projCategory;
	}
	/**
	 * @param projCategory the projCategory to set
	 */
	public void setProjCategory(List<String> projCategory) {
		this.projCategory = projCategory;
	}
	/**
	 * @return the assignedByAndReviewDoneByMapperSet
	 */
	public Set<AssignedByAndReviewDoneByMapper> getAssignedByAndReviewDoneByMapperSet() {
		return assignedByAndReviewDoneByMapperSet;
	}
	/**
	 * @param assignedByAndReviewDoneByMapperSet the assignedByAndReviewDoneByMapperSet to set
	 */
	public void setAssignedByAndReviewDoneByMapperSet(
			Set<AssignedByAndReviewDoneByMapper> assignedByAndReviewDoneByMapperSet) {
		this.assignedByAndReviewDoneByMapperSet = assignedByAndReviewDoneByMapperSet;
	}
	/**
	 * @return the totalAssignedReviewer
	 */
	public String getTotalAssignedReviewer() {
		return totalAssignedReviewer;
	}
	/**
	 * @param totalAssignedReviewer the totalAssignedReviewer to set
	 */
	public void setTotalAssignedReviewer(String totalAssignedReviewer) {
		this.totalAssignedReviewer = totalAssignedReviewer;
	}
	/**
	 * @return the reviewStatus
	 */
	public String getReviewStatus() {
		return reviewStatus;
	}
	/**
	 * @param reviewStatus the reviewStatus to set
	 */
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	/**
	 * @return the averageRating
	 */
	public String getAverageRating() {
		return averageRating;
	}
	/**
	 * @param averageRating the averageRating to set
	 */
	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}
	/**
	 * @return the averageNoveltyRating
	 */
	public String getAverageNoveltyRating() {
		return averageNoveltyRating;
	}
	/**
	 * @param averageNoveltyRating the averageNoveltyRating to set
	 */
	public void setAverageNoveltyRating(String averageNoveltyRating) {
		this.averageNoveltyRating = averageNoveltyRating;
	}
	/**
	 * @return the averageTechnicalRigorRating
	 */
	public String getAverageTechnicalRigorRating() {
		return averageTechnicalRigorRating;
	}
	/**
	 * @param averageTechnicalRigorRating the averageTechnicalRigorRating to set
	 */
	public void setAverageTechnicalRigorRating(String averageTechnicalRigorRating) {
		this.averageTechnicalRigorRating = averageTechnicalRigorRating;
	}
	/**
	 * @return the averageFrugalityRating
	 */
	public String getAverageFrugalityRating() {
		return averageFrugalityRating;
	}
	/**
	 * @param averageFrugalityRating the averageFrugalityRating to set
	 */
	public void setAverageFrugalityRating(String averageFrugalityRating) {
		this.averageFrugalityRating = averageFrugalityRating;
	}
	/**
	 * @return the averageSocialApplicationRating
	 */
	public String getAverageSocialApplicationRating() {
		return averageSocialApplicationRating;
	}
	/**
	 * @param averageSocialApplicationRating the averageSocialApplicationRating to set
	 */
	public void setAverageSocialApplicationRating(
			String averageSocialApplicationRating) {
		this.averageSocialApplicationRating = averageSocialApplicationRating;
	}
	
	
}
