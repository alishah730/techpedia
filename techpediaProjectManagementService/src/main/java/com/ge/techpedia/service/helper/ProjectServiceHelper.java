package com.ge.techpedia.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.techpedia.constant.ProjectManagementServiceConstant;
import com.ge.techpedia.service.response.ProjectServiceResponse;
import com.google.gson.Gson;
import com.techpedia.email.exception.EmailServiceException;
import com.techpedia.projectmanagement.bean.AddCommVO;
import com.techpedia.projectmanagement.bean.AddNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberResponseVO;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberVO;
import com.techpedia.projectmanagement.bean.ApproveOrDeclineMentorRequestResponse;
import com.techpedia.projectmanagement.bean.ApproveOrDeclineMentorRequestVO;
import com.techpedia.projectmanagement.bean.Branch;
import com.techpedia.projectmanagement.bean.CreateProjectResponseVO;
import com.techpedia.projectmanagement.bean.DeleteCommVO;
import com.techpedia.projectmanagement.bean.DeleteDocVO;
import com.techpedia.projectmanagement.bean.DisplayProjectMacroVO;
import com.techpedia.projectmanagement.bean.DisplayProjectsMacroBranchVO;
import com.techpedia.projectmanagement.bean.DisplayTeamCommVO;
import com.techpedia.projectmanagement.bean.DownloadDocVO;
import com.techpedia.projectmanagement.bean.FacInitProjVO;
import com.techpedia.projectmanagement.bean.FacRejectProjResponse;
import com.techpedia.projectmanagement.bean.FacRejectProjVO;
import com.techpedia.projectmanagement.bean.Faculty;
import com.techpedia.projectmanagement.bean.FacultyMarkedProjectAsCompletedResponse;
import com.techpedia.projectmanagement.bean.FacultyMarkedProjectAsCompletedVO;
import com.techpedia.projectmanagement.bean.FacultyVO;
import com.techpedia.projectmanagement.bean.FollowProjectVO;
import com.techpedia.projectmanagement.bean.GYTIProjectStatisticsVO;
import com.techpedia.projectmanagement.bean.GetAllGytiProjectByLoggedInReviewerResponse;
import com.techpedia.projectmanagement.bean.GetAllReviewsByLoggedInReviewerAndOthersResponse;
import com.techpedia.projectmanagement.bean.GetReviewRatingVO;
import com.techpedia.projectmanagement.bean.GytiProjectVO;
import com.techpedia.projectmanagement.bean.MentorVO;
import com.techpedia.projectmanagement.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.projectmanagement.bean.ProjFollowVO;
import com.techpedia.projectmanagement.bean.ProjSubmit;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.ProjectGytiAddInfo;
import com.techpedia.projectmanagement.bean.ProjectMacroBranch;
import com.techpedia.projectmanagement.bean.ProjectTeamComment;
import com.techpedia.projectmanagement.bean.ProjectTeamDetailVO;
import com.techpedia.projectmanagement.bean.ProjectType;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyVO;
import com.techpedia.projectmanagement.bean.ReplaceTeamLead;
import com.techpedia.projectmanagement.bean.RequestToBeMentorResponse;
import com.techpedia.projectmanagement.bean.RequestToBeMentorVO;
import com.techpedia.projectmanagement.bean.SaveProjectPhotoVO;
import com.techpedia.projectmanagement.bean.ResubmitProjectResponse;
import com.techpedia.projectmanagement.bean.ReviewRatingVO;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.SubmitGytiInnovationResponseVO;
import com.techpedia.projectmanagement.bean.SubmitInnovationToGytiVO;
import com.techpedia.projectmanagement.bean.SuggestReviewerVO;
import com.techpedia.projectmanagement.bean.SuggestedProjectForReviewByLoggedInReviewerVO;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.TeamMember;
import com.techpedia.projectmanagement.bean.TotalProjectsStatisticsVO;
import com.techpedia.projectmanagement.bean.TotalProjectsYearWiseStatisticsVO;
import com.techpedia.projectmanagement.bean.UploadMultipleProjDocVO;
import com.techpedia.projectmanagement.bean.UploadProjDocVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.dao.ProjectDao;
import com.techpedia.projectmanagement.exception.AddCommentException;
import com.techpedia.projectmanagement.exception.AddNewFacultyException;
import com.techpedia.projectmanagement.exception.AddNewMentorException;
import com.techpedia.projectmanagement.exception.AddNewTeamMemberException;
import com.techpedia.projectmanagement.exception.AddTeamMembersException;
import com.techpedia.projectmanagement.exception.ApproveOrDeclineMentorRequestException;
import com.techpedia.projectmanagement.exception.BulkUploadException;
import com.techpedia.projectmanagement.exception.CheckProjectFollowException;
import com.techpedia.projectmanagement.exception.CollegeRecentProjectsException;
import com.techpedia.projectmanagement.exception.CreateProjectException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DeleteProjectException;
import com.techpedia.projectmanagement.exception.DownloadProjDocException;
import com.techpedia.projectmanagement.exception.FacultyClosedProjectException;
import com.techpedia.projectmanagement.exception.FacultyInitiatedProjectException;
import com.techpedia.projectmanagement.exception.FacultyMarkedProjectAsCompletedException;
import com.techpedia.projectmanagement.exception.FacultyRejectedProjectException;
import com.techpedia.projectmanagement.exception.FollowTheProjectException;
import com.techpedia.projectmanagement.exception.GetAllBranchesException;
import com.techpedia.projectmanagement.exception.GetAllFollowedProjectException;
import com.techpedia.projectmanagement.exception.GetAllGytiProjectException;
import com.techpedia.projectmanagement.exception.GetAllMentorsException;
import com.techpedia.projectmanagement.exception.GetAllProjectException;
import com.techpedia.projectmanagement.exception.GetAllReviewsException;
import com.techpedia.projectmanagement.exception.GetDetailOfTeamException;
import com.techpedia.projectmanagement.exception.GetGYTIProjectStatisticsException;
import com.techpedia.projectmanagement.exception.GetGytiProjectRatingDetailsException;
import com.techpedia.projectmanagement.exception.GetPopularityException;
import com.techpedia.projectmanagement.exception.GetProjectDetailsException;
import com.techpedia.projectmanagement.exception.GetProjectFollowersException;
import com.techpedia.projectmanagement.exception.GetProjectTypeException;
import com.techpedia.projectmanagement.exception.GetSuggestedReviewersException;
import com.techpedia.projectmanagement.exception.GytiInnovationCountException;
import com.techpedia.projectmanagement.exception.GytiReviewedInnovationCountException;
import com.techpedia.projectmanagement.exception.OtherCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.ProjectByLoggedInUserException;
import com.techpedia.projectmanagement.exception.ProjectMacroBranchException;
import com.techpedia.projectmanagement.exception.RejectSuggestedProjectForReviewException;
import com.techpedia.projectmanagement.exception.RemoveCommentException;
import com.techpedia.projectmanagement.exception.RemoveMentorException;
import com.techpedia.projectmanagement.exception.RemoveProjectFollowException;
import com.techpedia.projectmanagement.exception.RemoveTeamMembersException;
import com.techpedia.projectmanagement.exception.ReplaceTeamLeadException;
import com.techpedia.projectmanagement.exception.RequestToBeMentorException;
import com.techpedia.projectmanagement.exception.SaveProjectPhotoException;
import com.techpedia.projectmanagement.exception.ResubmitProjectException;
import com.techpedia.projectmanagement.exception.ReviewRatingException;
import com.techpedia.projectmanagement.exception.SearchProjectException;
import com.techpedia.projectmanagement.exception.SubmitAcademicProjectToGytiException;
import com.techpedia.projectmanagement.exception.SubmitProjectToGytiException;
import com.techpedia.projectmanagement.exception.SubmitProjectsException;
import com.techpedia.projectmanagement.exception.SuggestReviewerException;
import com.techpedia.projectmanagement.exception.SuggestedBranchNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedFacultyNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedTeamMembersNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedkeywordsNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.TotalProectsStatisticsException;
import com.techpedia.projectmanagement.exception.TotalProectsYearWiseStatisticsException;
import com.techpedia.projectmanagement.exception.UpdateGytiInnovationException;
import com.techpedia.projectmanagement.exception.UpdateProjectException;
import com.techpedia.projectmanagement.exception.UploadMultipleProjDocException;
import com.techpedia.projectmanagement.exception.UploadProjDocException;
import com.techpedia.projectmanagement.exception.updateGytiProjectReviewRatingException;

