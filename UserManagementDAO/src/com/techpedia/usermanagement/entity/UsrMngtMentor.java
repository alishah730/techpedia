package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " USR_MNGT_MENTOR")
public class UsrMngtMentor {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "DEGREE")
	private String degree;
	 
	@Column(name = "DESIGNATION")
	private String designation;
	 
	@Column(name = "BRANCH_ID")
	private String branchId;	 


	@Column(name = "INSTITUTIONAL_ASSCTN_INFO")
	private String institutionalAssctnInfo;
	 
	@Column(name = "PRO_EXPERIENCE")
	private String proExperience;
	 
	@Column(name = "TIME_U_SPARE_FOR_MENTORING_PER_MNTH")
	private String timeUspaceForMentoringPerMnth;
	
	@Column(name = "MENTOR_PROFILE")
	private String mentorProfile;

	@Column(name = "EXPECTATION_FROM_MENTOR")
	private String expectationFromMentor;
	
	
	@Column(name = "COMMITMENT_U_BRING_IN")
	private String commitmentUBringIn;
	
	@Column(name = "WEB_LINK")
	private String webLink;
	
	@Column(name = "INT_ON_GRASSRT_INNOVATORS")
	private String intOnGrassrtInnovators;
	
	@Column(name = "POPULARITY")
	private int popularity;

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

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the institutionalAssctnInfo
	 */
	public String getInstitutionalAssctnInfo() {
		return institutionalAssctnInfo;
	}

	/**
	 * @param institutionalAssctnInfo the institutionalAssctnInfo to set
	 */
	public void setInstitutionalAssctnInfo(String institutionalAssctnInfo) {
		this.institutionalAssctnInfo = institutionalAssctnInfo;
	}

	/**
	 * @return the proExperience
	 */
	public String getProExperience() {
		return proExperience;
	}

	/**
	 * @param proExperience the proExperience to set
	 */
	public void setProExperience(String proExperience) {
		this.proExperience = proExperience;
	}

	/**
	 * @return the timeUspaceForMentoringPerMnth
	 */
	public String getTimeUspaceForMentoringPerMnth() {
		return timeUspaceForMentoringPerMnth;
	}

	/**
	 * @param timeUspaceForMentoringPerMnth the timeUspaceForMentoringPerMnth to set
	 */
	public void setTimeUspaceForMentoringPerMnth(
			String timeUspaceForMentoringPerMnth) {
		this.timeUspaceForMentoringPerMnth = timeUspaceForMentoringPerMnth;
	}

	/**
	 * @return the mentorProfile
	 */
	public String getMentorProfile() {
		return mentorProfile;
	}

	/**
	 * @param mentorProfile the mentorProfile to set
	 */
	public void setMentorProfile(String mentorProfile) {
		this.mentorProfile = mentorProfile;
	}

	/**
	 * @return the expectationFromMentor
	 */
	public String getExpectationFromMentor() {
		return expectationFromMentor;
	}

	/**
	 * @param expectationFromMentor the expectationFromMentor to set
	 */
	public void setExpectationFromMentor(String expectationFromMentor) {
		this.expectationFromMentor = expectationFromMentor;
	}

	/**
	 * @return the commitmentUBringIn
	 */
	public String getCommitmentUBringIn() {
		return commitmentUBringIn;
	}

	/**
	 * @param commitmentUBringIn the commitmentUBringIn to set
	 */
	public void setCommitmentUBringIn(String commitmentUBringIn) {
		this.commitmentUBringIn = commitmentUBringIn;
	}

	/**
	 * @return the webLink
	 */
	public String getWebLink() {
		return webLink;
	}

	/**
	 * @param webLink the webLink to set
	 */
	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	/**
	 * @return the intOnGrassrtInnovators
	 */
	public String getIntOnGrassrtInnovators() {
		return intOnGrassrtInnovators;
	}

	/**
	 * @param intOnGrassrtInnovators the intOnGrassrtInnovators to set
	 */
	public void setIntOnGrassrtInnovators(String intOnGrassrtInnovators) {
		this.intOnGrassrtInnovators = intOnGrassrtInnovators;
	}

	/**
	 * @return the popularity
	 */
	public int getPopularity() {
		return popularity;
	}

	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public UsrMngtMentor(long rgstrId, String degree, String designation,
			String branchId, String institutionalAssctnInfo, String proExperience,
			String timeUspaceForMentoringPerMnth, String mentorProfile,
			String expectationFromMentor, String commitmentUBringIn,
			String webLink, String intOnGrassrtInnovators, int popularity) {
		super();
		this.rgstrId = rgstrId;
		this.degree = degree;
		this.designation = designation;
		this.branchId = branchId;
		this.institutionalAssctnInfo = institutionalAssctnInfo;
		this.proExperience = proExperience;
		this.timeUspaceForMentoringPerMnth = timeUspaceForMentoringPerMnth;
		this.mentorProfile = mentorProfile;
		this.expectationFromMentor = expectationFromMentor;
		this.commitmentUBringIn = commitmentUBringIn;
		this.webLink = webLink;
		this.intOnGrassrtInnovators = intOnGrassrtInnovators;
		this.popularity = popularity;
	}

	public UsrMngtMentor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtMentor [rgstrId=" + rgstrId + ", degree=" + degree
				+ ", designation=" + designation + ", branchId=" + branchId
				+ ", institutionalAssctnInfo=" + institutionalAssctnInfo
				+ ", proExperience=" + proExperience
				+ ", timeUspaceForMentoringPerMnth="
				+ timeUspaceForMentoringPerMnth + ", mentorProfile="
				+ mentorProfile + ", expectationFromMentor="
				+ expectationFromMentor + ", commitmentUBringIn="
				+ commitmentUBringIn + ", webLink=" + webLink
				+ ", intOnGrassrtInnovators=" + intOnGrassrtInnovators
				+ ", popularity=" + popularity + "]";
	}

	
	
	

	
}
