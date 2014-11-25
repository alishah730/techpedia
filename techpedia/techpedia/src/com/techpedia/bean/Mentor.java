package com.techpedia.bean;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

public class Mentor {
	private String prdRng;
	private String psnlWebpgLink;
	private String facilitiesOffrdToStudents;
	private String commitmentUBringIn;
	private Long collegeDesc;
	private Long homePhoneNo;
	private String designationOfMentor;
	private Long password;
	private Long city;
	private Long userType;
	private Long intrstToPoseInnovtnChlngAwrds;
	private String addrLn1;
	private String addrLn2;
	private String prinicipalEmail;
	private String cntctInfoForNatnlInnovnClub;
	private String userName;
	private String specializationOfFaculty;
	private String lastName;
	private Long fax;
	private String degreeOfStudent;
	private Long rgstrId;
	private String affltUniversityOfFaculty;
	private String alumni;
	private String operatnSectr;
	private String collegeName;
	private String expectationFromMentor;
	private String collgeContactEmail;
	private String associateIndustry;
	private String country;
	private int pincode;
	private Long proffesionalExpOfFaculty;
	private String photo;
	private String kindOfSprtUProvideInnovtr;
	private String email;
	private String webpage;
	private String degreeOfMentor;
	private String studentID;
	private String prinicipalName;
	private Long mobile;
	private String affltUniversityOfCollege;
	private boolean iSactive;
	private String state;
	private String degreeOfFaculty;
	private String intOnGrassrtInnovators;
	private String specializationOfMentor;
	private int completionYear;
	private String collgeOfFaculty;
	private String techngyExprtizOffrToOthers;
	private String techpdaFactlyCoordtr;
	private String memshipInAssocns;
	private String collge;
	private String district;
	private String institutionalAssctnInfo;
	private String firstName;
	private String mentorProfile;
	private String cntctPerNameofCollege;
	private String logo;
	private String university;
	private String contactNameOfIndustry;
	private String midName;
	private String universityOfFaculty;
	private String solnReqrdForTechnlgicalChlngs;
	private Long professionalExperience;
	private String timeUspaceForMentoringPerMnth;
	private String address;
	private Long dob;
	private String faceBookId;
	private String contactEmailOfIndustry;
	
