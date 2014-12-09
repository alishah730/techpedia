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
@Table(name="tb_tech001_txn_project_comment")
public class ProjectCommentTxn {
	
	@Id
	@GeneratedValue
	@Column (name ="COMMENT_ID")
	private long commentId;
	
	@Column(name="PROJ_ID")
	private long projId;
	
	@Column(name="PROJ_COMMENT")
	private String projComment;
	
	@Column(name="PROJ_COMMENTS_REC_DATE")
	private Date projCommentsRecDate;
	
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
	public ProjectCommentTxn(long projId, String projComment,
			Date projCommentsRecDate, long regstrId,String isActiveCommt) {
		this.projId = projId;
		this.projComment = projComment;
		this.projCommentsRecDate = projCommentsRecDate;
		this.regstrId = regstrId;
		this.isActiveCommt = isActiveCommt;
	}
	public ProjectCommentTxn(){
		
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
	 * @return the projCommentsRecDate
	 */
	public Date getProjCommentsRecDate() {
		return projCommentsRecDate;
	}
	/**
	 * @param projCommentsRecDate the projCommentsRecDate to set
	 */
	public void setProjCommentsRecDate(Date projCommentsRecDate) {
		this.projCommentsRecDate = projCommentsRecDate;
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
