package com.techpedia.usermanagement.dataobject;

public class UserProfileDO {



	//USR_MNGT_MASTER	
	private long rgstrId;
	private String firstName;
	private String midName;
	private String lastName;
	private String dob;
	private String iSactive;
	private String userType;
	private String userName;
	private String faceBookId;
	private String email;
	private String twitterId;
	private String linkedinId;
	private String isMobile;
	private String gender;
	private String age;

	//USR_MNGT_ADDR
	private String address;
	private String addrLn1;
	private String addrLn2;
	private String city;
	private String pincode;
	private String country;
	private String state;
	private String district;

	//USR_MNGT_CONTACT_INFO
	private String mobile;
	private String homePhoneNo;
	private String photo;
	private String photoPath;
	private String imgName;
	private String imgByteArray;
	private String isPhoto;

	//USR_MNGT_STUDENT
	private String collegeState;
	private String degreeOfStudent;
	private String collge;
	private String studentID;
	private String completionYear;
	private String university;
	private String branchIdOfStudent;
	private String projectBranchDescOfStudent;

	//USR_MNGT_MENTOR
	private String degreeOfMentor;
	private String designationOfMentor;
	private String branchIdOfMentor;
	private String institutionalAssctnInfo;
	private String professionalExperience;
	private String timeUspaceForMentoringPerMnth;
	private String mentorProfile;
	private String expectationFromMentor;
	private String commitmentUBringIn;
	private String intOnGrassrtInnovators;
	private int popularity;
	private String projectBranchDescOfMentor;
	
	
	//USR_MNGT_COLLEGE
	private String webpage;
	private String logo;
	private String cntctPerNameofCollege;
	private String collgeContactEmail;
	private String prinicipalName;
	private String prinicipalEmail;
	private String facilitiesOffrdToStudents;
	private String cntctInfoForNatnlInnovnClub;
	private String collegeInfoForCollege;
	private String affltUniversityOfCollege;
	private String techpdaFactlyCoordtr;
	
	
	//USR_MNGT_INDUSTRY
	private String fax;
	private String contactNameOfIndustry;
	private String contactEmailOfIndustry;
	private String operatnSectr;
	private String kindOfSprtUProvideInnovtr;
	private String prdRng;
	private String associateIndustry;
	private String techngyExprtizOffrToOthers;
	private String solnReqrdForTechnlgicalChlngs;
	private String intrstToPoseInnovtnChlngAwrds;
	
	
	//USR_MNGT_FACULTY
	private String degreeOfFaculty;
	private String collgeOfFaculty;
	private String specializationOfFaculty;
	private String universityOfFaculty;
	private String alumni;
	private String memshipInAssocns;
	private String psnlWebpgLink;
	private String proffesionalExpOfFaculty;
	private String affltUniversityOfFaculty;
	private String branchIdOfFaculty;
	private String projectBranchDescOfFaculty;
	



	//USR_MNGT_PASSWD
	private String password;
	
	//USR_MNGT_COLLEGE_MASTER
	
	private String collegeName;
	private String collegeDesc;
	
	
	//TB_TECH001_MAST_BRANCH
	private String branchId;
	private String projectBranchDesc;
	
	
	
	//Authorization
	private UsrAccessDetails usrAccessDetails;

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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the iSactive
	 */
	public String getiSactive() {
		return iSactive;
	}

	/**
	 * @param iSactive the iSactive to set
	 */
	public void setiSactive(String iSactive) {
		this.iSactive = iSactive;
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
	 * @return the faceBookId
	 */
	public String getFaceBookId() {
		return faceBookId;
	}

	/**
	 * @param faceBookId the faceBookId to set
	 */
	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
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
	 * @return the twitterId
	 */

	public String getTwitterId() {
		return twitterId;
	}
	/**
	 * @param twitterid the twitterId to set
	 */
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	/**
	 * @return the linkedinId
	 */

	public String getLinkedinId() {
		return linkedinId;
	}
	/**
	 * @param linkedinId the linkedinId to set
	 */
	public void setLinkedinId(String linkedinId) {
		this.linkedinId = linkedinId;
	}
	
	/**
	 * @return the isMobile
	 */
	public String getIsMobile() {
		return isMobile;
	}

	/**
	 * @param isMobile the isMobile to set
	 */
	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}
	

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addrLn1
	 */
	public String getAddrLn1() {
		return addrLn1;
	}

