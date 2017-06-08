/**
 * 
 */
package com.techpedia.projectmanagement.bean;


import java.util.ArrayList;

/**
 * @author geetanjali
 *
 */
public class Challenge {

	private long challengId;
	private int challengTypeId;
	private String challengTitle;
	private String challengAbstract;
	private String challengDescription;
	private long rgstrId;
	private int challengYear;
	private String challengStartDate;
	private String challengCloseDate;
	private String isChallengActive;
	private String isChallengSuccess;
	private String challengCommentsPublish;
	private String challengImpact;
	private String challengIsIncentiv;
	private String challengSourceFund;
	private String challengDelivExpctatn;
	private String challengBenchmark;

	private String challengTypeDesc;
	private String userName;
	
	private String challengImgPath;
	
	private long projTeamId;
	private long projId;
	
	
	private ArrayList<Integer> challengTypeIds;

	private ArrayList<Long> challengIds;
	
	 
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Challenge [challengId=" + challengId + ", challengTypeId="
				+ challengTypeId + ", challengTitle=" + challengTitle
				+ ", challengAbstract=" + challengAbstract
				+ ", challengDescription=" + challengDescription + ", rgstrId="
				+ rgstrId + ", challengYear=" + challengYear
				+ ", challengStartDate=" + challengStartDate
				+ ", challengCloseDate=" + challengCloseDate
				+ ", isChallengActive=" + isChallengActive
				+ ", isChallengSuccess=" + isChallengSuccess
				+ ", challengCommentsPublish=" + challengCommentsPublish
				+ ", challengImpact=" + challengImpact
				+ ", challengIsIncentiv=" + challengIsIncentiv
				+ ", challengSourceFund=" + challengSourceFund
				+ ", challengDelivExpctatn=" + challengDelivExpctatn
				+ ", challengBenchmark=" + challengBenchmark
				+ ", challengTypeDesc=" + challengTypeDesc
				+ ", challengImgPath=" + challengImgPath + ", projTeamId="
				+ projTeamId + ", projId=" + projId + ", challengTypeIds="
				+ challengTypeIds + ", challengIds=" + challengIds + ", userName=" + userName + "]";
	}

	
	
	
	
	/**
	 * @return the challengIds
	 */
	public ArrayList<Long> getChallengIds() {
		return challengIds;
	}


	/**
	 * @param challengIds the challengIds to set
	 */
	public void setChallengIds(ArrayList<Long> challengIds) {
		this.challengIds = challengIds;
	}


	/**
	 * @return the challengTypeIds
	 */
	public ArrayList<Integer> getChallengTypeIds() {
		return challengTypeIds;
	}


	/**
	 * @param challengTypeIds the challengTypeIds to set
	 */
	public void setChallengTypeIds(ArrayList<Integer> challengTypeIds) {
		this.challengTypeIds = challengTypeIds;
	}





	/**
	 * @return the challengImgPath
	 */
	public String getChallengImgPath() {
		return challengImgPath;
	}


	/**
	 * @param challengImgPath the challengImgPath to set
	 */
	public void setChallengImgPath(String challengImgPath) {
		this.challengImgPath = challengImgPath;
	}


	/**
	 * @return the challengTypeId
	 */
	public int getChallengTypeId() {
		return challengTypeId;
	}

	/**
	 * @param challengTypeId the challengTypeId to set
	 */
	public void setChallengTypeId(int challengTypeId) {
		this.challengTypeId = challengTypeId;
	}

	/**
	 * @return the challengTitle
	 */
	public String getChallengTitle() {
		return challengTitle;
	}

	/**
	 * @param challengTitle the challengTitle to set
	 */
	public void setChallengTitle(String challengTitle) {
		this.challengTitle = challengTitle;
	}

	/**
	 * @return the challengAbstract
	 */
	public String getChallengAbstract() {
		return challengAbstract;
	}

	/**
	 * @param challengAbstract the challengAbstract to set
	 */
	public void setChallengAbstract(String challengAbstract) {
		this.challengAbstract = challengAbstract;
	}

	/**
	 * @return the challengDescription
	 */
	public String getChallengDescription() {
		return challengDescription;
	}

