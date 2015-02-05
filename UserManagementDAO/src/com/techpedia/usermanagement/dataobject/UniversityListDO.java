package com.techpedia.usermanagement.dataobject;

public class UniversityListDO {

	private String universityName;
	@Override
	public String toString() {
		return "UniversityListDO [universityName=" + universityName
				+ ", universityId=" + universityId + "]";
	}
	public UniversityListDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UniversityListDO(String universityName, String universityId) {
		super();
		this.universityName = universityName;
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	private String universityId;
}
