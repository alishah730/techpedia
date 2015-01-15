package com.techpedia.projectmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tech001_txn_project_doc_path")
public class ProjectDocPathTxn {
	
	@Id
	@GeneratedValue
	@Column(name="PROJ_DOC_ID")
	private long projDocId;
	
	@Column(name="PROJ_ID")
	private long projId;
	
	@Column(name="PROJ_PATH")
	private String projPath;
	
	@Column(name="PROJ_DOC_UPLOAD_DATE")
	private Date projDocUploadDate;
	
	@Column(name="REGSTR_ID")
	private long regstrId;
	
	@Column(name="PROJ_DOC_SIZE_MB")
	private String projDocSize;

	/**
	 * @return the projDocId
	 */
	public long getProjDocId() {
		return projDocId;
	}

	/**
	 * @param projDocId the projDocId to set
	 */
	public void setProjDocId(long projDocId) {
		this.projDocId = projDocId;
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
	 * @return the projPath
	 */
	public String getProjPath() {
		return projPath;
	}

	/**
	 * @param projPath the projPath to set
	 */
	public void setProjPath(String projPath) {
		this.projPath = projPath;
	}

	/**
	 * @return the projDocUploadDate
	 */
	public Date getProjDocUploadDate() {
		return projDocUploadDate;
	}

	/**
	 * @param projDocUploadDate the projDocUploadDate to set
	 */
	public void setProjDocUploadDate(Date projDocUploadDate) {
		this.projDocUploadDate = projDocUploadDate;
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
	 * @return the projDocSize
	 */
	public String getProjDocSize() {
		return projDocSize;
	}

	/**
	 * @param projDocSize the projDocSize to set
	 */
	public void setProjDocSize(String projDocSize) {
		this.projDocSize = projDocSize;
	}

	/**
	 * @param projDocId
	 * @param projId
	 * @param projPath
	 * @param projDocUploadDate
	 * @param regstrId
	 * @param projDocSize
	 */
	public ProjectDocPathTxn(long projId, String projPath,
			Date projDocUploadDate, long regstrId, String projDocSize) {		
		this.projId = projId;
		this.projPath = projPath;
		this.projDocUploadDate = projDocUploadDate;
		this.regstrId = regstrId;
		this.projDocSize = projDocSize;
	}
	
	public ProjectDocPathTxn() {
	}
	
}
