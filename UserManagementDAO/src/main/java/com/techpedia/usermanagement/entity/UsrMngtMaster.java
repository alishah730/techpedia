package com.techpedia.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_MASTER")
public class UsrMngtMaster {

	
	@Id   //@GeneratedValue
	@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "FNAME")
	private String pFname;
	 
	@Column(name = "MNAME")
	private String mName;
	 
	@Column(name = "LNAME")
	private String lName;
	 
	@Column(name = "DOB")
	private String dOb;
	 
	@Column(name = "IS_ACTIVE")
	private String iSactive;
	 
	@Column(name = "CAPTCHA_VERIFICATION")
	private String cVerify;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "USR_ID")
	private String userId;
	
	@Column(name = "FB_ID")
	private String fbId;
	
	@Column(name = "RGSTR_DATE")
	private String rgstrDate;
	
	@Column(name = "ACTIVATED_DATE")
	private Date activatedDate;
	
	@Column(name = "EMAIL_ID")
	private String email;
	
	@Column(name = "TWITTER_ID")
	private String twitterId;
	
	@Column(name = "LINKEDIN_ID")
	private String linkedinId;
	
	@Column(name = "ISMOBILE")
	private String isMobile;

	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "AGE")
	private String age;
	

	/**
	 * @param rgstrId
	 * @param pFname
	 * @param mName
	 * @param lName
	 * @param dOb
	 * @param iSactive
	 * @param cVerify
	 * @param type
	 * @param userId
	 * @param fbId
	 * @param rgstrDate
	 * @param activatedDate
	 * @param email
	 * @param twitterId
	 * @param linkedinId
	 */
	public UsrMngtMaster(String pFname, String mName,
			String lName, String dOb, String iSactive, String cVerify,
			String type, String userId, String fbId, String rgstrDate,
			Date activatedDate, String email, String twitterId, String linkedinId,String isMobile,String gender,String age) {
		super();
		this.pFname = pFname;
		this.mName = mName;
		this.lName = lName;
		this.dOb = dOb;
		this.iSactive = iSactive;
		this.cVerify = cVerify;
		this.type = type;
		this.userId = userId;
		this.fbId = fbId;
		this.rgstrDate = rgstrDate;
		this.activatedDate = activatedDate;
		this.email = email;
		this.twitterId = twitterId;
		this.linkedinId = linkedinId;
		this.isMobile = isMobile;
		this.gender = gender;
		this.age = age;
	}
	
	


	/**
	 * 
	 */
	public UsrMngtMaster() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getTwitterId() {
		return twitterId;
	}




	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}




	public String getLinkedinId() {
		return linkedinId;
	}




	public void setLinkedinId(String linkedinId) {
		this.linkedinId = linkedinId;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public long getRgstrId() {
		return rgstrId;
	}
	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}
	public String getpFname() {
		return pFname;
	}
	public void setpFname(String pFname) {
		this.pFname = pFname;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getdOb() {
		return dOb;
	}
	public void setdOb(String dOb) {
		this.dOb = dOb;
	}
	public String getiSactive() {
		return iSactive;
	}
	public void setiSactive(String iSactive) {
		this.iSactive = iSactive;
	}
	public String getcVerify() {
		return cVerify;
	}
	public void setcVerify(String cVerify) {
		this.cVerify = cVerify;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getRgstrDate() {
		return rgstrDate;
	}
	public void setRgstrDate(String rgstrDate) {
		this.rgstrDate = rgstrDate;
	}
	public Date getActivatedDate() {
		return activatedDate;
	}
	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}
	/**
	 * @return the isMobile
	 */
	public String getIsMobile() {
		return isMobile;
	}
	/**
	 * @param isMobile the isMobile to set
	 */
	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}




	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtMaster [rgstrId=" + rgstrId + ", pFname=" + pFname
				+ ", mName=" + mName + ", lName=" + lName + ", dOb=" + dOb
				+ ", iSactive=" + iSactive + ", cVerify=" + cVerify + ", type="
				+ type + ", userId=" + userId + ", twitterId=" + twitterId + ", linkedinId=" + linkedinId + 
				",fbId=" + fbId + ", rgstrDate=" + rgstrDate + ", activatedDate="
				+ activatedDate + ", email=" + email +",isMobile="+isMobile
				+ ", twitterId=" + twitterId + ", linkedinId=" + linkedinId + "]";
	}
	

}
