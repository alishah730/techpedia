package com.techpedia.projectmanagement.bean;

public class DisplayProjectMacroVO {
	
	private String branchName;
	private String iterationCount;
	
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIterationCount() {
		return iterationCount;
	}
	public void setIterationCount(String iterationCount) {
		this.iterationCount = iterationCount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DisplayProjectMacroVO [branchName=" + branchName + ", iterationCount=" + iterationCount + "]";
	}
	
	

}