	/**
	 * @param challengDescription the challengDescription to set
	 */
	public void setChallengDescription(String challengDescription) {
		this.challengDescription = challengDescription;
	}

	/**
	 * @return the rgstrId
	 */
	public long getRgstrId() {
		return rgstrId;
	}

	/**
	 * @param rgstrId the rgstrId to set
	 */
	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}

	/**
	 * @return the challengYear
	 */
	public int getChallengYear() {
		return challengYear;
	}

	/**
	 * @param challengYear the challengYear to set
	 */
	public void setChallengYear(int challengYear) {
		this.challengYear = challengYear;
	}


	/**
	 * @return the challengStartDate
	 */
	public String getChallengStartDate() {
		return challengStartDate;
	}

	/**
	 * @param challengStartDate the challengStartDate to set
	 */
	public void setChallengStartDate(String challengStartDate) {
		this.challengStartDate = challengStartDate;
	}

	/**
	 * @return the challengCloseDate
	 */
	public String getChallengCloseDate() {
		return challengCloseDate;
	}

	/**
	 * @param challengCloseDate the challengCloseDate to set
	 */
	public void setChallengCloseDate(String challengCloseDate) {
		this.challengCloseDate = challengCloseDate;
	}

	/**
	 * @return the isChallengActive
	 */
	public String getIsChallengActive() {
		return isChallengActive;
	}

	/**
	 * @param isChallengActive the isChallengActive to set
	 */
	public void setIsChallengActive(String isChallengActive) {
		this.isChallengActive = isChallengActive;
	}

	/**
	 * @return the isChallengSuccess
	 */
	public String getIsChallengSuccess() {
		return isChallengSuccess;
	}

	/**
	 * @param isChallengSuccess the isChallengSuccess to set
	 */
	public void setIsChallengSuccess(String isChallengSuccess) {
		this.isChallengSuccess = isChallengSuccess;
	}

	/**
	 * @return the challengCommentsPublish
	 */
	public String getChallengCommentsPublish() {
		return challengCommentsPublish;
	}

	/**
	 * @param challengCommentsPublish the challengCommentsPublish to set
	 */
	public void setChallengCommentsPublish(String challengCommentsPublish) {
		this.challengCommentsPublish = challengCommentsPublish;
	}

	/**
	 * @return the challengImpact
	 */
	public String getChallengImpact() {
		return challengImpact;
	}

	/**
	 * @param challengImpact the challengImpact to set
	 */
	public void setChallengImpact(String challengImpact) {
		this.challengImpact = challengImpact;
	}

	/**
	 * @return the challengIsIncentiv
	 */
	public String getChallengIsIncentiv() {
		return challengIsIncentiv;
	}

	/**
	 * @param challengIsIncentiv the challengIsIncentiv to set
	 */
	public void setChallengIsIncentiv(String challengIsIncentiv) {
		this.challengIsIncentiv = challengIsIncentiv;
	}

	/**
	 * @return the challengSourceFund
	 */
	public String getChallengSourceFund() {
		return challengSourceFund;
	}

	/**
	 * @param challengSourceFund the challengSourceFund to set
	 */
	public void setChallengSourceFund(String challengSourceFund) {
		this.challengSourceFund = challengSourceFund;
	}

	/**
	 * @return the challengDelivExpctatn
	 */
	public String getChallengDelivExpctatn() {
		return challengDelivExpctatn;
	}

	/**
	 * @param challengDelivExpctatn the challengDelivExpctatn to set
	 */
	public void setChallengDelivExpctatn(String challengDelivExpctatn) {
		this.challengDelivExpctatn = challengDelivExpctatn;
	}

	/**
	 * @return the challengBenchmark
	 */
	public String getChallengBenchmark() {
		return challengBenchmark;
	}

	/**
	 * @param challengBenchmark the challengBenchmark to set
	 */
	public void setChallengBenchmark(String challengBenchmark) {
		this.challengBenchmark = challengBenchmark;
	}

	/**
	 * @return the challengTypeDesc
	 */
	public String getChallengTypeDesc() {
		return challengTypeDesc;
	}

	/**
	 * @param challengTypeDesc the challengTypeDesc to set
	 */
	public void setChallengTypeDesc(String challengTypeDesc) {
		this.challengTypeDesc = challengTypeDesc;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}





	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
