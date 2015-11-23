package com.techpedia.usermanagement.dataobject;

public class SearchForMentorListDO {
	
	private long rgstrId;
	private String firstName;
	private String lastName;
	private String midName;
	private String photo;
	
	
	
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the midName
	 */
	public String getMidName() {
		return midName;
	}
	/**
	 * @param midName the midName to set
	 */
	public void setMidName(String midName) {
		this.midName = midName;
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
	public SearchForMentorListDO(long rgstrId, String firstName,
			String lastName, String midName, String photo) {
		super();
		this.rgstrId = rgstrId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.photo = photo;
	}
	public SearchForMentorListDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchForMentorListDO [rgstrId=" + rgstrId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", midName=" + midName
				+ ", photo=" + photo + "]";
	}

	
	
}
