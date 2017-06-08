/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.ArrayList;

/**
 * @author charan_teja
 *
 */
public class GytiProjectVO {

	private long projId;
	private int projTypeId;
	private String projTitle;
	private ArrayList<Integer> projBranches;
	private ArrayList<String> projKeywords;
	private ArrayList<Long> projTeamMembers;
	private ArrayList<Branch> projBranchList;
	private ArrayList<Team> projTeamMemberList;
	private long projTeamId;
	private String projTeamDesc;
	private String projStartDate;
	private String projEndDate;
	private int projYear;
	private int projDuration;
	private String projAbstract;
	private String projDescription;
	private String projUniversity;
	private String projCollege;
	private String projCollegeState;
	private String projStudentId;
	private long projFaculty;
	private String projFacultyName;
	private long projFacRgstrId;
	private int projStatusId;
	
	private long projEstimationCost;
	private String imgName;
	private String imgByteArray;
	private String footerImgName;
	private String footerImgByteArray;
	private String photo1Path;
	private String photo2Path;


	private long projMentor1Id;
	private long projMentor2Id;
	private long projGuideId;
	private String projToFloat;
	private String projCommentsPublish;
	private String projGrade;
	private long projTeamLeaderId;
	
	private String projAppliedAwards;
	private String projGuideName;
	private String projGuideEmail;
	private String projGuideMobile;
	private String projAcademicProgram;
	private String projStatusInfo;
	private String projCopyrightInfo;
	private String projProofInfo;
	private String otherDistinguishablePatents;
	private String projFeature;
	private String projFrugalityInfo;
	private String projObjectiveInfo;
	private String projContributeInfo;
	private String projImpactInfo;
	private String projRequiredResource;
	private String projResearchContinue;
	private String projPatentWork;
	private String projPublishedPaper;
	private String projOtherInfo;
	private String projBenefitInfo;
	private String projAwardYear;
	private String teamLeaderName;
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
	 * @return the projTypeId
	 */
	public int getProjTypeId() {
		return projTypeId;
	}
	/**
	 * @param projTypeId the projTypeId to set
	 */
	public void setProjTypeId(int projTypeId) {
		this.projTypeId = projTypeId;
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
	 * @return the projBranches
	 */
	public ArrayList<Integer> getProjBranches() {
		return projBranches;
	}
	/**
	 * @param projBranches the projBranches to set
	 */
	public void setProjBranches(ArrayList<Integer> projBranches) {
		this.projBranches = projBranches;
	}
	/**
	 * @return the projKeywords
	 */
	public ArrayList<String> getProjKeywords() {
		return projKeywords;
	}
	/**
	 * @param projKeywords the projKeywords to set
	 */
	public void setProjKeywords(ArrayList<String> projKeywords) {
		this.projKeywords = projKeywords;
	}
	/**
	 * @return the projTeamMembers
	 */
	public ArrayList<Long> getProjTeamMembers() {
		return projTeamMembers;
	}
	/**
	 * @param projTeamMembers the projTeamMembers to set
	 */
	public void setProjTeamMembers(ArrayList<Long> projTeamMembers) {
		this.projTeamMembers = projTeamMembers;
	}
	/**
	 * @return the projBranchList
	 */
	public ArrayList<Branch> getProjBranchList() {
		return projBranchList;
	}
	/**
	 * @param projBranchList the projBranchList to set
	 */
	public void setProjBranchList(ArrayList<Branch> projBranchList) {
		this.projBranchList = projBranchList;
	}
	/**
	 * @return the projTeamMemberList
	 */
	public ArrayList<Team> getProjTeamMemberList() {
		return projTeamMemberList;
	}
	/**
	 * @param projTeamMemberList the projTeamMemberList to set
	 */
	public void setProjTeamMemberList(ArrayList<Team> projTeamMemberList) {
		this.projTeamMemberList = projTeamMemberList;
	}
	/**
	 * @return the projTeamId
	 */
	public long getProjTeamId() {
		return projTeamId;
	}
	/**
	 * @param projTeamId the projTeamId to set
	 */
	public void setProjTeamId(long projTeamId) {
		this.projTeamId = projTeamId;
	}
	/**
	 * @return the projTeamDesc
	 */
	public String getProjTeamDesc() {
		return projTeamDesc;
	}
	/**
	 * @param projTeamDesc the projTeamDesc to set
	 */
	public void setProjTeamDesc(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}
	/**
	 * @return the projStartDate
	 */
	public String getProjStartDate() {
		return projStartDate;
	}
	/**
	 * @param projStartDate the projStartDate to set
	 */
	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}
	/**
	 * @return the projEndDate
	 */
	public String getProjEndDate() {
		return projEndDate;
	}
	/**
	 * @param projEndDate the projEndDate to set
	 */
	public void setProjEndDate(String projEndDate) {
		this.projEndDate = projEndDate;
	}
	/**
	 * @return the projYear
	 */
	public int getProjYear() {
		return projYear;
	}
	/**
	 * @param projYear the projYear to set
	 */
	public void setProjYear(int projYear) {
		this.projYear = projYear;
	}
	/**
	 * @return the projDuration
	 */
	public int getProjDuration() {
		return projDuration;
	}
	/**
	 * @param projDuration the projDuration to set
	 */
	public void setProjDuration(int projDuration) {
		this.projDuration = projDuration;
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
	 * @return the projDescription
	 */
	public String getProjDescription() {
		return projDescription;
	}
	/**
	 * @param projDescription the projDescription to set
	 */
	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}
	/**
	 * @return the projUniversity
	 */
	public String getProjUniversity() {
		return projUniversity;
	}
	/**
	 * @param projUniversity the projUniversity to set
	 */
	public void setProjUniversity(String projUniversity) {
		this.projUniversity = projUniversity;
	}
	/**
	 * @return the projCollege
	 */
	public String getProjCollege() {
		return projCollege;
	}
	/**
	 * @param projCollege the projCollege to set
	 */
	public void setProjCollege(String projCollege) {
		this.projCollege = projCollege;
	}
	/**
	 * @return the projCollegeState
	 */
	public String getProjCollegeState() {
		return projCollegeState;
	}
	/**
	 * @param projCollegeState the projCollegeState to set
	 */
	public void setProjCollegeState(String projCollegeState) {
		this.projCollegeState = projCollegeState;
	}
	/**
	 * @return the projStudentId
	 */
	public String getProjStudentId() {
		return projStudentId;
	}
	/**
	 * @param projStudentId the projStudentId to set
	 */
	public void setProjStudentId(String projStudentId) {
		this.projStudentId = projStudentId;
	}
	/**
	 * @return the projFaculty
	 */
	public long getProjFaculty() {
		return projFaculty;
	}
	/**
	 * @param projFaculty the projFaculty to set
	 */
	public void setProjFaculty(long projFaculty) {
		this.projFaculty = projFaculty;
	}
	/**
	 * @return the projFacultyName
	 */
	public String getProjFacultyName() {
		return projFacultyName;
	}
	/**
	 * @param projFacultyName the projFacultyName to set
	 */
	public void setProjFacultyName(String projFacultyName) {
		this.projFacultyName = projFacultyName;
	}
	/**
	 * @return the projFacRgstrId
	 */
	public long getProjFacRgstrId() {
		return projFacRgstrId;
	}
	/**
	 * @param projFacRgstrId the projFacRgstrId to set
	 */
	public void setProjFacRgstrId(long projFacRgstrId) {
		this.projFacRgstrId = projFacRgstrId;
	}
	/**
	 * @return the projStatusId
	 */
	public int getProjStatusId() {
		return projStatusId;
	}
	/**
	 * @param projStatusId the projStatusId to set
	 */
	public void setProjStatusId(int projStatusId) {
		this.projStatusId = projStatusId;
	}
	/**
	 * @return the projEstimationCost
	 */
	public long getProjEstimationCost() {
		return projEstimationCost;
	}
	/**
	 * @param projEstimationCost the projEstimationCost to set
	 */
	public void setProjEstimationCost(long projEstimationCost) {
		this.projEstimationCost = projEstimationCost;
	}
	/**
	 * @return the imgName
	 */
	public String getImgName() {
		return imgName;
	}
	/**
	 * @param imgName the imgName to set
	 */
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	/**
	 * @return the imgByteArray
	 */
	public String getImgByteArray() {
		return imgByteArray;
	}
	/**
	 * @param imgByteArray the imgByteArray to set
	 */
	public void setImgByteArray(String imgByteArray) {
		this.imgByteArray = imgByteArray;
	}
	/**
	 * @return the footerImgName
	 */
	public String getFooterImgName() {
		return footerImgName;
	}
	/**
	 * @param footerImgName the footerImgName to set
	 */
	public void setFooterImgName(String footerImgName) {
		this.footerImgName = footerImgName;
	}
	/**
	 * @return the footerImgByteArray
	 */
	public String getFooterImgByteArray() {
		return footerImgByteArray;
	}
	/**
	 * @param footerImgByteArray the footerImgByteArray to set
	 */
	public void setFooterImgByteArray(String footerImgByteArray) {
		this.footerImgByteArray = footerImgByteArray;
	}
	/**
	 * @return the photo1Path
	 */
	public String getPhoto1Path() {
		return photo1Path;
	}
	/**
	 * @param photo1Path the photo1Path to set
	 */
	public void setPhoto1Path(String photo1Path) {
		this.photo1Path = photo1Path;
	}
	/**
	 * @return the photo2Path
	 */
	public String getPhoto2Path() {
		return photo2Path;
	}
	/**
	 * @param photo2Path the photo2Path to set
	 */
	public void setPhoto2Path(String photo2Path) {
		this.photo2Path = photo2Path;
	}
	/**
	 * @return the projMentor1Id
	 */
	public long getProjMentor1Id() {
		return projMentor1Id;
	}
	/**
	 * @param projMentor1Id the projMentor1Id to set
	 */
	public void setProjMentor1Id(long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}
	/**
	 * @return the projMentor2Id
	 */
	public long getProjMentor2Id() {
		return projMentor2Id;
	}
	/**
	 * @param projMentor2Id the projMentor2Id to set
	 */
	public void setProjMentor2Id(long projMentor2Id) {
		this.projMentor2Id = projMentor2Id;
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
	 * @return the projToFloat
	 */
	public String getProjToFloat() {
		return projToFloat;
	}
	/**
	 * @param projToFloat the projToFloat to set
	 */
	public void setProjToFloat(String projToFloat) {
		this.projToFloat = projToFloat;
	}
	/**
	 * @return the projCommentsPublish
	 */
	public String getProjCommentsPublish() {
		return projCommentsPublish;
	}
	/**
	 * @param projCommentsPublish the projCommentsPublish to set
	 */
	public void setProjCommentsPublish(String projCommentsPublish) {
		this.projCommentsPublish = projCommentsPublish;
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
	 * @return the projTeamLeaderId
	 */
	public long getProjTeamLeaderId() {
		return projTeamLeaderId;
	}
	/**
	 * @param projTeamLeaderId the projTeamLeaderId to set
	 */
	public void setProjTeamLeaderId(long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}
	/**
	 * @return the projAppliedAwards
	 */
	public String getProjAppliedAwards() {
		return projAppliedAwards;
	}
	/**
	 * @param projAppliedAwards the projAppliedAwards to set
	 */
	public void setProjAppliedAwards(String projAppliedAwards) {
		this.projAppliedAwards = projAppliedAwards;
	}
	/**
	 * @return the projGuideName
	 */
	public String getProjGuideName() {
		return projGuideName;
	}
	/**
	 * @param projGuideName the projGuideName to set
	 */
	public void setProjGuideName(String projGuideName) {
		this.projGuideName = projGuideName;
	}
	/**
	 * @return the projGuideEmail
	 */
	public String getProjGuideEmail() {
		return projGuideEmail;
	}
	/**
	 * @param projGuideEmail the projGuideEmail to set
	 */
	public void setProjGuideEmail(String projGuideEmail) {
		this.projGuideEmail = projGuideEmail;
	}
	/**
	 * @return the projGuideMobile
	 */
	public String getProjGuideMobile() {
		return projGuideMobile;
	}
	/**
	 * @param projGuideMobile the projGuideMobile to set
	 */
	public void setProjGuideMobile(String projGuideMobile) {
		this.projGuideMobile = projGuideMobile;
	}
	/**
	 * @return the projAcademicProgram
	 */
	public String getProjAcademicProgram() {
		return projAcademicProgram;
	}
	/**
	 * @param projAcademicProgram the projAcademicProgram to set
	 */
	public void setProjAcademicProgram(String projAcademicProgram) {
		this.projAcademicProgram = projAcademicProgram;
	}
	/**
	 * @return the projStatusInfo
	 */
	public String getProjStatusInfo() {
		return projStatusInfo;
	}
	/**
	 * @param projStatusInfo the projStatusInfo to set
	 */
	public void setProjStatusInfo(String projStatusInfo) {
		this.projStatusInfo = projStatusInfo;
	}
	/**
	 * @return the projCopyrightInfo
	 */
	public String getProjCopyrightInfo() {
		return projCopyrightInfo;
	}
	/**
	 * @param projCopyrightInfo the projCopyrightInfo to set
	 */
	public void setProjCopyrightInfo(String projCopyrightInfo) {
		this.projCopyrightInfo = projCopyrightInfo;
	}
	/**
	 * @return the projProofInfo
	 */
	public String getProjProofInfo() {
		return projProofInfo;
	}
	/**
	 * @param projProofInfo the projProofInfo to set
	 */
	public void setProjProofInfo(String projProofInfo) {
		this.projProofInfo = projProofInfo;
	}
	/**
	 * @return the otherDistinguishablePatents
	 */
	public String getOtherDistinguishablePatents() {
		return otherDistinguishablePatents;
	}
	/**
	 * @param otherDistinguishablePatents the otherDistinguishablePatents to set
	 */
	public void setOtherDistinguishablePatents(String otherDistinguishablePatents) {
		this.otherDistinguishablePatents = otherDistinguishablePatents;
	}
	/**
	 * @return the projFeature
	 */
	public String getProjFeature() {
		return projFeature;
	}
	/**
	 * @param projFeature the projFeature to set
	 */
	public void setProjFeature(String projFeature) {
		this.projFeature = projFeature;
	}
	/**
	 * @return the projFrugalityInfo
	 */
	public String getProjFrugalityInfo() {
		return projFrugalityInfo;
	}
	/**
	 * @param projFrugalityInfo the projFrugalityInfo to set
	 */
	public void setProjFrugalityInfo(String projFrugalityInfo) {
		this.projFrugalityInfo = projFrugalityInfo;
	}
	/**
	 * @return the projObjectiveInfo
	 */
	public String getProjObjectiveInfo() {
		return projObjectiveInfo;
	}
	/**
	 * @param projObjectiveInfo the projObjectiveInfo to set
	 */
	public void setProjObjectiveInfo(String projObjectiveInfo) {
		this.projObjectiveInfo = projObjectiveInfo;
	}
	/**
	 * @return the projContributeInfo
	 */
	public String getProjContributeInfo() {
		return projContributeInfo;
	}
	/**
	 * @param projContributeInfo the projContributeInfo to set
	 */
	public void setProjContributeInfo(String projContributeInfo) {
		this.projContributeInfo = projContributeInfo;
	}
	/**
	 * @return the projImpactInfo
	 */
	public String getProjImpactInfo() {
		return projImpactInfo;
	}
	/**
	 * @param projImpactInfo the projImpactInfo to set
	 */
	public void setProjImpactInfo(String projImpactInfo) {
		this.projImpactInfo = projImpactInfo;
	}
	/**
	 * @return the projRequiredResource
	 */
	public String getProjRequiredResource() {
		return projRequiredResource;
	}
	/**
	 * @param projRequiredResource the projRequiredResource to set
	 */
	public void setProjRequiredResource(String projRequiredResource) {
		this.projRequiredResource = projRequiredResource;
	}
	/**
	 * @return the projResearchContinue
	 */
	public String getProjResearchContinue() {
		return projResearchContinue;
	}
	/**
	 * @param projResearchContinue the projResearchContinue to set
	 */
	public void setProjResearchContinue(String projResearchContinue) {
		this.projResearchContinue = projResearchContinue;
	}
	/**
	 * @return the projPatentWork
	 */
	public String getProjPatentWork() {
		return projPatentWork;
	}
	/**
	 * @param projPatentWork the projPatentWork to set
	 */
	public void setProjPatentWork(String projPatentWork) {
		this.projPatentWork = projPatentWork;
	}
	/**
	 * @return the projPublishedPaper
	 */
	public String getProjPublishedPaper() {
		return projPublishedPaper;
	}
	/**
	 * @param projPublishedPaper the projPublishedPaper to set
	 */
	public void setProjPublishedPaper(String projPublishedPaper) {
		this.projPublishedPaper = projPublishedPaper;
	}
	/**
	 * @return the projOtherInfo
	 */
	public String getProjOtherInfo() {
		return projOtherInfo;
	}
	/**
	 * @param projOtherInfo the projOtherInfo to set
	 */
	public void setProjOtherInfo(String projOtherInfo) {
		this.projOtherInfo = projOtherInfo;
	}
	/**
	 * @return the projBenefitInfo
	 */
	public String getProjBenefitInfo() {
		return projBenefitInfo;
	}
	/**
	 * @param projBenefitInfo the projBenefitInfo to set
	 */
	public void setProjBenefitInfo(String projBenefitInfo) {
		this.projBenefitInfo = projBenefitInfo;
	}
	/**
	 * @return the projAwardYear
	 */
	public String getProjAwardYear() {
		return projAwardYear;
	}
	/**
	 * @param projAwardYear the projAwardYear to set
	 */
	public void setProjAwardYear(String projAwardYear) {
		this.projAwardYear = projAwardYear;
	}
	
	/**
	 * @return the teamLeaderName
	 */
	public String getTeamLeaderName() {
		return teamLeaderName;
	}
	/**
	 * @param teamLeaderName the teamLeaderName to set
	 */
	public void setTeamLeaderName(String teamLeaderName) {
		this.teamLeaderName = teamLeaderName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GytiProjectVO [projId=" + projId + ", projTypeId=" + projTypeId
				+ ", projTitle=" + projTitle + ", projBranches=" + projBranches
				+ ", projKeywords=" + projKeywords + ", projTeamMembers="
				+ projTeamMembers + ", projBranchList=" + projBranchList
				+ ", projTeamMemberList=" + projTeamMemberList
				+ ", projTeamId=" + projTeamId + ", projTeamDesc="
				+ projTeamDesc + ", projStartDate=" + projStartDate
				+ ", projEndDate=" + projEndDate + ", projYear=" + projYear
				+ ", projDuration=" + projDuration + ", projAbstract="
				+ projAbstract + ", projDescription=" + projDescription
				+ ", projUniversity=" + projUniversity + ", projCollege="
				+ projCollege + ", projCollegeState=" + projCollegeState
				+ ", projStudentId=" + projStudentId + ", projFaculty="
				+ projFaculty + ", projFacultyName=" + projFacultyName
				+ ", projFacRgstrId=" + projFacRgstrId + ", projStatusId="
				+ projStatusId + ", projEstimationCost=" + projEstimationCost
				+ ", imgName=" + imgName + ", imgByteArray=" + imgByteArray
				+ ", footerImgName=" + footerImgName + ", footerImgByteArray="
				+ footerImgByteArray + ", photo1Path=" + photo1Path
				+ ", photo2Path=" + photo2Path + ", projMentor1Id="
				+ projMentor1Id + ", projMentor2Id=" + projMentor2Id
				+ ", projGuideId=" + projGuideId + ", projToFloat="
				+ projToFloat + ", projCommentsPublish=" + projCommentsPublish
				+ ", projGrade=" + projGrade + ", projTeamLeaderId="
				+ projTeamLeaderId + ", projAppliedAwards=" + projAppliedAwards
				+ ", projGuideName=" + projGuideName + ", projGuideEmail="
				+ projGuideEmail + ", projGuideMobile=" + projGuideMobile
				+ ", projAcademicProgram=" + projAcademicProgram
				+ ", projStatusInfo=" + projStatusInfo + ", projCopyrightInfo="
				+ projCopyrightInfo + ", projProofInfo=" + projProofInfo
				+ ", otherDistinguishablePatents="
				+ otherDistinguishablePatents + ", projFeature=" + projFeature
				+ ", projFrugalityInfo=" + projFrugalityInfo
				+ ", projObjectiveInfo=" + projObjectiveInfo
				+ ", projContributeInfo=" + projContributeInfo
				+ ", projImpactInfo=" + projImpactInfo
				+ ", projRequiredResource=" + projRequiredResource
				+ ", projResearchContinue=" + projResearchContinue
				+ ", projPatentWork=" + projPatentWork
				+ ", projPublishedPaper=" + projPublishedPaper
				+ ", projOtherInfo=" + projOtherInfo + ", projBenefitInfo="
				+ projBenefitInfo + ", projAwardYear=" + projAwardYear
				+ ", teamLeaderName=" + teamLeaderName + "]";
	}
	
}
