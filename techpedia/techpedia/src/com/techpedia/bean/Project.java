package com.techpedia.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Project {

	private String challengId;

	public String getChallengId() {
		return challengId;
	}

	public void setChallengId(String challengId) {
		this.challengId = challengId;
	}

	public String projIsForChallenge;

	@JsonIgnore
	public String getProjIsForChallenge() {
		return projIsForChallenge;
	}

	public void setProjIsForChallenge(String projIsForChallenge) {
		this.projIsForChallenge = projIsForChallenge;
	}

	private String projBranchList;
	private String projTeamMemberList;
	private String projFacultyName;

	@JsonIgnore
	public String getProjFacultyName() {
		return projFacultyName;
	}

	public void setProjFacultyName(String projFacultyName) {
		this.projFacultyName = projFacultyName;
	}

	@JsonIgnore
	public String getProjTeamMemberList() {
		return projTeamMemberList;
	}

	public void setProjTeamMemberList(String projTeamMemberList) {
		this.projTeamMemberList = projTeamMemberList;
	}

	@JsonIgnore
	public String getProjBranchList() {
		return projBranchList;
	}

	public void setProjBranchList(String projBranchList) {
		this.projBranchList = projBranchList;
	}

	private long projId;
	private int projTypeId;
	private String projTitle;
	private ArrayList<Integer> projBranches;
	private ArrayList<String> projKeywords;
	private ArrayList<Long> projTeamMembers;
	private String projBranchesString;
	private String projKeywordsString;
	private String projTeamMembersString;
	private long projTeamId;
	private String projTeamDesc;
	private Date projStartDate;
	private Date projEndDate;
	private int projYear;
	private int projDuration;
	private String projAbstract;
	private String projDescription;
	private String projUniversity;
	private String projCollege;
	private String projCollegeState;
	private String projStudentId;
	private String projFaculty;
	private long projEstimationCost;
	private String projImage;
	// Nothing after this in add project UI
	private String projCollegeRgstrIdUsr;
	private String userRgstrNo;
	private long projMentor1Id;
	private long projMentor2Id;
	private long projGuideId;
	private int projStatusId;
	private String projToFloat;
	private String projCommentsPublish;
	private String projGrade;
	private long projTeamLeaderId;
	private String projAwardWon;
	private String projAwardDesc;
	private String projIsMentorAvail;
	private String projIsFacApprove;
	private String projAdminComments;

	public String getProjAbstract() {
		return this.projAbstract;
	}

	@JsonIgnore
	public String getProjAdminComments() {
		return this.projAdminComments;
	}

	@JsonIgnore
	public String getProjAwardDesc() {
		return this.projAwardDesc;
	}

	@JsonIgnore
	public String getProjAwardWon() {
		return this.projAwardWon;
	}

	public ArrayList<Integer> getProjBranches() {
		return projBranches;
	}

	// FIX--------------------------------JSON IGNORE
	@JsonIgnore
	public String getProjBranchesString() {
		return projBranchesString;
	}

	public String getProjCollege() {
		return this.projCollege;
	}

	@JsonIgnore
	public String getProjCollegeRgstrIdUsr() {
		return this.projCollegeRgstrIdUsr;
	}

	public String getProjCollegeState() {
		return this.projCollegeState;
	}

	@JsonIgnore
	public String getProjCommentsPublish() {
		return this.projCommentsPublish;
	}

	public String getProjDescription() {
		return this.projDescription;
	}

	public int getProjDuration() {
		return this.projDuration;
	}

	public Date getProjEndDate() {
		return this.projEndDate;
	}

	public long getProjEstimationCost() {
		return this.projEstimationCost;
	}

	public String getProjFaculty() {
		return this.projFaculty;
	}

	@JsonIgnore
	public String getProjGrade() {
		return this.projGrade;
	}

	@JsonIgnore
	public long getProjGuideId() {
		return this.projGuideId;
	}

	public long getProjId() {
		return projId;
	}

	public String getProjImage() {
		return this.projImage;
	}

	@JsonIgnore
	public String getProjIsFacApprove() {
		return this.projIsFacApprove;
	}

	@JsonIgnore
	public String getProjIsMentorAvail() {
		return this.projIsMentorAvail;
	}

	public ArrayList<String> getProjKeywords() {
		return projKeywords;
	}

	@JsonIgnore
	public String getProjKeywordsString() {
		return projKeywordsString;
	}

	@JsonIgnore
	public long getProjMentor1Id() {
		return this.projMentor1Id;
	}

	@JsonIgnore
	public long getProjMentor2Id() {
		return this.projMentor2Id;
	}

	public Date getProjStartDate() {
		return this.projStartDate;
	}

	@JsonIgnore
	public int getProjStatusId() {
		return this.projStatusId;
	}

	public String getProjStudentId() {
		return this.projStudentId;
	}

	public String getProjTeamDesc() {
		return this.projTeamDesc;
	}

	@JsonIgnore
	public long getProjTeamId() {
		return this.projTeamId;
	}

	@JsonIgnore
	public long getProjTeamLeaderId() {
		return this.projTeamLeaderId;
	}

	public ArrayList<Long> getProjTeamMembers() {
		return projTeamMembers;
	}

	@JsonIgnore
	public String getProjTeamMembersString() {
		return projTeamMembersString;
	}

	public String getProjTitle() {
		return this.projTitle;
	}

	@JsonIgnore
	public String getProjToFloat() {
		return this.projToFloat;
	}

	public int getProjTypeId() {
		return projTypeId;
	}

	public String getProjUniversity() {
		return this.projUniversity;
	}

	public int getProjYear() {
		return this.projYear;
	}

	@JsonIgnore
	public String getUserRgstrNo() {
		return this.userRgstrNo;
	}

	public void setProjAbstract(String projAbstract) {
		this.projAbstract = projAbstract;
	}

	public void setProjAdminComments(String projAdminComments) {
		this.projAdminComments = projAdminComments;
	}

	public void setProjAwardDesc(String projAwardDesc) {
		this.projAwardDesc = projAwardDesc;
	}

	public void setProjAwardWon(String projAwardWon) {
		this.projAwardWon = projAwardWon;
	}

	public void setProjBranches(ArrayList<Integer> projBranches) {
		this.projBranches = projBranches;
	}

	public void setProjBranchesString(String projBranchesString) {
		this.projBranchesString = projBranchesString;

	}

	public void setProjCollege(String projCollege) {
		this.projCollege = projCollege;
	}

	public void setProjCollegeRgstrIdUsr(String projCollegeRgstrIdUsr) {
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
	}

	public void setProjCollegeState(String projCollegeState) {
		this.projCollegeState = projCollegeState;
	}

	public void setProjCommentsPublish(String projCommentsPublish) {
		this.projCommentsPublish = projCommentsPublish;
	}

	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}

	public void setProjDuration(int projDuration) {
		this.projDuration = projDuration;
	}

	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}

	public void setProjEstimationCost(long projEstimationCost) {
		this.projEstimationCost = projEstimationCost;
	}

	public void setProjFaculty(String projFaculty) {
		this.projFaculty = projFaculty;
	}

	public void setProjGrade(String projGrade) {
		this.projGrade = projGrade;
	}

	public void setProjGuideId(long projGuideId) {
		this.projGuideId = projGuideId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}

	public void setProjImage(String projImage) {
		this.projImage = projImage;
	}

	public void setProjIsFacApprove(String projIsFacApprove) {
		this.projIsFacApprove = projIsFacApprove;
	}

	public void setProjIsMentorAvail(String projIsMentorAvail) {
		this.projIsMentorAvail = projIsMentorAvail;
	}

	public void setProjKeywords(ArrayList<String> projKeywords) {
		this.projKeywords = projKeywords;
	}

	public void setProjKeywordsString(String projKeywordsString) {
		this.projKeywordsString = projKeywordsString;

	}

	public void setProjMentor1Id(long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}

	public void setProjMentor2Id(long projMentor2Id) {
		this.projMentor2Id = projMentor2Id;
	}

	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	public void setProjStatusId(int projStatusId) {
		this.projStatusId = projStatusId;
	}

	public void setProjStudentId(String projStudentId) {
		this.projStudentId = projStudentId;
	}

	public void setProjTeamDesc(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}

	public void setProjTeamId(long projTeamId) {
		this.projTeamId = projTeamId;
	}

	public void setProjTeamLeaderId(long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}

	public void setProjTeamMembers(ArrayList<Long> projTeamMembers) {
		this.projTeamMembers = projTeamMembers;
	}

	public void setProjTeamMembersString(String projTeamMembersString) {
		this.projTeamMembersString = projTeamMembersString;

	}

	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}

	public void setProjToFloat(String projToFloat) {
		this.projToFloat = projToFloat;
	}

	public void setProjTypeId(int projTypeId) {
		this.projTypeId = projTypeId;
	}

	public void setProjUniversity(String projUniversity) {
		this.projUniversity = projUniversity;
	}

	public void setProjYear(int projYear) {
		this.projYear = projYear;
	}

	public void setUserRgstrNo(String userRgstrNo) {
		this.userRgstrNo = userRgstrNo;
	}

	public String toString() {
		return "Project [projTypeId=" + this.projTypeId + ", projTitle=" + this.projTitle + ", projBranches=" + this.projBranches + ", projKeywords=" + this.projKeywords + ", projTeamMembers=" + this.projTeamMembers + ", projTeamId=" + this.projTeamId + ", projTeamDesc=" + this.projTeamDesc + ", projStartDate=" + this.projStartDate + ", projEndDate=" + this.projEndDate + ", projYear=" + this.projYear + ", projDuration=" + this.projDuration + ", projAbstract=" + this.projAbstract + ", projDescription=" + this.projDescription + ", projUniversity=" + this.projUniversity + ", projCollege=" + this.projCollege + ", projCollegeState=" + this.projCollegeState + ", projStudentId=" + this.projStudentId + ", projFaculty=" + this.projFaculty + ", projEstimationCost=" + this.projEstimationCost + ", projImage=" + this.projImage + ", projCollegeRgstrIdUsr=" + this.projCollegeRgstrIdUsr + ", userRgstrNo=" + this.userRgstrNo + ", projMentor1Id=" + this.projMentor1Id + ", projMentor2Id=" + this.projMentor2Id + ", projGuideId=" + this.projGuideId + ", projStatusId=" + this.projStatusId + ", projToFloat=" + this.projToFloat + ", projCommentsPublish=" + this.projCommentsPublish + ", projGrade=" + this.projGrade + ", projTeamLeaderId=" + this.projTeamLeaderId + ", projAwardWon=" + this.projAwardWon + ", projAwardDesc=" + this.projAwardDesc + ", projIsMentorAvail=" + this.projIsMentorAvail + ", projIsFacApprove=" + this.projIsFacApprove + ", projAdminComments=" + this.projAdminComments + "]";
	}
}