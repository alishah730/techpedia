package com.techpedia.projectmanagement.dao.helper;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.techpedia.projectmanagement.bean.Faculty;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectTeamComment;
import com.techpedia.projectmanagement.bean.ProjectTeamDetailVO;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.entity.Mentor;
import com.techpedia.projectmanagement.entity.ProjectTeamDetail;
import com.techpedia.projectmanagement.entity.TeamComment;
import com.techpedia.projectmanagement.entity.TopFiveProjFollowers;
import com.techpedia.projectmanagement.exception.GetAllMentorsException;
import com.techpedia.projectmanagement.exception.GetDetailOfTeamException;
import com.techpedia.projectmanagement.exception.GetProjectFollowersException;
import com.techpedia.projectmanagement.exception.OtherCommentsNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedFacultyNotFoundException;
import com.techpedia.projectmanagement.exception.SuggestedTeamMembersNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
import com.techpedia.util.HibernateUtil;

public class ProjectDaoHelper {
	
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
		
		if(enrlmtNo != null)
			hql2 = hql2.append(" UMS.ENROLLMENT_NO LIKE :ENROLLMENT_NO AND ");
		if(college != null)
			hql2 = hql2.append(" COLLEGE LIKE :COLLEGE AND ");
		if(fName != null)
			hql2 = hql2.append(" FNAME LIKE :FNAME AND ");
		if(lName != null)
			hql2 = hql2.append(" LNAME LIKE :LNAME AND ");
		if(mName != null)
			hql2 = hql2.append(" MNAME LIKE :MNAME AND ");
		
