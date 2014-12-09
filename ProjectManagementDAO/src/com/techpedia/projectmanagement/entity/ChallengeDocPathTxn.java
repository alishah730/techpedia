package com.techpedia.projectmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_tech001_txn_challng_doc_path")
public class ChallengeDocPathTxn {

	@Id
	@GeneratedValue
	@Column(name="CHALLENG_DOC_ID")
	private long challengDocId;
	
	@Column(name="CHALENG_ID")
	private long chalengId;
	
	@Column(name="CHALLENG_PATH")
	private String challengPath;
	
	@Column(name="CHALLENG_DOC_UPLOAD_DATE")
	private Date challengDocUploadDate;
	
	@Column(name="REGSTR_ID")
	private long regstrId;
	
	@Column(name="CHALLENG_DOC_SIZE_MB")
	private String challengDocSize;

	/**
	 * @return the challengDocId
	 */
	public long getChallengDocId() {
		return challengDocId;
	}

	/**
	 * @param challengDocId the challengDocId to set
	 */
	public void setChallengDocId(long challengDocId) {
		this.challengDocId = challengDocId;
	}

	/**
	 * @return the chalengId
	 */
	public long getChalengId() {
		return chalengId;
	}

	/**
	 * @param chalengId the chalengId to set
	 */
	public void setChalengId(long chalengId) {
		this.chalengId = chalengId;
	}

	/**
	 * @return the challengPath
	 */
	public String getChallengPath() {
		return challengPath;
	}

	/**
	 * @param challengPath the challengPath to set
	 */
	public void setChallengPath(String challengPath) {
		this.challengPath = challengPath;
	}

	/**
	 * @return the challengDocUploadDate
	 */
	public Date getChallengDocUploadDate() {
		return challengDocUploadDate;
	}

	/**
	 * @param challengDocUploadDate the challengDocUploadDate to set
	 */
	public void setChallengDocUploadDate(Date challengDocUploadDate) {
		this.challengDocUploadDate = challengDocUploadDate;
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
	 * @return the challengDocSize
	 */
	public String getChallengDocSize() {
		return challengDocSize;
	}

	/**
	 * @param challengDocSize the challengDocSize to set
	 */
	public void setChallengDocSize(String challengDocSize) {
		this.challengDocSize = challengDocSize;
	}

	/**
	 * @param challengDocId
	 * @param chalengId
	 * @param challengPath
	 * @param challengDocUploadDate
	 * @param regstrId
	 * @param challengDocSize
	 */
	public ChallengeDocPathTxn(long chalengId,
			String challengPath, Date challengDocUploadDate, long regstrId,
			String challengDocSize) {		
		this.chalengId = chalengId;
		this.challengPath = challengPath;
		this.challengDocUploadDate = challengDocUploadDate;
		this.regstrId = regstrId;
		this.challengDocSize = challengDocSize;
	}

	public ChallengeDocPathTxn() {
	}
}
