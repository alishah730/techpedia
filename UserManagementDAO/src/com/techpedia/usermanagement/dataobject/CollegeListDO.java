package com.techpedia.usermanagement.dataobject;

public class CollegeListDO {

	private String colegeName;
	private String colegeId;
	public String getColegeName() {
		return colegeName;
	}
	public void setColegeName(String colegeName) {
		this.colegeName = colegeName;
	}
	public String getColegeId() {
		return colegeId;
	}
	public void setColegeId(String colegeId) {
		this.colegeId = colegeId;
	}
	@Override
	public String toString() {
		return "CollegeUniversityListDO [colegeName=" + colegeName
				+ ", colegeId=" + colegeId + "]";
	}
	public CollegeListDO(String colegeName, String colegeId) {
		super();
		this.colegeName = colegeName;
		this.colegeId = colegeId;
	}
	public CollegeListDO() {
		super();
		// TODO Auto-generated constructor stub
	}
}

	