package com.techpedia.usermanagement.dataobject;
public class CollegeDataDo {

	private String rgstrId;
	private String collegeName;
	private String collegeDescription;
	
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	/**
	 * @return the collegeDescription
	 */
	public String getCollegeDescription() {
		return collegeDescription;
	}
	/**
	 * @return the rgstrId
	 */
	public String getRgstrId() {
		return rgstrId;
	}
	/**
	 * @param rgstrId the rgstrId to set
	 */
	public void setRgstrId(String rgstrId) {
		this.rgstrId = rgstrId;
	}
	/**
	 * @param collegeDescription the collegeDescription to set
	 */
	public void setCollegeDescription(String collegeDescription) {
		this.collegeDescription = collegeDescription;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollegeDataDo [rgstrId=" + rgstrId + ", collegeName=" + collegeName + ", collegeDescription="
				+ collegeDescription + "]";
	}
	
	
	

	


	

}
