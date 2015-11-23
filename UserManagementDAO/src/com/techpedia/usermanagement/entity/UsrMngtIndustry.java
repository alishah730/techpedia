package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " USR_MNGT_INDUSTRY")
public class UsrMngtIndustry {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "FAX")
	private String fax;
	 
	@Column(name = "CNTCT_PRSN_NAME")
	private String cntctprsnName;
	 

	@Column(name = "CNTCT_PRSN_MAIL_ID")
	private String cntctPrsnEmailId;
	
	@Column(name = "OPERATN_SECTR")
	private String operatnSectr;
	 	 
	@Column(name = "KIND_OF_SPRT_U_PROVIDE_INNOVTR")
	private String kindOfSprtUProvideInnovtr;
	 
	@Column(name = "PRD_RNG")
	private String prdRng;
	
	@Column(name = "ASSOCIAT_INDUSTRY")
	private String associateIndustry;

	@Column(name = "TECHNGY_EXPRTIZ_U_OFFR_TO_OTHRS")
	private String techngyExprtizOffrToOthers;
	
	
	@Column(name = "SOLN_REQRD_FOR_TECHNLGICAL_CHLNGS")
	private String solnReqrdForTechnlgicalChlngs;
	
	@Column(name = "INTRST_TO_POSE_INNOVTN_CHLNG_AWRDS")
	private String intrstToPoseInnovtnChlngAwrds;

	/**
	 * @param rgstrId
	 * @param fax
	 * @param cntctprsnName
	 * @param cntctPerEmailId
	 * @param operatnSectr
	 * @param kindOfSprtUProvideInnovtr
	 * @param prdRng
	 * @param associateIndustry
	 * @param techngyExprtizOffrToOthers
	 * @param solnReqrdForTechnlgicalChlngs
	 * @param intrstToPoseInnovtnChlngAwrds
	 */
	public UsrMngtIndustry(long rgstrId, String fax, String cntctprsnName,
			String cntctPrsnEmailId, String operatnSectr,
			String kindOfSprtUProvideInnovtr, String prdRng,
			String associateIndustry, String techngyExprtizOffrToOthers,
			String solnReqrdForTechnlgicalChlngs,
			String intrstToPoseInnovtnChlngAwrds) {
		super();
		this.rgstrId = rgstrId;
		this.fax = fax;
		this.cntctprsnName = cntctprsnName;
		this.cntctPrsnEmailId = cntctPrsnEmailId;
		this.operatnSectr = operatnSectr;
		this.kindOfSprtUProvideInnovtr = kindOfSprtUProvideInnovtr;
		this.prdRng = prdRng;
		this.associateIndustry = associateIndustry;
		this.techngyExprtizOffrToOthers = techngyExprtizOffrToOthers;
		this.solnReqrdForTechnlgicalChlngs = solnReqrdForTechnlgicalChlngs;
		this.intrstToPoseInnovtnChlngAwrds = intrstToPoseInnovtnChlngAwrds;
	}

	
	
	/**
	 * 
	 */
	public UsrMngtIndustry() {
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
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the cntctprsnName
	 */
	public String getCntctprsnName() {
		return cntctprsnName;
	}

	/**
	 * @param cntctprsnName the cntctprsnName to set
	 */
	public void setCntctprsnName(String cntctprsnName) {
		this.cntctprsnName = cntctprsnName;
	}

	/**
	 * @return the cntctPrsnEmailId
	 */
	public String getCntctPrsnEmailId() {
		return cntctPrsnEmailId;
	}

	/**
	 * @param cntctPrsnEmailId the cntctPrsnEmailId to set
	 */
	public void setCntctPrsnEmailId(String cntctPrsnEmailId) {
		this.cntctPrsnEmailId = cntctPrsnEmailId;
	}

	/**
	 * @return the operatnSectr
	 */
	public String getOperatnSectr() {
		return operatnSectr;
	}

	/**
	 * @param operatnSectr the operatnSectr to set
	 */
	public void setOperatnSectr(String operatnSectr) {
		this.operatnSectr = operatnSectr;
	}

	/**
	 * @return the kindOfSprtUProvideInnovtr
	 */
	public String getKindOfSprtUProvideInnovtr() {
		return kindOfSprtUProvideInnovtr;
	}

	/**
	 * @param kindOfSprtUProvideInnovtr the kindOfSprtUProvideInnovtr to set
	 */
	public void setKindOfSprtUProvideInnovtr(String kindOfSprtUProvideInnovtr) {
		this.kindOfSprtUProvideInnovtr = kindOfSprtUProvideInnovtr;
	}

	/**
	 * @return the prdRng
	 */
	public String getPrdRng() {
		return prdRng;
	}

	/**
	 * @param prdRng the prdRng to set
	 */
	public void setPrdRng(String prdRng) {
		this.prdRng = prdRng;
	}

	/**
	 * @return the associateIndustry
	 */
	public String getAssociateIndustry() {
		return associateIndustry;
	}

	/**
	 * @param associateIndustry the associateIndustry to set
	 */
	public void setAssociateIndustry(String associateIndustry) {
		this.associateIndustry = associateIndustry;
	}

	/**
	 * @return the techngyExprtizOffrToOthers
	 */
	public String getTechngyExprtizOffrToOthers() {
		return techngyExprtizOffrToOthers;
	}

	/**
	 * @param techngyExprtizOffrToOthers the techngyExprtizOffrToOthers to set
	 */
	public void setTechngyExprtizOffrToOthers(String techngyExprtizOffrToOthers) {
		this.techngyExprtizOffrToOthers = techngyExprtizOffrToOthers;
	}

	/**
	 * @return the solnReqrdForTechnlgicalChlngs
	 */
	public String getSolnReqrdForTechnlgicalChlngs() {
		return solnReqrdForTechnlgicalChlngs;
	}

	/**
	 * @param solnReqrdForTechnlgicalChlngs the solnReqrdForTechnlgicalChlngs to set
	 */
	public void setSolnReqrdForTechnlgicalChlngs(
			String solnReqrdForTechnlgicalChlngs) {
		this.solnReqrdForTechnlgicalChlngs = solnReqrdForTechnlgicalChlngs;
	}

	/**
	 * @return the intrstToPoseInnovtnChlngAwrds
	 */
	public String getIntrstToPoseInnovtnChlngAwrds() {
		return intrstToPoseInnovtnChlngAwrds;
	}

	/**
	 * @param intrstToPoseInnovtnChlngAwrds the intrstToPoseInnovtnChlngAwrds to set
	 */
	public void setIntrstToPoseInnovtnChlngAwrds(
			String intrstToPoseInnovtnChlngAwrds) {
		this.intrstToPoseInnovtnChlngAwrds = intrstToPoseInnovtnChlngAwrds;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtIndustry [rgstrId=" + rgstrId + ", fax=" + fax
				+ ", cntctprsnName=" + cntctprsnName + ", cntctPrsnEmailId="
				+ cntctPrsnEmailId + ", operatnSectr=" + operatnSectr
				+ ", kindOfSprtUProvideInnovtr=" + kindOfSprtUProvideInnovtr
				+ ", prdRng=" + prdRng + ", associateIndustry="
				+ associateIndustry + ", techngyExprtizOffrToOthers="
				+ techngyExprtizOffrToOthers
				+ ", solnReqrdForTechnlgicalChlngs="
				+ solnReqrdForTechnlgicalChlngs
				+ ", intrstToPoseInnovtnChlngAwrds="
				+ intrstToPoseInnovtnChlngAwrds + "]";
	}
	
	
}
