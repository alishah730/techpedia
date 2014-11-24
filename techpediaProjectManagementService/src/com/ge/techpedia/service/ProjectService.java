package com.ge.techpedia.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ge.techpedia.bean.AddCommVO;
import com.ge.techpedia.bean.DeleteCommVO;
import com.ge.techpedia.bean.DeleteDocVO;
import com.ge.techpedia.bean.DisplayTeamCommVO;
import com.ge.techpedia.bean.DownloadDocVO;
import com.ge.techpedia.bean.FacInitProjVO;
import com.ge.techpedia.bean.FacultyVO;
import com.ge.techpedia.bean.FollowProjectVO;
import com.ge.techpedia.bean.MentorVO;
import com.ge.techpedia.bean.ProjFollowVO;
import com.ge.techpedia.bean.ProjSubmit;
import com.ge.techpedia.bean.Project;
import com.ge.techpedia.bean.SearchByKeyVO;
import com.ge.techpedia.bean.TeamMember;
import com.ge.techpedia.bean.UploadProjDocVO;
import com.ge.techpedia.bean.UserProfileVO;
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
import com.ge.techpedia.service.helper.ProjectServiceHelper;
import com.techpedia.email.exception.EmailServiceException;

@Path("projectservice")
public class ProjectService {	
	
