/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Date;

/**
 * @author 455959
 *
 */
public class UsrMngtPasswdVO {
	private long rgstrId;
	private String usrId;
	private String usrPasswd;
	private Date createdDate;
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
	 * @return the usrId
	 */
	public String getUsrId() {
		return usrId;
	}
	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * @return the usrPasswd
	 */
	public String getUsrPasswd() {
		return usrPasswd;
	}
	/**
	 * @param usrPasswd the usrPasswd to set
	 */
	public void setUsrPasswd(String usrPasswd) {
		this.usrPasswd = usrPasswd;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
