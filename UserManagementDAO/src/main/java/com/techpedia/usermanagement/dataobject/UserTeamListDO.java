package com.techpedia.usermanagement.dataobject;

public class UserTeamListDO {
	
	private String teamID;
	private String teamName;
	private String photo1Path;
	private String projTitle;
	private long projId;
	private int projStatusId;
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
	/**
	 * @return the photo1Path
	 */
	public String getPhoto1Path() {
		return photo1Path;
	}
	/**
	 * @param photo1Path the photo1Path to set
	 */
	public void setPhoto1Path(String photo1Path) {
		this.photo1Path = photo1Path;
	}
	/**
	 * @return the projTitle
	 */
	public String getProjTitle() {
		return projTitle;
	}
	/**
	 * @param projTitle the projTitle to set
	 */
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
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
	 * @return the projStatusId
	 */
	public int getProjStatusId() {
		return projStatusId;
	}
	/**
	 * @param projStatusId the projStatusId to set
	 */
	public void setProjStatusId(int projStatusId) {
		this.projStatusId = projStatusId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserTeamListDO [teamID=" + teamID + ", teamName=" + teamName
				+ "photo1Path=" + photo1Path + ",projTitle=" + projTitle + ",projId=" + projId + ",projStatusId=" + projStatusId + "]";
	}
	
}
