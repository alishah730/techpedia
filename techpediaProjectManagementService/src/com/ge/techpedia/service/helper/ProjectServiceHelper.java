package com.ge.techpedia.service.helper;

import java.util.ArrayList;

import com.ge.techpedia.bean.AddCommVO;
import com.ge.techpedia.bean.Branch;
import com.ge.techpedia.bean.DeleteCommVO;
import com.ge.techpedia.bean.DeleteDocVO;
import com.ge.techpedia.bean.DisplayTeamCommVO;
import com.ge.techpedia.bean.DownloadDocVO;
import com.ge.techpedia.bean.FacInitProjVO;
import com.ge.techpedia.bean.Faculty;
import com.ge.techpedia.bean.FacultyVO;
import com.ge.techpedia.bean.FollowProjectVO;
import com.ge.techpedia.bean.MentorVO;
import com.ge.techpedia.bean.ProjFollowVO;
import com.ge.techpedia.bean.ProjSubmit;
import com.ge.techpedia.bean.Project;
import com.ge.techpedia.bean.ProjectDocument;
import com.ge.techpedia.bean.ProjectTeamComment;
import com.ge.techpedia.bean.ProjectTeamDetailVO;
import com.ge.techpedia.bean.SearchByKeyVO;
import com.ge.techpedia.bean.Team;
import com.ge.techpedia.bean.TeamMember;
import com.ge.techpedia.bean.UploadProjDocVO;
import com.ge.techpedia.bean.UserProfileVO;
import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.ge.techpedia.dao.ProjectDao;
import com.ge.techpedia.dao.impl.ProjectDaoImpl;
import com.ge.techpedia.exception.AddCommentException;
import com.ge.techpedia.exception.AddNewFacultyException;
import com.ge.techpedia.exception.AddNewMentorException;
import com.ge.techpedia.exception.AddTeamMembersException;
import com.ge.techpedia.exception.BulkUploadException;
import com.ge.techpedia.exception.CheckProjectFollowException;
import com.ge.techpedia.exception.CreateProjectException;
import com.ge.techpedia.exception.DeleteDocumentException;
import com.ge.techpedia.exception.DeleteProjectException;
import com.ge.techpedia.exception.DownloadProjDocException;
import com.ge.techpedia.exception.FacultyClosedProjectException;
import com.ge.techpedia.exception.FacultyInitiatedProjectException;
import com.ge.techpedia.exception.FollowTheProjectException;
import com.ge.techpedia.exception.GetAllFollowedProjectException;
import com.ge.techpedia.exception.GetAllMentorsException;
import com.ge.techpedia.exception.GetAllProjectException;
import com.ge.techpedia.exception.GetDetailOfTeamException;
import com.ge.techpedia.exception.GetPopularityException;
import com.ge.techpedia.exception.GetProjectDetailsException;
import com.ge.techpedia.exception.GetProjectFollowersException;
import com.ge.techpedia.exception.OtherCommentsNotFoundException;
import com.ge.techpedia.exception.ProjectByLoggedInUserException;
import com.ge.techpedia.exception.RemoveCommentException;
import com.ge.techpedia.exception.RemoveMentorException;
import com.ge.techpedia.exception.RemoveProjectFollowException;
import com.ge.techpedia.exception.RemoveTeamMembersException;
import com.ge.techpedia.exception.SearchProjectException;
import com.ge.techpedia.exception.SubmitProjectsException;
import com.ge.techpedia.exception.SuggestedBranchNotFoundException;
import com.ge.techpedia.exception.SuggestedFacultyNotFoundException;
import com.ge.techpedia.exception.SuggestedTeamMembersNotFoundException;
import com.ge.techpedia.exception.SuggestedkeywordsNotFoundException;
import com.ge.techpedia.exception.TeamCommentsNotFoundException;
import com.ge.techpedia.exception.UpdateProjectException;
import com.ge.techpedia.exception.UploadProjDocException;
import com.ge.techpedia.service.response.ProjectServiceResponse;
import com.google.gson.Gson;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.logger.TechPediaLogger;


public class ProjectServiceHelper {

	private static TechPediaLogger log = TechPediaLogger.getLogger(ProjectServiceHelper.class.getName());
	
	static ProjectDao projectDao = null;
	static ProjectServiceResponse response = null;
	static Gson gson = null;
	
