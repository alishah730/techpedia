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
@Table(name="TB_TECH001_MAST_PROJECT_TYPE")
public class ProjectTypeMaster {
	
	@Id
	@GeneratedValue
	@Column(name="PROJ_TYPE_ID")
	private int projTypeId;
	
	@Column(name="PROJ_TYPE_DESC")
	private String projTypeDesc;

	/**
	 * @param projTypeDesc
	 */
	public ProjectTypeMaster(String projTypeDesc) {
		this.projTypeDesc = projTypeDesc;
	}
	
	public ProjectTypeMaster( ) {		
	}

	/**
	 * @return the projTypeId
	 */
	public int getProjTypeId() {
		return projTypeId;
	}

	/**
	 * @param projTypeId the projTypeId to set
	 */
	public void setProjTypeId(int projTypeId) {
		this.projTypeId = projTypeId;
	}

	/**
	 * @return the projTypeDesc
	 */
	public String getProjTypeDesc() {
		return projTypeDesc;
	}

	/**
	 * @param projTypeDesc the projTypeDesc to set
	 */
	public void setProjTypeDesc(String projTypeDesc) {
		this.projTypeDesc = projTypeDesc;
	}
}
