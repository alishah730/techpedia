package com.techpedia.usermanagement.test;

import com.techpedia.usermanagement.dataobject.SearchCriteriaDO;
import com.techpedia.usermanagement.dataobject.UserProfileDO;
import com.techpedia.usermanagement.exception.CreateProfileException;
import com.techpedia.usermanagement.exception.ProfileNotFoundException;
import com.techpedia.usermanagement.exception.ProfileUpdateException;

public class HibernateTest {
	// main method

		public static void main(String args[]) throws CreateProfileException, ProfileNotFoundException, ProfileUpdateException {

			 UserProfileDO userprofile = new UserProfileDO();
			 //usr_mngt_master
			 userprofile.setRgstrId(new Long(26));
			 userprofile.setFirstName("Kareena");
			 userprofile.setMidName("kapoor");
			 userprofile.setLastName("KK");
			 userprofile.setUserName("kapoor14"); /* mandatory and unique field */
			 userprofile.setFaceBookId("techpedia@facebook.com");	/* Not null field*/
			 userprofile.setDob("1987/11/12");
			 userprofile.setEmail("techpedia@techpedia.com");
			 userprofile.setUserType("college");
			 //usr_mngt_password
			 userprofile.setPassword("prakash1234");
			 //usr_mngt_address
			 userprofile.setAddress("TechMaindra, Bahadurpally");
			 userprofile.setCity("Hyderabad");
			 userprofile.setDistrict("kutbullapur");
			 userprofile.setState("Telanagana");
			 userprofile.setCountry("India");
			 userprofile.setPincode("520072");
			 //usr_mngt_contactinfo
			 userprofile.setMobile("9985998567");
			 userprofile.setHomePhoneNo("040-2223444");
			 userprofile.setPhoto("Photo path");
			 //usr_mng_student
			 userprofile.setDegreeOfStudent("MS IT");
			 userprofile.setCollge("Mahindra Ecole Centrale");	
			 userprofile.setUniversity("JNTUH");
			 userprofile.setStudentID("TN5023456");
			 userprofile.setCompletionYear("2014-03-01");
			 //usr_mngt_college
			 userprofile.setWebpage("hhtps://msn.com/");
			 userprofile.setLogo("logo path or log blog");
			 userprofile.setCntctPerNameofCollege("person Name"); /* name of the person from the usr_mngt_master*/
			 userprofile.setCollgeContactEmail("test@techpedia.com");
			 userprofile.setPrinicipalName("Principal Name");
			 userprofile.setPrinicipalEmail("princiaplemail@gmail.com");
			 userprofile.setFacilitiesOffrdToStudents("facilities to the students");
			 userprofile.setCntctInfoForNatnlInnovnClub("contact person for national inno club");
			 userprofile.setAffltUniversityOfCollege("AICTE");
			 userprofile.setTechpdaFactlyCoordtr("facily co-ordinator for techpedia");
			 //usr_mngt_faculty
			 userprofile.setSpecializationOfFaculty("computers");
			 userprofile.setAlumni("alumni"); 
			 userprofile.setMemshipInAssocns("Membership");
			 userprofile.setPsnlWebpgLink("Https://www.personalwebpagelink.com/");
			 userprofile.setProffesionalExpOfFaculty("ProExp");
			 //usr_mngt_mentor
			 userprofile.setDesignationOfMentor("lab co-ordinator");
			 userprofile.setInstitutionalAssctnInfo("instituational Info");
			 userprofile.setProfessionalExperience("5 years");
			 userprofile.setTimeUspaceForMentoringPerMnth("5");
			 userprofile.setMentorProfile("mentor profile");
			 userprofile.setExpectationFromMentor("expectations");
			 userprofile.setCommitmentUBringIn("commitment");
			 userprofile.setIntOnGrassrtInnovators("Innnovaters");
			 //usr_mngt_industry
			 userprofile.setFax("Fax Details");
			 userprofile.setContactNameOfIndustry("contact name");
			 userprofile.setContactEmailOfIndustry("email@gmail.com");
			 userprofile.setOperatnSectr("Operation Sector");
			 userprofile.setKindOfSprtUProvideInnovtr("innovater");
			 userprofile.setPrdRng("prdRng");
			 userprofile.setAssociateIndustry("Associate Industry");
			 userprofile.setTechngyExprtizOffrToOthers("Technology Expertization");
			 userprofile.setSolnReqrdForTechnlgicalChlngs("solution for technological Changes");
			 userprofile.setIntrstToPoseInnovtnChlngAwrds("challange awards");
			 
			 
			 userprofile.setCollegeName("JNTU");
			 userprofile.setCollegeDesc("Anantapur");
			 
			 
			 //userprofile.setAreaOfMentoring("");
			// userprofile.setAssociateInfo("");
			
			// userprofile.setRgstrId(343901);
			 

			 boolean retval = false;
			 
			 
			 SearchCriteriaDO sdo = new SearchCriteriaDO();
			 sdo.setFirstName("K");
			 //sdo.setLastName("K");
			// sdo.setDob("1987-11-10");
			 
		/*	try {
				retval = new UserManagementDAOImpl().createProfile(userprofile);
			} catch (Exception e) {
				System.out.println("error" + e.getMessage());
				e.printStackTrace();
				throw new CreateProfileException("getting exception while creating profile");
				// TODO Auto-generated catch block
				
			}*/

			 System.out.println("Inserted the object " + retval);
			
		/*	
			 try {
				 List<UserProfileDO> uprofile = new UserManagementDAOImpl().searchUserProfiles(sdo);
				 System.out.println("obect size " + uprofile.size());
				 System.out.println("obect Data " + uprofile.toString());
				 } catch (Exception e) {
					System.out.println("error" + e.getMessage());
					e.printStackTrace();
					throw new CreateProfileException("getting exception while creating profile");
					// TODO Auto-generated catch block
					
				}*/
			//int rgid = 1;
			/* try {
				 UserManagementDAOHelper.getUsrRolePermissions(rgid);
			} catch (Exception e) {
				
				System.out.println("Error : " + e.getMessage());
			}*/
		 }

}
