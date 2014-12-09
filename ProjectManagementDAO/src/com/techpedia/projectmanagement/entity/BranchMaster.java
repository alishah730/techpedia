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
@Table(name="TB_TECH001_MAST_BRANCH")
public class BranchMaster{

	@Id
	@GeneratedValue
	@Column(name="BRANCH_ID")
	private int branchId;
	
	@Column(name="PROJ_BRANCH_DESC")
	private String projBranchDesc;

	/**
	 * 
	 */
	public BranchMaster() {}
	
	/**
	 * @param projBranchDesc
	 */
	public BranchMaster(String projBranchDesc) {
		this.projBranchDesc = projBranchDesc;
	}

	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the projBranchDesc
	 */
	public String getProjBranchDesc() {
		return projBranchDesc;
	}

	/**
	 * @param projBranchDesc the projBranchDesc to set
	 */
	public void setProjBranchDesc(String projBranchDesc) {
		this.projBranchDesc = projBranchDesc;
	}
	
}
