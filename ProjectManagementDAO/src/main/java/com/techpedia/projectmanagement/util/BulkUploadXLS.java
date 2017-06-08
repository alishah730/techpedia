/**
 * 
 */
package com.techpedia.projectmanagement.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import jxl.Sheet;
import jxl.Workbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.techpedia.projectmanagement.bean.ProjectXLSVO;
import com.techpedia.projectmanagement.exception.BulkUploadException;

/**
 * @author 455959
 *
 */
public class BulkUploadXLS {
	
	Logger log = LoggerFactory.getLogger(BulkUploadXLS.class.getName());
	
	public ArrayList<ProjectXLSVO> readXLS(File inputWorkbook) throws BulkUploadException {
		
		ArrayList<ProjectXLSVO> projectXLSVOs = new ArrayList<ProjectXLSVO>();
		ProjectXLSVO projectXLSVO = null;
		Workbook workbook;
		Pattern regexForNumber = Pattern.compile("[0-9]+");
		Pattern regexForDate = Pattern.compile("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]");
		Pattern regexForEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		int projCollegePos = 0;
		int projUniversityPos = 1;
		int projCollegeStatePos = 2;
		int projTitlePos = 3;
		int projAbstractPos = 4;
		int projDescriptionPos = 5;
		int projYearPos = 6;
		int projStartDatePos = 7;
		int projEndDatePos = 8;
		int projAwardWonPos = 9;
		int projAwardDescPos = 10;
		int fnamePos = 11;
		int mnamePos = 12;
		int lnamePos = 13;
		int emailIdPos = 14;
		int mobileNoPos = 15;
		int branchIdPos = 16;
		int degreePos = 17;
		int yearOfPassPos = 18;
		int enrollmentNoPos = 19;
		
		int initialColumnIndexInAlphabet = 65;

		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = workbook.getSheet(0);
           
			for (int i = 1; i < sheet.getRows(); i++) {	
				
					projectXLSVO = new ProjectXLSVO();
					
					//PROJ_COLLEGE
					if(sheet.getCell(projCollegePos, i).getContents().trim()=="")
					{
						log.error("Please provide College Name at (row,col)  :: "+"("+(i+1)+","+(char)(char)(projCollegePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide College Name at (row,col)  :: "+"("+(i+1)+","+(char)(char)(projCollegePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projCollegePos, i).getContents().trim().length() > 1000)
					{  	
						log.error("The College Name at (row,col) cannot be more than 1000 chars long :: "+"("+(i+1)+","+(char)(char)(projCollegePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The College Name at (row,col) cannot be more than 1000 chars long :: "+"("+(i+1)+","+(char)(char)(projCollegePos+initialColumnIndexInAlphabet)+")");
					} 
				    if(sheet.getCell(projCollegePos, i).getContents().trim()!="")
					{    
					     projectXLSVO.setProjCollege(sheet.getCell(projCollegePos, i).getContents().trim());  
					}	
					
					//PROJ_UNIVERSITY
					if(sheet.getCell(projUniversityPos, i).getContents().trim()=="")
					{  		
						log.error("Please provide University Name at (row,col)  :: "+"("+(i+1)+","+(char)(char)(projUniversityPos+initialColumnIndexInAlphabet)+")");	
						throw new BulkUploadException("Please provide University Name at (row,col)  :: "+"("+(i+1)+","+(char)(char)(projUniversityPos+initialColumnIndexInAlphabet)+")");	
					} 
					if(sheet.getCell(projUniversityPos, i).getContents().trim().length() > 1000)
					{  		
						log.error("The University Name at (row,col) cannot be more than 1000 chars long :: "+"("+(i+1)+","+(char)(char)(projUniversityPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The University Name at (row,col) cannot be more than 1000 chars long :: "+"("+(i+1)+","+(char)(char)(projUniversityPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projUniversityPos, i).getContents().trim()!="")
					{    
						projectXLSVO.setProjUniversity(sheet.getCell(projUniversityPos, i).getContents().trim());
					}
					
					//PROJ_COLLEGE_STATE
					if(sheet.getCell(projCollegeStatePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide College State at (row,col) :: "+"("+(i+1)+","+(char)(char)(projCollegeStatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide College State at (row,col) :: "+"("+(i+1)+","+(char)(char)(projCollegeStatePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projCollegeStatePos, i).getContents().trim().length() > 100)
					{  		
						log.error("The College State at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(char)(projCollegeStatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The College State at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(char)(projCollegeStatePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projCollegeStatePos, i).getContents().trim()!="")
					{    
						projectXLSVO.setProjCollegeState(sheet.getCell(projCollegeStatePos, i).getContents().trim());
					}
					
					//PROJ_TITLE
					if(sheet.getCell(projTitlePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project Title at (row,col) :: "+"("+(i+1)+","+(char)(char)(projTitlePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Title at (row,col) :: "+"("+(i+1)+","+(char)(char)(projTitlePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projTitlePos, i).getContents().trim().length() > 200)
					{  	
						log.error("The Project Title at (row,col) cannot be more than 200 chars long :: "+"("+(i+1)+","+(char)(char)(projTitlePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Title at (row,col) cannot be more than 200 chars long :: "+"("+(i+1)+","+(char)(char)(projTitlePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projTitlePos, i).getContents().trim()!="")
					{    
						projectXLSVO.setProjTitle(sheet.getCell(projTitlePos, i).getContents().trim());
					}
					
					//PROJ_ABSTRACT
					if(sheet.getCell(projAbstractPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project Abstract at (row,col) :: "+"("+(i+1)+","+(char)(projAbstractPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Abstract at (row,col) :: "+"("+(i+1)+","+(char)(projAbstractPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projAbstractPos, i).getContents().trim().length() > 2000)
					{  	
						log.error("The Project Abtract at (row,col) cannot be more than 2000 chars long :: "+"("+(i+1)+","+(char)(projAbstractPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Abtract at (row,col) cannot be more than 2000 chars long :: "+"("+(i+1)+","+(char)(projAbstractPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projAbstractPos, i).getContents().trim()!="")
					{   
						projectXLSVO.setProjAbstract(sheet.getCell(projAbstractPos, i).getContents().trim());
					}
					
					//PROJ_DESCRIPTION
					if(sheet.getCell(projDescriptionPos, i).getContents().trim().length() > 4000)
					{  		
						log.error("The Project Description at (row,col) cannot be more than 4000 chars long :: "+"("+(i+1)+","+(char)(projDescriptionPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Description at (row,col) cannot be more than 4000 chars long :: "+"("+(i+1)+","+(char)(projDescriptionPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projDescriptionPos, i).getContents().trim()!="")
					{    
						projectXLSVO.setProjDescription(sheet.getCell(projDescriptionPos, i).getContents().trim());
					}
					
					//PROJ_YEAR
					if(sheet.getCell(projYearPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project Year at (row,col) :: "+"("+(i+1)+","+(char)(projYearPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Year at (row,col) :: "+"("+(i+1)+","+(char)(char)(projYearPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(projYearPos, i).getContents().trim().length() > 4)
					{  		
						log.error("The Project Year at (row,col) cannot be more than 4 digits :: "+"("+(i+1)+","+(char)(projYearPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Year at (row,col) cannot be more than 4 digits :: "+"("+(i+1)+","+(char)(projYearPos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForNumber.matcher(sheet.getCell(projYearPos, i).getContents().trim()).find())
					{  		
						log.error("The Project Year at (row,col) does not have a valid year  :: "+"("+(i+1)+","+(char)(projYearPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Year at (row,col) does not have a valid year  :: "+"("+(i+1)+","+(char)(projYearPos+initialColumnIndexInAlphabet)+")");
					} 
					if(sheet.getCell(projYearPos, i).getContents().trim()!="")
					{
						projectXLSVO.setProjYear(Integer.parseInt(sheet.getCell(projYearPos, i).getContents().trim()));
					}
					
					//PROJ_START_DATE
					if(sheet.getCell(projStartDatePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project Start Date at (row,col) :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Start Date at (row,col) :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForDate.matcher(sheet.getCell(projStartDatePos, i).getContents().trim()).find())
					{  		
						log.error("The Project Start Date at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project Start Date at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
					} 
					if(sheet.getCell(projStartDatePos, i).getContents().trim()!=""){ 
						  
					    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
						try {    	
							simpleDateFormat.setLenient(false);
							Date projStartDate = simpleDateFormat.parse(sheet.getCell(projStartDatePos, i).getContents().trim());
							projectXLSVO.setProjStartDate(projStartDate); 
							log.info("projStartDate :: "+projStartDate);
						}catch (ParseException e) {
							log.error("The Project Start Date at (row,col) does not have a valid date. Please provide a Correct date  :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
							throw new BulkUploadException("The Project Start Date at (row,col) does not have a valid date. Please provide a Correct date :: "+"("+(i+1)+","+(char)(projStartDatePos+initialColumnIndexInAlphabet)+")");
						}
					 }
				   	//PROJ_END_DATE
					if(sheet.getCell(projEndDatePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project End Date at (row,col) :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project End Date at (row,col) :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForDate.matcher(sheet.getCell(projEndDatePos, i).getContents().trim()).find())
					{  		
						log.error("The Project End Date at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Project End Date at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
					} 
				    if(sheet.getCell(projEndDatePos, i).getContents().trim()!=""){ 
					    
					    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    					try {    	
    						simpleDateFormat.setLenient(false);
    						Date projEndDate = simpleDateFormat.parse(sheet.getCell(projEndDatePos, i).getContents().trim());
    						projectXLSVO.setProjEndDate(projEndDate);  
    						log.info("projEndDate :: "+projEndDate);
    					}catch (ParseException e) {
    						log.error("The Project End Date at (row,col) does not have a valid date. Please provide a Correct date :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
    						throw new BulkUploadException("The Project End Date at (row,col) does not have a valid date. Please provide a Correct date :: "+"("+(i+1)+","+(char)(projEndDatePos+initialColumnIndexInAlphabet)+")");
    					}
				    }
					
				    //PROJ_AWARD_WON
				    if(sheet.getCell(projAwardWonPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Project Award Won at (row,col) :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Award Won at (row,col) :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
					}
				    if(sheet.getCell(projAwardWonPos, i).getContents().trim().length() > 1)
					{  	
				    	log.error("The Project Award Won at (row,col) cannot be more than 1 chars long :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
				    	throw new BulkUploadException("The Project Award Won at (row,col) cannot be more than 1 chars long :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
					}
				    if(sheet.getCell(projAwardWonPos, i).getContents().trim().equalsIgnoreCase("Y") || sheet.getCell(projAwardWonPos, i).getContents().trim().equalsIgnoreCase("N"))
					{  	
				    	projectXLSVO.setProjAwardWon(sheet.getCell(projAwardWonPos, i).getContents().trim().toUpperCase());
					}
					else
					{
						log.error("Please provide Project Award Won at (row,col) as either Y or N :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Project Award Won at (row,col) as either Y or N :: "+"("+(i+1)+","+(char)(projAwardWonPos+initialColumnIndexInAlphabet)+")");
					}
				    //PROJ_AWARD_DESC
				    if(sheet.getCell(projAwardDescPos, i).getContents().trim().length() > 200)
					{  	
				    	log.error("The Project Award Desc at (row,col) cannot be more than 200 chars long :: "+"("+(i+1)+","+(char)(projAwardDescPos+initialColumnIndexInAlphabet)+")");
				    	throw new BulkUploadException("The Project Award Desc at (row,col) cannot be more than 200 chars long :: "+"("+(i+1)+","+(char)(projAwardDescPos+initialColumnIndexInAlphabet)+")");
					}
				    if(sheet.getCell(projAwardDescPos, i).getContents().trim()!="")
					{    
					     projectXLSVO.setProjAwardDesc(sheet.getCell(projAwardDescPos, i).getContents().trim());  
					}
				    
				    //FNAME
					if(sheet.getCell(fnamePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student First Name at (row,col) :: "+"("+(i+1)+","+(char)(fnamePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student First Name at (row,col) :: "+"("+(i+1)+","+(char)(fnamePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(fnamePos, i).getContents().trim().length() > 45)
					{  	
						log.error("The Student First Name at (row,col) cannot be more than 45 chars long :: "+"("+(i+1)+","+(char)(fnamePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student First Name at (row,col) cannot be more than 45 chars long :: "+"("+(i+1)+","+(char)(fnamePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(fnamePos, i).getContents().trim()!="")
					{   
						projectXLSVO.setFirstName(sheet.getCell(fnamePos, i).getContents().trim());
					}
					
					//MNAME
					if(sheet.getCell(mnamePos, i).getContents().trim().length() > 100)
					{  	
						log.error("The Student Middle Name at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(mnamePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Middle Name at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(mnamePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(mnamePos, i).getContents().trim()!="")
					{   
						projectXLSVO.setMidName(sheet.getCell(mnamePos, i).getContents().trim());
					}
					
					//LNAME
					if(sheet.getCell(lnamePos, i).getContents().trim().length() > 100)
					{  	
						log.error("The Student Last Name at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(lnamePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Last Name at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(lnamePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(lnamePos, i).getContents().trim()!="")
					{   
						projectXLSVO.setLastName(sheet.getCell(lnamePos, i).getContents().trim());
					}
					
					//EMAIL_ID
					if(sheet.getCell(emailIdPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Email Id at (row,col) :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Email Id at (row,col) :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(emailIdPos, i).getContents().trim().length() > 100)
					{  	
						log.error("The Student Email Id at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Email Id at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForEmail.matcher(sheet.getCell(emailIdPos, i).getContents().trim()).find())
					{  		
						log.error("The Student Email Id (row,col) does not have a valid Email Id  :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Email Id at (row,col) does not have a valid Email Id  :: "+"("+(i+1)+","+(char)(emailIdPos+initialColumnIndexInAlphabet)+")");
					} 
					if(sheet.getCell(emailIdPos, i).getContents().trim()!="")
					{   
						projectXLSVO.setEmail(sheet.getCell(emailIdPos, i).getContents().trim());
					}
					
					//MOBILE_NO
					if(sheet.getCell(mobileNoPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Mobile No at (row,col) :: "+"("+(i+1)+","+(char)(mobileNoPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Mobile No at (row,col) :: "+"("+(i+1)+","+(char)(mobileNoPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(mobileNoPos, i).getContents().trim().length() > 15)
					{  	
						log.error("The Student Mobile No at (row,col) cannot be more than 15 digits long :: "+"("+(i+1)+","+(char)(mobileNoPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Mobile No at (row,col) cannot be more than 15 digits long :: "+"("+(i+1)+","+(char)(mobileNoPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(mobileNoPos, i).getContents().trim()!="")
					{   
						projectXLSVO.setContactNo(Long.parseLong(sheet.getCell(mobileNoPos, i).getContents().trim()));
					}
					
					//BRANCH_ID
					String branchIdWithName = sheet.getCell(branchIdPos, i).getContents().trim();
					if(sheet.getCell(branchIdPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Branch Id at (row,col) :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Branch Id at (row,col) :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
					}
					String[] branchId = branchIdWithName.split("\\.");
					if(branchId[0].length() > 3)
					{  		
						log.error("The Student Branch Id at (row,col) cannot be more than 3 digits :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Branch Id at (row,col) cannot be more than 3 digits :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForNumber.matcher(branchId[0]).find())
					{  		
						log.error("The Student Branch Id at (row,col) is not valid  :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Branch Id at (row,col) is not valid :: "+"("+(i+1)+","+(char)(branchIdPos+initialColumnIndexInAlphabet)+")");
					} 
					if(branchId[0]!="")
					{
						log.info("Branch Id :: " +branchId[0]);
						projectXLSVO.setBranchId(Integer.parseInt(branchId[0]));
					}
					
					//DEGREE
					if(sheet.getCell(degreePos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Degree at (row,col) :: "+"("+(i+1)+","+(char)(degreePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Degree at (row,col) :: "+"("+(i+1)+","+(char)(degreePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(degreePos, i).getContents().trim().length() > 100)
					{  	
						log.error("The Student Degree at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(degreePos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Degree at (row,col) cannot be more than 100 chars long :: "+"("+(i+1)+","+(char)(degreePos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(degreePos, i).getContents().trim()!="")
					{   
						projectXLSVO.setDegree(sheet.getCell(degreePos, i).getContents().trim());
					}
					
					//YEAR_OF_PASS
					if(sheet.getCell(yearOfPassPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Year Of Passing at (row,col) :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Year Of Passing at (row,col) :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
					}
					if(!regexForDate.matcher(sheet.getCell(yearOfPassPos, i).getContents().trim()).find())
					{  		
						log.error("The Student Year Of Passing at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Year Of Passing at (row,col) does not have a valid format. Correct format (dd/MM/yyyy)  :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
					} 
				    if(sheet.getCell(yearOfPassPos, i).getContents().trim()!=""){ 
					    
					    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    					try {    	
    						simpleDateFormat.setLenient(false);
    						Date yearOfPassDate = simpleDateFormat.parse(sheet.getCell(yearOfPassPos, i).getContents().trim());
    						projectXLSVO.setYearOfPass(yearOfPassDate);  
    						log.info("yearOfPassDate :: "+yearOfPassDate);
    					}catch (ParseException e) {
    						log.error("The Student Year Of Passing at (row,col) does not have a valid date. Please provide a Correct date :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
    						throw new BulkUploadException("The Student Year Of Passing at (row,col) does not have a valid date. Please provide a Correct date :: "+"("+(i+1)+","+(char)(yearOfPassPos+initialColumnIndexInAlphabet)+")");
    					}
				    }
				    
				    //ENROLLMENT_NO
					if(sheet.getCell(enrollmentNoPos, i).getContents().trim()=="")
					{ 		
						log.error("Please provide Student Enrollment No at (row,col) :: "+"("+(i+1)+","+(char)(enrollmentNoPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("Please provide Student Enrollment No at (row,col) :: "+"("+(i+1)+","+(char)(enrollmentNoPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(enrollmentNoPos, i).getContents().trim().length() > 20)
					{  	
						log.error("The Student Enrollment No at (row,col) cannot be more than 20 digits long :: "+"("+(i+1)+","+(char)(enrollmentNoPos+initialColumnIndexInAlphabet)+")");
						throw new BulkUploadException("The Student Enrollment No at (row,col) cannot be more than 20 digits long :: "+"("+(i+1)+","+(char)(enrollmentNoPos+initialColumnIndexInAlphabet)+")");
					}
					if(sheet.getCell(enrollmentNoPos, i).getContents().trim()!="")
					{   
						projectXLSVO.setEnrollmentNo(sheet.getCell(enrollmentNoPos, i).getContents().trim());
					}
					projectXLSVOs.add(projectXLSVO);
				}
			return projectXLSVOs;
		} catch (Exception e) {
			log.error("Error while project bulk uploading Ex :: ", e);
			throw new BulkUploadException("Error while project bulk uploading : "+ e.getMessage());
		}
		
	}
}