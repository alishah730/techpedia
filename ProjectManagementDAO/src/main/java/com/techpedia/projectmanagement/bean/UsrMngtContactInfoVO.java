/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.Arrays;

/**
 * @author 455959
 *
 */
public class UsrMngtContactInfoVO {
	private long rgstrId;
	private String mobileNo;
	private String homePhoneNo;
	private byte[] photo;
	private String photoPath;
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
	public byte[] getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtContactInfoVO [rgstrId=" + rgstrId + ", mobileNo="
				+ mobileNo + ", homePhoneNo=" + homePhoneNo + ", photo="
				+ Arrays.toString(photo) + ", photoPath=" + photoPath + "]";
	}

}
