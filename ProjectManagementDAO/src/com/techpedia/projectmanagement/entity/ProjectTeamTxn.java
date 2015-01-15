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
 * @author nishikant.singh
 *
 */
@Entity
@Table(name="TB_TECH001_TXN_PROJECTS_TEAM")
public class ProjectTeamTxn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1908478067603264779L;

	@Id
	@Column(name="PROJ_ID")
	private long projId;
	
	@Id
	@Column(name="REGSTR_ID")
	private long regstrId;
	
	@Id
	@Column(name="TEAM_ID")
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
	
	public ProjectTeamTxn() {}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (projId ^ (projId >>> 32));
		result = prime * result + (int) (regstrId ^ (regstrId >>> 32));
		result = prime * result + (int) (teamId ^ (teamId >>> 32));
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
		ProjectTeamTxn other = (ProjectTeamTxn) obj;
		if (projId != other.projId)
			return false;
		if (regstrId != other.regstrId)
			return false;
		if (teamId != other.teamId)
			return false;
		return true;
	}
	
	
	
	
}
