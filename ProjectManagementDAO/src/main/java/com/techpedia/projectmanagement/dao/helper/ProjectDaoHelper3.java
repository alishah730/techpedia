/**
 * 
 */
package com.techpedia.projectmanagement.dao.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.techpedia.chiper.ChiperUtils;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberResponseVO;
import com.techpedia.projectmanagement.bean.AddNewTeamMemberVO;
import com.techpedia.projectmanagement.bean.AssignedByAndReviewDoneByMapper;
import com.techpedia.projectmanagement.bean.GetAllReviewsByLoggedInReviewerAndOthersResponse;
import com.techpedia.projectmanagement.bean.OverallCalculatedReviewRatingVO;
import com.techpedia.projectmanagement.bean.ProjAwardVO;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyResponseVO;
import com.techpedia.projectmanagement.bean.RegisterNewFacultyVO;
import com.techpedia.projectmanagement.bean.ReviewRatingVO;
import com.techpedia.projectmanagement.bean.ReviewerVO;
import com.techpedia.projectmanagement.bean.UserProfileVO;
import com.techpedia.projectmanagement.bean.UsrMngtAddressVO;
import com.techpedia.projectmanagement.bean.UsrMngtContactInfoVO;
import com.techpedia.projectmanagement.bean.UsrMngtFacultyVO;
import com.techpedia.projectmanagement.bean.UsrMngtPasswdVO;
import com.techpedia.projectmanagement.bean.UsrMngtStudentVO;
import com.techpedia.projectmanagement.entity.ProjectMaster;
import com.techpedia.projectmanagement.exception.AddNewTeamMemberException;
import com.techpedia.projectmanagement.exception.GetAllReviewsException;
import com.techpedia.projectmanagement.util.OverAllRatingsComparator;

/**
 * @author 455959
 *
 */
@Component
public class ProjectDaoHelper3 {
	
