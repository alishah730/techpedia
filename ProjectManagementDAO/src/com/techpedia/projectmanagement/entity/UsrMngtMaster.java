package com.techpedia.projectmanagement.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USR_MNGT_MASTER")
public class UsrMngtMaster
{

  @Id
  @GeneratedValue
  @Column(name="RGSTR_ID")
  private long rgstrId;

  @Column(name="FNAME")
  private String pFname;

  @Column(name="MNAME")
  private String mName;

  @Column(name="LNAME")
  private String lName;

  @Column(name="DOB")
  private String dOb;

  @Column(name="IS_ACTIVE")
  private String iSactive;

  @Column(name="CAPTCHA_VERIFICATION")
  private String cVerify;

  @Column(name="TYPE")
  private String type;

  @Column(name="USR_ID")
  private String userId;

  @Column(name="FB_ID")
  private String fbId;

  @Column(name="RGSTR_DATE")
  private String rgstrDate;

  @Column(name="ACTIVATED_DATE")
  private Date activatedDate;

  @Column(name="EMAIL_ID")
  private String email;

  public UsrMngtMaster(String pFname, String mName, String lName, String dOb, String iSactive, String cVerify, String type, String userId, String fbId, String rgstrDate, Date activatedDate, String email)
  {
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

  public UsrMngtMaster()
  {
  }

  public String getEmail()
  {
    return this.email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
  public long getRgstrId() {
    return this.rgstrId;
  }
  public void setRgstrId(long rgstrId) {
    this.rgstrId = rgstrId;
  }
  public String getpFname() {
    return this.pFname;
  }
  public void setpFname(String pFname) {
    this.pFname = pFname;
  }
  public String getmName() {
    return this.mName;
  }
  public void setmName(String mName) {
    this.mName = mName;
  }
  public String getlName() {
    return this.lName;
  }
  public void setlName(String lName) {
    this.lName = lName;
  }
  public String getdOb() {
    return this.dOb;
  }
  public void setdOb(String dOb) {
    this.dOb = dOb;
  }
  public String getiSactive() {
    return this.iSactive;
  }
  public void setiSactive(String iSactive) {
    this.iSactive = iSactive;
  }
  public String getcVerify() {
    return this.cVerify;
  }
  public void setcVerify(String cVerify) {
    this.cVerify = cVerify;
  }
  public String getType() {
    return this.type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getUserId() {
    return this.userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getFbId() {
    return this.fbId;
  }
  public void setFbId(String fbId) {
    this.fbId = fbId;
  }
  public String getRgstrDate() {
    return this.rgstrDate;
  }
  public void setRgstrDate(String rgstrDate) {
    this.rgstrDate = rgstrDate;
  }
  public Date getActivatedDate() {
    return this.activatedDate;
  }
  public void setActivatedDate(Date activatedDate) {
    this.activatedDate = activatedDate;
  }
}