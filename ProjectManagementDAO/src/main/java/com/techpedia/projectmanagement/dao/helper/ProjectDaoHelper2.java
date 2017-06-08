/**
 * 
 */
package com.techpedia.projectmanagement.dao.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Statement;
import com.techpedia.projectmanagement.bean.Branch;
import com.techpedia.projectmanagement.bean.GYTIProjectStatisticsVO;
import com.techpedia.projectmanagement.bean.GetAllGytiProjectByLoggedInReviewerResponse;
import com.techpedia.projectmanagement.bean.GetReviewRatingVO;
import com.techpedia.projectmanagement.bean.GytiProjectVO;
import com.techpedia.projectmanagement.bean.ProjectGytiAddInfo;
import com.techpedia.projectmanagement.bean.ReviewRatingVO;
import com.techpedia.projectmanagement.bean.SubmitInnovationToGytiVO;
import com.techpedia.projectmanagement.bean.SuggestReviewerVO;
import com.techpedia.projectmanagement.bean.SuggestedProjectForReviewByLoggedInReviewerVO;
import com.techpedia.projectmanagement.bean.Team;
import com.techpedia.projectmanagement.bean.TotalProjectsStatisticsVO;
import com.techpedia.projectmanagement.bean.TotalProjectsYearWiseStatisticsVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.bean.UsrMngtStudentVO;
import com.techpedia.projectmanagement.exception.GetAllGytiProjectException;
import com.techpedia.projectmanagement.exception.GetGYTIProjectStatisticsException;
import com.techpedia.projectmanagement.exception.GetGytiProjectRatingDetailsException;
import com.techpedia.projectmanagement.exception.GetProjectDetailsException;
import com.techpedia.projectmanagement.exception.GetSuggestedReviewersException;
import com.techpedia.projectmanagement.exception.GytiInnovationCountException;
import com.techpedia.projectmanagement.exception.GytiReviewedInnovationCountException;
import com.techpedia.projectmanagement.exception.RejectSuggestedProjectForReviewException;
import com.techpedia.projectmanagement.exception.ReviewRatingException;
import com.techpedia.projectmanagement.exception.SubmitAcademicProjectToGytiException;
import com.techpedia.projectmanagement.exception.SubmitProjectToGytiException;
import com.techpedia.projectmanagement.exception.SuggestReviewerException;
import com.techpedia.projectmanagement.exception.TotalProectsStatisticsException;
import com.techpedia.projectmanagement.exception.TotalProectsYearWiseStatisticsException;
import com.techpedia.projectmanagement.exception.UpdateGytiInnovationException;
import com.techpedia.projectmanagement.exception.updateGytiProjectReviewRatingException;

/**
 * @author 455959
 *
 */
@Component
public class ProjectDaoHelper2 {

	@Autowired
	private DataSource dataSource;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDaoHelper2.class.getName());
	
	public String submitAcademicProjectToGyti(ProjectGytiAddInfo gytiAddInfo) throws SubmitAcademicProjectToGytiException {

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiAdditionalInfoMasterGytiDetailInsertQuery = rbundle.getString("GYTI_ADDITIONAL_INFO_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_INSERT_QUERY");
		String projectAwardInfoInsertQuery = rbundle.getString("PROJECT_AWARD_INFO_INSERT_QUERY");
		String projectStatusInfoUpdateQuery = rbundle.getString("PROJECT_STATUS_INFO_UPDATE_QUERY");
		projectStatusInfoUpdateQuery = projectStatusInfoUpdateQuery.replaceAll("&projId", ":projId");
		LOGGER.info("gytiAdditionalInfoMasterGytiDetailInsertQuery :: "+gytiAdditionalInfoMasterGytiDetailInsertQuery);
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String sql = "select count(*) from techpedia.TB_TECH001_MAST_PROJECTS_DETAIL where proj_id= ?";
			long projId = gytiAddInfo.getProjId();
			int rowCount = jdbcTemplate.queryForObject(sql, new Object[] {projId},Integer.class);
			if (rowCount > 0){
				gytiAddInfo.setProjAppliedAwards("GYTI");
				jdbcTemplate.update(gytiAdditionalInfoMasterGytiDetailInsertQuery, new PreparedStatementSetter(){

					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setLong(1,gytiAddInfo.getProjId());
						ps.setString(2, gytiAddInfo.getProjAppliedAwards());
						ps.setString(3, gytiAddInfo.getProjGuideName());
						ps.setString(4, gytiAddInfo.getProjGuideEmail());
						ps.setString(5, gytiAddInfo.getProjGuideMobile());
						ps.setString(6, gytiAddInfo.getProjAcademicProgram());
						ps.setString(7, gytiAddInfo.getProjStatusInfo());
						ps.setString(8, gytiAddInfo.getProjCopyrightInfo());
						ps.setString(9, gytiAddInfo.getProjProofInfo());
						ps.setString(10, gytiAddInfo.getOtherDistinguishablePatents());
						ps.setString(11, gytiAddInfo.getProjFeature());
						ps.setString(12, gytiAddInfo.getProjFrugalityInfo());
						ps.setString(13, gytiAddInfo.getProjObjectiveInfo());
						ps.setString(14, gytiAddInfo.getProjContributeInfo());
						ps.setString(15, gytiAddInfo.getProjImpactInfo());
						ps.setString(16, gytiAddInfo.getProjRequiredResource());
						ps.setString(17, gytiAddInfo.getProjResearchContinue());
						ps.setString(18, gytiAddInfo.getProjPatentWork());
						ps.setString(19, gytiAddInfo.getProjPublishedPaper());
						ps.setString(20, gytiAddInfo.getProjOtherInfo());
						ps.setString(21, gytiAddInfo.getProjBenefitInfo());
						ps.setString(22, gytiAddInfo.getProjPreviousAwardYear());
						ps.setString(23, gytiAddInfo.getNominatedBy());
						ps.setString(24, gytiAddInfo.getPublishOnWebsite());
						ps.setString(25, gytiAddInfo.getProjObjectiveInfoArea());
						ps.setString(26, gytiAddInfo.getProjPhotoVideoNewsOthers());
						ps.setString(27, gytiAddInfo.getProjFinishYear());
					}

				});
			/*	LOGGER.info("projectAwardInfoInsertQuery :: "+ projectAwardInfoInsertQuery);
				jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, gytiAddInfo.getProjId());
						ps.setLong(2, 1);
						ps.setString(3, gytiAddInfo.getProjAwardYear());
						ps.setString(4, "N");

					}
				});*/
				LOGGER.info("projectAwardInfoInsertQuery for latest:: "+ projectAwardInfoInsertQuery);
				jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, gytiAddInfo.getProjId());
						ps.setLong(2, 1);
						ps.setString(3,  Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
						ps.setString(4, "N");

					}
				});
				LOGGER.info("projectStatusInfoUpdateQuery :: "+ projectStatusInfoUpdateQuery);
				Map<String, Object> paramMapForProjectId = new HashMap<String, Object>();
				paramMapForProjectId.put("projId", gytiAddInfo.getProjId());
				namedParameterjdbcTemplate.update(projectStatusInfoUpdateQuery, paramMapForProjectId);
			}
			else{
				throw new SubmitAcademicProjectToGytiException("Error while Inserting Additional Gyti Info", "Project with project Id "+gytiAddInfo.getProjId()+"Not found");
			}
		}catch(Exception e) {
			LOGGER.error("Error while Inserting Additional Gyti Info :", e);
			throw new SubmitAcademicProjectToGytiException("Error while Inserting Additional Gyti Info : "+ e.getMessage());
		}
		return "Y";
	}

	public String submitProjectToGyti(SubmitInnovationToGytiVO innovationInfo) throws SubmitProjectToGytiException {

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiInfoProjectMasterDetailInsertQuery = rbundle.getString("GYTI_INFO_TB_TECH001_MAST_PROJECTS_DETAIL_INSERT_QUERY");
		String gytiInfoTeamMasterDetailInsertQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_team_INSERT_QUERY");
		String gytiInfoKeywordMasterDetailInsertQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_keywrd_INSERT_QUERY");
		String gytiInfoBranchMasterDetailInsertQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_brnch_INSERT_QUERY");
		String gytiInfoTeanTxnDetailInsertQuery = rbundle.getString("GYTI_INFO_tb_tech001_txn_projects_team_INSERT_QUERY");
		String gytiAdditionalInfoMasterGytiDetailInsertQuery = rbundle.getString("GYTI_ADDITIONAL_INFO_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_INSERT_QUERY");
		String projectAwardInfoInsertQuery = rbundle.getString("PROJECT_AWARD_INFO_INSERT_QUERY");

		try{
			KeyHolder holder = new GeneratedKeyHolder();	
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

			LOGGER.info("gytiInfoTeamMasterDetailInsertQuery :: "+gytiInfoTeamMasterDetailInsertQuery);
			String teamName = "";
			if(innovationInfo.getProjTeamDesc().trim().equalsIgnoreCase("")){
				if(innovationInfo.getProjTitle().trim().length()>10){
					teamName = innovationInfo.getProjTitle().trim().substring(0, 10)+"_Team";
				}else{
					teamName = innovationInfo.getProjTitle().trim()+"_Team";
				}
			}else{
				teamName = innovationInfo.getProjTeamDesc().trim();
			}
			innovationInfo.setProjTeamDesc(teamName);
			LOGGER.info("teamName"+teamName);
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps =con.prepareStatement(gytiInfoTeamMasterDetailInsertQuery, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, innovationInfo.getProjTeamDesc());	
					return ps;
				}
			},holder);
			innovationInfo.setProjTeamId(holder.getKey().longValue());

			KeyHolder holder1 = new GeneratedKeyHolder();
			LOGGER.info("gytiInfoProjectMasterDetailInsertQuery :: "+gytiInfoProjectMasterDetailInsertQuery);
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					PreparedStatement ps =con.prepareStatement(gytiInfoProjectMasterDetailInsertQuery, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, innovationInfo.getProjTitle());
					ps.setString(2, innovationInfo.getProjAbstract());
					ps.setString(3, innovationInfo.getProjDescription());
					ps.setString(4, innovationInfo.getProjUniversity());
					ps.setInt(5, innovationInfo.getProjYear());
					ps.setInt(6, innovationInfo.getProjDuration());
					ps.setString(7, innovationInfo.getProjCollegeState());
					ps.setDate(8, new java.sql.Date(Long.parseLong(innovationInfo.getProjStartDate())));
					ps.setDate(9, new java.sql.Date(Long.parseLong(innovationInfo.getProjEndDate())));
					ps.setLong(10, innovationInfo.getProjTeamId());
					ps.setLong(11, innovationInfo.getProjEstimationCost());
					ps.setLong(12, innovationInfo.getProjTeamLeaderId());
					ps.setString(13, innovationInfo.getProjCollege());
					ps.setInt(14, 0);
					//ps.setLong(15, innovationInfo.getProjFaculty());
					ps.setInt(15, 11);
					return ps;
				}
			},holder1);
			innovationInfo.setProjId(holder1.getKey().longValue());

			for(String projKeyword:innovationInfo.getProjKeywords()){
				LOGGER.info("gytiInfoKeywordMasterDetailInsertQuery :: "+gytiInfoKeywordMasterDetailInsertQuery);
				jdbcTemplate.update(gytiInfoKeywordMasterDetailInsertQuery, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, innovationInfo.getProjId());
						ps.setString(2, projKeyword);	
					}
				});
			}

			for(int projBranch:innovationInfo.getProjBranches()){
				LOGGER.info("gytiInfoBranchMasterDetailInsertQuery :: "+gytiInfoBranchMasterDetailInsertQuery);
				jdbcTemplate.update(gytiInfoBranchMasterDetailInsertQuery, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, innovationInfo.getProjId());
						ps.setInt(2, projBranch);	
					}
				});
			}

			for(Long projTeamMemId:innovationInfo.getProjTeamMembers()){
				LOGGER.info("gytiInfoTeanTxnDetailInsertQuery :: "+gytiInfoTeanTxnDetailInsertQuery);
				jdbcTemplate.update(gytiInfoTeanTxnDetailInsertQuery, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, innovationInfo.getProjId());
						ps.setLong(2, projTeamMemId);
						ps.setLong(3, innovationInfo.getProjTeamId());	
					}
				});
			}

			LOGGER.info("gytiAdditionalInfoMasterGytiDetailInsertQuery :: "+gytiAdditionalInfoMasterGytiDetailInsertQuery);
			innovationInfo.setProjAppliedAwards("GYTI");
			jdbcTemplate.update(gytiAdditionalInfoMasterGytiDetailInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1,innovationInfo.getProjId());
					ps.setString(2, innovationInfo.getProjAppliedAwards());
					ps.setString(3, innovationInfo.getProjGuideName());
					ps.setString(4, innovationInfo.getProjGuideEmail());
					ps.setString(5, innovationInfo.getProjGuideMobile());
					ps.setString(6, innovationInfo.getProjAcademicProgram());
					ps.setString(7, innovationInfo.getProjStatusInfo());
					ps.setString(8, innovationInfo.getProjCopyrightInfo());
					ps.setString(9, innovationInfo.getProjProofInfo());
					ps.setString(10, innovationInfo.getOtherDistinguishablePatents());
					ps.setString(11, innovationInfo.getProjFeature());
					ps.setString(12, innovationInfo.getProjFrugalityInfo());
					ps.setString(13, innovationInfo.getProjObjectiveInfo());
					ps.setString(14, innovationInfo.getProjContributeInfo());
					ps.setString(15, innovationInfo.getProjImpactInfo());
					ps.setString(16, innovationInfo.getProjRequiredResource());
					ps.setString(17, innovationInfo.getProjResearchContinue());
					ps.setString(18, innovationInfo.getProjPatentWork());
					ps.setString(19, innovationInfo.getProjPublishedPaper());
					ps.setString(20, innovationInfo.getProjOtherInfo());
					ps.setString(21, innovationInfo.getProjBenefitInfo());
					ps.setString(22, innovationInfo.getProjAwardYear());
					ps.setString(23, innovationInfo.getNominatedBy());
					ps.setString(24, innovationInfo.getPublishOnWebsite());
					ps.setString(25, innovationInfo.getProjObjectiveInfoArea());
					ps.setString(26, innovationInfo.getProjPhotoVideoNewsOthers());
					ps.setString(27, innovationInfo.getProjFinishYear());
				}

			});

			/*LOGGER.info("projectAwardInfoInsertQuery :: "+ projectAwardInfoInsertQuery);
			jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setLong(1, innovationInfo.getProjId());
					ps.setLong(2, 1);
					ps.setString(3, innovationInfo.getProjAwardYear());
					ps.setString(4, "N");

				}
			});*/
			LOGGER.info("projectAwardInfoInsertQuery for latest:: "+ projectAwardInfoInsertQuery);
			jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setLong(1, innovationInfo.getProjId());
					ps.setLong(2, 1);
					ps.setString(3,  Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
					ps.setString(4, "N");

				}
			});
		}catch(Exception e) {
			LOGGER.error("Error while submitting Innovation to GYTI :", e);
			//e.printStackTrace();
			throw new SubmitProjectToGytiException("Error while submitting Innovation to GYTI : "+ e.getMessage());
		}
		return "Y";
	}

	public SubmitInnovationToGytiVO getgytiProjectDetails(long projId) throws GetProjectDetailsException{
		SubmitInnovationToGytiVO gytiProjectDetails = new SubmitInnovationToGytiVO();

		ResourceBundle rbundle=ResourceBundle.getBundle("query");
		String getGytiProjectDetailQuery=rbundle.getString("GET_GYTI_PROJECT_DETAIL_QUERY");
		getGytiProjectDetailQuery = getGytiProjectDetailQuery.replaceAll("&projId", ":projId");
		LOGGER.info("getGytiProjectDetailQuery :: "+getGytiProjectDetailQuery);


		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, Object> paramMapForprojId = new HashMap<String, Object>();
			paramMapForprojId.put("projId", projId);
			gytiProjectDetails= (SubmitInnovationToGytiVO) namedParameterJdbcTemplate.queryForObject(getGytiProjectDetailQuery,paramMapForprojId,new RowMapper<SubmitInnovationToGytiVO>(){
				public SubmitInnovationToGytiVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					SubmitInnovationToGytiVO submitInnovationToGytiVO = new SubmitInnovationToGytiVO();
					submitInnovationToGytiVO.setProjId(rs.getLong("PROJ_ID"));
					submitInnovationToGytiVO.setProjTitle(rs.getString("PROJ_TITLE"));
					submitInnovationToGytiVO.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					submitInnovationToGytiVO.setProjAbstract(rs.getString("PROJ_ABSTRACT"));
					submitInnovationToGytiVO.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					submitInnovationToGytiVO.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					submitInnovationToGytiVO.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					submitInnovationToGytiVO.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					submitInnovationToGytiVO.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					submitInnovationToGytiVO.setProjTeamId(rs.getLong("TEAM_ID"));
					submitInnovationToGytiVO.setPhoto1Path(rs.getString("PHOTO1_PATH"));
					submitInnovationToGytiVO.setPhoto2Path(rs.getString("PHOTO2_PATH"));
					submitInnovationToGytiVO.setProjEstimationCost(rs.getLong("PROJ_ESTIMATED_COST"));
					submitInnovationToGytiVO.setProjDuration(rs.getInt("PROJ_DURATION"));
					submitInnovationToGytiVO.setProjYear(rs.getInt("PROJ_YEAR"));
					submitInnovationToGytiVO.setProjStartDate(rs.getDate("PROJ_START_DATE").toString());
					submitInnovationToGytiVO.setProjEndDate(rs.getDate("PROJ_END_DATE").toString());
					submitInnovationToGytiVO.setProjCollege(rs.getString("PROJ_COLLEGE"));
					return submitInnovationToGytiVO;

				}
			});
			//project branch list
			ArrayList<Branch> projBranches = new ArrayList<Branch>();
			String getBranchDetailsForGytiProjectQuery = rbundle.getString("GET_BRANCH_DETAILS_FOR_GYTI_PROJECT_QUERY");
			getBranchDetailsForGytiProjectQuery = getBranchDetailsForGytiProjectQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getBranchDetailsForGytiProjectQuery :: "+getBranchDetailsForGytiProjectQuery);

			Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
			paramMapForProjId.put("projId", projId);

			projBranches = (ArrayList<Branch>) namedParameterJdbcTemplate.query(getBranchDetailsForGytiProjectQuery, paramMapForProjId, new RowMapper<Branch>(){

				@Override
				public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {

					Branch branch = new Branch();
					branch.setBranchId(rs.getInt("BRANCH_ID"));
					branch.setBranchName(rs.getString("PROJ_BRANCH_DESC"));
					return branch;
				}

			});
			gytiProjectDetails.setProjBranchList(projBranches);
			//project keywords
			ArrayList<String> projKeywordList = new ArrayList<String>();
			String getKeywordsForGytiProjectQuery = rbundle.getString("GET_KEYWORDS_FOR_GYTI_PROJECT_QUERY");
			getKeywordsForGytiProjectQuery = getKeywordsForGytiProjectQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getKeywordsForGytiProjectQuery :: "+getKeywordsForGytiProjectQuery);


			projKeywordList = (ArrayList<String>) namedParameterJdbcTemplate.query(getKeywordsForGytiProjectQuery, paramMapForProjId, new RowMapper<String>(){

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {

					String projKeyword = new String();
					projKeyword = rs.getString("PROJ_KEYWORD");
					return projKeyword;
				}

			});
			gytiProjectDetails.setProjKeywords(projKeywordList);
			//Project faculty
			ArrayList<UserProfileVO> projFacultyNames = new ArrayList<UserProfileVO>();
			String getFacultyDetailsUsrMngtMasterQuery = rbundle.getString("GET_FACULTY_DETAILS_USR_MNGT_MASTER_QUERY");
			getFacultyDetailsUsrMngtMasterQuery = getFacultyDetailsUsrMngtMasterQuery.replace("&PROJ_FAC_RGSTR_ID", ":projFacRgstrId");
			LOGGER.info("getFacultyDetailsUsrMngtMasterQuery :: "+getFacultyDetailsUsrMngtMasterQuery);

			Map<String, Object> paramMapForFacultyRegstrId = new HashMap<String, Object>();
			paramMapForFacultyRegstrId.put("projFacRgstrId",gytiProjectDetails.getProjFaculty());

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
				if(projFacultyNames.get(0).getMidName()==null){
					gytiProjectDetails.setProjFacultyName(projFacultyNames.get(0).getFirstName()+" "+projFacultyNames.get(0).getLastName());
				}
				else{
					gytiProjectDetails.setProjFacultyName(projFacultyNames.get(0).getFirstName()+" "+projFacultyNames.get(0).getMidName()+" "+projFacultyNames.get(0).getLastName());
				}
			}

			//team members
			ArrayList<Team> teamMemberList = new ArrayList<Team>();

			String getGytiTeamMembersQuery = rbundle.getString("GET_GYTI_PROJECT_TEAM_MEMBERS_QUERY");
			getGytiTeamMembersQuery = getGytiTeamMembersQuery.replace("&projId", ":projId");
			teamMemberList= (ArrayList<Team>) namedParameterJdbcTemplate.query(getGytiTeamMembersQuery, paramMapForProjId,new RowMapper<Team>() {
				public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
					Team team= new Team();
					team.setTeamMemberRgstrId(rs.getLong("RGSTR_ID"));
					team.setTeamMemberName(rs.getString("FACULTY_NAME"));
					return team;
				}
			});
			gytiProjectDetails.setProjTeamMemberList(teamMemberList);
			//Additional Info for Gyti
			ProjectGytiAddInfo addGytiInfo = new ProjectGytiAddInfo();

			String getGytiAddInfoQuery = rbundle.getString("GET_GYTI_ADD_INFO_QUERY");
			getGytiAddInfoQuery = getGytiAddInfoQuery.replace("&projId", ":projId");
			LOGGER.info("getGytiAddInfoQuery :: "+getGytiAddInfoQuery);
			addGytiInfo= (ProjectGytiAddInfo) namedParameterJdbcTemplate.queryForObject(getGytiAddInfoQuery, paramMapForprojId,new BeanPropertyRowMapper<ProjectGytiAddInfo>(ProjectGytiAddInfo.class));

			gytiProjectDetails.setProjAcademicProgram(addGytiInfo.getProjAcademicProgram());
			gytiProjectDetails.setProjStatusInfo(addGytiInfo.getProjStatusInfo());
			gytiProjectDetails.setProjCopyrightInfo(addGytiInfo.getProjCopyrightInfo());
			gytiProjectDetails.setProjProofInfo(addGytiInfo.getProjProofInfo());
			gytiProjectDetails.setOtherDistinguishablePatents(addGytiInfo.getOtherDistinguishablePatents());
			gytiProjectDetails.setProjFeature(addGytiInfo.getProjFeature());
			gytiProjectDetails.setProjFrugalityInfo(addGytiInfo.getProjFrugalityInfo());
			gytiProjectDetails.setProjObjectiveInfo(addGytiInfo.getProjObjectiveInfo());
			gytiProjectDetails.setProjContributeInfo(addGytiInfo.getProjContributeInfo());
			gytiProjectDetails.setProjImpactInfo(addGytiInfo.getProjImpactInfo());
			gytiProjectDetails.setProjRequiredResource(addGytiInfo.getProjRequiredResource());
			gytiProjectDetails.setProjResearchContinue(addGytiInfo.getProjResearchContinue());
			gytiProjectDetails.setProjPatentWork(addGytiInfo.getProjPatentWork());
			gytiProjectDetails.setProjPublishedPaper(addGytiInfo.getProjPublishedPaper());
			gytiProjectDetails.setProjOtherInfo(addGytiInfo.getProjOtherInfo());
			gytiProjectDetails.setProjBenefitInfo(addGytiInfo.getProjBenefitInfo());
			gytiProjectDetails.setProjAwardYear(addGytiInfo.getProjPreviousAwardYear());
			gytiProjectDetails.setProjGuideName(addGytiInfo.getProjGuideName());
			gytiProjectDetails.setProjGuideEmail(addGytiInfo.getProjGuideEmail());
			gytiProjectDetails.setProjGuideMobile(addGytiInfo.getProjGuideMobile());
			gytiProjectDetails.setNominatedBy(addGytiInfo.getNominatedBy());
			gytiProjectDetails.setPublishOnWebsite(addGytiInfo.getPublishOnWebsite());
			gytiProjectDetails.setProjObjectiveInfoArea(addGytiInfo.getProjObjectiveInfoArea());
			gytiProjectDetails.setProjPhotoVideoNewsOthers(addGytiInfo.getProjPhotoVideoNewsOthers());
			gytiProjectDetails.setProjFinishYear(addGytiInfo.getProjFinishYear());
