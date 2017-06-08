/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Date;

/**
 * @author 455959
 *
 */
public class UsrMngtStudentVO {
	private long rgstrId;
	private String degree;
	private String college;
	private String university;
	private String enrollmentNo;
	private Date yearOfPass;
	private String branchId;
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
	public Date getYearOfPass() {
		return yearOfPass;
	}
	/**
	 * @param yearOfPass the yearOfPass to set
	 */
	public void setYearOfPass(Date yearOfPass) {
		this.yearOfPass = yearOfPass;
	}
	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
}
