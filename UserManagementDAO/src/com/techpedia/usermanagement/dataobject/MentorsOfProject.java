package com.techpedia.usermanagement.dataobject;

public class MentorsOfProject {
	
	private Long mentorId1;
	private Long mentorId2;
	/**
	 * @return the mentorId1
	 */
	public Long getMentorId1() {
		return mentorId1;
	}
	/**
	 * @param mentorId1 the mentorId1 to set
	 */
	public void setMentorId1(Long mentorId1) {
		this.mentorId1 = mentorId1;
	}
	/**
	 * @return the mentorId2
	 */
	public Long getMentorId2() {
		return mentorId2;
	}
	/**
	 * @param mentorId2 the mentorId2 to set
	 */
	public void setMentorId2(Long mentorId2) {
		this.mentorId2 = mentorId2;
	}
	public MentorsOfProject(Long mentorId1, Long mentorId2) {
		super();
		this.mentorId1 = mentorId1;
		this.mentorId2 = mentorId2;
	}
	public MentorsOfProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MentorsAssignedToProject [mentorId1=" + mentorId1
				+ ", mentorId2=" + mentorId2 + "]";
	}
	
	
	
	
}
