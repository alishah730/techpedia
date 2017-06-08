/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Date;

/**
 * @author 455959
 *
 */
public class ProjectDocPathVO {
	private long projDocId;
	private long projId;
	private String projPath;
	private Date projDocUploadDate;
	private long regstrId;
	private String projDocSizeMb;
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
	 * @return the projDocSizeMb
	 */
	public String getprojDocSizeMb() {
		return projDocSizeMb;
	}
	/**
	 * @param projDocSizeMb the projDocSizeMb to set
	 */
	public void setprojDocSizeMb(String projDocSizeMb) {
		this.projDocSizeMb = projDocSizeMb;
	}
	

}
