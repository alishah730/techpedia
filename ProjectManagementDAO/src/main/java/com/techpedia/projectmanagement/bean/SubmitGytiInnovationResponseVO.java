/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author charan_teja
 *
 */
public class SubmitGytiInnovationResponseVO {

	private String status;
	
	private String description;
	
	private long projId;
	
	private String projTitle;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

	
	
}
