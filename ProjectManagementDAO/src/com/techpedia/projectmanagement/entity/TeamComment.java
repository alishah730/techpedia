package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamComment {
	
	@Id
	@Column(name="comment_id")
	private Long commentId;
	
	@Column(name="proj_comment")
	private String projComment;
	
	@Column(name="proj_id")
	private Long projId;
	
	@Column(name="regstr_id")
	private Long regstrId;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="MNAME")
	private String mName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="proj_team_leader_id")
	private Long projTeamLeaderId;
	
	@Column(name="PROJ_FAC_RGSTR_ID")
	private Long projGuideId;
	
	@Column(name="proj_mentor1_id")	
	private Long projMentor1Id;
	
	@Column(name="proj_mentor2_id")
	private Long projMentor2Id;

	/**
	 * @return the commentId
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the projComment
	 */
	public String getProjComment() {
		return projComment;
	}

	/**
	 * @param projComment the projComment to set
	 */
	public void setProjComment(String projComment) {
		this.projComment = projComment;
	}

	/**
	 * @return the projId
	 */
	public Long getProjId() {
		return projId;
	}

	/**
	 * @param projId the projId to set
	 */
	public void setProjId(Long projId) {
		this.projId = projId;
	}

	/**
	 * @return the regstrId
	 */
	public Long getRegstrId() {
		return regstrId;
	}

	/**
	 * @param regstrId the regstrId to set
	 */
	public void setRegstrId(Long regstrId) {
		this.regstrId = regstrId;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the projTeamLeaderId
	 */
	public Long getProjTeamLeaderId() {
		return projTeamLeaderId;
	}

	/**
	 * @param projTeamLeaderId the projTeamLeaderId to set
	 */
	public void setProjTeamLeaderId(Long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}

	/**
	 * @return the projGuideId
	 */
	public Long getProjGuideId() {
		return projGuideId;
	}

	/**
	 * @param projGuideId the projGuideId to set
	 */
	public void setProjGuideId(Long projGuideId) {
		this.projGuideId = projGuideId;
	}

	/**
	 * @return the projMentor1Id
	 */
	public Long getProjMentor1Id() {
		return projMentor1Id;
	}

	/**
	 * @param projMentor1Id the projMentor1Id to set
	 */
	public void setProjMentor1Id(Long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}

	/**
	 * @return the projMentor2Id
	 */
	public Long getProjMentor2Id() {
		return projMentor2Id;
	}

	/**
	 * @param projMentor2Id the projMentor2Id to set
	 */
	public void setProjMentor2Id(Long projMentor2Id) {
		this.projMentor2Id = projMentor2Id;
	}
	

}
