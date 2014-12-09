/**
 * 
 */
package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nishikant.singh
 *
 */
@Entity
@Table(name = " USR_MNGT_MENTOR")
public class UsrMngtMentor {

	@Id
	@Column(name = "RGSTR_ID")
	private long rgstrId;

	@Column(name = "DEGREE")
	private String degree;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "SPECIALIZATION")
	private String specialization;

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
	 * @param rgstrId
	 * @param degree
	 * @param designation
	 * @param specialization
	 * @param institutionalAssctnInfo
	 * @param proExperience
	 * @param timeUspaceForMentoringPerMnth
	 * @param mentorProfile
	 * @param expectationFromMentor
	 * @param commitmentUBringIn
	 * @param webLink
	 * @param intOnGrassrtInnovators
	 * @param popularity
	 */
	public UsrMngtMentor(long rgstrId, String degree, String designation,
			String specialization, String institutionalAssctnInfo,
			String proExperience, String timeUspaceForMentoringPerMnth,
			String mentorProfile, String expectationFromMentor,
			String commitmentUBringIn, String webLink,
			String intOnGrassrtInnovators, int popularity) {
		this.rgstrId = rgstrId;
		this.degree = degree;
		this.designation = designation;
		this.specialization = specialization;
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
	}

	public long getRgstrId() {
		return this.rgstrId;
	}

	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getInstitutionalAssctnInfo() {
		return this.institutionalAssctnInfo;
	}

	public void setInstitutionalAssctnInfo(String institutionalAssctnInfo) {
		this.institutionalAssctnInfo = institutionalAssctnInfo;
	}

	public String getProExperience() {
		return this.proExperience;
	}

	public void setProExperience(String proExperience) {
		this.proExperience = proExperience;
	}

	public String getTimeUspaceForMentoringPerMnth() {
		return this.timeUspaceForMentoringPerMnth;
	}

	public void setTimeUspaceForMentoringPerMnth(
			String timeUspaceForMentoringPerMnth) {
		this.timeUspaceForMentoringPerMnth = timeUspaceForMentoringPerMnth;
	}

	public String getMentorProfile() {
		return this.mentorProfile;
	}

	public void setMentorProfile(String mentorProfile) {
		this.mentorProfile = mentorProfile;
	}

	public String getExpectationFromMentor() {
		return this.expectationFromMentor;
	}

	public void setExpectationFromMentor(String expectationFromMentor) {
		this.expectationFromMentor = expectationFromMentor;
	}

	public String getCommitmentUBringIn() {
		return this.commitmentUBringIn;
	}

	public void setCommitmentUBringIn(String commitmentUBringIn) {
		this.commitmentUBringIn = commitmentUBringIn;
	}

	public String getWebLink() {
		return this.webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getIntOnGrassrtInnovators() {
		return this.intOnGrassrtInnovators;
	}

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
	
}
