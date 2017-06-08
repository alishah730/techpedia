/**
 * 
 */
package com.techpedia.projectmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

/**
 * @author nishikant.singh
 *
 */
public interface ProjectDao {
	
	public abstract String uploadProjectPhoto(SaveProjectPhotoVO saveProjectPhoto) throws SaveProjectPhotoException;
	
	public abstract CreateProjectResponseVO createProject(Project project) throws CreateProjectException;

	public abstract ArrayList<String> getSuggestedkeywords(ArrayList<Integer> branchIds) throws SuggestedkeywordsNotFoundException;
	
	public abstract ArrayList<Team> getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException;
	
	public abstract ArrayList<Branch> getSuggestedBranches(String term) throws SuggestedBranchNotFoundException;
	
	public abstract ArrayList<Faculty> getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException;
	
	public abstract AddNewFacultyResponseVO addNewFaculty(FacultyVO facultyVO) throws AddNewFacultyException;
	
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
	
	public abstract ArrayList<ProjectType> getProjectType() throws GetProjectTypeException;

	public abstract ArrayList<Project> getRecentProject() throws GetAllProjectException;
	
	public abstract ArrayList<Project> getLatestProject() throws GetAllProjectException;
	
	public abstract ArrayList<GytiProjectVO> getLatestGytiProject() throws GetAllGytiProjectException;
	
	public abstract String bulkUploadProjectAsXLS(String fileName) throws BulkUploadException;

	public abstract ArrayList<Project> getProjectsByMacroBranch(DisplayProjectsMacroBranchVO displayProjectsMacroBranchVO) throws ProjectByLoggedInUserException;

	public abstract String replaceTeamLead(ReplaceTeamLead replaceTeamLead) throws ReplaceTeamLeadException;
	
	public abstract ArrayList<Project> getCompletedProject() throws GetAllProjectException;
	
	public abstract ArrayList<Project> getWorkingProject() throws GetAllProjectException;
	
	public abstract ArrayList<Project> getCompletedProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException;
	
	public abstract ArrayList<Project> getWorkingProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException;
	
	public abstract FacRejectProjResponse facultyRejectedProject(FacRejectProjVO facRejectProjVO) throws FacultyRejectedProjectException;

	public abstract ResubmitProjectResponse resubmitProject(String projId) throws ResubmitProjectException;

	public abstract FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompleted(FacultyMarkedProjectAsCompletedVO facultyMarkedProjectAsCompletedVO) throws FacultyMarkedProjectAsCompletedException;

	public abstract RequestToBeMentorResponse requestToBeMentor(RequestToBeMentorVO requestToBeMentorVO) throws RequestToBeMentorException;

	public abstract ApproveOrDeclineMentorRequestResponse approveOrDeclineMentorRequest(ApproveOrDeclineMentorRequestVO approveOrDeclineMentorRequestVO) throws ApproveOrDeclineMentorRequestException;
	
	public abstract ArrayList<ProjectMacroBranch> getprojectMacroBranch() throws ProjectMacroBranchException;
	
	public abstract ArrayList<Project> getAllProjectBymacroBranch( DisplayProjectMacroVO displayProjectMacro ) throws GetAllProjectException;

	public abstract ArrayList<Project> getCollegeRecentProjects(String collegeName) throws CollegeRecentProjectsException;
	
	public abstract ArrayList<Branch> getAllBranches() throws GetAllBranchesException;
	
	public abstract String submitAcademicProjectToGyti(ProjectGytiAddInfo gytiAddInfo) throws SubmitAcademicProjectToGytiException;
	
	public abstract String submitProjectToGyti(SubmitInnovationToGytiVO innovationInfo) throws SubmitProjectToGytiException;

	public abstract String uploadMultipleProjectDocument(UploadMultipleProjDocVO uploadMultipleProjDocVO) throws UploadMultipleProjDocException;
	
	public abstract SubmitInnovationToGytiVO getgytiProjectDetails(long projId) throws GetProjectDetailsException;

	public abstract ArrayList<GytiProjectVO> getAllGytiProject(int interationCount) throws GetAllGytiProjectException;

	public abstract ArrayList<GytiProjectVO> getAllGytiProjectByLoggedInUser(String rgstrId) throws GetAllGytiProjectException;
	
	public abstract String updateGytiProject(SubmitInnovationToGytiVO innovationInfo) throws UpdateGytiInnovationException;
	
	public abstract ArrayList<GYTIProjectStatisticsVO> getGYTIProjectStatistics() throws GetGYTIProjectStatisticsException;
	
	public abstract String reviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException;
	
	public abstract GetAllGytiProjectByLoggedInReviewerResponse getAllGytiProjectByLoggedInReviewer(String revRgstrId,String awardYear) throws GetAllGytiProjectException;
	
	public abstract String suggestReviewer(ArrayList<SuggestReviewerVO> suggestReviewerVO) throws SuggestReviewerException;
	
	public abstract ReviewRatingVO getgytiProjectReviewDetails(GetReviewRatingVO getReviewRatingVO) throws GetGytiProjectRatingDetailsException;
	
	public abstract List<OverallCalculatedReviewRatingVO> getAllReviews(String awardYear) throws GetAllReviewsException;
	
	public abstract String updateGytiProjectReviewRating(ReviewRatingVO reviewRatingVO) throws updateGytiProjectReviewRatingException;
	
	public abstract ReviewRatingVO getRatingDetailsByReviwer( String ratingId) throws GetGytiProjectRatingDetailsException;

	public abstract GetAllReviewsByLoggedInReviewerAndOthersResponse getAllReviewsByLoggedInReviewerAndOthers(String revRgstrId, String awardYear) throws GetAllReviewsException;
	
	public abstract ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> getSuggestedReviewersByLoggedInReviewer(long assignedBy) throws GetSuggestedReviewersException;
	
	public abstract ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> getAllSuggestedReviewersList() throws GetSuggestedReviewersException;
	
	public abstract String rejectSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException;
	
	public abstract OverallCalculatedReviewRatingVO getAllReviewsForSpecificProject(long projId) throws GetAllReviewsException;

	public abstract long gytiInnovationCount() throws GytiInnovationCountException;
	
	public abstract long gytiYearWiseInnovationCount(int year) throws GytiInnovationCountException;
	
	public abstract long gytiYearWiseReviewedInnovationCount(int year) throws GytiReviewedInnovationCountException;
	
	public abstract List<TotalProjectsStatisticsVO> totalProjectsStatistics() throws TotalProectsStatisticsException;
	
	public abstract Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWiseStatistics() throws TotalProectsYearWiseStatisticsException;
	
	public abstract Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsInAYearStatistics(int year) throws TotalProectsYearWiseStatisticsException;
	
	public abstract AddNewTeamMemberResponseVO addNewTeamMember(AddNewTeamMemberVO addNewTeamMemberVO) throws AddNewTeamMemberException;

	public abstract RegisterNewFacultyResponseVO registerNewFaculty(RegisterNewFacultyVO registerNewFacultyVO) throws AddNewTeamMemberException;
	
	public abstract String saveReviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException;
	
	public abstract String acceptSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException;
}
