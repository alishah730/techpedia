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
@Table(name="TB_TECH001_MAST_PROJECTS_STATUS")
public class ProjectStatusMaster {

	@Id
	@GeneratedValue
	@Column(name="PROJ_STATUS_ID")
	private int projStatusId;
	
	@Column(name="PROJ_STATUS_DESC")
	private int projStatusDesc;

	/**
	 * @param projStatusDesc
	 */
	public ProjectStatusMaster(int projStatusDesc) {
		this.projStatusDesc = projStatusDesc;
	}

	/**
	 * @return the projStatusId
	 */
	public int getProjStatusId() {
		return projStatusId;
	}

	/**
	 * @param projStatusId the projStatusId to set
	 */
	public void setProjStatusId(int projStatusId) {
		this.projStatusId = projStatusId;
	}

	/**
	 * @return the projStatusDesc
	 */
	public int getProjStatusDesc() {
		return projStatusDesc;
	}

	/**
	 * @param projStatusDesc the projStatusDesc to set
	 */
	public void setProjStatusDesc(int projStatusDesc) {
		this.projStatusDesc = projStatusDesc;
	}

}
