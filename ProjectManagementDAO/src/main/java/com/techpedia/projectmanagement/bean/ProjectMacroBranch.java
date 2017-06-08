package com.techpedia.projectmanagement.bean;

public class ProjectMacroBranch {
	
	private long macroBranchId;
	private String macroBranchName;
	private String photoPath;
	public long getMacroBranchId() {
		return macroBranchId;
	}
	public void setMacroBranchId(long macroBranchId) {
		this.macroBranchId = macroBranchId;
	}
	public String getMacroBranchName() {
		return macroBranchName;
	}
	public void setMacroBranchName(String macroBranchName) {
		this.macroBranchName = macroBranchName;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	@Override
	public String toString() {
		return "ProjectMacroBranch [macroBranchId=" + macroBranchId + ", macroBranchName=" + macroBranchName
				+ ", photoPath=" + photoPath + "]";
	}
	
	
}
