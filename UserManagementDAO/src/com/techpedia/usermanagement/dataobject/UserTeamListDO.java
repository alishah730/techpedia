package com.techpedia.usermanagement.dataobject;

public class UserTeamListDO {
	
	private String teamID;
	private String teamName;
	/**
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamID;
	}
	/**
	 * @param teamID the teamID to set
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserTeamListDO [teamID=" + teamID + ", teamName=" + teamName
				+ "]";
	}
	
}