	/**
	 * @param project
	 * @return result flag
	 */
	@POST
	@Path("createproject")
	@Consumes({"application/json"})
	public Response createProject(Project project) throws CreateProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.createProject(project)).type("application/json").build();
	}

	/**
	 * @param branchIds
	 * @return list of suggested keyword
	 */
	@POST
	@Path("getsuggestedkeywords")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getSuggestedkeywords(ArrayList<String> branchIds) throws NumberFormatException, SuggestedkeywordsNotFoundException{			
		return Response.ok().status(200).entity(ProjectServiceHelper.getSuggestedkeywords(branchIds)).type("application/json").build();
	}
	
	/**
	 * @param userProfileVO
	 * @return list of suggested team
	 */
	@POST
	@Path("getsuggestedteammembers")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getSuggestedTeamMembers(userProfileVO)).type("application/json").build();		
	}
	
	/**
	 * @param term
	 * @return list of suggested branch
	 */
	@POST
	@Path("getsuggestedbranches")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getSuggestedBranches(String term) throws SuggestedBranchNotFoundException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.getSuggestedBranches(term)).type("application/json").build();
	}
	
	/**
	 * @param userId
	 * @return list of suggested faculty
	 */
	@POST
	@Path("getsuggestedfaculty")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.getSuggestedFaculty(userId)).type("application/json").build();
	}
	
	/**
	 * @param facultyVO
	 * @return result flag
	 */
	@POST
	@Path("addnewfaculty")
	@Consumes({"application/json"})
	public Response addNewFaculty(FacultyVO facultyVO) throws AddNewFacultyException{
		return Response.ok().status(200).entity(ProjectServiceHelper.addNewFaculty(facultyVO)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @return result flag
	 */
	@POST
	@Path("deleteproject")
	@Consumes("application/json")
	public Response deleteProject(long projId) throws DeleteProjectException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.deleteProject(projId)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @return Project
	 */
	@POST
	@Path("getprojectdetails")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getProjectDetails(long projId) throws GetProjectDetailsException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.getProjectDetails(projId)).type("application/json").build();		
	}
	
	/**
	 * @param iterationCount
	 * @return ArrayList<Project>
	 */
	@POST
	@Path("getallproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getAllProject(String iterationCount) throws GetAllProjectException{				
		return Response.ok().status(200).entity(ProjectServiceHelper.getAllProject(iterationCount)).type("application/json").build();
	}
	
	/**
	 * @param iterationCount
	 * @return
	 */
	@POST
	@Path("getallmentors")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getAllMentors(String iterationCount) throws GetAllMentorsException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getAllMentors(iterationCount)).type("application/json").build();
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getpopularity")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getPopularity(String rgstrId) throws GetPopularityException{				
		return Response.ok().status(200).entity(ProjectServiceHelper.getPopularity(rgstrId)).type("application/json").build();
	}
	
	/**
	 * @param project
	 * @return
	 */
	@POST
	@Path("updateproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response updateProject(Project project) throws UpdateProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.updateProject(project)).type("application/json").build();
	}
	
	/**
	 * @param teamMembers
	 * @return
	 */
	@POST
	@Path("addteammembers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response addTeamMembers(ArrayList<TeamMember> teamMembers) throws AddTeamMembersException{
		return Response.ok().status(200).entity(ProjectServiceHelper.addTeamMembers(teamMembers)).type("application/json").build();
	}
	
	/**
	 * @param teamMembers
	 * @return
	 */
	@POST
	@Path("removeteammembers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response removeTeamMembers(ArrayList<TeamMember> teamMembers) throws RemoveTeamMembersException{
		return Response.ok().status(200).entity(ProjectServiceHelper.removeTeamMembers(teamMembers)).type("application/json").build();
	}
	
	/**
	 * @param term
	 * @param iterationCount
	 * @return
	 */
	@POST
	@Path("searchprojectbykeyword")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response searchProjectByKeyword(SearchByKeyVO searchByKeyVO) throws SearchProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.searchProjectByKeyword(searchByKeyVO)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @param mentorRgstrId
	 * @return
	 */
	@POST
	@Path("addnewmentor")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response addNewMentor(MentorVO mentorVO) throws AddNewMentorException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.addNewMentor(mentorVO)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @param mentorRgstrId
	 * @return
	 */
	@POST
	@Path("deletementor")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response deleteMentor(MentorVO mentorVO) throws RemoveMentorException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.deleteMentor(mentorVO)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @param userRgstrNo
	 * @return
	 */
	@POST
	@Path("followtheproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response followTheProject(FollowProjectVO followProjectVO) throws FollowTheProjectException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.followTheProject(followProjectVO)).type("application/json").build();
	}
	
	/**
	 * @param projId
	 * @return
	 */
	@POST
	@Path("displayteamcomments")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response displayTeamComments(DisplayTeamCommVO displayTeamCommVO) throws TeamCommentsNotFoundException{
		return Response.ok().status(200).entity(ProjectServiceHelper.displayTeamComments(displayTeamCommVO)).type("application/json").build();
	}

	/**
	 * @param projId
	 * @param regstrId
	 * @param projComment
	 * @return
	 */
	@POST
	@Path("addcomment")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response addComment(AddCommVO addCommVO) throws AddCommentException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.addComment(addCommVO)).type("application/json").build();
	}

	/**
	 * @param projectId
	 * @param commentId
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("deletecomment")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response deleteComment(DeleteCommVO deleteCommVO) throws RemoveCommentException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.deleteComment(deleteCommVO)).type("application/json").build();
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */	
	@POST
	@Path("getallfollowedproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getAllFollowedProject(String rgstrId) throws GetAllFollowedProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getAllFollowedProject(rgstrId)).type("application/json").build();
	}
	
	/**
	 * @param teamId
	 * @return
	 */
	@POST
	@Path("getdetailofteam")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getDetailOfTeam(String teamId) throws GetDetailOfTeamException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getDetailOfTeam(teamId)).type("application/json").build();
	}
	
	/**
	 * @param projFollowVO
	 * @return
	 */
	@POST
	@Path("removeprojectfollow")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response removeProjectFollow(ProjFollowVO projFollowVO) throws RemoveProjectFollowException{
		return Response.ok().status(200).entity(ProjectServiceHelper.removeProjectFollow(projFollowVO)).type("application/json").build();
	}
	
	/**
	 * @param projFollowVO
	 * @return
	 */
	@POST
	@Path("checkprojectfollow")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response checkProjectFollow(ProjFollowVO projFollowVO) throws CheckProjectFollowException{
		return Response.ok().status(200).entity(ProjectServiceHelper.checkProjectFollow(projFollowVO)).type("application/json").build();
	}
	
	/**
	 * @param projSubmit
	 * @return
	 * @throws SubmitProjectsException
	 * @throws EmailServiceException
	 */
	@POST
	@Path("submitproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response submitProject(ProjSubmit projSubmit) throws SubmitProjectsException, EmailServiceException{		
		return Response.ok().status(200).entity(ProjectServiceHelper.submitProject(projSubmit)).type("application/json").build();
	}
	
	/**
	 * @param uploadProjDocVO
	 * @return
	 */
	@POST
	@Path("uploadprojectdocument")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response uploadProjectDocument(UploadProjDocVO uploadProjDocVO) throws UploadProjDocException{
		return Response.ok().status(200).entity(ProjectServiceHelper.uploadProjectDocument(uploadProjDocVO)).type("application/json").build();
	}
	
	/**
	 * @param downloadDocVO
	 * @return
	 */
	@POST
	@Path("downloadprojectdocument")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response downloadProjectDocument(DownloadDocVO downloadDocVO) throws DownloadProjDocException{
		return Response.ok().status(200).entity(ProjectServiceHelper.downloadProjectDocument(downloadDocVO)).type("application/json").build();
	}
	
	/**
	 * @param displayTeamCommVO
	 * @return
	 */
	@POST
	@Path("displayothercomments")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response displayOtherComments(DisplayTeamCommVO displayTeamCommVO) throws OtherCommentsNotFoundException{
		return Response.ok().status(200).entity(ProjectServiceHelper.displayOtherComments(displayTeamCommVO)).type("application/json").build();
	}
	
	/**
	 * @param rgstrId
	 * @return
	 */
	@POST
	@Path("getprojectsbyLoggedinuser")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getProjectsByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getProjectsByLoggedInUser(rgstrId)).type("application/json").build();
	}
	
	/**
	 * @param exlByteArray
	 * @return
	 */
	@POST
	@Path("bulkuploadproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response bulkUploadProject(String exlByteArray) throws BulkUploadException{
		return Response.ok().status(200).entity(ProjectServiceHelper.bulkUploadProject(exlByteArray)).type("application/json").build();
	}
	
	@POST
	@Path("getprojectfollowers")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response getProjectFollowers() throws GetProjectFollowersException{
		return Response.ok().status(200).entity(ProjectServiceHelper.getProjectFollowers()).type("application/json").build();
	}
	
	@POST
	@Path("deleteprojectdocument")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response deleteProjectDocument(DeleteDocVO deleteDocVO) throws DeleteDocumentException{
		return Response.ok().status(200).entity(ProjectServiceHelper.deleteProjectDocument(deleteDocVO)).type("application/json").build();
	}
	
	@POST
	@Path("facultyinitiatedproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response facultyInitiatedProject(FacInitProjVO facInitProjVO) throws FacultyInitiatedProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.facultyInitiatedProject(facInitProjVO)).type("application/json").build();
	}
	
	@POST
	@Path("facultyclosedproject")
	@Consumes("application/json")
	@Produces({"application/json"})
	public Response facultyClosedProject(FacInitProjVO facInitProjVO) throws FacultyClosedProjectException{
		return Response.ok().status(200).entity(ProjectServiceHelper.facultyClosedProject(facInitProjVO)).type("application/json").build();
	}		
	
}
