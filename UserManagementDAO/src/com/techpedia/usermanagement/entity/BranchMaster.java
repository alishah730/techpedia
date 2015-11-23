package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TECH001_MAST_BRANCH")
public class BranchMaster {
	

	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "BRANCH_ID")
	private String branchId;
	
	@Column(name = "PROJ_BRANCH_DESC")
	private String proBrancDesc;
		
	public BranchMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getProBrancDesc() {
		return proBrancDesc;
	}

	public void setProBrancDesc(String proBrancDesc) {
		this.proBrancDesc = proBrancDesc;
	}
	
	@Override
	public String toString() {
		return "BranchMaster [branchId=" + branchId + ", proBrancDesc="
				+ proBrancDesc + "]";
	}

	public String getBranchId() {
		return branchId;
	}	

}
