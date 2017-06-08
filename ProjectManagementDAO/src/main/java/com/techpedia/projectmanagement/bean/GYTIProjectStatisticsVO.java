package com.techpedia.projectmanagement.bean;

public class GYTIProjectStatisticsVO {
	private String category;
	
	private long totalProject;
	
	public long getTotalProject() {
		return totalProject;
	}
	public void setTotalProject(long totalProject) {
		this.totalProject = totalProject;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "GYTIProjectStatisticsVO [category=" + category + ", totalProject=" + totalProject + "]";
	}
	
}