	/**
	 * @param project
	 * @return result flag
	 */
	public static String createProject(Project project) throws CreateProjectException{

		//log.debug("ProjectServiceHelper.createProject:Start");
		response = new ProjectServiceResponse();
		String returnVal = null;		
		try {
			returnVal = getProjectDao().createProject(project);
			
			if(returnVal == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (CreateProjectException e) {
			throw e;
		}		
	}

	/**
	 * @param branchIds
	 * @return list of suggested keyword
	 */
	public static String getSuggestedkeywords(ArrayList<String> branchIds) throws NumberFormatException, SuggestedkeywordsNotFoundException{
		
		ArrayList<Integer> branches = null;
		ArrayList<String> suggestedKeywords = null;		
		try {
			branches = new ArrayList<Integer>(branchIds.size()); 
			for (String branchId : branchIds) { 
				branches.add(Integer.valueOf(branchId)); 
			}
			suggestedKeywords = getProjectDao().getSuggestedkeywords(branches);
			if(suggestedKeywords != null){
				gson = new Gson();
				return gson.toJson(suggestedKeywords);
			}
		} catch (NumberFormatException e) {
			throw e;
		} catch (SuggestedkeywordsNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;			
	}
	
	/**
	 * @param userProfileVO
	 * @return list of suggested team
	 */
	public static String getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException{
		ArrayList<Team> teams = null;		
		try {
			teams = getProjectDao().getSuggestedTeamMembers(userProfileVO);
			if(teams != null){
				gson = new Gson();
				return gson.toJson(teams);
			}
		} catch (SuggestedTeamMembersNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param term
	 * @return list of suggested branch
	 */
	public static String getSuggestedBranches(String term) throws SuggestedBranchNotFoundException{		
		ArrayList<Branch> branches = null;		
		try {
			branches = getProjectDao().getSuggestedBranches(term);
			if(branches != null){
				gson = new Gson();
				return gson.toJson(branches);
			}
		} catch (SuggestedBranchNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param userId
	 * @return list of suggested faculty
	 */
	public static String getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException{
		ArrayList<Faculty> faculties = null;		
		try {
			faculties = getProjectDao().getSuggestedFaculty(userId);
			if(faculties != null){
				gson = new Gson();
				return gson.toJson(faculties);
			}
		} catch (SuggestedFacultyNotFoundException e) {
			e.printStackTrace();
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param facultyVO
	 * @return result flag
	 */
	public static String addNewFaculty(FacultyVO facultyVO){
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().addNewFaculty(facultyVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddNewFacultyException e) {
			e.printStackTrace();
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param projId
	 * @return result flag
	 */
	public static String deleteProject(long projId) throws DeleteProjectException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().deleteProject(projId);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DELETE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DELETE_FAILURE);
				return gson.toJson(response);
			}
		} catch (DeleteProjectException e) {
			throw e;
		}		
	}
	
	/**
	 * @param projId
	 * @return Project
	 */
	public static String getProjectDetails(long projId) throws GetProjectDetailsException{
		Project project = null;
		try {
			project = getProjectDao().getProjectDetails(projId);
			if(project != null){
				gson = new Gson();
				return gson.toJson(project);
			}
		} catch (GetProjectDetailsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param iterationCount
	 * @return ArrayList<Project>
	 */
	public static String getAllProject(String iterationCount) throws GetAllProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = getProjectDao().getAllProject(iterationCount);
			if(projects != null){
				gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param iterationCount
	 * @return
	 */
	public static String getAllMentors(String iterationCount) throws GetAllMentorsException{
		ArrayList<UserProfileVO> userProfileVOs = null;
		log.debug("ProjectServiceHelper.getAllMentors:Start");
		try {
			userProfileVOs = getProjectDao().getAllMentors(iterationCount);
			if(userProfileVOs != null){
				gson = new Gson();
				return gson.toJson(userProfileVOs);
			}
		} catch (GetAllMentorsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	public static String getPopularity(String rgstrId) throws GetPopularityException{
		String popularity = null;
		try {
			popularity = getProjectDao().getPopularity(rgstrId);
			if(popularity != null){
				gson = new Gson();
				return gson.toJson(popularity);
			}
		} catch (GetPopularityException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param project
	 * @return
	 */
	public static String updateProject(Project project) throws UpdateProjectException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().updateProject(project);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPDATE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPDATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (UpdateProjectException e) {
			throw e;
		}		
	}
	
	/**
	 * @param teamMembers
	 * @return
	 */
	public static String addTeamMembers(ArrayList<TeamMember> teamMembers) throws AddTeamMembersException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().addTeamMembers(teamMembers);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_ADD_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddTeamMembersException e) {
			throw e;
		}		
	}
	
	/**
	 * @param teamMembers
	 * @return
	 */
	public static String removeTeamMembers(ArrayList<TeamMember> teamMembers) throws RemoveTeamMembersException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().removeTeamMembers(teamMembers);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_REMOVE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_REMOVE_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveTeamMembersException e) {
			throw e;
		}		
	}
	
	/**
	 * @param term
	 * @param iterationCount
	 * @return
	 */
	public static String searchProjectByKeyword(SearchByKeyVO searchByKeyVO) throws SearchProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = getProjectDao().searchProjectByKeyword(searchByKeyVO);
			if(projects != null){
				gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (SearchProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param projId
	 * @param mentorRgstrId
	 * @return
	 */
	public static String addNewMentor(MentorVO mentorVO) throws AddNewMentorException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().addNewMentor(mentorVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_ADD_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddNewMentorException e) {
			throw e;
		}		
	}
	
	/**
	 * @param projId
	 * @param mentorRgstrId
	 * @return
	 */
	public static String deleteMentor(MentorVO mentorVO) throws RemoveMentorException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().deleteMentor(mentorVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_REMOVE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_REMOVE_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveMentorException e) {
			throw e;
		}		
	}
	
	/**
	 * @param projId
	 * @param userRgstrNo
	 * @return
	 */
	public static String followTheProject(FollowProjectVO followProjectVO) throws FollowTheProjectException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().followTheProject(followProjectVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FOLLOW_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FollowTheProjectException e) {
			throw e;
		}		
	}
	
	/**
	 * @param projId
	 * @return
	 */
	public static String displayTeamComments(DisplayTeamCommVO displayTeamCommVO) throws TeamCommentsNotFoundException{
		 ArrayList<ProjectTeamComment> comments = null;
		try {
			comments = getProjectDao().displayTeamComments(displayTeamCommVO);
			if(comments != null){
				gson = new Gson();
				return gson.toJson(comments);
			}
		} catch (TeamCommentsNotFoundException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	/**
	 * @param projId
	 * @param regstrId
	 * @param projComment
	 * @return
	 */
	public static String addComment(AddCommVO addCommVO) throws AddCommentException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().addComment(addCommVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.COMMENT_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.COMMENT_ADD_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddCommentException e) {
			throw e;
		}		
	}

	/**
	 * @param projectId
	 * @param commentId
	 * @param rgstrId
	 * @return
	 */
	public static String deleteComment(DeleteCommVO deleteCommVO) throws RemoveCommentException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().deleteComment(deleteCommVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_COMMENT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.DELETE_COMMENT_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveCommentException e) {
			throw e;
		}		
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */	
	public static String getAllFollowedProject(String rgstrId) throws GetAllFollowedProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = getProjectDao().getAllFollowedProject(rgstrId);
			if(projects != null){
				gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllFollowedProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param teamId
	 * @return
	 */
	public static String getDetailOfTeam(String teamId) throws GetDetailOfTeamException{
		ArrayList<ProjectTeamDetailVO> teamDetailVOs = null;
		try {
			teamDetailVOs = getProjectDao().getDetailOfTeam(teamId);
			if(teamDetailVOs != null){
				gson = new Gson();
				return gson.toJson(teamDetailVOs);
			}
		} catch (GetDetailOfTeamException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param projFollowVO
	 * @return
	 */
	public static String removeProjectFollow(ProjFollowVO projFollowVO) throws RemoveProjectFollowException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().removeProjectFollow(projFollowVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.DELETE_FOLLOW_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (RemoveProjectFollowException e) {			
			throw e;
		}
	}
	
	/**
	 * @param projFollowVO
	 * @return
	 */
	public static String checkProjectFollow(ProjFollowVO projFollowVO) throws CheckProjectFollowException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().checkProjectFollow(projFollowVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHECK_FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.CHECK_FOLLOW_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (CheckProjectFollowException e) {			
			throw e;
		}
	}
	
	/**
	 * @param projSubmit
	 * @return
	 * @throws SubmitProjectsException
	 * @throws EmailServiceException
	 */
	public static String submitProject(ProjSubmit projSubmit) throws SubmitProjectsException, EmailServiceException{		
		Project project = new Project();
		String result = "N";
		response = new ProjectServiceResponse();
		try {
			project = getProjectDao().submitProject(projSubmit);
			if(project.getProjTitle() != ""){
				ProjectManagementEMailHelper.sendEmail(project);
				result = "Y";
				if(result == "Y"){				
					gson = new Gson();
					response.setStatus(ProjectManagementServiceConstant.SUCCESS);
					response.setDescription(ProjectManagementServiceConstant.PROJECT_SUBMITION_SUCCESS);
					return gson.toJson(response);
				}else{
					gson = new Gson();
					response.setStatus(ProjectManagementServiceConstant.FAILURE);
					response.setDescription(ProjectManagementServiceConstant.PROJECT_SUBMITION_FAILURE);
					return gson.toJson(response);
				}
			}
		} catch (SubmitProjectsException e) {			
			throw e;
		}
		return result;
	}
	
	/**
	 * @param uploadProjDocVO
	 * @return
	 */
	public static String uploadProjectDocument(UploadProjDocVO uploadProjDocVO) throws UploadProjDocException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().uploadProjectDocument(uploadProjDocVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_UPLOAD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_UPLOAD_FAILURE);
				return gson.toJson(response);
			}
		} catch (UploadProjDocException e) {			
			throw e;
		}		
	}
	
	/**
	 * @param downloadDocVO
	 * @return
	 */
	public static String downloadProjectDocument(DownloadDocVO downloadDocVO) throws DownloadProjDocException{
		ArrayList<ProjectDocument> projectDocuments = null;
		try {
			projectDocuments = getProjectDao().downloadProjectDocument(downloadDocVO);
			if(projectDocuments != null){
				gson = new Gson();
				return gson.toJson(projectDocuments);
			}
		} catch (DownloadProjDocException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param displayTeamCommVO
	 * @return
	 */
	public static String displayOtherComments(DisplayTeamCommVO displayTeamCommVO) throws OtherCommentsNotFoundException{
		ArrayList<ProjectTeamComment> projectTeamComments = null;
		try {
			projectTeamComments = getProjectDao().displayOtherComments(displayTeamCommVO);
			if(projectTeamComments != null){
				gson = new Gson();
				return gson.toJson(projectTeamComments);
			}
		} catch (OtherCommentsNotFoundException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	public static String getProjectsByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			projects = getProjectDao().getProjectsByLoggedInUser(rgstrId);
			if(projects != null){
				gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (ProjectByLoggedInUserException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @param exlByteArray
	 * @return
	 */
	public static String bulkUploadProject(String exlByteArray) throws BulkUploadException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().bulkUploadProject(exlByteArray);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_FAILURE);
				return gson.toJson(response);
			}
		} catch (BulkUploadException e) {			
			throw e;
		}		
	}
	
	public static String getProjectFollowers() throws GetProjectFollowersException{
		ArrayList<Project> projects = null;
		try {
			projects = getProjectDao().getProjectFollowers();
			if(projects != null){
				gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetProjectFollowersException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public static String deleteProjectDocument(DeleteDocVO deleteDocVO) throws DeleteDocumentException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().deleteProjectDocument(deleteDocVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_DELETE_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_DELETE_FAILURE);
				return gson.toJson(response);
			}
		} catch (DeleteDocumentException e) {			
			throw e;
		}		
	}
	
	public static String facultyInitiatedProject(FacInitProjVO facInitProjVO) throws FacultyInitiatedProjectException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().facultyInitiatedProject(facInitProjVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_INITIATED_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_INITIATED_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyInitiatedProjectException e) {			
			throw e;
		}		
	}
	
	public static String facultyClosedProject(FacInitProjVO facInitProjVO) throws FacultyClosedProjectException{
		String result = null;
		response = new ProjectServiceResponse();
		try {
			result = getProjectDao().facultyClosedProject(facInitProjVO);
			if(result == "Y"){				
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CLOSED_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CLOSED_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyClosedProjectException e) {			
			throw e;
		}		
	}
	
	/**
	 * @return ProjectDao
	 */
	private static ProjectDao getProjectDao() {
		
		if (projectDao == null) {
			projectDao = new ProjectDaoImpl();
		}
		return projectDao;
	}

}
