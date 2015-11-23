package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usr_authortn_roles")
public class UsrAuthortnRoles {
	
	@Id
	@GeneratedValue
	@Column (name = "ROLE_ID")
	private int roleId;

	@Column (name = "ROLE_NAME")
	private String roleName;
	
	@Column (name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	@Column (name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column (name = "FUN_IDS")
	private String funIds;

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the funIds
	 */
	public String getFunIds() {
		return funIds;
	}

	/**
	 * @param funIds the funIds to set
	 */
	public void setFunIds(String funIds) {
		this.funIds = funIds;
	}

	public UsrAuthortnRoles(int roleId, String roleName,
			String roleDescription, Boolean isActive, String funIds) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.isActive = isActive;
		this.funIds = funIds;
	}

	
	public UsrAuthortnRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrAuthortnRoles [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDescription=" + roleDescription + ", isActive="
				+ isActive + ", funIds=" + funIds + "]";
	}
	
	
	

}
