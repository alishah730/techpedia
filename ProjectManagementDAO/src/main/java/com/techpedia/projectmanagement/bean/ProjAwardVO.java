/**
 * 
 */
package com.techpedia.projectmanagement.bean;

/**
 * @author 455959
 *
 */
public class ProjAwardVO {
	
	private long projId;
	private int awardId;
	private String awardYear;
	private String awardWon;
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
	 * @return the awardId
	 */
	public int getAwardId() {
		return awardId;
	}
	/**
	 * @param awardId the awardId to set
	 */
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	/**
	 * @return the awardYear
	 */
	public String getAwardYear() {
		return awardYear;
	}
	/**
	 * @param awardYear the awardYear to set
	 */
	public void setAwardYear(String awardYear) {
		this.awardYear = awardYear;
	}
	/**
	 * @return the awardWon
	 */
	public String getAwardWon() {
		return awardWon;
	}
	/**
	 * @param awardWon the awardWon to set
	 */
	public void setAwardWon(String awardWon) {
		this.awardWon = awardWon;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjAwardVO [projId=" + projId + ", awardId=" + awardId
				+ ", awardYear=" + awardYear + ", awardWon=" + awardWon + "]";
	}
	

}
