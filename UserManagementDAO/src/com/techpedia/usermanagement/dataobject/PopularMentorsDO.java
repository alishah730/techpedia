package com.techpedia.usermanagement.dataobject;

public class PopularMentorsDO {
	
	private String mentorId;
	private String mentorFirstName;
	private String mentorMiddleName;
	private String mentorLastName;
	private String mentorImage;
	private String popualrity;
	private String mentorBranch;
	private String mentorCollege;

	/**
	 * @return the mentorId
	 */
	public String getMentorId() {
		return mentorId;
	}
	/**
	 * @param mentorId the mentorId to set
	 */
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}
	/**
	 * @return the mentorFirstName
	 */
	public String getMentorFirstName() {
		return mentorFirstName;
	}
	/**
	 * @param mentorFirstName the mentorFirstName to set
	 */
	public void setMentorFirstName(String mentorFirstName) {
		this.mentorFirstName = mentorFirstName;
	}
	/**
	 * @return the mentorMiddleName
	 */
	public String getMentorMiddleName() {
		return mentorMiddleName;
	}
	/**
	 * @param mentorMiddleName the mentorMiddleName to set
	 */
	public void setMentorMiddleName(String mentorMiddleName) {
		this.mentorMiddleName = mentorMiddleName;
	}
	/**
	 * @return the mentorLastName
	 */
	public String getMentorLastName() {
		return mentorLastName;
	}
	/**
	 * @param mentorLastName the mentorLastName to set
	 */
	public void setMentorLastName(String mentorLastName) {
		this.mentorLastName = mentorLastName;
	}
	/**
	 * @return the mentorImage
	 */
	public String getMentorImage() {
		return mentorImage;
	}
	/**
	 * @param mentorImage the mentorImage to set
	 */
	public void setMentorImage(String mentorImage) {
		this.mentorImage = mentorImage;
	}
	/**
	 * @return the popualrity
	 */
	public String getPopualrity() {
		return popualrity;
	}
	/**
	 * @param popualrity the popualrity to set
	 */
	public void setPopualrity(String popualrity) {
		this.popualrity = popualrity;
	}
	/**
	 * @return the mentorBranch
	 */
	public String getMentorBranch() {
		return mentorBranch;
	}
	/**
	 * @param mentorBranch the mentorBranch to set
	 */
	public void setMentorBranch(String mentorBranch) {
		this.mentorBranch = mentorBranch;
	}
	/**
	 * @return the mentorCollege
	 */
	public String getMentorCollege() {
		return mentorCollege;
	}
	/**
	 * @param mentorCollege the mentorCollege to set
	 */
	public void setMentorCollege(String mentorCollege) {
		this.mentorCollege = mentorCollege;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PopularMentorsDO [mentorId=" + mentorId + ", mentorFirstName="
				+ mentorFirstName + ", mentorMiddleName=" + mentorMiddleName
				+ ", mentorLastName=" + mentorLastName + ", mentorImage="
				+ mentorImage + ", popualrity=" + popualrity
				+ ", mentorBranch=" + mentorBranch + ", mentorCollege="
				+ mentorCollege + "]";
	}
	
	
	
	
}
