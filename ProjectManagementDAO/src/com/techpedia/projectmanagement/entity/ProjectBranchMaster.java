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
@Table(name="TB_TECH001_MAST_PROJECTS_BRNCH")
public class ProjectBranchMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -514499002610485722L;

	@Id
	@Column(name="PROJ_ID")
	private long projId;
	
	@Id
	@Column(name="PROJ_BRANCH_ID")
	private int projBranchId;

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
	 * @return the projBranchId
	 */
	public int getProjBranchId() {
		return projBranchId;
	}

	/**
	 * @param projBranchId the projBranchId to set
	 */
	public void setProjBranchId(int projBranchId) {
		this.projBranchId = projBranchId;
	}

	/**
	 * 
	 */
	public ProjectBranchMaster() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + projBranchId;
		result = prime * result + (int) (projId ^ (projId >>> 32));
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
		ProjectBranchMaster other = (ProjectBranchMaster) obj;
		if (projBranchId != other.projBranchId)
			return false;
		if (projId != other.projId)
			return false;
		return true;
	}
	
}
