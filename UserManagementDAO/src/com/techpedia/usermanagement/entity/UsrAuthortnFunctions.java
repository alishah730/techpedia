package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usr_authortn_functions")
public class UsrAuthortnFunctions {
	
	

	@Id
	@GeneratedValue
	@Column (name = "FUN_ID")
	private int funId;
	
	@Column (name = "FUN_NAME")
	private String funName;
	
	@Column (name = "FUN_DESCRIPTION")
	private String funDescription;

	/**
	 * @return the funId
	 */
	public int getFunId() {
		return funId;
	}

	/**
	 * @param funId the funId to set
	 */
	public void setFunId(int funId) {
		this.funId = funId;
	}

	/**
	 * @return the funName
	 */
	public String getFunName() {
		return funName;
	}

	/**
	 * @param funName the funName to set
	 */
	public void setFunName(String funName) {
		this.funName = funName;
	}

	/**
	 * @return the funDescription
	 */
	public String getFunDescription() {
		return funDescription;
	}

	/**
	 * @param funDescription the funDescription to set
	 */
	public void setFunDescription(String funDescription) {
		this.funDescription = funDescription;
	}

	public UsrAuthortnFunctions(int funId, String funName, String funDescription) {
		super();
		this.funId = funId;
		this.funName = funName;
		this.funDescription = funDescription;
	}

	public UsrAuthortnFunctions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
