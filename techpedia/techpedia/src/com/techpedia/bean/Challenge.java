package com.techpedia.bean;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Challenge {
	String challengeID;
	int challengTypeId;
	String challengTitle;
	String challengBranch1;
	String challengBranch2;
	String challengKeywords;
	String challengAbstract;
	String challengDescription; // Nullable-shall be used during bulk upload.
								// Mandatory for bulk uplaod and academic
								// challenge
	String challengUniversity; // Nullable-shall be used during bulk upload.
								// Mandatory for bulk uplaod and academic
								// challenge
	String challengCollege; // Nullable
	String rgstrId; // Nullable-Mandatory for academic challenge
	byte[] challengeDocuments;
	int challengYear;
	int challengeDuration; // in months
	String challengeCollegeState;
	Date challengStartDate;
	Date challengEndDate;
	
	Date challengCloseDate;
	String challengeMentor1ID; // Nullable-Mandatory for academic challenge
	String challengeMentor2ID; // Nullable-Mandatory for academic challenge
	String challengeTeamID;
	String challengeGuideID; // Nullable-Mandatory for academic challenge
	String challengeStatus; // I.E. Un-initiated, Close, Review, Completed, etc
	String challengeToFloat; // 'Y' or 'N' I.E. searchable challenge or not\
	long challengeEstimatedCost; // Nullable
	String challengCommentsPublish; // Display comments or not , default 'N'
	String challengeBusinessPlan; // Nullable
	String challengeImage; // Nullable, default image if null.
	String challengImpact;
	String challengSourceFund;
	String challengIsIncentiv;
	String challengDelivExpctatn;
	String challengBenchmark;

	@JsonIgnore
	public String getChallengeID() {
		return challengeID;
	}

	public void setChallengeID(String challengeID) {
		this.challengeID = challengeID;
	}

	public int getChallengTypeId() {
		return challengTypeId;
	}

	public void setChallengTypeId(int challengTypeId) {
		this.challengTypeId = challengTypeId;
	}

	public String getChallengTitle() {
		return challengTitle;
	}

	public void setChallengTitle(String challengeTitle) {
		this.challengTitle = challengeTitle;
	}

	@JsonIgnore
	public String getChallengeBranch1() {
		return challengBranch1;
	}

	public void setChallengeBranch1(String challengeBranch1) {
		this.challengBranch1 = challengeBranch1;
	}

	@JsonIgnore
	public String getChallengeBranch2() {
		return challengBranch2;
	}

	public void setChallengeBranch2(String challengeBranch2) {
		this.challengBranch2 = challengeBranch2;
	}

	@JsonIgnore
	public String getChallengeKeywords() {
		return challengKeywords;
	}

	public void setChallengeKeywords(String challengeKeywords) {
		this.challengKeywords = challengeKeywords;
	}

	public String getChallengAbstract() {
		return challengAbstract;
	}

	public void setChallengAbstract(String challengAbstract){
		
		this.challengAbstract = challengAbstract;
	}

	public String getChallengDescription() {
		return challengDescription;
	}
    public void setChallengDescription(String challengDescription)
    {
    	this.challengDescription = challengDescription;
    }
	
	@JsonIgnore
	public String getChallengeUniversity() {
		return challengUniversity;
	}

	public void setChallengeUniversity(String challengeUniversity) {
		this.challengUniversity = challengeUniversity;
	}

	@JsonIgnore
	public String getChallengeCollege() {
		return challengCollege;
	}

	public void setChallengeCollege(String challengeCollege) {
		this.challengCollege = challengeCollege;
	}

	public String getRgstrId() {
		return rgstrId;
	}

	public void setRgstrId(String userRegisterationNumber) {
		this.rgstrId = userRegisterationNumber;
	}

	@JsonIgnore
	public byte[] getChallengeDocuments() {
		return challengeDocuments;
	}

	public void setChallengeDocuments(byte[] challengeDocuments) {
		this.challengeDocuments = challengeDocuments;
	}

	public int getChallengYear() {
		return challengYear;
	}

	public void setChallengYear(int challengeYear) {
		this.challengYear = challengeYear;
	}

	@JsonIgnore
	public int getChallengeDuration() {
		return challengeDuration;
	}

	public void setChallengeDuration(int challengeDuration) {
		this.challengeDuration = challengeDuration;
	}

	@JsonIgnore
	public String getChallengeCollegeState() {
		return challengeCollegeState;
	}

	public void setChallengeCollegeState(String challengeCollegeState) {
		this.challengeCollegeState = challengeCollegeState;
	}

	public Date getChallengStartDate() {
		return challengStartDate;
	}

	public void setChallengStartDate(Date challengeStartDate) {
		this.challengStartDate = challengeStartDate;
	}

	public Date getChallengCloseDate() {
		return challengCloseDate;
	}

	public void setChallengCloseDate(Date challengeEndDate) {
		this.challengCloseDate = challengeEndDate;
	}

	@JsonIgnore
	public String getChallengeMentor1ID() {
		return challengeMentor1ID;
	}

	public void setChallengeMentor1ID(String challengeMentor1ID) {
		this.challengeMentor1ID = challengeMentor1ID;
	}

	@JsonIgnore
	public String getChallengeMentor2ID() {
		return challengeMentor2ID;
	}

	public void setChallengeMentor2ID(String challengeMentor2ID) {
		this.challengeMentor2ID = challengeMentor2ID;
	}

	@JsonIgnore
	public String getChallengeTeamID() {
		return challengeTeamID;
	}

	public void setChallengeTeamID(String challengeTeamID) {
		this.challengeTeamID = challengeTeamID;
	}

	@JsonIgnore
	public String getChallengeGuideID() {
		return challengeGuideID;
	}

	public void setChallengeGuideID(String challengeGuideID) {
		this.challengeGuideID = challengeGuideID;
	}

	@JsonIgnore
	public String getChallengeStatus() {
		return challengeStatus;
	}

	public void setChallengeStatus(String challengeStatus) {
		this.challengeStatus = challengeStatus;
	}

	@JsonIgnore
	public String getChallengeToFloat() {
		return challengeToFloat;
	}

	public void setChallengeToFloat(String challengeToFloat) {
		this.challengeToFloat = challengeToFloat;
	}

	@JsonIgnore
	public long getChallengeEstimatedCost() {
		return challengeEstimatedCost;
	}

	public void setChallengeEstimatedCost(long challengeEstimatedCost) {
		this.challengeEstimatedCost = challengeEstimatedCost;
	}

	public String getChallengCommentsPublish() {
		return challengCommentsPublish;
	}

	public void setChallengCommentsPublish(String challengCommentsPublish) {
		this.challengCommentsPublish = challengCommentsPublish;
	}

	@JsonIgnore
	public String getChallengeBusinessPlan() {
		return challengeBusinessPlan;
	}

	public void setChallengeBusinessPlan(String challengeBusinessPlan) {
		this.challengeBusinessPlan = challengeBusinessPlan;
	}

	@JsonIgnore
	public String getChallengeImage() {
		return challengeImage;
	}

	public String getChallengImpact() {
		return challengImpact;
	}

	public void setChallengImpact(String challengImpact) {
		this.challengImpact = challengImpact;
	}

	public String getChallengSourceFund() {
		return challengSourceFund;
	}

	public void setChallengSourceFund(String challengSourceFund) {
		this.challengSourceFund = challengSourceFund;
	}

	public String getChallengIsIncentiv() {
		return challengIsIncentiv;
	}

	public void setChallengIsIncentiv(String challengIsIncentiv) {
		this.challengIsIncentiv = challengIsIncentiv;
	}

	public String getChallengDelivExpctatn() {
		return challengDelivExpctatn;
	}

	public void setChallengDelivExpctatn(String challengDelivExpctatn) {
		this.challengDelivExpctatn = challengDelivExpctatn;
	}

	public String getChallengBenchmark() {
		return challengBenchmark;
	}

	public void setChallengBenchmark(String challengBenchmark) {
		this.challengBenchmark = challengBenchmark;
	}

	public void setChallengeImage(String challengeImage) {
		this.challengeImage = challengeImage;
	}
	

	

}
