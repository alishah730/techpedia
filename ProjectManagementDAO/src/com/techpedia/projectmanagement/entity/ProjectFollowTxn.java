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
@Table(name="tb_tech001_txn_projects_follow")
public class ProjectFollowTxn implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6328869997998032572L;

	@Id
	@Column(name="PROJ_ID")
	private long projId;
	
	@Id
	@Column(name="REGSTR_ID")
	private long regstrId;
	

  public ProjectFollowTxn(long projId, long regstrId) {
		
		this.projId = projId;
		this.regstrId = regstrId;
	}
	
   public ProjectFollowTxn() {
		
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
		result = prime * result + (int) (projId ^ (projId >>> 32));
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
		ProjectFollowTxn other = (ProjectFollowTxn) obj;
		if (projId != other.projId)
			return false;
		if (regstrId != other.regstrId)
			return false;
		return true;
	}
	
}
