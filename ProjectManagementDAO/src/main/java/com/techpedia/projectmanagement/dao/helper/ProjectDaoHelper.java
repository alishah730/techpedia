package com.techpedia.projectmanagement.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.techpedia.projectmanagement.bean.ApproveOrDeclineMentorRequestResponse;
import com.techpedia.projectmanagement.bean.ApproveOrDeclineMentorRequestVO;
import com.techpedia.projectmanagement.bean.Branch;
import com.techpedia.projectmanagement.bean.DisplayProjectMacroVO;
import com.techpedia.projectmanagement.bean.FacRejectProjResponse;
import com.techpedia.projectmanagement.bean.FacRejectProjVO;
import com.techpedia.projectmanagement.bean.Faculty;
import com.techpedia.projectmanagement.bean.FacultyMarkedProjectAsCompletedResponse;
import com.techpedia.projectmanagement.bean.FacultyMarkedProjectAsCompletedVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectMacroBranch;
import com.techpedia.projectmanagement.bean.ProjectTeamComment;
import com.techpedia.projectmanagement.bean.ProjectTeamDetailVO;
import com.techpedia.projectmanagement.bean.RequestToBeMentorResponse;
import com.techpedia.projectmanagement.bean.RequestToBeMentorVO;
import com.techpedia.projectmanagement.bean.ResubmitProjectResponse;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.entity.Mentor;
import com.techpedia.projectmanagement.entity.ProjectMaster;
import com.techpedia.projectmanagement.entity.ProjectTeamDetail;
import com.techpedia.projectmanagement.entity.ProjectTeamTxn;
import com.techpedia.projectmanagement.entity.ProjectUser;
import com.techpedia.projectmanagement.entity.TeamComment;
import com.techpedia.projectmanagement.entity.TopFiveProjFollowers;
import com.techpedia.projectmanagement.entity.UsrMngtMaster;
import com.techpedia.projectmanagement.exception.ApproveOrDeclineMentorRequestException;
import com.techpedia.projectmanagement.exception.CollegeRecentProjectsException;
import com.techpedia.projectmanagement.exception.DownloadProjDocException;
import com.techpedia.projectmanagement.exception.FacultyMarkedProjectAsCompletedException;
import com.techpedia.projectmanagement.exception.FacultyRejectedProjectException;
import com.techpedia.projectmanagement.exception.GetAllBranchesException;
import com.techpedia.projectmanagement.exception.GetAllMentorsException;
import com.techpedia.projectmanagement.exception.GetAllProjectException;
import com.techpedia.projectmanagement.exception.GetDetailOfTeamException;
import com.techpedia.projectmanagement.exception.GetProjectFollowersException;
import com.techpedia.projectmanagement.exception.OtherCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.ProjectByLoggedInUserException;
import com.techpedia.projectmanagement.exception.ProjectMacroBranchException;
import com.techpedia.projectmanagement.exception.RequestToBeMentorException;
import com.techpedia.projectmanagement.exception.ResubmitProjectException;
import com.techpedia.projectmanagement.exception.SuggestedFacultyNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedTeamMembersNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
import com.techpedia.util.HibernateUtil;

@Component
public class ProjectDaoHelper {

