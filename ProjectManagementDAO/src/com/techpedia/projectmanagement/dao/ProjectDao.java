/**
 * 
 */
package com.techpedia.projectmanagement.dao;

import java.util.ArrayList;

import com.techpedia.projectmanagement.bean.AddCommVO;
import com.techpedia.projectmanagement.bean.Branch;
import com.techpedia.projectmanagement.bean.DeleteCommVO;
import com.techpedia.projectmanagement.bean.DeleteDocVO;
import com.techpedia.projectmanagement.bean.DisplayTeamCommVO;
import com.techpedia.projectmanagement.bean.DownloadDocVO;
import com.techpedia.projectmanagement.bean.FacInitProjVO;
import com.techpedia.projectmanagement.bean.Faculty;
import com.techpedia.projectmanagement.bean.FacultyVO;
import com.techpedia.projectmanagement.bean.FollowProjectVO;
import com.techpedia.projectmanagement.bean.MentorVO;
import com.techpedia.projectmanagement.bean.ProjFollowVO;
import com.techpedia.projectmanagement.bean.ProjSubmit;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.ProjectTeamComment;
import com.techpedia.projectmanagement.bean.ProjectTeamDetailVO;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.TeamMember;
import com.techpedia.projectmanagement.bean.UploadProjDocVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.exception.AddCommentException;
import com.techpedia.projectmanagement.exception.AddNewFacultyException;
import com.techpedia.projectmanagement.exception.AddNewMentorException;
import com.techpedia.projectmanagement.exception.AddTeamMembersException;
import com.techpedia.projectmanagement.exception.BulkUploadException;
import com.techpedia.projectmanagement.exception.CheckProjectFollowException;
import com.techpedia.projectmanagement.exception.CreateProjectException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DeleteProjectException;
import com.techpedia.projectmanagement.exception.DownloadProjDocException;
import com.techpedia.projectmanagement.exception.FacultyClosedProjectException;
import com.techpedia.projectmanagement.exception.FacultyInitiatedProjectException;
import com.techpedia.projectmanagement.exception.FollowTheProjectException;
import com.techpedia.projectmanagement.exception.GetAllFollowedProjectException;
import com.techpedia.projectmanagement.exception.GetAllMentorsException;
import com.techpedia.projectmanagement.exception.GetAllProjectException;
import com.techpedia.projectmanagement.exception.GetDetailOfTeamException;
import com.techpedia.projectmanagement.exception.GetPopularityException;
import com.techpedia.projectmanagement.exception.GetProjectDetailsException;
import com.techpedia.projectmanagement.exception.GetProjectFollowersException;
import com.techpedia.projectmanagement.exception.OtherCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.ProjectByLoggedInUserException;
import com.techpedia.projectmanagement.exception.RemoveCommentException;
import com.techpedia.projectmanagement.exception.RemoveMentorException;
import com.techpedia.projectmanagement.exception.RemoveProjectFollowException;
import com.techpedia.projectmanagement.exception.RemoveTeamMembersException;
import com.techpedia.projectmanagement.exception.SearchProjectException;
import com.techpedia.projectmanagement.exception.SubmitProjectsException;
import com.techpedia.projectmanagement.exception.SuggestedBranchNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedFacultyNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedTeamMembersNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedkeywordsNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.UpdateProjectException;
import com.techpedia.projectmanagement.exception.UploadProjDocException;

/**
 * @author nishikant.singh
 *
 */
public interface ProjectDao {
	
	public abstract String createProject(Project project) throws CreateProjectException;

	public abstract ArrayList<String> getSuggestedkeywords(ArrayList<Integer> branchIds) throws SuggestedkeywordsNotFoundException;
	
	public abstract ArrayList<Team> getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException;
	
	public abstract ArrayList<Branch> getSuggestedBranches(String term) throws SuggestedBranchNotFoundException;
	
	public abstract ArrayList<Faculty> getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException;
	
	public abstract String addNewFaculty(FacultyVO facultyVO) throws AddNewFacultyException;
	
	public abstract String deleteProject(long projId) throws DeleteProjectException;
	
	public abstract Project getProjectDetails(long projId) throws GetProjectDetailsException;
	
	public abstract ArrayList<Project> getAllProject(String iterationCount) throws GetAllProjectException;
	
	public abstract ArrayList<UserProfileVO> getAllMentors(String iterationCount) throws GetAllMentorsException;
	
	public abstract String getPopularity(String rgstrId) throws GetPopularityException;
	
	public abstract String updateProject(Project project) throws UpdateProjectException;
	
	public abstract String addTeamMembers(ArrayList<TeamMember> teamMembers) throws AddTeamMembersException;
	
	public abstract String removeTeamMembers(ArrayList<TeamMember> teamMembers) throws RemoveTeamMembersException;
	
	public abstract ArrayList<Project> searchProjectByKeyword(SearchByKeyVO searchByKeyVO) throws SearchProjectException;
	
	public abstract String addNewMentor(MentorVO mentorVO) throws AddNewMentorException;

	public abstract String deleteMentor(MentorVO mentorVO) throws RemoveMentorException;
	
	public abstract String followTheProject(FollowProjectVO followProjectVO) throws FollowTheProjectException;

	public abstract ArrayList<ProjectTeamComment> displayTeamComments(DisplayTeamCommVO displayTeamCommVO) throws TeamCommentsNotFoundException;
	
	public abstract String addComment(AddCommVO addCommVO) throws AddCommentException;

	public abstract String deleteComment(DeleteCommVO deleteCommVO)throws RemoveCommentException;
	
	public abstract ArrayList<Project> getAllFollowedProject(String rgstrId) throws GetAllFollowedProjectException;
	
	public abstract String bulkUploadProject(String exlByteArray) throws BulkUploadException;
	
	public abstract ArrayList<ProjectTeamDetailVO> getDetailOfTeam(String teamId) throws GetDetailOfTeamException;
	
	public abstract String removeProjectFollow(ProjFollowVO projFollowVO) throws RemoveProjectFollowException;
	
	public abstract String checkProjectFollow(ProjFollowVO projFollowVO) throws CheckProjectFollowException;
	
	public abstract Project submitProject(ProjSubmit projSubmit) throws SubmitProjectsException;
	
	public abstract String uploadProjectDocument(UploadProjDocVO uploadProjDocVO) throws UploadProjDocException;
	
	public abstract ArrayList<ProjectDocument> downloadProjectDocument(DownloadDocVO downloadDocVO) throws DownloadProjDocException;
	
	public abstract ArrayList<ProjectTeamComment> displayOtherComments(DisplayTeamCommVO displayTeamCommVO) throws OtherCommentsNotFoundException;
	
	public abstract ArrayList<Project> getProjectsByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException;
	
	public abstract ArrayList<Project> getProjectFollowers() throws GetProjectFollowersException;
	
	public abstract String deleteProjectDocument(DeleteDocVO deleteDocVO) throws DeleteDocumentException;
	
	public abstract String facultyInitiatedProject(FacInitProjVO facInitProjVO) throws FacultyInitiatedProjectException;
	
	public abstract String facultyClosedProject(FacInitProjVO facInitProjVO) throws FacultyClosedProjectException;

}
