package com.techpedia.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_UNIVERSITY_MASTER")
public class UsrUniversityMaster {

	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "University_ID")
	private String uId;
		
	@Column(name = "University_Name")
	private String uName;
	
	public UsrUniversityMaster(String uId, String uName) {
		super();
		this.uId = uId;
		this.uName = uName;		
	}

	public UsrUniversityMaster() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "UsrUniversityMaster [uId=" + uId + ", uName=" + uName +"]";
	}

}
