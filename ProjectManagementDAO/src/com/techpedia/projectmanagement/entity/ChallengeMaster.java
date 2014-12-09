/**
 * 
 */
package com.techpedia.projectmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author geetanjali
 *
 */
@Entity
@Table(name="TB_TECH001_MAST_CHALLENG_DETAIL")
public class ChallengeMaster {
	
	@Id
	@GeneratedValue
	@Column(name="CHALLENG_ID")
	private long challengId;
	
	@Column(name="CHALLENG_TYPE_ID")
	private int challengTypeId;
	
	@Column(name="CHALLENG_TITLE")
	private String challengTitle; 
	
	@Column(name="CHALLENG_ABSTRACT")
	private String challengAbstract; 
	
	@Column(name="CHALLENG_DESCRIPTION")
	private String challengDescription;
	
	@Column (name="RGSTR_ID")
	private long rgstrId;
	
	@Column(name="CHALLENG_YEAR")
	private int challengYear; 
	
	@Column(name="CHALLENG_START_DATE")
	private Date challengStartDate; 
	
	@Column(name="CHALLENG_CLOSE_DATE")
	private Date challengCloseDate; 
	
	@Column(name="IS_CHALLENG_ACTIVE")
	private String isChallengActive;
	
	@Column(name="IS_CHALLENG_SUCCESS")
	private String isChallengSuccess;
	
	@Column(name="CHALLENG_COMMENTS_PUBLISH")
	private String challengCommentsPublish;

	@Column (name="CHALLENG_IMPACT")
	private String challengImpact;
	
	@Column (name="CHALLENG_IS_INCENTIV")
	private String challengIsIncentiv;
	
	@Column (name="CHALLENG_SOURC_FUND")
	private String challengSourceFund;	
	
	@Column (name="CHALLENG_DELIV_EXPCTATN")
	private String challengDelivExpctatn;
	
	@Column (name="CHALLENG_BENCHMARK")
	private String challengBenchmark;

	/**
	 * @param challengId
	 * @param challengTypeId
	 * @param challengTitle
	 * @param challengAbstract
	 * @param challengDescription
	 * @param rgstrId
	 * @param challengYear
	 * @param challengStartDate
	 * @param challengCloseDate
     * @param isChallengActive
     * @param isChallengSuccess
     * @param challengCommentsPublish
     * @param challengImpact
     * @param challengIsIncentiv
     * @param challengSourceFund
     * @param challengDelivExpctatn
     * @param challengBenchmark
  
	 */
	 
	public ChallengeMaster(int challengTypeId,
			String challengTitle,
			String challengAbstract,
			String challengDescription,
			long rgstrId,
			int challengYear,
			Date challengStartDate,
			Date challengCloseDate, 
			String isChallengActive,
			String isChallengSuccess,
			String challengCommentsPublish,
			String challengImpact,
			String challengIsIncentiv,
			String challengSourceFund,
			String challengDelivExpctatn,
			String challengBenchmark) {
		
			
			this.challengTypeId = challengTypeId;
			this.challengTitle = challengTitle;
			this.challengAbstract = challengAbstract;
			this.challengDescription = challengDescription;
			this.rgstrId = rgstrId;
			this.challengYear = challengYear;
			this.challengStartDate = challengStartDate;
			this.challengCloseDate = challengCloseDate;
			this.isChallengActive  = isChallengActive;
			this.isChallengSuccess = isChallengSuccess;
			this.challengCommentsPublish = challengCommentsPublish;	
			this.challengImpact = challengImpact;
			this.challengIsIncentiv = challengIsIncentiv;
			this.challengSourceFund = challengSourceFund;			
			this.challengDelivExpctatn = challengDelivExpctatn;
			this.challengBenchmark = challengBenchmark;
				
	}
	
	public ChallengeMaster() {
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
	public Date getChallengStartDate() {
		return challengStartDate;
	}

	/**
	 * @param challengStartDate the challengStartDate to set
	 */
	public void setChallengStartDate(Date challengStartDate) {
		this.challengStartDate = challengStartDate;
	}

	/**
	 * @return the challengCloseDate
	 */
	public Date getChallengCloseDate() {
		return challengCloseDate;
	}

	/**
	 * @param challengCloseDate the challengCloseDate to set
	 */
	public void setChallengCloseDate(Date challengCloseDate) {
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

	
}