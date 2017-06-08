/**
 * 
 */
package com.techpedia.projectmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nishikant.singh
 *
 */
@Entity
@Table(name="TB_TECH001_MAST_PROJECTS_DETAIL")
public class ProjectMaster {
	
	@Id
	@GeneratedValue
	@Column(name="PROJ_ID")
	private long projId;
	
	@Column(name="PROJ_TYPE_ID")
	private int projTypeId;
	
	@Column(name="PROJ_TITLE")
	private String projTitle; 
	
	@Column(name="PROJ_ABSTRACT")
	private String projAbstract; 
	
	@Column(name="PROJ_DESCRIPTION")
	private String projDescription; 
	
	@Column(name="PROJ_UNIVERSITY")
	private String projUniversity; 
	
	@Column(name="PROJ_COLLEGE_RGSTR_ID_USR")
	private String projCollegeRgstrIdUsr; 
	
	@Column(name="USER_REGISTRATION_NO")
	private String userRgstrNo; 
	
	@Column(name="PROJ_YEAR")
	private int projYear; 
	
	@Column(name="PROJ_DURATION")
	private int projDuration; 
	
	@Column(name="PROJ_COLLEGE")
	private String projCollege;
	
	@Column(name="PROJ_COLLEGE_STATE")
	private String projCollegeState; 
	
	@Column(name="PROJ_START_DATE")
	private Date projStartDate; 
	
	@Column(name="PROJ_END_DATE")
	private Date projEndDate; 
	
	@Column(name="PROJ_MENTOR1_ID")
	private long projMentor1Id; 
	
	@Column(name="PROJ_MENTOR2_ID")
	private long projMentor2Id; 
	
	@Column(name="TEAM_ID")
	private long teamId; 
	
	@Column(name="PROJ_GUIDE_ID")
	private long projGuideId; 
	
	@Column(name="PROJ_STATUS_ID")
	private int projStatusId; 
	
	@Column(name="PROJ_TO_FLOAT")
	private String projToFloat;
	
	@Column(name="PROJ_ESTIMATED_COST")
	private Long projEstimatedCost;
	
	@Column(name="PROJ_COMMENTS_PUBLISH")
	private String projCommentsPublish;
	
	@Column(name="PROJ_GRADE")
	private String projGrade;
	
	@Column(name="PROJ_TEAM_LEADER_ID")
	private long projTeamLeaderId;
	
	@Column(name="PROJ_AWARD_WON")
	private String projAwardWon;
	
	@Column(name="PROJ_AWARD_DESC")
	private String projAwardDesc;
	
	@Column(name="PROJ_IS_MENTOR_AVAIL")
	private String projIsMentorAvail;
	
	@Column(name="PROJ_IS_FAC_APPROVE")
	private String projIsFacApprove;
	
	@Column(name="PROJ_ADMIN_COMMENTS")
	private String projAdminComments;
	
	@Column(name="PROJ_IS_FOR_CHALLENGE")
	private String projIsForChallenge;
	
	@Column(name="PROJECT_STATUS")
	private String projStatus;
	
	
	@Column(name="PROJ_FAC_RGSTR_ID")
	private long projFacRgstrId;
	
	@Column(name="PHOTO1_PATH")
	private String photo1Path;
	
	@Column(name="PHOTO2_PATH")
	private String photo2Path;
	
	@Column(name="PROJ_FAC_NOTES")
	private String projFacNotes;