		String hql3 = " UMM.RGSTR_ID = UMS.RGSTR_ID";
		try {
			
			SQLQuery query  = session.createSQLQuery(hql1+hql2.toString()+hql3);
			
			if(enrlmtNo != null)
				query.setParameter("ENROLLMENT_NO", "%"+enrlmtNo+"%");
			if(college != null)
				query.setParameter("COLLEGE", "%"+college+"%");
			if(fName != null)
				query.setParameter("FNAME", "%"+fName+"%");
			if(lName != null)
				query.setParameter("LNAME", "%"+lName+"%");
			if(mName != null)
				query.setParameter("MNAME", "%"+mName+"%");
			
			suggestedTeamMembers = (ArrayList<Team>) query.list();
		
		} catch (Exception e) {
			//log.error("Error while retrieving the Suggested keywords :" + e.getMessage());
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
		String hql = "SELECT UMM.RGSTR_ID, IFNULL(FNAME,'') AS FNAME, IFNULL(MNAME,'') AS MNAME, IFNULL(LNAME,'') AS LNAME, UMMT.DESIGNATION  FROM "
				+ "USR_MNGT_MASTER AS UMM, USR_MNGT_MENTOR AS UMMT WHERE UMM.RGSTR_ID = ummt.RGSTR_ID ORDER BY RGSTR_ID";
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
					userProfileVOs.add(userProfileVO);
				}
			}
		}catch (Exception e) {
			//log.debug("Error while getting all Mentors : "+ e.getMessage());
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
		String hql = "select proj.proj_id, proj.proj_team_leader_id, proj.proj_guide_id, proj.proj_mentor1_id, "
				+ "proj.proj_mentor2_id, proj.regstr_id, IFNULL(proj.FNAME,'') AS FNAME, IFNULL(proj.MNAME,'') AS MNAME, IFNULL(proj.LNAME,'') AS LNAME, comt.comment_id, comt.proj_comment "
				+ "from((select comment_id, txn_project_comment.regstr_id, txn_projects_team.proj_id, proj_comment "
				+ "from tb_tech001_txn_projects_team txn_projects_team, tb_tech001_txn_project_comment "
				+ "txn_project_comment	WHERE txn_projects_team.regstr_id = txn_project_comment.regstr_id "
				+ "and txn_projects_team.PROJ_ID = txn_project_comment.PROJ_ID and IS_ACTIVE_COMMNT = 'Y' "
				+ "GROUP BY comment_id, txn_project_comment.regstr_id, txn_projects_team.proj_id, proj_comment "
				+ "ORDER BY  comment_id) comt, (select mpd.proj_id, proj_team_leader_id, proj_guide_id, proj_mentor1_id, "
				+ "proj_mentor2_id,	tpt.regstr_id, IFNULL(FNAME,'') AS FNAME, IFNULL(MNAME,'') AS MNAME, IFNULL(LNAME,'') AS LNAME from  tb_tech001_mast_projects_detail mpd, "
				+ "tb_tech001_txn_projects_team tpt, usr_mngt_master umm where	mpd.proj_id = tpt.proj_id and "
				+ "tpt.REGSTR_ID = umm.RGSTR_ID) proj) where comt.regstr_id=proj.regstr_id and comt.PROJ_ID = "
				+ "proj.PROJ_ID and proj.PROJ_ID = :PROJ_ID order by comt.comment_id";
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
			//log.error("Error while retrieving the Team Comments: " + e.getMessage());
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
		String hql = "select -1 PROJ_TEAM_LEADER_ID,-1 PROJ_ID,'-1' PROJ_TITLE, '-1' PROJ_TEAM_DESC, umm.rgstr_Id "
				+ "RGSTR_ID, IFNULL(FNAME,'') AS FNAME, IFNULL(MNAME,'') AS MNAME, IFNULL(LNAME,'') AS LNAME, PHOTO, STATE, COUNTRY, COLLEGE from usr_mngt_master umm, usr_mngt_addr"
				+ " uma, usr_mngt_student ums, usr_mngt_contact_info umci where	 umm.rgstr_Id in (select regstr_Id "
				+ "from tb_tech001_txn_projects_team where team_id = :team_id) and umm.rgstr_Id = uma.rgstr_Id and "
				+ "umm.rgstr_Id = ums.rgstr_Id and umm.rgstr_Id = umci.rgstr_Id union select DISTINCT "
				+ "PROJ_TEAM_LEADER_ID, PROJ_D.PROJ_ID, PROJ_D.PROJ_TITLE, PROJ_TEAM_DESC, '-1' RGSTR_ID, "
				+ "'-1' FNAME, '-1' MNAME, '-1' LNAME, '-1' PHOTO, '-1' STATE, '-1' COUNTRY, '-1' COLLEGE "
				+ "from tb_tech001_mast_projects_detail PROJ_D, tb_tech001_txn_projects_team PROJ_T, "
				+ "tb_tech001_mast_projects_team PROJ_TEAM where PROJ_D.proj_id = PROJ_T.proj_id AND "
				+ "PROJ_D.team_id = PROJ_TEAM.team_id AND PROJ_T.team_id = :team_id";
		try {			
			SQLQuery query  = session.createSQLQuery(hql);
			query.setParameter("team_id", Long.valueOf(teamId));
			query.addEntity(ProjectTeamDetail.class);
			projectTeamDetails = (ArrayList<ProjectTeamDetail>) query.list();
			for(ProjectTeamDetail teamDetail:projectTeamDetails){				
				projectTeamDetailVO = new ProjectTeamDetailVO();
				if(!teamDetail.getTeamMemFName().equals("-1"))
					projectTeamDetailVO.setTeamMemFName(teamDetail.getTeamMemFName());
				if(!teamDetail.getTeamMemMName().equals("-1"))
					projectTeamDetailVO.setTeamMemMName(teamDetail.getTeamMemMName());
				if(!teamDetail.getTeamMemLName().equals("-1"))
					projectTeamDetailVO.setTeamMemLName(teamDetail.getTeamMemLName());
				if(!teamDetail.getCollege().equals("-1"))
					projectTeamDetailVO.setCollege(teamDetail.getCollege());	
				if(!teamDetail.getCountry().equals("-1"))
					projectTeamDetailVO.setCountry(teamDetail.getCountry());
				if(!teamDetail.getState().equals("-1"))
					projectTeamDetailVO.setState(teamDetail.getState());				
				if(teamDetail.getPhoto()!="-1")				
					projectTeamDetailVO.setPhoto(teamDetail.getPhoto());				
				if(teamDetail.getRgstrId()!=-1)					
					projectTeamDetailVO.setTeamMemRegstrId(teamDetail.getRgstrId());
				if(teamDetail.getTeamLeaderId()!=-1){					
					teamLeadId = teamDetail.getTeamLeaderId();
				}
				if(teamDetail.getProjTeamName()!="-1")			
					teamName = teamDetail.getProjTeamName();
				if(teamDetail.getProjId()!=-1)			
					projId = teamDetail.getProjId();
				if(teamDetail.getProjTitle()!="-1")			
					projTitle = teamDetail.getProjTitle();
				
				if(projectTeamDetailVO.getTeamMemFName() != null)
					projectTeamDetailVOs.add(projectTeamDetailVO);
			}
			
			for(ProjectTeamDetailVO teamDetailVO:projectTeamDetailVOs){
				teamDetailVO.setTeamLeaderId(teamLeadId);
				teamDetailVO.setProjTeamName(teamName);
				teamDetailVO.setProjId(projId);
				teamDetailVO.setProjTitle(projTitle);
			}
			
			
		} catch (Exception e) {
			//log.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new GetDetailOfTeamException("Error while retrieving the Team Comments: "+ e.getMessage());
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
		String hql = "select a.*, IFNULL(usr.FNAME,'') AS FNAME, IFNULL(usr.MNAME,'') AS MNAME, IFNULL(usr.LNAME,'') AS LNAME from (select proj.proj_id,proj_team_leader_id, "
				+ "proj_guide_id, proj_mentor1_id, proj_mentor2_id, cmt.regstr_id,comment_id, proj_comment from "
				+ "tb_tech001_mast_projects_detail proj, tb_tech001_txn_project_comment cmt where "
				+ "proj.PROJ_ID=cmt.PROJ_ID and not exists (select 1 from tb_tech001_txn_projects_team team where "
				+ "cmt.proj_id = team.proj_id and cmt.REGSTR_ID = team.REGSTR_ID) and not exists (select 1 "
				+ "from tb_tech001_mast_projects_detail x where x.proj_team_leader_id = cmt.REGSTR_ID or "
				+ "x.proj_guide_id = cmt.REGSTR_ID or x.proj_mentor1_id = cmt.REGSTR_ID or x.proj_mentor2_id = "
				+ "cmt.REGSTR_ID) and proj.PROJ_ID = :PROJ_ID)A, usr_mngt_master Usr where a.regstr_id=usr.rgstr_id";
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
			//log.error("Error while retrieving the Team Comments: " + e.getMessage());
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
		int maxResultSize = 5;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT count(tpf.proj_id) count, mpd.proj_id, proj_title, proj_description  FROM "
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
				projects.add(project);
			}
						
		} catch (Exception e) {
			//log.error("Error while retrieving the Team Comments: " + e.getMessage());
			throw new GetProjectFollowersException("Error while retrieving the other Comments: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projects;
	}

}
