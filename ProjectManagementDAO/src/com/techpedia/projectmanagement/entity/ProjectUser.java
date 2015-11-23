package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectUser {
	
	@Id
	@Column(name="proj_team_leader_id")
	private long projTeamLeaderId;
	
	@Column(name="PROJ_FAC_RGSTR_ID")
	private long projFacRgstrId;
	
	@Column(name="proj_mentor1_id")
	private long projMentor1Id;
	
	@Column(name="proj_mentor2_id")
	private long projMentor2Id;

	public long getProjTeamLeaderId() {
		return projTeamLeaderId;
	}

	public void setProjTeamLeaderId(long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}

	public long getProjFacRgstrId() {
		return projFacRgstrId;
	}

	public void setProjFacRgstrId(long projFacRgstrId) {
		this.projFacRgstrId = projFacRgstrId;
	}

	public long getProjMentor1Id() {
		return projMentor1Id;
	}

	public void setProjMentor1Id(long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}

	public long getProjMentor2Id() {
		return projMentor2Id;
	}

	public void setProjMentor2Id(long projMentor2Id) {
		this.projMentor2Id = projMentor2Id;
	}

	
}
