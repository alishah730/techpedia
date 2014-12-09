/**
 * 
 */
package com.techpedia.projectmanagement.entity;

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
@Table(name="TB_TECH001_MAST_PROJECTS_TEAM")
public class ProjectTeamMaster {
	
	@Id
	@GeneratedValue
	@Column(name="TEAM_ID")
	private long teamId;
	
	@Column(name="PROJ_TEAM_DESC")
	private String projTeamDesc;

	/**
	 * @return the teamId
	 */
	public long getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the projTeamDesc
	 */
	public String getProjTeamDesc() {
		return projTeamDesc;
	}

	/**
	 * @param projTeamDesc the projTeamDesc to set
	 */
	public void setProjTeamDesc(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}
	/**
	 * @param projTeamDesc
	 */
	public ProjectTeamMaster(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}
	public ProjectTeamMaster() {}
	
}
