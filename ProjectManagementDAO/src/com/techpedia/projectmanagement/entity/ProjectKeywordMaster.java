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
@Table(name="TB_TECH001_MAST_PROJECTS_KEYWRD")
public class ProjectKeywordMaster implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3891301085359088781L;

	@Id
	@Column(name="PROJ_ID")
	private long projId;
	
	@Id
	@Column(name="PROJ_KEYWORD")
	private String projKeyword;

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
	 * @return the projKeyword
	 */
	public String getProjKeyword() {
		return projKeyword;
	}

	/**
	 * @param projKeyword the projKeyword to set
	 */
	public void setProjKeyword(String projKeyword) {
		this.projKeyword = projKeyword;
	}

	/**
	 * 
	 */
	public ProjectKeywordMaster() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (projId ^ (projId >>> 32));
		result = prime * result
				+ ((projKeyword == null) ? 0 : projKeyword.hashCode());
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
		ProjectKeywordMaster other = (ProjectKeywordMaster) obj;
		if (projId != other.projId)
			return false;
		if (projKeyword == null) {
			if (other.projKeyword != null)
				return false;
		} else if (!projKeyword.equals(other.projKeyword))
			return false;
		return true;
	}

}
