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
 * @author charan.teja
 *
 */
@Entity
@Table(name="tb_tech001_txn_challeng_comment")
public class ChallengeCommentTxn {
	
	@Id
	@GeneratedValue
	@Column (name ="COMMENT_ID")
	private long commentId;
	
	@Column(name="CHALLENG_ID")
	private long challengeId;
	
	@Column(name="CHALLENG_COMMENT")
	private String challengeComment;
	
	@Column(name="CHALLENG_COMMENTS_REC_DATE")
	private Date challengeCommentsRecDate;
	
	@Column(name="REGSTR_ID")
	private long regstrId;
	
	@Column(name="IS_ACTIVE_COMMNT")	
	private String isActiveCommt;
	
	/**
	 * @param projId
	 * @param projComment
	 * @param projCommentsRecDate
	 * @param regstrId
	 * @param isActiveCommt
	 */
	public ChallengeCommentTxn(long challengeId, String challengeComment,
			Date challengeCommentsRecDate, long regstrId,String isActiveCommt) {
		this.challengeId = challengeId;
		this.challengeComment = challengeComment;
		this.challengeCommentsRecDate = challengeCommentsRecDate;
		this.regstrId = regstrId;
		this.isActiveCommt = isActiveCommt;
	}
	public ChallengeCommentTxn(){
		
	}
	/**
	 * @return the commentId
	 */
	public long getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	/**
	 * @return the challengeId
	 */
	public long getChallengeId() {
		return challengeId;
	}
	/**
	 * @param challengeId the challengeId to set
	 */
	public void setChallengeId(long challengeId) {
		this.challengeId = challengeId;
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
	 * @return the challengeCommentsRecDate
	 */
	public Date getChallengeCommentsRecDate() {
		return challengeCommentsRecDate;
	}
	/**
	 * @param challengeCommentsRecDate the challengeCommentsRecDate to set
	 */
	public void setChallengeCommentsRecDate(Date challengeCommentsRecDate) {
		this.challengeCommentsRecDate = challengeCommentsRecDate;
	}
	/**
	 * @return the regstrId
	 */
	public long getRegstrId() {
		return regstrId;
	}
	/**
	 * @param regstrId the regstrId to set
	 */
	public void setRegstrId(long regstrId) {
		this.regstrId = regstrId;
	}
	/**
	 * @return the isActiveCommt
	 */
	public String getIsActiveCommt() {
		return isActiveCommt;
	}
	/**
	 * @param isActiveCommt the isActiveCommt to set
	 */
	public void setIsActiveCommt(String isActiveCommt) {
		this.isActiveCommt = isActiveCommt;
	}	
	

}
