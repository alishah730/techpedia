package com.techpedia.usermanagement.dataobject;

public class StateListDO {
private String stateId;
private String stateName;
/**
 * @return the stateId
 */
public String getStateId() {
	return stateId;
}
/**
 * @param stateId the stateId to set
 */
public void setStateId(String stateId) {
	this.stateId = stateId;
}
/**
 * @return the stateName
 */
public String getStateName() {
	return stateName;
}
/**
 * @param stateName the stateName to set
 */
public void setStateName(String stateName) {
	this.stateName = stateName;
}

@Override
public String toString() {
	return "StateListDO [stateId=" + stateId + ", stateName=" + stateName + "]";
}

public StateListDO(String stateId, String stateName) {
	super();
	this.stateId = stateId;
	this.stateName = stateName;
}
/**
 * 
 */
public StateListDO() {
	super();
	// TODO Auto-generated constructor stub
}


}
