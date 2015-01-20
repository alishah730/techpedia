/**
 * 
 */
package com.techpedia.projectmanagement.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import sun.misc.BASE64Decoder;

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
import com.techpedia.projectmanagement.bean.ProjectXLSVO;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.TeamMember;
import com.techpedia.projectmanagement.bean.UploadProjDocVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.dao.ProjectDao;
import com.techpedia.projectmanagement.dao.helper.ProjectDaoHelper;
import com.techpedia.projectmanagement.entity.BranchMaster;
import com.techpedia.projectmanagement.entity.ChallengeTeamTxn;
import com.techpedia.projectmanagement.entity.ProjectBranchMaster;
import com.techpedia.projectmanagement.entity.ProjectCommentTxn;
import com.techpedia.projectmanagement.entity.ProjectDocPathTxn;
import com.techpedia.projectmanagement.entity.ProjectFollowTxn;
import com.techpedia.projectmanagement.entity.ProjectKeywordMaster;
import com.techpedia.projectmanagement.entity.ProjectMaster;
import com.techpedia.projectmanagement.entity.ProjectTeamMaster;
import com.techpedia.projectmanagement.entity.ProjectTeamTxn;
import com.techpedia.projectmanagement.entity.UsrMngtFaculty;
import com.techpedia.projectmanagement.entity.UsrMngtMaster;
import com.techpedia.projectmanagement.entity.UsrMngtMentor;
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
import com.techpedia.projectmanagement.util.BulkUploadCVS;
import com.techpedia.projectmanagement.util.FileUploadDownload;
import com.techpedia.util.HibernateUtil;

/**
 * @author nishikant.singh
 *
 */
public class ProjectDaoImpl implements ProjectDao {