@Service
public class ProjectServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceHelper.class.getName());

	@Autowired
	ProjectDao projectDao;


	/**
	 * @param project
	 * @return result flag
	 * @throws SaveProjectPhotoException 
	 */
	public  String createProject(Project project) throws CreateProjectException, EmailServiceException, SaveProjectPhotoException{

		//LOGGER.debug("ProjectServiceHelper.createProject:Start");
		ProjectServiceResponse response = new ProjectServiceResponse();
		CreateProjectResponseVO createProjectResponseVO;	
		String result = "N";
		try {
			createProjectResponseVO = projectDao.createProject(project);
			if(!(project.getImgName().equalsIgnoreCase("")&&project.getFooterImgName().equalsIgnoreCase(""))){
				SaveProjectPhotoVO saveProjectPhoto =new SaveProjectPhotoVO();
				saveProjectPhoto.setProjectId(project.getProjId());
				saveProjectPhoto.setImgName(project.getImgName());
				saveProjectPhoto.setImgByteArray(project.getImgByteArray());
				saveProjectPhoto.setFooterImgName(project.getFooterImgName());
				saveProjectPhoto.setFooterImgByteArray(project.getFooterImgByteArray());
				result = projectDao.uploadProjectPhoto(saveProjectPhoto);
			}

			if(createProjectResponseVO.getStatus() == "Y" && project.getImgName().equalsIgnoreCase("") && project.getFooterImgName().equalsIgnoreCase("")){	

				//ProjectManagementEMailHelper.sendEmail(project, createProjectResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_CREATE_SUCCESS);
				return gson.toJson(response);
			}
			else if(createProjectResponseVO.getStatus() == "Y" && result == "Y"){
				//ProjectManagementEMailHelper.sendEmail(project, createProjectResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_CREATE_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
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
	public  String getSuggestedkeywords(ArrayList<String> branchIds) throws NumberFormatException, SuggestedkeywordsNotFoundException{

		ArrayList<Integer> branches = null;
		ArrayList<String> suggestedKeywords = null;		
		try {
			branches = new ArrayList<Integer>(branchIds.size()); 
			for (String branchId : branchIds) { 
				branches.add(Integer.valueOf(branchId)); 
			}
			suggestedKeywords = projectDao.getSuggestedkeywords(branches);
			if(suggestedKeywords != null){
				Gson gson = new Gson();
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
	public  String getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException{
		ArrayList<Team> teams = null;		
		try {
			teams = projectDao.getSuggestedTeamMembers(userProfileVO);
			if(teams != null){
				Gson gson = new Gson();
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
	public  String getSuggestedBranches(String term) throws SuggestedBranchNotFoundException{		
		ArrayList<Branch> branches = null;		
		try {
			branches = projectDao.getSuggestedBranches(term);
			if(branches != null){
				Gson gson = new Gson();
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
	public  String getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException{
		ArrayList<Faculty> faculties = null;		
		try {
			faculties = projectDao.getSuggestedFaculty(userId);
			if(faculties != null){
				Gson gson = new Gson();
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
	public  String addNewFaculty(FacultyVO facultyVO){
		AddNewFacultyResponseVO addNewFacultyResponseVO = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			addNewFacultyResponseVO = projectDao.addNewFaculty(facultyVO);
			if(addNewFacultyResponseVO.getRgstrId() != ""){
				FacultyEMailHelper.sendEmail(facultyVO, addNewFacultyResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddNewFacultyException e) {
			e.printStackTrace();
		} catch (EmailServiceException e) {
			e.printStackTrace();
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	/**
	 * @param projId
	 * @return result flag
	 */
	public  String deleteProject(long projId) throws DeleteProjectException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.deleteProject(projId);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DELETE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String getProjectDetails(long projId) throws GetProjectDetailsException{
		Project project = null;
		try {
			project = projectDao.getProjectDetails(projId);
			if(project != null){
				Gson gson = new Gson();
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
	public  String getAllProject(String iterationCount) throws GetAllProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.getAllProject(iterationCount);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String getRecentproject() throws GetAllProjectException{
		ArrayList<Project> projects =null;
		try {
			projects = projectDao.getRecentProject();
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String getLatestproject() throws GetAllProjectException{
		ArrayList<Project> projects =null;
		try {
			projects = projectDao.getLatestProject();
			if(projects != null){
				Gson gson = new Gson();
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
	public  String getAllMentors(String iterationCount) throws GetAllMentorsException{
		ArrayList<UserProfileVO> userProfileVOs = null;
		//LOGGER.debug("ProjectServiceHelper.getAllMentors:Start");
		try {
			userProfileVOs = projectDao.getAllMentors(iterationCount);
			if(userProfileVOs != null){
				Gson gson = new Gson();
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
	public  String getPopularity(String rgstrId) throws GetPopularityException{
		String popularity = null;
		try {
			popularity = projectDao.getPopularity(rgstrId);
			if(popularity != null){
				Gson gson = new Gson();
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
	public  String updateProject(Project project) throws UpdateProjectException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.updateProject(project);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_UPDATE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String addTeamMembers(ArrayList<TeamMember> teamMembers) throws AddTeamMembersException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.addTeamMembers(teamMembers);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String removeTeamMembers(ArrayList<TeamMember> teamMembers) throws RemoveTeamMembersException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.removeTeamMembers(teamMembers);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_REMOVE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String searchProjectByKeyword(SearchByKeyVO searchByKeyVO) throws SearchProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.searchProjectByKeyword(searchByKeyVO);
			if(projects != null){
				Gson gson = new Gson();
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
	public  String addNewMentor(MentorVO mentorVO) throws AddNewMentorException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.addNewMentor(mentorVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String deleteMentor(MentorVO mentorVO) throws RemoveMentorException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.deleteMentor(mentorVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.MENTOR_REMOVE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String followTheProject(FollowProjectVO followProjectVO) throws FollowTheProjectException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.followTheProject(followProjectVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String displayTeamComments(DisplayTeamCommVO displayTeamCommVO) throws TeamCommentsNotFoundException{
		ArrayList<ProjectTeamComment> comments = null;
		try {
			comments = projectDao.displayTeamComments(displayTeamCommVO);
			if(comments != null){
				Gson gson = new Gson();
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
	public  String addComment(AddCommVO addCommVO) throws AddCommentException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.addComment(addCommVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.COMMENT_ADD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String deleteComment(DeleteCommVO deleteCommVO) throws RemoveCommentException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.deleteComment(deleteCommVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_COMMENT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String getAllFollowedProject(String rgstrId) throws GetAllFollowedProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.getAllFollowedProject(rgstrId);
			if(projects != null){
				Gson gson = new Gson();
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
	public  String getDetailOfTeam(String teamId) throws GetDetailOfTeamException{
		ArrayList<ProjectTeamDetailVO> teamDetailVOs = null;
		try {
			teamDetailVOs = projectDao.getDetailOfTeam(teamId);
			if(teamDetailVOs != null){
				Gson gson = new Gson();
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
	public  String removeProjectFollow(ProjFollowVO projFollowVO) throws RemoveProjectFollowException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.removeProjectFollow(projFollowVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DELETE_FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String checkProjectFollow(ProjFollowVO projFollowVO) throws CheckProjectFollowException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.checkProjectFollow(projFollowVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.CHECK_FOLLOW_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String submitProject(ProjSubmit projSubmit) throws SubmitProjectsException, EmailServiceException{		
		Project project = new Project();
		String result = "N";
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			project = projectDao.submitProject(projSubmit);
			if(project.getProjTitle() != ""){
				ProjectManagementEMailHelper.sendEmail(project);
				result = "Y";
				if(result == "Y"){				
					Gson gson = new Gson();
					response.setStatus(ProjectManagementServiceConstant.SUCCESS);
					response.setDescription(ProjectManagementServiceConstant.PROJECT_SUBMITION_SUCCESS);
					return gson.toJson(response);
				}else{
					Gson gson = new Gson();
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
	public  String uploadProjectDocument(UploadProjDocVO uploadProjDocVO) throws UploadProjDocException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.uploadProjectDocument(uploadProjDocVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_UPLOAD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
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
	public  String downloadProjectDocument(DownloadDocVO downloadDocVO) throws DownloadProjDocException{
		ArrayList<ProjectDocument> projectDocuments = null;
		try {
			projectDocuments = projectDao.downloadProjectDocument(downloadDocVO);
			if(projectDocuments != null){
				Gson gson = new Gson();
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
	public  String displayOtherComments(DisplayTeamCommVO displayTeamCommVO) throws OtherCommentsNotFoundException{
		ArrayList<ProjectTeamComment> projectTeamComments = null;
		try {
			projectTeamComments = projectDao.displayOtherComments(displayTeamCommVO);
			if(projectTeamComments != null){
				Gson gson = new Gson();
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
	public  String getProjectsByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			projects = projectDao.getProjectsByLoggedInUser(rgstrId);
			if(projects != null){
				Gson gson = new Gson();
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
	public  String bulkUploadProject(String exlByteArray) throws BulkUploadException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			result = projectDao.bulkUploadProject(exlByteArray);
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
		} catch (BulkUploadException e) {			
			LOGGER.error("An unexpected error occured while bulkUploadProject Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.PROJECT_UPLOAD_FAILURE);
			response.setExceptionMessage(e.getMessage());
			return gson.toJson(response);
		}		
	}

	public  String getProjectFollowers() throws GetProjectFollowersException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.getProjectFollowers();
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetProjectFollowersException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String deleteProjectDocument(DeleteDocVO deleteDocVO) throws DeleteDocumentException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			result = projectDao.deleteProjectDocument(deleteDocVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_DELETE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_DOC_DELETE_FAILURE);
				return gson.toJson(response);
			}
		} catch (DeleteDocumentException e) {			
			throw e;
		}		
	}

	public  String facultyInitiatedProject(FacInitProjVO facInitProjVO) throws FacultyInitiatedProjectException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			result = projectDao.facultyInitiatedProject(facInitProjVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_INITIATED_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_INITIATED_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyInitiatedProjectException e) {			
			throw e;
		}		
	}

	public  String facultyClosedProject(FacInitProjVO facInitProjVO) throws FacultyClosedProjectException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			result = projectDao.facultyClosedProject(facInitProjVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CLOSED_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_CLOSED_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyClosedProjectException e) {			
			throw e;
		}		
	}

	public  String getProjectType() throws GetProjectTypeException{
		ArrayList<ProjectType> projectTypes = null;
		try {
			projectTypes = projectDao.getProjectType();
			if(projectTypes != null){
				Gson gson = new Gson();
				return gson.toJson(projectTypes);
			}
		} catch (GetProjectTypeException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String getProjectsByMacroBranch(DisplayProjectsMacroBranchVO displayProjectsMacroBranchVO) throws ProjectByLoggedInUserException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.getProjectsByMacroBranch(displayProjectsMacroBranchVO);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (ProjectByLoggedInUserException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String replaceTeamLead(ReplaceTeamLead replaceTeamLead) throws ReplaceTeamLeadException {
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.replaceTeamLead(replaceTeamLead);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_LEADER_REPLACE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.TEAM_LEADER_REPLACE_FAILURE);
				return gson.toJson(response);
			}
		} catch (ReplaceTeamLeadException e) {			
			throw e;
		}		
	}

	public Object getCompletedProject() throws GetAllProjectException{
		ArrayList<Project> projects =null;
		try {
			projects = projectDao.getCompletedProject();
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public Object getWorkingProject() throws GetAllProjectException{
		ArrayList<Project> projects =null;
		try {
			projects = projectDao.getWorkingProject();
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	/**
	 * @param rgstrId
	 * @return
	 */
	public  String getCompletedProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			projects = projectDao.getCompletedProjectByLoggedInUser(rgstrId);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (ProjectByLoggedInUserException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	/**
	 * @param rgstrId
	 * @return
	 */
	public  String getWorkingProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			projects = projectDao.getWorkingProjectByLoggedInUser(rgstrId);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (ProjectByLoggedInUserException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String facultyRejectedProject(FacRejectProjVO facRejectProjVO) throws FacultyRejectedProjectException, EmailServiceException{

		FacRejectProjResponse facRejectProjResponse = new FacRejectProjResponse();
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			facRejectProjResponse = projectDao.facultyRejectedProject(facRejectProjVO);
			if(facRejectProjResponse.getStatus() == "Y"){
				FacultyEMailHelper.sendFacultyRejectedProjectEmail(facRejectProjResponse);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_REJECTED_PROJECT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_REJECTED_PROJECT_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyRejectedProjectException e) {	
			LOGGER.error("An unexpected Exception occured while facultyRejectedProject Ex :: ", e);
			throw e;
		}
		catch (EmailServiceException e) {
			LOGGER.error("An unexpected EmailServiceException occured while facultyRejectedProject Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(ProjectManagementServiceConstant.SUCCESS_WITH_MAIL_FAILURE);
			return gson.toJson(response);
		}
	}

	public String resubmitProject(String projId) throws ResubmitProjectException, EmailServiceException {

		ResubmitProjectResponse resubmitProjectResponse = new ResubmitProjectResponse();
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			resubmitProjectResponse = projectDao.resubmitProject(projId);
			if(resubmitProjectResponse.getStatus() == "Y"){
				ProjectManagementEMailHelper.sendResubmitProjectEmail(resubmitProjectResponse.getProject(), resubmitProjectResponse);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_RESUBMIT_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_RESUBMIT_FAILURE);
				return gson.toJson(response);
			}
		} catch (ResubmitProjectException e) {			
			throw e;
		}	
	}

	public String facultyMarkedProjectAsCompleted(FacultyMarkedProjectAsCompletedVO facultyMarkedProjectAsCompletedVO)  throws FacultyMarkedProjectAsCompletedException, EmailServiceException {
		FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompletedResponse = new FacultyMarkedProjectAsCompletedResponse();
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			facultyMarkedProjectAsCompletedResponse = projectDao.facultyMarkedProjectAsCompleted(facultyMarkedProjectAsCompletedVO);
			if(facultyMarkedProjectAsCompletedResponse.getStatus() == "Y"){		
				FacultyEMailHelper.sendFacultyMarkedProjectAsCompleteEmail(facultyMarkedProjectAsCompletedResponse);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_MARKED_PROJECT_AS_COMPLETED_SUCCESS);
				return gson.toJson(response);
			}else if(facultyMarkedProjectAsCompletedResponse.getStatus() == "N"){
				FacultyEMailHelper.sendFacultyRejectedProjectAtClosureEmail(facultyMarkedProjectAsCompletedResponse);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_REJECTED_PROJECT_AT_CLOSURE_SUCCESS);
				return gson.toJson(response);

			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.FACULTY_MARKED_PROJECT_AS_COMPLETED_FAILURE);
				return gson.toJson(response);
			}
		} catch (FacultyMarkedProjectAsCompletedException e) {	
			LOGGER.error("An unexpected Exception occured while facultyMarkedProjectAsCompleted Ex :: ", e);
			throw e;
		}	
		catch (EmailServiceException e) {
			LOGGER.error("An unexpected EmailServiceException occured while facultyMarkedProjectAsCompleted Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(ProjectManagementServiceConstant.SUCCESS_WITH_MAIL_FAILURE);
			return gson.toJson(response);
		}
	}

	public String requestToBeMentor(RequestToBeMentorVO requestToBeMentorVO) throws EmailServiceException, RequestToBeMentorException {
		RequestToBeMentorResponse requestToBeMentorResponse = new RequestToBeMentorResponse();
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			requestToBeMentorResponse = projectDao.requestToBeMentor(requestToBeMentorVO);

			if(requestToBeMentorResponse.getStatus() == "Y" && ProjectManagementEMailHelper.sendRequestToBeMentorEmail(requestToBeMentorResponse)){		
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.REQUEST_TO_BE_MENTOR_SUCCESS);
				return gson.toJson(response);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.REQUEST_TO_BE_MENTOR_FAILURE);
				return gson.toJson(response);
			}
		} catch (RequestToBeMentorException e) {		
			LOGGER.error("An unexpected Exception occured while requestToBeMentor Ex :: ", e);
			throw e;
		} catch (EmailServiceException e) {
			LOGGER.error("An unexpected EmailServiceException occured while requestToBeMentor Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(ProjectManagementServiceConstant.SUCCESS_WITH_MAIL_FAILURE);
			return gson.toJson(response);
		}
		
	}

	public String approveOrDeclineMentorRequest(ApproveOrDeclineMentorRequestVO approveOrDeclineMentorRequestVO) throws EmailServiceException, ApproveOrDeclineMentorRequestException {
		ApproveOrDeclineMentorRequestResponse approveOrDeclineMentorRequestResponse = new ApproveOrDeclineMentorRequestResponse();
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			approveOrDeclineMentorRequestResponse = projectDao.approveOrDeclineMentorRequest(approveOrDeclineMentorRequestVO);

			if(approveOrDeclineMentorRequestResponse.getStatus() == "Y" && ProjectManagementEMailHelper.sendApproveOrDeclineMentorRequestEmail(approveOrDeclineMentorRequestResponse)){		
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.REQUEST_TO_BE_MENTOR_SUCCESS);
				return gson.toJson(response);
			}

			else if(approveOrDeclineMentorRequestResponse.getStatus() == "N" && ProjectManagementEMailHelper.sendApproveOrDeclineMentorRequestEmail(approveOrDeclineMentorRequestResponse)){
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.DECLINE_MENTOR_REQUEST_SUCCESS);
				return gson.toJson(response);

			}
			else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.APPROVE_OR_DECLINE_MENTOR_REQUEST_FAILURE);
				return gson.toJson(response);
			}
		} catch (ApproveOrDeclineMentorRequestException e) {	
			LOGGER.error("An unexpected Exception occured while approveOrDeclineMentorRequest Ex :: ", e);
			throw e;
		} catch (EmailServiceException e) {
			LOGGER.error("An unexpected EmailServiceException occured while approveOrDeclineMentorRequest Ex :: ", e);
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.PARTIAL_SUCCESS);
			response.setDescription(ProjectManagementServiceConstant.SUCCESS_WITH_MAIL_FAILURE);
			return gson.toJson(response);
		}
	}

	public  String getProjectMacroBranch() throws ProjectMacroBranchException{
		ArrayList<ProjectMacroBranch> projectsMacro = new ArrayList<ProjectMacroBranch>();
		try {
			projectsMacro = projectDao.getprojectMacroBranch();
			if(projectsMacro != null){
				Gson gson = new Gson();
				return gson.toJson(projectsMacro);
			}
		} catch (ProjectMacroBranchException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String getAllProjectsByMacroBranch(DisplayProjectMacroVO displayProjectMacro) throws GetAllProjectException{
		ArrayList<Project> projects = null;
		try {
			projects = projectDao.getAllProjectBymacroBranch(displayProjectMacro);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (GetAllProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String getCollegeRecentProjects(String collegeName) throws CollegeRecentProjectsException{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			projects = projectDao.getCollegeRecentProjects(collegeName);
			if(projects != null){
				Gson gson = new Gson();
				return gson.toJson(projects);
			}
		} catch (CollegeRecentProjectsException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String submitAcademicProjectToGyti(ProjectGytiAddInfo gytiAddInfo) throws SubmitAcademicProjectToGytiException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			result = projectDao.submitAcademicProjectToGyti(gytiAddInfo);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_ACADEMIC_PROJECT_TO_GYTI_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_ACADEMIC_PROJECT_TO_GYTI_FAILURE);
				return gson.toJson(response);
			}
		} catch (SubmitAcademicProjectToGytiException e) {			
			throw e;
		}		
	}

	public  String getAllBranches() throws GetAllBranchesException{
		ArrayList<Branch> branches = new ArrayList<Branch>();
		try {
			branches = projectDao.getAllBranches();
			if(branches != null){
				Gson gson = new Gson();
				return gson.toJson(branches);
			}
		} catch (GetAllBranchesException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public  String submitProjectToGyti(SubmitInnovationToGytiVO innovationInfo) throws SubmitProjectToGytiException, SaveProjectPhotoException{
		String result = null;
		String imageResult = null;
		SubmitGytiInnovationResponseVO response = new SubmitGytiInnovationResponseVO();
		try {
			result = projectDao.submitProjectToGyti(innovationInfo);
			if(!(innovationInfo.getImgName().equalsIgnoreCase("")&&innovationInfo.getFooterImgName().equalsIgnoreCase(""))){
				SaveProjectPhotoVO saveProjectPhoto =new SaveProjectPhotoVO();
				saveProjectPhoto.setProjectId(innovationInfo.getProjId());
				saveProjectPhoto.setImgName(innovationInfo.getImgName());
				saveProjectPhoto.setImgByteArray(innovationInfo.getImgByteArray());
				saveProjectPhoto.setFooterImgName(innovationInfo.getFooterImgName());
				saveProjectPhoto.setFooterImgByteArray(innovationInfo.getFooterImgByteArray());
				imageResult = projectDao.uploadProjectPhoto(saveProjectPhoto);
			}
			if(result == "Y" && innovationInfo.getImgName().equalsIgnoreCase("") && innovationInfo.getFooterImgName().equalsIgnoreCase("")){	

				//ProjectManagementEMailHelper.sendEmail(project, createProjectResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_ACADEMIC_PROJECT_TO_GYTI_SUCCESS);
				response.setProjId(innovationInfo.getProjId());
				response.setProjTitle(innovationInfo.getProjTitle());
				return gson.toJson(response);
			}
			else if(result == "Y" && imageResult == "Y"){
				//ProjectManagementEMailHelper.sendEmail(project, createProjectResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_ACADEMIC_PROJECT_TO_GYTI_SUCCESS);
				response.setProjId(innovationInfo.getProjId());
				response.setProjTitle(innovationInfo.getProjTitle());
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_ACADEMIC_PROJECT_TO_GYTI_FAILURE);
				return gson.toJson(response);
			}
		} catch (SubmitProjectToGytiException e) {			
			throw e;
		}
		catch (SaveProjectPhotoException e) {			
			throw e;
		}
	}

	public String uploadMultipleProjectDocument(UploadMultipleProjDocVO uploadMultipleProjDocVO) throws UploadMultipleProjDocException {
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.uploadMultipleProjectDocument(uploadMultipleProjDocVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_MULTIPLE_DOC_UPLOAD_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.PROJECT_MULTIPLE_DOC_UPLOAD_FAILURE);
				return gson.toJson(response);
			}
		} catch (UploadMultipleProjDocException e) {			
			throw e;
		}		
	}

	public String getAllGytiProject(int interationCount) throws GetAllGytiProjectException{
		ArrayList<GytiProjectVO> gytiProjectVOs = null;
		try {
			gytiProjectVOs = projectDao.getAllGytiProject(interationCount);
			if(gytiProjectVOs != null){
				Gson gson = new Gson();
				return gson.toJson(gytiProjectVOs);
			}
		} catch (GetAllGytiProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public String getAllGytiProjectByLoggedInUser(String rgstrId) throws GetAllGytiProjectException{
		ArrayList<GytiProjectVO> gytiProjectVOs = null;
		try {
			gytiProjectVOs = projectDao.getAllGytiProjectByLoggedInUser(rgstrId);
			if(gytiProjectVOs != null){
				Gson gson = new Gson();
				return gson.toJson(gytiProjectVOs);
			}
		} catch (GetAllGytiProjectException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}


	/**
	 * @param projId
	 * @return SubmitInnovationToGytiVO
	 */
	public  String getgytiProjectDetails(long projId) throws GetProjectDetailsException{
		SubmitInnovationToGytiVO submitInnovationToGytiVO = null;
		try {
			submitInnovationToGytiVO = projectDao.getgytiProjectDetails(projId);
			if(submitInnovationToGytiVO != null){
				Gson gson = new Gson();
				return gson.toJson(submitInnovationToGytiVO);
			}
		} catch (GetProjectDetailsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}


	/**
	 * @param innovationInfo
	 * @return ProjectServiceResponse
	 */
	public  String updateGytiProject(SubmitInnovationToGytiVO innovationInfo) throws UpdateGytiInnovationException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.updateGytiProject(innovationInfo);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.UPDATE_ACADEMIC_PROJECT_TO_GYTI_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.UPDATE_ACADEMIC_PROJECT_TO_GYTI_FAILURE);
				return gson.toJson(response);
			}
		} catch (UpdateGytiInnovationException e) {

			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}		
	}
	/**
	 * @return ProjectDao
	 *//*
	private  ProjectDao getProjectDao() {

		if (projectDao == null) {
			projectDao = new ProjectDaoImpl();
		}
		return projectDao;
	}*/

	public String getGYTIProjectStatistics () throws GetGYTIProjectStatisticsException{
		ArrayList<GYTIProjectStatisticsVO>  projectsByCategory=null;

		try {
			projectsByCategory=projectDao.getGYTIProjectStatistics();
			if(projectsByCategory != null){
				Gson gson = new Gson();
				return gson.toJson(projectsByCategory);
			}
		} catch (Exception e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public Object submitReviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException {
		String result=null;
		ProjectServiceResponse response=new ProjectServiceResponse();

		try {

			result=projectDao.reviewRating(reviewRating);
			if(result=="Y")
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_REVIEW_RATING_SUCCESS);
				return gson.toJson(response);
			}
			else
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.SUBMIT_REVIEW_RATING_FAILURE);
				return gson.toJson(response);
			}

		} catch (ReviewRatingException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.SUBMIT_REVIEW_RATING_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	
	public String getAllGytiProjectByLoggedInReviewer(String revRgstrId,String awardYear) throws GetAllGytiProjectException{
		GetAllGytiProjectByLoggedInReviewerResponse getAllGytiProjectByLoggedInReviewerResponse = null;
		try {
			getAllGytiProjectByLoggedInReviewerResponse = projectDao.getAllGytiProjectByLoggedInReviewer(revRgstrId,awardYear);
			if(getAllGytiProjectByLoggedInReviewerResponse != null){
				Gson gson = new Gson();
				return gson.toJson(getAllGytiProjectByLoggedInReviewerResponse);
			}
		} catch (GetAllGytiProjectException e) {			
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public  String suggestReviewer(ArrayList<SuggestReviewerVO> suggestReviewerVO) throws SuggestReviewerException{
		String result = null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {

			result=projectDao.suggestReviewer(suggestReviewerVO);
			if(result=="Y")
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SUGGEST_REVIEWER_SUCCESS);
				return gson.toJson(response);
			}
			else
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.SUGGEST_REVIEWER_FAILURE);
				return gson.toJson(response);
			}

		} catch (SuggestReviewerException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.SUGGEST_REVIEWER_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	public String getAllReviews(String awardYear) throws GetAllReviewsException {
		List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings = null;
		try {
			overallCalculatedReviewRatings = projectDao.getAllReviews(awardYear);
			if(overallCalculatedReviewRatings != null){
				Gson gson = new Gson();
				return gson.toJson(overallCalculatedReviewRatings);
			}
		} catch (GetAllReviewsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	@SuppressWarnings("unused")
	public String getgytiProjectReviewDetails(GetReviewRatingVO getReviewRatingVO) throws GetGytiProjectRatingDetailsException{
		ReviewRatingVO reviewRatingVO=null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			reviewRatingVO = projectDao.getgytiProjectReviewDetails(getReviewRatingVO);

			if (reviewRatingVO != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(reviewRatingVO);
			}
			else if (reviewRatingVO == null) {
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.NO_RATING_AVAILABLE);
				return gson.toJson(response);
			}
		} catch (GetGytiProjectRatingDetailsException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.GET_RATING_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	/**
	 * @return ProjectServiceResponse
	 */
	public  String updateGytiProjectReviewRating(ReviewRatingVO reviewRatingVO) throws updateGytiProjectReviewRatingException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.updateGytiProjectReviewRating(reviewRatingVO);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.UPDATE_GYTI_PROJECT_RATING_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.UPDATE_GYTI_PROJECT_RATING_NOT_FOUND);
				return gson.toJson(response);
			}
		} catch (updateGytiProjectReviewRatingException e) {

			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.UPDATE_GYTI_PROJECT_RATING_FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}		
	}

	public String getLatestGytiProject() throws GetAllGytiProjectException{
		ArrayList<GytiProjectVO> gytiProjectVOs = null;
		try {
			gytiProjectVOs = projectDao.getLatestGytiProject();
			if(gytiProjectVOs != null){
				Gson gson = new Gson();
				return gson.toJson(gytiProjectVOs);
			}
		} catch (GetAllGytiProjectException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}


	@SuppressWarnings("unused")
	public String getRatingDetailsByReviwer(String ratingId) throws GetGytiProjectRatingDetailsException{
		ReviewRatingVO reviewRatingVO=null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			reviewRatingVO = projectDao.getRatingDetailsByReviwer(ratingId);

			if (reviewRatingVO != null) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(reviewRatingVO);
			}
			else if (reviewRatingVO == null) {
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.NO_RATING_AVAILABLE);
				return gson.toJson(response);
			}
		} catch (GetGytiProjectRatingDetailsException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.GET_RATING_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	public String getAllReviewsByLoggedInReviewerAndOthers(String revRgstrId, String awardYear) throws GetAllReviewsException {
		GetAllReviewsByLoggedInReviewerAndOthersResponse getAllReviewsByLoggedInReviewerAndOthersResponse = null;
		try {
			getAllReviewsByLoggedInReviewerAndOthersResponse = projectDao.getAllReviewsByLoggedInReviewerAndOthers(revRgstrId, awardYear);
			if(getAllReviewsByLoggedInReviewerAndOthersResponse != null){
				Gson gson = new Gson();
				return gson.toJson(getAllReviewsByLoggedInReviewerAndOthersResponse);
			}
		} catch (GetAllReviewsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}

	
	public String getSuggestedReviewersByLoggedInReviewer(long assignedBy) throws GetSuggestedReviewersException{
		ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> suggestedReviews=null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			suggestedReviews = projectDao.getSuggestedReviewersByLoggedInReviewer(assignedBy);
			LOGGER.info("suggestedReviews size :: "+suggestedReviews.size());
			if (suggestedReviews.size()>0) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(suggestedReviews);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.NO_SUGGESTED_REVIEWERS_AVAILABLE);
				return gson.toJson(response);
			}
		} catch (GetSuggestedReviewersException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setExceptionMessage(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	
	public String getAllSuggestedReviewersList() throws GetSuggestedReviewersException{
		ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> suggestedReviews=null;
		ProjectServiceResponse  response = new ProjectServiceResponse();
		try {
			suggestedReviews = projectDao.getAllSuggestedReviewersList();

			if (suggestedReviews.size()>0) {
				Gson gson = new Gson();
				gson = new Gson();
				return gson.toJson(suggestedReviews);
			}
			else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.NO_SUGGESTED_REVIEWERS_AVAILABLE);
				return gson.toJson(response);
			}
		} catch (GetSuggestedReviewersException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setExceptionMessage(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	
	/**
	 * @param ratingId
	 * @return ProjectServiceResponse
	 */
	public  String rejectSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.rejectSuggestedProjectForReview(getReviewRating);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.REJECT_SUGGESTED_GYTI_PROJECT_RATING_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.REJECT_SUGGESTED_GYTI_PROJECT_RATING_NOT_FOUND);
				return gson.toJson(response);
			}
		} catch (RejectSuggestedProjectForReviewException e) {

			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.REJECT_SUGGESTED_GYTI_PROJECT_RATING_FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}		
	}
	
	public String getAllReviewsForSpecificProject(long projId) throws GetAllReviewsException {
		OverallCalculatedReviewRatingVO overallCalculatedReviewRating = null;
		try {
			overallCalculatedReviewRating = projectDao.getAllReviewsForSpecificProject(projId);
			if(overallCalculatedReviewRating != null){
				Gson gson = new Gson();
				return gson.toJson(overallCalculatedReviewRating);
			}
		} catch (GetAllReviewsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String  getGytiInnovationCount() throws GytiInnovationCountException {
		long gytiInnovationCount;
		try {
			gytiInnovationCount = projectDao.gytiInnovationCount();
			if(gytiInnovationCount != 0){
				Gson gson = new Gson();
				return gson.toJson(gytiInnovationCount);
			}
		} catch (GytiInnovationCountException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String  getGytiYearWiseInnovationCount(int year) throws GytiInnovationCountException {
		long gytiInnovationCount;
		try {
			gytiInnovationCount = projectDao.gytiYearWiseInnovationCount(year);
			if(gytiInnovationCount != 0){
				Gson gson = new Gson();
				return gson.toJson(gytiInnovationCount);
			}
		} catch (GytiInnovationCountException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String  getGytiYearWiseReviewedInnovationCount(int year) throws GytiReviewedInnovationCountException {
		long gytiReviewedInnovationCount;
		try {
			gytiReviewedInnovationCount = projectDao.gytiYearWiseReviewedInnovationCount(year);
			if(gytiReviewedInnovationCount != 0){
				Gson gson = new Gson();
				return gson.toJson(gytiReviewedInnovationCount);
			}
		} catch (GytiReviewedInnovationCountException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String  totalProjectsStatistics() throws TotalProectsStatisticsException {
		List<TotalProjectsStatisticsVO> totalProjectsStatistics = null;
		try {
			totalProjectsStatistics = projectDao.totalProjectsStatistics();
			if(totalProjectsStatistics != null){
				Gson gson = new Gson();
				return gson.toJson(totalProjectsStatistics);
			}
		} catch (TotalProectsStatisticsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String totalProjectsYearWiseStatistics() throws TotalProectsYearWiseStatisticsException {
		Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWise = null;
		try {
			totalProjectsYearWise = projectDao.totalProjectsYearWiseStatistics();
			if(totalProjectsYearWise != null){
				Gson gson = new Gson();
				return gson.toJson(totalProjectsYearWise);
			}
		} catch (TotalProectsYearWiseStatisticsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String totalProjectsInAYearStatistics(int year) throws TotalProectsYearWiseStatisticsException {
		Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWise = null;
		try {
			totalProjectsYearWise = projectDao.totalProjectsInAYearStatistics(year);
			if(totalProjectsYearWise != null){
				Gson gson = new Gson();
				return gson.toJson(totalProjectsYearWise);
			}
		} catch (TotalProectsYearWiseStatisticsException e) {
			throw e;
		}
		return ProjectManagementServiceConstant.EMPTY_STRING;
	}
	
	public String addNewTeamMember(AddNewTeamMemberVO addNewTeamMemberVO) throws AddNewTeamMemberException{
		AddNewTeamMemberResponseVO addNewTeamMemberResponseVO = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			addNewTeamMemberResponseVO = projectDao.addNewTeamMember(addNewTeamMemberVO);
			if(addNewTeamMemberResponseVO.getStatus().equalsIgnoreCase("Y")){
				FacultyEMailHelper.sendEmail(addNewTeamMemberVO, addNewTeamMemberResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.TEAM_MEMBER_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddNewTeamMemberException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.TEAM_MEMBER_CREATE_FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
			
		} catch (EmailServiceException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.TEAM_MEMBER_CREATE_PARTIAL_SUCCESS);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	
	public Object saveReviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException {
		String result=null;
		ProjectServiceResponse response=new ProjectServiceResponse();

		try {

			result=projectDao.saveReviewRating(reviewRating);
			if(result=="Y")
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.SAVE_REVIEW_RATING_SUCCESS);
				return gson.toJson(response);
			}
			else
			{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.SAVE_REVIEW_RATING_FAILURE);
				return gson.toJson(response);
			}

		} catch (ReviewRatingException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.FAILURE);
			response.setDescription(ProjectManagementServiceConstant.SAVE_REVIEW_RATING_FAILURE);
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
	
	public  String acceptSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException{
		String result = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			result = projectDao.acceptSuggestedProjectForReview(getReviewRating);
			if(result == "Y"){				
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.ACCEPT_SUGGESTED_GYTI_PROJECT_RATING_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.ACCEPT_SUGGESTED_GYTI_PROJECT_RATING_NOT_FOUND);
				return gson.toJson(response);
			}
		} catch (RejectSuggestedProjectForReviewException e) {

			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.ACCEPT_SUGGESTED_GYTI_PROJECT_RATING_FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}		
	}
	
	public String registerNewFaculty(RegisterNewFacultyVO registerNewFacultyVO) throws AddNewTeamMemberException{
		RegisterNewFacultyResponseVO registerNewFacultyResponseVO = null;
		ProjectServiceResponse response = new ProjectServiceResponse();
		try {
			registerNewFacultyResponseVO = projectDao.registerNewFaculty(registerNewFacultyVO);
			if(registerNewFacultyResponseVO.getStatus().equalsIgnoreCase("Y")){
				FacultyEMailHelper.sendEmailToRegisterFaculty(registerNewFacultyVO, registerNewFacultyResponseVO);
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.SUCCESS);
				response.setDescription(ProjectManagementServiceConstant.NEW_FACULTY_CREATE_SUCCESS);
				return gson.toJson(response);
			}else{
				Gson gson = new Gson();
				response.setStatus(ProjectManagementServiceConstant.FAILURE);
				response.setDescription(ProjectManagementServiceConstant.NEW_FACULTY_CREATE_FAILURE);
				return gson.toJson(response);
			}
		} catch (AddNewTeamMemberException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.NEW_FACULTY_CREATE_FAILURE);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
			
		} catch (EmailServiceException e) {
			Gson gson = new Gson();
			response.setStatus(ProjectManagementServiceConstant.NEW_FACULTY_CREATE_PARTIAL_SUCCESS);
			response.setDescription(e.getExceptionMessage());
			response.setExceptionDetails(e.getExceptionDetails());
			return gson.toJson(response);
		}
	}
}
