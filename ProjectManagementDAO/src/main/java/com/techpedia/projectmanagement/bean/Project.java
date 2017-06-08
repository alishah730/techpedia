/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.ArrayList;
import java.util.Arrays;

import com.techpedia.projectmanagement.bean.Branch;
import com.techpedia.projectmanagement.bean.Team;

/**
 * @author nishikant.singh
 *
 */
public class Project {

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
	private int projFacRgstrId;
	
	private long projEstimationCost;
	private  byte[] projImage;
	private String imgName;
	private String imgByteArray;
	private String footerImgName;
	private String footerImgByteArray;
	private String photo1Path;
	private String photo2Path;

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
	private long challengId;
	private String projIsForChallenge;
	private String projFacEmailId;
	private String projTeamLeaderEMailId;
	private String projTeamLeaderName;
	private String projSubmitionDate;
	private String projFacNotes;
	
	
	/**
	 * @return the projFacRgstrId
	 */
	public int getProjFacRgstrId() {
		return projFacRgstrId;
	}
	/**
	 * @param projFacRgstrId the projFacRgstrId to set
	 */
	public void setProjFacRgstrId(int projFacRgstrId) {
		this.projFacRgstrId = projFacRgstrId;
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
	 * @return the photo1Path
	 */
	public String getPhoto1Path() {
		return photo1Path;
	}
	/**
	 * @param photopath the photo1Path to set
	 */
	public void setPhoto1Path(String photo1Path) {
		this.photo1Path = photo1Path;
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
	 * @return the projImage
	 */
	public byte[] getProjImage() {
		return projImage;
	}
	/**
	 * @param projImage the projImage to set
	 */
	public void setProjImage(byte[] projImage) {
		this.projImage = projImage;
	}
	/**************************************************/
	/**
	 * @return the projCollegeRgstrIdUsr
	 */
	public String getProjCollegeRgstrIdUsr() {
		return projCollegeRgstrIdUsr;
	}
	/**
	 * @param projCollegeRgstrIdUsr the projCollegeRgstrIdUsr to set
	 */
	public void setProjCollegeRgstrIdUsr(String projCollegeRgstrIdUsr) {
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
	}
	/**
	 * @return the userRgstrNo
	 */
	public String getUserRgstrNo() {
		return userRgstrNo;
	}
	/**
	 * @param userRgstrNo the userRgstrNo to set
	 */
	public void setUserRgstrNo(String userRgstrNo) {
		this.userRgstrNo = userRgstrNo;
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
	 * @return the projAwardWon
	 */
	public String getProjAwardWon() {
		return projAwardWon;
	}
	/**
	 * @param projAwardWon the projAwardWon to set
	 */
	public void setProjAwardWon(String projAwardWon) {
		this.projAwardWon = projAwardWon;
	}
	/**
	 * @return the projAwardDesc
	 */
	public String getProjAwardDesc() {
		return projAwardDesc;
	}
	/**
	 * @param projAwardDesc the projAwardDesc to set
	 */
	public void setProjAwardDesc(String projAwardDesc) {
		this.projAwardDesc = projAwardDesc;
	}
	/**
	 * @return the projIsMentorAvail
	 */
	public String getProjIsMentorAvail() {
		return projIsMentorAvail;
	}
	/**
	 * @param projIsMentorAvail the projIsMentorAvail to set
	 */
	public void setProjIsMentorAvail(String projIsMentorAvail) {
		this.projIsMentorAvail = projIsMentorAvail;
	}
	/**
	 * @return the projIsFacApprove
	 */
	public String getProjIsFacApprove() {
		return projIsFacApprove;
	}
	/**
	 * @param projIsFacApprove the projIsFacApprove to set
	 */
	public void setProjIsFacApprove(String projIsFacApprove) {
		this.projIsFacApprove = projIsFacApprove;
	}
	/**
	 * @return the projAdminComments
	 */
	public String getProjAdminComments() {
		return projAdminComments;
	}
	/**
	 * @param projAdminComments the projAdminComments to set
	 */
	public void setProjAdminComments(String projAdminComments) {
		this.projAdminComments = projAdminComments;
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
	 * @return the challengId
	 */
	public long getChallengId() {
		return challengId;
	}
	/**
	 * @param challengId the challengId to set
	 */
	public void setChallengId(long challengId) {
		this.challengId = challengId;
	}
	/**
	 * @return the projIsForChallenge
	 */
	public String getProjIsForChallenge() {
		return projIsForChallenge;
	}
	/**
	 * @param projIsForChallenge the projIsForChallenge to set
	 */
	public void setProjIsForChallenge(String projIsForChallenge) {
		this.projIsForChallenge = projIsForChallenge;
	}
	/**
	 * @return the projFacEmailId
	 */
	public String getProjFacEmailId() {
		return projFacEmailId;
	}
	/**
	 * @param projFacEmailId the projFacEmailId to set
	 */
	public void setProjFacEmailId(String projFacEmailId) {
		this.projFacEmailId = projFacEmailId;
	}
	/**
	 * @return the projTeamLeaderEMailId
	 */
	public String getProjTeamLeaderEMailId() {
		return projTeamLeaderEMailId;
	}
	/**
	 * @param projTeamLeaderEMailId the projTeamLeaderEMailId to set
	 */
	public void setProjTeamLeaderEMailId(String projTeamLeaderEMailId) {
		this.projTeamLeaderEMailId = projTeamLeaderEMailId;
	}
	
	/**
	 * @return the projTeamLeaderName
	 */
	public String getProjTeamLeaderName() {
		return projTeamLeaderName;
	}
	/**
	 * @param projTeamLeaderName the projTeamLeaderName to set
	 */
	public void setProjTeamLeaderName(String projTeamLeaderName) {
		this.projTeamLeaderName = projTeamLeaderName;
	}
	/**
	 * @return the projSubmitionDate
	 */
	public String getProjSubmitionDate() {
		return projSubmitionDate;
	}
	/**
	 * @param projSubmitionDate the projSubmitionDate to set
	 */
	public void setProjSubmitionDate(String projSubmitionDate) {
		this.projSubmitionDate = projSubmitionDate;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projTypeId=" + projTypeId + ", projTitle=" + projTitle
				+ ", projBranches=" + projBranches + ", projKeywords=" + projKeywords + ", projTeamMembers="
				+ projTeamMembers + ", projBranchList=" + projBranchList + ", projTeamMemberList=" + projTeamMemberList
				+ ", projTeamId=" + projTeamId + ", projTeamDesc=" + projTeamDesc + ", projStartDate=" + projStartDate
				+ ", projEndDate=" + projEndDate + ", projYear=" + projYear + ", projDuration=" + projDuration
				+ ", projAbstract=" + projAbstract + ", projDescription=" + projDescription + ", projUniversity="
				+ projUniversity + ", projCollege=" + projCollege + ", projCollegeState=" + projCollegeState
				+ ", projStudentId=" + projStudentId + ", projFaculty=" + projFaculty + ", projFacultyName="
				+ projFacultyName + ", projFacRgstrId=" + projFacRgstrId + ", projEstimationCost=" + projEstimationCost
				+ ", projImage=" + Arrays.toString(projImage) + ", imgName=" + imgName + ", imgByteArray="
				+ imgByteArray + ", footerImgName=" + footerImgName + ", footerImgByteArray=" + footerImgByteArray
				+ ", photo1Path=" + photo1Path + ", photo2Path=" + photo2Path + ", projCollegeRgstrIdUsr="
				+ projCollegeRgstrIdUsr + ", userRgstrNo=" + userRgstrNo + ", projMentor1Id=" + projMentor1Id
				+ ", projMentor2Id=" + projMentor2Id + ", projGuideId=" + projGuideId + ", projStatusId=" + projStatusId
				+ ", projToFloat=" + projToFloat + ", projCommentsPublish=" + projCommentsPublish + ", projGrade="
				+ projGrade + ", projTeamLeaderId=" + projTeamLeaderId + ", projAwardWon=" + projAwardWon
				+ ", projAwardDesc=" + projAwardDesc + ", projIsMentorAvail=" + projIsMentorAvail
				+ ", projIsFacApprove=" + projIsFacApprove + ", projAdminComments=" + projAdminComments
				+ ", challengId=" + challengId + ", projIsForChallenge=" + projIsForChallenge + ", ProjFacEMailId="
				+ projFacEmailId + ", projTeamLeaderEMailId=" + projTeamLeaderEMailId + ", projTeamLeaderName="
				+ projTeamLeaderName + ", projSubmitionDate=" + projSubmitionDate + ", projFacNotes=" + projFacNotes
				+ "]";
	}
	
}