/*			//project award year
			String getAwardYearForGytiProjectQuery = rbundle.getString("GET_AWARD_YEAR_FOR_GYTI_PROJECT_QUERY");
			getAwardYearForGytiProjectQuery = getAwardYearForGytiProjectQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("GET_AWARD_YEAR_FOR_GYTI_PROJECT_QUERY :: "+getAwardYearForGytiProjectQuery);

			String awardYear = namedParameterJdbcTemplate.queryForObject(getAwardYearForGytiProjectQuery, paramMapForprojId, String.class);*/

			

		} catch (Exception e) {
			LOGGER.error("Error while getting GYTI Project details :", e);
			throw new GetProjectDetailsException("Error while getting GYTI Project details : "+ e.getMessage());
		}
		return gytiProjectDetails;

	}

	public ArrayList<GytiProjectVO> getAllGytiProject(int iterationCount) throws GetAllGytiProjectException{

		ArrayList<GytiProjectVO> gytiProjects = new ArrayList<GytiProjectVO>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllGytiProjectAwardGytiDetailQuery = rbundle.getString("GET_ALL_GYTI_PROJECT_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_QUERY");
		getAllGytiProjectAwardGytiDetailQuery = getAllGytiProjectAwardGytiDetailQuery.replaceAll("&OFFSETCOUNT", ":offsetCount");
		LOGGER.info("getAllGytiProjectAwardGytiDetailQuery :: "+getAllGytiProjectAwardGytiDetailQuery);

		int initCount = Integer.valueOf(iterationCount);
		int offsetCount = (initCount*9)-9;

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			Map<String, Object> paramMapForOffsetCount = new HashMap<String, Object>();
			paramMapForOffsetCount.put("offsetCount", offsetCount);
			LOGGER.info("offsetCount as int :: "+offsetCount);
			gytiProjects = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectAwardGytiDetailQuery, paramMapForOffsetCount, new RowMapper<GytiProjectVO>(){

				@Override
				public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					GytiProjectVO gytiProject = new GytiProjectVO();
					gytiProject.setProjId(rs.getLong("PROJ_ID"));
					gytiProject.setProjAppliedAwards(rs.getString("PROJ_APPLIED_AWARDS"));
					gytiProject.setProjGuideName(rs.getString("PROJ_GUIDE_NAME"));
					gytiProject.setProjGuideEmail(rs.getString("PROJ_GUIDE_EMAIL"));
					gytiProject.setProjGuideMobile(rs.getString("PROJ_GUIDE_MOBILE"));
					gytiProject.setProjAcademicProgram(rs.getString("PROJ_ACADEMIC_PROGRAM"));
					gytiProject.setProjStatusInfo(rs.getString("PROJ_STATUS_INFO"));
					gytiProject.setProjCopyrightInfo(rs.getString("PROJ_COPYRIGHT_INFO"));
					gytiProject.setProjProofInfo(rs.getString("PROJ_PROOF_INFO"));
					gytiProject.setOtherDistinguishablePatents(rs.getString("OTHER_DISTINGUISHABLE_PATENTS"));
					gytiProject.setProjFeature(rs.getString("PROJ_FEATURE"));
					gytiProject.setProjFrugalityInfo(rs.getString("PROJ_FRUGALITY_INFO"));
					gytiProject.setProjObjectiveInfo(rs.getString("PROJ_OBJECTIVE_INFO"));
					gytiProject.setProjContributeInfo(rs.getString("PROJ_CONTRIBUTE_INFO"));
					gytiProject.setProjImpactInfo(rs.getString("PROJ_IMPACT_INFO"));
					gytiProject.setProjRequiredResource(rs.getString("PROJ_REQUIRED_RESOURCE"));
					gytiProject.setProjResearchContinue(rs.getString("PROJ_RESEARCH_CONTINUE"));
					gytiProject.setProjPatentWork(rs.getString("PROJ_PATENT_WORK"));
					gytiProject.setProjPublishedPaper(rs.getString("PROJ_PUBLISHED_PAPER"));
					gytiProject.setProjOtherInfo(rs.getString("PROJ_OTHER_INFO"));
					gytiProject.setProjBenefitInfo(rs.getString("PROJ_BENEFIT_INFO"));
					return gytiProject;
				}

			});
			List<Long> projIds = new ArrayList<Long>();
			
			if(gytiProjects.size()>0){
				
				for(GytiProjectVO gytiProjectVO : gytiProjects){
					projIds.add(gytiProjectVO.getProjId());
					LOGGER.info("projId :: "+gytiProjectVO.getProjId());
				}
	
				//Get the project details by using PROJ_ID 
				ArrayList<GytiProjectVO> gytiProjectVOs = new ArrayList<GytiProjectVO>();
	
				String getAllGytiProjectDetailsQuery = rbundle.getString("GET_ALL_GYTI_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
				getAllGytiProjectDetailsQuery = getAllGytiProjectDetailsQuery.replaceAll("&PROJIDS", ":projIds");
				LOGGER.info("getProjectDetailsQuery :: "+getAllGytiProjectDetailsQuery);
	
				//Setting Proj Details
				Map<String, Object> paramMapForProjIds = new HashMap<String, Object>();
				paramMapForProjIds.put("projIds", projIds);
	
				LOGGER.info("projIds :: "+projIds);
				gytiProjectVOs = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectDetailsQuery, paramMapForProjIds, new RowMapper<GytiProjectVO>(){
	
					@Override
					public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
						GytiProjectVO gytiProjectVO = new GytiProjectVO();
						gytiProjectVO.setProjId(rs.getLong("PROJ_ID"));
						gytiProjectVO.setProjTitle(rs.getString("PROJ_TITLE"));
						gytiProjectVO.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
						gytiProjectVO.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
						gytiProjectVO.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
						gytiProjectVO.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
						gytiProjectVO.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
						gytiProjectVO.setProjFacRgstrId(rs.getLong("PROJ_FAC_RGSTR_ID"));
						gytiProjectVO.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
						gytiProjectVO.setProjTeamId(rs.getLong("TEAM_ID"));
	
						return gytiProjectVO;
					}
	
				});
				for(GytiProjectVO gytiProjectObj : gytiProjects){
					for(GytiProjectVO gytiProjectVO : gytiProjectVOs){
						if(gytiProjectObj.getProjId()== gytiProjectVO.getProjId()){
							gytiProjectObj.setProjTitle(gytiProjectVO.getProjTitle());
							gytiProjectObj.setProjDescription(gytiProjectVO.getProjDescription());
							gytiProjectObj.setProjTeamLeaderId(gytiProjectVO.getProjTeamLeaderId());
							gytiProjectObj.setProjMentor1Id(gytiProjectVO.getProjMentor1Id());
							gytiProjectObj.setProjMentor2Id(gytiProjectVO.getProjMentor2Id());
							gytiProjectObj.setProjUniversity(gytiProjectVO.getProjUniversity());
							gytiProjectObj.setProjFacRgstrId(gytiProjectVO.getProjFacRgstrId());
							gytiProjectObj.setProjStatusId(gytiProjectVO.getProjStatusId());
							gytiProjectObj.setProjTeamId(gytiProjectVO.getProjTeamId());
						}
					}
				}
	
				ArrayList<UserProfileVO> userProfileVOs = new ArrayList<UserProfileVO>();
				ArrayList<Branch> projBranches = new ArrayList<Branch>();
				ArrayList<UserProfileVO> projFacultyNames = new ArrayList<UserProfileVO>();
				ArrayList<UsrMngtStudentVO> teamLeaderNamesForCollege = new ArrayList<UsrMngtStudentVO>();
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
	
				String getCollegeDetailsUsrMngtStudentQuery = rbundle.getString("GET_COLLEGE_DETAILS_USR_MNGT_STUDENT_QUERY");
				getCollegeDetailsUsrMngtStudentQuery = getCollegeDetailsUsrMngtStudentQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
				LOGGER.info("getCollegeDetailsUsrMngtMasterQuery :: "+getCollegeDetailsUsrMngtStudentQuery);
	
				String getTeamLeaderDetailsUsrMngtMasterQuery = rbundle.getString("GET_TEAM_LEADER_DETAILS_USR_MNGT_MASTER_QUERY");
				getTeamLeaderDetailsUsrMngtMasterQuery = getTeamLeaderDetailsUsrMngtMasterQuery.replace("&PROJ_TEAM_LEADER_ID", ":projTeamLeaderId");
				LOGGER.info("getTeamLeaderDetailsUsrMngtMasterQuery :: "+getTeamLeaderDetailsUsrMngtMasterQuery);
	
				for(GytiProjectVO gytiProject : gytiProjects){
	
					//Setting Team Members 
					Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
					paramMapForProjId.put("projId", gytiProject.getProjId());
					userProfileVOs = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamDetailsUsrMngtMasterQuery, paramMapForProjId, new RowMapper<UserProfileVO>(){
	
						@Override
						public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
							UserProfileVO userProfileVO = new UserProfileVO();
							userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
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
					gytiProject.setProjTeamMemberList(projTeamMemberList);
	
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
					gytiProject.setProjBranchList(projBranches);
	
					//Setting Faculty Names 
					Map<String, Object> paramMapForFacultyRegtrId = new HashMap<String, Object>();
					paramMapForFacultyRegtrId.put("projFacRgstrId", gytiProject.getProjFacRgstrId());
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
						gytiProject.setProjFacultyName(projFacultyNames.get(0).getFirstName()
								+((projFacultyNames.get(0).getMidName()==""||projFacultyNames.get(0).getMidName()==null) ? "":" ") 
								+projFacultyNames.get(0).getMidName()+((projFacultyNames.get(0).getLastName()==""||projFacultyNames.get(0).getLastName()==null) ? "":" ")
								+projFacultyNames.get(0).getLastName());
					}
	
					//Setting College Name
					Map<String, Object> paramMapForTeamLeaderId = new HashMap<String, Object>();
					paramMapForTeamLeaderId.put("projTeamLeaderId", gytiProject.getProjTeamLeaderId());
					teamLeaderNamesForCollege = (ArrayList<UsrMngtStudentVO>) namedParameterJdbcTemplate.query(getCollegeDetailsUsrMngtStudentQuery, paramMapForTeamLeaderId, new RowMapper<UsrMngtStudentVO>(){
	
						@Override
						public UsrMngtStudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
							UsrMngtStudentVO usrMngtStudentVO = new UsrMngtStudentVO();
							usrMngtStudentVO.setCollege(rs.getString("COLLEGE"));
							return usrMngtStudentVO;
						}
	
					});
					if(teamLeaderNamesForCollege.size()>0){
						gytiProject.setProjCollege(teamLeaderNamesForCollege.get(0).getCollege());
					}
					//Setting TeamLeader Name 
					paramMapForTeamLeaderId.put("projTeamLeaderId", gytiProject.getProjTeamLeaderId());
					teamLeaderNames = (ArrayList<UserProfileVO>) namedParameterJdbcTemplate.query(getTeamLeaderDetailsUsrMngtMasterQuery, paramMapForTeamLeaderId, new RowMapper<UserProfileVO>(){
	
						@Override
						public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
							UserProfileVO userProfileVO = new UserProfileVO();
							userProfileVO.setFirstName(rs.getString("FNAME"));
							userProfileVO.setMidName(rs.getString("MNAME"));
							userProfileVO.setLastName(rs.getString("LNAME"));
							return userProfileVO;
						}
	
					});
					if(teamLeaderNames.size()>0){
						gytiProject.setTeamLeaderName(teamLeaderNames.get(0).getFirstName()
								+((teamLeaderNames.get(0).getMidName()==""||teamLeaderNames.get(0).getMidName()==null) ? "":" ") 
								+teamLeaderNames.get(0).getMidName()+((teamLeaderNames.get(0).getLastName()==""||teamLeaderNames.get(0).getLastName()==null) ? "":" ")
								+teamLeaderNames.get(0).getLastName());
					}
				}

			}
		} catch (Exception e) {
			LOGGER.error("Error while getting all gytiProjects :", e);
			throw new GetAllGytiProjectException("Error while getting all gytiProjects : "+ e.getMessage());
		}

		return gytiProjects;
	}

	public ArrayList<GytiProjectVO> getAllGytiProjectByLoggedInUser(String rgstrId) throws GetAllGytiProjectException{

		//Get the project details by using RGSTRID 
		ArrayList<GytiProjectVO> gytiProjects = new ArrayList<GytiProjectVO>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllGytiProjectDetailsByLoggedInUserQuery = rbundle.getString("GET_ALL_GYTI_PROJECT_DETAILS_BY_LOGGED_IN_USER_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
		getAllGytiProjectDetailsByLoggedInUserQuery = getAllGytiProjectDetailsByLoggedInUserQuery.replaceAll("&RGSTRID", ":rgstrId");
		LOGGER.info("getAllGytiProjectDetailsByLoggedInUserQuery :: "+getAllGytiProjectDetailsByLoggedInUserQuery);

		try{
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			//Setting Proj Details
			Map<String, Object> paramMapForRgstrId = new HashMap<String, Object>();
			paramMapForRgstrId.put("rgstrId", rgstrId);
			LOGGER.info("rgstrId :: "+rgstrId);

			gytiProjects = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectDetailsByLoggedInUserQuery, paramMapForRgstrId, new RowMapper<GytiProjectVO>(){

				@Override
				public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					GytiProjectVO gytiProjectVO = new GytiProjectVO();
					gytiProjectVO.setProjId(rs.getLong("PROJ_ID"));
					gytiProjectVO.setProjTitle(rs.getString("PROJ_TITLE"));
					gytiProjectVO.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
					gytiProjectVO.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					gytiProjectVO.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
					gytiProjectVO.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
					gytiProjectVO.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
					gytiProjectVO.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
					gytiProjectVO.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
					gytiProjectVO.setProjTeamId(rs.getLong("TEAM_ID"));

					return gytiProjectVO;
				}

			});

			List<Long> projIds = new ArrayList<Long>();
			for(GytiProjectVO gytiProjectVO : gytiProjects){
				projIds.add(gytiProjectVO.getProjId());
				LOGGER.info("projId :: "+gytiProjectVO.getProjId());
			}

			ArrayList<GytiProjectVO> gytiProjectVOs = new ArrayList<GytiProjectVO>();

			String getAllGytiProjectByLoggedInUserAwardGytiDetailQuery = rbundle.getString("GET_ALL_GYTI_PROJECT_BY_LOGGED_IN_USER_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_QUERY");
			getAllGytiProjectByLoggedInUserAwardGytiDetailQuery = getAllGytiProjectByLoggedInUserAwardGytiDetailQuery.replaceAll("&PROJIDS", ":projIds");
			LOGGER.info("getAllGytiProjectByLoggedInUserAwardGytiDetailQuery :: "+getAllGytiProjectByLoggedInUserAwardGytiDetailQuery);

			//Setting GYTI Details
			Map<String, Object> paramMapForProjIds = new HashMap<String, Object>();
			paramMapForProjIds.put("projIds", projIds);
			LOGGER.info("projIds :: "+projIds);


			gytiProjectVOs = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectByLoggedInUserAwardGytiDetailQuery, paramMapForProjIds, new RowMapper<GytiProjectVO>(){

				@Override
				public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					GytiProjectVO gytiProject = new GytiProjectVO();
					gytiProject.setProjId(rs.getLong("PROJ_ID"));
					gytiProject.setProjAppliedAwards(rs.getString("PROJ_APPLIED_AWARDS"));
					gytiProject.setProjGuideName(rs.getString("PROJ_GUIDE_NAME"));
					gytiProject.setProjGuideEmail(rs.getString("PROJ_GUIDE_EMAIL"));
					gytiProject.setProjGuideMobile(rs.getString("PROJ_GUIDE_MOBILE"));
					gytiProject.setProjAcademicProgram(rs.getString("PROJ_ACADEMIC_PROGRAM"));
					gytiProject.setProjStatusInfo(rs.getString("PROJ_STATUS_INFO"));
					gytiProject.setProjCopyrightInfo(rs.getString("PROJ_COPYRIGHT_INFO"));
					gytiProject.setProjProofInfo(rs.getString("PROJ_PROOF_INFO"));
					gytiProject.setOtherDistinguishablePatents(rs.getString("OTHER_DISTINGUISHABLE_PATENTS"));
					gytiProject.setProjFeature(rs.getString("PROJ_FEATURE"));
					gytiProject.setProjFrugalityInfo(rs.getString("PROJ_FRUGALITY_INFO"));
					gytiProject.setProjObjectiveInfo(rs.getString("PROJ_OBJECTIVE_INFO"));
					gytiProject.setProjContributeInfo(rs.getString("PROJ_CONTRIBUTE_INFO"));
					gytiProject.setProjImpactInfo(rs.getString("PROJ_IMPACT_INFO"));
					gytiProject.setProjRequiredResource(rs.getString("PROJ_REQUIRED_RESOURCE"));
					gytiProject.setProjResearchContinue(rs.getString("PROJ_RESEARCH_CONTINUE"));
					gytiProject.setProjPatentWork(rs.getString("PROJ_PATENT_WORK"));
					gytiProject.setProjPublishedPaper(rs.getString("PROJ_PUBLISHED_PAPER"));
					gytiProject.setProjOtherInfo(rs.getString("PROJ_OTHER_INFO"));
					gytiProject.setProjBenefitInfo(rs.getString("PROJ_BENEFIT_INFO"));
					return gytiProject;
				}

			});

			for(GytiProjectVO gytiProjectObj : gytiProjects){
				for(GytiProjectVO gytiProjectVO : gytiProjectVOs){
					if(gytiProjectObj.getProjId()== gytiProjectVO.getProjId()){
						gytiProjectObj.setProjTitle(gytiProjectVO.getProjTitle());
						gytiProjectObj.setProjDescription(gytiProjectVO.getProjDescription());
						gytiProjectObj.setProjTeamLeaderId(gytiProjectVO.getProjTeamLeaderId());
						gytiProjectObj.setProjMentor1Id(gytiProjectVO.getProjMentor1Id());
						gytiProjectObj.setProjMentor2Id(gytiProjectVO.getProjMentor2Id());
						gytiProjectObj.setProjUniversity(gytiProjectVO.getProjUniversity());
						gytiProjectObj.setProjFaculty(gytiProjectVO.getProjFaculty());
						gytiProjectObj.setProjStatusId(gytiProjectVO.getProjStatusId());
						gytiProjectObj.setProjTeamId(gytiProjectVO.getProjTeamId());
					}
				}
			}
		}
		catch(Exception e){
			LOGGER.error("Error while getting all gytiProjects :", e);
			throw new GetAllGytiProjectException("Error while getting all gytiProjects : "+ e.getMessage());
		}
		return gytiProjects;
	}

	public String updateGytiProject(SubmitInnovationToGytiVO innovationInfo) throws UpdateGytiInnovationException {

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiInfoProjectMasterDetailUpdateQuery = rbundle.getString("GYTI_INFO_TB_TECH001_MAST_PROJECTS_DETAIL_UPDATE_QUERY");
		String gytiInfoTeamMasterDetailUpdateQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_team_UPDATE_QUERY");
		String gytiInfoKeywordMasterDetailDeleteQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_keywrd_DELETE_QUERY");
		String gytiInfoKeywordMasterDetailInsertQuery = rbundle.getString("GYTI_INFO_tb_tech001_mast_projects_keywrd_INSERT_QUERY");
		String gytiAdditionalInfoMasterGytiDetailUpdateQuery = rbundle.getString("GYTI_ADDITIONAL_INFO_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_UPDATE_QUERY");
		String projectAwardInfoDeleteQuery = rbundle.getString("PROJECT_AWARD_INFO_DELETE_QUERY");
		String projectAwardInfoInsertQuery = rbundle.getString("PROJECT_AWARD_INFO_INSERT_QUERY");

		try{
			NamedParameterJdbcTemplate namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			//update team master
			LOGGER.info("gytiInfoTeamMasterDetailInsertQuery :: "+gytiInfoTeamMasterDetailUpdateQuery);
			MapSqlParameterSource teamParameters = new MapSqlParameterSource();
			teamParameters.addValue("projTeamDesc", innovationInfo.getProjTeamDesc());
			teamParameters.addValue("teamId", innovationInfo.getProjTeamId());
			namedParameterjdbcTemplate.update(gytiInfoTeamMasterDetailUpdateQuery, teamParameters);

			//update project master
			LOGGER.info("gytiInfoProjectMasterDetailUpdateQuery :: "+gytiInfoProjectMasterDetailUpdateQuery);
			MapSqlParameterSource projectMasterParameters = new MapSqlParameterSource();
			projectMasterParameters.addValue("projTitle", innovationInfo.getProjTitle());
			projectMasterParameters.addValue("projAbstract", innovationInfo.getProjAbstract());
			projectMasterParameters.addValue("projDescription", innovationInfo.getProjDescription());
			projectMasterParameters.addValue("projYear", innovationInfo.getProjYear());
			projectMasterParameters.addValue("projDuration", innovationInfo.getProjDuration());
			projectMasterParameters.addValue("projEndDate", new java.sql.Date(Long.parseLong(innovationInfo.getProjEndDate())));
			projectMasterParameters.addValue("projEstimatedCost", innovationInfo.getProjEstimationCost());
			projectMasterParameters.addValue("projId", innovationInfo.getProjId());
			namedParameterjdbcTemplate.update(gytiInfoProjectMasterDetailUpdateQuery, projectMasterParameters);

			//delete keywords for this project
			LOGGER.info("gytiInfoKeywordMasterDetailDeleteQuery :: " + gytiInfoKeywordMasterDetailDeleteQuery);
			MapSqlParameterSource projIdParameters = new MapSqlParameterSource();
			projIdParameters.addValue("projId", innovationInfo.getProjId());
			namedParameterjdbcTemplate.update(gytiInfoKeywordMasterDetailDeleteQuery, projIdParameters);

			//insert keywords for this project
			for(String projKeyword:innovationInfo.getProjKeywords()){
				LOGGER.info("gytiInfoKeywordMasterDetailInsertQuery :: "+gytiInfoKeywordMasterDetailInsertQuery);
				jdbcTemplate.update(gytiInfoKeywordMasterDetailInsertQuery, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setLong(1, innovationInfo.getProjId());
						ps.setString(2, projKeyword);	
					}
				});
			}

			//update additional info
			LOGGER.info("gytiAdditionalInfoMasterGytiDetailUpdateQuery :: "+gytiAdditionalInfoMasterGytiDetailUpdateQuery);
			MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
			addInfoParameters.addValue("projAppliedAwards", innovationInfo.getProjAppliedAwards());
			addInfoParameters.addValue("projGuideName", innovationInfo.getProjGuideName());
			addInfoParameters.addValue("projGuideEmail", innovationInfo.getProjGuideEmail());
			addInfoParameters.addValue("projGuideMobile", innovationInfo.getProjGuideMobile());
			addInfoParameters.addValue("projAcademicProgram", innovationInfo.getProjAcademicProgram());
			addInfoParameters.addValue("projStatusInfo", innovationInfo.getProjStatusInfo());
			addInfoParameters.addValue("projCopyrightInfo", innovationInfo.getProjCopyrightInfo());
			addInfoParameters.addValue("projProofInfo", innovationInfo.getProjProofInfo());
			addInfoParameters.addValue("otherDistinguishablePatents", innovationInfo.getOtherDistinguishablePatents());
			addInfoParameters.addValue("projFeature", innovationInfo.getProjFeature());
			addInfoParameters.addValue("projFrugalityInfo", innovationInfo.getProjFrugalityInfo());
			addInfoParameters.addValue("projObjectiveInfo", innovationInfo.getProjObjectiveInfo());
			addInfoParameters.addValue("projContributeInfo", innovationInfo.getProjContributeInfo());
			addInfoParameters.addValue("projImpactInfo", innovationInfo.getProjImpactInfo());
			addInfoParameters.addValue("projRequiredResource", innovationInfo.getProjRequiredResource());
			addInfoParameters.addValue("projResearchContinue", innovationInfo.getProjResearchContinue());
			addInfoParameters.addValue("projPatentWork", innovationInfo.getProjPatentWork());
			addInfoParameters.addValue("projPublishedPaper", innovationInfo.getProjPublishedPaper());
			addInfoParameters.addValue("projOtherInfo", innovationInfo.getProjOtherInfo());
			addInfoParameters.addValue("projBenefitInfo", innovationInfo.getProjBenefitInfo());
			addInfoParameters.addValue("projPreviousAwardYear", innovationInfo.getProjAwardYear());
			addInfoParameters.addValue("nominatedBy", innovationInfo.getNominatedBy());
			addInfoParameters.addValue("publishOnWebsite", innovationInfo.getPublishOnWebsite());
			addInfoParameters.addValue("projObjectiveInfoArea", innovationInfo.getProjObjectiveInfoArea());
			addInfoParameters.addValue("projPhotoVideoNewsOthers", innovationInfo.getProjPhotoVideoNewsOthers());
			addInfoParameters.addValue("projFinishYear", innovationInfo.getProjFinishYear());
			addInfoParameters.addValue("projId", innovationInfo.getProjId());
			namedParameterjdbcTemplate.update(gytiAdditionalInfoMasterGytiDetailUpdateQuery, addInfoParameters);


			//delete awards for this project
