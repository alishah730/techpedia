package com.techpedia.projectmanagement.bean;

public class Team {
	
	private long teamMemberRgstrId;
	
	private String teamMemberName;


	/**
	 * @return the teamMemberRgstrId
	 */
	public long getTeamMemberRgstrId() {
		return teamMemberRgstrId;
	}

	/**
	 * @param teamMemberRgstrId the teamMemberRgstrId to set
	 */
	public void setTeamMemberRgstrId(long teamMemberRgstrId) {
		this.teamMemberRgstrId = teamMemberRgstrId;
	}

	/**
	 * @return the teamMemberName
	 */
	public String getTeamMemberName() {
		return teamMemberName;
	}

	/**
	 * @param teamMemberName the teamMemberName to set
	 */
	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Team [teamMemberRgstrId=" + teamMemberRgstrId
				+ ", teamMemberName=" + teamMemberName + "]";
	}
}
