package com.techpedia.projectmanagement.bean;


public class TeamMember {

	private long projId;
	private long regstrId;
	private long teamId;
	/**
	 * @return the projId
	 */
	public long getProjId() {
		return projId;
	}
	/**
	 * @param projId the projId to set
	 */
	public void setProjId(long projId) {
		this.projId = projId;
	}
	/**
	 * @return the regstrId
	 */
	public long getRegstrId() {
		return regstrId;
	}
	/**
	 * @param regstrId the regstrId to set
	 */
	public void setRegstrId(long regstrId) {
		this.regstrId = regstrId;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeamMember [projId=" + projId + ", regstrId=" + regstrId
				+ ", teamId=" + teamId + "]";
	}
	
	
}
