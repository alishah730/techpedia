package com.techpedia.usermanagement.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the trs_reviewer_mast_details database table.
 * 
 */
@Entity
@Table(name="trs_reviewer_mast_details")
@NamedQuery(name="TrsReviewerMastDetail.findAll", query="SELECT t FROM TrsReviewerMastDetail t")
public class TrsReviewerMastDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REV_RGSTR_ID")
	private int revRgstrId;

	@Column(name="REV_ALTERNATE_NO")
	private String revAlternateNo;

	@Column(name="REV_CITY")
	private String revCity;

	@Column(name="REV_CREATED_DATE")
	private Timestamp revCreatedDate;

	@Column(name="REV_DESIGNATION")
	private String revDesignation;

	@Column(name="REV_EMAIL_ID")
	private String revEmailId;

	@Column(name="REV_FNAME")
	private String revFname;

	@Column(name="REV_LAST_LOGIN_DATE")
	private Timestamp revLastLoginDate;

	@Column(name="REV_LNAME")
	private String revLname;

	@Column(name="REV_MNAME")
	private String revMname;

	@Column(name="REV_MOBILE_NO")
	private String revMobileNo;

	@Column(name="REV_ORG_NAME")
	private String revOrgName;

	@Column(name="REV_PASSWORD")
	private String revPassword;

	@Column(name="REV_REG_TYPE")
	private String revRegType;

	@Column(name="REV_SEX")
	private String revSex;

	@Column(name="REV_SPECIALITY")
	private String revSpeciality;

	@Column(name="REV_STATE")
	private String revState;

	@Column(name="REV_STATUS")
	private String revStatus;

	@Column(name="REV_USR_ID")
	private String revUsrId;

	public TrsReviewerMastDetail() {
	}

	public int getRevRgstrId() {
		return this.revRgstrId;
	}

	public void setRevRgstrId(int revRgstrId) {
		this.revRgstrId = revRgstrId;
	}

	public String getRevAlternateNo() {
		return this.revAlternateNo;
	}

	public void setRevAlternateNo(String revAlternateNo) {
		this.revAlternateNo = revAlternateNo;
	}

	public String getRevCity() {
		return this.revCity;
	}

	public void setRevCity(String revCity) {
		this.revCity = revCity;
	}

	public Timestamp getRevCreatedDate() {
		return this.revCreatedDate;
	}

	public void setRevCreatedDate(Timestamp revCreatedDate) {
		this.revCreatedDate = revCreatedDate;
	}

	public String getRevDesignation() {
		return this.revDesignation;
	}

	public void setRevDesignation(String revDesignation) {
		this.revDesignation = revDesignation;
	}

	public String getRevEmailId() {
		return this.revEmailId;
	}

	public void setRevEmailId(String revEmailId) {
		this.revEmailId = revEmailId;
	}

	public String getRevFname() {
		return this.revFname;
	}

	public void setRevFname(String revFname) {
		this.revFname = revFname;
	}

	public Timestamp getRevLastLoginDate() {
		return this.revLastLoginDate;
	}

	public void setRevLastLoginDate(Timestamp revLastLoginDate) {
		this.revLastLoginDate = revLastLoginDate;
	}

	public String getRevLname() {
		return this.revLname;
	}

	public void setRevLname(String revLname) {
		this.revLname = revLname;
	}

	public String getRevMname() {
		return this.revMname;
	}

	public void setRevMname(String revMname) {
		this.revMname = revMname;
	}

	public String getRevMobileNo() {
		return this.revMobileNo;
	}

	public void setRevMobileNo(String revMobileNo) {
		this.revMobileNo = revMobileNo;
	}

	public String getRevOrgName() {
		return this.revOrgName;
	}

	public void setRevOrgName(String revOrgName) {
		this.revOrgName = revOrgName;
	}

	public String getRevPassword() {
		return this.revPassword;
	}

	public void setRevPassword(String revPassword) {
		this.revPassword = revPassword;
	}

	public String getRevRegType() {
		return this.revRegType;
	}

	public void setRevRegType(String revRegType) {
		this.revRegType = revRegType;
	}

	public String getRevSex() {
		return this.revSex;
	}

	public void setRevSex(String revSex) {
		this.revSex = revSex;
	}

	public String getRevSpeciality() {
		return this.revSpeciality;
	}

	public void setRevSpeciality(String revSpeciality) {
		this.revSpeciality = revSpeciality;
	}

	public String getRevState() {
		return this.revState;
	}

	public void setRevState(String revState) {
		this.revState = revState;
	}

	public String getRevStatus() {
		return this.revStatus;
	}

	public void setRevStatus(String revStatus) {
		this.revStatus = revStatus;
	}

	public String getRevUsrId() {
		return this.revUsrId;
	}

	public void setRevUsrId(String revUsrId) {
		this.revUsrId = revUsrId;
	}

}