	@JsonIgnore
	public String getKindOfSprtUProvideInnovtr() {
		return kindOfSprtUProvideInnovtr;
	}
	public void setKindOfSprtUProvideInnovtr(String kindOfSprtUProvideInnovtr) {
		this.kindOfSprtUProvideInnovtr = kindOfSprtUProvideInnovtr;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@JsonIgnore
	public Long getProffesionalExpOfFaculty() {
		return proffesionalExpOfFaculty;
	}
	public void setProffesionalExpOfFaculty(Long proffesionalExpOfFaculty) {
		this.proffesionalExpOfFaculty = proffesionalExpOfFaculty;
	}
	@JsonIgnore
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	@JsonIgnore
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@JsonIgnore
	public String getAssociateIndustry() {
		return associateIndustry;
	}
	public void setAssociateIndustry(String associateIndustry) {
		this.associateIndustry = associateIndustry;
	}
	@JsonIgnore
	public String getCollgeContactEmail() {
		return collgeContactEmail;
	}
	public void setCollgeContactEmail(String collgeContactEmail) {
		this.collgeContactEmail = collgeContactEmail;
	}

	@JsonIgnore
	public String getExpectationFromMentor() {
		return expectationFromMentor;
	}
	public void setExpectationFromMentor(String expectationFromMentor) {
		this.expectationFromMentor = expectationFromMentor;
	}
	
	@JsonIgnore
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@JsonIgnore
	public String getOperatnSectr() {
		return operatnSectr;
	}
	public void setOperatnSectr(String operatnSectr) {
		this.operatnSectr = operatnSectr;
	}
	
	@JsonIgnore
	public String getAlumni() {
		return alumni;
	}
	public void setAlumni(String alumni) {
		this.alumni = alumni;
	}
	@JsonIgnore
	public String getAffltUniversityOfFaculty() {
		return affltUniversityOfFaculty;
	}
	public void setAffltUniversityOfFaculty(String affltUniversityOfFaculty) {
		this.affltUniversityOfFaculty = affltUniversityOfFaculty;
	}
	
	public Long getRgstrId() {
		return rgstrId;
	}
	public void setRgstrId(Long rgstrId) {
		this.rgstrId = rgstrId;
	}
	
	@JsonIgnore
	public String getDegreeOfStudent() {
		return degreeOfStudent;
	}
	public void setDegreeOfStudent(String degreeOfStudent) {
		this.degreeOfStudent = degreeOfStudent;
	}
	@JsonIgnore
	public Long getFax() {
		return fax;
	}
	public void setFax(Long fax) {
		this.fax = fax;
	}
	@JsonIgnore
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonIgnore
	public String getSpecializationOfFaculty() {
		return specializationOfFaculty;
	}
	public void setSpecializationOfFaculty(String specializationOfFaculty) {
		this.specializationOfFaculty = specializationOfFaculty;
	}
	
	@JsonIgnore
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public String getCntctInfoForNatnlInnovnClub() {
		return cntctInfoForNatnlInnovnClub;
	}
	public void setCntctInfoForNatnlInnovnClub(
			String cntctInfoForNatnlInnovnClub) {
		this.cntctInfoForNatnlInnovnClub = cntctInfoForNatnlInnovnClub;
	}
	@JsonIgnore
	public String getAddrLn2() {
		return addrLn2;
	}
	public void setAddrLn2(String addrLn2) {
		this.addrLn2 = addrLn2;
	}
	@JsonIgnore
	public String getPrinicipalEmail() {
		return prinicipalEmail;
	}
	public void setPrinicipalEmail(String prinicipalEmail) {
		this.prinicipalEmail = prinicipalEmail;
	}
	@JsonIgnore
	public String getAddrLn1() {
		return addrLn1;
	}
	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}
	@JsonIgnore
	public Long getIntrstToPoseInnovtnChlngAwrds() {
		return intrstToPoseInnovtnChlngAwrds;
	}
	public void setIntrstToPoseInnovtnChlngAwrds(
			Long intrstToPoseInnovtnChlngAwrds) {
		this.intrstToPoseInnovtnChlngAwrds = intrstToPoseInnovtnChlngAwrds;
	}
	@JsonIgnore
	public Long getUserType() {
		return userType;
	}
	public void setUserType(Long userType) {
		this.userType = userType;
	}
	@JsonIgnore
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	@JsonIgnore
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	public String getDesignationOfMentor() {
		return designationOfMentor;
	}
	public void setDesignationOfMentor(String designationOfMentor) {
		this.designationOfMentor = designationOfMentor;
	}
	@JsonIgnore
	public Long getHomePhoneNo() {
		return homePhoneNo;
	}
	public void setHomePhoneNo(Long homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}	
	@JsonIgnore
	public Long getCollegeDesc() {
		return collegeDesc;
	}
	public void setCollegeDesc(Long collegeDesc) {
		this.collegeDesc = collegeDesc;
	}
	
