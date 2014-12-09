package com.techpedia.projectmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USR_MNGT_STUDENT")
public class UsrMngtStudent
{

  @Id
  @Column(name="RGSTR_ID")
  private long rgstrId;

  @Column(name="DEGREE")
  private String degree;

  @Column(name="COLLEGE")
  private String college;

  @Column(name="UNIVERSITY")
  private String university;

  @Column(name="ENROLLMENT_NO")
  private String enrollmentNo;

  @Column(name="YEAR_OF_PASS")
  private String yearOfPass;

  public UsrMngtStudent(long rgstrId, String degree, String college, String university, String enrollmentNo, String yearOfPass)
  {
    this.rgstrId = rgstrId;
    this.degree = degree;
    this.college = college;
    this.university = university;
    this.enrollmentNo = enrollmentNo;
    this.yearOfPass = yearOfPass;
  }

  public UsrMngtStudent()
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

  public String getUniversity()
  {
    return this.university;
  }

  public void setUniversity(String university)
  {
    this.university = university;
  }

  public String getEnrollmentNo()
  {
    return this.enrollmentNo;
  }

  public void setEnrollmentNo(String enrollmentNo)
  {
    this.enrollmentNo = enrollmentNo;
  }

  public String getYearOfPass()
  {
    return this.yearOfPass;
  }

  public void setYearOfPass(String yearOfPass)
  {
    this.yearOfPass = yearOfPass;
  }
}