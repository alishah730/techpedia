package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_PASSWD")
public class UsrMngtPassword {
	
	@Id   //@GeneratedValue
	@Column(name = "sno")
	private int sno;
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "USR_ID")
	private String usrId;
	 
	@Column(name = "USR_PASSWD")
	private String usrPasswd;
	 
	@Column(name = "CREATED_DATE")
	private String createdDate;



	
	/**
	 * @param sno
	 * @param rgstrId
	 * @param usrId
	 * @param usrPasswd
	 * @param createdDate
	 */
	public UsrMngtPassword(long rgstrId, String usrId,
			String usrPasswd, String createdDate) {
		super();
		this.rgstrId = rgstrId;
		this.usrId = usrId;
		this.usrPasswd = usrPasswd;
		this.createdDate = createdDate;
	}


	/**
	 * 
	 */
	public UsrMngtPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the sno
	 */
	public int getSno() {
		return sno;
	}


	/**
	 * @param sno the sno to set
	 */
	public void setSno(int sno) {
		this.sno = sno;
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
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtPassword [sno=" + sno + ", rgstrId=" + rgstrId
				+ ", usrId=" + usrId + ", usrPasswd=" + usrPasswd
				+ ", createdDate=" + createdDate + "]";
	}


	

}
