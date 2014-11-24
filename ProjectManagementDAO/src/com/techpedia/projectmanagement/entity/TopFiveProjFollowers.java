package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopFiveProjFollowers {

	@Id
	@Column(name="proj_id")
	private long projId;
	
	@Column(name="proj_title")
	private String projTitle;
	
	@Column(name="proj_description")
	private String projDescription;

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
	
}
