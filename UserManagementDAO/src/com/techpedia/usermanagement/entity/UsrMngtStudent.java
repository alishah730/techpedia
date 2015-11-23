package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_STUDENT")
public class UsrMngtStudent {

	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "DEGREE")
	private String degree;
	 
	@Column(name = "COLLEGE")
	private String college;
	 
	@Column(name = "UNIVERSITY")
	private String university;
	
	@Column(name = "ENROLLMENT_NO")
	private String enrollmentNo;
	 
	@Column(name = "YEAR_OF_PASS")
	private String yearOfPass;

	@Column(name = "BRANCH_ID")
	private String branchId;
	/**
	 * 
	 */
	public UsrMngtStudent() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the enrollmentNo
	 */
	public String getEnrollmentNo() {
		return enrollmentNo;
	}

	/**
	 * @param enrollmentNo the enrollmentNo to set
	 */
	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	/**
	 * @return the yearOfPass
	 */
	public String getYearOfPass() {
		return yearOfPass;
	}

	/**
	 * @param yearOfPass the yearOfPass to set
	 */
	public void setYearOfPass(String yearOfPass) {
		this.yearOfPass = yearOfPass;
	}

	

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public UsrMngtStudent(long rgstrId, String degree, String college,
			String university, String enrollmentNo, String yearOfPass,
			String branchId) {
		super();
		this.rgstrId = rgstrId;
		this.degree = degree;
		this.college = college;
		this.university = university;
		this.enrollmentNo = enrollmentNo;
		this.yearOfPass = yearOfPass;
		this.branchId = branchId;
	}

	
	
}
