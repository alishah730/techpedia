package com.techpedia.usermanagement.dataobject;

public class Mentor1n2Details {
	
	private Long rgstr_id;
	private String firstName;
	private String lastName;
	private String midName;
	private String photo;
	private String degree;
	private String designation;
	private String experience;
	private String association;
	private String interest;
	private String commitment;
	/**
	 * @return the rgstr_id
	 */
	public Long getRgstr_id() {
		return rgstr_id;
	}
	/**
	 * @param rgstr_id the rgstr_id to set
	 */
	public void setRgstr_id(Long rgstr_id) {
		this.rgstr_id = rgstr_id;
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
	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the association
	 */
	public String getAssociation() {
		return association;
	}
	/**
	 * @param association the association to set
	 */
	public void setAssociation(String association) {
		this.association = association;
	}
	/**
	 * @return the interest
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * @return the commitment
	 */
	public String getCommitment() {
		return commitment;
	}
	/**
	 * @param commitment the commitment to set
	 */
	public void setCommitment(String commitment) {
		this.commitment = commitment;
	}
	public Mentor1n2Details(Long rgstr_id, String firstName, String lastName,
			String midName, String photo, String degree, String designation,
			String experience, String association, String interest,
			String commitment) {
		super();
		this.rgstr_id = rgstr_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
		this.photo = photo;
		this.degree = degree;
		this.designation = designation;
		this.experience = experience;
		this.association = association;
		this.interest = interest;
		this.commitment = commitment;
	}
	public Mentor1n2Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mentor1n2Details [rgstr_id=" + rgstr_id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", midName=" + midName
				+ ", photo=" + photo + ", degree=" + degree + ", designation="
				+ designation + ", experience=" + experience + ", association="
				+ association + ", interest=" + interest + ", commitment="
				+ commitment + "]";
	}
	
	
	
	
	
	
	
	
}
