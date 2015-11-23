package com.techpedia.projectmanagement.bean;

public class ChallengeType {

	private int challengeTypeId;
	
	private String challengeTypeDesc;
	
	public int getChallengeTypeId() {
		return challengeTypeId;
	}
	public void setChallengeTypeId(int challengeTypeId) {
		this.challengeTypeId = challengeTypeId;
	}
	public String getChallengeTypeDesc() {
		return challengeTypeDesc;
	}
	public void setChallengeTypeDesc(String challengeTypeDesc) {
		this.challengeTypeDesc = challengeTypeDesc;
	}
	@Override
	public String toString() {
		return "ChallengeType [challengeTypeId=" + challengeTypeId
				+ ", challengeTypeDesc=" + challengeTypeDesc + "]";
	}
	
}
