package com.techpedia.projectmanagement.util;

import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;

import com.techpedia.projectmanagement.bean.ProjectXLSVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.dao.ProjectDao;
import com.techpedia.projectmanagement.dao.impl.ProjectDaoImpl;
import com.techpedia.projectmanagement.exception.BulkUploadException;

public class BulkUploadCVS {
	InputStream input = null;
	int projectStatusId = 3;
	String projectTofloat = "Y";
	String projCmntsPubl = "N";
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<Integer> projectBranches = new ArrayList<Integer>();
	ArrayList<String> projectKeywords = new ArrayList<String>();
	ProjectDao projectDao = new ProjectDaoImpl();	
	ArrayList<ProjectXLSVO> projectXLSVOs = new ArrayList<ProjectXLSVO>();
	ProjectXLSVO projectXLSVO;
	UserProfileVO userprofilevo = new UserProfileVO();

	Workbook workbook;
	int uniPos = 0;
	int collRegIdPos = 1;
	int collStatPos = 2;
	int projTypeIdPos = 3;
	int fstNmOfStudPos = 4;
	int midNmOfStudPos = 5;
	int lstNmOfStudPos = 6;
	int eMailOfStudPos = 7;
	int contNoOfStuPos = 8;
	int ProjTitlePos = 9;
	int projAbtrPos = 10;
	int projExtAbstrPos = 11;
	int projYearPos = 12;
	int projStartDatePos = 13;
	int ProjEndDatePos = 14;
	int projBranchId1Pos = 15;
	int projBranchId2Pos = 16;
	int projBranchId3Pos = 17;
	int projBranchId4Pos = 18;
	int projBranchId5Pos = 19;
	int keywordsBranch1Pos = 20;
	int keywordsBranch2Pos = 21;
	int keywordsBranch3Pos = 22;
	int keywordsBranch4Pos = 23;
	int keywordsBranch5Pos = 24;
	int projGuidNamePos = 25;
	int eMailOfFacPos = 26;
	int projMentorNamePos = 27;
	int projStatusIdPos = 28;
	int projToFloatPos = 29;
	int projCommentsPubPos = 30;
	int projGradePos = 31;
	int projAwardWonPos = 32;
	int projAwardDescPos = 33;

