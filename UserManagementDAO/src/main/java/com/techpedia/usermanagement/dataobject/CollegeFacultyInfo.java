package com.techpedia.usermanagement.dataobject;

public class CollegeFacultyInfo {
	
	private long rgstrId;
	private String facultyName;
	private String photoPath;
	private String projBranchDesc;
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
	 * @return the facultyNAme
	 */
	public String getFacultyName() {
		return facultyName;
	}
	/**
	 * @param facultyNAme the facultyNAme to set
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * @return the projBranchDesc
	 */
	public String getProjBranchDesc() {
		return projBranchDesc;
	}
	/**
	 * @param projBranchDesc the projBranchDesc to set
	 */
	public void setProjBranchDesc(String projBranchDesc) {
		this.projBranchDesc = projBranchDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CollegeFacultyInfo [rgstrId=" + rgstrId + ", facultyName="
				+ facultyName + ", photoPath=" + photoPath
				+ ", projBranchDesc=" + projBranchDesc + "]";
	}
	
}
