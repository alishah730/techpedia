package com.techpedia.bean;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class AddReviewer {
	private long revRgstrId;
	private String revEmailId;
	private String revUsrId;
	private String revFname;
	private String revMname;
	private String revLname;
	private String revSex;
	private String revState;
	private String revCity;
	private String revMobileNo;
	private String revAlternateNo;
	private String revOrgName;
	private String revDesignation;
	private String revSpeciality;
	private String revPassword;
	private String revStatus;
	/**
	 * @return the revStatus
	 */
	@JsonIgnore
	public String getRevStatus() {
		return revStatus;
	}
	/**
	 * @param revStatus the revStatus to set
	 */
	public void setRevStatus(String revStatus) {
		this.revStatus = revStatus;
	}
	private Date revCreatedDate;
	private Date revLastLoginDate;
	private String revRegType;
	/**
	 * @return the revCreatedDate
	 */
	@JsonIgnore
	public Date getRevCreatedDate() {
		return revCreatedDate;
	}
	/**
	 * @param revCreatedDate the revCreatedDate to set
	 */
	public void setRevCreatedDate(Date revCreatedDate) {
		this.revCreatedDate = revCreatedDate;
	}
	/**
	 * @return the revLastLoginDate
	 */
	@JsonIgnore
	public Date getRevLastLoginDate() {
		return revLastLoginDate;
	}
	/**
	 * @param revLastLoginDate the revLastLoginDate to set
	 */
	@JsonIgnore
	public void setRevLastLoginDate(Date revLastLoginDate) {
		this.revLastLoginDate = revLastLoginDate;
	}
	/**
	 * @return the revRegType
	 */
	@JsonIgnore
	public String getRevRegType() {
		return revRegType;
	}
	/**
	 * @param revRegType the revRegType to set
	 */
	public void setRevRegType(String revRegType) {
		this.revRegType = revRegType;
	}
	private List<String> branchIds;
	private String branchIdString;
	
	
	
	/**
	 * @return the revPassword
	 */
	@JsonIgnore
	public String getRevPassword() {
		return revPassword;
	}
	/**
	 * @param revPassword the revPassword to set
	 */
	public void setRevPassword(String revPassword) {
		this.revPassword = revPassword;
	}
	/**
	 * @return the revRgstrId
	 */
	public long getRevRgstrId() {
		return revRgstrId;
	}
	/**
	 * @param revRgstrId the revRgstrId to set
	 */
	public void setRevRgstrId(long revRgstrId) {
		this.revRgstrId = revRgstrId;
	}
	public String getRevEmailId() {
		return revEmailId;
	}
	public void setRevEmailId(String revEmailId) {
		this.revEmailId = revEmailId;
	}
	public String getRevUsrId() {
		return revUsrId;
	}
	public void setRevUsrId(String revUsrId) {
		this.revUsrId = revUsrId;
	}
	public String getRevFname() {
		return revFname;
	}
	public void setRevFname(String revFname) {
		this.revFname = revFname;
	}
	public String getRevMname() {
		return revMname;
	}
	public void setRevMname(String revMname) {
		this.revMname = revMname;
	}
	public String getRevLname() {
		return revLname;
	}
	public void setRevLname(String revLname) {
		this.revLname = revLname;
	}
	public String getRevSex() {
		return revSex;
	}
	public void setRevSex(String revSex) {
		this.revSex = revSex;
	}
	public String getRevState() {
		return revState;
	}
	public void setRevState(String revState) {
		this.revState = revState;
	}
	public String getRevCity() {
		return revCity;
	}
	public void setRevCity(String revCity) {
		this.revCity = revCity;
	}
	public String getRevMobileNo() {
		return revMobileNo;
	}
	public void setRevMobileNo(String revMobileNo) {
		this.revMobileNo = revMobileNo;
	}
	public String getRevAlternateNo() {
		return revAlternateNo;
	}
	public void setRevAlternateNo(String revAlternateNo) {
		this.revAlternateNo = revAlternateNo;
	}
	public String getRevOrgName() {
		return revOrgName;
	}
	public void setRevOrgName(String revOrgName) {
		this.revOrgName = revOrgName;
	}
	public String getRevDesignation() {
		return revDesignation;
	}
	public void setRevDesignation(String revDesignation) {
		this.revDesignation = revDesignation;
	}
	public String getRevSpeciality() {
		return revSpeciality;
	}
	public void setRevSpeciality(String revSpeciality) {
		this.revSpeciality = revSpeciality;
	}
	public List<String> getBranchIds() {
		return branchIds;
	}
	public void setBranchIds(List<String> branchIds) {
		this.branchIds = branchIds;
	}
	@JsonIgnore
	public String getBranchIdString() {
		return branchIdString;
	}
	public void setBranchIdString(String branchIdString) {
		this.branchIdString = branchIdString;
	}
	@Override
	public String toString() {
		return "AddReviewer [revEmailId=" + revEmailId + ", revUsrId=" + revUsrId + ", revFname=" + revFname
				+ ", revMname=" + revMname + ", revLname=" + revLname + ", revSex=" + revSex + ", revState=" + revState
				+ ", revCity=" + revCity + ", revMobileNo=" + revMobileNo + ", revAlternateNo=" + revAlternateNo
				+ ", revOrgName=" + revOrgName + ", revDesignation=" + revDesignation + ", revSpeciality="
				+ revSpeciality + ", branchIds=" + branchIds + "]";
	}
}