/*			LOGGER.info("projectAwardInfoDeleteQuery :: " + projectAwardInfoDeleteQuery);
			namedParameterjdbcTemplate.update(projectAwardInfoDeleteQuery, projIdParameters);

			//insert award info for this project
		LOGGER.info("projectAwardInfoInsertQuery :: "+ projectAwardInfoInsertQuery);
			jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setLong(1, innovationInfo.getProjId());
					ps.setLong(2, 1);
					ps.setString(3, innovationInfo.getProjAwardYear());
					ps.setString(4, "N");

				}
			});
			LOGGER.info("projectAwardInfoInsertQuery for latest:: "+ projectAwardInfoInsertQuery);
			jdbcTemplate.update(projectAwardInfoInsertQuery,new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setLong(1, innovationInfo.getProjId());
					ps.setLong(2, 1);
					ps.setString(3,  Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
					ps.setString(4, "N");

				}
			});*/
		}catch(Exception e) {
			LOGGER.error("Error while updating Innovation to GYTI :", e);
			//e.printStackTrace();
			throw new UpdateGytiInnovationException("Error while updating Innovation to GYTI : "+ e.getMessage());
		}
		return "Y";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<GYTIProjectStatisticsVO> getGYTIProjectStatistics() throws GetGYTIProjectStatisticsException {

		ArrayList<GYTIProjectStatisticsVO> gytiProjStats=new ArrayList<GYTIProjectStatisticsVO>();
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiProjStatsQuery=rbundle.getString("GET_ALL_GYTI_PROJECTS_BASED_ON_CATEGORY");
		LOGGER.info("getGYTIProjectStatistics::"+gytiProjStatsQuery);
		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			gytiProjStats=(ArrayList<GYTIProjectStatisticsVO>) namedParameterJdbcTemplate.query(gytiProjStatsQuery, new BeanPropertyRowMapper(GYTIProjectStatisticsVO.class));
		} catch (Exception e) {
			LOGGER.error("Error while updating Innovation to GYTI :", e);
			//e.printStackTrace();
			throw new GetGYTIProjectStatisticsException("Error while updating Innovation to GYTI : "+ e.getMessage());
		}
		return gytiProjStats;
	}

	public String reviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException {
		LOGGER.info("ProjectmanagementDAO.reviewRating :Start");
		ResourceBundle rbundle=ResourceBundle.getBundle("query");
		String reviewRatingInserQuery=rbundle.getString("REVIEW_RATING_INSERT_QUERY");
		String reviewRatingValidationQuery=rbundle.getString("REVIEW_RATING_VALIDATION_QUERY");
		String reviewRatingUpdateQuery=rbundle.getString("REVIEW_RATING_UPDATE_INSERT_QUERY");
		
		try {
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			LOGGER.info("reviewRatingValidationQuery :: "+reviewRatingValidationQuery);
			int rowCount = jdbcTemplate.queryForObject(reviewRatingValidationQuery, new Object[] {reviewRating.getRevRgstrId(),reviewRating.getProjId()},Integer.class);
				
			if (rowCount > 0){
				//If project is suggested update Review Rating info
				LOGGER.info("reviewRatingUpdateQuery :: "+reviewRatingUpdateQuery);
				MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
				addInfoParameters.addValue("projTeamLeaderId", reviewRating.getProjteamLeaderId());
				addInfoParameters.addValue("revRecommendation", reviewRating.getRevRecommendation());
				addInfoParameters.addValue("revNovelty", reviewRating.getRevNovelty());
				addInfoParameters.addValue("revTechnicalRigor", reviewRating.getRevTechnicalRigor());
				addInfoParameters.addValue("revSocialApplication", reviewRating.getRevSocialApplication());
				addInfoParameters.addValue("revFrugality", reviewRating.getRevFrugality());
				addInfoParameters.addValue("revRatingPercentage", reviewRating.getRevRatingPercentage());
				addInfoParameters.addValue("revComments", reviewRating.getRevComments());
				addInfoParameters.addValue("revSuggestedLinks", reviewRating.getRevSuggestedLinks());
				addInfoParameters.addValue("canIdeaBeTakenForward", reviewRating.getCanIdeaBeTakenForward());
				addInfoParameters.addValue("canIdeaBeTakenForwardRemarks", reviewRating.getCanIdeaBeTakenForwardRemarks());
				addInfoParameters.addValue("moreInfoNeeded", reviewRating.getMoreInfoNeeded());
				addInfoParameters.addValue("moreInfoNeededRemarks", reviewRating.getMoreInfoNeededRemarks());
				addInfoParameters.addValue("suggestToOtherRev", reviewRating.getSuggestToOtherRev());
				addInfoParameters.addValue("reviewEndDate", new Timestamp((new Date()).getTime()));
				addInfoParameters.addValue("projId", reviewRating.getProjId());
				addInfoParameters.addValue("revRgstrId", reviewRating.getRevRgstrId());
				addInfoParameters.addValue("status", "reviewed");
				int noOfRowAffected=namedParameterJdbcTemplate.update(reviewRatingUpdateQuery, addInfoParameters);
				LOGGER.info("rows affected :: " + noOfRowAffected);
				if (noOfRowAffected>0){
					return "Y";
				}
				
			}
			else{//if project is not suggested insert new record
					LOGGER.info("reviewRatingInserQuery"+reviewRatingInserQuery);
					int noOfRowAffected=jdbcTemplate.update(reviewRatingInserQuery,new PreparedStatementSetter(){
					public void setValues(PreparedStatement ps) throws SQLException {
	
						ps.setLong(1, reviewRating.getRatingId());
						ps.setLong(2, reviewRating.getRevRgstrId());
						ps.setLong(3, reviewRating.getRevRgstrId());
						ps.setLong(4, reviewRating.getProjteamLeaderId());
						ps.setLong(5, reviewRating.getProjId());
	
						Timestamp reviewStartDate = new Timestamp((new Date()).getTime());
	
						ps.setTimestamp(6, reviewStartDate);
						ps.setString(7, reviewRating.getRevRecommendation());
						ps.setInt(8, reviewRating.getRevNovelty());
						ps.setInt(9, reviewRating.getRevTechnicalRigor());
						ps.setInt(10, reviewRating.getRevSocialApplication());
						ps.setLong(11, reviewRating.getRevFrugality());
						ps.setFloat(12, reviewRating.getRevRatingPercentage());
						ps.setString(13, reviewRating.getRevComments());
						ps.setString(14, reviewRating.getRevSuggestedLinks());
						ps.setString(15,  String.valueOf(reviewRating.getCanIdeaBeTakenForward()));
						ps.setString(16, reviewRating.getCanIdeaBeTakenForwardRemarks());
						ps.setString(17, String.valueOf(reviewRating.getMoreInfoNeeded()));
						ps.setString(18, reviewRating.getMoreInfoNeededRemarks());
						ps.setString(19, String.valueOf(reviewRating.getSuggestToOtherRev()));
						
						Timestamp reviewEndDate = new Timestamp((new Date()).getTime());
						ps.setTimestamp(20, reviewEndDate);
						ps.setString(21, "reviewed");
					}
	
				});
					LOGGER.info("rows affected :: " + noOfRowAffected);
					if (noOfRowAffected>0){
						return "Y";
					}
			}
			
		} catch (Exception e) {
			LOGGER.error("Error while Submitting Review Rating : Ex :: ", e);
			throw new ReviewRatingException("Error while Submitting Review Rating : "+ e.getMessage());

		}
		LOGGER.info("ProjectmanagementDAO.reviewRating :End");
		return "N";
	}
	
	public GetAllGytiProjectByLoggedInReviewerResponse getAllGytiProjectByLoggedInReviewer(String revRgstrId,String awardYear) throws GetAllGytiProjectException{

		GetAllGytiProjectByLoggedInReviewerResponse getAllGytiProjectByLoggedInReviewerResponse = new GetAllGytiProjectByLoggedInReviewerResponse();
		//Get the project details by using RGSTRID and awardYear
		ArrayList<GytiProjectVO> gytiProjects = new ArrayList<GytiProjectVO>();

		try{
			ResourceBundle rbundle = ResourceBundle.getBundle("query");
			String getAllGytiProjectsForReviewerBranchQuery = rbundle.getString("GET_ALL_GYTI_PROJECTS_FOR_REVIEWER_BRANCH_IN_YEAR_QUERY");
			getAllGytiProjectsForReviewerBranchQuery = getAllGytiProjectsForReviewerBranchQuery.replaceAll("&REVRGSTRID", ":revRgstrId");
			getAllGytiProjectsForReviewerBranchQuery = getAllGytiProjectsForReviewerBranchQuery.replaceAll("&AWARDYEAR", ":awardYear");
			LOGGER.info("getAllGytiProjectsForReviewerBranchQuery :: "+getAllGytiProjectsForReviewerBranchQuery);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			Map<String, Object> paramMapForRevRgstrId = new HashMap<String, Object>();
			paramMapForRevRgstrId.put("revRgstrId", revRgstrId);
			paramMapForRevRgstrId.put("awardYear", awardYear);
			LOGGER.info("revRgstrId :: "+revRgstrId);
			LOGGER.info("Award Year :: "+awardYear);

			gytiProjects = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectsForReviewerBranchQuery, paramMapForRevRgstrId, new RowMapper<GytiProjectVO>(){

				@Override
				public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					GytiProjectVO gytiProject = new GytiProjectVO();
					gytiProject.setProjId(rs.getLong("PROJ_ID"));
					gytiProject.setProjAppliedAwards(rs.getString("PROJ_APPLIED_AWARDS"));
					gytiProject.setProjGuideName(rs.getString("PROJ_GUIDE_NAME"));
					gytiProject.setProjGuideEmail(rs.getString("PROJ_GUIDE_EMAIL"));
					gytiProject.setProjGuideMobile(rs.getString("PROJ_GUIDE_MOBILE"));
					gytiProject.setProjAcademicProgram(rs.getString("PROJ_ACADEMIC_PROGRAM"));
					gytiProject.setProjStatusInfo(rs.getString("PROJ_STATUS_INFO"));
					gytiProject.setProjCopyrightInfo(rs.getString("PROJ_COPYRIGHT_INFO"));
					gytiProject.setProjProofInfo(rs.getString("PROJ_PROOF_INFO"));
					gytiProject.setOtherDistinguishablePatents(rs.getString("OTHER_DISTINGUISHABLE_PATENTS"));
					gytiProject.setProjFeature(rs.getString("PROJ_FEATURE"));
					gytiProject.setProjFrugalityInfo(rs.getString("PROJ_FRUGALITY_INFO"));
					gytiProject.setProjObjectiveInfo(rs.getString("PROJ_OBJECTIVE_INFO"));
					gytiProject.setProjContributeInfo(rs.getString("PROJ_CONTRIBUTE_INFO"));
					gytiProject.setProjImpactInfo(rs.getString("PROJ_IMPACT_INFO"));
					gytiProject.setProjRequiredResource(rs.getString("PROJ_REQUIRED_RESOURCE"));
					gytiProject.setProjResearchContinue(rs.getString("PROJ_RESEARCH_CONTINUE"));
					gytiProject.setProjPatentWork(rs.getString("PROJ_PATENT_WORK"));
					gytiProject.setProjPublishedPaper(rs.getString("PROJ_PUBLISHED_PAPER"));
					gytiProject.setProjOtherInfo(rs.getString("PROJ_OTHER_INFO"));
					gytiProject.setProjBenefitInfo(rs.getString("PROJ_BENEFIT_INFO"));
					return gytiProject;
				}

			});

			List<Long> projIds = new ArrayList<Long>();
			for(GytiProjectVO gytiProjectVO : gytiProjects){
				projIds.add(gytiProjectVO.getProjId());
				LOGGER.info("projId :: "+gytiProjectVO.getProjId());
			}
			
			List<GytiProjectVO> projectsProposedForReview = new ArrayList<GytiProjectVO>();
			List<GytiProjectVO> projectsAlreadyReviewed = new ArrayList<GytiProjectVO>();
			List<GytiProjectVO> projectsOptionalForReview = new ArrayList<GytiProjectVO>();
			List<GytiProjectVO> projectsInProgressForReview = new ArrayList<GytiProjectVO>();
			List<GytiProjectVO> projectsAcceptedForReview = new ArrayList<GytiProjectVO>();
			
			if(projIds.size()>0){
				
				ArrayList<GytiProjectVO> gytiProjectVOs = new ArrayList<GytiProjectVO>();
				String getAllGytiProjectsMastProjectsDetailQuery = rbundle.getString("GET_ALL_GYTI_PROJECTS_MAST_PROJECTS_DETAIL_QUERY");
				getAllGytiProjectsMastProjectsDetailQuery = getAllGytiProjectsMastProjectsDetailQuery.replaceAll("&PROJID", ":projId");
				LOGGER.info("getAllGytiProjectsMastProjectsDetailQuery :: "+getAllGytiProjectsMastProjectsDetailQuery);
				Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
				paramMapForProjId.put("projId", projIds);
				LOGGER.info("projId :: "+projIds);
	
				gytiProjectVOs = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectsMastProjectsDetailQuery, paramMapForProjId, new RowMapper<GytiProjectVO>(){
	
					@Override
					public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
						GytiProjectVO gytiProjectVO = new GytiProjectVO();
						gytiProjectVO.setProjId(rs.getLong("PROJ_ID"));
						gytiProjectVO.setProjTitle(rs.getString("PROJ_TITLE"));
						gytiProjectVO.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
						gytiProjectVO.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
						gytiProjectVO.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
						gytiProjectVO.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
						gytiProjectVO.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
						gytiProjectVO.setProjFaculty(rs.getLong("PROJ_FAC_RGSTR_ID"));
						gytiProjectVO.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
						gytiProjectVO.setProjTeamId(rs.getLong("TEAM_ID"));
						gytiProjectVO.setPhoto1Path(rs.getString("PHOTO1_PATH"));
						gytiProjectVO.setPhoto2Path(rs.getString("PHOTO2_PATH"));
	
						return gytiProjectVO;
					}
	
				});
	
				for(GytiProjectVO gytiProjectObj : gytiProjects){
					for(GytiProjectVO gytiProjectVO : gytiProjectVOs){
						if(gytiProjectObj.getProjId()== gytiProjectVO.getProjId()){
							gytiProjectObj.setProjTitle(gytiProjectVO.getProjTitle());
							gytiProjectObj.setProjDescription(gytiProjectVO.getProjDescription());
							gytiProjectObj.setProjTeamLeaderId(gytiProjectVO.getProjTeamLeaderId());
							gytiProjectObj.setProjMentor1Id(gytiProjectVO.getProjMentor1Id());
							gytiProjectObj.setProjMentor2Id(gytiProjectVO.getProjMentor2Id());
							gytiProjectObj.setProjUniversity(gytiProjectVO.getProjUniversity());
							gytiProjectObj.setProjFaculty(gytiProjectVO.getProjFaculty());
							gytiProjectObj.setProjStatusId(gytiProjectVO.getProjStatusId());
							gytiProjectObj.setProjTeamId(gytiProjectVO.getProjTeamId());
							gytiProjectObj.setPhoto1Path(gytiProjectVO.getPhoto1Path());
							gytiProjectObj.setPhoto2Path(gytiProjectVO.getPhoto2Path());
						}
					}
				}
				List<ReviewRatingVO> reviewRatingVOs = new ArrayList<ReviewRatingVO>();
				String getAllTrsReviewRatingQuery = rbundle.getString("GET_ALL_TRS_REVIEW_RATING_QUERY");
				getAllTrsReviewRatingQuery = getAllTrsReviewRatingQuery.replaceAll("&REVRGSTRID", ":revRgstrId");
				LOGGER.info("getAllTrsReviewRatingQuery :: "+getAllTrsReviewRatingQuery);
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("revRgstrId", revRgstrId);
				LOGGER.info("revRgstrId :: "+revRgstrId);
				
				reviewRatingVOs = (ArrayList<ReviewRatingVO>) namedParameterJdbcTemplate.query(getAllTrsReviewRatingQuery, paramMap, new RowMapper<ReviewRatingVO>(){
	
					@Override
					public ReviewRatingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
						ReviewRatingVO reviewRatingVO = new ReviewRatingVO();
						reviewRatingVO.setProjId(rs.getLong("PROJ_ID"));
						reviewRatingVO.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
						reviewRatingVO.setStatus(rs.getString("STATUS"));
						return reviewRatingVO;
					}
	
				});
				if(reviewRatingVOs.size()>0){
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							for(GytiProjectVO gytiProjectObj : gytiProjects){
								if(reviewRatingVO.getProjId() == gytiProjectObj.getProjId()  && reviewRatingVO.getStatus().equalsIgnoreCase("pending")){
									projectsProposedForReview.add(gytiProjectObj);
								}
							}
						}
						
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							for(GytiProjectVO gytiProjectObj : gytiProjects){
								if(reviewRatingVO.getProjId() == gytiProjectObj.getProjId() && reviewRatingVO.getStatus().equalsIgnoreCase( "reviewed")){
								projectsAlreadyReviewed.add(gytiProjectObj);
								}
							}
						}
						
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							for(GytiProjectVO gytiProjectObj : gytiProjects){
								if(reviewRatingVO.getProjId() == gytiProjectObj.getProjId() && reviewRatingVO.getStatus().equalsIgnoreCase("inProgress")){
									projectsInProgressForReview.add(gytiProjectObj);
								}
							}
						}
						
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							for(GytiProjectVO gytiProjectObj : gytiProjects){
								if(reviewRatingVO.getProjId() == gytiProjectObj.getProjId() && reviewRatingVO.getStatus().equalsIgnoreCase("accepted")){
									projectsAcceptedForReview.add(gytiProjectObj);
								}
							}
						}
						
						for(GytiProjectVO gytiProjectObj : gytiProjects){
							projectsOptionalForReview.add(gytiProjectObj);
						}
						projectsOptionalForReview.removeAll(projectsProposedForReview);
						projectsOptionalForReview.removeAll(projectsAlreadyReviewed);
						projectsOptionalForReview.removeAll(projectsInProgressForReview);
						projectsOptionalForReview.removeAll(projectsAcceptedForReview);
					}
				else{
					projectsOptionalForReview.addAll(gytiProjects);
				}
			}
			getAllGytiProjectByLoggedInReviewerResponse.setProjectsAlreadyReviewed(projectsAlreadyReviewed);
			getAllGytiProjectByLoggedInReviewerResponse.setProjectsOptionalForReview(projectsOptionalForReview);
			getAllGytiProjectByLoggedInReviewerResponse.setProjectsProposedForReview(projectsProposedForReview);
			getAllGytiProjectByLoggedInReviewerResponse.setProjectsInProgressForReview(projectsInProgressForReview);
			getAllGytiProjectByLoggedInReviewerResponse.setProjectsAcceptedForReview(projectsAcceptedForReview);
		}
		catch(Exception e){
			LOGGER.error("Error while getting all gytiProjects for Logged in reviewer :", e);
			throw new GetAllGytiProjectException("Error while getting all gytiProjects for Logged in reviewer : "+ e.getMessage());
		}
		return getAllGytiProjectByLoggedInReviewerResponse;
	}
	
	public String suggestReviewer(ArrayList<SuggestReviewerVO> suggestReviewerVO) throws SuggestReviewerException{
		String returnVal ="N";
		try {
			ResourceBundle rbundle = ResourceBundle.getBundle("query");
			String suggestReviewerForProjectInsertQuery = rbundle.getString("SUGGEST_REVIEWER_TRS_REVIEW_INSERT_QUERY");
			String suggestReviewerValidationGetQuery = rbundle.getString("SUGGEST_REVIEWER_TRS_REVIEW_VALIDATION_COUNT_QUERY");
			String suggestReviewerValidation1GetQuery = rbundle.getString("SUGGEST_REVIEWER_TRS_REVIEW_VALIDATION1_COUNT_QUERY");
			String SuggestReviewerExistStartDateUpdateQuery=rbundle.getString("SUGGEST_REVIEWER_START_DATE_UPDATE_QUERY");
			String SuggestReviewerStatusGetQuery=rbundle.getString("SUGGEST_REVIEWER_RATING_GET_QUERY");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			for(SuggestReviewerVO suggestReviewer:suggestReviewerVO){
				//Verify for duplicate record
				LOGGER.info("suggestReviewerValidationGetQuery :: "+suggestReviewerValidationGetQuery);
				int rowCount = jdbcTemplate.queryForObject(suggestReviewerValidationGetQuery, new Object[] {suggestReviewer.getRevRgstrId(),suggestReviewer.getProjId()},Integer.class);
					
				if (rowCount > 0){
							
						LOGGER.info("suggestReviewerValidation1GetQuery :: "+suggestReviewerValidation1GetQuery);
						int rowCount1 = jdbcTemplate.queryForObject(suggestReviewerValidation1GetQuery, new Object[] {suggestReviewer.getRevRgstrId(),suggestReviewer.getAssignedBy(),suggestReviewer.getProjId()},Integer.class);
							if (rowCount1 > 0){
							//If Duplicate Record Exists check for status
							LOGGER.info("SuggestReviewerStatusGetQuery :: "+SuggestReviewerStatusGetQuery);
							String status = jdbcTemplate.queryForObject(SuggestReviewerStatusGetQuery, new Object[] {suggestReviewer.getRevRgstrId(),suggestReviewer.getAssignedBy(),suggestReviewer.getProjId()},String.class);
							if(status.equalsIgnoreCase("pending")){
							// If the status is pending Update the existing record start date
							LOGGER.info("SuggestReviewerExistStartDateUpdateQuery :: "+SuggestReviewerExistStartDateUpdateQuery);
							MapSqlParameterSource updateStartDateParameters = new MapSqlParameterSource();
							updateStartDateParameters.addValue("reviewStartDate", new Timestamp((new Date()).getTime()));
							updateStartDateParameters.addValue("revRgstrId", suggestReviewer.getRevRgstrId());
							updateStartDateParameters.addValue("assignedBy", suggestReviewer.getAssignedBy());
							updateStartDateParameters.addValue("projId", suggestReviewer.getProjId());
							namedParameterJdbcTemplate.update(SuggestReviewerExistStartDateUpdateQuery, updateStartDateParameters);
							}
						}
						}
					else{
						//Insert new record
						LOGGER.info("suggestReviewerForProjectInsertQuery :: "+suggestReviewerForProjectInsertQuery);
						jdbcTemplate.update(suggestReviewerForProjectInsertQuery, new PreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement ps) throws SQLException {
								ps.setLong(1, suggestReviewer.getRevRgstrId());
								ps.setLong(2, suggestReviewer.getAssignedBy());
								ps.setLong(3, suggestReviewer.getProjId());
								ps.setTimestamp(4, new Timestamp((new Date()).getTime()));
								ps.setString(5, "pending");
							}
						});
						
					}
				
				}
				returnVal="Y";
			
		} catch (Exception e) {
			LOGGER.error("Error while adding suggested reviewers :", e);
			throw new SuggestReviewerException("Error while adding suggested reviewers",e.getMessage());
		}
		return returnVal;
	}
	
	public ReviewRatingVO getgytiProjectReviewDetails(GetReviewRatingVO getReviewRatingVO) throws GetGytiProjectRatingDetailsException{
		ReviewRatingVO gytiProjectReviewDetails = null;

		ResourceBundle rbundle=ResourceBundle.getBundle("query");
		String getGytiProjectRatingQuery=rbundle.getString("GET_GYTI_PROJECT_RATING_QUERY");
		getGytiProjectRatingQuery = getGytiProjectRatingQuery.replaceAll("&projId", ":projId");
		getGytiProjectRatingQuery = getGytiProjectRatingQuery.replaceAll("&revRgstrId", ":revRgstrId");
		String getGytiProjectStatusQuery=rbundle.getString("GET_GYTI_PROJECT_RATING_STATUS_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


		try {
			LOGGER.info("getGytiProjectStatusQuery :: "+getGytiProjectStatusQuery);
			String status = jdbcTemplate.queryForObject(getGytiProjectStatusQuery, new Object[] {getReviewRatingVO.getRevRgstrId(),getReviewRatingVO.getProjId()},String.class);
			if(status.equalsIgnoreCase("inProgress")||status.equalsIgnoreCase("reviewed") ){
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
				Map<String, Object> paramMapToGetRating = new HashMap<String, Object>();
				paramMapToGetRating.put("projId", getReviewRatingVO.getProjId());
				paramMapToGetRating.put("revRgstrId", getReviewRatingVO.getRevRgstrId());
				LOGGER.info("getGytiProjectDetailQuery :: "+getGytiProjectRatingQuery);
				gytiProjectReviewDetails= (ReviewRatingVO) namedParameterJdbcTemplate.queryForObject(getGytiProjectRatingQuery,paramMapToGetRating,new BeanPropertyRowMapper<ReviewRatingVO>(ReviewRatingVO.class));
			}
		} catch (Exception e) {
			LOGGER.error("Error while getting GYTI Project Rating Details :", e);
			throw new GetGytiProjectRatingDetailsException("Error while getting GYTI Project Rating Details", e.getMessage());
		}
		return gytiProjectReviewDetails;

	}
	
	public String updateGytiProjectReviewRating(ReviewRatingVO reviewRatingVO) throws updateGytiProjectReviewRatingException {

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String reviewRatingUpdateQuery = rbundle.getString("REVIEW_RATING_UPDATE_QUERY");
		String reviewRatingValidationGetQuery=rbundle.getString("REVIEW_RATING_VALIDATE_COUNT_QUERY");

		try{
			NamedParameterJdbcTemplate namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
			LOGGER.info("reviewRatingValidationGetQuery :: "+reviewRatingValidationGetQuery);
			int rowCount = jdbcTemplate.queryForObject(reviewRatingValidationGetQuery, new Object[] {reviewRatingVO.getRatingId()},Integer.class);
				
			if (rowCount > 0){
			//update Review Rating info
			LOGGER.info("reviewRatingUpdateQuery :: "+reviewRatingUpdateQuery);
			MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
			addInfoParameters.addValue("revRecommendation", reviewRatingVO.getRevRecommendation());
			addInfoParameters.addValue("revNovelty", reviewRatingVO.getRevNovelty());
			addInfoParameters.addValue("revTechnicalRigor", reviewRatingVO.getRevTechnicalRigor());
			addInfoParameters.addValue("revSocialApplication", reviewRatingVO.getRevSocialApplication());
			addInfoParameters.addValue("revFrugality", reviewRatingVO.getRevFrugality());
			addInfoParameters.addValue("revRatingPercentage", reviewRatingVO.getRevRatingPercentage());
			addInfoParameters.addValue("revComments", reviewRatingVO.getRevComments());
			addInfoParameters.addValue("revSuggestedLinks", reviewRatingVO.getRevSuggestedLinks());
			addInfoParameters.addValue("canIdeaBeTakenForward", reviewRatingVO.getCanIdeaBeTakenForward());
			addInfoParameters.addValue("canIdeaBeTakenForwardRemarks", reviewRatingVO.getCanIdeaBeTakenForwardRemarks());
			addInfoParameters.addValue("moreInfoNeeded", reviewRatingVO.getMoreInfoNeeded());
			addInfoParameters.addValue("moreInfoNeededRemarks", reviewRatingVO.getMoreInfoNeededRemarks());
			addInfoParameters.addValue("suggestToOtherRev", reviewRatingVO.getSuggestToOtherRev());
			addInfoParameters.addValue("reviewEndDate", new Timestamp((new Date()).getTime()));
			addInfoParameters.addValue("ratingId", reviewRatingVO.getRatingId());
			namedParameterjdbcTemplate.update(reviewRatingUpdateQuery, addInfoParameters);
			}
			else{
				return"N";
			}
		}catch(Exception e) {
			LOGGER.error("Error while updating Rating to GYTI project:", e);
			//e.printStackTrace();
			throw new updateGytiProjectReviewRatingException("Error while updating Rating to GYTI project ", e.getMessage());
		}
		return "Y";
	}
	
	public ArrayList<GytiProjectVO> getLatestGytiProject() throws GetAllGytiProjectException{

		ArrayList<GytiProjectVO> gytiProjects = new ArrayList<GytiProjectVO>();

		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllGytiProjectAwardGytiDetailQuery = rbundle.getString("GET_LATEST_GYTI_PROJECT_TB_TECH001_MAST_PROJECTS_AWARD_GYTI_DETAIL_QUERY");
		LOGGER.info("getAllGytiProjectAwardGytiDetailQuery :: "+getAllGytiProjectAwardGytiDetailQuery);

		try {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			gytiProjects = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectAwardGytiDetailQuery,new RowMapper<GytiProjectVO>(){

				@Override
				public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {

					GytiProjectVO gytiProject = new GytiProjectVO();
					gytiProject.setProjId(rs.getLong("PROJ_ID"));
					gytiProject.setProjAppliedAwards(rs.getString("PROJ_APPLIED_AWARDS"));
					gytiProject.setProjGuideName(rs.getString("PROJ_GUIDE_NAME"));
					gytiProject.setProjGuideEmail(rs.getString("PROJ_GUIDE_EMAIL"));
					gytiProject.setProjGuideMobile(rs.getString("PROJ_GUIDE_MOBILE"));
					gytiProject.setProjAcademicProgram(rs.getString("PROJ_ACADEMIC_PROGRAM"));
					gytiProject.setProjStatusInfo(rs.getString("PROJ_STATUS_INFO"));
					gytiProject.setProjCopyrightInfo(rs.getString("PROJ_COPYRIGHT_INFO"));
					gytiProject.setProjProofInfo(rs.getString("PROJ_PROOF_INFO"));
					gytiProject.setOtherDistinguishablePatents(rs.getString("OTHER_DISTINGUISHABLE_PATENTS"));
					gytiProject.setProjFeature(rs.getString("PROJ_FEATURE"));
					gytiProject.setProjFrugalityInfo(rs.getString("PROJ_FRUGALITY_INFO"));
					gytiProject.setProjObjectiveInfo(rs.getString("PROJ_OBJECTIVE_INFO"));
					gytiProject.setProjContributeInfo(rs.getString("PROJ_CONTRIBUTE_INFO"));
					gytiProject.setProjImpactInfo(rs.getString("PROJ_IMPACT_INFO"));
					gytiProject.setProjRequiredResource(rs.getString("PROJ_REQUIRED_RESOURCE"));
					gytiProject.setProjResearchContinue(rs.getString("PROJ_RESEARCH_CONTINUE"));
					gytiProject.setProjPatentWork(rs.getString("PROJ_PATENT_WORK"));
					gytiProject.setProjPublishedPaper(rs.getString("PROJ_PUBLISHED_PAPER"));
					gytiProject.setProjOtherInfo(rs.getString("PROJ_OTHER_INFO"));
					gytiProject.setProjBenefitInfo(rs.getString("PROJ_BENEFIT_INFO"));
					return gytiProject;
				}

			});
			List<Long> projIds = new ArrayList<Long>();
			
			if(gytiProjects.size()>0){
				
				for(GytiProjectVO gytiProjectVO : gytiProjects){
					projIds.add(gytiProjectVO.getProjId());
					LOGGER.info("projId :: "+gytiProjectVO.getProjId());
				}
	
				//Get the project details by using PROJ_ID 
				ArrayList<GytiProjectVO> gytiProjectVOs = new ArrayList<GytiProjectVO>();
	
				String getAllGytiProjectDetailsQuery = rbundle.getString("GET_ALL_GYTI_PROJECT_DETAILS_TB_TECH001_MAST_PROJECTS_DETAIL_QUERY");
				getAllGytiProjectDetailsQuery = getAllGytiProjectDetailsQuery.replaceAll("&PROJIDS", ":projIds");
				LOGGER.info("getProjectDetailsQuery :: "+getAllGytiProjectDetailsQuery);
	
				//Setting Proj Details
				Map<String, Object> paramMapForProjIds = new HashMap<String, Object>();
				paramMapForProjIds.put("projIds", projIds);
	
				LOGGER.info("projIds :: "+projIds);
				gytiProjectVOs = (ArrayList<GytiProjectVO>) namedParameterJdbcTemplate.query(getAllGytiProjectDetailsQuery, paramMapForProjIds, new RowMapper<GytiProjectVO>(){
	
					@Override
					public GytiProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
						GytiProjectVO gytiProjectVO = new GytiProjectVO();
						gytiProjectVO.setProjId(rs.getLong("PROJ_ID"));
						gytiProjectVO.setProjTitle(rs.getString("PROJ_TITLE"));
						gytiProjectVO.setProjDescription(rs.getString("PROJ_DESCRIPTION"));
						gytiProjectVO.setProjTeamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
						gytiProjectVO.setProjMentor1Id(rs.getLong("PROJ_MENTOR1_ID"));
						gytiProjectVO.setProjMentor2Id(rs.getLong("PROJ_MENTOR2_ID"));
						gytiProjectVO.setProjUniversity(rs.getString("PROJ_UNIVERSITY"));
						gytiProjectVO.setProjFacRgstrId(rs.getLong("PROJ_FAC_RGSTR_ID"));
						gytiProjectVO.setProjStatusId(rs.getInt("PROJ_STATUS_ID"));
						gytiProjectVO.setProjTeamId(rs.getLong("TEAM_ID"));
	
						return gytiProjectVO;
					}
	
				});
				for(GytiProjectVO gytiProjectObj : gytiProjects){
					for(GytiProjectVO gytiProjectVO : gytiProjectVOs){
						if(gytiProjectObj.getProjId()== gytiProjectVO.getProjId()){
							gytiProjectObj.setProjTitle(gytiProjectVO.getProjTitle());
							gytiProjectObj.setProjDescription(gytiProjectVO.getProjDescription());
							gytiProjectObj.setProjTeamLeaderId(gytiProjectVO.getProjTeamLeaderId());
							gytiProjectObj.setProjMentor1Id(gytiProjectVO.getProjMentor1Id());
							gytiProjectObj.setProjMentor2Id(gytiProjectVO.getProjMentor2Id());
							gytiProjectObj.setProjUniversity(gytiProjectVO.getProjUniversity());
							gytiProjectObj.setProjFacRgstrId(gytiProjectVO.getProjFacRgstrId());
							gytiProjectObj.setProjStatusId(gytiProjectVO.getProjStatusId());
							gytiProjectObj.setProjTeamId(gytiProjectVO.getProjTeamId());
						}
					}
				}
	
				

			}
		} catch (Exception e) {
			LOGGER.error("Error while getting latest gytiProjects :", e);
			throw new GetAllGytiProjectException("Error while getting latest gytiProjects : "+ e.getMessage());
		}

		return gytiProjects;
	}
	
	public ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> getSuggestedReviewersByLoggedInReviewer(long assignedBy) throws GetSuggestedReviewersException{
		ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> suggestedReviews=null;
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getAllSuggestedReviewsRatingIdsQuery = rbundle.getString("GET_ALL_SUGGESTED_REVIEWS_RATING_ID'S_QUERY");
		String getAllSuggestedReviewsInfoQuery = rbundle.getString("GET_ALL_SUGGESTED_REVIEWS_INFO_QUERY");
		String getSuggestedReviewProjTitleQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_TITLE_QUERY");
		String getSuggestedReviewProjBranchListQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_BRANCH_LIST_QUERY");
		String getSuggestedReviewProjAssignedByNameQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_REVIEWER_NAME_QUERY");
		String getSuggestedReviewProjReviewerNameQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_REVIEWER_NAME_QUERY");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Long> ratingIds=new ArrayList<Long>();
		try {
				LOGGER.info("getAllSuggestedReviewsRatingIdsQuery :: "+getAllSuggestedReviewsRatingIdsQuery);
				Map<String, Object> paramMapForAssignedById = new HashMap<String, Object>();
				paramMapForAssignedById.put("assignedBy", assignedBy);
				
				ratingIds = (ArrayList<Long>) namedParameterJdbcTemplate.queryForList(getAllSuggestedReviewsRatingIdsQuery, paramMapForAssignedById, Long.class);
				LOGGER.info("List of suugested rating Ids rating Ids " +ratingIds);
				LOGGER.info("rating Ids " +ratingIds.size());
				if(ratingIds.size()>0){
						LOGGER.info("getAllSuggestedReviewsInfoQuery for rating Ids " +ratingIds+ " :: "+ getAllSuggestedReviewsInfoQuery);
						Map<String, Object> paramMapForRatingIds = new HashMap<String, Object>();
						paramMapForRatingIds.put("ratingIds", ratingIds);
						
						suggestedReviews=(ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO>) namedParameterJdbcTemplate.query(getAllSuggestedReviewsInfoQuery, paramMapForRatingIds,
								new RowMapper<SuggestedProjectForReviewByLoggedInReviewerVO>(){
	
							@Override
							public SuggestedProjectForReviewByLoggedInReviewerVO mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								SuggestedProjectForReviewByLoggedInReviewerVO suggestedReviewInfo=new SuggestedProjectForReviewByLoggedInReviewerVO();
								
								suggestedReviewInfo.setRatingId(rs.getLong("RATING_ID"));
								suggestedReviewInfo.setAssignedBy(rs.getLong("ASSIGNED_BY"));
								suggestedReviewInfo.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
								suggestedReviewInfo.setProjId(rs.getLong("PROJ_ID"));
								suggestedReviewInfo.setReviewStartDate(rs.getDate("REVIEW_START_DATE"));
								suggestedReviewInfo.setRevRatingPercentage(rs.getFloat("REV_RATING_PERCENTAGE"));
								suggestedReviewInfo.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
								suggestedReviewInfo.setStatus(rs.getString("STATUS"));
								
								return suggestedReviewInfo;
							}
						
						});
					
				}
				else{
					throw new GetSuggestedReviewersException("You haven't Suggested any projects.","Failed To retrieve suggested reviewers");
				}
				
				if(suggestedReviews.size()>0){
					
					for(SuggestedProjectForReviewByLoggedInReviewerVO suggestedReview:suggestedReviews){
						
						LOGGER.info("getSuggestedReviewProjTitleQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjTitleQuery);
						Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
						paramMapForProjId.put("projId", suggestedReview.getProjId());
						
						String projTitle = jdbcTemplate.queryForObject(getSuggestedReviewProjTitleQuery, new Object[] {suggestedReview.getProjId()},String.class);
						suggestedReview.setProjTitle(projTitle);
						
						LOGGER.info("getSuggestedReviewProjBranchListQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjBranchListQuery);
						List<String> projBranches=new ArrayList<String>();
						
						projBranches =(ArrayList<String>) namedParameterJdbcTemplate.query(getSuggestedReviewProjBranchListQuery, paramMapForProjId, new RowMapper<String>() {
	
							@Override
							public String mapRow(ResultSet rs, int rowNum) throws SQLException {
								
								return rs.getString("PROJ_BRANCH_DESC");
							}
						});
						suggestedReview.setProjBranchList(projBranches);
						
						LOGGER.info("getSuggestedReviewProjAssignedByNameQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjAssignedByNameQuery);
	
						String assignedByName = jdbcTemplate.queryForObject(getSuggestedReviewProjAssignedByNameQuery, new Object[] {suggestedReview.getAssignedBy()},String.class);
						suggestedReview.setAssignedByName(assignedByName);
						
						LOGGER.info("getSuggestedReviewProjReviewerNameQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjReviewerNameQuery);
	
						String reviewerName = jdbcTemplate.queryForObject(getSuggestedReviewProjReviewerNameQuery, new Object[] {suggestedReview.getRevRgstrId()},String.class);
						suggestedReview.setReviewerName(reviewerName);
					}
				}
			
		} catch (GetSuggestedReviewersException e) {
			LOGGER.error("Error while retrieving suggested reviewers List:", e);
			//e.printStackTrace();
			throw new GetSuggestedReviewersException(e.getExceptionMessage(), e.getExceptionDetails());
		}
		catch (Exception e) {
			LOGGER.error("Error while retrieving suggested reviewers List:", e);
			//e.printStackTrace();
			throw new GetSuggestedReviewersException("Error while retrieving suggested reviewers List", e.getMessage());
		}
		
		return suggestedReviews;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ReviewRatingVO getRatingDetailsByReviewer(String ratingId) throws GetGytiProjectRatingDetailsException{
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String reviewRatingQuery = rbundle.getString("Get_rating_and_review_details_by_Reviewer");
		
		reviewRatingQuery = reviewRatingQuery.replace("&ratingId", ":ratingId");
		LOGGER.info("getProjBranchDetailsMastBranchQuery :: "+reviewRatingQuery);
		
		Map<String, String> paramMapForRatingId = new HashMap<String, String>();
		paramMapForRatingId.put("ratingId", ratingId);
		LOGGER.info("rating Id :: "+paramMapForRatingId);
		ReviewRatingVO reviewDetailsByReviwer=null;
		try {
			NamedParameterJdbcTemplate namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			reviewDetailsByReviwer= (ReviewRatingVO) namedParameterjdbcTemplate.queryForObject(reviewRatingQuery,paramMapForRatingId,new BeanPropertyRowMapper(ReviewRatingVO.class));
			
		} catch (Exception e) {
			LOGGER.error("Error while getting raview and rating details::", e);
			throw new GetGytiProjectRatingDetailsException("Error while getting raview and rating details:: ", e.getMessage());
		}		
		return reviewDetailsByReviwer;	
	}
	

	public ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> getAllSuggestedReviewersList() throws GetSuggestedReviewersException{
		ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO> suggestedReviews=null;
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String adminGetAllSuggestedReviewsInfoQuery = rbundle.getString("ADMIN_GET_ALL_SUGGESTED_REVIEWS_INFO_QUERY");
		String getSuggestedReviewProjTitleQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_TITLE_QUERY");
		String getSuggestedReviewProjBranchListQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_BRANCH_LIST_QUERY");
		String getSuggestedReviewProjAssignedByNameQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_REVIEWER_NAME_QUERY");
		String getSuggestedReviewProjReviewerNameQuery = rbundle.getString("GET_SUGGESTED_REVIEW_PROJECT_REVIEWER_NAME_QUERY");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		try {
				
						LOGGER.info("adminGetAllSuggestedReviewsInfoQuery :: "+ adminGetAllSuggestedReviewsInfoQuery);
					
						suggestedReviews=(ArrayList<SuggestedProjectForReviewByLoggedInReviewerVO>) jdbcTemplate.query(adminGetAllSuggestedReviewsInfoQuery,
								new RowMapper<SuggestedProjectForReviewByLoggedInReviewerVO>(){
	
							@Override
							public SuggestedProjectForReviewByLoggedInReviewerVO mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								SuggestedProjectForReviewByLoggedInReviewerVO suggestedReviewInfo=new SuggestedProjectForReviewByLoggedInReviewerVO();
								
								suggestedReviewInfo.setRatingId(rs.getLong("RATING_ID"));
								suggestedReviewInfo.setAssignedBy(rs.getLong("ASSIGNED_BY"));
								suggestedReviewInfo.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
								suggestedReviewInfo.setProjId(rs.getLong("PROJ_ID"));
								suggestedReviewInfo.setReviewStartDate(rs.getDate("REVIEW_START_DATE"));
								suggestedReviewInfo.setRevRatingPercentage(rs.getFloat("REV_RATING_PERCENTAGE"));
								suggestedReviewInfo.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
								suggestedReviewInfo.setStatus(rs.getString("STATUS"));
								
								return suggestedReviewInfo;
							}
						
						});
					
				if(suggestedReviews.size()>0){
					
					for(SuggestedProjectForReviewByLoggedInReviewerVO suggestedReview:suggestedReviews){
						
						LOGGER.info("getSuggestedReviewProjTitleQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjTitleQuery);
						Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
						paramMapForProjId.put("projId", suggestedReview.getProjId());
						
						String projTitle = jdbcTemplate.queryForObject(getSuggestedReviewProjTitleQuery, new Object[] {suggestedReview.getProjId()},String.class);
						suggestedReview.setProjTitle(projTitle);
						
						LOGGER.info("getSuggestedReviewProjBranchListQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjBranchListQuery);
						List<String> projBranches=new ArrayList<String>();
						
						projBranches =(ArrayList<String>) namedParameterJdbcTemplate.query(getSuggestedReviewProjBranchListQuery, paramMapForProjId, new RowMapper<String>() {
	
							@Override
							public String mapRow(ResultSet rs, int rowNum) throws SQLException {
								
								return rs.getString("PROJ_BRANCH_DESC");
							}
						});
						suggestedReview.setProjBranchList(projBranches);
						
						LOGGER.info("getSuggestedReviewProjAssignedByNameQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjAssignedByNameQuery);
	
						String assignedByName = jdbcTemplate.queryForObject(getSuggestedReviewProjAssignedByNameQuery, new Object[] {suggestedReview.getAssignedBy()},String.class);
						suggestedReview.setAssignedByName(assignedByName);
						
						LOGGER.info("getSuggestedReviewProjReviewerNameQuery for project Id " +suggestedReview.getProjId()+ " :: "+ getSuggestedReviewProjReviewerNameQuery);
	
						String reviewerName = jdbcTemplate.queryForObject(getSuggestedReviewProjReviewerNameQuery, new Object[] {suggestedReview.getRevRgstrId()},String.class);
						suggestedReview.setReviewerName(reviewerName);
					}
				}
			
		}catch (Exception e) {
			LOGGER.error("Error while retrieving suggested reviewers List:", e);
			//e.printStackTrace();
			throw new GetSuggestedReviewersException("Error while retrieving suggested reviewers List", e.getMessage());
		}
		
		return suggestedReviews;
	}

	public String rejectSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException{
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String rejectSuggestedProjectForReviewStatusUpdateQuery= rbundle.getString("REJECT_SUGGESTED_PROJECT_FOR_REVIEW_STATUS_UPDATE_QUERY");
		String rejectSuggestedProjectForReviewValidationGetQuery=rbundle.getString("REJECT_SUGGESTED_PROJECT_FOR_REVIEW_VALIDATE_COUNT_QUERY");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
			LOGGER.info("rejectSuggestedProjectForReviewValidationGetQuery :: "+rejectSuggestedProjectForReviewValidationGetQuery);
			int rowCount = jdbcTemplate.queryForObject(rejectSuggestedProjectForReviewValidationGetQuery, new Object[] {getReviewRating.getProjId(),getReviewRating.getRevRgstrId()},Integer.class);
			
			if (rowCount > 0){
				//update Review Rating info
				LOGGER.info("rejectSuggestedProjectForReviewStatusUpdateQuery :: "+rejectSuggestedProjectForReviewStatusUpdateQuery);
				MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
				addInfoParameters.addValue("reviewStatus", "rejected");
				addInfoParameters.addValue("reviewEndDate", new Timestamp((new Date()).getTime()));
			    addInfoParameters.addValue("projId", getReviewRating.getProjId());
			    addInfoParameters.addValue("revRgstrId", getReviewRating.getRevRgstrId());
			    namedParameterJdbcTemplate.update(rejectSuggestedProjectForReviewStatusUpdateQuery, addInfoParameters);
				}
				else{
					return"N";
				}
		} catch (Exception e) {
			LOGGER.error("Error while Updating the status to rejected:", e);
			//e.printStackTrace();
			throw new RejectSuggestedProjectForReviewException("Error while Updating the status to rejected", e.getMessage());
		}
		return"Y";
		
	}

	public long gytiInnovationCount() throws GytiInnovationCountException{
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiInnovationCount= rbundle.getString("GYTI_INNOVATION_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		long rowCount ;
		try {
			LOGGER.info("gytiInnovationCount :: "+gytiInnovationCount);
			rowCount = jdbcTemplate.queryForObject(gytiInnovationCount,Long.class);
		}catch (Exception e) {
			LOGGER.error("Error while fetching the innovation Count:", e);
			throw new GytiInnovationCountException("Error while fetching the innovation Count", e.getMessage());
		}	
		return rowCount;
	}
	
	public long gytiYearWiseInnovationCount(int year) throws GytiInnovationCountException{
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiYearWiseInnovationCount= rbundle.getString("GYTI_INNOVATION_YEAR_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		long rowCount ;
		try {
			LOGGER.info("gytiYearWiseInnovationCount :: "+gytiYearWiseInnovationCount);
			rowCount = jdbcTemplate.queryForObject(gytiYearWiseInnovationCount,new Object[] {year},Long.class);
		}catch (Exception e) {
			LOGGER.error("Error while fetching year wise innovation Count:", e);
			throw new GytiInnovationCountException("Error while fetching year wise innovation Count", e.getMessage());
		}	
		return rowCount;
	}
	
	public long gytiYearWiseReviewedInnovationCount(int year) throws GytiReviewedInnovationCountException{
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String gytiYearWiseReviewedInnovationCount= rbundle.getString("GYTI_REVIEWED_INNOVATION_YEARWISE_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		long rowCount ;
		try {
			LOGGER.info("gytiYearWiseReviewedInnovationCount :: "+gytiYearWiseReviewedInnovationCount);
			rowCount = jdbcTemplate.queryForObject(gytiYearWiseReviewedInnovationCount,new Object[] {year},Long.class);
		}catch (Exception e) {
			LOGGER.error("Error while fetching year wise reviewed innovation Count:", e);
			throw new GytiReviewedInnovationCountException("Error while fetching year wise reviewed innovation Count", e.getMessage());
		}	
		return rowCount;
	}
	
	public List<TotalProjectsStatisticsVO> totalProjectsStatistics() throws TotalProectsStatisticsException {
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String totalProjectsTechpediaCount= rbundle.getString("TOTAL_PROJECTS_TECHPEDIA_COUNT_QUERY");
		String totalProjectsGYTICount= rbundle.getString("TOTAL_PROJECTS_GYTI_COUNT_QUERY");
		String totalProjectsGYTIReviewedCount= rbundle.getString("TOTAL_PROJECTS_GYTI_REVIEWED_COUNT_QUERY");
		String totalProjectsGYTIPendingWithReviewerCount= rbundle.getString("TOTAL_PROJECTS_GYTI_PENDING_WITH_REVIEWER_COUNT_QUERY");
		String totalProjectsGYTIAwardedCount= rbundle.getString("TOTAL_PROJECTS_GYTI_AWARDED_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<TotalProjectsStatisticsVO> totalProjectsStatistics = new ArrayList<TotalProjectsStatisticsVO>();
		try{
			LOGGER.info("totalProjectsTechpediaCount :: "+totalProjectsTechpediaCount);
			TotalProjectsStatisticsVO totalProjectsTechpedia = new TotalProjectsStatisticsVO();
			totalProjectsTechpedia.setStatus("Total Submitted Projects");
			totalProjectsTechpedia.setValue(jdbcTemplate.queryForObject(totalProjectsTechpediaCount,Long.class));
			totalProjectsStatistics.add(totalProjectsTechpedia);
			
			LOGGER.info("totalProjectsGYTICount :: "+totalProjectsGYTICount);
			TotalProjectsStatisticsVO totalProjectsGYTI = new TotalProjectsStatisticsVO();
			totalProjectsGYTI.setStatus("Applied for GYTI Award");
			totalProjectsGYTI.setValue(jdbcTemplate.queryForObject(totalProjectsGYTICount,Long.class));
			totalProjectsStatistics.add(totalProjectsGYTI);
			
			LOGGER.info("totalProjectsGYTIReviewedCount :: "+totalProjectsGYTIReviewedCount);
			TotalProjectsStatisticsVO totalProjectsGYTIReviewed = new TotalProjectsStatisticsVO();
			totalProjectsGYTIReviewed.setStatus("Review Done");
			totalProjectsGYTIReviewed.setValue(jdbcTemplate.queryForObject(totalProjectsGYTIReviewedCount,Long.class));
			totalProjectsStatistics.add(totalProjectsGYTIReviewed);
			
			LOGGER.info("totalProjectsGYTIPendingYearWiseCount");
			TotalProjectsStatisticsVO totalProjectsGYTIPending = new TotalProjectsStatisticsVO();
			totalProjectsGYTIPending.setStatus("Pending for Review");
			totalProjectsGYTIPending.setValue(totalProjectsGYTI.getValue() - totalProjectsGYTIReviewed.getValue());
			totalProjectsStatistics.add(totalProjectsGYTIPending);
			
			LOGGER.info("totalProjectsGYTIPendingWithReviewerCount :: "+totalProjectsGYTIPendingWithReviewerCount);
			TotalProjectsStatisticsVO totalProjectsGYTIPendingWithReviewer = new TotalProjectsStatisticsVO();
			totalProjectsGYTIPendingWithReviewer.setStatus("Pending With Reviewer");
			totalProjectsGYTIPendingWithReviewer.setValue(jdbcTemplate.queryForObject(totalProjectsGYTIPendingWithReviewerCount,Long.class));
			totalProjectsStatistics.add(totalProjectsGYTIPendingWithReviewer);
			
			LOGGER.info("totalProjectsGYTIAwardedCount :: "+totalProjectsGYTIAwardedCount);
			TotalProjectsStatisticsVO totalProjectsGYTIAwarded= new TotalProjectsStatisticsVO();
			totalProjectsGYTIAwarded.setStatus("Total GYTI Awrded Projects");
			totalProjectsGYTIAwarded.setValue(jdbcTemplate.queryForObject(totalProjectsGYTIAwardedCount,Long.class));
			totalProjectsStatistics.add(totalProjectsGYTIAwarded);
		}catch (Exception e){
			LOGGER.error("Error while fetching total projects count:", e);
			throw new TotalProectsStatisticsException("Error while fetching total projects count "+ e.getMessage());
		}
		return totalProjectsStatistics;
		
	}
	
	public Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWiseStatistics() throws TotalProectsYearWiseStatisticsException {
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String getYearListQuery= rbundle.getString("GYTI_AWARD_YEAR_LIST_GET_QUERY");
		String totalProjectsTechpediaYearWiseCount= rbundle.getString("TOTAL_PROJECTS_TECHPEDIA_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIReviewedYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_REVIEWED_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIPendingWithReviewerYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_PENDING_WITH_REVIEWER_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIAwardedYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_AWARDED_YEARWISE_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		List<Long> years = new ArrayList<Long>();
		Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWise = new HashMap<String, List<TotalProjectsYearWiseStatisticsVO>>();
		try{
			LOGGER.info("getYearListQuery :: "+getYearListQuery);
			Map<String, Object> paramMapForAwardYearsList = new HashMap<String, Object>();
			paramMapForAwardYearsList.put("awardYears", years);
			years = namedParameterJdbcTemplate.queryForList(getYearListQuery, paramMapForAwardYearsList, Long.class);
			
			if(years.size()>0){
				for(long year : years){
					List<TotalProjectsYearWiseStatisticsVO> totalProjectsStatistics = new ArrayList<TotalProjectsYearWiseStatisticsVO>();
/*					LOGGER.info("totalProjectsTechpediaYearWiseCount :: "+totalProjectsTechpediaYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsTechpediaYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsTechpediaYearWise.setSector("Total Submitted Projects");
					totalProjectsTechpediaYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsTechpediaYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsTechpediaYearWise);*/
					
					LOGGER.info("totalProjectsGYTIYearWiseCount :: "+totalProjectsGYTIYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIYearWise.setSector("Applied for GYTI Award");
					totalProjectsGYTIYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIYearWise);
					
					LOGGER.info("totalProjectsGYTIReviewedYearWiseCount :: "+totalProjectsGYTIReviewedYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIReviewedYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIReviewedYearWise.setSector("Review Done");
					totalProjectsGYTIReviewedYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIReviewedYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIReviewedYearWise);
					
					LOGGER.info("totalProjectsGYTIPendingYearWiseCount");
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIPendingYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIPendingYearWise.setSector("Pending for Review");
					totalProjectsGYTIPendingYearWise.setSize(totalProjectsGYTIYearWise.getSize() - totalProjectsGYTIReviewedYearWise.getSize());
					totalProjectsStatistics.add(totalProjectsGYTIPendingYearWise);
					
					LOGGER.info("totalProjectsGYTIPendingWithReviewerYearWiseCount :: "+totalProjectsGYTIPendingWithReviewerYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIPendingWithReviewerYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIPendingWithReviewerYearWise.setSector("Pending With Reviewer");
					totalProjectsGYTIPendingWithReviewerYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIPendingWithReviewerYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIPendingWithReviewerYearWise);
					
					LOGGER.info("totalProjectsGYTIAwardedYearWiseCount :: "+totalProjectsGYTIAwardedYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIAwardedYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIAwardedYearWise.setSector("Total GYTI Awrded Projects");
					totalProjectsGYTIAwardedYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIAwardedYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIAwardedYearWise);
					
					totalProjectsYearWise.put(String.valueOf(year), totalProjectsStatistics);
				}
			}
		}catch (Exception e){
			LOGGER.error("Error while fetching total projects year wise count :", e);
			throw new TotalProectsYearWiseStatisticsException("Error while fetching total projects year wise count "+ e.getMessage());
		}
		return totalProjectsYearWise;
			
	}
	
	public Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsInAYearStatistics(int year) throws TotalProectsYearWiseStatisticsException {
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String totalProjectsTechpediaYearWiseCount= rbundle.getString("TOTAL_PROJECTS_TECHPEDIA_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIReviewedYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_REVIEWED_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIPendingWithReviewerYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_PENDING_WITH_REVIEWER_YEARWISE_COUNT_QUERY");
		String totalProjectsGYTIAwardedYearWiseCount= rbundle.getString("TOTAL_PROJECTS_GYTI_AWARDED_YEARWISE_COUNT_QUERY");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Map<String, List<TotalProjectsYearWiseStatisticsVO>> totalProjectsYearWise = new HashMap<String, List<TotalProjectsYearWiseStatisticsVO>>();
		try{
					List<TotalProjectsYearWiseStatisticsVO> totalProjectsStatistics = new ArrayList<TotalProjectsYearWiseStatisticsVO>();
					LOGGER.info("totalProjectsTechpediaYearWiseCount :: "+totalProjectsTechpediaYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsTechpediaYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsTechpediaYearWise.setSector("Total Submitted Projects");
					totalProjectsTechpediaYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsTechpediaYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsTechpediaYearWise);
					
					LOGGER.info("totalProjectsGYTIYearWiseCount :: "+totalProjectsGYTIYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIYearWise.setSector("Applied for GYTI Award");
					totalProjectsGYTIYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIYearWise);
					
					LOGGER.info("totalProjectsGYTIReviewedYearWiseCount :: "+totalProjectsGYTIReviewedYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIReviewedYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIReviewedYearWise.setSector("Review Done");
					totalProjectsGYTIReviewedYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIReviewedYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIReviewedYearWise);
					
					LOGGER.info("totalProjectsGYTIPendingYearWiseCount");
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIPendingYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIPendingYearWise.setSector("Pending for Review");
					totalProjectsGYTIPendingYearWise.setSize(totalProjectsGYTIYearWise.getSize() - totalProjectsGYTIReviewedYearWise.getSize());
					totalProjectsStatistics.add(totalProjectsGYTIPendingYearWise);
					
					LOGGER.info("totalProjectsGYTIPendingWithReviewerYearWiseCount :: "+totalProjectsGYTIPendingWithReviewerYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIPendingWithReviewerYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIPendingWithReviewerYearWise.setSector("Pending With Reviewer");
					totalProjectsGYTIPendingWithReviewerYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIPendingWithReviewerYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIPendingWithReviewerYearWise);
					
					LOGGER.info("totalProjectsGYTIAwardedYearWiseCount :: "+totalProjectsGYTIAwardedYearWiseCount);
					TotalProjectsYearWiseStatisticsVO totalProjectsGYTIAwardedYearWise = new TotalProjectsYearWiseStatisticsVO();
					totalProjectsGYTIAwardedYearWise.setSector("Total GYTI Awrded Projects");
					totalProjectsGYTIAwardedYearWise.setSize(jdbcTemplate.queryForObject(totalProjectsGYTIAwardedYearWiseCount,new Object[]{year},Long.class));
					totalProjectsStatistics.add(totalProjectsGYTIAwardedYearWise);
					
					totalProjectsYearWise.put(String.valueOf(year), totalProjectsStatistics);
		}catch (Exception e){
			LOGGER.error("Error while fetching total projects year wise count :", e);
			throw new TotalProectsYearWiseStatisticsException("Error while fetching total projects year wise count "+ e.getMessage());
		}
		return totalProjectsYearWise;
			
	}
	
	
	public String saveReviewRating(ReviewRatingVO reviewRating) throws ReviewRatingException {
		LOGGER.info("ProjectmanagementDAO.reviewRating :Start");
		ResourceBundle rbundle=ResourceBundle.getBundle("query");
		String reviewRatingInserQuery=rbundle.getString("REVIEW_RATING_INSERT_QUERY");
		String reviewRatingValidationQuery=rbundle.getString("REVIEW_RATING_VALIDATION_QUERY");
		String reviewRatingUpdateQuery=rbundle.getString("REVIEW_RATING_UPDATE_INSERT_QUERY");
		
		try {
			JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			LOGGER.info("reviewRatingValidationQuery :: "+reviewRatingValidationQuery);
			int rowCount = jdbcTemplate.queryForObject(reviewRatingValidationQuery, new Object[] {reviewRating.getRevRgstrId(),reviewRating.getProjId()},Integer.class);
				
			if (rowCount > 0){
				//If project is suggested update Review Rating info
				LOGGER.info("reviewRatingUpdateQuery :: "+reviewRatingUpdateQuery);
				MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
				addInfoParameters.addValue("projTeamLeaderId", reviewRating.getProjteamLeaderId());
				addInfoParameters.addValue("revRecommendation", reviewRating.getRevRecommendation());
				addInfoParameters.addValue("revNovelty", reviewRating.getRevNovelty());
				addInfoParameters.addValue("revTechnicalRigor", reviewRating.getRevTechnicalRigor());
				addInfoParameters.addValue("revSocialApplication", reviewRating.getRevSocialApplication());
				addInfoParameters.addValue("revFrugality", reviewRating.getRevFrugality());
				addInfoParameters.addValue("revRatingPercentage", reviewRating.getRevRatingPercentage());
				addInfoParameters.addValue("revComments", reviewRating.getRevComments());
				addInfoParameters.addValue("revSuggestedLinks", reviewRating.getRevSuggestedLinks());
				addInfoParameters.addValue("canIdeaBeTakenForward", reviewRating.getCanIdeaBeTakenForward());
				addInfoParameters.addValue("canIdeaBeTakenForwardRemarks", reviewRating.getCanIdeaBeTakenForwardRemarks());
				addInfoParameters.addValue("moreInfoNeeded", reviewRating.getMoreInfoNeeded());
				addInfoParameters.addValue("moreInfoNeededRemarks", reviewRating.getMoreInfoNeededRemarks());
				addInfoParameters.addValue("suggestToOtherRev", reviewRating.getSuggestToOtherRev());
				addInfoParameters.addValue("reviewEndDate", new Timestamp((new Date()).getTime()));
				addInfoParameters.addValue("projId", reviewRating.getProjId());
				addInfoParameters.addValue("revRgstrId", reviewRating.getRevRgstrId());
				addInfoParameters.addValue("status", "inProgress");
				int noOfRowAffected=namedParameterJdbcTemplate.update(reviewRatingUpdateQuery, addInfoParameters);
				LOGGER.info("rows affected :: " + noOfRowAffected);
				if (noOfRowAffected>0){
					return "Y";
				}
				
			}
			else{//if project is not suggested insert new record
					LOGGER.info("reviewRatingInserQuery"+reviewRatingInserQuery);
					int noOfRowAffected=jdbcTemplate.update(reviewRatingInserQuery,new PreparedStatementSetter(){
					public void setValues(PreparedStatement ps) throws SQLException {
	
						ps.setLong(1, reviewRating.getRatingId());
						ps.setLong(2, reviewRating.getRevRgstrId());
						ps.setLong(3, reviewRating.getRevRgstrId());
						ps.setLong(4, reviewRating.getProjteamLeaderId());
						ps.setLong(5, reviewRating.getProjId());
	
						Timestamp reviewStartDate = new Timestamp((new Date()).getTime());
	
						ps.setTimestamp(6, reviewStartDate);
						ps.setString(7, reviewRating.getRevRecommendation());
						ps.setInt(8, reviewRating.getRevNovelty());
						ps.setInt(9, reviewRating.getRevTechnicalRigor());
						ps.setInt(10, reviewRating.getRevSocialApplication());
						ps.setLong(11, reviewRating.getRevFrugality());
						ps.setFloat(12, reviewRating.getRevRatingPercentage());
						ps.setString(13, reviewRating.getRevComments());
						ps.setString(14, reviewRating.getRevSuggestedLinks());
						ps.setString(15,  String.valueOf(reviewRating.getCanIdeaBeTakenForward()));
						ps.setString(16, reviewRating.getCanIdeaBeTakenForwardRemarks());
						ps.setString(17, String.valueOf(reviewRating.getMoreInfoNeeded()));
						ps.setString(18, reviewRating.getMoreInfoNeededRemarks());
						ps.setString(19, String.valueOf(reviewRating.getSuggestToOtherRev()));
						
						Timestamp reviewEndDate = new Timestamp((new Date()).getTime());
						ps.setTimestamp(20, reviewEndDate);
						ps.setString(21, "inProgress");
					}
	
				});
					LOGGER.info("rows affected :: " + noOfRowAffected);
					if (noOfRowAffected>0){
						return "Y";
					}
			}
			
		} catch (Exception e) {
			LOGGER.error("Error while saving Review Rating : Ex :: ", e);
			throw new ReviewRatingException("Error while Saving Review Rating : "+ e.getMessage());

		}
		LOGGER.info("ProjectmanagementDAO.reviewRating :End");
		return "N";
	}
	
public String acceptSuggestedProjectForReview(GetReviewRatingVO getReviewRating) throws RejectSuggestedProjectForReviewException{
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		String acceptSuggestedProjectForReviewStatusUpdateQuery= rbundle.getString("ACCEPT_SUGGESTED_PROJECT_FOR_REVIEW_STATUS_UPDATE_QUERY");
		String acceptSuggestedProjectForReviewValidationGetQuery=rbundle.getString("ACCEPT_SUGGESTED_PROJECT_FOR_REVIEW_VALIDATE_COUNT_QUERY");
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
			LOGGER.info("acceptSuggestedProjectForReviewValidationGetQuery :: "+acceptSuggestedProjectForReviewValidationGetQuery);
			int rowCount = jdbcTemplate.queryForObject(acceptSuggestedProjectForReviewValidationGetQuery, new Object[] {getReviewRating.getProjId(),getReviewRating.getRevRgstrId()},Integer.class);
			
			if (rowCount > 0){
				//update Review Rating info
				LOGGER.info("acceptSuggestedProjectForReviewStatusUpdateQuery :: "+acceptSuggestedProjectForReviewStatusUpdateQuery);
				MapSqlParameterSource addInfoParameters = new MapSqlParameterSource();
				addInfoParameters.addValue("reviewStatus", "accepted");
				addInfoParameters.addValue("reviewEndDate", new Timestamp((new Date()).getTime()));
			    addInfoParameters.addValue("projId", getReviewRating.getProjId());
			    addInfoParameters.addValue("revRgstrId", getReviewRating.getRevRgstrId());
			    namedParameterJdbcTemplate.update(acceptSuggestedProjectForReviewStatusUpdateQuery, addInfoParameters);
				}
				else{
					return"N";
				}
		} catch (Exception e) {
			LOGGER.error("Error while Updating the status to acceptted:", e);
			//e.printStackTrace();
			throw new RejectSuggestedProjectForReviewException("Error while Updating the status to accepted", e.getMessage());
		}
		return"Y";
		
	}
}

