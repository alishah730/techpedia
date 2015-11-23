package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_FACULTY")
public class UsrMngtFaculty {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "DEGREE")
	private String degree;
	 
	@Column(name = "COLLEGE")
	private String college;
	 
	@Column(name = "SPECIALISATION")
	private String specification;
	 
	@Column(name = "UNIVERSITY")
	private String university;
	 
	@Column(name = "ALUMNI")
	private String alumni;
	 
	@Column(name = "MEMSHP_IN_ASSOCNS")
	private String memshipInAssocns;
	
	@Column(name = "PSNL_WBPG_LNK")
	private String psnlWebpgLink;

	@Column(name = "PRO_EXP")
	private String proExp;

	@Column(name = "AFFLT_UNIVERSITY")
	private String affltUniversity;
	
	@Column(name = "BRANCH_ID")
	private String branchId;

	
	/**
	 * 
	 */
	public UsrMngtFaculty() {
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
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	/**
	 * @return the alumni
	 */
	public String getAlumni() {
		return alumni;
	}

	/**
	 * @param alumni the alumni to set
	 */
	public void setAlumni(String alumni) {
		this.alumni = alumni;
	}

	/**
	 * @return the memshipInAssocns
	 */
	public String getMemshipInAssocns() {
		return memshipInAssocns;
	}

	/**
	 * @param memshipInAssocns the memshipInAssocns to set
	 */
	public void setMemshipInAssocns(String memshipInAssocns) {
		this.memshipInAssocns = memshipInAssocns;
	}

	/**
	 * @return the psnlWebpgLink
	 */
	public String getPsnlWebpgLink() {
		return psnlWebpgLink;
	}

	/**
	 * @param psnlWebpgLink the psnlWebpgLink to set
	 */
	public void setPsnlWebpgLink(String psnlWebpgLink) {
		this.psnlWebpgLink = psnlWebpgLink;
	}

	/**
	 * @return the proExp
	 */
	public String getProExp() {
		return proExp;
	}

	/**
	 * @param proExp the proExp to set
	 */
	public void setProExp(String proExp) {
		this.proExp = proExp;
	}

	/**
	 * @return the affltUniversity
	 */
	public String getAffltUniversity() {
		return affltUniversity;
	}

	/**
	 * @param affltUniversity the affltUniversity to set
	 */
	public void setAffltUniversity(String affltUniversity) {
		this.affltUniversity = affltUniversity;
	}



	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public UsrMngtFaculty(long rgstrId, String degree, String college,
			String specification, String university, String alumni,
			String memshipInAssocns, String psnlWebpgLink, String proExp,
			String affltUniversity, String branchId) {
		super();
		this.rgstrId = rgstrId;
		this.degree = degree;
		this.college = college;
		this.specification = specification;
		this.university = university;
		this.alumni = alumni;
		this.memshipInAssocns = memshipInAssocns;
		this.psnlWebpgLink = psnlWebpgLink;
		this.proExp = proExp;
		this.affltUniversity = affltUniversity;
		this.branchId = branchId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtFaculty [rgstrId=" + rgstrId + ", degree=" + degree
				+ ", college=" + college + ", specification=" + specification
				+ ", university=" + university + ", alumni=" + alumni
				+ ", memshipInAssocns=" + memshipInAssocns + ", psnlWebpgLink="
				+ psnlWebpgLink + ", proExp=" + proExp + ", affltUniversity="
				+ affltUniversity + ", branchId=" + branchId + "]";
	}

	
	


}
