package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentorDetails {
	
	
	@Id
	@Column (name = "RGSTR_ID")
	private long rgstrId;
	
	@Column (name = "FNAME")
	private String fName;
	
	@Column (name = "LNAME")
	private String lName;
	
	@Column (name = "MNAME")
	private String mName;
	
	@Column (name = "PHOTO")
	private String photo;

	@Column (name = "DEGREE")
	private String degree;
	
	@Column (name = "DESIGNATION")
	private String designation;
	
	@Column (name = "PRO_EXPERIENCE")
	private String experience;
	
	@Column (name = "INSTITUTIONAL_ASSCTN_INFO")
	private String assctnInfo;
	
	@Column (name = "INT_ON_GRASSRT_INNOVATORS")
	private String interest;
	
	@Column (name = "COMMITMENT_U_BRING_IN")
	private String commintment;
	
	
	
	
	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * @return the assctnInfo
	 */
	public String getAssctnInfo() {
		return assctnInfo;
	}

	/**
	 * @param assctnInfo the assctnInfo to set
	 */
	public void setAssctnInfo(String assctnInfo) {
		this.assctnInfo = assctnInfo;
	}

	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * @return the commintment
	 */
	public String getCommintment() {
		return commintment;
	}

	/**
	 * @param commintment the commintment to set
	 */
	public void setCommintment(String commintment) {
		this.commintment = commintment;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the mName
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * @param mName the mName to set
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}


	

}