	@Autowired
	private DataSource dataSource;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDaoHelper3.class.getName());

	public GetAllReviewsByLoggedInReviewerAndOthersResponse getAllReviewsByLoggedInReviewerAndOthers(String revRgstrId, String awardYear) throws GetAllReviewsException{
		
		GetAllReviewsByLoggedInReviewerAndOthersResponse getAllReviewsByLoggedInReviewerAndOthersResponse = new GetAllReviewsByLoggedInReviewerAndOthersResponse();
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<ReviewRatingVO> reviewRatingVOs = new ArrayList<ReviewRatingVO>();
		List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings = new ArrayList<OverallCalculatedReviewRatingVO>();
		Set<Long> participantIds = new HashSet<Long>();
		List<ProjAwardVO> projAwardVOs = new ArrayList<ProjAwardVO>();
		try{
			
			String getAllReviewsYearwiseProjIdsQuery = rbundle.getString("GET_ALL_REVIEWS_TRS_REVIEW_RATING_YEARWISE_PROJIDS_QUERY");
			getAllReviewsYearwiseProjIdsQuery = getAllReviewsYearwiseProjIdsQuery.replaceAll("&AWARDYEAR", ":awardYear");
			LOGGER.info("getAllReviewsYearwiseProjIdsQuery :: "+getAllReviewsYearwiseProjIdsQuery);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			Map<String, Object> paramMapForAwardYear = new HashMap<String, Object>();
			paramMapForAwardYear.put("awardYear", awardYear);
			LOGGER.info("awardYear :: "+awardYear);
			
			projAwardVOs = (ArrayList<ProjAwardVO>) namedParameterJdbcTemplate.query(getAllReviewsYearwiseProjIdsQuery, paramMapForAwardYear, new RowMapper<ProjAwardVO>(){
	
				@Override
				public ProjAwardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ProjAwardVO projectAward = new ProjAwardVO();
					projectAward.setProjId(rs.getLong("PROJ_ID"));
					projectAward.setAwardId(rs.getInt("AWARD_ID"));
					projectAward.setAwardYear(rs.getString("AWARD_YEAR"));
					projectAward.setAwardWon(rs.getString("AWARD_WON"));
					return projectAward;
				}
	
			});
			Set<Long> projectIds = new HashSet<Long>();
			for(ProjAwardVO projAwardVO : projAwardVOs){
				projectIds.add(projAwardVO.getProjId());
			}
			if(projectIds.size()>0){
			
				String getAllReviewsTrsReviewRatingQuery = rbundle.getString("GET_ALL_REVIEWS_TRS_REVIEW_RATING_QUERY");
				getAllReviewsTrsReviewRatingQuery = getAllReviewsTrsReviewRatingQuery.replaceAll("&PROJIDS", ":projIds");
				LOGGER.info("getAllReviewsTrsReviewRatingQuery :: "+getAllReviewsTrsReviewRatingQuery);
				
				Map<String, Object> paramMapForProjIds = new HashMap<String, Object>();
				paramMapForProjIds.put("projIds", projectIds);
				LOGGER.info("projectIds :: "+projectIds);
				
				reviewRatingVOs = (ArrayList<ReviewRatingVO>) namedParameterJdbcTemplate.query(getAllReviewsTrsReviewRatingQuery, paramMapForProjIds, new RowMapper<ReviewRatingVO>(){
	
				@Override
				public ReviewRatingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ReviewRatingVO reviewRatingVO = new ReviewRatingVO();
					reviewRatingVO.setRatingId(rs.getLong("RATING_ID"));
					reviewRatingVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
					reviewRatingVO.setAssignedBy(rs.getLong("ASSIGNED_BY"));
					reviewRatingVO.setProjteamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					reviewRatingVO.setProjId(rs.getLong("PROJ_ID"));
					reviewRatingVO.setReviewStartDate(rs.getTimestamp("REVIEW_START_DATE"));
					reviewRatingVO.setRevRecommendation(rs.getString("REV_RECOMMENDATION"));
					reviewRatingVO.setRevNovelty(rs.getInt("REV_NOVELTY"));
					reviewRatingVO.setRevTechnicalRigor(rs.getInt("REV_TECHNICAL_RIGOR"));
					reviewRatingVO.setRevSocialApplication(rs.getInt("REV_SOCIAL_APPLICATION"));
					reviewRatingVO.setRevFrugality(rs.getLong("REV_FRUGALITY"));
					reviewRatingVO.setRevRatingPercentage(rs.getFloat("REV_RATING_PERCENTAGE"));
					reviewRatingVO.setRevComments(rs.getString("REV_COMMENTS"));
					reviewRatingVO.setRevSuggestedLinks(rs.getString("REV_SUGGESTED_LINKS"));
					reviewRatingVO.setCanIdeaBeTakenForward(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD"));
					reviewRatingVO.setCanIdeaBeTakenForwardRemarks(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD_REMARKS"));
					reviewRatingVO.setMoreInfoNeeded(rs.getString("MORE_INFO_NEEDED"));
					reviewRatingVO.setMoreInfoNeededRemarks(rs.getString("MORE_INFO_NEEDED_REMARKS"));
					reviewRatingVO.setSuggestToOtherRev(rs.getString("SUGGEST_TO_OTHER_REV"));
					reviewRatingVO.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
					reviewRatingVO.setStatus(rs.getString("STATUS"));
	
					return reviewRatingVO;
				}
	
			});
			for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
				participantIds.add(reviewRatingVO.getProjId());
			}
			if(participantIds.size()>0){
				
				List<ProjectMaster> projects = new ArrayList<ProjectMaster>();
				String getProjTitleMastProjectsDetailQuery = rbundle.getString("GET_PROJ_TITLE_MAST_PROJECTS_DETAIL_QUERY");
				getProjTitleMastProjectsDetailQuery = getProjTitleMastProjectsDetailQuery.replaceAll("&PROJIDS", ":projIds");
				LOGGER.info("getProjTitleMastProjectsDetailQuery :: "+getProjTitleMastProjectsDetailQuery);
				
				Map<String, Object> paramMapForParticipantIds = new HashMap<String, Object>();
				paramMapForParticipantIds.put("projIds", participantIds);
				LOGGER.info("participantIds :: "+participantIds);
		
				projects = (ArrayList<ProjectMaster>) namedParameterJdbcTemplate.query(getProjTitleMastProjectsDetailQuery, paramMapForParticipantIds, new RowMapper<ProjectMaster>(){
		
					@Override
					public ProjectMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						ProjectMaster project = new ProjectMaster();
						project.setProjId(rs.getLong("PROJ_ID"));
						project.setProjTitle(rs.getString("PROJ_TITLE"));
						return project;
					}
		
				});
			
				for(Long participantId : participantIds){
					OverallCalculatedReviewRatingVO overallCalculatedReviewRating = new OverallCalculatedReviewRatingVO();
					overallCalculatedReviewRating.setParticipantId(participantId);
					overallCalculatedReviewRatings.add(overallCalculatedReviewRating);
					
					List<String> projBranches = new ArrayList<String>();
					String getProjBranchDetailsMastBranchQuery = rbundle.getString("GET_PROJ_BRANCH_DETAILS_MAST_BRANCH_QUERY");
					getProjBranchDetailsMastBranchQuery = getProjBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
					LOGGER.info("getProjBranchDetailsMastBranchQuery :: "+getProjBranchDetailsMastBranchQuery);
					
					Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
					paramMapForProjId.put("projId", participantId);
					LOGGER.info("participantId :: "+participantId);
					
					projBranches = (ArrayList<String>) namedParameterJdbcTemplate.query(getProjBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<String>(){
		
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
							return rs.getString("PROJ_BRANCH_DESC");
						}
		
					});
					overallCalculatedReviewRating.setProjCategory(projBranches);
				}
			
				List<ReviewerVO> reviewerVOs = new ArrayList<ReviewerVO>();
				String getAllReviewerMastDetailsQuery = rbundle.getString("GET_ALL_REVIEWER_MAST_DETAILS_QUERY");
				LOGGER.info("getAllReviewerMastDetailsQuery :: "+getAllReviewerMastDetailsQuery);
				
				reviewerVOs = (ArrayList<ReviewerVO>) jdbcTemplate.query(getAllReviewerMastDetailsQuery, new RowMapper<ReviewerVO>(){
		
					@Override
					public ReviewerVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						ReviewerVO reviewerVO = new ReviewerVO();
						reviewerVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
						reviewerVO.setRevFname(rs.getString("REV_FNAME"));
						reviewerVO.setRevMname(rs.getString("REV_MNAME"));
						reviewerVO.setRevLname(rs.getString("REV_LNAME"));
						return reviewerVO;
					}
				});
					
				if(overallCalculatedReviewRatings.size()>0){
					for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
						int count = 0;
						float sumOfIndividualPercentages = 0;
						Set<AssignedByAndReviewDoneByMapper> assignedByAndReviewDoneByMapperSet = new LinkedHashSet<AssignedByAndReviewDoneByMapper>();
						Date reviewedDate = reviewRatingVOs.get(0).getReviewEndDate();
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							if(reviewRatingVO.getProjId() == overallCalculatedReviewRating.getParticipantId()){
								//Percentage calculation
								sumOfIndividualPercentages = reviewRatingVO.getRevRatingPercentage();
								count = count+1;
								//Assigned By 
								AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper = new AssignedByAndReviewDoneByMapper();
								String assignedByName = "";
								for(ReviewerVO reviewerVO : reviewerVOs){
									if(reviewRatingVO.getAssignedBy() == reviewerVO.getRevRgstrId()){
										assignedByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null) ? "":" ") 
												+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null) ? "":" ")
												+reviewerVO.getRevLname();
									}
								}
								String reviewDoneByName = "";
								for(ReviewerVO reviewerVO : reviewerVOs){
									
									if(reviewRatingVO.getRevRgstrId() == reviewerVO.getRevRgstrId()){
										reviewDoneByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null || reviewerVO.getRevMname().length()==0) ? "":" ") 
												+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null || reviewerVO.getRevLname().length()==0) ? "":" ")
												+reviewerVO.getRevLname();
									}
									LOGGER.info("reviewDoneByName:: "+reviewDoneByName);
								}
								
								assignedByAndReviewDoneByMapper.setAssignedBy(reviewRatingVO.getAssignedBy());
								assignedByAndReviewDoneByMapper.setAssignedByName(assignedByName);
								assignedByAndReviewDoneByMapper.setReviewDoneBy(reviewRatingVO.getRevRgstrId());
								assignedByAndReviewDoneByMapper.setReviewDoneByName(reviewDoneByName);
								assignedByAndReviewDoneByMapper.setRatingId(reviewRatingVO.getRatingId());
								assignedByAndReviewDoneByMapperSet.add(assignedByAndReviewDoneByMapper);
								//Reviewed Date
								if(reviewedDate.compareTo(reviewRatingVO.getReviewEndDate())>0){
									reviewedDate = reviewRatingVO.getReviewEndDate();
								}
							}
							float averageRating =  sumOfIndividualPercentages/count;
							String averageRatingUptoTwoDecimalPlaces = String.format("%.02f", averageRating);
							overallCalculatedReviewRating.setAverageRating(averageRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAssignedByAndReviewDoneByMapperSet(assignedByAndReviewDoneByMapperSet);
							overallCalculatedReviewRating.setReviewedDate(reviewedDate);
						}
						//project title  
						for(ProjectMaster project : projects){
							if(project.getProjId() == overallCalculatedReviewRating.getParticipantId()){
								overallCalculatedReviewRating.setProjTitle(project.getProjTitle());
							}
						}
						
					}
				}
			}
			List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByLoggedInReviewer = new ArrayList<OverallCalculatedReviewRatingVO>();
			List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatingsByOtherReviewers = new ArrayList<OverallCalculatedReviewRatingVO>();
			for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
				int reviewedByLoggedInReviewerCount = 0;
				for(AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper :overallCalculatedReviewRating.getAssignedByAndReviewDoneByMapperSet()){
					if(assignedByAndReviewDoneByMapper.getReviewDoneBy()==(Long.parseLong(revRgstrId))){
						reviewedByLoggedInReviewerCount++;
						
					}
				}
				if(reviewedByLoggedInReviewerCount>0){
					overallCalculatedReviewRatingsByLoggedInReviewer.add(overallCalculatedReviewRating);
					Collections.sort(overallCalculatedReviewRatingsByLoggedInReviewer, new OverAllRatingsComparator());
				}
				else{
					//overallCalculatedReviewRatingsByOtherReviewers.add(overallCalculatedReviewRating);
					Collections.sort(overallCalculatedReviewRatingsByOtherReviewers, new OverAllRatingsComparator());
				}
			}
			getAllReviewsByLoggedInReviewerAndOthersResponse.setOverallCalculatedReviewRatingsByLoggedInReviewer(overallCalculatedReviewRatingsByLoggedInReviewer);
			getAllReviewsByLoggedInReviewerAndOthersResponse.setOverallCalculatedReviewRatingsByOtherReviewers(overallCalculatedReviewRatingsByOtherReviewers);
			}
		}
		catch(Exception e){
			LOGGER.error("Error while getting all reviews for Logged in reviewer and Others :", e);
			throw new GetAllReviewsException("Error while getting all Reviews for Logged in reviewer and Others : "+ e.getMessage());
		}
		return getAllReviewsByLoggedInReviewerAndOthersResponse;
	}
	
	public List<OverallCalculatedReviewRatingVO> getAllReviews(String awardYear) throws GetAllReviewsException{
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		List<ReviewRatingVO> reviewRatingVOs = new ArrayList<ReviewRatingVO>();
		List<OverallCalculatedReviewRatingVO> overallCalculatedReviewRatings = new ArrayList<OverallCalculatedReviewRatingVO>();
		Set<Long> participantIds = new HashSet<Long>();
		List<ProjAwardVO> projAwardVOs = new ArrayList<ProjAwardVO>();
		try{
			
			String getAllReviewsYearwiseProjIdsQuery = rbundle.getString("GET_ALL_REVIEWS_TRS_REVIEW_RATING_YEARWISE_PROJIDS_QUERY");
			getAllReviewsYearwiseProjIdsQuery = getAllReviewsYearwiseProjIdsQuery.replaceAll("&AWARDYEAR", ":awardYear");
			LOGGER.info("getAllReviewsYearwiseProjIdsQuery :: "+getAllReviewsYearwiseProjIdsQuery);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			Map<String, Object> paramMapForAwardYear = new HashMap<String, Object>();
			paramMapForAwardYear.put("awardYear", awardYear);
			LOGGER.info("awardYear :: "+awardYear);
			
			projAwardVOs = (ArrayList<ProjAwardVO>) namedParameterJdbcTemplate.query(getAllReviewsYearwiseProjIdsQuery, paramMapForAwardYear, new RowMapper<ProjAwardVO>(){
	
				@Override
				public ProjAwardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ProjAwardVO projectAward = new ProjAwardVO();
					projectAward.setProjId(rs.getLong("PROJ_ID"));
					projectAward.setAwardId(rs.getInt("AWARD_ID"));
					projectAward.setAwardYear(rs.getString("AWARD_YEAR"));
					projectAward.setAwardWon(rs.getString("AWARD_WON"));
					return projectAward;
				}
	
			});
			Set<Long> projectIds = new HashSet<Long>();
			for(ProjAwardVO projAwardVO : projAwardVOs){
				projectIds.add(projAwardVO.getProjId());
			}
			if(projectIds.size()>0){
			
			
			String getAllReviewsTrsReviewRatingQuery = rbundle.getString("GET_ALL_REVIEWS_TRS_REVIEW_RATING_QUERY");
			getAllReviewsTrsReviewRatingQuery = getAllReviewsTrsReviewRatingQuery.replaceAll("&PROJIDS", ":projIds");
			LOGGER.info("getAllReviewsTrsReviewRatingQuery :: "+getAllReviewsTrsReviewRatingQuery);
			
			Map<String, Object> paramMapForProjIds = new HashMap<String, Object>();
			paramMapForProjIds.put("projIds", projectIds);
			LOGGER.info("projectIds :: "+projectIds);
			
			reviewRatingVOs = (ArrayList<ReviewRatingVO>) namedParameterJdbcTemplate.query(getAllReviewsTrsReviewRatingQuery, paramMapForProjIds, new RowMapper<ReviewRatingVO>(){
	
				@Override
				public ReviewRatingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ReviewRatingVO reviewRatingVO = new ReviewRatingVO();
					reviewRatingVO.setRatingId(rs.getLong("RATING_ID"));
					reviewRatingVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
					reviewRatingVO.setAssignedBy(rs.getLong("ASSIGNED_BY"));
					reviewRatingVO.setProjteamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					reviewRatingVO.setProjId(rs.getLong("PROJ_ID"));
					reviewRatingVO.setReviewStartDate(rs.getTimestamp("REVIEW_START_DATE"));
					reviewRatingVO.setRevRecommendation(rs.getString("REV_RECOMMENDATION"));
					reviewRatingVO.setRevNovelty(rs.getInt("REV_NOVELTY"));
					reviewRatingVO.setRevTechnicalRigor(rs.getInt("REV_TECHNICAL_RIGOR"));
					reviewRatingVO.setRevSocialApplication(rs.getInt("REV_SOCIAL_APPLICATION"));
					reviewRatingVO.setRevFrugality(rs.getLong("REV_FRUGALITY"));
					reviewRatingVO.setRevRatingPercentage(rs.getFloat("REV_RATING_PERCENTAGE"));
					reviewRatingVO.setRevComments(rs.getString("REV_COMMENTS"));
					reviewRatingVO.setRevSuggestedLinks(rs.getString("REV_SUGGESTED_LINKS"));
					reviewRatingVO.setCanIdeaBeTakenForward(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD"));
					reviewRatingVO.setCanIdeaBeTakenForwardRemarks(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD_REMARKS"));
					reviewRatingVO.setMoreInfoNeeded(rs.getString("MORE_INFO_NEEDED"));
					reviewRatingVO.setMoreInfoNeededRemarks(rs.getString("MORE_INFO_NEEDED_REMARKS"));
					reviewRatingVO.setSuggestToOtherRev(rs.getString("SUGGEST_TO_OTHER_REV"));
					reviewRatingVO.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
	
					return reviewRatingVO;
				}
	
			});
			
			for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
				participantIds.add(reviewRatingVO.getProjId());
			}
			if(participantIds.size()>0){
				
				List<ProjectMaster> projects = new ArrayList<ProjectMaster>();
				String getProjTitleMastProjectsDetailQuery = rbundle.getString("GET_PROJ_TITLE_MAST_PROJECTS_DETAIL_QUERY");
				getProjTitleMastProjectsDetailQuery = getProjTitleMastProjectsDetailQuery.replaceAll("&PROJIDS", ":projIds");
				LOGGER.info("getProjTitleMastProjectsDetailQuery :: "+getProjTitleMastProjectsDetailQuery);
				
				Map<String, Object> paramMapForParticipantIds = new HashMap<String, Object>();
				paramMapForParticipantIds.put("projIds", participantIds);
				LOGGER.info("participantIds :: "+participantIds);
				
				projects = (ArrayList<ProjectMaster>) namedParameterJdbcTemplate.query(getProjTitleMastProjectsDetailQuery, paramMapForParticipantIds, new RowMapper<ProjectMaster>(){
		
					@Override
					public ProjectMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						ProjectMaster project = new ProjectMaster();
						project.setProjId(rs.getLong("PROJ_ID"));
						project.setProjTitle(rs.getString("PROJ_TITLE"));
						return project;
					}
		
				});

	
			
				for(Long participantId : participantIds){
					OverallCalculatedReviewRatingVO overallCalculatedReviewRating = new OverallCalculatedReviewRatingVO();
					overallCalculatedReviewRating.setParticipantId(participantId);
					overallCalculatedReviewRatings.add(overallCalculatedReviewRating);
					
					List<String> projBranches = new ArrayList<String>();
					String getProjBranchDetailsMastBranchQuery = rbundle.getString("GET_PROJ_BRANCH_DETAILS_MAST_BRANCH_QUERY");
					getProjBranchDetailsMastBranchQuery = getProjBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
					LOGGER.info("getProjBranchDetailsMastBranchQuery :: "+getProjBranchDetailsMastBranchQuery);
					
					Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
					paramMapForProjId.put("projId", participantId);
					LOGGER.info("participantId :: "+participantId);
					
					projBranches = (ArrayList<String>) namedParameterJdbcTemplate.query(getProjBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<String>(){
		
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
							return rs.getString("PROJ_BRANCH_DESC");
						}
		
					});
					overallCalculatedReviewRating.setProjCategory(projBranches);
				}
			
				List<ReviewerVO> reviewerVOs = new ArrayList<ReviewerVO>();
				String getAllReviewerMastDetailsQuery = rbundle.getString("GET_ALL_REVIEWER_MAST_DETAILS_QUERY");
				LOGGER.info("getAllReviewerMastDetailsQuery :: "+getAllReviewerMastDetailsQuery);
				
				reviewerVOs = (ArrayList<ReviewerVO>) jdbcTemplate.query(getAllReviewerMastDetailsQuery, new RowMapper<ReviewerVO>(){
		
					@Override
					public ReviewerVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
						ReviewerVO reviewerVO = new ReviewerVO();
						reviewerVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
						reviewerVO.setRevFname(rs.getString("REV_FNAME"));
						reviewerVO.setRevMname(rs.getString("REV_MNAME"));
						reviewerVO.setRevLname(rs.getString("REV_LNAME"));
						return reviewerVO;
					}
				});
					
				if(overallCalculatedReviewRatings.size()>0){
					for(OverallCalculatedReviewRatingVO overallCalculatedReviewRating : overallCalculatedReviewRatings){
						int count = 0;
						float sumOfIndividualPercentages = 0;
						float sumOfIndividualFrugality = 0;
						float sumOfIndividualTechnicalRigor = 0;
						float sumOfIndividualNovelty = 0;
						float sumOfIndividualSocialApplication = 0;
						Set<AssignedByAndReviewDoneByMapper> assignedByAndReviewDoneByMapperSet = new LinkedHashSet<AssignedByAndReviewDoneByMapper>();
						Date reviewedDate = reviewRatingVOs.get(0).getReviewEndDate();
						for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
							if(reviewRatingVO.getProjId() == overallCalculatedReviewRating.getParticipantId()){
								//Percentage calculation
								sumOfIndividualPercentages = sumOfIndividualPercentages + reviewRatingVO.getRevRatingPercentage();
								sumOfIndividualFrugality = sumOfIndividualFrugality + reviewRatingVO.getRevFrugality();
								sumOfIndividualTechnicalRigor = sumOfIndividualTechnicalRigor + reviewRatingVO.getRevTechnicalRigor();
								sumOfIndividualNovelty = sumOfIndividualNovelty + reviewRatingVO.getRevNovelty();
								sumOfIndividualSocialApplication = sumOfIndividualSocialApplication + reviewRatingVO.getRevSocialApplication();
								count = count+1;
								//Assigned By 
								AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper = new AssignedByAndReviewDoneByMapper();
								String assignedByName = "";
								for(ReviewerVO reviewerVO : reviewerVOs){
									if(reviewRatingVO.getAssignedBy() == reviewerVO.getRevRgstrId()){
										assignedByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null) ? "":" ") 
												+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null) ? "":" ")
												+reviewerVO.getRevLname();
									}
								}
								String reviewDoneByName = "";
								for(ReviewerVO reviewerVO : reviewerVOs){
									if(reviewRatingVO.getRevRgstrId() == reviewerVO.getRevRgstrId()){
										reviewDoneByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null) ? "":" ") 
												+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null) ? "":" ")
												+reviewerVO.getRevLname();
									}
								}
								assignedByAndReviewDoneByMapper.setAssignedBy(reviewRatingVO.getAssignedBy());
								assignedByAndReviewDoneByMapper.setAssignedByName(assignedByName);
								assignedByAndReviewDoneByMapper.setReviewDoneBy(reviewRatingVO.getRevRgstrId());
								assignedByAndReviewDoneByMapper.setReviewDoneByName(reviewDoneByName);
								assignedByAndReviewDoneByMapper.setRatingId(reviewRatingVO.getRatingId());
								assignedByAndReviewDoneByMapper.setRevFrugality(reviewRatingVO.getRevFrugality());
								assignedByAndReviewDoneByMapper.setRevNovelty(reviewRatingVO.getRevNovelty());
								assignedByAndReviewDoneByMapper.setRevSocialApplication(reviewRatingVO.getRevSocialApplication());
								assignedByAndReviewDoneByMapper.setRevTechnicalRigor(reviewRatingVO.getRevTechnicalRigor());
								assignedByAndReviewDoneByMapperSet.add(assignedByAndReviewDoneByMapper);
								//Reviewed Date
								if(reviewedDate.compareTo(reviewRatingVO.getReviewEndDate())>0){
									reviewedDate = reviewRatingVO.getReviewEndDate();
								}
							}
							float averageRating =  sumOfIndividualPercentages/count;
							String averageRatingUptoTwoDecimalPlaces = String.format("%.02f", averageRating);
							
							float averageFrugalityRating = 10*(sumOfIndividualFrugality/count);
							String averageFrugalityRatingUptoTwoDecimalPlaces = String.format("%.02f", averageFrugalityRating);
							
							float averageTechnicalRigorRating =  10*(sumOfIndividualTechnicalRigor/count);
							String averageTechnicalRigorRatingUptoTwoDecimalPlaces = String.format("%.02f", averageTechnicalRigorRating);
							
							float averageNoveltyRating = 10*(sumOfIndividualNovelty/count);
							String averageNoveltyRatingUptoTwoDecimalPlaces = String.format("%.02f", averageNoveltyRating);
							
							float averageSocialApplicationRating =  10*(sumOfIndividualSocialApplication/count);
							String averageSocialApplicationRatingUptoTwoDecimalPlaces = String.format("%.02f", averageSocialApplicationRating);
							
							overallCalculatedReviewRating.setAverageFrugalityRating(averageFrugalityRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAverageNoveltyRating(averageNoveltyRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAverageSocialApplicationRating(averageSocialApplicationRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAverageTechnicalRigorRating(averageTechnicalRigorRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAverageRating(averageRatingUptoTwoDecimalPlaces);
							overallCalculatedReviewRating.setAssignedByAndReviewDoneByMapperSet(assignedByAndReviewDoneByMapperSet);
							overallCalculatedReviewRating.setReviewedDate(reviewedDate);
						}
						//project title  
						for(ProjectMaster project : projects){
							if(project.getProjId() == overallCalculatedReviewRating.getParticipantId()){
								overallCalculatedReviewRating.setProjTitle(project.getProjTitle());
							}
						}
						
					}
				}
			}
			Collections.sort(overallCalculatedReviewRatings, new OverAllRatingsComparator());
			}
		}
		catch(Exception e){
			LOGGER.error("Error while getting all reviews :", e);
			throw new GetAllReviewsException("Error while getting all Reviews : "+ e.getMessage());
		}
		return overallCalculatedReviewRatings;
	}
	
	public OverallCalculatedReviewRatingVO getAllReviewsForSpecificProject(long projId) throws GetAllReviewsException{
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		List<ReviewRatingVO> reviewRatingVOs = new ArrayList<ReviewRatingVO>();
		OverallCalculatedReviewRatingVO overallCalculatedReviewRating = new OverallCalculatedReviewRatingVO();
		try{
			String getAllReviewsForSpecificProjectTrsReviewRatingQuery = rbundle.getString("GET_ALL_REVIEWS_FOR_SPECIFIC_PROJECT_TRS_REVIEW_RATING_QUERY");
			getAllReviewsForSpecificProjectTrsReviewRatingQuery = getAllReviewsForSpecificProjectTrsReviewRatingQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getAllReviewsForSpecificProjectTrsReviewRatingQuery :: "+getAllReviewsForSpecificProjectTrsReviewRatingQuery);
			
			Map<String, Object> paramMapForProjId = new HashMap<String, Object>();
			paramMapForProjId.put("projId", projId);
			LOGGER.info("projId :: "+projId);
			
			reviewRatingVOs = (ArrayList<ReviewRatingVO>) jdbcTemplate.query(getAllReviewsForSpecificProjectTrsReviewRatingQuery, paramMapForProjId, new RowMapper<ReviewRatingVO>(){
	
				@Override
				public ReviewRatingVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ReviewRatingVO reviewRatingVO = new ReviewRatingVO();
					reviewRatingVO.setRatingId(rs.getLong("RATING_ID"));
					reviewRatingVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
					reviewRatingVO.setAssignedBy(rs.getLong("ASSIGNED_BY"));
					reviewRatingVO.setProjteamLeaderId(rs.getLong("PROJ_TEAM_LEADER_ID"));
					reviewRatingVO.setProjId(rs.getLong("PROJ_ID"));
					reviewRatingVO.setReviewStartDate(rs.getTimestamp("REVIEW_START_DATE"));
					reviewRatingVO.setRevRecommendation(rs.getString("REV_RECOMMENDATION"));
					reviewRatingVO.setRevNovelty(rs.getInt("REV_NOVELTY"));
					reviewRatingVO.setRevTechnicalRigor(rs.getInt("REV_TECHNICAL_RIGOR"));
					reviewRatingVO.setRevSocialApplication(rs.getInt("REV_SOCIAL_APPLICATION"));
					reviewRatingVO.setRevFrugality(rs.getLong("REV_FRUGALITY"));
					reviewRatingVO.setRevRatingPercentage(rs.getFloat("REV_RATING_PERCENTAGE"));
					reviewRatingVO.setRevComments(rs.getString("REV_COMMENTS"));
					reviewRatingVO.setRevSuggestedLinks(rs.getString("REV_SUGGESTED_LINKS"));
					reviewRatingVO.setCanIdeaBeTakenForward(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD"));
					reviewRatingVO.setCanIdeaBeTakenForwardRemarks(rs.getString("CAN_IDEA_BE_TAKEN_FORWARD_REMARKS"));
					reviewRatingVO.setMoreInfoNeeded(rs.getString("MORE_INFO_NEEDED"));
					reviewRatingVO.setMoreInfoNeededRemarks(rs.getString("MORE_INFO_NEEDED_REMARKS"));
					reviewRatingVO.setSuggestToOtherRev(rs.getString("SUGGEST_TO_OTHER_REV"));
					reviewRatingVO.setReviewEndDate(rs.getDate("REVIEW_END_DATE"));
	
					return reviewRatingVO;
				}
	
			});
				
			ProjectMaster project = new ProjectMaster();
			String getSpecificProjTitleMastProjectsDetailQuery = rbundle.getString("GET_SPECIFIC_PROJ_TITLE_MAST_PROJECTS_DETAIL_QUERY");
			getSpecificProjTitleMastProjectsDetailQuery = getSpecificProjTitleMastProjectsDetailQuery.replaceAll("&PROJID", ":projId");
			LOGGER.info("getSpecificProjTitleMastProjectsDetailQuery :: "+getSpecificProjTitleMastProjectsDetailQuery);
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			project = (ProjectMaster) namedParameterJdbcTemplate.queryForObject(getSpecificProjTitleMastProjectsDetailQuery, paramMapForProjId, new RowMapper<ProjectMaster>(){
	
				@Override
				public ProjectMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ProjectMaster project = new ProjectMaster();
					project.setProjId(rs.getLong("PROJ_ID"));
					project.setProjTitle(rs.getString("PROJ_TITLE"));
					project.setProjAbstract(rs.getString("PROJ_ABSTRACT"));
					return project;
				}
	
			});
		
			
			overallCalculatedReviewRating.setParticipantId(projId);
			
			List<String> projBranches = new ArrayList<String>();
			String getSpecificProjBranchDetailsMastBranchQuery = rbundle.getString("GET_SPECIFIC_PROJ_BRANCH_DETAILS_MAST_BRANCH_QUERY");
			getSpecificProjBranchDetailsMastBranchQuery = getSpecificProjBranchDetailsMastBranchQuery.replace("&PROJ_ID", ":projId");
			LOGGER.info("getSpecificProjBranchDetailsMastBranchQuery :: "+getSpecificProjBranchDetailsMastBranchQuery);
			
			projBranches = (ArrayList<String>) namedParameterJdbcTemplate.query(getSpecificProjBranchDetailsMastBranchQuery, paramMapForProjId, new RowMapper<String>(){

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {

					return rs.getString("PROJ_BRANCH_DESC");
				}

			});
			overallCalculatedReviewRating.setProjCategory(projBranches);
		
			List<ReviewerVO> reviewerVOs = new ArrayList<ReviewerVO>();
			String getAllReviewerMastDetailsQuery = rbundle.getString("GET_ALL_REVIEWER_MAST_DETAILS_QUERY");
			LOGGER.info("getAllReviewerMastDetailsQuery :: "+getAllReviewerMastDetailsQuery);
			
			reviewerVOs = (ArrayList<ReviewerVO>) jdbcTemplate.query(getAllReviewerMastDetailsQuery, new RowMapper<ReviewerVO>(){
	
				@Override
				public ReviewerVO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
					ReviewerVO reviewerVO = new ReviewerVO();
					reviewerVO.setRevRgstrId(rs.getLong("REV_RGSTR_ID"));
					reviewerVO.setRevFname(rs.getString("REV_FNAME"));
					reviewerVO.setRevMname(rs.getString("REV_MNAME"));
					reviewerVO.setRevLname(rs.getString("REV_LNAME"));
					return reviewerVO;
				}
			});
				
			int count = 0;
			float sumOfIndividualPercentages = 0;
			Set<AssignedByAndReviewDoneByMapper> assignedByAndReviewDoneByMapperSet = new LinkedHashSet<AssignedByAndReviewDoneByMapper>();
			if(reviewRatingVOs.size()>0){
			Date reviewedDate = reviewRatingVOs.get(0).getReviewEndDate();
			for(ReviewRatingVO reviewRatingVO : reviewRatingVOs){
				if(reviewRatingVO.getProjId() == overallCalculatedReviewRating.getParticipantId()){
					//Percentage calculation
					sumOfIndividualPercentages = sumOfIndividualPercentages + reviewRatingVO.getRevRatingPercentage();
					count = count+1;
					//Assigned By 
					AssignedByAndReviewDoneByMapper assignedByAndReviewDoneByMapper = new AssignedByAndReviewDoneByMapper();
					String assignedByName = "";
					for(ReviewerVO reviewerVO : reviewerVOs){
						if(reviewRatingVO.getAssignedBy() == reviewerVO.getRevRgstrId()){
							assignedByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null) ? "":" ") 
									+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null) ? "":" ")
									+reviewerVO.getRevLname();
						}
					}
					String reviewDoneByName = "";
					for(ReviewerVO reviewerVO : reviewerVOs){
						if(reviewRatingVO.getRevRgstrId() == reviewerVO.getRevRgstrId()){
							reviewDoneByName = reviewerVO.getRevFname()+ ((reviewerVO.getRevMname()==""||reviewerVO.getRevMname()==null) ? "":" ") 
									+reviewerVO.getRevMname()+((reviewerVO.getRevLname()==""||reviewerVO.getRevLname()==null) ? "":" ")
									+reviewerVO.getRevLname();
						}
					}
					assignedByAndReviewDoneByMapper.setAssignedBy(reviewRatingVO.getAssignedBy());
					assignedByAndReviewDoneByMapper.setAssignedByName(assignedByName);
					assignedByAndReviewDoneByMapper.setReviewDoneBy(reviewRatingVO.getRevRgstrId());
					assignedByAndReviewDoneByMapper.setReviewDoneByName(reviewDoneByName);
					assignedByAndReviewDoneByMapper.setRatingId(reviewRatingVO.getRatingId());
					assignedByAndReviewDoneByMapper.setRevRecommendation(reviewRatingVO.getRevRecommendation());
					assignedByAndReviewDoneByMapper.setRevNovelty(reviewRatingVO.getRevNovelty());
					assignedByAndReviewDoneByMapper.setRevTechnicalRigor(reviewRatingVO.getRevTechnicalRigor());
					assignedByAndReviewDoneByMapper.setRevSocialApplication(reviewRatingVO.getRevSocialApplication());
					assignedByAndReviewDoneByMapper.setRevFrugality(reviewRatingVO.getRevFrugality());
					assignedByAndReviewDoneByMapper.setRevRatingPercentage(reviewRatingVO.getRevRatingPercentage());
					assignedByAndReviewDoneByMapper.setRevComments(reviewRatingVO.getRevComments());
					assignedByAndReviewDoneByMapper.setRevSuggestedLinks(reviewRatingVO.getRevSuggestedLinks());
					assignedByAndReviewDoneByMapper.setCanIdeaBeTakenForward(reviewRatingVO.getCanIdeaBeTakenForward());
					assignedByAndReviewDoneByMapper.setCanIdeaBeTakenForwardRemarks(reviewRatingVO.getCanIdeaBeTakenForwardRemarks());
					assignedByAndReviewDoneByMapper.setMoreInfoNeeded(reviewRatingVO.getMoreInfoNeeded());
					assignedByAndReviewDoneByMapper.setMoreInfoNeededRemarks(reviewRatingVO.getMoreInfoNeededRemarks());
					assignedByAndReviewDoneByMapper.setSuggestToOtherRev(reviewRatingVO.getSuggestToOtherRev());
					assignedByAndReviewDoneByMapperSet.add(assignedByAndReviewDoneByMapper);
					//Reviewed Date
					if(reviewedDate.compareTo(reviewRatingVO.getReviewEndDate())>0){
						reviewedDate = reviewRatingVO.getReviewEndDate();
					}
				}
				float averageRating =  sumOfIndividualPercentages/count;
				String averageRatingUptoTwoDecimalPlaces = String.format("%.02f", averageRating);
				overallCalculatedReviewRating.setAverageRating(averageRatingUptoTwoDecimalPlaces);
				overallCalculatedReviewRating.setAssignedByAndReviewDoneByMapperSet(assignedByAndReviewDoneByMapperSet);
				overallCalculatedReviewRating.setReviewedDate(reviewedDate);
				}
			}
			//project title  & Abstract
			if(project.getProjId() == overallCalculatedReviewRating.getParticipantId()){
				overallCalculatedReviewRating.setProjTitle(project.getProjTitle());
				overallCalculatedReviewRating.setProjAbstract(project.getProjAbstract());
			}
				
		}
		catch(Exception e){
			LOGGER.error("Error while getting all reviews for specific project : ", e);
			throw new GetAllReviewsException("Error while getting all Reviews for specific project : "+ e.getMessage());
		}
		return overallCalculatedReviewRating;
	}
	
	public AddNewTeamMemberResponseVO addNewTeamMember(AddNewTeamMemberVO addNewTeamMemberVO) throws AddNewTeamMemberException{
		AddNewTeamMemberResponseVO addNewTeamMemberResponseVO = null;
		addNewTeamMemberResponseVO = new AddNewTeamMemberResponseVO();
		addNewTeamMemberResponseVO.setStatus("N");
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		
		ArrayList<UserProfileVO> userList = new ArrayList<UserProfileVO>();
		
		
		//Select All EMAIL_ID from USR_MNGT_MASTER TABLE
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String addNewTeamMemberUsrMngtMasterSelectQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_SELECT_QUERY");
		LOGGER.info("addNewTeamMemberUsrMngtMasterSelectQuery :: "+addNewTeamMemberUsrMngtMasterSelectQuery);
		
		userList = (ArrayList<UserProfileVO>) jdbcTemplate.query(addNewTeamMemberUsrMngtMasterSelectQuery, new RowMapper<UserProfileVO>(){

			@Override
			public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserProfileVO userProfileVO = new UserProfileVO();
				userProfileVO.setFirstName(rs.getString("FNAME"));
				userProfileVO.setMidName(rs.getString("MNAME"));
				userProfileVO.setLastName(rs.getString("LNAME"));
				userProfileVO.setEmail(rs.getString("EMAIL_ID"));
				return userProfileVO;
			}});
		
		for(UserProfileVO userProfile : userList){
			if(addNewTeamMemberVO.getEmailId().trim().equalsIgnoreCase(userProfile.getEmail())){
				throw new AddNewTeamMemberException("This Email Id is already registered in the database.","Please search this member and add.");
			}
		}
		try{
			String addNewTeamMemberUsrMngtMasterInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_INSERT_QUERY");
			LOGGER.info("addNewTeamMemberUsrMngtMasterInsertQuery :: "+addNewTeamMemberUsrMngtMasterInsertQuery);
			
			jdbcTemplate.update(addNewTeamMemberUsrMngtMasterInsertQuery,new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					
					String emailId = addNewTeamMemberVO.getEmailId().trim();
					String fName = addNewTeamMemberVO.getfName();
					String mName = addNewTeamMemberVO.getmName();
					String lName = addNewTeamMemberVO.getlName();
					String gender = addNewTeamMemberVO.getGender();
					String age = addNewTeamMemberVO.getAge();
					String generatedUserId = RandomStringUtils.randomAlphanumeric(12);
					Date rgstrDate = new Date();
					ps.setString(1, fName);//FNAME
					ps.setString(2, mName);//MNAME
					ps.setString(3, lName);//LNAME
					ps.setString(4, generatedUserId);//USR_ID
					ps.setTimestamp(5, new java.sql.Timestamp (rgstrDate.getTime()));//RGSTR_DATE
					ps.setDate(6, new java.sql.Date (rgstrDate.getTime()));//ACTIVATED_DATE
					ps.setString(7, "1");//CAPTCHA_VERIFICATION
					ps.setString(8, "Y");//IS_ACTIVE
					ps.setString(9, "student");//TYPE
					ps.setString(10, emailId);//EMAIL_ID
					ps.setString(11, gender);//GENDER
					ps.setString(12, age);//AGE
				}

			});
			
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			String addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_SELECT_BY_EMAIL_ID_QUERY");
			addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery = addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery.replaceAll("&EMAILID", ":emailId");
			LOGGER.info("addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery :: "+addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery);
	
			Map<String, Object> paramMapForEmailId = new HashMap<String, Object>();
			paramMapForEmailId.put("emailId", addNewTeamMemberVO.getEmailId().trim());
			LOGGER.info("emailId :: "+addNewTeamMemberVO.getEmailId().trim());
	
			UserProfileVO userProfileVO = new UserProfileVO();
			userProfileVO = (UserProfileVO) namedParameterJdbcTemplate.queryForObject(addNewTeamMemberUsrMngtMasterSelectByEmailIdQuery, paramMapForEmailId,  new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					userProfileVO.setUserName(rs.getString("USR_ID"));
					return userProfileVO;
				}});
				
			//Insert into UsrMngtPasswd for the new inserted RGSTR_ID
			UsrMngtPasswdVO usrMngtPasswdVO = new UsrMngtPasswdVO();
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			usrMngtPasswdVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtPasswdVO.setUsrId(userProfileVO.getUserName());
			String generatedPasswd = RandomStringUtils.randomAlphanumeric(8); // Encryption to be done here
			String encryptedGeneratedPasswd = ChiperUtils.encrypt2(generatedPasswd);
			usrMngtPasswdVO.setUsrPasswd(encryptedGeneratedPasswd);
			Date createdDate = new Date();
			usrMngtPasswdVO.setCreatedDate(createdDate);
			
			String adNewTeamMemberUsrMngtPasswdInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_PASSWD_INSERT_QUERY");
			LOGGER.info("adNewTeamMemberUsrMngtPasswdInsertQuery :: "+adNewTeamMemberUsrMngtPasswdInsertQuery);
			jdbcTemplate.update(adNewTeamMemberUsrMngtPasswdInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtPasswdVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtPasswdVO.getUsrId());//USR_ID
					ps.setString(3, usrMngtPasswdVO.getUsrPasswd());//USR_PASSWD
					ps.setTimestamp(4, new java.sql.Timestamp (usrMngtPasswdVO.getCreatedDate().getTime()));//CREATED_DATE
				}
			});
			
			//Insert into UsrMngtStudent for the new inserted RGSTR_ID
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			UsrMngtStudentVO usrMngtStudentVO = new UsrMngtStudentVO();
			usrMngtStudentVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtStudentVO.setBranchId(addNewTeamMemberVO.getBranchId());
			usrMngtStudentVO.setDegree("");
			usrMngtStudentVO.setUniversity("");
			usrMngtStudentVO.setEnrollmentNo("");
			usrMngtStudentVO.setYearOfPass(new Date());
			
			String addNewTeamMemberUsrMngtStudentInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_STUDENT_INSERT_QUERY");
			LOGGER.info("addNewTeamMemberUsrMngtStudentInsertQuery :: "+addNewTeamMemberUsrMngtStudentInsertQuery);
			jdbcTemplate.update(addNewTeamMemberUsrMngtStudentInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtStudentVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtStudentVO.getDegree());//DEGREE
					ps.setString(3, usrMngtStudentVO.getCollege());//COLLEGE
					ps.setString(4, usrMngtStudentVO.getUniversity());//UNIVERSITY
					ps.setString(5, usrMngtStudentVO.getEnrollmentNo());//ENROLLMENT_NO
					ps.setDate(6, new java.sql.Date(usrMngtStudentVO.getYearOfPass().getTime()));//YEAR_OF_PASS
					ps.setString(7, usrMngtStudentVO.getBranchId());//BRANCH
				}

			});
			//Insert into UsrMngtContactInfo for the new inserted RGSTR_ID
			UsrMngtContactInfoVO usrMngtContactInfoVO = new UsrMngtContactInfoVO();
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			usrMngtContactInfoVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtContactInfoVO.setMobileNo("");
			usrMngtContactInfoVO.setHomePhoneNo("");
			
			String addNewTeamMemberUsrMngtContactInfoInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_CONTACT_INFO_INSERT_QUERY");
			LOGGER.info("addNewTeamMemberUsrMngtContactInfoInsertQuery :: "+addNewTeamMemberUsrMngtContactInfoInsertQuery);
			jdbcTemplate.update(addNewTeamMemberUsrMngtContactInfoInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtContactInfoVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtContactInfoVO.getMobileNo());//MOBILE_NO
					ps.setString(3, usrMngtContactInfoVO.getHomePhoneNo());//HOME_PHONE_NO
				}

			});
			
			//Insert into UsrMngtAddress for the new inserted RGSTR_ID
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			UsrMngtAddressVO usrMngtAddressVO = new UsrMngtAddressVO();
			usrMngtAddressVO.setRgstrId(userProfileVO.getRgstrId());
			
			String addNewTeamMemberUsrMngtAddressInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_ADDRESS_INSERT_QUERY");
			LOGGER.info("addNewTeamMemberUsrMngtAddressInsertQuery :: "+addNewTeamMemberUsrMngtAddressInsertQuery);
			jdbcTemplate.update(addNewTeamMemberUsrMngtAddressInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtAddressVO.getRgstrId());//RGSTR_ID
				}

			});
			
			addNewTeamMemberResponseVO.setRgstrId(userProfileVO.getRgstrId());
			addNewTeamMemberResponseVO.setfName(addNewTeamMemberVO.getfName());
			addNewTeamMemberResponseVO.setmName(addNewTeamMemberVO.getmName());
			addNewTeamMemberResponseVO.setlName(addNewTeamMemberVO.getlName());
			addNewTeamMemberResponseVO.setUserId(userProfileVO.getUserName());
			addNewTeamMemberResponseVO.setEmailId(addNewTeamMemberVO.getEmailId());
			addNewTeamMemberResponseVO.setBranchId(addNewTeamMemberVO.getBranchId());
			addNewTeamMemberResponseVO.setGender(addNewTeamMemberVO.getGender());
			addNewTeamMemberResponseVO.setAge(addNewTeamMemberVO.getAge());
			addNewTeamMemberResponseVO.setStatus("Y");
		}
		catch(Exception e){
			LOGGER.error("An unexpected exception occurred in addNewTeamMember :: ",e);
			throw new AddNewTeamMemberException("Error while Adding New Team Member for this project : ", e.getMessage());
		}
		
		return addNewTeamMemberResponseVO;
	}
	
	
	public RegisterNewFacultyResponseVO registerNewFaculty(RegisterNewFacultyVO registerNewFacultyVO) throws AddNewTeamMemberException{
		RegisterNewFacultyResponseVO registerNewFacultyResponseVO = null;
		registerNewFacultyResponseVO = new RegisterNewFacultyResponseVO();
		registerNewFacultyResponseVO.setStatus("N");
		
		ResourceBundle rbundle = ResourceBundle.getBundle("query");
		
		ArrayList<UserProfileVO> userList = new ArrayList<UserProfileVO>();
		
		
		//Select All EMAIL_ID from USR_MNGT_MASTER TABLE
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String newFacultyUsrMngtMasterSelectQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_SELECT_QUERY");
		LOGGER.info("addNewTeamMemberUsrMngtMasterSelectQuery :: "+newFacultyUsrMngtMasterSelectQuery);
		
		userList = (ArrayList<UserProfileVO>) jdbcTemplate.query(newFacultyUsrMngtMasterSelectQuery, new RowMapper<UserProfileVO>(){

			@Override
			public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserProfileVO userProfileVO = new UserProfileVO();
				userProfileVO.setFirstName(rs.getString("FNAME"));
				userProfileVO.setMidName(rs.getString("MNAME"));
				userProfileVO.setLastName(rs.getString("LNAME"));
				userProfileVO.setEmail(rs.getString("EMAIL_ID"));
				return userProfileVO;
			}});
		
		for(UserProfileVO userProfile : userList){
			if(registerNewFacultyVO.getEmailId().trim().equalsIgnoreCase(userProfile.getEmail())){
				throw new AddNewTeamMemberException("This Email Id is already registered in the database.","Please search this member and add.");
			}
		}
		try{
			String newFacultyUsrMngtMasterInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_INSERT_QUERY");
			LOGGER.info("newFacultyUsrMngtMasterInsertQuery :: "+newFacultyUsrMngtMasterInsertQuery);
			
			jdbcTemplate.update(newFacultyUsrMngtMasterInsertQuery,new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					
					String emailId = registerNewFacultyVO.getEmailId().trim();
					String fName = registerNewFacultyVO.getfName();
					String mName = registerNewFacultyVO.getmName();
					String lName = registerNewFacultyVO.getlName();
					String gender = registerNewFacultyVO.getGender();
					String age = registerNewFacultyVO.getAge();
					String generatedUserId = RandomStringUtils.randomAlphanumeric(12);
					Date rgstrDate = new Date();
					ps.setString(1, fName);//FNAME
					ps.setString(2, mName);//MNAME
					ps.setString(3, lName);//LNAME
					ps.setString(4, generatedUserId);//USR_ID
					ps.setTimestamp(5, new java.sql.Timestamp (rgstrDate.getTime()));//RGSTR_DATE
					ps.setDate(6, new java.sql.Date (rgstrDate.getTime()));//ACTIVATED_DATE
					ps.setString(7, "1");//CAPTCHA_VERIFICATION
					ps.setString(8, "Y");//IS_ACTIVE
					ps.setString(9, "faculty");//TYPE
					ps.setString(10, emailId);//EMAIL_ID
					ps.setString(11, gender);//GENDER
					ps.setString(12, age);//AGE
				}

			});
			
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			
			String newFacultyUsrMngtMasterSelectByEmailIdQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_MASTER_SELECT_BY_EMAIL_ID_QUERY");
			newFacultyUsrMngtMasterSelectByEmailIdQuery = newFacultyUsrMngtMasterSelectByEmailIdQuery.replaceAll("&EMAILID", ":emailId");
			LOGGER.info("newFacultyUsrMngtMasterSelectByEmailIdQuery :: "+newFacultyUsrMngtMasterSelectByEmailIdQuery);
	
			Map<String, Object> paramMapForEmailId = new HashMap<String, Object>();
			paramMapForEmailId.put("emailId", registerNewFacultyVO.getEmailId().trim());
			LOGGER.info("emailId :: "+registerNewFacultyVO.getEmailId().trim());
	
			UserProfileVO userProfileVO = new UserProfileVO();
			userProfileVO = (UserProfileVO) namedParameterJdbcTemplate.queryForObject(newFacultyUsrMngtMasterSelectByEmailIdQuery, paramMapForEmailId,  new RowMapper<UserProfileVO>(){

				@Override
				public UserProfileVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserProfileVO userProfileVO = new UserProfileVO();
					userProfileVO.setRgstrId(rs.getLong("RGSTR_ID"));
					userProfileVO.setEmail(rs.getString("EMAIL_ID"));
					userProfileVO.setUserName(rs.getString("USR_ID"));
					return userProfileVO;
				}});
				
			//Insert into UsrMngtPasswd for the new inserted RGSTR_ID
			UsrMngtPasswdVO usrMngtPasswdVO = new UsrMngtPasswdVO();
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			usrMngtPasswdVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtPasswdVO.setUsrId(userProfileVO.getUserName());
			String generatedPasswd = RandomStringUtils.randomAlphanumeric(8); // Encryption to be done here
			String encryptedGeneratedPasswd = ChiperUtils.encrypt2(generatedPasswd);
			usrMngtPasswdVO.setUsrPasswd(encryptedGeneratedPasswd);
			Date createdDate = new Date();
			usrMngtPasswdVO.setCreatedDate(createdDate);
			
			String newFacultyUsrMngtPasswdInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_PASSWD_INSERT_QUERY");
			LOGGER.info("newFacultyUsrMngtPasswdInsertQuery :: "+newFacultyUsrMngtPasswdInsertQuery);
			jdbcTemplate.update(newFacultyUsrMngtPasswdInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtPasswdVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtPasswdVO.getUsrId());//USR_ID
					ps.setString(3, usrMngtPasswdVO.getUsrPasswd());//USR_PASSWD
					ps.setTimestamp(4, new java.sql.Timestamp (usrMngtPasswdVO.getCreatedDate().getTime()));//CREATED_DATE
				}
			});
			
			//Insert into UsrMngtStudent for the new inserted RGSTR_ID
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			UsrMngtFacultyVO usrMngtFacultyVO = new UsrMngtFacultyVO();
			usrMngtFacultyVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtFacultyVO.setBranchId(registerNewFacultyVO.getBranchId());
			usrMngtFacultyVO.setCollege(registerNewFacultyVO.getCollege());
			usrMngtFacultyVO.setDegree("");
			usrMngtFacultyVO.setUniversity("");
			usrMngtFacultyVO.setAlumni("");
			usrMngtFacultyVO.setMemshipInAssocns("");
			usrMngtFacultyVO.setProExp("");
			usrMngtFacultyVO.setPsnlWebpgLink("");
			usrMngtFacultyVO.setAffltUniversity("");
			usrMngtFacultyVO.setSpecification("");
			
			
			String newFacultyUsrMngtStudentInsertQuery = rbundle.getString("ADD_NEW_FACULTY_USR_MNGT_FACULTY_INSERT_QUERY");
			LOGGER.info("newFacultyUsrMngtStudentInsertQuery :: "+newFacultyUsrMngtStudentInsertQuery);
			jdbcTemplate.update(newFacultyUsrMngtStudentInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtFacultyVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtFacultyVO.getDegree());//DEGREE
					ps.setString(3, usrMngtFacultyVO.getCollege());//COLLEGE
					ps.setString(4,usrMngtFacultyVO.getSpecification());//SPECIFICATION
					ps.setString(5, usrMngtFacultyVO.getUniversity());//UNIVERSITY
					ps.setString(6, usrMngtFacultyVO.getAlumni());//ALUMNI
					ps.setString(7,usrMngtFacultyVO.getMemshipInAssocns());//MEMSHIPINASSOCNS
					ps.setString(8,usrMngtFacultyVO.getPsnlWebpgLink() );//PSOCIALNETWORKWEBPAGELINK
					ps.setString(9,usrMngtFacultyVO.getProExp() );//PERSONALEXPERIENCE
					ps.setString(10,usrMngtFacultyVO.getAffltUniversity());//AFFLTUNIVERSITY
					ps.setString(11,usrMngtFacultyVO.getBranchId());//BRANCHID
				}

			});
			//Insert into UsrMngtContactInfo for the new inserted RGSTR_ID
			UsrMngtContactInfoVO usrMngtContactInfoVO = new UsrMngtContactInfoVO();
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			usrMngtContactInfoVO.setRgstrId(userProfileVO.getRgstrId());
			usrMngtContactInfoVO.setMobileNo("");
			usrMngtContactInfoVO.setHomePhoneNo("");
			
			String newFacultyUsrMngtContactInfoInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_CONTACT_INFO_INSERT_QUERY");
			LOGGER.info("newFacultyUsrMngtContactInfoInsertQuery :: "+newFacultyUsrMngtContactInfoInsertQuery);
			jdbcTemplate.update(newFacultyUsrMngtContactInfoInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtContactInfoVO.getRgstrId());//RGSTR_ID
					ps.setString(2, usrMngtContactInfoVO.getMobileNo());//MOBILE_NO
					ps.setString(3, usrMngtContactInfoVO.getHomePhoneNo());//HOME_PHONE_NO
				}

			});
			
			//Insert into UsrMngtAddress for the new inserted RGSTR_ID
			LOGGER.info("Rgstr Id :: "+userProfileVO.getRgstrId());
			UsrMngtAddressVO usrMngtAddressVO = new UsrMngtAddressVO();
			usrMngtAddressVO.setRgstrId(userProfileVO.getRgstrId());
			
			String newFacultyUsrMngtAddressInsertQuery = rbundle.getString("ADD_NEW_TEAM_MEMBER_USR_MNGT_ADDRESS_INSERT_QUERY");
			LOGGER.info("addNewTeamMemberUsrMngtAddressInsertQuery :: "+newFacultyUsrMngtAddressInsertQuery);
			jdbcTemplate.update(newFacultyUsrMngtAddressInsertQuery, new PreparedStatementSetter(){

				@Override
				public void setValues(PreparedStatement ps)
						throws SQLException {
					ps.setLong(1, usrMngtAddressVO.getRgstrId());//RGSTR_ID
				}

			});
			
			registerNewFacultyResponseVO.setRgstrId(userProfileVO.getRgstrId());
			registerNewFacultyResponseVO.setfName(registerNewFacultyVO.getfName());
			registerNewFacultyResponseVO.setmName(registerNewFacultyVO.getmName());
			registerNewFacultyResponseVO.setlName(registerNewFacultyVO.getlName());
			registerNewFacultyResponseVO.setUserId(userProfileVO.getUserName());
			registerNewFacultyResponseVO.setEmailId(registerNewFacultyVO.getEmailId());
			registerNewFacultyResponseVO.setBranchId(registerNewFacultyVO.getBranchId());
			registerNewFacultyResponseVO.setGender(registerNewFacultyVO.getGender());
			registerNewFacultyResponseVO.setAge(registerNewFacultyVO.getAge());
			registerNewFacultyResponseVO.setCollege(registerNewFacultyVO.getCollege());
			registerNewFacultyResponseVO.setStatus("Y");
		}
		catch(Exception e){
			LOGGER.error("An unexpected exception occurred in registerNewFaculty :: ",e);
			throw new AddNewTeamMemberException("Error while Adding New facultyr for this project : ", e.getMessage());
		}
		
		return registerNewFacultyResponseVO;
	}
	
}
