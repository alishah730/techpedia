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
 * @author geetanjali
 *
 */
@Entity
@Table(name="TB_TECH001_TXN_CHALLNG_TEAM")
public class ChallengeTeamTxn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1405849269185791930L;
	

	@Id
	@Column(name="PROJ_ID")
	private long projId;
	
	@Id
	@Column(name="REGSTR_ID")
	private long regstrId;
	
	@Id
	@Column(name="PROJ_TEAM_ID")
	private long projTeamId;
	
	@Id
	@Column(name="CHALLENG_ID")
	private long challengId;
	
	/**
	 * @param projId
	 * @param regstrId
	 * @param projTeamId
	 * @param challengId 
	 */
   
	public ChallengeTeamTxn(long projId, 
			                long regstrId, 
			                long projTeamId,
			                long challengId) {
		this.projId = projId;
		this.regstrId = regstrId;
		this.projTeamId = projTeamId;
		this.challengId = challengId;
	}

	public ChallengeTeamTxn() {
		
	}

	/**
	 * @return the ProjId
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
	 * @return the ChallengId
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (challengId ^ (challengId >>> 32));
		result = prime * result + (int) (projId ^ (projId >>> 32));
		result = prime * result + (int) (projTeamId ^ (projTeamId >>> 32));
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
		ChallengeTeamTxn other = (ChallengeTeamTxn) obj;
		if (challengId != other.challengId)
			return false;
		if (projId != other.projId)
			return false;
		if (projTeamId != other.projTeamId)
			return false;
		if (regstrId != other.regstrId)
			return false;
		return true;
	}

}
