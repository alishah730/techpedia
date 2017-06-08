package com.techpedia.usermanagement.dataobject;

public class CityListDO {
private String cityName;
private String stateId;
/**
 * @return the cityName
 */
public String getCityName() {
	return cityName;
}
/**
 * @param cityName the cityName to set
 */
public void setCityName(String cityName) {
	this.cityName = cityName;
}
/**
 * @return the stateId
 */
public String getStateId() {
	return stateId;
}

@Override
public String toString() {
	return "CityListDO [cityName=" + cityName + ", stateId=" + stateId + "]";
}
/**
 * 
 */
public CityListDO() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param cityName
 * @param stateId
 */
public CityListDO(String cityName, String stateId) {
	super();
	this.cityName = cityName;
	this.stateId = stateId;
}
/**
 * @param stateId the stateId to set
 */
public void setStateId(String stateId) {
	this.stateId = stateId;
}
}