	public ArrayList<ProjectXLSVO> readCSV(File inputWorkbook) throws BulkUploadException {

		try {
			projectXLSVO = new ProjectXLSVO(); 			
			workbook = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = workbook.getSheet(0);
           
			for (int i = 1; i < sheet.getRows(); i++) {				
					if(sheet.getCell(uniPos, i).getContents().trim()=="")
					{  							
						throw new BulkUploadException("Error while project bulk uploading: Please provide University Name at row no:"+i);						
					} 
					else{
						projectXLSVO.setProjUniversity(sheet.getCell(uniPos, i).getContents().trim());
					}
					
					if(sheet.getCell(collRegIdPos, i).getContents().trim()!="")
					{  
					     projectXLSVO.setProjCollegeRgstrIdUsr(sheet.getCell(collRegIdPos, i).getContents().trim());
					}
					
					if(sheet.getCell(collStatPos, i).getContents().trim()=="")
					{ 						  
						  throw new BulkUploadException("Error while project bulk uploading: Please provide College State at row no:"+i);
					}
					else
					{
						projectXLSVO.setProjCollegeState(sheet.getCell(collStatPos, i).getContents().trim());
					}
					
					if(sheet.getCell(projTypeIdPos, i).getContents().trim()!="")
					{  					    
					    projectXLSVO.setProjTypeId(Integer.parseInt(sheet.getCell(projTypeIdPos, i).getContents().trim()));
					}
					
				    if(sheet.getCell(fstNmOfStudPos, i).getContents().trim()=="")
				    { 					   				    
				    	throw new BulkUploadException("Error while project bulk uploading: Please provide First name of student at row no:"+i);
				    }
					else
					{
						projectXLSVO.setFirstName(sheet.getCell(fstNmOfStudPos, i).getContents().trim());
				    }  
				    
				   if(sheet.getCell(midNmOfStudPos, i).getContents().trim()!=""){ 
					    
					    projectXLSVO.setMidName(sheet.getCell(midNmOfStudPos, i).getContents().trim());
					}
				   
				   if(sheet.getCell(lstNmOfStudPos, i).getContents().trim()=="")
				   { 					    										   
					   throw new BulkUploadException("Error while project bulk uploading: Please provide Last name of student at row no:"+i);
				   }
				   else{
					   projectXLSVO.setLastName(sheet.getCell(lstNmOfStudPos, i).getContents().trim());
				   }
				   
				   if(sheet.getCell(eMailOfStudPos, i).getContents().trim()=="")
				   {  					   					   
					   throw new BulkUploadException("Error while project bulk uploading: Please provide Email-id of student at row no:"+i);
				   }
				   else{
					    projectXLSVO.setEmail(sheet.getCell(eMailOfStudPos, i).getContents().trim());
				   }
				   
				   if(sheet.getCell(contNoOfStuPos, i).getContents().trim()!=""){ 
					     
					    projectXLSVO.setContactNo(Long.valueOf(sheet.getCell(contNoOfStuPos, i).getContents().trim()));					     
				   }
				   
				   if(sheet.getCell(ProjTitlePos, i).getContents().trim()=="")
				   { 					    										   
					   throw new BulkUploadException("Error while project bulk uploading: Please provide Project Title at row no:"+i);
				   }
				   else{
					   projectXLSVO.setProjTitle(sheet.getCell(ProjTitlePos, i).getContents().trim());
				   }
				   
				   if(sheet.getCell(projAbtrPos, i).getContents().trim()=="")
				   { 					    										   
					   throw new BulkUploadException("Error while project bulk uploading: Please provide Project Abstract at row no:"+i);
				   }
				   else{
					   projectXLSVO.setProjAbstract(sheet.getCell(projAbtrPos, i).getContents().trim());
				   }
				   
				   if(sheet.getCell(projExtAbstrPos, i).getContents().trim()!=""){ 
					     
					    projectXLSVO.setProjDescription(sheet.getCell(projExtAbstrPos, i).getContents().trim());					     
				   }
				   
				   if(sheet.getCell(projYearPos, i).getContents().trim()=="")
				   { 					    										   
					   throw new BulkUploadException("Error while project bulk uploading: Please provide Project Year at row no:"+i);
				   }
				   else{
					   projectXLSVO.setProjYear(Integer.valueOf(sheet.getCell(projYearPos, i).getContents().trim()));
				   }
				   
				   if(sheet.getCell(projStartDatePos, i).getContents().trim()!=""){ 
					  
					    SimpleDateFormat ProjEndDate = new SimpleDateFormat("dd/MM/yyyy");
    					try {    		
    						Date date = ProjEndDate.parse(sheet.getCell(projStartDatePos, i).getContents().trim());
    						projectXLSVO.setProjStartDate(date);    				
    					}catch (ParseException e) {
    						e.printStackTrace();
    					}
				    }
				   
				    if(sheet.getCell(ProjEndDatePos, i).getContents().trim()!=""){ 
					    
					    SimpleDateFormat ProjEndDate = new SimpleDateFormat("dd/MM/yyyy");
    					try {    						
    						Date date = ProjEndDate.parse(sheet.getCell(ProjEndDatePos, i).getContents().trim());
    						projectXLSVO.setProjEndDate(date);    						
    					}catch (ParseException e) {
    						e.printStackTrace();
    					}
				    }
				    
				    if(sheet.getCell(projBranchId1Pos, i).getContents().trim()=="")
					{  					   						  
						  throw new BulkUploadException("Error while project bulk uploading: Please provide Project Branch1 id(Main Branch) at row no:"+i);					 
					}
					else{
						 projectBranches.add(Integer.parseInt(sheet.getCell(projBranchId1Pos, i).getContents().trim()));					    
					}
				    
				    if(sheet.getCell(projBranchId2Pos, i).getContents().trim()!="")
					{ 
						 projectBranches.add(Integer.parseInt(sheet.getCell(projBranchId2Pos, i).getContents().trim()));					     
					}
				    if(sheet.getCell(projBranchId3Pos, i).getContents().trim()!="")
					{ 
						 projectBranches.add(Integer.parseInt(sheet.getCell(projBranchId3Pos, i).getContents().trim()));					     
					}
				    if(sheet.getCell(projBranchId4Pos, i).getContents().trim()!="")
					{ 
						 projectBranches.add(Integer.parseInt(sheet.getCell(projBranchId4Pos, i).getContents().trim()));					     
					}
				    if(sheet.getCell(projBranchId5Pos, i).getContents().trim()!="")
					{  
						 projectBranches.add(Integer.parseInt(sheet.getCell(projBranchId5Pos, i).getContents().trim()));					     
					}
				    projectXLSVO.setProjBranches(projectBranches);
				    
				    if(sheet.getCell(keywordsBranch1Pos, i).getContents().trim()!="")
					{  
					    projectKeywords.add(sheet.getCell(keywordsBranch1Pos, i).getContents().trim());					    
					}
				    if(sheet.getCell(keywordsBranch2Pos, i).getContents().trim()!="")
					{   
					   projectKeywords.add(sheet.getCell(keywordsBranch2Pos, i).getContents().trim());;					     
					}
				    if(sheet.getCell(projBranchId3Pos, i).getContents().trim()!="")
					{    
					   projectKeywords.add(sheet.getCell(keywordsBranch3Pos, i).getContents().trim());;					     
					}
				    if(sheet.getCell(keywordsBranch4Pos, i).getContents().trim()!="")
					{    
					   projectKeywords.add(sheet.getCell(keywordsBranch4Pos, i).getContents().trim());;					    
					}
				    if(sheet.getCell(keywordsBranch5Pos, i).getContents().trim()!="")
					{    
					   projectKeywords.add(sheet.getCell(keywordsBranch5Pos, i).getContents().trim());;					   
					}
				    projectXLSVO.setProjKeywords(projectKeywords);
				    
				    if(sheet.getCell(projGuidNamePos, i).getContents().trim()=="")
					{  					    						  
						  throw new BulkUploadException("Error while project bulk uploading: Please provide Project Guide Name at row no:"+i);
					}
				    else{						 
					     projectXLSVO.setProjGuideId(Integer.parseInt(sheet.getCell(projGuidNamePos, i).getContents().trim()));
					}
				    
				    if(sheet.getCell(eMailOfFacPos, i).getContents().trim()=="")
					{  					    						  
						  throw new BulkUploadException("Error while project bulk uploading: Please provide Email-id of Faculty at row no:"+i);
					}
					else{
					     projectXLSVO.setFacEmail(sheet.getCell(eMailOfFacPos, i).getContents().trim());
					}
				    
				    if(sheet.getCell(projMentorNamePos,i).getContents().trim()!="")
					{   
					   projectXLSVO.setProjMentor1Id(Integer.parseInt(sheet.getCell(projMentorNamePos, i).getContents().trim()));
					}
				    
				    if(sheet.getCell(projStatusIdPos, i).getContents().trim()=="")
					{     					     
				    	projectXLSVO.setProjStatusId(projectStatusId);
					}
					else{
					   projectXLSVO.setProjStatusId(Integer.parseInt(sheet.getCell(projStatusIdPos, i).getContents().trim()));  
					}
				    
				    if(sheet.getCell(projToFloatPos, i).getContents().trim()=="")
					{   					  
				    	projectXLSVO.setProjToFloat(projectTofloat);
					}
					else{
					   projectXLSVO.setProjToFloat(sheet.getCell(projToFloatPos, i).getContents().trim());  
					}
				    
				    if(sheet.getCell(projCommentsPubPos, i).getContents().trim()=="")
					{     					     
				    	projectXLSVO.setProjCommentsPublish(projCmntsPubl);
					}
					else{
					   projectXLSVO.setProjCommentsPublish(sheet.getCell(projCommentsPubPos, i).getContents().trim());  
					}
				    
				    if(sheet.getCell(projGradePos, i).getContents().trim()!="")
					{    
					     projectXLSVO.setProjGrade(sheet.getCell(projGradePos, i).getContents().trim());  
					}
				    
				    if(sheet.getCell(projAwardWonPos, i).getContents().trim()=="")
					{  					    				    	
				    	throw new BulkUploadException("Error while project bulk uploading: Please provide Project Award Won at row no:"+i);
					}
					else
					{
						projectXLSVO.setProjAwardWon(sheet.getCell(projAwardWonPos, i).getContents().trim());
					}
				    
				    if(sheet.getCell(projAwardDescPos, i).getContents().trim()!="")
					{    
					     projectXLSVO.setProjAwardDesc(sheet.getCell(projAwardDescPos, i).getContents().trim());  
					}				   							
					projectXLSVOs.add(projectXLSVO);
				}
			return projectXLSVOs;
		} catch (Exception e) {
			throw new BulkUploadException("Error while project bulk uploading : "+ e.getMessage());
		}
		
	}
}