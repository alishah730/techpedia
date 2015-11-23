package com.techpedia.projectmanagement.bean;


/**
 * @author nishikant.singh
 *
 */

public class ProjectType {

	private int projTypeId;
	
	private String projTypeDesc;
	
	public int getProjTypeId() {
		return projTypeId;
	}
	public void setProjTypeId(int projTypeId) {
		this.projTypeId = projTypeId;
	}
	public String getProjTypeDesc() {
		return projTypeDesc;
	}
	public void setProjTypeDesc(String projTypeDesc) {
		this.projTypeDesc = projTypeDesc;
	}
	@Override
	public String toString() {
		return "ProjectType [projTypeId=" + projTypeId + ", projTypeDesc="
				+ projTypeDesc + "]";
	}
	
}