	@JsonIgnore
	public String getCommitmentUBringIn() {
		return commitmentUBringIn;
	}
	public void setCommitmentUBringIn(String commitmentUBringIn) {
		this.commitmentUBringIn = commitmentUBringIn;
	}	
	@JsonIgnore
	public String getFacilitiesOffrdToStudents() {
		return facilitiesOffrdToStudents;
	}
	public void setFacilitiesOffrdToStudents(String facilitiesOffrdToStudents) {
		this.facilitiesOffrdToStudents = facilitiesOffrdToStudents;
	}
	
	
	private	String mentorName;
	private	String mentorAddress;
	private String mentorPersonal;
	private	String mentorCity;
	private	String mentorState;
	private	String mentorCountry;
	private	String mentorZipcode;
	private	String mentorPosition;
	private	String mentorDegree;
	private	String mentorAssociation;
	private	String mentorExperience;
	private	String mentorSocieties;
	private	String mentorAlumni;
	private	MultipartFile mentorImage;
	private String captcha;
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getMentorAddress() {
		return mentorAddress;
	}
	public void setMentorAddress(String mentorAddress) {
		this.mentorAddress = mentorAddress;
	}
	public String getMentorPersonal() {
		return mentorPersonal;
	}
	public void setMentorPersonal(String mentorPersonal) {
		this.mentorPersonal = mentorPersonal;
	}
	public String getMentorCity() {
		return mentorCity;
	}
	public void setMentorCity(String mentorCity) {
		this.mentorCity = mentorCity;
	}
	public String getMentorState() {
		return mentorState;
	}
	public void setMentorState(String mentorState) {
		this.mentorState = mentorState;
	}
	public String getMentorCountry() {
		return mentorCountry;
	}
	public void setMentorCountry(String mentorCountry) {
		this.mentorCountry = mentorCountry;
	}
	public String getMentorZipcode() {
		return mentorZipcode;
	}
	public void setMentorZipcode(String mentorZipcode) {
		this.mentorZipcode = mentorZipcode;
	}
	public String getMentorPosition() {
		return mentorPosition;
	}
	public void setMentorPosition(String mentorPosition) {
		this.mentorPosition = mentorPosition;
	}
	public String getMentorDegree() {
		return mentorDegree;
	}
	public void setMentorDegree(String mentorDegree) {
		this.mentorDegree = mentorDegree;
	}
	public String getMentorAssociation() {
		return mentorAssociation;
	}
	public void setMentorAssociation(String mentorAssociation) {
		this.mentorAssociation = mentorAssociation;
	}
	public String getMentorExperience() {
		return mentorExperience;
	}
	public void setMentorExperience(String mentorExperience) {
		this.mentorExperience = mentorExperience;
	}
	public String getMentorSocieties() {
		return mentorSocieties;
	}
	public void setMentorSocieties(String mentorSocieties) {
		this.mentorSocieties = mentorSocieties;
	}
	public String getMentorAlumni() {
		return mentorAlumni;
	}
	public void setMentorAlumni(String mentorAlumni) {
		this.mentorAlumni = mentorAlumni;
	}
	public MultipartFile getMentorImage() {
		return mentorImage;
	}
	public void setMentorImage(MultipartFile mentorImage) {
		this.mentorImage = mentorImage;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@JsonIgnore
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	public String getWebpage() {
		return webpage;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	@JsonIgnore
	public String getDegreeOfMentor() {
		return degreeOfMentor;
	}
	public void setDegreeOfMentor(String degreeOfMentor) {
		this.degreeOfMentor = degreeOfMentor;
	}
	@JsonIgnore
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	@JsonIgnore
	public String getPrinicipalName() {
		return prinicipalName;
	}
	public void setPrinicipalName(String prinicipalName) {
		this.prinicipalName = prinicipalName;
	}
	@JsonIgnore
	public String getPsnlWebpgLink() {
		return psnlWebpgLink;
	}
	public void setPsnlWebpgLink(String psnlWebpgLink) {
		this.psnlWebpgLink = psnlWebpgLink;
	}
	@JsonIgnore
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	@JsonIgnore
	public String getAffltUniversityOfCollege() {
		return affltUniversityOfCollege;
	}
	public void setAffltUniversityOfCollege(String affltUniversityOfCollege) {
		this.affltUniversityOfCollege = affltUniversityOfCollege;
	}
	@JsonIgnore
	public boolean isiSactive() {
		return iSactive;
	}
	public void setiSactive(boolean iSactive) {
		this.iSactive = iSactive;
	}
	@JsonIgnore
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonIgnore
	public String getDegreeOfFaculty() {
		return degreeOfFaculty;
	}
	public void setDegreeOfFaculty(String degreeOfFaculty) {
		this.degreeOfFaculty = degreeOfFaculty;
	}
	@JsonIgnore
	public String getIntOnGrassrtInnovators() {
		return intOnGrassrtInnovators;
	}
	public void setIntOnGrassrtInnovators(String intOnGrassrtInnovators) {
		this.intOnGrassrtInnovators = intOnGrassrtInnovators;
	}
	@JsonIgnore
	public String getSpecializationOfMentor() {
		return specializationOfMentor;
	}
	public void setSpecializationOfMentor(String specializationOfMentor) {
		this.specializationOfMentor = specializationOfMentor;
	}
	@JsonIgnore
	public int getCompletionYear() {
		return completionYear;
	}
	public void setCompletionYear(int completionYear) {
		this.completionYear = completionYear;
	}
	@JsonIgnore
	public String getCollgeOfFaculty() {
		return collgeOfFaculty;
	}
	public void setCollgeOfFaculty(String collgeOfFaculty) {
		this.collgeOfFaculty = collgeOfFaculty;
	}
	@JsonIgnore
	public String getTechngyExprtizOffrToOthers() {
		return techngyExprtizOffrToOthers;
	}
	public void setTechngyExprtizOffrToOthers(String techngyExprtizOffrToOthers) {
		this.techngyExprtizOffrToOthers = techngyExprtizOffrToOthers;
	}
	@JsonIgnore
	public String getTechpdaFactlyCoordtr() {
		return techpdaFactlyCoordtr;
	}
	public void setTechpdaFactlyCoordtr(String techpdaFactlyCoordtr) {
		this.techpdaFactlyCoordtr = techpdaFactlyCoordtr;
	}
	@JsonIgnore
	public String getMemshipInAssocns() {
		return memshipInAssocns;
	}
	public void setMemshipInAssocns(String memshipInAssocns) {
		this.memshipInAssocns = memshipInAssocns;
	}
	@JsonIgnore
	public String getCollge() {
		return collge;
	}
	public void setCollge(String collge) {
		this.collge = collge;
	}
	@JsonIgnore
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonIgnore
	public String getInstitutionalAssctnInfo() {
		return institutionalAssctnInfo;
	}
	public void setInstitutionalAssctnInfo(String institutionalAssctnInfo) {
		this.institutionalAssctnInfo = institutionalAssctnInfo;
	}
	@JsonIgnore
	public String getMentorProfile() {
		return mentorProfile;
	}
	public void setMentorProfile(String mentorProfile) {
		this.mentorProfile = mentorProfile;
	}
	@JsonIgnore
	public String getCntctPerNameofCollege() {
		return cntctPerNameofCollege;
	}
	public void setCntctPerNameofCollege(String cntctPerNameofCollege) {
		this.cntctPerNameofCollege = cntctPerNameofCollege;
	}
	@JsonIgnore
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@JsonIgnore
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	@JsonIgnore
	public String getContactNameOfIndustry() {
		return contactNameOfIndustry;
	}
	public void setContactNameOfIndustry(String contactNameOfIndustry) {
		this.contactNameOfIndustry = contactNameOfIndustry;
	}
	@JsonIgnore
	public String getMidName() {
		return midName;
	}
	public void setMidName(String midName) {
		this.midName = midName;
	}
	@JsonIgnore
	public String getUniversityOfFaculty() {
		return universityOfFaculty;
	}
	public void setUniversityOfFaculty(String universityOfFaculty) {
		this.universityOfFaculty = universityOfFaculty;
	}
	@JsonIgnore
	public String getPrdRng() {
		return prdRng;
	}
	public void setPrdRng(String prdRng) {
		this.prdRng = prdRng;
	}
	@JsonIgnore
	public String getSolnReqrdForTechnlgicalChlngs() {
		return solnReqrdForTechnlgicalChlngs;
	}
	public void setSolnReqrdForTechnlgicalChlngs(
			String solnReqrdForTechnlgicalChlngs) {
		this.solnReqrdForTechnlgicalChlngs = solnReqrdForTechnlgicalChlngs;
	}
	@JsonIgnore
	public Long getProfessionalExperience() {
		return professionalExperience;
	}
	public void setProfessionalExperience(Long professionalExperience) {
		this.professionalExperience = professionalExperience;
	}
	@JsonIgnore
	public String getTimeUspaceForMentoringPerMnth() {
		return timeUspaceForMentoringPerMnth;
	}
	public void setTimeUspaceForMentoringPerMnth(
			String timeUspaceForMentoringPerMnth) {
		this.timeUspaceForMentoringPerMnth = timeUspaceForMentoringPerMnth;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonIgnore
	public Long getDob() {
		return dob;
	}
	public void setDob(Long dob) {
		this.dob = dob;
	}
	@JsonIgnore
	public String getFaceBookId() {
		return faceBookId;
	}
	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
	}
	@JsonIgnore
	public String getContactEmailOfIndustry() {
		return contactEmailOfIndustry;
	}
	public void setContactEmailOfIndustry(String contactEmailOfIndustry) {
		this.contactEmailOfIndustry = contactEmailOfIndustry;
	}
	
}
