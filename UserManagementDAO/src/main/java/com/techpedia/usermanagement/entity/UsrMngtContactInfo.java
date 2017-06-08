package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_CONTACT_INFO")
public class UsrMngtContactInfo {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	 
	@Column(name = "HOME_PHONE_NO")
	private String homePhoneNo;
	 
	@Column(name = "PHOTO")
	private String photo;
	
	@Column(name = "PHOTO_PATH")
	private String photoPath;

	public UsrMngtContactInfo(long rgstrId, String mobileNo, String homePhoneNo,
			String photo,String photoPath) {
		super();
		this.rgstrId = rgstrId;
		this.mobileNo = mobileNo;
		this.homePhoneNo = homePhoneNo;
		this.photo = photo;
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @param photoPath
	 */
	public UsrMngtContactInfo(long rgstrId,String photoPath) {
		super();
		this.rgstrId = rgstrId;
		this.photoPath = photoPath;
	}

	/**
	 * 
	 */
	public UsrMngtContactInfo() {
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the homePhoneNo
	 */
	public String getHomePhoneNo() {
		return homePhoneNo;
	}

	/**
	 * @param homePhoneNo the homePhoneNo to set
	 */
	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "UsrMngtContactInfo [rgstrId=" + rgstrId + ", mobileNo="
				+ mobileNo + ", homePhoneNo=" + homePhoneNo + ", photo="
				+ photo + ", photoPath=" + photoPath + "]";
	}
	
	

}
