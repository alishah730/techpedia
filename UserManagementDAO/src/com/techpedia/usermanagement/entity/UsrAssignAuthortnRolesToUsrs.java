package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="usr_assign_authortn_roles_to_usrs")
public class UsrAssignAuthortnRolesToUsrs {
	
	@Id
	@GeneratedValue
	@Column (name= "SEQ_ID")
	private int seqId;
	
	@Column (name = "RGSTR_ID")
	private long rgstrId;
	
	@Column (name = "ROLE_ID")
	private int roleId;
	
	@Column (name = "ROLE_NAME")
	private String roleName;

	/**
	 * @return the seqId
	 */
	public int getSeqId() {
		return seqId;
	}

	/**
	 * @param seqId the seqId to set
	 */
	public void setSeqId(int seqId) {
		this.seqId = seqId;
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

	public UsrAssignAuthortnRolesToUsrs()
	{
		
	}

	public UsrAssignAuthortnRolesToUsrs(int seqId, long rgstrId, int roleId,
			String roleName) {
		super();
		this.seqId = seqId;
		this.rgstrId = rgstrId;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	
}
