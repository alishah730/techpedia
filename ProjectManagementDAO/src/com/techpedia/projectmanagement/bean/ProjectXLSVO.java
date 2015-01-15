/**
 * 
 */
package com.techpedia.projectmanagement.bean;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author nishikant.singh
 *
 */
public class ProjectXLSVO {
	private String projUniversity;
	private String projCollegeRgstrIdUsr;
	private String projCollegeState;
	private int projTypeId;
	private String projTitle;
	private String projAbstract;
	private String projDescription;
	private int projYear;
	private Date projStartDate;
	private Date projEndDate;
	private ArrayList<Integer> projBranches;
	private ArrayList<String> projKeywords;
	private long projGuideId;
	private long projMentor1Id;
	private int projStatusId;
	private String projToFloat;
	private String projCommentsPublish;
	private String projGrade;
	private String projAwardWon;
	private String projAwardDesc;
	private long projTeamLeaderId;
	private long projTeamId;
	private long projId;
	private ArrayList<Long> projTeamMembers;
	private String facEmail;
	String projTeamDesc;
	/*User columns*/
	private String firstName;
	private String midName;
	private String lastName;
	private String email;
	private String userName;
	private String userType;
	private long  contactNo;
	
	public ArrayList<Long> getProjTeamMembers() {
		return projTeamMembers;
	}
	public void setProjTeamMembers(ArrayList<Long> projTeamMembers) {
		this.projTeamMembers = projTeamMembers;
	}
	public String getProjTeamDesc() {
		return projTeamDesc;
	}
	public void setProjTeamDesc(String projTeamDesc) {
		this.projTeamDesc = projTeamDesc;
	}
	public ProjectXLSVO() {
		super();		
	}
	/**
	 * @param projUniversity
	 * @param projCollegeRgstrIdUsr
	 * @param projCollegeState
	 * @param projTypeId
	 * @param projTitle
	 * @param projAbstract
	 * @param projDescription
	 * @param projYear
	 * @param projStartDate
	 * @param projEndDate
	 * @param projBranches
	 * @param projKeywords
	 * @param projGuideId
	 * @param projMentor1Id
	 * @param projStatusId
	 * @param projToFloat
	 * @param projCommentsPublish
	 * @param projGrade
	 * @param projAwardWon
	 * @param projAwardDesc
	 * @param projTeamLeaderId
	 * @param projTeamId
	 * @param projId
	 * @param projTeamMembers
	 * @param firstName
	 * @param midName
	 * @param lastName
	 * @param email
	 * @param userName
	 * @param userType
	 * @param projTeamDesc
	 * * @param facEmail
	 * @param contactNO
	 */
	public ProjectXLSVO(String projUniversity, String projCollegeRgstrIdUsr,
			String projCollegeState, int projTypeId, String projTitle,
			String projAbstract, String projDescription, int projYear,
			Date projStartDate, Date projEndDate,
			ArrayList<Integer> projBranches, ArrayList<String> projKeywords,
			long projGuideId, long projMentor1Id, int projStatusId,
			String projToFloat, String projCommentsPublish, String projGrade,
			String projAwardWon, String projAwardDesc, long projTeamLeaderId,
			long projTeamId, long projId, ArrayList<Long> projTeamMembers,
			String firstName, String midName, String lastName, String email,
			String userName, String userType, String projTeamDesc, String facEmail,long contactNo) {
		this.projUniversity = projUniversity;
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
		this.projCollegeState = projCollegeState;
		this.projTypeId = projTypeId;
		this.projTitle = projTitle;
		this.projAbstract = projAbstract;
		this.projDescription = projDescription;
		this.projYear = projYear;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projBranches = projBranches;
		this.projKeywords = projKeywords;
		this.projGuideId = projGuideId;
		this.projMentor1Id = projMentor1Id;
		this.projStatusId = projStatusId;
		this.projToFloat = projToFloat;
		this.projCommentsPublish = projCommentsPublish;
		this.projGrade = projGrade;
		this.projAwardWon = projAwardWon;
		this.projAwardDesc = projAwardDesc;
		this.projTeamLeaderId = projTeamLeaderId;
		this.projTeamId = projTeamId;
		this.projId = projId;
		this.projTeamMembers = projTeamMembers;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.userType = userType;
		this.projTeamDesc = projTeamDesc;
		this.facEmail = facEmail;
	}
	public String getProjUniversity() {
		return projUniversity;
	}
	public void setProjUniversity(String projUniversity) {
		this.projUniversity = projUniversity;
	}
	public String getProjCollegeRgstrIdUsr() {
		return projCollegeRgstrIdUsr;
	}
	public void setProjCollegeRgstrIdUsr(String projCollegeRgstrIdUsr) {
		this.projCollegeRgstrIdUsr = projCollegeRgstrIdUsr;
	}
	public String getProjCollegeState() {
		return projCollegeState;
	}
	public void setProjCollegeState(String projCollegeState) {
		this.projCollegeState = projCollegeState;
	}
	public int getProjTypeId() {
		return projTypeId;
	}
	public void setProjTypeId(int projTypeId) {
		this.projTypeId = projTypeId;
	}
	public String getProjTitle() {
		return projTitle;
	}
	public void setProjTitle(String projTitle) {
		this.projTitle = projTitle;
	}
	public String getProjAbstract() {
		return projAbstract;
	}
	public void setProjAbstract(String projAbstract) {
		this.projAbstract = projAbstract;
	}
	public String getProjDescription() {
		return projDescription;
	}
	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}
	public int getProjYear() {
		return projYear;
	}
	public void setProjYear(int projYear) {
		this.projYear = projYear;
	}
	public Date getProjStartDate() {
		return projStartDate;
	}
	public void setProjStartDate(Date projStartDate) {
		this.projStartDate = projStartDate;
	}
	public Date getProjEndDate() {
		return projEndDate;
	}
	public void setProjEndDate(Date projEndDate) {
		this.projEndDate = projEndDate;
	}
	public ArrayList<Integer> getProjBranches() {
		return projBranches;
	}
	public void setProjBranches(ArrayList<Integer> projBranches) {
		this.projBranches = projBranches;
	}
	public ArrayList<String> getProjKeywords() {
		return projKeywords;
	}
	public void setProjKeywords(ArrayList<String> projKeywords) {
		this.projKeywords = projKeywords;
	}
	public long getProjGuideId() {
		return projGuideId;
	}
	public void setProjGuideId(long projGuideId) {
		this.projGuideId = projGuideId;
	}
	public long getProjMentor1Id() {
		return projMentor1Id;
	}
	public void setProjMentor1Id(long projMentor1Id) {
		this.projMentor1Id = projMentor1Id;
	}
	public int getProjStatusId() {
		return projStatusId;
	}
	public void setProjStatusId(int projStatusId) {
		this.projStatusId = projStatusId;
	}
	public String getProjToFloat() {
		return projToFloat;
	}
	public void setProjToFloat(String projToFloat) {
		this.projToFloat = projToFloat;
	}
	public String getProjCommentsPublish() {
		return projCommentsPublish;
	}
	public void setProjCommentsPublish(String projCommentsPublish) {
		this.projCommentsPublish = projCommentsPublish;
	}
	public String getProjGrade() {
		return projGrade;
	}
	public void setProjGrade(String projGrade) {
		this.projGrade = projGrade;
	}
	public String getProjAwardWon() {
		return projAwardWon;
	}
	public void setProjAwardWon(String projAwardWon) {
		this.projAwardWon = projAwardWon;
	}
	public String getProjAwardDesc() {
		return projAwardDesc;
	}
	public void setProjAwardDesc(String projAwardDesc) {
		this.projAwardDesc = projAwardDesc;
	}
	public long getProjTeamLeaderId() {
		return projTeamLeaderId;
	}
	public void setProjTeamLeaderId(long projTeamLeaderId) {
		this.projTeamLeaderId = projTeamLeaderId;
	}
	public long getProjTeamId() {
		return projTeamId;
	}
	public void setProjTeamId(long projTeamId) {
		this.projTeamId = projTeamId;
	}
	public long getProjId() {
		return projId;
	}
	public void setProjId(long projId) {
		this.projId = projId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the midName
	 */
	public String getMidName() {
		return midName;
	}
	/**
	 * @param midName the midName to set
	 */
	public void setMidName(String midName) {
		this.midName = midName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the facEmail
	 */
	public String getFacEmail() {
		return facEmail;
	}
	/**
	 * @param facEmail the facEmail to set
	 */
	public void setFacEmail(String facEmail) {
		this.facEmail = facEmail;
	}
	/**
	 * @return the contactNo
	 */
	public long getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	 
	}