	@Autowired
	private DataSource dataSource;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDaoHelper.class.getName());

	/**
	 * @param userProfileVO
	 * @return
	 * @throws SuggestedTeamMembersNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Team> getSuggestedTeamMembers(UserProfileVO userProfileVO) throws SuggestedTeamMembersNotFoundException{

		String enrlmtNo = userProfileVO.getStudentID();
		String college = userProfileVO.getCollge();
		String fName = userProfileVO.getFirstName();
		String lName = userProfileVO.getLastName();
		String mName = userProfileVO.getMidName();
		ArrayList<Team> suggestedTeamMembers = new ArrayList<Team>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql1 = "SELECT UMM.RGSTR_ID, CONCAT(IFNULL(FNAME, ''), ' ', IFNULL(MNAME,''), ' ', IFNULL(LNAME,'')) AS USR_NAME FROM "
				+ "USR_MNGT_MASTER AS UMM, USR_MNGT_STUDENT AS UMS WHERE ";
		StringBuffer hql2 = new StringBuffer();

		if(enrlmtNo != null && enrlmtNo.trim() != "")
			hql2 = hql2.append(" UMS.ENROLLMENT_NO LIKE :ENROLLMENT_NO AND ");
		if(college != null && college.trim() != "")
			hql2 = hql2.append(" COLLEGE LIKE :COLLEGE AND ");
		if(fName != null && fName.trim() != "")
			hql2 = hql2.append(" FNAME LIKE :FNAME AND ");
		if(lName != null && lName.trim() != "")
			hql2 = hql2.append(" LNAME LIKE :LNAME AND ");
		if(mName != null && mName.trim() != "")
			hql2 = hql2.append(" MNAME LIKE :MNAME AND ");

		String hql3 = " UMM.RGSTR_ID = UMS.RGSTR_ID";
		try {

			SQLQuery query  = session.createSQLQuery(hql1+hql2.toString()+hql3);

			if(enrlmtNo != null && enrlmtNo.trim() != "")
				query.setParameter("ENROLLMENT_NO", "%"+enrlmtNo+"%");
			if(college != null && college.trim() != "")
				query.setParameter("COLLEGE", "%"+college+"%");
			if(fName != null && fName.trim() != "")
				query.setParameter("FNAME", "%"+fName+"%");
			if(lName != null && lName.trim() != "")
				query.setParameter("LNAME", "%"+lName+"%");
			if(mName != null && mName.trim() != "")
				query.setParameter("MNAME", "%"+mName+"%");

			suggestedTeamMembers = (ArrayList<Team>) query.list();

		} catch (Exception e) {
			//LOGGER.error("Error while retrieving the Suggested keywords :" + e.getMessage());
			throw new SuggestedTeamMembersNotFoundException("Error while retriving the Suggested TeamMembers : "
					+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return suggestedTeamMembers;
	}

	/**
	 * @param userId
	 * @return
	 * @throws SuggestedFacultyNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Faculty> getSuggestedFaculty(String userId) throws SuggestedFacultyNotFoundException{

		ArrayList<Faculty> suggestedFaculties = new ArrayList<Faculty>(); 
		String hql = "SELECT UMM.RGSTR_ID, CONCAT(IFNULL(FNAME,''), ' ', IFNULL(MNAME,''), ' ', IFNULL(LNAME,'')) AS FACULTYNAME, DEGREE, "
				+ "SPECIALISATION FROM USR_MNGT_MASTER AS UMM, USR_MNGT_FACULTY AS UMF WHERE COLLEGE "
				+ "IN(SELECT COLLEGE FROM USR_MNGT_STUDENT WHERE RGSTR_ID IN (SELECT RGSTR_ID FROM USR_MNGT_MASTER "
				+ "WHERE USR_ID = :USR_ID)) AND UMM.RGSTR_ID = UMF.RGSTR_ID";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("USR_ID", userId);
			suggestedFaculties = (ArrayList<Faculty>) query.list();
		} catch (HibernateException e) {
			throw new SuggestedFacultyNotFoundException("Error while retriving the suggested faculty : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return suggestedFaculties;
	}

	/**
	 * @param milliseconds
	 * @return
	 */
	public static Date getMillisecondsToDate(String milliseconds){
		long lnMilliseconds = Long.valueOf(milliseconds);
		Date projectStartDate = new Date(lnMilliseconds);
		return projectStartDate;
	}

	/**
	 * @param dateVal
	 * @return
	 */
	public static String getDateToMilliseconds(Date dateVal){
		long lnMilliseconds = dateVal.getTime();
		String milliseconds = String.valueOf(lnMilliseconds);
		return milliseconds;
	}

	/**
	 * @param iterationCount
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<UserProfileVO> getAllMentors(String iterationCount) throws GetAllMentorsException{

		ArrayList<Mentor> mentors = new ArrayList<Mentor>();
		UserProfileVO userProfileVO;
		ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*8)-8;
		int maxResultSize = 8;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT UMM.RGSTR_ID, IFNULL(FNAME,'') AS FNAME, IFNULL(MNAME,'') AS MNAME, IFNULL(LNAME,'') "
				+ "AS LNAME, UMMT.DESIGNATION, PHOTO  FROM USR_MNGT_MASTER AS UMM, USR_MNGT_MENTOR AS UMMT, "
				+ "usr_mngt_contact_info UMCI WHERE UMM.RGSTR_ID = ummt.RGSTR_ID AND UMM.RGSTR_ID = UMCI.RGSTR_ID "
				+ " ORDER BY RGSTR_ID";
		try{
			SQLQuery query  = session.createSQLQuery(hql);
			query.setFirstResult(minIndex);
			query.setMaxResults(maxResultSize);	
			query.addEntity(Mentor.class);
			mentors = (ArrayList<Mentor>) query.list();			
			if(mentors.size()==0){
				throw new GetAllMentorsException("No mentors available for this criteria");	
			}else{
				for(Mentor mentor:mentors){
					userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(mentor.getRgstrId());
					userProfileVO.setFirstName(mentor.getfName());
					userProfileVO.setMidName(mentor.getmName());
					userProfileVO.setLastName(mentor.getlName());
					userProfileVO.setDesignationOfMentor(mentor.getDesignation());
					userProfileVO.setPhoto(mentor.getPhoto());
					userProfileVOs.add(userProfileVO);
				}
			}
		}catch (Exception e) {
			//LOGGER.debug("Error while getting all Mentors : "+ e.getMessage());
			throw new GetAllMentorsException("Error while getting all Mentors : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}

		return userProfileVOs;
	}

	/**
	 * @param projId
	 * @param iterationCount
	 * @return
	 * @throws TeamCommentsNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<ProjectTeamComment> displayTeamComments(String projId, String iterationCount) throws TeamCommentsNotFoundException{

		ArrayList<ProjectTeamComment> projectTeamComments = new ArrayList<ProjectTeamComment>();
		ProjectTeamComment projectTeamComment;
		ArrayList<TeamComment> teamComments = new ArrayList<TeamComment>();
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*5)-5;
		int maxResultSize = 5;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select cmt.proj_id,cmt.comment_id,cmt.REGSTR_ID,cmt.proj_comment,(Select IFNULL(umm.FNAME,'') "
				+ "from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) FNAME,(Select IFNULL(umm.MNAME,'')  "
				+ "from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) MNAME,(Select IFNULL(umm.LNAME,'') "
				+ "from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) LNAME, (select proj_team_leader_id "
				+ "from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)proj_team_leader_id, "
				+ "(select PROJ_FAC_RGSTR_ID from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_FAC_RGSTR_ID,"
				+ "(select proj_mentor1_id from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)proj_mentor1_id,"
				+ "(select proj_mentor2_id from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)proj_mentor2_id  "
				+ "from tb_tech001_txn_projects_team team, tb_tech001_txn_project_comment cmt where cmt.proj_id = team.proj_id "
				+ "and cmt.REGSTR_ID = team.REGSTR_ID and team.proj_id= :PROJ_ID and cmt.IS_ACTIVE_COMMNT = 'Y' and "
				+ "team.proj_id=cmt.proj_id union select cmt.proj_id,cmt.comment_id,cmt.REGSTR_ID, cmt.proj_comment,"
				+ "(Select IFNULL(umm.FNAME,'') from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) FNAME,"
				+ "(Select IFNULL(umm.MNAME,'')  from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) MNAME,"
				+ "(Select IFNULL(umm.LNAME,'') from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) LNAME "
				+ ",x.proj_team_leader_id, x.PROJ_FAC_RGSTR_ID,x.proj_mentor1_id,x.proj_mentor2_id from "
				+ "tb_tech001_mast_projects_detail x, tb_tech001_txn_project_comment cmt where (x.proj_team_leader_id = "
				+ "cmt.REGSTR_ID or x.PROJ_FAC_RGSTR_ID = cmt.REGSTR_ID or x.proj_mentor1_id = cmt.REGSTR_ID or x.proj_mentor2_id "
				+ "= cmt.REGSTR_ID) and x.proj_id= :PROJ_ID and cmt.IS_ACTIVE_COMMNT = 'Y' and cmt.proj_id=x.proj_id";
		try {			
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("PROJ_ID", Long.valueOf(projId));
			query.setFirstResult(minIndex);
			query.setMaxResults(maxResultSize);				
			query.addEntity(TeamComment.class);
			teamComments = (ArrayList<TeamComment>) query.list();
			for(TeamComment teamComment:teamComments){
				projectTeamComment = new ProjectTeamComment();
				projectTeamComment.setCommentId(teamComment.getCommentId());
				projectTeamComment.setfName(teamComment.getfName());
				projectTeamComment.setlName(teamComment.getlName());
				projectTeamComment.setmName(teamComment.getmName());
				projectTeamComment.setProjComment(teamComment.getProjComment());
				projectTeamComment.setProjGuideId(teamComment.getProjGuideId());
				projectTeamComment.setProjId(teamComment.getProjId());
				projectTeamComment.setProjMentor1Id(teamComment.getProjMentor1Id());
				projectTeamComment.setProjMentor2Id(teamComment.getProjMentor2Id());
				projectTeamComment.setProjTeamLeaderId(teamComment.getProjTeamLeaderId());
				projectTeamComment.setRegstrId(teamComment.getRegstrId());
				projectTeamComments.add(projectTeamComment);				
			}


		} catch (Exception e) {
			//LOGGER.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new TeamCommentsNotFoundException("Error while retrieving the Team Comments: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projectTeamComments;
	}	

	@SuppressWarnings("unchecked")
	public static ArrayList<ProjectTeamDetailVO> getDetailOfTeam(String teamId)	throws GetDetailOfTeamException {

		ArrayList<ProjectTeamDetailVO> projectTeamDetailVOs = new ArrayList<ProjectTeamDetailVO>();
		ProjectTeamDetailVO projectTeamDetailVO;
		ArrayList<ProjectTeamDetail> projectTeamDetails = new ArrayList<ProjectTeamDetail>();
		long teamLeadId = 0;
		String teamName = "";
		long projId = 0;
		String projTitle = "";
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String hql ="select cmt.REGSTR_ID RGSTR_ID,(Select IFNULL(umm.FNAME,'') from usr_mngt_master umm where umm.RGSTR_ID=" 
				+ " cmt.regstr_id) FNAME,(Select IFNULL(umm.MNAME,'')  from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) MNAME,(Select "
				+ " IFNULL(umm.LNAME,'') from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) LNAME, (select umci.PHOTO from "
				+ " usr_mngt_contact_info umci where umci.rgstr_id=cmt.regstr_id) Photo, cmt.proj_id PROJ_ID,(select PROJ_TITLE from " 
				+ " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_TITLE,(select PROJ_MENTOR1_ID from "
				+ " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_MENTOR1_ID,(select PROJ_MENTOR2_ID from "
				+ " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_MENTOR2_ID,(select proj_team_leader_id from "
				+ " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_TEAM_LEADER_ID,     team.PROJ_TEAM_DESC PROJ_TEAM_DESC , "
				+ " (select uma.State from usr_mngt_addr uma where uma.rgstr_id=cmt.regstr_id) State, (select uma.Country from usr_mngt_addr uma "
				+ " where uma.rgstr_id=cmt.regstr_id)Country,(select ums.College from usr_mngt_student ums where ums.rgstr_id=cmt.regstr_id) College,"
				+"(select cmt1.proj_branch_desc from tb_tech001_mast_branch cmt1,usr_mngt_student ums1 where  ums1.rgstr_id=cmt.regstr_id and ums1.branch_id=cmt1.branch_id) BRANCH_NAME"
				+ " from tb_tech001_txn_projects_team cmt, tb_tech001_mast_projects_team team where  cmt.team_id = team.team_id and "
				+ " cmt.team_id=:team_id";

		try {			
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("team_id", Long.valueOf(teamId));
			query.addEntity(ProjectTeamDetail.class);
			projectTeamDetails = (ArrayList<ProjectTeamDetail>) query.list();
			for(ProjectTeamDetail teamDetail:projectTeamDetails){				
				projectTeamDetailVO = new ProjectTeamDetailVO();
				projectTeamDetailVO.setTeamMemFName(teamDetail.getTeamMemFName());
				projectTeamDetailVO.setTeamMemMName(teamDetail.getTeamMemMName());
				projectTeamDetailVO.setTeamMemLName(teamDetail.getTeamMemLName());
				projectTeamDetailVO.setCollege(teamDetail.getCollege());
				projectTeamDetailVO.setBranchName(teamDetail.getBranchName());
				projectTeamDetailVO.setCountry(teamDetail.getCountry());
				projectTeamDetailVO.setState(teamDetail.getState());		
				projectTeamDetailVO.setPhoto(teamDetail.getPhoto());			
				projectTeamDetailVO.setTeamMemRegstrId(teamDetail.getRgstrId());				
				projectTeamDetailVO.setTeamLeaderId(teamDetail.getTeamLeaderId());		
				projectTeamDetailVO.setProjTeamName(teamDetail.getProjTeamName());	
				projectTeamDetailVO.setProjId(teamDetail.getProjId());	
				projectTeamDetailVO.setProjTitle(teamDetail.getProjTitle()); 
				projectTeamDetailVO.setProjMentor1Id(teamDetail.getProjMentor1Id());
				projectTeamDetailVO.setProjMentor2Id(teamDetail.getProjMentor2Id());

				projectTeamDetailVOs.add(projectTeamDetailVO);

			}

			/*for(ProjectTeamDetailVO teamDetailVO:projectTeamDetailVOs){
				teamDetailVO.setTeamLeaderId(teamLeadId);
				teamDetailVO.setProjTeamName(teamName);
				teamDetailVO.setProjId(projId);
				teamDetailVO.setProjTitle(projTitle);
			}*/


		} catch (Exception e) {
			LOGGER.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new GetDetailOfTeamException("Error while retrieving the Team details: "+ e.getMessage());
			//e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return projectTeamDetailVOs;	

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<ProjectTeamComment> displayOtherComments(String projId, String iterationCount) throws OtherCommentsNotFoundException{

		ArrayList<ProjectTeamComment> projectTeamComments = new ArrayList<ProjectTeamComment>();
		ProjectTeamComment projectTeamComment;
		ArrayList<TeamComment> teamComments = new ArrayList<TeamComment>();
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*5)-5;
		int maxResultSize = 5;
		Session session = HibernateUtil.getSessionFactory().openSession();		
		String hql = "select cmt1.proj_id,cmt1.comment_id,cmt1.regstr_id,cmt1.proj_comment,(Select IFNULL(umm.FNAME,'') "
				+ "from usr_mngt_master umm where umm.RGSTR_ID = cmt1.regstr_id) FNAME,(Select IFNULL(umm.MNAME,'')  "
				+ "from usr_mngt_master umm where umm.RGSTR_ID = cmt1.regstr_id) MNAME,(Select IFNULL(umm.LNAME,'') "
				+ "from usr_mngt_master umm where umm.RGSTR_ID = cmt1.regstr_id) LNAME, (select proj_team_leader_id "
				+ "from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt1.proj_id)proj_team_leader_id, "
				+ "(select PROJ_FAC_RGSTR_ID from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt1.proj_id)PROJ_FAC_RGSTR_ID,"
				+ "(select proj_mentor1_id from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt1.proj_id)proj_mentor1_id,"
				+ "(select proj_mentor2_id from tb_tech001_mast_projects_detail xx where xx.proj_id=cmt1.proj_id)proj_mentor2_id "
				+ "from tb_tech001_txn_project_comment cmt1 where regstr_id not in (select cmt.REGSTR_ID from "
				+ "tb_tech001_txn_projects_team team, tb_tech001_txn_project_comment cmt where cmt.proj_id = team.proj_id and "
				+ "cmt.REGSTR_ID = team.REGSTR_ID and team.proj_id= :PROJ_ID and cmt.IS_ACTIVE_COMMNT = 'Y' and team.proj_id=cmt.proj_id"
				+ " union select cmt.REGSTR_ID from tb_tech001_mast_projects_detail x, tb_tech001_txn_project_comment cmt "
				+ "where (x.proj_team_leader_id = cmt.REGSTR_ID or x.PROJ_FAC_RGSTR_ID = cmt.REGSTR_ID or x.proj_mentor1_id "
				+ "= cmt.REGSTR_ID or x.proj_mentor2_id = cmt.REGSTR_ID) and x.proj_id= :PROJ_ID and cmt.IS_ACTIVE_COMMNT = 'Y' "
				+ "and cmt.proj_id=x.proj_id) and proj_id= :PROJ_ID and IS_ACTIVE_COMMNT = 'Y' ORDER BY cmt1.PROJ_COMMENTS_REC_DATE DESC";
		try {			
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("PROJ_ID", Long.valueOf(projId));
			query.setFirstResult(minIndex);
			query.setMaxResults(maxResultSize);
			query.addEntity(TeamComment.class);
			teamComments = (ArrayList<TeamComment>) query.list();

			for(TeamComment teamComment:teamComments){
				projectTeamComment = new ProjectTeamComment();
				projectTeamComment.setCommentId(teamComment.getCommentId());
				projectTeamComment.setfName(teamComment.getfName());
				projectTeamComment.setlName(teamComment.getlName());
				projectTeamComment.setmName(teamComment.getmName());
				projectTeamComment.setProjComment(teamComment.getProjComment());
				projectTeamComment.setProjGuideId(teamComment.getProjGuideId());
				projectTeamComment.setProjId(teamComment.getProjId());
				projectTeamComment.setProjMentor1Id(teamComment.getProjMentor1Id());
				projectTeamComment.setProjMentor2Id(teamComment.getProjMentor2Id());
				projectTeamComment.setProjTeamLeaderId(teamComment.getProjTeamLeaderId());
				projectTeamComment.setRegstrId(teamComment.getRegstrId());
				projectTeamComments.add(projectTeamComment);				
			}

		} catch (Exception e) {
			//LOGGER.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new OtherCommentsNotFoundException("Error while retrieving the other Comments: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projectTeamComments;
	}



	@SuppressWarnings("unchecked")
	public static ArrayList<Project> getProjectFollowers()
			throws GetProjectFollowersException {
		Project project;
		ArrayList<Project> projects = new ArrayList<Project>();
		ArrayList<TopFiveProjFollowers> topFiveProjFollowers = new ArrayList<TopFiveProjFollowers>();
		int maxResultSize = 8;


		Session session = HibernateUtil.getSessionFactory().openSession();


		String hql = "SELECT count(tpf.proj_id) count, mpd.proj_id, proj_title, proj_description, photo1_path  FROM "
				+ "techpedia.tb_tech001_txn_projects_follow tpf, tb_tech001_mast_projects_detail mpd where "
				+ "tpf.proj_id = mpd.proj_id group by proj_id ORDER BY count desc, proj_id desc";
		try {			
			SQLQuery query  = session.createSQLQuery(hql);			
			query.setMaxResults(maxResultSize);
			query.addEntity(TopFiveProjFollowers.class);
			topFiveProjFollowers = (ArrayList<TopFiveProjFollowers>) query.list();
			for(TopFiveProjFollowers projFollowers:topFiveProjFollowers){
				project = new Project();
				project.setProjId(projFollowers.getProjId());
				project.setProjTitle(projFollowers.getProjTitle());
				project.setProjDescription(projFollowers.getProjDescription());	
				project.setPhoto1Path(projFollowers.getPhoto1Path());
				projects.add(project);
			}

		} catch (Exception e) {
			//LOGGER.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new GetProjectFollowersException("Error while retrieving the other Comments: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projects;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Project> getRecentProject()
			throws GetAllProjectException {
		//LOGGER.debug("ProjectDaoImpl.getAllProject :Start");
		Project project = null;
		ArrayList<Project> projects = new ArrayList<Project>();
		int maxResultSize = 8;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria =session.createCriteria(ProjectMaster.class);
			criteria.add(Restrictions.eq("projStatus", "ACTIVE"));
			criteria.addOrder(Order.desc("projId"));
			criteria.setMaxResults(maxResultSize);
			ArrayList<ProjectMaster> projectMasters = (ArrayList<ProjectMaster>) criteria.list();
			for(ProjectMaster projectMaster:projectMasters){
				project = new Project();
				project.setProjId(projectMaster.getProjId());
				project.setProjTitle(projectMaster.getProjTitle());
				project.setProjDescription(projectMaster.getProjDescription());
				project.setProjUniversity(projectMaster.getProjUniversity());
				project.setProjTeamLeaderId(projectMaster.getProjTeamLeaderId());
				project.setProjFaculty(projectMaster.getProjFacRgstrId());
				project.setProjTeamId(projectMaster.getTeamId());
				project.setPhoto1Path(projectMaster.getPhoto1Path());
				project.setPhoto2Path(projectMaster.getPhoto2Path());


				DetachedCriteria dcProjTeamTxn = DetachedCriteria.forClass(ProjectTeamTxn.class);
				dcProjTeamTxn.add(Restrictions.eq("projId", projectMaster.getProjId()));
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

				projects.add(project);
			}
			if(projects.size()==0)
				throw new GetAllProjectException("No projects available for this criteria");
		} catch (Exception e) {
			//LOGGER.debug("Error while deleting project : "+ e.getMessage());
			throw new GetAllProjectException("Error while getting all project : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//LOGGER.debug("ProjectDaoImpl.getAllProject :End");
		return projects;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Project> getLatestProject()
			throws GetAllProjectException {
		//LOGGER.debug("ProjectDaoImpl.getAllProject :Start");
		Project project = null;
		ArrayList<Project> projects = new ArrayList<Project>();
		int maxResultSize = 5;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria =session.createCriteria(ProjectMaster.class);
			criteria.add(Restrictions.eq("projStatus", "ACTIVE"));
			criteria.addOrder(Order.desc("projId"));
			criteria.setMaxResults(maxResultSize);
			ArrayList<ProjectMaster> projectMasters = (ArrayList<ProjectMaster>) criteria.list();
			for(ProjectMaster projectMaster:projectMasters){
				project = new Project();
				project.setProjId(projectMaster.getProjId());
				project.setProjTitle(projectMaster.getProjTitle());
				project.setProjDescription(projectMaster.getProjDescription());
				project.setProjUniversity(projectMaster.getProjUniversity());
				project.setProjTeamLeaderId(projectMaster.getProjTeamLeaderId());
				project.setProjFaculty(projectMaster.getProjFacRgstrId());
				project.setProjTeamId(projectMaster.getTeamId());
				project.setPhoto1Path(projectMaster.getPhoto1Path());
				project.setPhoto2Path(projectMaster.getPhoto2Path());


				DetachedCriteria dcProjTeamTxn = DetachedCriteria.forClass(ProjectTeamTxn.class);
				dcProjTeamTxn.add(Restrictions.eq("projId", projectMaster.getProjId()));
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

				projects.add(project);
			}
			if(projects.size()==0)
				throw new GetAllProjectException("No projects available for this criteria");
		} catch (Exception e) {
			//LOGGER.debug("Error while deleting project : "+ e.getMessage());
			throw new GetAllProjectException("Error while getting all project : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//LOGGER.debug("ProjectDaoImpl.getAllProject :End");
		return projects;
	}

	@SuppressWarnings("unchecked")
	public static Set<Long> getProjectTeamMembers(long projId) throws DownloadProjDocException{

		Set<Long> projTeamMems = new HashSet<Long>();
		ArrayList<ProjectUser> projUsers = new ArrayList<ProjectUser>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "select proj_team_leader_id , PROJ_FAC_RGSTR_ID , proj_mentor1_id , proj_mentor2_id "
				+ "from tb_tech001_mast_projects_detail xx where xx.proj_id=:PROJ_ID union Select team.REGSTR_ID,"
				+ "-1,-1,-1  from tb_tech001_txn_projects_team team where team.proj_id=:PROJ_ID union select "
				+ "folo.REGSTR_ID,-1,-1,-1 from tb_tech001_txn_projects_follow folo where folo.proj_id= :PROJ_ID";
		try {			
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("PROJ_ID", projId);
			query.addEntity(ProjectUser.class);		
			projUsers = (ArrayList<ProjectUser>) query.list();
			for(ProjectUser projectUser:projUsers){	
				if(projectUser.getProjFacRgstrId()!=0 || projectUser.getProjFacRgstrId()!=-1)				
					projTeamMems.add(projectUser.getProjFacRgstrId());
				if(projectUser.getProjMentor1Id()!=0 || projectUser.getProjMentor1Id()!=-1)				
					projTeamMems.add(projectUser.getProjMentor1Id());
				if(projectUser.getProjMentor2Id()!=0 || projectUser.getProjMentor2Id()!=-1)				
					projTeamMems.add(projectUser.getProjMentor2Id());
				if(projectUser.getProjTeamLeaderId()!=0 || projectUser.getProjTeamLeaderId()!=-1)				
					projTeamMems.add(projectUser.getProjTeamLeaderId());
			}			

		} catch (Exception e) {
			//LOGGER.error("Error while retrieving Project Team Members rgstr Id: " + e.getMessage());
			throw new DownloadProjDocException("Error while retrieving Project Team Members rgstr Id: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projTeamMems;
	}


	public ArrayList<Project> getCompletedProject() throws GetAllProjectException {

		ArrayList<Project> projects = new ArrayList<Project>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getCompletedProjectDetailQuery = rbundle.getString("GET_COMPLETED_PROJECT_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
		LOGGER.info("getCompletedProjectDetailQuery :: "+getCompletedProjectDetailQuery);

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			projects = (ArrayList<Project>) jdbcTemplate.query(getCompletedProjectDetailQuery, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));
					return project;
				}

			});

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();
			ArrayList<Branch> projBranches = new ArrayList<Branch>();
			ArrayList<UserProfileVO> projFacultyNames = new ArrayList<UserProfileVO>();
			ArrayList<UserProfileVO> teamLeaderNames = new ArrayList<UserProfileVO>();

			String getTeamDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamDetailsUsrMngtMasterQuery = getTeamDetailsUsrMngtMasterQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getTeamDetailsUsrMngtMasterQuery :: "+getTeamDetailsUsrMngtMasterQuery);

			String getBranchDetailsMastBranchQuery = rbundle.getString("GET_BRANCH_DETAILS_MAST_BRANCH_QUERY");
			getBranchDetailsMastBranchQuery = getBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getBranchDetailsMastBranchQuery :: "+getBranchDetailsMastBranchQuery);

			String getFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getFacultyDetailsUsrMngtMasterQuery = getFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			LOGGER.info("getFacultyDetailsUsrMngtMasterQuery :: "+getFacultyDetailsUsrMngtMasterQuery);

			String getCollegeDetailsUsrMngtMasterQuery = rbundle.getString("GET_COLLEGE_DETAILS_USR_MNGT_MASTER_QUERY");
			getCollegeDetailsUsrMngtMasterQuery = getCollegeDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getCollegeDetailsUsrMngtMasterQuery :: "+getCollegeDetailsUsrMngtMasterQuery);


			for(Project project : projects){

				//Setting Team Members 
				Map<String, String> paramMapForProjId = new HashMap<String, String>();
				paramMapForProjId.put("projId", Long.toString(project.getProjId()));
				userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamDetailsUsrMngtMasterQuery, paramMapForProjId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				ArrayList<Team> projTeamMemberList = new ArrayList<Team>();
				for(UserProfileVO userProfileVO : userProfileVOs){
					Team team = new Team();
					team.setTeamMemberRgstrId(userProfileVO.getRgstrId());
					team.setTeamMemberName(userProfileVO.getFirstName()+" "+userProfileVO.getMidName()+" "+userProfileVO.getLastName());
					projTeamMemberList.add(team);
				}
				project.setProjTeamMemberList(projTeamMemberList);

				//Setting Branches 
				projBranches = (ArrayList<Branch>) namedParameterJdbcTemplate.query(getBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<Branch>(){

					@Override
					public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

						Branch branch = new Branch();
						branch.setBranchId(rs.getInt("BRANCH_ID"));
						branch.setBranchName(rs.getString("PROJ_BRANCH_DESC"));
						return branch;
					}

				});
				project.setProjBranchList(projBranches);

				//Setting Faculty Names 
				Map<String, String> paramMapForFacultyRegtrId = new HashMap<String, String>();
				paramMapForFacultyRegtrId.put("projFacRgstrId", Long.toString(project.getProjFaculty()));
				projFacultyNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getFacultyDetailsUsrMngtMasterQuery, paramMapForFacultyRegtrId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				ArrayList<UserProfileVO> projFacultyNamesList = new ArrayList<UserProfileVO>();
				for(UserProfileVO userProfileVO : projFacultyNames){
					projFacultyNamesList.add(userProfileVO);
				}
				if(projFacultyNamesList.size()>0){
					project.setProjFacultyName(projFacultyNames.get(0).getFirstName()+" "+projFacultyNames.get(0).getMidName()+" "+projFacultyNames.get(0).getLastName());
				}

				//Setting College Name
				Map<String, String> paramMapForTeamLeaderId = new HashMap<String, String>();
				paramMapForTeamLeaderId.put("projTeamLeaderId", Long.toString(project.getProjTeamLeaderId()));
				teamLeaderNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getCollegeDetailsUsrMngtMasterQuery, paramMapForTeamLeaderId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setCollge(rs.getString("COLLEGE"));
						return userProfileVO;
					}

				});
				ArrayList<UserProfileVO> teamLeaderNamesList = new ArrayList<UserProfileVO>();
				for(UserProfileVO userProfileVO : teamLeaderNames){
					teamLeaderNamesList.add(userProfileVO);
				}
				if(teamLeaderNamesList.size()>0){
					project.setProjCollege(teamLeaderNames.get(0).getCollegeName());
				}

			}
		} catch (Exception e) {
			LOGGER.error("Error while getting all completed projects :"+ e.getMessage());
			throw new GetAllProjectException("Error while getting all completed projects : "+ e.getMessage());
		}

		return projects;
	}

	public ArrayList<Project> getWorkingProject() throws GetAllProjectException {

		ArrayList<Project> projects = new ArrayList<Project>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getWorkingProjectDetailQuery = rbundle.getString("GET_WORKING_PROJECT_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
		LOGGER.info("getWorkingProjectDetailQuery :: "+getWorkingProjectDetailQuery);


		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			projects = (ArrayList<Project>) jdbcTemplate.query(getWorkingProjectDetailQuery, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));
					return project;
				}

			});

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();
			ArrayList<Branch> projBranches = new ArrayList<Branch>();
			ArrayList<UserProfileVO> projFacultyNames = new ArrayList<UserProfileVO>();
			ArrayList<UserProfileVO> teamLeaderNames = new ArrayList<UserProfileVO>();

			String getTeamDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamDetailsUsrMngtMasterQuery = getTeamDetailsUsrMngtMasterQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getTeamDetailsUsrMngtMasterQuery :: "+getTeamDetailsUsrMngtMasterQuery);

			String getBranchDetailsMastBranchQuery = rbundle.getString("GET_BRANCH_DETAILS_MAST_BRANCH_QUERY");
			getBranchDetailsMastBranchQuery = getBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getBranchDetailsMastBranchQuery :: "+getBranchDetailsMastBranchQuery);

			String getFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getFacultyDetailsUsrMngtMasterQuery = getFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			LOGGER.info("getFacultyDetailsUsrMngtMasterQuery :: "+getFacultyDetailsUsrMngtMasterQuery);

			String getCollegeDetailsUsrMngtMasterQuery = rbundle.getString("GET_COLLEGE_DETAILS_USR_MNGT_MASTER_QUERY");
			getCollegeDetailsUsrMngtMasterQuery = getCollegeDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getCollegeDetailsUsrMngtMasterQuery :: "+getCollegeDetailsUsrMngtMasterQuery);


			for(Project project : projects){

				//Setting Team Members 
				Map<String, String> paramMapForProjId = new HashMap<String, String>();
				paramMapForProjId.put("projId", Long.toString(project.getProjId()));
				userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamDetailsUsrMngtMasterQuery, paramMapForProjId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				ArrayList<Team> projTeamMemberList = new ArrayList<Team>();
				for(UserProfileVO userProfileVO : userProfileVOs){
					Team team = new Team();
					team.setTeamMemberRgstrId(userProfileVO.getRgstrId());
					team.setTeamMemberName(userProfileVO.getFirstName()+" "+userProfileVO.getMidName()+" "+userProfileVO.getLastName());
					projTeamMemberList.add(team);
				}
				project.setProjTeamMemberList(projTeamMemberList);

				//Setting Branches 
				projBranches = (ArrayList<Branch>) namedParameterJdbcTemplate.query(getBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<Branch>(){

					@Override
					public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

						Branch branch = new Branch();
						branch.setBranchId(rs.getInt("BRANCH_ID"));
						branch.setBranchName("PROJ_BRANCH_DESC");
						return branch;
					}

				});
				project.setProjBranchList(projBranches);

				//Setting Faculty Names 
				Map<String, String> paramMapForFacultyRegtrId = new HashMap<String, String>();
				paramMapForFacultyRegtrId.put("projFacRgstrId", Long.toString(project.getProjFaculty()));
				projFacultyNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getFacultyDetailsUsrMngtMasterQuery, paramMapForFacultyRegtrId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				ArrayList<UserProfileVO> projFacultyNamesList = new ArrayList<UserProfileVO>();
				for(UserProfileVO userProfileVO : projFacultyNames){
					projFacultyNamesList.add(userProfileVO);
				}
				if(projFacultyNamesList.size()>0){
					project.setProjFacultyName(projFacultyNames.get(0).getFirstName()+" "+projFacultyNames.get(0).getMidName()+" "+projFacultyNames.get(0).getLastName());
				}

				//Setting College Name
				Map<String, String> paramMapForTeamLeaderId = new HashMap<String, String>();
				paramMapForTeamLeaderId.put("projTeamLeaderId", Long.toString(project.getProjTeamLeaderId()));
				teamLeaderNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getCollegeDetailsUsrMngtMasterQuery, paramMapForTeamLeaderId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setCollge(rs.getString("COLLEGE"));
						return userProfileVO;
					}

				});
				ArrayList<UserProfileVO> teamLeaderNamesList = new ArrayList<UserProfileVO>();
				for(UserProfileVO userProfileVO : teamLeaderNames){
					teamLeaderNamesList.add(userProfileVO);
				}
				if(teamLeaderNamesList.size()>0){
					project.setProjCollege(teamLeaderNames.get(0).getCollegeName());
				}

			}
		} catch (Exception e) {
			LOGGER.error("Error while getting all working projects :"+ e.getMessage());
			throw new GetAllProjectException("Error while getting all working projects : "+ e.getMessage());
		}

		return projects;
	}

	public ArrayList<Project> getCompletedProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException {

		ArrayList<Project> projects = new ArrayList<Project>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getCompletedProjectByLoggedInUserDetailQuery = rbundle.getString("GET_COMPLETED_PROJECT_BY_LOGGED_IN_USER_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
		getCompletedProjectByLoggedInUserDetailQuery = getCompletedProjectByLoggedInUserDetailQuery.replaceAll("&RGSTRID", ":rgstrId");
		LOGGER.info("getCompletedProjectDetailQuery :: "+getCompletedProjectByLoggedInUserDetailQuery);

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForRgstrId = new HashMap<String, String>();
			paramMapForRgstrId.put("rgstrId", rgstrId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getCompletedProjectByLoggedInUserDetailQuery, paramMapForRgstrId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));
					project.setPhoto1Path(rs.getString("PHOTO1_PATH"));

					return project;
				}

			});
		} catch (Exception e) {
			LOGGER.error("Error while getting all completed projects by LoggedInUser :"+ e.getMessage());
			throw new ProjectByLoggedInUserException("Error while getting all completed projects by LoggedInUser : "+ e.getMessage());
		}

		return projects;
	}


	public ArrayList<Project> getWorkingProjectByLoggedInUser(String rgstrId) throws ProjectByLoggedInUserException {

		ArrayList<Project> projects = new ArrayList<Project>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getWorkingProjectByLoggedInUserDetailQuery = rbundle.getString("GET_WORKING_PROJECT_BY_LOGGED_IN_USER_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
		getWorkingProjectByLoggedInUserDetailQuery = getWorkingProjectByLoggedInUserDetailQuery.replaceAll("&RGSTRID", ":rgstrId");
		LOGGER.info("getWorkingProjectByLoggedInUserDetailQuery :: "+getWorkingProjectByLoggedInUserDetailQuery);

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForRgstrId = new HashMap<String, String>();
			paramMapForRgstrId.put("rgstrId", rgstrId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getWorkingProjectByLoggedInUserDetailQuery, paramMapForRgstrId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));
					project.setPhoto1Path(rs.getString("PHOTO1_PATH"));

					return project;
				}

			});
		} catch (Exception e) {
			LOGGER.error("Error while getting all working projects by LoggedInUser :"+ e.getMessage());
			throw new ProjectByLoggedInUserException("Error while getting all working projects by LoggedInUser : "+ e.getMessage());
		}

		return projects;
	}

	public FacRejectProjResponse facultyRejectedProject(FacRejectProjVO facRejectProjVO) throws FacultyRejectedProjectException {

		FacRejectProjResponse facRejectProjResponse = new FacRejectProjResponse();
		facRejectProjResponse.setStatus("N");
		facRejectProjResponse.setRejectReason(facRejectProjVO.getRejectReason());

		long projId = facRejectProjVO.getProjId();
		long projGuideId = facRejectProjVO.getProjGuideId();
		String approvalStatus = facRejectProjVO.getApprovalStatus();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");

		try {
			//Update the PROJ_IS_FAC_APPROVE column
			String facultyRejectedProjectProjDetailUpdateQuery = rbundle.getString("FACULTY_REJECTED_PROJECT_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			facultyRejectedProjectProjDetailUpdateQuery = facultyRejectedProjectProjDetailUpdateQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("facultyRejectedProjectProjDetailUpdateQuery :: "+facultyRejectedProjectProjDetailUpdateQuery);

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForProjId = new HashMap<String, String>();
			paramMapForProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);

			int noOfRowsAffected = 0;

			if(projId != 0 || projGuideId != 0){
				if(approvalStatus.toUpperCase() == "N" || approvalStatus.equalsIgnoreCase("N")) {
					noOfRowsAffected = namedParameterJdbcTemplate.update(facultyRejectedProjectProjDetailUpdateQuery, paramMapForProjId);
				}
			}
			if(noOfRowsAffected > 0){
				facRejectProjResponse.setStatus("Y");
				LOGGER.info("Project rejected :: "+facRejectProjResponse.getStatus());
			}

			//Get the project details by using PROJ_ID 
			ArrayList<Project> projects = new ArrayList<Project>();

			String getProjectDetailsQuery = rbundle.getString("GET_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			getProjectDetailsQuery = getProjectDetailsQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getProjectDetailsQuery :: "+getProjectDetailsQuery);

			Map<String, String> paramMapForRequestedProjId = new HashMap<String, String>();
			paramMapForRequestedProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getProjectDetailsQuery, paramMapForRequestedProjId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));

					return project;
				}

			});
			if(projects.size()>0){
				facRejectProjResponse.setProjTitle(projects.get(0).getProjTitle());
			}


			//Get the team leader & the faculty EMAIL_ID, FNAME, MNAME, LNAME by using PROJ_TEAM_LEADER_ID 
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();

			String getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_AND_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery :: "+getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery);

			Map<String, String> paramMapForTeamLeaderIdAndFacultyRegtrId = new HashMap<String, String>();
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projFacRgstrId", Long.toString(projects.get(0).getProjFaculty()));
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projTeamLeaderId", Long.toString(projects.get(0).getProjTeamLeaderId()));
			LOGGER.info("projFacRgstrId :: "+ Long.toString(projects.get(0).getProjFaculty()));
			LOGGER.info("projTeamLeaderId :: "+ Long.toString(projects.get(0).getProjTeamLeaderId()));
			userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery, paramMapForTeamLeaderIdAndFacultyRegtrId, new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setFirstName(rs.getString("FNAME"));
					userProfileVO.setMidName(rs.getString("MNAME"));
					userProfileVO.setLastName(rs.getString("LNAME"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					return userProfileVO;
				}

			});
			if(userProfileVOs.size()>0){
				for(UserProfileVO userProfileVO : userProfileVOs){
					if(userProfileVO.getRgstrId()==projects.get(0).getProjFaculty()){
						facRejectProjResponse.setFacultyEmailId(userProfileVO.getEmail());
						facRejectProjResponse.setFacultyFname(userProfileVO.getFirstName());
						facRejectProjResponse.setFacultyMname(userProfileVO.getMidName());
						facRejectProjResponse.setFacultyLname(userProfileVO.getLastName());
						LOGGER.info("facultyEmailId :: "+userProfileVO.getEmail());
					}
					else{
						facRejectProjResponse.setTeamLeaderEmailId(userProfileVO.getEmail());
						facRejectProjResponse.setTeamLeaderFname(userProfileVO.getFirstName());
						facRejectProjResponse.setTeamLeaderMname(userProfileVO.getMidName());
						facRejectProjResponse.setTeamLeaderLname(userProfileVO.getLastName());
						LOGGER.info("teamLeaderEmailId :: "+userProfileVO.getEmail());
					}
				}
				facRejectProjResponse.setProjTitle(projects.get(0).getProjTitle());
			}
		} catch (Exception e) {
			LOGGER.error("Error occured while faculty Reject Project :"+ e.getMessage());
			throw new FacultyRejectedProjectException("Error occured while faculty Reject Project : "+ e.getMessage());
		}
		return facRejectProjResponse;
	}

	public ResubmitProjectResponse resubmitProject(String projId) throws ResubmitProjectException {

		ResubmitProjectResponse resubmitProjectResponse = new ResubmitProjectResponse();
		resubmitProjectResponse.setStatus("N");
		resubmitProjectResponse.setProject(new Project());

		ResourceBundle rbundle = ResourceBundle.getBundle("query");


		try {
			//Update the PROJ_IS_FAC_APPROVE column
			int noOfRowsAffected = 0;
			String resubmitProjectProjDetailUpdateQuery = rbundle.getString("RESUBMIT_PROJECT_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			resubmitProjectProjDetailUpdateQuery = resubmitProjectProjDetailUpdateQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("resubmitProjectProjDetailUpdateQuery :: "+resubmitProjectProjDetailUpdateQuery);

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForProjId = new HashMap<String, String>();
			paramMapForProjId.put("projId", projId);
			LOGGER.info("projId :: "+projId);

			noOfRowsAffected = namedParameterJdbcTemplate.update(resubmitProjectProjDetailUpdateQuery, paramMapForProjId);

			if(noOfRowsAffected > 0){
				resubmitProjectResponse.setStatus("Y");
				LOGGER.info("Project resubmitted :: "+resubmitProjectResponse.getStatus());
			}

			//Get the project details by using PROJ_ID 
			ArrayList<Project> projects = new ArrayList<Project>();

			String getProjectDetailsQuery = rbundle.getString("GET_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			getProjectDetailsQuery = getProjectDetailsQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getProjectDetailsQuery :: "+getProjectDetailsQuery);

			namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForRequestedProjId = new HashMap<String, String>();
			paramMapForRequestedProjId.put("projId", projId);
			LOGGER.info("projId :: "+projId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getProjectDetailsQuery, paramMapForRequestedProjId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));

					return project;
				}

			});
			if(projects.size()>0){
				resubmitProjectResponse.setStatus("Y");
				resubmitProjectResponse.setProject(projects.get(0));
				LOGGER.info("Project resubmitted Successfully :: "+resubmitProjectResponse.getStatus());
			}
			//Get the team leader & the faculty EMAIL_ID, FNAME, MNAME, LNAME by using PROJ_TEAM_LEADER_ID 
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();

			String getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_AND_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery :: "+getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery);

			Map<String, String> paramMapForTeamLeaderIdAndFacultyRegtrId = new HashMap<String, String>();
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projFacRgstrId", Long.toString(projects.get(0).getProjFaculty()));
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projTeamLeaderId", Long.toString(projects.get(0).getProjTeamLeaderId()));
			LOGGER.info("projFacRgstrId :: "+ Long.toString(projects.get(0).getProjFaculty()));
			LOGGER.info("projTeamLeaderId :: "+ Long.toString(projects.get(0).getProjTeamLeaderId()));
			userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery, paramMapForTeamLeaderIdAndFacultyRegtrId, new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setFirstName(rs.getString("FNAME"));
					userProfileVO.setMidName(rs.getString("MNAME"));
					userProfileVO.setLastName(rs.getString("LNAME"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					return userProfileVO;
				}

			});
			if(userProfileVOs.size()>0){
				for(UserProfileVO userProfileVO : userProfileVOs){
					if(userProfileVO.getRgstrId()==projects.get(0).getProjFaculty()){
						resubmitProjectResponse.setFacultyEmailId(userProfileVO.getEmail());
						LOGGER.info("facultyEmailId :: "+userProfileVO.getEmail());
					}
					else{
						resubmitProjectResponse.setTeamLeaderEmailId(userProfileVO.getEmail());
						resubmitProjectResponse.getProject().setProjTeamLeaderName(userProfileVO.getFirstName()+" "+userProfileVO.getMidName()+" "+userProfileVO.getLastName());
						LOGGER.info("teamLeaderEmailId :: "+userProfileVO.getEmail());
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error occured while resubmit Project :"+ e.getMessage());
			throw new ResubmitProjectException("Error occured while resubmit Project : "+ e.getMessage());
		}
		return resubmitProjectResponse;
	}

	public FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompleted(FacultyMarkedProjectAsCompletedVO facultyMarkedProjectAsCompletedVO) throws FacultyMarkedProjectAsCompletedException {

		FacultyMarkedProjectAsCompletedResponse facultyMarkedProjectAsCompletedResponse = new FacultyMarkedProjectAsCompletedResponse();
		facultyMarkedProjectAsCompletedResponse.setStatus("N");
		facultyMarkedProjectAsCompletedResponse.setProjGrade(facultyMarkedProjectAsCompletedVO.getProjGrade());
		facultyMarkedProjectAsCompletedResponse.setProjFacNotes(facultyMarkedProjectAsCompletedVO.getProjFacNotes());
		facultyMarkedProjectAsCompletedResponse.setRejectReason(facultyMarkedProjectAsCompletedResponse.getRejectReason());

		long projId = facultyMarkedProjectAsCompletedVO.getProjId();
		long projGuideId = facultyMarkedProjectAsCompletedVO.getProjGuideId();
		String approvalStatus = facultyMarkedProjectAsCompletedVO.getApprovalStatus();
		String projGrade = facultyMarkedProjectAsCompletedVO.getProjGrade();
		String projFacNotes = facultyMarkedProjectAsCompletedVO.getProjFacNotes();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");

		try{
			//Update the PROJ_GRADE & PROJ_FAC_NOTE column
			String facultyClosedProjectProjDetailUpdateQuery = rbundle.getString("FACULTY_CLOSED_PROJECT_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			facultyClosedProjectProjDetailUpdateQuery = facultyClosedProjectProjDetailUpdateQuery.replaceAll("&PROJID", ":projId");
			facultyClosedProjectProjDetailUpdateQuery = facultyClosedProjectProjDetailUpdateQuery.replaceAll("&PROJGRADE", ":projGrade");
			facultyClosedProjectProjDetailUpdateQuery = facultyClosedProjectProjDetailUpdateQuery.replaceAll("&PROJFACNOTES", ":projFacNotes");
			LOGGER.info("facultyClosedProjectProjDetailUpdateQuery :: "+facultyClosedProjectProjDetailUpdateQuery);

			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForProjIdProjGradeAndProjFacNotes = new HashMap<String, String>();
			paramMapForProjIdProjGradeAndProjFacNotes.put("projId", String.valueOf(projId));
			paramMapForProjIdProjGradeAndProjFacNotes.put("projGrade", projGrade);
			paramMapForProjIdProjGradeAndProjFacNotes.put("projFacNotes", projFacNotes);
			LOGGER.info("projId :: "+projId);
			LOGGER.info("projGrade :: "+projGrade);
			LOGGER.info("projFacNotes :: "+projFacNotes);

			//Update the PROJ_STATUS_ID & PROJ_IS_FAC_APPROVE column
			String facultyRejectedProjectAtClosureProjectDetailUpdateQuery = rbundle.getString("FACULTY_REJECTED_PROJECT_AT_CLOSURE_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			facultyRejectedProjectAtClosureProjectDetailUpdateQuery = facultyRejectedProjectAtClosureProjectDetailUpdateQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("facultyRejectedProjectAtClosureProjectDetailUpdateQuery :: "+facultyRejectedProjectAtClosureProjectDetailUpdateQuery);
			Map<String, String> paramMapForProjId = new HashMap<String, String>();
			paramMapForProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);

			int noOfRowsAffected = 0;

			if(projId != 0 && projGuideId != 0){
				if(approvalStatus.toUpperCase() == "Y" || approvalStatus.equalsIgnoreCase("Y")) {
					noOfRowsAffected = namedParameterJdbcTemplate.update(facultyClosedProjectProjDetailUpdateQuery, paramMapForProjIdProjGradeAndProjFacNotes);
					if(noOfRowsAffected > 0){
						facultyMarkedProjectAsCompletedResponse.setStatus("Y");
						facultyMarkedProjectAsCompletedResponse.setProjGrade(projGrade);
						facultyMarkedProjectAsCompletedResponse.setProjFacNotes(projFacNotes);
						LOGGER.info("Project Marked As Complete And Grades given with Notes :: "+facultyMarkedProjectAsCompletedResponse.getStatus());
					}
				}
				else{
					noOfRowsAffected = namedParameterJdbcTemplate.update(facultyRejectedProjectAtClosureProjectDetailUpdateQuery, paramMapForProjId);
					if(noOfRowsAffected > 0){
						facultyMarkedProjectAsCompletedResponse.setStatus("N");
						facultyMarkedProjectAsCompletedResponse.setRejectReason(facultyMarkedProjectAsCompletedResponse.getRejectReason());
						LOGGER.info("Project Rejected by Faculty At Closure :: "+facultyMarkedProjectAsCompletedResponse.getStatus());
						LOGGER.info("RejectReason :: "+facultyMarkedProjectAsCompletedResponse.getRejectReason());
					}

				}
			}
			//Get the project details by using PROJ_ID 
			ArrayList<Project> projects = new ArrayList<Project>();

			String getProjectDetailsQuery = rbundle.getString("GET_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			getProjectDetailsQuery = getProjectDetailsQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getProjectDetailsQuery :: "+getProjectDetailsQuery);

			Map<String, String> paramMapForRequestedProjId = new HashMap<String, String>();
			paramMapForRequestedProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getProjectDetailsQuery, paramMapForRequestedProjId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));

					return project;
				}

			});
			if(projects.size()>0){
				facultyMarkedProjectAsCompletedResponse.setProjTitle(projects.get(0).getProjTitle());
			}


			//Get the team leader & the faculty EMAIL_ID, FNAME, MNAME, LNAME by using PROJ_TEAM_LEADER_ID 
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();

			String getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_AND_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery = getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery :: "+getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery);

			Map<String, String> paramMapForTeamLeaderIdAndFacultyRegtrId = new HashMap<String, String>();
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projFacRgstrId", Long.toString(projects.get(0).getProjFaculty()));
			paramMapForTeamLeaderIdAndFacultyRegtrId.put("projTeamLeaderId", Long.toString(projects.get(0).getProjTeamLeaderId()));
			LOGGER.info("projFacRgstrId :: "+ Long.toString(projects.get(0).getProjFaculty()));
			LOGGER.info("projTeamLeaderId :: "+ Long.toString(projects.get(0).getProjTeamLeaderId()));
			userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeaderAndFacultyDetailsUsrMngtMasterQuery, paramMapForTeamLeaderIdAndFacultyRegtrId, new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setFirstName(rs.getString("FNAME"));
					userProfileVO.setMidName(rs.getString("MNAME"));
					userProfileVO.setLastName(rs.getString("LNAME"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					return userProfileVO;
				}

			});
			if(userProfileVOs.size()>0){
				for(UserProfileVO userProfileVO : userProfileVOs){
					if(userProfileVO.getRgstrId()==projects.get(0).getProjFaculty()){
						facultyMarkedProjectAsCompletedResponse.setFacultyEmailId(userProfileVO.getEmail());
						facultyMarkedProjectAsCompletedResponse.setFacultyFname(userProfileVO.getFirstName());
						facultyMarkedProjectAsCompletedResponse.setFacultyMname(userProfileVO.getMidName());
						facultyMarkedProjectAsCompletedResponse.setFacultyLname(userProfileVO.getLastName());
						LOGGER.info("facultyEmailId :: "+userProfileVO.getEmail());
					}
					else{
						facultyMarkedProjectAsCompletedResponse.setTeamLeaderEmailId(userProfileVO.getEmail());
						facultyMarkedProjectAsCompletedResponse.setTeamLeaderFname(userProfileVO.getFirstName());
						facultyMarkedProjectAsCompletedResponse.setTeamLeaderMname(userProfileVO.getMidName());
						facultyMarkedProjectAsCompletedResponse.setTeamLeaderLname(userProfileVO.getLastName());
						LOGGER.info("teamLeaderEmailId :: "+userProfileVO.getEmail());
					}
				}
				facultyMarkedProjectAsCompletedResponse.setProjTitle(projects.get(0).getProjTitle());
			}
		} catch (Exception e) {
			LOGGER.error("Error occured while marking the project as complete by faculty :"+ e.getMessage());
			throw new FacultyMarkedProjectAsCompletedException("Error occured while  marking the project as complete by faculty : "+ e.getMessage());
		}

		return facultyMarkedProjectAsCompletedResponse;
	}

	public RequestToBeMentorResponse requestToBeMentor(RequestToBeMentorVO requestToBeMentorVO) throws RequestToBeMentorException {

		RequestToBeMentorResponse requestToBeMentorResponse = new RequestToBeMentorResponse();
		requestToBeMentorResponse.setStatus("N");
		requestToBeMentorResponse.setProjId(requestToBeMentorVO.getProjId());
		requestToBeMentorResponse.setMentorEmailId(requestToBeMentorVO.getMentorEmailId());
		requestToBeMentorResponse.setMentorFname(requestToBeMentorVO.getMentorFirstName());
		requestToBeMentorResponse.setMentorLname(requestToBeMentorVO.getMentorLastName());

		long projId = requestToBeMentorVO.getProjId();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try{
			//Get the project details by using PROJ_ID 
			ArrayList<Project> projects = new ArrayList<Project>();

			String getProjectDetailsQuery = rbundle.getString("GET_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			getProjectDetailsQuery = getProjectDetailsQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getProjectDetailsQuery :: "+getProjectDetailsQuery);

			Map<String, String> paramMapForRequestedProjId = new HashMap<String, String>();
			paramMapForRequestedProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getProjectDetailsQuery, paramMapForRequestedProjId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));

					return project;
				}

			});
			if(projects.size()>0){
				requestToBeMentorResponse.setProjTitle(projects.get(0).getProjTitle());
			}

			//Get the team leader EMAIL_ID, FNAME, MNAME, LNAME by using PROJ_TEAM_LEADER_ID 
			ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();

			String getTeamLeaderDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_DETAILS_USR_MNGT_MASTER_QUERY");
			getTeamLeaderDetailsUsrMngtMasterQuery = getTeamLeaderDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
			LOGGER.info("getTeamLeaderDetailsUsrMngtMasterQuery :: "+getTeamLeaderDetailsUsrMngtMasterQuery);

			Map<String, String> paramMapForTeamLeaderIdRegtrId = new HashMap<String, String>();
			paramMapForTeamLeaderIdRegtrId.put("projTeamLeaderId", Long.toString(projects.get(0).getProjTeamLeaderId()));
			LOGGER.info("projTeamLeaderId :: "+ Long.toString(projects.get(0).getProjTeamLeaderId()));
			userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeaderDetailsUsrMngtMasterQuery, paramMapForTeamLeaderIdRegtrId, new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setFirstName(rs.getString("FNAME"));
					userProfileVO.setMidName(rs.getString("MNAME"));
					userProfileVO.setLastName(rs.getString("LNAME"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					return userProfileVO;
				}

			});
			if(userProfileVOs.size()>0){
				for(UserProfileVO userProfileVO : userProfileVOs){
					if(userProfileVO.getRgstrId()==projects.get(0).getProjTeamLeaderId()){
						requestToBeMentorResponse.setTeamLeaderEmailId(userProfileVO.getEmail());
						requestToBeMentorResponse.setTeamLeaderFname(userProfileVO.getFirstName());
						requestToBeMentorResponse.setTeamLeaderMname(userProfileVO.getMidName());
						requestToBeMentorResponse.setTeamLeaderLname(userProfileVO.getLastName());
						LOGGER.info("teamLeaderEmailId :: "+userProfileVO.getEmail());
					}
				}
				requestToBeMentorResponse.setStatus("Y");
			}
		}catch(Exception e){
			LOGGER.error("Error occured while marking the project as complete by faculty :"+ e.getMessage());
			throw new RequestToBeMentorException("Error occured while sending the request to be mentor : "+ e.getMessage());
		}
		return requestToBeMentorResponse;
	}

	public ApproveOrDeclineMentorRequestResponse approveOrDeclineMentorRequest(ApproveOrDeclineMentorRequestVO approveOrDeclineMentorRequestVO) throws ApproveOrDeclineMentorRequestException{

		ApproveOrDeclineMentorRequestResponse approveOrDeclineMentorRequestResponse = new ApproveOrDeclineMentorRequestResponse();
		approveOrDeclineMentorRequestResponse.setProjId(approveOrDeclineMentorRequestVO.getProjId());
		approveOrDeclineMentorRequestResponse.setMentorEmailId(approveOrDeclineMentorRequestVO.getMentorEmailId());
		approveOrDeclineMentorRequestResponse.setMentorFname(approveOrDeclineMentorRequestVO.getMentorFirstName());
		approveOrDeclineMentorRequestResponse.setMentorLname(approveOrDeclineMentorRequestVO.getMentorLastName());
		approveOrDeclineMentorRequestResponse.setTeamLeaderEmailId(approveOrDeclineMentorRequestVO.getTeamLeaderEmailId());
		approveOrDeclineMentorRequestResponse.setTeamLeaderFname(approveOrDeclineMentorRequestVO.getTeamLeaderFname());
		approveOrDeclineMentorRequestResponse.setTeamLeaderLname(approveOrDeclineMentorRequestVO.getTeamLeaderLname());

		long projId = approveOrDeclineMentorRequestVO.getProjId();
		long mentorRegstrId = approveOrDeclineMentorRequestVO.getMentorRegstrId();
		String approvalStatus = approveOrDeclineMentorRequestVO.getApprovalStatus();
		String declineComments = approveOrDeclineMentorRequestVO.getDeclineComments();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		try{
			//Get the project details by using PROJ_ID 
			ArrayList<Project> projects = new ArrayList<Project>();

			String getProjectDetailsQuery = rbundle.getString("GET_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
			getProjectDetailsQuery = getProjectDetailsQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getProjectDetailsQuery :: "+getProjectDetailsQuery);

			Map<String, String> paramMapForRequestedProjId = new HashMap<String, String>();
			paramMapForRequestedProjId.put("projId", String.valueOf(projId));
			LOGGER.info("projId :: "+projId);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getProjectDetailsQuery, paramMapForRequestedProjId, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));

					return project;
				}

			});
			if(projects.size()>0){
				approveOrDeclineMentorRequestResponse.setProjTitle(projects.get(0).getProjTitle());

				if(projects.get(0).getProjMentor1Id()==0){

					long mentor1RegstrId = mentorRegstrId;
					//Update the PROJ_IS_MENTOR_AVAIL, PROJ_MENTOR1_ID column
					String approveMentor1RequestProjectDetailUpdateQuery = rbundle.getString("APPROVE_MENTOR1_REQUEST_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
					approveMentor1RequestProjectDetailUpdateQuery = approveMentor1RequestProjectDetailUpdateQuery.replaceAll("&PROJID", ":projId");
					approveMentor1RequestProjectDetailUpdateQuery = approveMentor1RequestProjectDetailUpdateQuery.replaceAll("&MENTOR1REGSTRID", ":mentor1RegstrId");
					LOGGER.info("approveMentor1RequestProjectDetailUpdateQuery :: "+approveMentor1RequestProjectDetailUpdateQuery);
					Map<String, String> paramMapForProjIdAndMentor1RegstrId = new HashMap<String, String>();
					paramMapForProjIdAndMentor1RegstrId.put("projId", String.valueOf(projId));
					paramMapForProjIdAndMentor1RegstrId.put("mentor1RegstrId", String.valueOf(mentor1RegstrId));
					LOGGER.info("projId :: "+projId);
					LOGGER.info("mentor1RegstrId :: "+mentor1RegstrId);

					int noOfRowsAffected = 0;

					if(approvalStatus.toUpperCase() == "Y" || approvalStatus.equalsIgnoreCase("Y")) {
						noOfRowsAffected = namedParameterJdbcTemplate.update(approveMentor1RequestProjectDetailUpdateQuery, paramMapForProjIdAndMentor1RegstrId);
						if(noOfRowsAffected > 0){
							approveOrDeclineMentorRequestResponse.setStatus("Y");
							LOGGER.info("Team Leader Approved The Mentor Request :: "+approveOrDeclineMentorRequestResponse.getStatus());
						}
					}
					else{
						approveOrDeclineMentorRequestResponse.setStatus("N");
						approveOrDeclineMentorRequestResponse.setDeclineComments(declineComments);
						LOGGER.info("Team Leader Declined The Mentor Request :: "+approveOrDeclineMentorRequestResponse.getStatus());
						LOGGER.info("declineComments :: "+approveOrDeclineMentorRequestResponse.getDeclineComments());
					}
				}else if(projects.get(0).getProjMentor2Id()==0){

					long mentor2RegstrId = mentorRegstrId;
					//Update the PROJ_IS_MENTOR_AVAIL, PROJ_MENTOR2_ID column
					String approveMentor2RequestProjectDetailUpdateQuery = rbundle.getString("APPROVE_MENTOR2_REQUEST_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
					approveMentor2RequestProjectDetailUpdateQuery = approveMentor2RequestProjectDetailUpdateQuery.replaceAll("&PROJID", ":projId");
					approveMentor2RequestProjectDetailUpdateQuery = approveMentor2RequestProjectDetailUpdateQuery.replaceAll("&MENTOR2REGSTRID", ":mentor2RegstrId");
					LOGGER.info("approveMentor2RequestProjectDetailUpdateQuery :: "+approveMentor2RequestProjectDetailUpdateQuery);
					Map<String, String> paramMapForProjIdAndMentor2RegstrId = new HashMap<String, String>();
					paramMapForProjIdAndMentor2RegstrId.put("projId", String.valueOf(projId));
					paramMapForProjIdAndMentor2RegstrId.put("mentor2RegstrId", String.valueOf(mentor2RegstrId));
					LOGGER.info("projId :: "+projId);
					LOGGER.info("mentor2RegstrId :: "+mentor2RegstrId);

					int noOfRowsAffected = 0;

					if(approvalStatus.toUpperCase() == "Y" || approvalStatus.equalsIgnoreCase("Y")) {
						noOfRowsAffected = namedParameterJdbcTemplate.update(approveMentor2RequestProjectDetailUpdateQuery, paramMapForProjIdAndMentor2RegstrId);
						if(noOfRowsAffected > 0){
							approveOrDeclineMentorRequestResponse.setStatus("Y");
							LOGGER.info("Team Leader Approved The Mentor Request :: "+approveOrDeclineMentorRequestResponse.getStatus());
						}
					}
					else{
						approveOrDeclineMentorRequestResponse.setStatus("N");
						approveOrDeclineMentorRequestResponse.setDeclineComments(declineComments);
						LOGGER.info("Team Leader Declined The Mentor Request :: "+approveOrDeclineMentorRequestResponse.getStatus());
						LOGGER.info("declineComments :: "+approveOrDeclineMentorRequestResponse.getDeclineComments());
					}

				}

			}else{
				approveOrDeclineMentorRequestResponse.setStatus("N");
				approveOrDeclineMentorRequestResponse.setDeclineComments(declineComments);
				LOGGER.info("Team Leader Declined The Mentor Request :: "+approveOrDeclineMentorRequestResponse.getStatus());
				LOGGER.info("declineComments :: "+approveOrDeclineMentorRequestResponse.getDeclineComments());
			}
		}catch(Exception e){
			LOGGER.error("Error occured while Approve or Reject Mentor Request :"+ e.getMessage());
			throw new ApproveOrDeclineMentorRequestException("Error occured while Approve or Reject Mentor Request : "+ e.getMessage());
		}
		return approveOrDeclineMentorRequestResponse;
	}


	//project macro branches code start here....
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<ProjectMacroBranch> getprojectMacroBranch() throws ProjectMacroBranchException {

		ArrayList<ProjectMacroBranch> projectsMacro = new ArrayList<ProjectMacroBranch>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllProjectMacrobranchQuery = rbundle.getString("GET_ALL_MACRO_BRANCHES_QUERY");
		LOGGER.info("getAllProjectMacrobranchQuery:: "+getAllProjectMacrobranchQuery);

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			//Map<String, String> paramMapForRgstrId = new HashMap<String, String>();
			//paramMapForRgstrId.put("rgstrId", rgstrId);
			projectsMacro = (ArrayList<ProjectMacroBranch>) namedParameterJdbcTemplate.query(getAllProjectMacrobranchQuery,new BeanPropertyRowMapper(ProjectMacroBranch.class));
			/*projectsMacro = (ArrayList<ProjectMacroBranch>) namedParameterJdbcTemplate.query(getAllProjectMacrobranchQuery, new RowMapper<ProjectMacroBranch>(){

					@Override
					public ProjectMacroBranch mapRow(ResultSet rs, int rowNum) throws SQLException {

						ProjectMacroBranch macro = new ProjectMacroBranch();
						macro.setMacro_Branch_Id(rs.getLong("MACRO_BRANCH_ID"));
						macro.setMacro_Branch_Name(rs.getString("MACRO_BRANCH_NAME"));
						macro.setPhotoPath(rs.getString("PHOTOPATH"));


						return macro;
					}

				});*/
		} catch (Exception e) {
			LOGGER.error("Error while getting all Project Macro Branches :", e);
			throw new ProjectMacroBranchException("Error while getting all Project Macro Branches : "+ e.getMessage());
		}

		return projectsMacro;
	}

	//project macro branches code ends here...


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Project> getAllProjectBymacroBranch(DisplayProjectMacroVO  displayProjectMacro) throws GetAllProjectException{

		ArrayList<Project> projectsByMacro= new ArrayList<Project>();
		ArrayList<Branch> projBranches = new ArrayList<Branch>();

		ResourceBundle rbundle=ResourceBundle.getBundle("query");
		String getAllProjectsByMacroQuery=rbundle.getString("GET_ALL_PROJECTS_BY_MACRO_BRANCHES");
		getAllProjectsByMacroQuery = getAllProjectsByMacroQuery.replaceAll("&BRANCHNAME", ":branchName");
		getAllProjectsByMacroQuery = getAllProjectsByMacroQuery.replaceAll("&OFFSETCOUNT", ":offsetCount");
		LOGGER.info("getAllProjectMacrobranchQuery 12355final:: "+getAllProjectsByMacroQuery);

		int initCount = Integer.valueOf(displayProjectMacro.getIterationCount());
		int offsetCount = (initCount*9)-9;

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, Object> paramMapForBranchNameandOffsetCount = new HashMap<String, Object>();
			paramMapForBranchNameandOffsetCount.put("branchName", displayProjectMacro.getBranchName());
			paramMapForBranchNameandOffsetCount.put("offsetCount", offsetCount);
			LOGGER.info("branchName :: "+displayProjectMacro.getBranchName());
			LOGGER.info("offsetCount as int :: "+offsetCount);
			projectsByMacro=(ArrayList<Project>) namedParameterJdbcTemplate.query(getAllProjectsByMacroQuery,paramMapForBranchNameandOffsetCount,new BeanPropertyRowMapper(Project.class));
			for(Project pm : projectsByMacro){

				int projFacultyId=	pm.getProjFacRgstrId();
				long teamLeadid=pm.getProjTeamLeaderId();
				long porjId=pm.getProjId();

				LOGGER.info("projFacultyId :: "+projFacultyId);
				LOGGER.info("teamLeadid :: "+teamLeadid);
				LOGGER.info("porjId :: "+porjId);
				LOGGER.info("projectsByMacro :: "+projectsByMacro);


				//project branch list

				String getBranchDetailsMastBranchQuery = rbundle.getString("GET_BRANCH_DETAILS_MAST_BRANCH_QUERY");
				getBranchDetailsMastBranchQuery = getBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
				LOGGER.info("getBranchDetailsMastBranchQueryMacro :: "+getBranchDetailsMastBranchQuery);

				Map<String, String> paramMapForProjId = new HashMap<String, String>();
				paramMapForProjId.put("projId", Long.toString(porjId));

				projBranches = (ArrayList<Branch>) namedParameterJdbcTemplate.query(getBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<Branch>(){

					@Override
					public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

						Branch branch = new Branch();
						branch.setBranchId(rs.getInt("BRANCH_ID"));
						branch.setBranchName(rs.getString("PROJ_BRANCH_DESC"));
						return branch;
					}

				});
				pm.setProjBranchList(projBranches);

				//Project faculty

				ArrayList<UserProfileVO> projFacultyNames = new ArrayList<UserProfileVO>();
				String getFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY_MACRO");
				getFacultyDetailsUsrMngtMasterQuery = getFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
				LOGGER.info("getFacultyDetailsUsrMngtMasterQueryMacro :: "+getFacultyDetailsUsrMngtMasterQuery);

				Map<String, Object> paramMapForFacultyRegstrId = new HashMap<String, Object>();
				paramMapForFacultyRegstrId.put("projFacRgstrId",projFacultyId);

				LOGGER.info("paramMapForFacultyRegtrId::"+paramMapForFacultyRegstrId);

				projFacultyNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getFacultyDetailsUsrMngtMasterQuery, paramMapForFacultyRegstrId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				if(projFacultyNames.size()>0){
					pm.setProjFacultyName(projFacultyNames.get(0).getFirstName()+" "+projFacultyNames.get(0).getMidName()+" "+projFacultyNames.get(0).getLastName());
				}

				//team leader name

				ArrayList<UserProfileVO> projTeamLeadName = new ArrayList<UserProfileVO>();
				String getTeamLeadNameUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_NAME_USR_MNGT_MASTER_QUERY_MACRO");
				getTeamLeadNameUsrMngtMasterQuery = getTeamLeadNameUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
				LOGGER.info("getTeamLeadMngtMasterQueryMacro :: "+getTeamLeadNameUsrMngtMasterQuery);

				Map<String, String> paramMapForTeamLeadRegstrId = new HashMap<String, String>();
				paramMapForTeamLeadRegstrId.put("projTeamLeaderId", Long.toString(teamLeadid));

				projTeamLeadName = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeadNameUsrMngtMasterQuery, paramMapForTeamLeadRegstrId, new RowMapper<UserProfileVO>(){

					@Override
					public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {

						UserProfileVO userProfileVO = new UserProfileVO();
						userProfileVO.setFirstName(rs.getString("FNAME"));
						userProfileVO.setMidName(rs.getString("MNAME"));
						userProfileVO.setLastName(rs.getString("LNAME"));
						return userProfileVO;
					}

				});
				if(projTeamLeadName.size()>0){
					pm.setProjTeamLeaderName(projTeamLeadName.get(0).getFirstName()+" "+projTeamLeadName.get(0).getMidName()+" "+projTeamLeadName.get(0).getLastName());
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error while getting all Projects by Macro Branches :", e);
			throw new GetAllProjectException("Error while getting all Projects by Macro Branches : "+ e.getMessage());
		}
		return projectsByMacro;

	}



	public ArrayList<Project> getCollegeRecentProjects(String collegeName) throws CollegeRecentProjectsException {

		ArrayList<Project> projects = new ArrayList<Project>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getCollegeRecentProjectsQuery = rbundle.getString("GET_RECENT_PROJECTS_FOR_COLLEGE");
		getCollegeRecentProjectsQuery = getCollegeRecentProjectsQuery.replaceAll("&projCollege", ":projCollege");
		LOGGER.info("getCollegeRecentProjectsQuery :: "+getCollegeRecentProjectsQuery);

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, String> paramMapForCollegeName = new HashMap<String, String>();
			paramMapForCollegeName.put("projCollege", collegeName);
			projects = (ArrayList<Project>) namedParameterJdbcTemplate.query(getCollegeRecentProjectsQuery, paramMapForCollegeName, new RowMapper<Project>(){

				@Override
				public Project mapRow(ResultSet rs, int rowNum) throws SQLException {

					Project project = new Project();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					project.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					project.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					project.setProjIsFacApprove(rs.getString("PROJ_IS_FAC_APPROVE"));
					project.setProjIsMentorAvail(rs.getString("PROJ_IS_MENTOR_AVAIL"));
					project.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					project.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					project.setProjIsForChallenge(rs.getString("PROJ_IS_FOR_CHALLENGE"));
					project.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					project.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					project.setProjTeamId(rs.getLong("TEAM_ID"));
					project.setPhoto1Path(rs.getString("PHOTO1_PATH"));

					return project;
				}

			});
		} catch (Exception e) {
			LOGGER.error("Error while getting all working projects by LoggedInUser :"+ e.getMessage());
			throw new CollegeRecentProjectsException("Error while getting recent projects for college : "+ e.getMessage());
		}

		return projects;
	}


	public ArrayList<Branch> getAllBranches() throws GetAllBranchesException {

		ArrayList<Branch> branches = new ArrayList<Branch>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllbranchesQuery = rbundle.getString("GET_ALL_BRANCHES_QUERY");
		LOGGER.info("getAllbranchesQuery :: "+getAllbranchesQuery);

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			branches = (ArrayList<Branch>) jdbcTemplate.query(getAllbranchesQuery, new RowMapper<Branch>(){

				@Override
				public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

					Branch branch = new Branch();
					branch.setBranchId(rs.getInt("BRANCH_ID"));
					branch.setBranchName(rs.getString("PROJ_BRANCH_DESC"));

					return branch;
				}

			});
		} catch (Exception e) {
			LOGGER.error("Error while getting all Branches :", e);
			throw new GetAllBranchesException("Error while getting all Branches : "+ e.getMessage());
		}

		return branches;
	}

}
