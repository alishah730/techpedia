package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_COLLEGE")
public class UsrMngtCollege {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "WEBPG_LNK ")
	private String webpgLnk;
	 
	@Column(name = "LOGO")
	private String logo;
	 
	@Column(name = "CNTCT_PER_NAME_OF_COLLEGE")
	private String cntctPerNameofCollege;
	 
	@Column(name = "CNTCT_PER_EMAIL_ID")
	private String cntctPerEmailId;
	 
	@Column(name = "PRINCIPAL_NAME")
	private String principalName;
	 
	@Column(name = "PRINCIPAL_MAIL_ID")
	private String principalMailId;
	
	@Column(name = "FACILITIES_OFFRD_TO_STUDENTS")
	private String facilitiesOffrdToStudents;

	@Column(name = "CNTCT_INFO_FOR_NATNL_INNOVN_CLUB")
	private String cntctInfoForNatnlInnovnClub;
	
	
	@Column(name = "AFFLT_UNIVERSITY")
	private String affltUniversity;
	
	@Column(name = "TECPDA_FACLTY_COORDTR")
	private String techpdaFactlyCoordtr;

	/**
	 * @param rgstrId
	 * @param webpgLnk
	 * @param logo
	 * @param cntctPerNameofCollege
	 * @param cntctPerEmailId
	 * @param principalName
	 * @param principalMailId
	 * @param facilitiesOffrdToStudents
	 * @param cntctInfoForNatnlInnovnClub
	 * @param affltUniversity
	 * @param techpdaFactlyCoordtr
	 */
	public UsrMngtCollege(long rgstrId, String webpgLnk, String logo,
			String cntctPerNameofCollege, String cntctPerEmailId,
			String principalName, String principalMailId,
			String facilitiesOffrdToStudents,
			String cntctInfoForNatnlInnovnClub, String affltUniversity,
			String techpdaFactlyCoordtr) {
		super();
		this.rgstrId = rgstrId;
		this.webpgLnk = webpgLnk;
		this.logo = logo;
		this.cntctPerNameofCollege = cntctPerNameofCollege;
		this.cntctPerEmailId = cntctPerEmailId;
		this.principalName = principalName;
		this.principalMailId = principalMailId;
		this.facilitiesOffrdToStudents = facilitiesOffrdToStudents;
		this.cntctInfoForNatnlInnovnClub = cntctInfoForNatnlInnovnClub;
		this.affltUniversity = affltUniversity;
		this.techpdaFactlyCoordtr = techpdaFactlyCoordtr;
	}

	/**
	 * 
	 */
	public UsrMngtCollege() {
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
	 * @return the webpgLnk
	 */
	public String getWebpgLnk() {
		return webpgLnk;
	}

	/**
	 * @param webpgLnk the webpgLnk to set
	 */
	public void setWebpgLnk(String webpgLnk) {
		this.webpgLnk = webpgLnk;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the cntctPerNameofCollege
	 */
	public String getCntctPerNameofCollege() {
		return cntctPerNameofCollege;
	}

	/**
	 * @param cntctPerNameofCollege the cntctPerNameofCollege to set
	 */
	public void setCntctPerNameofCollege(String cntctPerNameofCollege) {
		this.cntctPerNameofCollege = cntctPerNameofCollege;
	}

	/**
	 * @return the cntctPerEmailId
	 */
	public String getCntctPerEmailId() {
		return cntctPerEmailId;
	}

	/**
	 * @param cntctPerEmailId the cntctPerEmailId to set
	 */
	public void setCntctPerEmailId(String cntctPerEmailId) {
		this.cntctPerEmailId = cntctPerEmailId;
	}

	/**
	 * @return the principalName
	 */
	public String getPrincipalName() {
		return principalName;
	}

	/**
	 * @param principalName the principalName to set
	 */
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	/**
	 * @return the principalMailId
	 */
	public String getPrincipalMailId() {
		return principalMailId;
	}

	/**
	 * @param principalMailId the principalMailId to set
	 */
	public void setPrincipalMailId(String principalMailId) {
		this.principalMailId = principalMailId;
	}

	/**
	 * @return the facilitiesOffrdToStudents
	 */
	public String getFacilitiesOffrdToStudents() {
		return facilitiesOffrdToStudents;
	}

	/**
	 * @param facilitiesOffrdToStudents the facilitiesOffrdToStudents to set
	 */
	public void setFacilitiesOffrdToStudents(String facilitiesOffrdToStudents) {
		this.facilitiesOffrdToStudents = facilitiesOffrdToStudents;
	}

	/**
	 * @return the cntctInfoForNatnlInnovnClub
	 */
	public String getCntctInfoForNatnlInnovnClub() {
		return cntctInfoForNatnlInnovnClub;
	}

	/**
	 * @param cntctInfoForNatnlInnovnClub the cntctInfoForNatnlInnovnClub to set
	 */
	public void setCntctInfoForNatnlInnovnClub(String cntctInfoForNatnlInnovnClub) {
		this.cntctInfoForNatnlInnovnClub = cntctInfoForNatnlInnovnClub;
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

	/**
	 * @return the techpdaFactlyCoordtr
	 */
	public String getTechpdaFactlyCoordtr() {
		return techpdaFactlyCoordtr;
	}

	/**
	 * @param techpdaFactlyCoordtr the techpdaFactlyCoordtr to set
	 */
	public void setTechpdaFactlyCoordtr(String techpdaFactlyCoordtr) {
		this.techpdaFactlyCoordtr = techpdaFactlyCoordtr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtCollege [rgstrId=" + rgstrId + ", webpgLnk=" + webpgLnk
				+ ", logo=" + logo + ", cntctPerNameofCollege="
				+ cntctPerNameofCollege + ", cntctPerEmailId="
				+ cntctPerEmailId + ", principalName=" + principalName
				+ ", principalMailId=" + principalMailId
				+ ", facilitiesOffrdToStudents=" + facilitiesOffrdToStudents
				+ ", cntctInfoForNatnlInnovnClub="
				+ cntctInfoForNatnlInnovnClub + ", affltUniversity="
				+ affltUniversity + ", techpdaFactlyCoordtr="
				+ techpdaFactlyCoordtr + "]";
	}
	
	
	

}