	//private static TechPediaLogger log = TechPediaLogger.getLogger(ProjectDaoImpl.class.getName());
	
	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectManagementDAO#createProject(com.techpedia.projectmanagement.dataobject.ProjectDO)
	 */
	@Override
	public String createProject(Project project) throws CreateProjectException{
		
		//log.debug("ProjectDaoImpl.createProject :Start");
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String returnVal = "N";
		int tranCount = 0;
	
		/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_DETAIL`*/
		long projId = 0;
		int projTypeId = project.getProjTypeId();
		String projectTitle = project.getProjTitle();
		String projectAbstract = project.getProjAbstract();
		String projectDescription = project.getProjDescription();
		String projectUniversity = project.getProjUniversity();
		String projCollegeRgstrIdUsr = project.getProjCollegeRgstrIdUsr();
		String userRgstrNo = project.getUserRgstrNo();
		int projectYear = project.getProjYear();
		int projectDuration = project.getProjDuration();
		String projectCollegeState = project.getProjCollegeState();
		Date projectStartDate = ProjectDaoHelper.getMillisecondsToDate(project.getProjStartDate());
		Date projectEndDate = ProjectDaoHelper.getMillisecondsToDate(project.getProjEndDate());
		long projMentor1Id = project.getProjMentor1Id();
		long projMentor2Id = project.getProjMentor2Id();
		long projectTeamId = project.getProjTeamId();
		long projGuideId = project.getProjGuideId();
		int projStatusId = project.getProjStatusId();
		String projToFloat = project.getProjToFloat();
		long projectEstimationCost = project.getProjEstimationCost();
		String projCommentsPublish = project.getProjCommentsPublish();
		String projGrade = project.getProjGrade();
		long projTeamLeaderId = project.getProjTeamLeaderId();
		String projAwardWon = project.getProjAwardWon();
		String projAwardDesc= project.getProjAwardDesc();
		String projIsMentorAvail = project.getProjIsMentorAvail();
		String projIsFacApprove = project.getProjIsFacApprove();
		String projAdminComments = project.getProjAdminComments();
		long projectFaculty = project.getProjFaculty();
		/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_TEAM`*/
		String projTeamDesc = project.getProjTeamDesc();
		/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_BRNCH`*/
		ArrayList<Integer> projectBranches = project.getProjBranches();
		/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_KEYWRD`*/
		ArrayList<String> projectKeywords = project.getProjKeywords();
		/*Parameters for Table: `TB_TECH001_TXN_PROJECTS_TEAM`*/
		ArrayList<Long> projectTeamMembers = project.getProjTeamMembers();
		
		/*String projectCollege = project.getProjCollege();
		String projectStudentId = project.getProjStudentId();
		
		
		byte[] projectImage = project.getProjImage();*/
		
		ProjectMaster projectMaster = null;
		
		try {
			
			tx = session.beginTransaction();
			
			/*Start Adding into TB_TECH001_MAST_PROJECTS_TEAM here*/
			ProjectTeamMaster projectTeamMaster = new ProjectTeamMaster(projTeamDesc);
			Serializable sr = session.save(projectTeamMaster);
			projectTeamId = Long.parseLong(sr.toString());
			//log.debug("ProjectTeamMaster added is :" + projectTeamId);
			
			/*Start Adding into TB_TECH001_MAST_PROJECTS_DETAIL here*/
			projectMaster = new ProjectMaster(projTypeId, projectTitle, projectAbstract, projectDescription, projectUniversity, 
					projCollegeRgstrIdUsr, userRgstrNo, projectYear, projectDuration, projectCollegeState, projectStartDate, 
					projectEndDate, projMentor1Id, projMentor2Id, projectTeamId, projGuideId, projStatusId, projToFloat, 
					projectEstimationCost, projCommentsPublish, projGrade, projTeamLeaderId, projAwardWon, projAwardDesc, 
					projIsMentorAvail, projIsFacApprove, projAdminComments,"N", "ACTIVE", projectFaculty);
			
			sr = session.save(projectMaster);
			projId = Long.parseLong(sr.toString());
			projectMaster.setProjId(projId);
			//log.debug("ProjectMaster added is :" + projId);
			
			
			/*Start Adding into TB_TECH001_MAST_PROJECTS_KEYWRD here*/
			ProjectKeywordMaster projectKeywordMaster;
			tranCount = 0;
			for(String projKeyword:projectKeywords){
				projectKeywordMaster = new ProjectKeywordMaster();
				projectKeywordMaster.setProjId(projId);
				projectKeywordMaster.setProjKeyword(projKeyword);
				session.saveOrUpdate(projectKeywordMaster);;
				if ( tranCount % 20 == 0 ) { 
			        session.flush();
			        session.clear();
			    }
				tranCount++;
			}
			
			/*Start Adding into TB_TECH001_MAST_PROJECTS_BRNCH here*/
			ProjectBranchMaster projectBranchMaster;
			tranCount = 0;
			for(int projBranch:projectBranches){
				projectBranchMaster = new ProjectBranchMaster();
				projectBranchMaster.setProjId(projId);
				projectBranchMaster.setProjBranchId(projBranch);
				session.saveOrUpdate(projectBranchMaster);
				if ( tranCount % 20 == 0 ) { 
			        session.flush();
			        session.clear();
			    }
				tranCount++;
			}
			
			/*Start Adding into TB_TECH001_TXN_PROJECTS_TEAM here*/
			ProjectTeamTxn projectTeamTxn;
			tranCount = 0;
			for(Long projTeamMemId:projectTeamMembers){
				projectTeamTxn = new ProjectTeamTxn();
				projectTeamTxn.setRegstrId(projTeamMemId);
				projectTeamTxn.setProjId(projId);
				projectTeamTxn.setTeamId(projectTeamId);
				session.saveOrUpdate(projectTeamTxn);
				if ( tranCount % 20 == 0 ) { 
			        session.flush();
			        session.clear();
			    }
				tranCount++;
			}
			tx.commit();
			returnVal = "Y";
		} catch (Exception e) {
			//log.debug("Unable to add project to DB : " + e);
			try {
				tx.rollback();
				session.createSQLQuery("delete from tb_tech001_mast_projects_detail where PROJ_ID = :projId").setParameter("projId", projId).executeUpdate();
			} catch (Exception e1) {
				//log.debug("Couldn’t roll back transaction : " + e1);
				throw new CreateProjectException("Error while doing rollback to the failed transection : "+ e1.getMessage());
			}
			throw new CreateProjectException("Error while creating new project : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.createProject :End");
		return returnVal;
	}
	
	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getSuggestedkeywords(java.util.ArrayList)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<String> getSuggestedkeywords(ArrayList<Integer> branchIds) throws SuggestedkeywordsNotFoundException{
		
		//log.debug("ProjectDaoImpl.getSuggestedkeywords :Start");
		ArrayList<String> suggestedkeywords = new ArrayList<String>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			
			DetachedCriteria dc = DetachedCriteria.forClass(ProjectBranchMaster.class);
			dc.add(Restrictions.in("projBranchId", branchIds));
			dc.setProjection(Projections.property("projId"));
			Criteria criteria = session.createCriteria(ProjectKeywordMaster.class);
			criteria.add(Subqueries.propertyIn("projId", dc));
			criteria.setProjection(Projections.property("projKeyword"));
			suggestedkeywords = (ArrayList<String>) criteria.list();
			
		} catch (Exception e) {
			//log.error("Error while retrieving the Suggested keywords :" + e.getMessage());
			throw new SuggestedkeywordsNotFoundException("Error while retriving the Suggested keywords : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.getSuggestedkeywords :End");
		return suggestedkeywords;
		
	}
	
	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getSuggestedTeamMembers(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Team> getSuggestedTeamMembers(UserProfileVO userProfileVO)
			throws SuggestedTeamMembersNotFoundException {
		//log.debug("ProjectDaoImpl.getSuggestedTeamMembers :Start");
		return  ProjectDaoHelper.getSuggestedTeamMembers(userProfileVO);
		//log.debug("ProjectDaoImpl.getSuggestedTeamMembers :End");
	}

	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getSuggestedBranches(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Branch> getSuggestedBranches(String term)
			throws SuggestedBranchNotFoundException {
		//log.debug("ProjectDaoImpl.getSuggestedBranches :Start");
		ArrayList<Branch> suggestedBranchs = new ArrayList<Branch>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria criteria = session.createCriteria(BranchMaster.class);
			criteria.add(Restrictions.ilike("projBranchDesc", "%"+term+"%"));
			suggestedBranchs = (ArrayList<Branch>) criteria.list();
		} catch (Exception e) {
			//log.error("Error while retrieving the Suggested keywords :" + e.getMessage());
			throw new SuggestedBranchNotFoundException("Error while retriving the Suggested Branchs : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.getSuggestedBranches :End");
		return suggestedBranchs;
	}

	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getSuggestedFaculty(java.lang.String)
	 */
	@Override
	public ArrayList<Faculty> getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException{
		//log.debug("ProjectDaoImpl.getSuggestedFaculty :Start");
		return ProjectDaoHelper.getSuggestedFaculty(userId);
		//log.debug("ProjectDaoImpl.getSuggestedFaculty :End");
	}

	/* 
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#addNewFaculty(com.techpedia.projectmanagement.bean.FacultyVO)
	 */
	@Override
	public String addNewFaculty(FacultyVO facultyVO)
			throws AddNewFacultyException {
		
		//log.debug("ProjectDaoImpl.addNewFaculty :Start");
		
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		UsrMngtMaster usrMngtMaster = null;
		UsrMngtFaculty usrMngtFaculty = null;
		String fName = facultyVO.getFirstName();
		String mName = facultyVO.getMiddleName();
		String lName = facultyVO.getLastName();
		String eMail = facultyVO.getEmail();
		String college = facultyVO.getCollege();
		String dept = facultyVO.getDepartment();
		long branchId = facultyVO.getBranchId();
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

		long regId = 0;
		String returnVal = "N";
		
		try {
			
			tx = session.beginTransaction();
			/*Start Adding into USR_MNGT_MASTER here*/
			usrMngtMaster = new UsrMngtMaster();
			usrMngtMaster.setpFname(fName);
			usrMngtMaster.setmName(mName);
			usrMngtMaster.setlName(lName);
			usrMngtMaster.setEmail(eMail);
			usrMngtMaster.setUserId(eMail+day+month+year+hour+minute+second);
			usrMngtMaster.setType("faculty");
			
			Serializable sr = session.save(usrMngtMaster);
			regId = (long) sr;
			//log.debug("UsrMngtMaster added is :" + regId);
			
			/*Start Adding into USR_MNGT_STUDENT here*/
			usrMngtFaculty = new UsrMngtFaculty();
			usrMngtFaculty.setRgstrId(regId);
			usrMngtFaculty.setCollege(college);
			usrMngtFaculty.setSpecification(dept);
			usrMngtFaculty.setBranchId(branchId);
			
			sr = session.save(usrMngtFaculty);
			//log.debug("UsrMngtStudent added is :" + sr.toString());
			
			tx.commit();
			returnVal = sr.toString();
		} catch (Exception e) {
			//log.debug("Unable to add Faculty to DB : " + e);
			try {
				tx.rollback();
				session.createSQLQuery("delete from usr_mngt_master where RGSTR_ID = :rgstrId").setParameter("rgstrId", regId).executeUpdate();
			} catch (Exception e1) {
				//log.debug("Couldn’t roll back transaction : " + e1);
				throw new AddNewFacultyException("Error while doing rollback to the failed transection : "+ e1.getMessage());
			}
			throw new AddNewFacultyException("Error while creating new faculty : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.addNewFaculty :End");
		return returnVal;
	}
	
	/**
	 * @param type
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean deleteById(Class<?> type, Serializable id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Object persistentInstance = session.load(type, id); 
	    if (persistentInstance != null) { 
	        session.delete(persistentInstance); 
	        return true; 
	    } 
	    return false; 
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#deleteProject(long)
	 */
	@Override
	public String deleteProject(long projId) throws DeleteProjectException {
		
		//log.debug("ProjectDaoImpl.deleteProject :Start");
		String returnVal = "N";
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			tx = session.beginTransaction();
			ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);
			projectMaster.setProjId(projId);
			projectMaster.setProjStatus("INACTIVE");
			session.update(projectMaster);
			tx.commit();
			returnVal = "Y";
		} catch (Exception e) {
			//log.debug("Error while deleting project : "+ e.getMessage());
			throw new DeleteProjectException("Error while deleting project : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.deleteProject :End");
		return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getProjectDetails(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Project getProjectDetails(long projId) throws GetProjectDetailsException {
		
		//log.debug("ProjectDaoImpl.getProjectDetails :Start");
		
		Project project = new Project();
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);
			project.setProjTitle(projectMaster.getProjTitle());
			
			DetachedCriteria dc = DetachedCriteria.forClass(ProjectBranchMaster.class);
			dc.add(Restrictions.eq("projId", projId));
			dc.setProjection(Projections.property("projBranchId"));
			Criteria branchMasterCriteria = session.createCriteria(BranchMaster.class);
			branchMasterCriteria.add(Subqueries.propertyIn("branchId", dc));
			project.setProjBranchList((ArrayList<Branch>) branchMasterCriteria.list());
			
			Criteria projKeywordsCriteria = session.createCriteria(ProjectKeywordMaster.class);
			projKeywordsCriteria.add(Restrictions.eq("projId", projId));
			projKeywordsCriteria.setProjection(Projections.property("projKeyword"));
			ArrayList<String> projKeywords = (ArrayList<String>) projKeywordsCriteria.list();
			project.setProjKeywords(projKeywords);
			
			DetachedCriteria dcProjTeamTxn = DetachedCriteria.forClass(ProjectTeamTxn.class);
			dcProjTeamTxn.add(Restrictions.eq("projId", projId));
			dcProjTeamTxn.setProjection(Projections.property("regstrId"));
			Criteria usrMngtMasterCriteria = session.createCriteria(UsrMngtMaster.class);
			usrMngtMasterCriteria.add(Subqueries.propertyIn("rgstrId", dcProjTeamTxn));
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.property("rgstrId"));
			projList.add(Projections.property("pFname"));
			projList.add(Projections.property("mName"));
			projList.add(Projections.property("lName"));
			usrMngtMasterCriteria.setProjection(projList);
			project.setProjTeamMemberList((ArrayList<Team>) usrMngtMasterCriteria.list());
			
			Criteria proFacultyCriteria = session.createCriteria(UsrMngtMaster.class);
			proFacultyCriteria.add(Restrictions.eq("rgstrId", projectMaster.getProjFacRgstrId()));
			if(usrMngtMasterCriteria.list().size() > 0){
				ArrayList<UsrMngtMaster> usrMngtMasters = (ArrayList<UsrMngtMaster>) proFacultyCriteria.list();
				project.setProjFacultyName(usrMngtMasters.get(0).getpFname()+" "+usrMngtMasters.get(0).getmName()+" "+usrMngtMasters.get(0).getlName());
			}
			
			project.setProjTeamLeaderId(projectMaster.getProjTeamLeaderId());
			project.setProjMentor1Id(projectMaster.getProjMentor1Id());
			project.setProjMentor2Id(projectMaster.getProjMentor2Id());
			project.setProjYear(projectMaster.getProjYear());
			project.setProjDuration(projectMaster.getProjDuration());
			project.setProjStartDate(ProjectDaoHelper.getDateToMilliseconds(projectMaster.getProjStartDate()));
			project.setProjEndDate(ProjectDaoHelper.getDateToMilliseconds(projectMaster.getProjEndDate()));
			project.setProjTeamId(projectMaster.getTeamId());
			project.setProjAbstract(projectMaster.getProjAbstract());
			project.setProjDescription(projectMaster.getProjDescription());
			project.setProjFaculty(projectMaster.getProjFacRgstrId());
			project.setUserRgstrNo(projectMaster.getUserRgstrNo());
			project.setProjEstimationCost(projectMaster.getProjEstimatedCost());
			//project.setProjImage(projectMaster.getProjImage);
			
			Criteria proChallCriteria = session.createCriteria(ChallengeTeamTxn.class);
			proChallCriteria.add(Restrictions.eq("projId", projectMaster.getProjId()));
			proChallCriteria.setProjection(Projections.property("challengId"));
			ArrayList<Long> challengeId = (ArrayList<Long>) proChallCriteria.list();
			if(challengeId.size()>0)
				project.setChallengId(challengeId.get(0));
			
		} catch (Exception e) {
			//log.debug("Error while deleting project : "+ e.getMessage());
			throw new GetProjectDetailsException("Error while getting project : "+ e.getMessage());
			
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.getProjectDetails :End");
		return project;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getAllProject(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> getAllProject(String iterationCount)
			throws GetAllProjectException {
		//log.debug("ProjectDaoImpl.getAllProject :Start");
		Project project = null;
		ArrayList<Project> projects = new ArrayList<Project>();
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*8)-8;
		int maxResultSize = 8;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria =session.createCriteria(ProjectMaster.class);
			criteria.add(Restrictions.eq("projStatus", "ACTIVE"));
			criteria.addOrder(Order.asc("projId"));
			criteria.setFirstResult(minIndex);
			criteria.setMaxResults(maxResultSize);
			ArrayList<ProjectMaster> projectMasters = (ArrayList<ProjectMaster>) criteria.list();
			for(ProjectMaster projectMaster:projectMasters){
				project = new Project();
				project.setProjId(projectMaster.getProjId());
				project.setProjTitle(projectMaster.getProjTitle());
				project.setProjDescription(projectMaster.getProjDescription());
				projects.add(project);
			}
			if(projects.size()==0)
				throw new GetAllProjectException("No projects available for this criteria");
		} catch (Exception e) {
			//log.debug("Error while deleting project : "+ e.getMessage());
			throw new GetAllProjectException("Error while getting all project : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.getAllProject :End");
		return projects;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getAllMentors(java.lang.String)
	 */
	@Override
	public ArrayList<UserProfileVO> getAllMentors(String iterationCount) throws GetAllMentorsException{
		return ProjectDaoHelper.getAllMentors(iterationCount);
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getPopularity(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getPopularity(String rgstrId) throws GetPopularityException {
		
		//log.debug("ProjectDaoImpl.getPopularity :Start");
		
		ArrayList<Integer> popularity = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria criteria = session.createCriteria(UsrMngtMentor.class);
			criteria.add(Restrictions.eq("rgstrId", Long.valueOf(rgstrId)));
			criteria.setProjection(Projections.property("popularity"));
			popularity = (ArrayList<Integer>) criteria.list();
			
		} catch (Exception e) {
			//log.error("Error while retrieving the Popularity :" + e.getMessage());
			throw new GetPopularityException("Error while retriving the Popularity : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.getPopularity :End");
		if(popularity.size() > 0 && popularity.get(0)!=null){
		return popularity.get(0).toString();
		}else{
			return "N";
		}
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#updateProject(com.techpedia.projectmanagement.bean.Project)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String updateProject(Project project) throws UpdateProjectException {
		
				//log.debug("ProjectDaoImpl.updateProject :Start");
				Transaction tx = null;
				Session session = HibernateUtil.getSessionFactory().openSession();
				String returnVal = "N";
				int tranCount = 0;
				/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_DETAIL`*/
				long projId = project.getProjId();
				String projectTitle = project.getProjTitle();
				String projectAbstract = project.getProjAbstract();
				String projectDescription = project.getProjDescription();
				int projectYear = project.getProjYear();
				int projectDuration = project.getProjDuration();
				Date projectEndDate = ProjectDaoHelper.getMillisecondsToDate(project.getProjEndDate());
				long projectEstimationCost = project.getProjEstimationCost();
				long projectFaculty = project.getProjFaculty();
				/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_TEAM`*/
				long projTeamId = project.getProjTeamId();
				String projTeamDesc = project.getProjTeamDesc();
				/*Parameters for Table: `TB_TECH001_MAST_PROJECTS_KEYWRD`*/
				ArrayList<String> projectKeywords = project.getProjKeywords();
			
				try {
					tx = session.beginTransaction();
					
					/*Start updating TB_TECH001_MAST_PROJECTS_TEAM here*/
					ProjectTeamMaster projectTeamMaster = (ProjectTeamMaster) session.get(ProjectTeamMaster.class, projTeamId);
					projectTeamMaster.setProjTeamDesc(projTeamDesc);
					
					/*Start updating TB_TECH001_MAST_PROJECTS_DETAIL here*/
					ProjectMaster projectMaster = (ProjectMaster)session.get(ProjectMaster.class, projId);
					projectMaster.setProjTitle(projectTitle);
					projectMaster.setProjYear(projectYear);
					projectMaster.setProjDuration(projectDuration);
					projectMaster.setProjEndDate(projectEndDate);
					projectMaster.setProjAbstract(projectAbstract);
					projectMaster.setProjDescription(projectDescription);
					projectMaster.setProjFacRgstrId(projectFaculty);
					projectMaster.setProjEstimatedCost(projectEstimationCost);
					
					/*Start Deleting TB_TECH001_MAST_PROJECTS_KEYWRD here*/
					Criteria criteriaKeyword = session.createCriteria(ProjectKeywordMaster.class);
					criteriaKeyword.add(Restrictions.eq("projId", projId));
					ArrayList<ProjectKeywordMaster> keywordMasters = (ArrayList<ProjectKeywordMaster>) criteriaKeyword.list();
					for(ProjectKeywordMaster pkm:keywordMasters){
						session.delete(pkm);
					}
					
					/*Start Adding into TB_TECH001_MAST_PROJECTS_KEYWRD here*/
					ProjectKeywordMaster projectKeywordMaster;
					tranCount = 0;
					for(String projKeyword:projectKeywords){
						projectKeywordMaster = new ProjectKeywordMaster();
						projectKeywordMaster.setProjId(projId);
						projectKeywordMaster.setProjKeyword(projKeyword);
						session.save(projectKeywordMaster);
						if ( tranCount % 20 == 0 ) { 
					        session.flush();
					        session.clear();
					    }
						tranCount++;
					}
					tx.commit();
					returnVal = "Y";
				}catch (Exception e) {
						//log.debug("Unable to update project to DB : " + e);
						throw new UpdateProjectException("Error while updating project : "+ e.getMessage());
					}finally{
						if(tx!=null)
							tx=null;
						if(session!=null)
							session.close();
					}
					//log.debug("ProjectDaoImpl.updateProject :End");
			return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#addTeamMembers(java.util.ArrayList)
	 */
	@Override
	public String addTeamMembers(ArrayList<TeamMember> teamMembers)
			throws AddTeamMembersException {
		//log.debug("ProjectDaoImpl.addTeamMembers :Start");
		String returnVal = "N";
		int tranCount = 0;
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
					tx = session.beginTransaction();
					ProjectTeamTxn projectTeamTxn;
					tranCount = 0;
					ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, teamMembers.get(0).getProjId());
					long teamId = projectMaster.getTeamId();
					for(TeamMember teamMember:teamMembers){
						projectTeamTxn = new ProjectTeamTxn();
						projectTeamTxn.setRegstrId(teamMember.getRegstrId());
						projectTeamTxn.setProjId(teamMember.getProjId());
						projectTeamTxn.setTeamId(teamId);
						session.saveOrUpdate(projectTeamTxn);
						if ( tranCount % 20 == 0 ) { 
					        session.flush();
					        session.clear();
					    }
						tranCount++;
					}
					tx.commit();
					returnVal = "Y";
			}catch(Exception e){
				throw new AddTeamMembersException("Error while adding new team member : "+ e.getMessage());
			}finally{
				if(tx!=null)
					tx=null;
				if(session!=null)
					session.close();
			}
		//log.debug("ProjectDaoImpl.addTeamMembers :End");
		return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#removeTeamMembers(java.util.ArrayList)
	 */
	@Override
	public String removeTeamMembers(ArrayList<TeamMember> teamMembers)
			throws RemoveTeamMembersException {
		//log.debug("ProjectDaoImpl.removeTeamMembers :Start");
		String returnVal = "N";
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
					tx = session.beginTransaction();
					ProjectTeamTxn projectTeamTxn;
					ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, teamMembers.get(0).getProjId());
					long teamId = projectMaster.getTeamId();
					for(TeamMember teamMember:teamMembers){
						projectTeamTxn = new ProjectTeamTxn();
						projectTeamTxn.setProjId(teamMember.getProjId());
						projectTeamTxn.setRegstrId(teamMember.getRegstrId());
						projectTeamTxn.setTeamId(teamId);
						session.delete(projectTeamTxn);
					}
					tx.commit();
					returnVal = "Y";
			}catch(Exception e){
				throw new RemoveTeamMembersException("Error while removing team members : "+ e.getMessage());
			}finally{
				if(tx!=null)
					tx=null;
				if(session!=null)
					session.close();
			}
		//log.debug("ProjectDaoImpl.removeTeamMembers :End");
		return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#searchProjectByKeyword(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> searchProjectByKeyword(SearchByKeyVO searchByKeyVO)
			throws SearchProjectException {
		//log.debug("ProjectDaoImpl.searchProject :Start");
				ArrayList<Project> projects = new ArrayList<Project>();
				Project project;
				String term = searchByKeyVO.getTerm();
				String iterationCount = searchByKeyVO.getIterationCount();
				Session session = HibernateUtil.getSessionFactory().openSession();
				int initCount = Integer.valueOf(iterationCount);
				int minIndex = (initCount*8)-8;
				int maxResultSize = 8;
				String[] termArray = term.split("[, ]");
				
				try {
					DetachedCriteria dc = DetachedCriteria.forClass(ProjectKeywordMaster.class);
					Disjunction disjunction = Restrictions.disjunction();
					for(int i=0;i<termArray.length;i++){
						disjunction.add(Restrictions.ilike("projKeyword", "%"+termArray[i].trim()+"%", MatchMode.ANYWHERE));
					}
					dc.add(disjunction);
					dc.setProjection(Projections.property("projId"));
					Criteria criteria = session.createCriteria(ProjectMaster.class);
					criteria.add(Subqueries.propertyIn("projId", dc));
					criteria.add(Restrictions.eq("projStatus", "ACTIVE"));
					criteria.addOrder(Order.asc("projId"));
					criteria.setFirstResult(minIndex);
					criteria.setMaxResults(maxResultSize);
					ArrayList<ProjectMaster> projectMasters = (ArrayList<ProjectMaster>) criteria.list();
					for(ProjectMaster projectMaster:projectMasters){
						project = new Project();
						project.setProjId(projectMaster.getProjId());
						project.setProjTitle(projectMaster.getProjTitle());
						project.setProjDescription(projectMaster.getProjDescription());
						projects.add(project);
					}
				} catch (Exception e) {
					//log.error("Error while searching the project :" + e.getMessage());
					throw new SearchProjectException("Error while searching the project : "+ e.getMessage());
				}finally{
					if(session!=null)
						session.close();
				}
				//log.debug("ProjectDaoImpl.searchProject :End");
		return projects;
	}
	
	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#addNewMentor(long, long)
	 */
	@Override
	public String addNewMentor(MentorVO mentorVO)
				throws AddNewMentorException {	
		
		String returnVal = "N";
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		long projId = mentorVO.getProjId();
		long mentorRgstrId = mentorVO.getMentorRgstrId();
		try {
	        tx = session.beginTransaction();
	        if(projId != 0 && mentorRgstrId != 0){ 
	        	ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);		  	        	
				
				if (projectMaster.getProjMentor1Id() == 0){						
					projectMaster.setProjMentor1Id(mentorRgstrId);		
					returnVal = "Y";
				}
				else if(projectMaster.getProjMentor2Id() == 0){						
					projectMaster.setProjMentor2Id(mentorRgstrId);	
					returnVal = "Y";
				}					
				else 					  
					returnVal = "N";
	        			  		
				session.update(projectMaster);
				tx.commit();				
	        }
	     }
	      catch (Exception e) {
			//log.debug("2 mentors already exist : " + e);
			throw new AddNewMentorException("Both mentors already exist : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
	
		//log.debug("ProjectDaoImpl.addNewMentor :End");
		return returnVal;
	
	}
	
	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#deleteMentor(long, long)
	 */
	@Override
	public String deleteMentor(MentorVO mentorVO)
				throws RemoveMentorException {	
		
	    String returnVal = "N";
		Transaction tx = null;
		long projId = mentorVO.getProjId();
		long mentorRgstrId = mentorVO.getMentorRgstrId();
		Session session = HibernateUtil.getSessionFactory().openSession();	    
		try {	    	 	      
	      tx = session.beginTransaction();
	      if(projId != 0 || mentorRgstrId != 0){
		  
	    	  ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);			
	    	  long projMentor1Id = projectMaster.getProjMentor1Id();
	    	  long projMentor2Id = projectMaster.getProjMentor2Id();						
		 
	    	  if (projMentor1Id == mentorRgstrId){										  
	    		  projectMaster.setProjMentor1Id(0);
	    	  }
	    	  else if(projMentor2Id == mentorRgstrId){						
						projectMaster.setProjMentor2Id(0);
	    	  }					
			else 
				return returnVal; 	
	    	  
	    	session.update(projectMaster);						
			tx.commit();
			returnVal = "Y";
		}		
		} catch (Exception e) {
			//log.debug("Mentors does NOT exist : " + e);
			throw new RemoveMentorException("Mentors does NOT exist : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.deleteMentor :End");
		return returnVal;
	}
	
	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#followTheProject(long, long)
	 */
	@Override
	public String followTheProject(FollowProjectVO followProjectVO)
				throws FollowTheProjectException {	
		 
		String returnVal = "N";
		Transaction tx = null;
		long projId = followProjectVO.getProjId();
		long userRgstrNo= followProjectVO.getUserRgstrNo();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		try {
			    tx = session.beginTransaction();
			    ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);		  			
				ProjectFollowTxn projectFollowTxn = new ProjectFollowTxn();				
		      
				if(projectMaster.getProjId() != 0){		    	 
					projectFollowTxn.setProjId(projId);	
					projectFollowTxn.setRegstrId(userRgstrNo);
		        }
				else 
		    	  return returnVal;
				
		    session.saveOrUpdate(projectFollowTxn);	
			tx.commit();
			returnVal = "Y";
		}catch (Exception e) {
			//log.debug("Error while Following the Project :" + e);
			throw new FollowTheProjectException("Error while Following the Project : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		    }
		//log.debug("ProjectDaoImpl.followTheProject :End");
		return returnVal;
	} 
	
	
	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#displayTeamComments(long)
	 */
	@Override
	public ArrayList<ProjectTeamComment> displayTeamComments(DisplayTeamCommVO displayTeamCommVO) throws TeamCommentsNotFoundException{
		//log.debug("ProjectDaoImpl.displayTeamComments :Start");
		return ProjectDaoHelper.displayTeamComments(displayTeamCommVO.getProjId(), displayTeamCommVO.getIterationCount());
		//log.debug("ProjectDaoImpl.displayTeamComments :End");
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#addComment(long, long, java.lang.String)
	 */
	@Override
	public String addComment(AddCommVO addCommVO) throws AddCommentException {
		
		//log.debug("ProjectDaoImpl.addComment :Start");
		
				Transaction tx = null;
				String returnVal = "N";
				long projId = addCommVO.getProjId();
				long regstrId = addCommVO.getRegstrId();
				String projComment = addCommVO.getProjComment();
				Session session = HibernateUtil.getSessionFactory().openSession();
				ProjectCommentTxn projectCommentTxn = null;				
				Calendar now = Calendar.getInstance(); 
			    Date projCmntRecDate = now.getTime(); 			    
				try {					
					tx = session.beginTransaction();
					
					/*Start Adding into tb_tech001_txn_project_comment here*/
					projectCommentTxn = new ProjectCommentTxn();
					projectCommentTxn.setProjId(projId);			
					projectCommentTxn.setProjComment(projComment);
					projectCommentTxn.setRegstrId(regstrId);		
					projectCommentTxn.setIsActiveCommt("Y"); 							
				    projectCommentTxn.setProjCommentsRecDate(projCmntRecDate);		             
				    session.saveOrUpdate(projectCommentTxn);
					//log.debug("ProjectCommentTxn added is :" + sr.toString());		
					tx.commit();
					returnVal = "Y";
				} catch (Exception e) {
					//log.debug("Unable to add Comments to DB : " + e);		
					throw new AddCommentException("Error while creating Project Comment : "+ e.getMessage());
				}finally{
					if(tx!=null)
						tx=null;
					if(session!=null)
						session.close();
				}
				//log.debug("ProjectDaoImpl.addNewFaculty :End");
				return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#deleteComment(long, long, long)
	 */
	@Override
	public String deleteComment(DeleteCommVO deleteCommVO)
			throws RemoveCommentException {
		String returnVal = "N";	
		Transaction tx = null;
		long projectId = deleteCommVO.getProjectId();
		long commentId = deleteCommVO.getCommentId();
		long rgstrId = deleteCommVO.getRgstrId();		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {	    	 
	      tx = session.beginTransaction();
	      ProjectCommentTxn projectCommentTxn = (ProjectCommentTxn) session.get(ProjectCommentTxn.class, commentId);			
		  
		  if(commentId != 0 && projectCommentTxn.getProjId() == projectId && projectCommentTxn.getRegstrId() == rgstrId)							  
			  projectCommentTxn.setIsActiveCommt("N");				  
		  else 
			  return returnVal; 					
				
			session.update(projectCommentTxn);						
			tx.commit();
			returnVal = "Y";
		} catch (Exception e) {
			//log.debug("Comments does NOT exist : " + e);
			throw new RemoveCommentException("Comments does NOT exist : "+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.deleteComment :End");
		return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#getAllFollowedProject(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> getAllFollowedProject(String rgstrId)
			throws GetAllFollowedProjectException {
		//log.debug("ProjectDaoImpl.getAllFollowedProject :Start");
				ArrayList<Project> projects = new ArrayList<Project>();
				ArrayList<ProjectMaster> projectMasters = new ArrayList<ProjectMaster>();
				Project project;
				Session session = HibernateUtil.getSessionFactory().openSession();
				
				try {					
					DetachedCriteria dc = DetachedCriteria.forClass(ProjectFollowTxn.class);
					dc.add(Restrictions.eq("regstrId", Long.valueOf(rgstrId)));
					dc.setProjection(Projections.property("projId"));
					Criteria criteria = session.createCriteria(ProjectMaster.class);
					criteria.addOrder(Order.asc("projId"));
					criteria.add(Subqueries.propertyIn("projId", dc));			
					projectMasters = (ArrayList<ProjectMaster>) criteria.list();
					for(ProjectMaster projectMaster:projectMasters){
						project = new Project();
						project.setProjId(projectMaster.getProjId());
						project.setProjTitle(projectMaster.getProjTitle());
						project.setProjDescription(projectMaster.getProjDescription());
						projects.add(project);
					}
					if(projects.size()==0)
						throw new GetAllFollowedProjectException("No projects are followed by this user");
					
				} catch (Exception e) {
					//log.error("Error while retriving the all followed projects : " + e.getMessage());
					throw new GetAllFollowedProjectException("Error while retriving the all followed projects : "+ e.getMessage());
				}finally{
					if(session!=null)
						session.close();
				}
				//log.debug("ProjectDaoImpl.getAllFollowedProject :End");
		return projects;
	}

	/* (non-Javadoc)
	 * @see com.techpedia.projectmanagement.dao.ProjectDao#uploadProject(java.util.ArrayList)
	 */
	@SuppressWarnings("unchecked")
	private String uploadProjects(ArrayList<ProjectXLSVO> projectXLSVOs)
			throws BulkUploadException {
		//log.debug("ProjectDaoImpl.uploadProject :Start");
				Transaction tx = null;
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				String returnVal = "N";
				int tranCount = 0;
				long projId = 0;
				Calendar now = Calendar.getInstance();
				int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH);
		        int day = now.get(Calendar.DAY_OF_MONTH);
		        int hour = now.get(Calendar.HOUR);
		        int minute = now.get(Calendar.MINUTE);
		        int second = now.get(Calendar.SECOND);
		        UsrMngtMaster userMngtMaster = null;
		        ProjectTeamMaster projectTeamMaster = null;
		        ProjectMaster projectMaster = null;
		        long projTeamLeaderId = 0;
		        long rgstrId = 0;
		        String projTeamDesc = "";
				try {
					tx = session.beginTransaction();
					for(ProjectXLSVO projectXLSVO:projectXLSVOs)
					{						
						Criteria criteria = session.createCriteria(UsrMngtMaster.class);
						criteria.add(Restrictions.eq("type", "faculty"));
						criteria.add(Restrictions.eq("email", projectXLSVO.getEmail()));
						criteria.setProjection(Projections.property("rgstrId"));
						ArrayList<Long> rgstrIds = (ArrayList<Long>) criteria.list();
						if(rgstrIds.size()>0)
						rgstrId = rgstrIds.get(0);
						/*Start Adding into usr_mngt_master here*/
						if(rgstrId == 0){
							String facUserId = projectXLSVO.getFacEmail()+day+month+year+hour+minute+second;													
							userMngtMaster = new UsrMngtMaster(projectXLSVO.getFirstName(), projectXLSVO.getMidName(), projectXLSVO.getLastName(),null, "Y", null, projectXLSVO.getUserType(), facUserId, null, null, null, projectXLSVO.getEmail());
							Serializable srr = session.save(userMngtMaster);
							projTeamLeaderId = Long.parseLong(srr.toString());
						}else{
							projTeamLeaderId = rgstrId;
						}
						
						
						/*Start Adding into TB_TECH001_MAST_PROJECTS_TEAM here*/
						projectTeamMaster = new ProjectTeamMaster(projTeamDesc);
						Serializable sr = session.save(projectTeamMaster);
						long projectTeamId = Long.parseLong(sr.toString());
						
						/*Start Adding into TB_TECH001_MAST_PROJECTS_DETAIL here*/
						projectMaster = new  ProjectMaster(projectXLSVO.getProjTypeId(),projectXLSVO.getProjTitle(),projectXLSVO.getProjAbstract(),
								projectXLSVO.getProjDescription(),projectXLSVO.getProjUniversity(),
								projectXLSVO.getProjCollegeRgstrIdUsr(),null,projectXLSVO.getProjYear(),0,
								projectXLSVO.getProjCollegeState(),projectXLSVO.getProjStartDate(),projectXLSVO.getProjEndDate(),
								projectXLSVO.getProjMentor1Id(),0,projectTeamId,projectXLSVO.getProjGuideId(),projectXLSVO.getProjStatusId(),
								projectXLSVO.getProjToFloat(),null,projectXLSVO.getProjCommentsPublish(),projectXLSVO.getProjGrade(),
								projTeamLeaderId,projectXLSVO.getProjAwardWon(),projectXLSVO.getProjAwardDesc(),null,null,"N",null,null,0);						
						sr = session.save(projectMaster);
						projId = Long.parseLong(sr.toString());
						projectMaster.setProjId(projId);
						
						/*Start Adding into TB_TECH001_MAST_PROJECTS_BRNCH here*/
						ProjectBranchMaster projectBranchMaster;
						tranCount = 0;
						for(int projBranch:projectXLSVO.getProjBranches()){
							projectBranchMaster = new ProjectBranchMaster();
							projectBranchMaster.setProjId(projId);
							projectBranchMaster.setProjBranchId(projBranch);
							session.saveOrUpdate(projectBranchMaster);
							if ( tranCount % 20 == 0 ) { 
						        session.flush();
						        session.clear();
						    }
							tranCount++;
						}
						
						/*Start Adding into TB_TECH001_MAST_PROJECTS_KEYWRD here*/
						ProjectKeywordMaster projectKeywordMaster;
						tranCount = 0;
						for(String projKeyword:projectXLSVO.getProjKeywords()){
							projectKeywordMaster = new ProjectKeywordMaster();
							projectKeywordMaster.setProjId(projId);
							projectKeywordMaster.setProjKeyword(projKeyword);
							session.saveOrUpdate(projectKeywordMaster);
							if ( tranCount % 20 == 0 ) { 
						        session.flush();
						        session.clear();
						    }
							tranCount++;
						}
					}
					tx.commit();
					returnVal = "Y";
				
				}catch (Exception e) {
					try {
						tx.rollback();
						session.createSQLQuery("delete from tb_tech001_mast_projects_detail where PROJ_ID = :projId").setParameter("projId", projId).executeUpdate();
					} catch (Exception e1) {
						//log.debug("Couldn’t roll back transaction : " + e1);
						throw new BulkUploadException("Error while doing rollback to the failed transection : "+ e1.getMessage());
					}
					throw new BulkUploadException("Error while creating new project : "+ e.getMessage());
				}finally{
					if(tx!=null)
						tx=null;
					if(session!=null)
						session.close();
				}
				return returnVal;
	}

	@Override
	public String bulkUploadProject(String exlByteArray)
			throws BulkUploadException {
		ArrayList<ProjectXLSVO> projectXLSVOs;
		try {
			ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
			String BULK_UPLOAD_TEMP_LOCATION = rbundle.getString("SERVER_PROJ_BULK_UPLOAD_TEMP_FOLDER_LOCATION");
			String BULK_UPLOAD_TEMP_FILE_NAME = rbundle.getString("BULK_UPLOAD_TEMP_FILE_NAME");
			BulkUploadCVS bulkUploadCVS = new BulkUploadCVS();
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(exlByteArray);
			InputStream inputStream = new ByteArrayInputStream(decodedBytes);
			String fileName = FileUploadDownload.saveFile(inputStream,BULK_UPLOAD_TEMP_LOCATION,BULK_UPLOAD_TEMP_FILE_NAME);
			projectXLSVOs = new ArrayList<ProjectXLSVO>();
			projectXLSVOs = bulkUploadCVS.readCSV(new File(fileName));			
			FileUploadDownload.deleteFile(fileName);
		} catch (Exception e) {
			throw new BulkUploadException("Error while bulk uploading project : "+ e.getMessage());
		}
		return this.uploadProjects(projectXLSVOs);
	}

	@Override
	public ArrayList<ProjectTeamDetailVO> getDetailOfTeam(String teamId)
			throws GetDetailOfTeamException {				
		return ProjectDaoHelper.getDetailOfTeam(teamId);
	}
	
	/**
	 * @author geetanjali dated: 09 Sep 2014
	 */
    @Override
    public String removeProjectFollow(ProjFollowVO projFollowVO) throws RemoveProjectFollowException {
    	
    	//log.debug("ProjectDaoImpl.removeProjectFollow :Start"); 
    	String returnVal = "N";
	     Transaction tx = null;	
	     Session session = HibernateUtil.getSessionFactory().openSession();
	     ProjectFollowTxn followTxn = new ProjectFollowTxn();
	     followTxn.setProjId(projFollowVO.getProjectId());
	     followTxn.setRegstrId(projFollowVO.getRgstrId());	     
	     try {	 	
	    	 tx = session.beginTransaction();
	    	 ProjectFollowTxn projectFollowTxn = new ProjectFollowTxn();
	    	 projectFollowTxn = (ProjectFollowTxn) session.load(ProjectFollowTxn.class, followTxn);
			 if(projectFollowTxn.getProjId()!=0){
				 session.delete(projectFollowTxn);	    	
				 tx.commit();
				 returnVal = "Y";
			 }
	    
	     }catch(ObjectNotFoundException onfe){
	    	 return returnVal;
	     }catch (Exception e) {
				//log.debug("Remove does NOT happened : " + e);
				throw new RemoveProjectFollowException("Remove does NOT happened : "+ e.getMessage());
	     }finally{
	    	 if(tx!=null)
	    		 tx=null;
	    	 if(session!=null)
				session.close();
			}
	   //log.debug("ProjectDaoImpl.removeProjectFollow :End"); 
	     return returnVal;
	}
	 /**
	 * @author geetanjali
	 */
	@Override
	public String checkProjectFollow(ProjFollowVO projFollowVO) throws CheckProjectFollowException {	
		
		//log.debug("ProjectDaoImpl.checkProjectFollow :Start");
	    String returnVal = "N";
	    long projId = projFollowVO.getProjectId();
	    long regstrId = projFollowVO.getRgstrId();
		Session session = HibernateUtil.getSessionFactory().openSession();
	    
		try {	    	 
			Criteria projectFollowCriteria = session.createCriteria(ProjectFollowTxn.class);
			projectFollowCriteria.add(Restrictions.conjunction()
			          .add(Restrictions.eq("regstrId", regstrId))
			          .add(Restrictions.eq("projId", projId)));
			int size= (projectFollowCriteria.list()).size();	 						 
		 if (size > 0)								  
			 returnVal = "Y";		 
		 
		} catch (Exception e) {
			//log.debug("Check whether Project is followed or NOT: " + e);
			throw new CheckProjectFollowException("Error in Check Project followed or not: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.checkProjectFollow :End");
		return returnVal;
	 }

	@SuppressWarnings("unused")
	@Override
	public Project submitProject(ProjSubmit projSubmit)
			throws SubmitProjectsException {
		
		//log.debug("ProjectDaoImpl.submitProject :Start");
		
			String returnVal = "N";
			long projId = projSubmit.getProjId();;
			int status = projSubmit.getStatus();			
			Project project = new Project();			
			Transaction tx = null;
			Calendar now = Calendar.getInstance(); 
		    String projSubmitionDate = now.getTime().toString();
			Session session = HibernateUtil.getSessionFactory().openSession();		
			try {				
				 tx = session.beginTransaction();		      
					ProjectMaster projectMaster = (ProjectMaster) session.load(ProjectMaster.class, projId);	
				    long prId = projectMaster.getProjId();
					 if (prId != 0){									  
						projectMaster.setProjStatusId(3);	
						session.update(projectMaster);
						long projGuideId = projectMaster.getProjFacRgstrId();
						long projTeamLeaderId = projectMaster.getProjTeamLeaderId();													 
						project.setProjTitle(projectMaster.getProjTitle());
						project.setProjDescription(projectMaster.getProjDescription());
						project.setProjSubmitionDate(projSubmitionDate);
						/*For Faculty*/	
						UsrMngtMaster usrMngtMasterGuide = new UsrMngtMaster();	 
						if(projGuideId != 0){				
							usrMngtMasterGuide = (UsrMngtMaster) session.get(UsrMngtMaster.class,projGuideId);	
							project.setProjFacEMailId(usrMngtMasterGuide.getEmail());							
						}
							
						/*For Team Leader*/
						UsrMngtMaster usrMngtMasterTL = new UsrMngtMaster();	
						if(projTeamLeaderId != 0){				 		
							usrMngtMasterTL = (UsrMngtMaster) session.get(UsrMngtMaster.class,projTeamLeaderId);
							project.setProjTeamLeaderEMailId(usrMngtMasterTL.getEmail());
							project.setProjTeamLeaderName(usrMngtMasterTL.getpFname()+" "+usrMngtMasterTL.getmName()+" "+usrMngtMasterTL.getlName());
						}	
					 }				
				tx.commit();
				returnVal = "Y";	
				
			}catch (Exception e) {
				//log.error("Error while retriving the all followed projects : " + e.getMessage());
				throw new SubmitProjectsException("Error submitting the Project :"+ e.getMessage());
			}finally{
				if(tx!=null)
					tx = null;
				if(session!=null)
					session.close();
			}
			//log.debug("ProjectDaoImpl.submitProject :End");
			return project;
	}

	@Override
	public String uploadProjectDocument(UploadProjDocVO uploadProjDocVO)
			throws UploadProjDocException {
		
		String returnVal = "N";
		String fileSize = "";
		ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
		String SERVER_UPLOAD_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_PROJECT_FOLDER_LOCATION");		
		String projId = String.valueOf(uploadProjDocVO.getProjId());
		String regstrId = String.valueOf(uploadProjDocVO.getRgstrId());
		String docName = uploadProjDocVO.getDocName();	
		String docPath = projId+"/"+regstrId+"/"+docName;
		Calendar now = Calendar.getInstance(); 
	    Date docUploadDate = now.getTime();
	    Transaction tx = null;
		Session session = null;
		try {			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(uploadProjDocVO.getDocByteArray());
			InputStream inputStream = new ByteArrayInputStream(decodedBytes);			
			fileSize = FileUploadDownload.saveFile(inputStream, SERVER_UPLOAD_FOLDER_LOCATION, projId, regstrId, docName);
			
			/*Start Adding into TB_TECH001_MAST_PROJECTS_DETAIL here*/	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(ProjectDocPathTxn.class);
			criteria.add(Restrictions.eq("regstrId", uploadProjDocVO.getRgstrId()));
	        criteria.add(Restrictions.eq("projId", uploadProjDocVO.getProjId()));
	        criteria.add(Restrictions.eq("projPath", docPath));	        
	        ProjectDocPathTxn docPathTxn = (ProjectDocPathTxn) criteria.uniqueResult();
	        if(docPathTxn == null){				
				ProjectDocPathTxn projectDocPathTxn = new ProjectDocPathTxn(uploadProjDocVO.getProjId(),docPath,docUploadDate,uploadProjDocVO.getRgstrId(),fileSize);		
				session.save(projectDocPathTxn);						
	        }else{
	        	docPathTxn.setProjDocSize(fileSize);
	        	session.update(docPathTxn);	        	
	        }
	        tx.commit();
			returnVal = "Y";
		} catch (Exception e) {		
			throw new UploadProjDocException("Error while uploading document :"+ e.getMessage());
		}finally{
			if(tx!=null)
				tx=null;
			if(session!=null)
				session.close();
		}	
		return returnVal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ProjectDocument> downloadProjectDocument(DownloadDocVO downloadDocVO)
			throws DownloadProjDocException {
		
		//log.debug("ProjectDaoImpl.downloadProjectDocument :Start");
		ArrayList<ProjectDocument> projectDocuments = new ArrayList<ProjectDocument>();
		ProjectDocument projectDocument;
		ArrayList<ProjectDocPathTxn> projectDocPathTxns = new ArrayList<ProjectDocPathTxn>();
		long projId = downloadDocVO.getProjId();
		long regstrId = downloadDocVO.getRegstrId();
		ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
		String SERVER_UPLOAD_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_PROJECT_FOLDER_LOCATION");
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try {							
			Criteria criteria = session.createCriteria(ProjectDocPathTxn.class);
			criteria.add(Restrictions.eq("regstrId", regstrId));
	        criteria.add(Restrictions.eq("projId", projId));
			criteria.addOrder(Order.asc("projDocId"));				
	        projectDocPathTxns = (ArrayList<ProjectDocPathTxn>) criteria.list();
			for(ProjectDocPathTxn docPathTxn:projectDocPathTxns){
				projectDocument = new ProjectDocument();
				String docPath = docPathTxn.getProjPath();
				String docName = docPath.substring(docPath.lastIndexOf("/"), docPath.length());
				projectDocument.setDocName(docName);
				projectDocument.setDocLink(SERVER_UPLOAD_FOLDER_LOCATION+docPath);
				
				projectDocuments.add(projectDocument);
			}
			if(projectDocPathTxns.size()==0)
				throw new DownloadProjDocException("No documents uploaded by given user for given project");		
		} catch (Exception e) {
			//log.error("Error while retriving the all followed projects : " + e.getMessage());
			throw new DownloadProjDocException("Error while downloading project documents : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ProjectDaoImpl.downloadProjectDocument :End");
		return projectDocuments;
	}

	@Override
	public ArrayList<ProjectTeamComment> displayOtherComments(
			DisplayTeamCommVO displayTeamCommVO)
			throws OtherCommentsNotFoundException {
		//log.debug("ProjectDaoImpl.displayOtherComments :Start");
			return ProjectDaoHelper.displayOtherComments(displayTeamCommVO.getProjId(), displayTeamCommVO.getIterationCount());
		//log.debug("ProjectDaoImpl.displayOtherComments :End");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> getProjectsByLoggedInUser(String rgstrId)
			throws ProjectByLoggedInUserException {	
		//log.debug("ProjectDaoImpl.getProjectsByLoggedInUser :Start");
				Project project = null;
				ArrayList<Project> projects = new ArrayList<Project>();
				
				Session session = HibernateUtil.getSessionFactory().openSession();
				try {
					DetachedCriteria dc = DetachedCriteria.forClass(ProjectTeamTxn.class);
					dc.add(Restrictions.eq("regstrId", Long.valueOf(rgstrId)));
					dc.setProjection(Projections.property("projId"));				
					Criteria criteria =session.createCriteria(ProjectMaster.class);				
					criteria.add(Restrictions.disjunction()
					          .add(Restrictions.eq("projMentor1Id", Long.valueOf(rgstrId)))
					          .add(Restrictions.eq("projMentor2Id", Long.valueOf(rgstrId)))
					          .add(Restrictions.eq("projTeamLeaderId", Long.valueOf(rgstrId)))
					          .add(Restrictions.eq("projFacRgstrId", Long.valueOf(rgstrId)))
					          .add(Subqueries.propertyIn("projId", dc)));
					criteria.add(Restrictions.eq("projStatus", "ACTIVE"));
					criteria.addOrder(Order.asc("projId"));
					
					ArrayList<ProjectMaster> projectMasters = (ArrayList<ProjectMaster>) criteria.list();
					for(ProjectMaster projectMaster:projectMasters){
						project = new Project();
						project.setProjId(projectMaster.getProjId());
						project.setProjTitle(projectMaster.getProjTitle());
						project.setProjDescription(projectMaster.getProjDescription());
						projects.add(project);
					}
					if(projects.size()==0)
						throw new ProjectByLoggedInUserException("No projects available for this criteria");
				} catch (Exception e) {
					//log.debug("Error while deleting project : "+ e.getMessage());
					throw new ProjectByLoggedInUserException("Error while getting all project : "+ e.getMessage());
				}finally{
					if(session!=null)
						session.close();
				}
				//log.debug("ProjectDaoImpl.getProjectsByLoggedInUser :End");
				return projects;
		}

	@Override
	public ArrayList<Project> getProjectFollowers()
			throws GetProjectFollowersException {	
		//log.debug("ProjectDaoImpl.checkProjectFollow :Start");
		return ProjectDaoHelper.getProjectFollowers();
		//log.debug("ProjectDaoImpl.checkProjectFollow :End");
		
	}
	
	@Override
	public String deleteProjectDocument(DeleteDocVO deleteDocVO)
			throws DeleteDocumentException {
		
		//log.debug("ProjectDaoImpl.deleteProjectDocument :Start");
		String returnVal = "N";		
		long projId = deleteDocVO.getProjId();
		long regstrId = deleteDocVO.getRegstrId();
		String docName = deleteDocVO.getDocName();
		//String docLink = deleteDocVO.getDocLink();
		String docPath = projId+"/"+regstrId+"/"+docName;
		ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
		String SERVER_UPLOAD_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_PROJECT_FOLDER_LOCATION");	
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProjectDocPathTxn projectDocPathTxn = new ProjectDocPathTxn();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria =session.createCriteria(ProjectDocPathTxn.class);	
			criteria.add(Restrictions.conjunction()
			          .add(Restrictions.eq("projId", Long.valueOf(projId)))
			          .add(Restrictions.eq("regstrId", Long.valueOf(regstrId)))
			          .add(Restrictions.eq("projPath", docPath)));
			projectDocPathTxn = (ProjectDocPathTxn) criteria.uniqueResult();
			session.delete(projectDocPathTxn);
			returnVal = FileUploadDownload.deleteFile(SERVER_UPLOAD_FOLDER_LOCATION+docPath);
			tx.commit();					
			if(returnVal=="N")
				throw new DeleteDocumentException("No documents uploaded by given user for given project");		
			} catch (Exception e) {
				//log.error("Error while retriving the all followed projects : " + e.getMessage());
				throw new DeleteDocumentException("Error while deleting project documents : "+ e.getMessage());
			}finally{
				if(tx!=null)
					tx=null;
				if(session!=null)
					session.close();
			}
			//log.debug("ProjectDaoImpl.deleteProjectDocument :End");				
		return returnVal;
	}

	@Override
	public String facultyInitiatedProject(FacInitProjVO facInitProjVO)
			throws FacultyInitiatedProjectException {
		//log.debug("ProjectDaoImpl.facultyInitiatedProject :Start");
				String returnVal = "N";
				Transaction tx = null;
				long projId = facInitProjVO.getProjId();
				long projGuideId = facInitProjVO.getProjGuideId();
				String approvalStatus = facInitProjVO.getApprovalStatus();
				Session session = HibernateUtil.getSessionFactory().openSession();				
				try {
					tx = session.beginTransaction();
					ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);
					projectMaster.setProjId(projId);
					if(projId != 0 || projGuideId != 0){
							if(approvalStatus == "Y") {
									projectMaster.setProjStatusId(2);
									projectMaster.setProjIsFacApprove("Y");									
							}
							/*uninitiated*/
							else {
								projectMaster.setProjStatusId(1);
								projectMaster.setProjIsFacApprove("N");								
							}
					}
					session.update(projectMaster);
					tx.commit();
					returnVal = "Y";
				} catch (Exception e) {
					//log.debug("Error while initiating the project by Faculty: "+ e.getMessage());
					throw new FacultyInitiatedProjectException("Error while initiating the project by Faculty: "+ e.getMessage());
				}finally{
					if(tx!=null)
						tx=null;
					if(session!=null)
						session = null;
				}
				//log.debug("ProjectDaoImpl.facultyInitiatedProject :End");
				return returnVal;
	}

	@Override
	public String facultyClosedProject(FacInitProjVO facInitProjVO)
			throws FacultyClosedProjectException {
		//log.debug("ProjectDaoImpl.facultyClosedProject :Start");
				String returnVal = "N";
				Transaction tx = null;
				long projId = facInitProjVO.getProjId();
				long projGuideId = facInitProjVO.getProjGuideId();
				String approvalStatus = facInitProjVO.getApprovalStatus();
				Session session = HibernateUtil.getSessionFactory().openSession();
				
				try {
					tx = session.beginTransaction();
					ProjectMaster projectMaster = (ProjectMaster) session.get(ProjectMaster.class, projId);
					projectMaster.setProjId(projId);
					if(projId != 0 || projGuideId != 0){
						/*close*/	
						if(approvalStatus == "Y") {								
							projectMaster.setProjStatusId(4);
							projectMaster.setProjIsFacApprove("Y");									
						}
						else {
							/*Initiated*/
							projectMaster.setProjStatusId(2);
							projectMaster.setProjIsFacApprove("N");								
						}
					}
					session.update(projectMaster);
					tx.commit();
					returnVal = "Y";
				} catch (Exception e) {
					//log.debug("Error while closing the project by faculty :"+ e.getMessage());
					throw new FacultyClosedProjectException("Error while closing the project by faculty : "+ e.getMessage());
				}finally{
					if(tx!=null)
						tx=null;
					if(session!=null)
						session = null;
				}
				//log.debug("ProjectDaoImpl.facultyClosedProject :End");
				return returnVal;
	}
}
