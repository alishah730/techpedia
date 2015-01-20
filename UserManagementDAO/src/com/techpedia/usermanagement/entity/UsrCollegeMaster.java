package com.techpedia.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_College_MASTER")
public class UsrCollegeMaster {
	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "College_ID")
	private String cId;
		
	@Column(name = "College_Name")
	private String cName;
	
	public UsrCollegeMaster(String cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;		
	}

	public UsrCollegeMaster() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "UsrCollegeMaster [cId=" + cId + ", cName=" + cName +"]";
	}

}
