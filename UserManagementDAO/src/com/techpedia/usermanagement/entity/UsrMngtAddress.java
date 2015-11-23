package com.techpedia.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_MNGT_ADDR")
public class UsrMngtAddress {
	
	@Id   //@GeneratedValue
	@Column(name = "RGSTR_ID")
	private long rgstrId;
		
	@Column(name = "ADDR_LN1 ")
	private String addrLn1;
	 
	@Column(name = "ADDR_LN2")
	private String addrLn2;
	 
	@Column(name = "CITY")
	private String city;
	 
	@Column(name = "DISTRICT")
	private String district;
	 
	@Column(name = "STATE")
	private String state;
	 
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PIN")
	private String pin;

	public UsrMngtAddress(long rgstrId, String addrLn1, String addrLn2, String city,
			String district, String state, String country, String pin) {
		super();
		this.rgstrId = rgstrId;
		this.addrLn1 = addrLn1;
		this.addrLn2 = addrLn2;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}

	/**
	 * 
	 */
	public UsrMngtAddress() {
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
	 * @param id the rgstrId to set
	 */
	public void setRgstrId(long rgstrId) {
		this.rgstrId = rgstrId;
	}

	/**
	 * @return the addrLn1
	 */
	public String getAddrLn1() {
		return addrLn1;
	}

	/**
	 * @param addrLn1 the addrLn1 to set
	 */
	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}

	/**
	 * @return the addrLn2
	 */
	public String getAddrLn2() {
		return addrLn2;
	}

	/**
	 * @param addrLn2 the addrLn2 to set
	 */
	public void setAddrLn2(String addrLn2) {
		this.addrLn2 = addrLn2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsrMngtAddress [rgstrId=" + rgstrId + ", addrLn1=" + addrLn1
				+ ", addrLn2=" + addrLn2 + ", city=" + city + ", district="
				+ district + ", state=" + state + ", country=" + country
				+ ", pin=" + pin + "]";
	}
	


}
