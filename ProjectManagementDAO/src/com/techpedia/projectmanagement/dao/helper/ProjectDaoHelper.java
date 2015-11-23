package com.techpedia.projectmanagement.dao.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import com.techpedia.projectmanagement.entity.ProjectUser;
import com.techpedia.projectmanagement.entity.TeamComment;
import com.techpedia.projectmanagement.entity.TopFiveProjFollowers;
import com.techpedia.projectmanagement.exception.DownloadProjDocException;
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
		String hql ="select cmt.REGSTR_ID RGSTR_ID,(Select IFNULL(umm.FNAME,'') from usr_mngt_master umm where umm.RGSTR_ID=" 
                + " cmt.regstr_id) FNAME,(Select IFNULL(umm.MNAME,'')  from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) MNAME,(Select "
                + " IFNULL(umm.LNAME,'') from usr_mngt_master umm where umm.RGSTR_ID= cmt.regstr_id) LNAME, (select umci.PHOTO from "
                + " usr_mngt_contact_info umci where umci.rgstr_id=cmt.regstr_id) Photo, cmt.proj_id PROJ_ID,(select PROJ_TITLE from " 
                + " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_TITLE,(select proj_team_leader_id from "
                + " tb_tech001_mast_projects_detail xx where xx.proj_id=cmt.proj_id)PROJ_TEAM_LEADER_ID,     team.PROJ_TEAM_DESC PROJ_TEAM_DESC , "
                + " (select uma.State from usr_mngt_addr uma where uma.rgstr_id=cmt.regstr_id) State, (select uma.Country from usr_mngt_addr uma "
                + " where uma.rgstr_id=cmt.regstr_id)Country,(select ums.College from usr_mngt_student ums where ums.rgstr_id=cmt.regstr_id) College "
                + " from tb_tech001_txn_projects_team cmt, tb_tech001_mast_projects_team team where  cmt.team_id = team.team_id and "
                + " cmt.team_id=:team_id";

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
			throw new GetDetailOfTeamException("Error while retrieving the Team details: "+ e.getMessage());
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
				+ "and cmt.proj_id=x.proj_id) and proj_id= :PROJ_ID and IS_ACTIVE_COMMNT = 'Y'";
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
			//log.error("Error while retrieving Project Team Members rgstr Id: " + e.getMessage());
			throw new DownloadProjDocException("Error while retrieving Project Team Members rgstr Id: "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return projTeamMems;
	}

}
