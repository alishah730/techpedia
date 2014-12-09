/**
 * 
 */
package com.techpedia.projectmanagement.entity;

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
@Table(name="TB_TECH001_MAST_CHALLENG_TYPE")
public class ChallengeTypeMaster {
	
	@Id
	@GeneratedValue
	@Column(name="CHALLENG_TYPE_ID")
	private int challengTypeId;
	
	@Column(name="CHALLENG_TYPE_DESC")
	private String challengTypeDesc;

	/**
	 * @param challengTypeDesc
	 */
	public ChallengeTypeMaster(String challengTypeDesc) {
		this.challengTypeDesc = challengTypeDesc;
	}
	
	public ChallengeTypeMaster(){
		
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
}