	/**
	 * @param addrLn1 the addrLn1 to set
	 */
	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}

	/**
	 * @return the addrLn2
	 */
	public String getAddrLn2() {
		return addrLn2;
	}

	/**
	 * @param addrLn2 the addrLn2 to set
	 */
	public void setAddrLn2(String addrLn2) {
		this.addrLn2 = addrLn2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the homePhoneNo
	 */
	public String getHomePhoneNo() {
		return homePhoneNo;
	}

	/**
	 * @param homePhoneNo the homePhoneNo to set
	 */
	public void setHomePhoneNo(String homePhoneNo) {
		this.homePhoneNo = homePhoneNo;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	/**
	 * @return the degreeOfStudent
	 */
	public String getDegreeOfStudent() {
		return degreeOfStudent;
	}

	/**
	 * @param degreeOfStudent the degreeOfStudent to set
	 */
	public void setDegreeOfStudent(String degreeOfStudent) {
		this.degreeOfStudent = degreeOfStudent;
	}

	/**
	 * @return the collge
	 */
	public String getCollge() {
		return collge;
	}

	/**
	 * @param collge the collge to set
	 */
	public void setCollge(String collge) {
		this.collge = collge;
	}

	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the completionYear
	 */
	public String getCompletionYear() {
		return completionYear;
	}

	/**
	 * @param completionYear the completionYear to set
	 */
	public void setCompletionYear(String completionYear) {
		this.completionYear = completionYear;
	}

	/**
	 * @return the university
	 */
	public String getUniversity() {
		return university;
	}

	/**
	 * @param university the university to set
	 */
	public void setUniversity(String university) {
		this.university = university;
	}

	

	/**
	 * @return the degreeOfMentor
	 */
	public String getDegreeOfMentor() {
		return degreeOfMentor;
	}

	/**
	 * @param degreeOfMentor the degreeOfMentor to set
	 */
	public void setDegreeOfMentor(String degreeOfMentor) {
		this.degreeOfMentor = degreeOfMentor;
	}

	

	/**
	 * @return the designationOfMentor
	 */
	public String getDesignationOfMentor() {
		return designationOfMentor;
	}

	/**
	 * @param designationOfMentor the designationOfMentor to set
	 */
	public void setDesignationOfMentor(String designationOfMentor) {
		this.designationOfMentor = designationOfMentor;
	}

	



	/**
	 * @return the institutionalAssctnInfo
	 */
	public String getInstitutionalAssctnInfo() {
		return institutionalAssctnInfo;
	}

	/**
	 * @param institutionalAssctnInfo the institutionalAssctnInfo to set
	 */
	public void setInstitutionalAssctnInfo(String institutionalAssctnInfo) {
		this.institutionalAssctnInfo = institutionalAssctnInfo;
	}

	/**
	 * @return the professionalExperience
	 */
	public String getProfessionalExperience() {
		return professionalExperience;
	}

	/**
	 * @param professionalExperience the professionalExperience to set
	 */
	public void setProfessionalExperience(String professionalExperience) {
		this.professionalExperience = professionalExperience;
	}

	/**
	 * @return the timeUspaceForMentoringPerMnth
	 */
	public String getTimeUspaceForMentoringPerMnth() {
		return timeUspaceForMentoringPerMnth;
	}

	/**
	 * @param timeUspaceForMentoringPerMnth the timeUspaceForMentoringPerMnth to set
	 */
	public void setTimeUspaceForMentoringPerMnth(
			String timeUspaceForMentoringPerMnth) {
		this.timeUspaceForMentoringPerMnth = timeUspaceForMentoringPerMnth;
	}

	/**
	 * @return the mentorProfile
	 */
	public String getMentorProfile() {
		return mentorProfile;
	}

	/**
	 * @param mentorProfile the mentorProfile to set
	 */
	public void setMentorProfile(String mentorProfile) {
		this.mentorProfile = mentorProfile;
	}

	/**
	 * @return the expectationFromMentor
	 */
	public String getExpectationFromMentor() {
		return expectationFromMentor;
	}

	/**
	 * @param expectationFromMentor the expectationFromMentor to set
	 */
	public void setExpectationFromMentor(String expectationFromMentor) {
		this.expectationFromMentor = expectationFromMentor;
	}

	/**
	 * @return the commitmentUBringIn
	 */
	public String getCommitmentUBringIn() {
		return commitmentUBringIn;
	}

	/**
	 * @param commitmentUBringIn the commitmentUBringIn to set
	 */
	public void setCommitmentUBringIn(String commitmentUBringIn) {
		this.commitmentUBringIn = commitmentUBringIn;
	}

	/**
	 * @return the intOnGrassrtInnovators
	 */
	public String getIntOnGrassrtInnovators() {
		return intOnGrassrtInnovators;
	}

	/**
	 * @param intOnGrassrtInnovators the intOnGrassrtInnovators to set
	 */
	public void setIntOnGrassrtInnovators(String intOnGrassrtInnovators) {
		this.intOnGrassrtInnovators = intOnGrassrtInnovators;
	}

	/**
	 * @return the webpage
	 */
	public String getWebpage() {
		return webpage;
	}

	/**
	 * @param webpage the webpage to set
	 */
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the cntctPerNameofCollege
	 */
	public String getCntctPerNameofCollege() {
		return cntctPerNameofCollege;
	}

	/**
	 * @param cntctPerNameofCollege the cntctPerNameofCollege to set
	 */
	public void setCntctPerNameofCollege(String cntctPerNameofCollege) {
		this.cntctPerNameofCollege = cntctPerNameofCollege;
	}

	/**
	 * @return the collgeContactEmail
	 */
	public String getCollgeContactEmail() {
		return collgeContactEmail;
	}

	/**
	 * @param collgeContactEmail the collgeContactEmail to set
	 */
	public void setCollgeContactEmail(String collgeContactEmail) {
		this.collgeContactEmail = collgeContactEmail;
	}

	/**
	 * @return the prinicipalName
	 */
	public String getPrinicipalName() {
		return prinicipalName;
	}

	/**
	 * @param prinicipalName the prinicipalName to set
	 */
	public void setPrinicipalName(String prinicipalName) {
		this.prinicipalName = prinicipalName;
	}

	/**
	 * @return the prinicipalEmail
	 */
	public String getPrinicipalEmail() {
		return prinicipalEmail;
	}

	/**
	 * @param prinicipalEmail the prinicipalEmail to set
	 */
	public void setPrinicipalEmail(String prinicipalEmail) {
		this.prinicipalEmail = prinicipalEmail;
	}

	/**
	 * @return the facilitiesOffrdToStudents
	 */
	public String getFacilitiesOffrdToStudents() {
		return facilitiesOffrdToStudents;
	}

	/**
	 * @param facilitiesOffrdToStudents the facilitiesOffrdToStudents to set
	 */
	public void setFacilitiesOffrdToStudents(String facilitiesOffrdToStudents) {
		this.facilitiesOffrdToStudents = facilitiesOffrdToStudents;
	}

	/**
	 * @return the cntctInfoForNatnlInnovnClub
	 */
	public String getCntctInfoForNatnlInnovnClub() {
		return cntctInfoForNatnlInnovnClub;
	}

	/**
	 * @param cntctInfoForNatnlInnovnClub the cntctInfoForNatnlInnovnClub to set
	 */
	public void setCntctInfoForNatnlInnovnClub(String cntctInfoForNatnlInnovnClub) {
		this.cntctInfoForNatnlInnovnClub = cntctInfoForNatnlInnovnClub;
	}

	/**
	 * @return the affltUniversityOfCollege
	 */
	public String getAffltUniversityOfCollege() {
		return affltUniversityOfCollege;
	}

	/**
	 * @param affltUniversityOfCollege the affltUniversityOfCollege to set
	 */
	public void setAffltUniversityOfCollege(String affltUniversityOfCollege) {
		this.affltUniversityOfCollege = affltUniversityOfCollege;
	}

	/**
	 * @return the techpdaFactlyCoordtr
	 */
	public String getTechpdaFactlyCoordtr() {
		return techpdaFactlyCoordtr;
	}

	/**
	 * @param techpdaFactlyCoordtr the techpdaFactlyCoordtr to set
	 */
	public void setTechpdaFactlyCoordtr(String techpdaFactlyCoordtr) {
		this.techpdaFactlyCoordtr = techpdaFactlyCoordtr;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the contactNameOfIndustry
	 */
	public String getContactNameOfIndustry() {
		return contactNameOfIndustry;
	}

	/**
	 * @param contactNameOfIndustry the contactNameOfIndustry to set
	 */
	public void setContactNameOfIndustry(String contactNameOfIndustry) {
		this.contactNameOfIndustry = contactNameOfIndustry;
	}

	/**
	 * @return the contactEmailOfIndustry
	 */
	public String getContactEmailOfIndustry() {
		return contactEmailOfIndustry;
	}

	/**
	 * @param contactEmailOfIndustry the contactEmailOfIndustry to set
	 */
	public void setContactEmailOfIndustry(String contactEmailOfIndustry) {
		this.contactEmailOfIndustry = contactEmailOfIndustry;
	}

	/**
	 * @return the operatnSectr
	 */
	public String getOperatnSectr() {
		return operatnSectr;
	}

	/**
	 * @param operatnSectr the operatnSectr to set
	 */
	public void setOperatnSectr(String operatnSectr) {
		this.operatnSectr = operatnSectr;
	}

	/**
	 * @return the kindOfSprtUProvideInnovtr
	 */
	public String getKindOfSprtUProvideInnovtr() {
		return kindOfSprtUProvideInnovtr;
	}

	/**
	 * @param kindOfSprtUProvideInnovtr the kindOfSprtUProvideInnovtr to set
	 */
	public void setKindOfSprtUProvideInnovtr(String kindOfSprtUProvideInnovtr) {
		this.kindOfSprtUProvideInnovtr = kindOfSprtUProvideInnovtr;
	}

	/**
	 * @return the prdRng
	 */
	public String getPrdRng() {
		return prdRng;
	}

	/**
	 * @param prdRng the prdRng to set
	 */
	public void setPrdRng(String prdRng) {
		this.prdRng = prdRng;
	}

	/**
	 * @return the associateIndustry
	 */
	public String getAssociateIndustry() {
		return associateIndustry;
	}

	/**
	 * @param associateIndustry the associateIndustry to set
	 */
	public void setAssociateIndustry(String associateIndustry) {
		this.associateIndustry = associateIndustry;
	}

	/**
	 * @return the techngyExprtizOffrToOthers
	 */
	public String getTechngyExprtizOffrToOthers() {
		return techngyExprtizOffrToOthers;
	}

	/**
	 * @param techngyExprtizOffrToOthers the techngyExprtizOffrToOthers to set
	 */
	public void setTechngyExprtizOffrToOthers(String techngyExprtizOffrToOthers) {
		this.techngyExprtizOffrToOthers = techngyExprtizOffrToOthers;
	}

	/**
	 * @return the solnReqrdForTechnlgicalChlngs
	 */
	public String getSolnReqrdForTechnlgicalChlngs() {
		return solnReqrdForTechnlgicalChlngs;
	}

	/**
	 * @param solnReqrdForTechnlgicalChlngs the solnReqrdForTechnlgicalChlngs to set
	 */
	public void setSolnReqrdForTechnlgicalChlngs(
			String solnReqrdForTechnlgicalChlngs) {
		this.solnReqrdForTechnlgicalChlngs = solnReqrdForTechnlgicalChlngs;
	}

	/**
	 * @return the intrstToPoseInnovtnChlngAwrds
	 */
	public String getIntrstToPoseInnovtnChlngAwrds() {
		return intrstToPoseInnovtnChlngAwrds;
	}

	/**
	 * @param intrstToPoseInnovtnChlngAwrds the intrstToPoseInnovtnChlngAwrds to set
	 */
	public void setIntrstToPoseInnovtnChlngAwrds(
			String intrstToPoseInnovtnChlngAwrds) {
		this.intrstToPoseInnovtnChlngAwrds = intrstToPoseInnovtnChlngAwrds;
	}

	/**
	 * @return the degreeOfFaculty
	 */
	public String getDegreeOfFaculty() {
		return degreeOfFaculty;
	}

	/**
	 * @param degreeOfFaculty the degreeOfFaculty to set
	 */
	public void setDegreeOfFaculty(String degreeOfFaculty) {
		this.degreeOfFaculty = degreeOfFaculty;
	}

	/**
	 * @return the collgeOfFaculty
	 */
	public String getCollgeOfFaculty() {
		return collgeOfFaculty;
	}

	/**
	 * @param collgeOfFaculty the collgeOfFaculty to set
	 */
	public void setCollgeOfFaculty(String collgeOfFaculty) {
		this.collgeOfFaculty = collgeOfFaculty;
	}

	/**
	 * @return the specializationOfFaculty
	 */
	public String getSpecializationOfFaculty() {
		return specializationOfFaculty;
	}

	/**
	 * @param specializationOfFaculty the specializationOfFaculty to set
	 */
	public void setSpecializationOfFaculty(String specializationOfFaculty) {
		this.specializationOfFaculty = specializationOfFaculty;
	}

	/**
	 * @return the universityOfFaculty
	 */
	public String getUniversityOfFaculty() {
		return universityOfFaculty;
	}

	/**
	 * @param universityOfFaculty the universityOfFaculty to set
	 */
	public void setUniversityOfFaculty(String universityOfFaculty) {
		this.universityOfFaculty = universityOfFaculty;
	}

	/**
	 * @return the alumni
	 */
	public String getAlumni() {
		return alumni;
	}

	/**
	 * @param alumni the alumni to set
	 */
	public void setAlumni(String alumni) {
		this.alumni = alumni;
	}

	/**
	 * @return the memshipInAssocns
	 */
	public String getMemshipInAssocns() {
		return memshipInAssocns;
	}

	/**
	 * @param memshipInAssocns the memshipInAssocns to set
	 */
	public void setMemshipInAssocns(String memshipInAssocns) {
		this.memshipInAssocns = memshipInAssocns;
	}

	/**
	 * @return the psnlWebpgLink
	 */
	public String getPsnlWebpgLink() {
		return psnlWebpgLink;
	}

	/**
	 * @param psnlWebpgLink the psnlWebpgLink to set
	 */
	public void setPsnlWebpgLink(String psnlWebpgLink) {
		this.psnlWebpgLink = psnlWebpgLink;
	}

	public String getBranchIdOfMentor() {
		return branchIdOfMentor;
	}

	public void setBranchIdOfMentor(String branchIdOfMentor) {
		this.branchIdOfMentor = branchIdOfMentor;
	}

	/**
	 * @return the proffesionalExpOfFaculty
	 */
	public String getProffesionalExpOfFaculty() {
		return proffesionalExpOfFaculty;
	}

	/**
	 * @param proffesionalExpOfFaculty the proffesionalExpOfFaculty to set
	 */
	public void setProffesionalExpOfFaculty(String proffesionalExpOfFaculty) {
		this.proffesionalExpOfFaculty = proffesionalExpOfFaculty;
	}

	/**
	 * @return the affltUniversityOfFaculty
	 */
	public String getAffltUniversityOfFaculty() {
		return affltUniversityOfFaculty;
	}

	/**
	 * @param affltUniversityOfFaculty the affltUniversityOfFaculty to set
	 */
	public void setAffltUniversityOfFaculty(String affltUniversityOfFaculty) {
		this.affltUniversityOfFaculty = affltUniversityOfFaculty;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
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
	 * @return the collegeDesc
	 */
	public String getCollegeDesc() {
		return collegeDesc;
	}

	/**
	 * @param collegeDesc the collegeDesc to set
	 */
	public void setCollegeDesc(String collegeDesc) {
		this.collegeDesc = collegeDesc;
	}

	/**
	 * @return the usrAccessDetails
	 */
	public UsrAccessDetails getUsrAccessDetails() {
		return usrAccessDetails;
	}

	/**
	 * @param usrAccessDetails the usrAccessDetails to set
	 */
	public void setUsrAccessDetails(UsrAccessDetails usrAccessDetails) {
		this.usrAccessDetails = usrAccessDetails;
	}

	/**
	 * @return the popularity
	 */
	public int getPopularity() {
		return popularity;
	}

	/**
	 * @param popularity the popularity to set
	 */
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public String getBranchIdOfFaculty() {
		return branchIdOfFaculty;
	}

	public void setBranchIdOfFaculty(String branchIdOfFaculty) {
		this.branchIdOfFaculty = branchIdOfFaculty;
	}	

	public String getBranchIdOfStudent() {
		return branchIdOfStudent;
	}

	public void setBranchIdOfStudent(String branchIdOfStudent) {
		this.branchIdOfStudent = branchIdOfStudent;
	}

	public String getProjectBranchDescOfStudent() {
		return projectBranchDescOfStudent;
	}

	public void setProjectBranchDescOfStudent(String projectBranchDescOfStudent) {
		this.projectBranchDescOfStudent = projectBranchDescOfStudent;
	}

	public String getProjectBranchDescOfMentor() {
		return projectBranchDescOfMentor;
	}

	public void setProjectBranchDescOfMentor(String projectBranchDescOfMentor) {
		this.projectBranchDescOfMentor = projectBranchDescOfMentor;
	}

	public String getProjectBranchDescOfFaculty() {
		return projectBranchDescOfFaculty;
	}

	public void setProjectBranchDescOfFaculty(String projectBranchDescOfFaculty) {
		this.projectBranchDescOfFaculty = projectBranchDescOfFaculty;
	}

	
	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getProjectBranchDesc() {
		return projectBranchDesc;
	}

	public void setProjectBranchDesc(String projectBranchDesc) {
		this.projectBranchDesc = projectBranchDesc;
	}	
	
	/**
	 * @return the isPhoto
	 */
	public String getIsPhoto() {
		return isPhoto;
	}

	/**
	 * @param isPhoto the isPhoto to set
	 */
	public void setIsPhoto(String isPhoto) {
		this.isPhoto = isPhoto;
	}

	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photopath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @return the imgName
	 */
	public String getImgName() {
		return imgName;
	}

	/**
	 * @param imgName the imgName to set
	 */
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	/**
	 * @return the imgByteArray
	 */
	public String getImgByteArray() {
		return imgByteArray;
	}

	/**
	 * @param imgByteArray the imgByteArray to set
	 */
	public void setImgByteArray(String imgByteArray) {
		this.imgByteArray = imgByteArray;
	}

	/**
	 * @return the collegeState
	 */
	public String getCollegeState() {
		return collegeState;
	}

	/**
	 * @param collegeState the collegeState to set
	 */
	public void setCollegeState(String collegeState) {
		this.collegeState = collegeState;
	}

	/**
	 * @return the collegeInfoForCollege
	 */
	public String getCollegeInfoForCollege() {
		return collegeInfoForCollege;
	}

	/**
	 * @param collegeInfoForCollege the collegeInfoForCollege to set
	 */
	public void setCollegeInfoForCollege(String collegeInfoForCollege) {
		this.collegeInfoForCollege = collegeInfoForCollege;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserProfileDO [rgstrId=" + rgstrId + ", firstName=" + firstName
				+ ", midName=" + midName + ", lastName=" + lastName + ", dob="
				+ dob + ", iSactive=" + iSactive + ", userType=" + userType
				+ ", userName=" + userName + ", faceBookId=" + faceBookId
				+ ", email=" + email + ", twitterId=" + twitterId
				+ ", linkedinId=" + linkedinId +",isMobile="+isMobile+",gender="+gender+",age="+age+", address=" + address
				+ ", addrLn1=" + addrLn1 + ", addrLn2=" + addrLn2 + ", city="
				+ city + ", pincode=" + pincode + ", country=" + country
				+ ", state=" + state + ", district=" + district + ", mobile="
				+ mobile + ", homePhoneNo=" + homePhoneNo + ", photo=" + photo
				+ ", photoPath=" + photoPath + ", imgName=" + imgName
				+ ", imgByteArray=" + imgByteArray + ", isPhoto=" + isPhoto
				+ ", collegeState=" + collegeState + ", degreeOfStudent="
				+ degreeOfStudent + ", collge=" + collge + ", studentID="
				+ studentID + ", completionYear=" + completionYear
				+ ", university=" + university + ", branchIdOfStudent="
				+ branchIdOfStudent + ", projectBranchDescOfStudent="
				+ projectBranchDescOfStudent + ", degreeOfMentor="
				+ degreeOfMentor + ", designationOfMentor="
				+ designationOfMentor + ", branchIdOfMentor="
				+ branchIdOfMentor + ", institutionalAssctnInfo="
				+ institutionalAssctnInfo + ", professionalExperience="
				+ professionalExperience + ", timeUspaceForMentoringPerMnth="
				+ timeUspaceForMentoringPerMnth + ", mentorProfile="
				+ mentorProfile + ", expectationFromMentor="
				+ expectationFromMentor + ", commitmentUBringIn="
				+ commitmentUBringIn + ", intOnGrassrtInnovators="
				+ intOnGrassrtInnovators + ", popularity=" + popularity
				+ ", projectBranchDescOfMentor=" + projectBranchDescOfMentor
				+ ", webpage=" + webpage + ", logo=" + logo
				+ ", cntctPerNameofCollege=" + cntctPerNameofCollege
				+ ", collgeContactEmail=" + collgeContactEmail
				+ ", prinicipalName=" + prinicipalName + ", prinicipalEmail="
				+ prinicipalEmail + ", facilitiesOffrdToStudents="
				+ facilitiesOffrdToStudents + ", cntctInfoForNatnlInnovnClub="
				+ cntctInfoForNatnlInnovnClub + ", collegeInfoForCollege="
				+ collegeInfoForCollege + ", affltUniversityOfCollege="
				+ affltUniversityOfCollege + ", techpdaFactlyCoordtr="
				+ techpdaFactlyCoordtr + ", fax=" + fax
				+ ", contactNameOfIndustry=" + contactNameOfIndustry
				+ ", contactEmailOfIndustry=" + contactEmailOfIndustry
				+ ", operatnSectr=" + operatnSectr
				+ ", kindOfSprtUProvideInnovtr=" + kindOfSprtUProvideInnovtr
				+ ", prdRng=" + prdRng + ", associateIndustry="
				+ associateIndustry + ", techngyExprtizOffrToOthers="
				+ techngyExprtizOffrToOthers
				+ ", solnReqrdForTechnlgicalChlngs="
				+ solnReqrdForTechnlgicalChlngs
				+ ", intrstToPoseInnovtnChlngAwrds="
				+ intrstToPoseInnovtnChlngAwrds + ", degreeOfFaculty="
				+ degreeOfFaculty + ", collgeOfFaculty=" + collgeOfFaculty
				+ ", specializationOfFaculty=" + specializationOfFaculty
				+ ", universityOfFaculty=" + universityOfFaculty + ", alumni="
				+ alumni + ", memshipInAssocns=" + memshipInAssocns
				+ ", psnlWebpgLink=" + psnlWebpgLink
				+ ", proffesionalExpOfFaculty=" + proffesionalExpOfFaculty
				+ ", affltUniversityOfFaculty=" + affltUniversityOfFaculty
				+ ", branchIdOfFaculty=" + branchIdOfFaculty
				+ ", projectBranchDescOfFaculty=" + projectBranchDescOfFaculty
				+ ", password=" + password + ", collegeName=" + collegeName
				+ ", collegeDesc=" + collegeDesc + ", branchId=" + branchId
				+ ", projectBranchDesc=" + projectBranchDesc
				+ ", usrAccessDetails=" + usrAccessDetails + "]";
	}

		
	
	
	
}
