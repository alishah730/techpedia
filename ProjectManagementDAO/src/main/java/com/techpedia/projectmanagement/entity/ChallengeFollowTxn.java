/**
 * 
 */
package com.techpedia.projectmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author charan teja
 *
 */
@Entity
@Table(name="tb_tech001_txn_challeng_follow")
public class ChallengeFollowTxn implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6328869997998032572L;

	@Id
	@Column(name="challeng_Id")
	private long challengId;
	
	@Id
	@Column(name="Regstr_Id")
	private long regstrId;
	

  public ChallengeFollowTxn(long challengId, long regstrId) {
		
		this.challengId = challengId;
		this.regstrId = regstrId;
	}
	
   public ChallengeFollowTxn() {
		
	}
	


	public long getChallengId() {
	return challengId;
}

public void setChallengId(long challengId) {
	this.challengId = challengId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (challengId ^ (challengId >>> 32));
		result = prime * result + (int) (regstrId ^ (regstrId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChallengeFollowTxn other = (ChallengeFollowTxn) obj;
		if (challengId != other.challengId)
			return false;
		if (regstrId != other.regstrId)
			return false;
		return true;
	}
	
}
