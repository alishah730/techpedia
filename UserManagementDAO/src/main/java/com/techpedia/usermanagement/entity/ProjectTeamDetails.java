package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectTeamDetails {
	
	@Id
	@Column (name = "PROJ_ID")
	private String projId;
	
	/**
	 * @return the projId
	 */
	public String getProjId() {
		return projId;
	}

	/**
	 * @param projId the projId to set
	 */
	public void setProjId(String projId) {
		this.projId = projId;
	}

	@Column (name = "PROJ_TITLE")
	private String projTitle;
	
	@Column (name = "PHOTO1_PATH")
	private String photo1Path;

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

}
