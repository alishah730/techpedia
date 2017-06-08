package com.techpedia.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr_mngt_college_master")
public class UsrCollegeMaster {
	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "COLG_ID")
	private long colgId;
		
	@Column(name = "College_Name")
	private String collegeName;
	
	@Column(name = "College_Desc")
	private String collegeDesc;
	
	@Column(name = "STATE_ID")
	private long stateId;
	
	

	/**
	 * @param colgId
	 * @param collegeName
	 * @param collegeDesc
	 * @param stateId
	 */
	public UsrCollegeMaster(long colgId, String collegeName,
			String collegeDesc, long stateId) {
		super();
		this.colgId = colgId;
		this.collegeName = collegeName;
		this.collegeDesc = collegeDesc;
		this.stateId = stateId;
	}

	public UsrCollegeMaster() {
		super();
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrCollegeMaster [colgId=" + colgId + ", collegeName="
				+ collegeName + ", collegeDesc=" + collegeDesc + ", stateId="
				+ stateId + "]";
	}
	
	
}
