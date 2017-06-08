package com.techpedia.usermanagement.dataobject;

public class SearchCityDO {
private String term;
private String stateName;
/**
 * @return the term
 */
public String getTerm() {
	return term;
}
/**
 * @param term the term to set
 */
public void setTerm(String term) {
	this.term = term;
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
	return "SearchCityDO [term=" + term + ", stateName=" + stateName + "]";
}

}