	/**	
	 * @param projTypeId
	 * @param projTitle
	 * @param projAbstract
	 * @param projDescription
	 * @param projUniversity
	 * @param projCollegeRgstrIdUsr
	 * @param userRgstrNo
	 * @param projYear
	 * @param projDuration
	 * @param projCollege
	 * @param projCollegeState
	 * @param projStartDate
	 * @param projEndDate
	 * @param projMentor1Id
	 * @param projMentor2Id
	 * @param teamId
	 * @param projGuideId
	 * @param projStatusId
	 * @param projToFloat
	 * @param projEstimatedCost
	 * @param projCommentsPublish
	 * @param projGrade
	 * @param projTeamLeaderId
	 * @param projAwardWon
	 * @param projAwardDesc
	 * @param projIsMentorAvail
	 * @param projIsFacApprove
	 * @param projAdminComments
	 * @param projIsForChallenge
	 * @param projStatus
	 * @param projFacRgstrId
	 */
	public ProjectMaster(int projTypeId, String projTitle,
			String projAbstract, String projDescription, String projUniversity,
			String projCollegeRgstrIdUsr, String userRgstrNo, int projYear,
			int projDuration, String projCollege, String projCollegeState, Date projStartDate,
			Date projEndDate, long projMentor1Id, long projMentor2Id,
			long teamId, long projGuideId, int projStatusId,
			String projToFloat, Long projEstimatedCost,
			String projCommentsPublish, String projGrade,
			long projTeamLeaderId, String projAwardWon, String projAwardDesc,
			String projIsMentorAvail, String projIsFacApprove,
			String projAdminComments, String projIsForChallenge,
			String projStatus, long projFacRgstrId) {		
		this.projTypeId = projTypeId;
		this.projTitle = projTitle;
		this.projAbstract = projAbstract;
		this.projDescription = projDescription;
		this.projUniversity = projUniversity;
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
		this.userRgstrNo = userRgstrNo;
		this.projYear = projYear;
		this.projDuration = projDuration;
		this.projCollege = projCollege;
		this.projCollegeState = projCollegeState;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projMentor1Id = projMentor1Id;
		this.projMentor2Id = projMentor2Id;
		this.teamId = teamId;
		this.projGuideId = projGuideId;
		this.projStatusId = projStatusId;
		this.projToFloat = projToFloat;
		this.projEstimatedCost = projEstimatedCost;
		this.projCommentsPublish = projCommentsPublish;
		this.projGrade = projGrade;
		this.projTeamLeaderId = projTeamLeaderId;
		this.projAwardWon = projAwardWon;
		this.projAwardDesc = projAwardDesc;
		this.projIsMentorAvail = projIsMentorAvail;
		this.projIsFacApprove = projIsFacApprove;
		this.projAdminComments = projAdminComments;
		this.projIsForChallenge = projIsForChallenge;
		this.projStatus = projStatus;
		this.projFacRgstrId = projFacRgstrId;
	}
	
	
	/**	
	 * @param projTypeId
	 * @param projTitle
	 * @param projAbstract
	 * @param projDescription
	 * @param projUniversity
	 * @param projCollegeRgstrIdUsr
	 * @param userRgstrNo
	 * @param projYear
	 * @param projDuration
	 * @param projCollegeState
	 * @param projStartDate
	 * @param projEndDate
	 * @param projMentor1Id
	 * @param projMentor2Id
	 * @param teamId
	 * @param projGuideId
	 * @param projStatusId
	 * @param projToFloat
	 * @param projEstimatedCost
	 * @param projCommentsPublish
	 * @param projGrade
	 * @param projTeamLeaderId
	 * @param projAwardWon
	 * @param projAwardDesc
	 * @param projIsMentorAvail
	 * @param projIsFacApprove
	 * @param projAdminComments
	 * @param projIsForChallenge
	 * @param projStatus
	 * @param projFacRgstrId
	 * @param photo1Path
	 * @param photo2Path
	 * @param projFacNotes
	 */
	public ProjectMaster(int projTypeId, String projTitle,
			String projAbstract, String projDescription, String projUniversity,
			String projCollegeRgstrIdUsr, String userRgstrNo, int projYear,
			int projDuration, String projCollege, String projCollegeState, Date projStartDate,
			Date projEndDate, long projMentor1Id, long projMentor2Id,
			long teamId, long projGuideId, int projStatusId,
			String projToFloat, Long projEstimatedCost,
			String projCommentsPublish, String projGrade,
			long projTeamLeaderId, String projAwardWon, String projAwardDesc,
			String projIsMentorAvail, String projIsFacApprove,
			String projAdminComments, String projIsForChallenge,
			String projStatus, long projFacRgstrId, String photo1Path, String photo2Path, String projFacNotes) {		
		this.projTypeId = projTypeId;
		this.projTitle = projTitle;
		this.projAbstract = projAbstract;
		this.projDescription = projDescription;
		this.projUniversity = projUniversity;
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
		this.userRgstrNo = userRgstrNo;
		this.projYear = projYear;
		this.projDuration = projDuration;
		this.projCollege = projCollege;
		this.projCollegeState = projCollegeState;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projMentor1Id = projMentor1Id;
		this.projMentor2Id = projMentor2Id;
		this.teamId = teamId;
		this.projGuideId = projGuideId;
		this.projStatusId = projStatusId;
		this.projToFloat = projToFloat;
		this.projEstimatedCost = projEstimatedCost;
		this.projCommentsPublish = projCommentsPublish;
		this.projGrade = projGrade;
		this.projTeamLeaderId = projTeamLeaderId;
		this.projAwardWon = projAwardWon;
		this.projAwardDesc = projAwardDesc;
		this.projIsMentorAvail = projIsMentorAvail;
		this.projIsFacApprove = projIsFacApprove;
		this.projAdminComments = projAdminComments;
		this.projIsForChallenge = projIsForChallenge;
		this.projStatus = projStatus;
		this.projFacRgstrId = projFacRgstrId;
		this.photo1Path = photo1Path;
		this.photo2Path = photo2Path;
		this.projFacNotes = projFacNotes;
	}

	public ProjectMaster() {
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
	 * @return the projStartDate
	 */
	public Date getProjStartDate() {
		return projStartDate;
	}

	/**
	 * @param projStartDate the projStartDate to set
	 */
	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}

	/**
	 * @return the projEndDate
	 */
	public Date getProjEndDate() {
		return projEndDate;
	}

	/**
	 * @param projEndDate the projEndDate to set
	 */
	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
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
	 * @return the teamId
	 */
	public long getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(long teamId) {
		this.teamId = teamId;
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
	 * @return the projEstimatedCost
	 */
	public Long getProjEstimatedCost() {
		return projEstimatedCost;
	}

	/**
	 * @param projEstimatedCost the projEstimatedCost to set
	 */
	public void setProjEstimatedCost(Long projEstimatedCost) {
		this.projEstimatedCost = projEstimatedCost;
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
	 * @return the projStatus
	 */
	public String getProjStatus() {
		return projStatus;
	}

	/**
	 * @param projStatus the projStatus to set
	 */
	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
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
}
