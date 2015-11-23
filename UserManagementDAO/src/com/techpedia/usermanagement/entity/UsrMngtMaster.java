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
	 */
	public UsrMngtMaster(String pFname, String mName,
			String lName, String dOb, String iSactive, String cVerify,
			String type, String userId, String fbId, String rgstrDate,
			Date activatedDate, String email) {
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
	}
	
	


	/**
	 * 
	 */
	public UsrMngtMaster() {
		super();
		// TODO Auto-generated constructor stub
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




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtMaster [rgstrId=" + rgstrId + ", pFname=" + pFname
				+ ", mName=" + mName + ", lName=" + lName + ", dOb=" + dOb
				+ ", iSactive=" + iSactive + ", cVerify=" + cVerify + ", type="
				+ type + ", userId=" + userId + ", fbId=" + fbId
				+ ", rgstrDate=" + rgstrDate + ", activatedDate="
				+ activatedDate + ", email=" + email + "]";
	}
	

}
