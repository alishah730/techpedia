package com.techpedia.usermanagement.dataobject;

public class CollegeUniversityListDO {

	private String colegeName;
	private String universityName;

	public String getColegeName() {
		return colegeName;
	}

	public void setColegeName(String colegeName) {
		this.colegeName = colegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public CollegeUniversityListDO(String colegeName, String universityName) {
		super();
		this.colegeName = colegeName;
		this.universityName = universityName;
	}

	public CollegeUniversityListDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollegeUniversityListDO [colegeName=" + colegeName
				+ ", universityName=" + universityName + "]";
	}

}
