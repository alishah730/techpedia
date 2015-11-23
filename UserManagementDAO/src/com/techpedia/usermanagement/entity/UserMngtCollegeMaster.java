package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_COLLEGE_MASTER")
public class UserMngtCollegeMaster {
	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "COLG_ID")
	private int collegeID;
	
	@Column(name = "COLLEGE_NAME")
	private String collegeName;

	@Column(name = "COLLEGE_DESC")
	private String collegeDesc;

	
	/**
	 * @return the collegeID
	 */
	public int getCollegeID() {
		return collegeID;
	}


	/**
	 * @param collegeID the collegeID to set
	 */
	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}


	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}


	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	/**
	 * @return the collegeDesc
	 */
	public String getCollegeDesc() {
		return collegeDesc;
	}


	/**
	 * @param collegeDesc the collegeDesc to set
	 */
	public void setCollegeDesc(String collegeDesc) {
		this.collegeDesc = collegeDesc;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserMngtCollegeMaster [collegeID=" + collegeID
				+ ", collegeName=" + collegeName + ", collegeDesc="
				+ collegeDesc + "]";
	}


	public UserMngtCollegeMaster(String collegeName, String collegeDesc) {
		super();
		this.collegeName = collegeName;
		this.collegeDesc = collegeDesc;
	}


	/**
	 * 
	 */
	public UserMngtCollegeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*public UserMngtCollegeMaster(long collegeID, String collegeName,
			String collegeDesc) {
		super();
		this.collegeID = collegeID;
		this.collegeName = collegeName;
		this.collegeDesc = collegeDesc;
	}*/

}
