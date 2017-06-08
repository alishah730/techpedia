package com.ge.techpedia.service.helper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.ge.techpedia.service.response.ProjectServiceResponse;
import com.google.gson.Gson;
import com.techpedia.projectmanagement.dao.ProjectDao;
import com.techpedia.projectmanagement.exception.BulkUploadException;

@Service
public class BulkUploadServiceHelper {
	
	@Autowired
	@Qualifier("projectDao")
	ProjectDao projectDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BulkUploadServiceHelper.class.getName());
	
	public String bulkUploadProject(String fileName) throws BulkUploadException{
		
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			LOGGER.info("Calling the bulkUploadProject method in projectDao : start");
			result = projectDao.bulkUploadProjectAsXLS(fileName);
			LOGGER.info("Calling the bulkUploadProject method in projectDao : end");
			LOGGER.info("Result :: "+result);
			
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_FAILURE);
				response.setExceptionMessage(result);
				return gson.toJson(response);
			}
		} catch (Exception e) {			
			LOGGER.error("An unexpected error occured while bulkUploadProject Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_FAILURE);
			response.setExceptionMessage(e.getMessage());
			return gson.toJson(response);
		}		
	}
}
