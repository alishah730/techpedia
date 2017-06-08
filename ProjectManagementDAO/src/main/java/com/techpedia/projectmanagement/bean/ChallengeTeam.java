package com.techpedia.projectmanagement.bean;

import java.util.ArrayList;


public class ChallengeTeam {

	private long projId;
	private long regstrId;
	private long projTeamId;
	private long challengId;
	private String fName;
	private String mName;
	private String lName;
	private String projTitle;
	private String projTeamDesc;
	private String projTeamLeaderName;
	private String projFacultyName;
	private String projCollege;
	private ArrayList<Branch> projBranchList;
	
	
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
	 * @return the projTeamId
	 */
	public long getProjTeamId() {
		return projTeamId;
	}
	/**
	 * @param projTeamId the projTeamId to set
	 */
	public void setProjTeamId(long projTeamId) {
		this.projTeamId = projTeamId;
	}
	/**
	 * @return the challengId
	 */
	public long getChallengId() {
		return challengId;
	}
	/**
	 * @param challengId the challengId to set
	 */
	public void setChallengId(long challengId) {
		this.challengId = challengId;
	}
	
	
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}
	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
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
	 * @return the projTeamDesc
	 */
	public String getProjTeamDesc() {
		return projTeamDesc;
	}
	/**
	 * @param projTeamDesc the projTeamDesc to set
	 */
	public void setProjTeamDesc(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}
	
	
	
	/**
	 * @return the projTeamLeaderName
	 */
	public String getProjTeamLeaderName() {
		return projTeamLeaderName;
	}
	/**
	 * @param projTeamLeaderName the projTeamLeaderName to set
	 */
	public void setProjTeamLeaderName(String projTeamLeaderName) {
		this.projTeamLeaderName = projTeamLeaderName;
	}
	/**
	 * @return the projFacultyName
	 */
	public String getProjFacultyName() {
		return projFacultyName;
	}
	/**
	 * @param projFacultyName the projFacultyName to set
	 */
	public void setProjFacultyName(String projFacultyName) {
		this.projFacultyName = projFacultyName;
	}
	/**
	 * @return the projCollege
	 */
	public String getProjCollege() {
		return projCollege;
	}
	/**
	 * @param projCollege the projCollege to set
	 */
	public void setProjCollege(String projCollege) {
		this.projCollege = projCollege;
	}
	/**
	 * @return the projBranchList
	 */
	public ArrayList<Branch> getProjBranchList() {
		return projBranchList;
	}
	/**
	 * @param projBranchList the projBranchList to set
	 */
	public void setProjBranchList(ArrayList<Branch> projBranchList) {
		this.projBranchList = projBranchList;
	}
	@Override
	public String toString() {
		return "TeamMember [projId=" + projId + ", regstrId=" + regstrId
				+ ", projTeamId=" + projTeamId + ", challengId=" + challengId + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + ","
				+ " projTitle=" + projTitle + ", projTeamDesc=" + projTeamDesc + ", projTeamLeaderName=" + projTeamLeaderName + ", projFacultyName=" + projFacultyName 
				+", projCollege=" + projCollege + ", projBranchList=" + projBranchList + "]";
	}
	
	
}
