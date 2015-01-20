package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USR_MNGT_FACULTY")
public class UsrMngtFaculty
{

  @Id
  @Column(name="RGSTR_ID")
  private long rgstrId;

  @Column(name="DEGREE")
  private String degree;

  @Column(name="COLLEGE")
  private String college;

  @Column(name="SPECIALISATION")
  private String specification;

  @Column(name="UNIVERSITY")
  private String university;

  @Column(name="ALUMNI")
  private String alumni;

  @Column(name="MEMSHP_IN_ASSOCNS")
  private String memshipInAssocns;

  @Column(name="PSNL_WBPG_LNK")
  private String psnlWebpgLink;

  @Column(name="PRO_EXP")
  private String proExp;

  @Column(name="AFFLT_UNIVERSITY")
  private String affltUniversity;
  
  @Column(name="BRANCH_ID")
  private long branchId;
  
  public UsrMngtFaculty(long rgstrId, String degree, String college, String specification, String university, String alumni, String memshipInAssocns, String psnlWebpgLink, String proExp, String affltUniversity, long branchId)
  {
    this.rgstrId = rgstrId;
    this.degree = degree;
    this.college = college;
    this.specification = specification;
    this.university = university;
    this.alumni = alumni;
    this.memshipInAssocns = memshipInAssocns;
    this.psnlWebpgLink = psnlWebpgLink;
    this.proExp = proExp;
    this.affltUniversity = affltUniversity;
    this.branchId = branchId;
  }

  public UsrMngtFaculty()
  {
  }

  public long getRgstrId()
  {
    return this.rgstrId;
  }

  public void setRgstrId(long rgstrId)
  {
    this.rgstrId = rgstrId;
  }

  public String getDegree()
  {
    return this.degree;
  }

  public void setDegree(String degree)
  {
    this.degree = degree;
  }

  public String getCollege()
  {
    return this.college;
  }

  public void setCollege(String college)
  {
    this.college = college;
  }

  public String getSpecification()
  {
    return this.specification;
  }

  public void setSpecification(String specification)
  {
    this.specification = specification;
  }

  public String getUniversity()
  {
    return this.university;
  }

  public void setUniversity(String university)
  {
    this.university = university;
  }

  public String getAlumni()
  {
    return this.alumni;
  }

  public void setAlumni(String alumni)
  {
    this.alumni = alumni;
  }

  public String getMemshipInAssocns()
  {
    return this.memshipInAssocns;
  }

  public void setMemshipInAssocns(String memshipInAssocns)
  {
    this.memshipInAssocns = memshipInAssocns;
  }

  public String getPsnlWebpgLink()
  {
    return this.psnlWebpgLink;
  }

  public void setPsnlWebpgLink(String psnlWebpgLink)
  {
    this.psnlWebpgLink = psnlWebpgLink;
  }

  public String getProExp()
  {
    return this.proExp;
  }

  public void setProExp(String proExp)
  {
    this.proExp = proExp;
  }

  public String getAffltUniversity()
  {
    return this.affltUniversity;
  }

  public void setAffltUniversity(String affltUniversity)
  {
    this.affltUniversity = affltUniversity;
  }

  public long getBranchId() {
	return branchId;
  }
	
  public void setBranchId(long branchId) {
	this.branchId = branchId;
  }
  
}