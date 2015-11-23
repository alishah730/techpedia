package com.techpedia.usermanagement.dataobject;

import java.util.List;
import java.util.Map;

import com.techpedia.usermanagement.entity.UsrAssignAuthortnRolesToUsrs;

public class UsrAccessDetails {
	
	//Jai Sriram and Jai Sri Gurudatta
	
	//Roles and Pages/Functions
	Map<String, List<String>> roleVsFunctions;
	
	List<String> noOfRoles;

	/**
	 * @return the roleVsFunctions
	 */
	public Map<String, List<String>> getRoleVsFunctions() {
		return roleVsFunctions;
	}

	/**
	 * @param roleVsFunctions the roleVsFunctions to set
	 */
	public void setRoleVsFunctions(Map<String, List<String>> roleVsFunctions) {
		this.roleVsFunctions = roleVsFunctions;
	}

	public UsrAccessDetails(Map<String, List<String>> roleVsFunctions) {
		super();
		this.roleVsFunctions = roleVsFunctions;
	}



	public UsrAccessDetails() {
		super();
	}

	/**
	 * @return the noOfRoles
	 */
	public List<String> getNoOfRoles() {
		return noOfRoles;
	}

	/**
	 * @param noOfRoles the noOfRoles to set
	 */
	public void setNoOfRoles(List<String> noOfRoles) {
		this.noOfRoles = noOfRoles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrAccessDetails [roleVsFunctions=" + roleVsFunctions
				+ ", noOfRoles=" + noOfRoles + "]";
	}
	
	
	
	
}
