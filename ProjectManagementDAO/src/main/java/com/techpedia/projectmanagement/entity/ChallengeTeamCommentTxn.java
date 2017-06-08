package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChallengeTeamCommentTxn {
	
	@Id
	@Column(name="comment_id")
	private Long commentId;
	
	@Column(name="challeng_comment")
	private String challengeComment;
	
	@Column(name="challeng_id")
	private Long challengeId;
	
	@Column(name="regstr_id")
	private Long regstrId;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="MNAME")
	private String mName;
	
	@Column(name="LNAME")
	private String lName;

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
	 * @return the challengeComment
	 */
	public String getChallengeComment() {
		return challengeComment;
	}

	/**
	 * @param challengeComment the challengeComment to set
	 */
	public void setChallengeComment(String challengeComment) {
		this.challengeComment = challengeComment;
	}

	/**
	 * @return the challengeId
	 */
	public Long getChallengeId() {
		return challengeId;
	}

	/**
	 * @param challengeId the challengeId to set
	 */
	public void setChallengeId(Long challengeId) {
		this.challengeId = challengeId;
	}

	
	

}
