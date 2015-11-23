/**
 * 
 */
package com.techpedia.projectmanagement.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import sun.misc.BASE64Decoder;

import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.ChallengeType;
import com.techpedia.projectmanagement.bean.ChallengeTypeMasterVO;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.dao.ChallengeDao;
import com.techpedia.projectmanagement.entity.ChallengeDocPathTxn;
import com.techpedia.projectmanagement.entity.ChallengeMaster;
import com.techpedia.projectmanagement.entity.ChallengeTeamTxn;
import com.techpedia.projectmanagement.entity.ChallengeTypeMaster;
import com.techpedia.projectmanagement.entity.ProjectBranchMaster;
import com.techpedia.projectmanagement.entity.ProjectKeywordMaster;
import com.techpedia.projectmanagement.entity.ProjectMaster;
import com.techpedia.projectmanagement.entity.ProjectTeamMaster;
import com.techpedia.projectmanagement.entity.ProjectTeamTxn;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeTypeException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.UploadChallengeDocException;
import com.techpedia.projectmanagement.util.FileUploadDownload;
import com.techpedia.util.HibernateUtil;


/**
 * @author geetanjali
 *
 */
public class ChallengeDaoImpl implements ChallengeDao {

	/* 
	 * @see com.techpedia.projectmanagement.dao.ChallengeManagementDAO#createChallenge(com.techpedia.projectmanagement.dataobject.ChallengeDAO)
	 */
	
	//private static TechPediaLogger log = TechPediaLogger.getLogger(ChallengeDaoImpl.class.getName());
	
	@Override
	public String createChallenge(Challenge challenge) throws CreateChallengeException{
		
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		String returnVal = "N";
		//int tranCount = 0;
		
		/*Parameters for Table: `TB_TECH001_MAST_CHALLENG_DETAIL */
		long challengId =0;
		int challengTypeId = challenge.getChallengTypeId();
		String challengTitle = challenge.getChallengTitle();
		String challengAbstract = challenge.getChallengAbstract();
		String challengDescription = challenge.getChallengDescription();
		long rgstrId = challenge.getRgstrId();
		int challengYear = challenge.getChallengYear();
		Date challengStartDate = getMillisecondsToDate(challenge.getChallengStartDate());
		Date challengCloseDate = getMillisecondsToDate(challenge.getChallengCloseDate());
	    String isChallengActive = "Y";//challenge.getIsChallengActive();
		String isChallengSuccess = challenge.getIsChallengSuccess();
		String challengCommentsPublish = challenge.getChallengCommentsPublish();
		String challengImpact = challenge.getChallengImpact();
		String challengIsIncentiv  = challenge.getChallengIsIncentiv();
		String challengSourceFund = challenge.getChallengSourceFund();	
		String challengDelivExpctatn  = challenge.getChallengDelivExpctatn();
		String challengBenchmark  = challenge.getChallengBenchmark();

		//String challengImgPath = challenge.getChallengImgPath();
		
		/*ArrayList<Integer> challengTypeIds = challenge.getChallengTypeIds();
		String challengTypeDesc = challenge.getChallengTypeDesc();
		
		ArrayList<Long> challengIds = challenge.getChallengIds();
		long projId = challenge.getProjId();
		long projTeamId = challenge.getProjTeamId();
		
	    */
		
		//ChallengeMaster challengeMaster = null;
		try {
					
			/*Start Adding into TB_TECH001_MAST_CHALLENG_DETAIL here*/
			ChallengeMaster challengMaster = new ChallengeMaster(challengTypeId,challengTitle,
					challengAbstract,challengDescription,rgstrId, 
					challengYear,challengStartDate, 
					challengCloseDate,isChallengActive,
					isChallengSuccess,challengCommentsPublish,
					challengImpact,challengIsIncentiv,challengSourceFund,
					challengDelivExpctatn,
					challengBenchmark);
		
			tx = session.beginTransaction();
			Serializable sr = session.save(challengMaster);
			challengId = Long.parseLong(sr.toString());
			tx.commit();
			
		    returnVal = "Y";
		} catch (Exception e) {
			//log.debug("Unable to add to challenge to DB : " + e);
			try 
			{
				tx.rollback();
				session.createSQLQuery("delete from tb_tech001_mast_challeng_detail where CHALLENG_ID = :challengId").setParameter("challengId", challengId).executeUpdate();
			} catch (Exception e1) 
			{
				//log.debug("deleted Record from usr_mngt_master table : " + e1);
				throw new CreateChallengeException("Error while doing rollback to the failed transaction : "+ e1.getMessage());
			}
			throw new CreateChallengeException("Error while creating new challenge : "+ e.getMessage());
		}finally{
			tx=null;
			session.close();
		}
		//log.debug("ChallengeDaoImpl.createChallenge :End");
		return returnVal;
   }

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Challenge> getAllChallenge(String iterationCount)
			throws GetAllChallengeException {
		
		Challenge challenge = null;
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*8)-8;
		int maxResultSize = 8;
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria =session.createCriteria(ChallengeMaster.class);
			criteria.addOrder(Order.asc("challengId"));
			criteria.setFirstResult(minIndex);
			criteria.setMaxResults(maxResultSize);
			ArrayList<ChallengeMaster> challengeMasters = (ArrayList<ChallengeMaster>) criteria.list();
			for(ChallengeMaster challengeMaster:challengeMasters){
				challenge = new Challenge();
				challenge.setRgstrId(challengeMaster.getRgstrId());
				challenge.setChallengId(challengeMaster.getChallengId());
				challenge.setChallengTitle(challengeMaster.getChallengTitle());
				challenge.setChallengDescription(challengeMaster.getChallengDescription());
				challenges.add(challenge);
			}
		} catch (Exception e) {
			//log.error("Error while retrieving the all Challenges :" + e.getMessage());
			throw new GetAllChallengeException("Error while retriving the all Challenges : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		return challenges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ChallengeTypeMasterVO> getSuggestedChallenges(String term)
			throws SuggestedChallengeNotFoundException {
		//log.debug("ChallengeDaoImpl.getSuggestedChallenges :Start");
		ArrayList<ChallengeTypeMasterVO> suggestedChallenges = new ArrayList<ChallengeTypeMasterVO>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria criteria = session.createCriteria(ChallengeTypeMaster.class);
			criteria.add(Restrictions.ilike("challengTypeDesc", "%"+term+"%"));
			suggestedChallenges = (ArrayList<ChallengeTypeMasterVO>) criteria.list();
		} catch (Exception e) {
			//log.error("Error while retrieving the Suggested Challenges :" + e.getMessage());
			throw new SuggestedChallengeNotFoundException("Error while retriving the Suggested Challenges : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ChallengeDaoImpl.getSuggestedChallenges :End");
		return suggestedChallenges;
	}
	
	public static Date getMillisecondsToDate(String milliseconds){
		long lnMilliseconds = Long.valueOf(milliseconds);
		Date projectStartDate = new Date(lnMilliseconds);
		return projectStartDate;
	}
	
	public static String getDateToMilliseconds(Date dateVal){
		long lnMilliseconds = dateVal.getTime();
		String milliseconds = String.valueOf(lnMilliseconds);
		return milliseconds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Challenge> getChallenge(String rgstrId)
			throws GetChallengeException {
		//log.debug("ChallengeDaoImpl.getChallenge :Start");
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		Challenge challenge;
		ArrayList<ChallengeMaster> challengeMasters = new ArrayList<ChallengeMaster>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria criteria = session.createCriteria(ChallengeMaster.class);
			criteria.add(Restrictions.eq("rgstrId", Long.parseLong(rgstrId)));
			challengeMasters = (ArrayList<ChallengeMaster>) criteria.list();
			for(ChallengeMaster challengeMaster:challengeMasters){
				challenge = new Challenge();
				challenge.setChallengId(challengeMaster.getChallengId());
				challenge.setChallengTitle(challengeMaster.getChallengTitle());
				challenge.setChallengAbstract(challengeMaster.getChallengAbstract());
				challenge.setChallengDescription(challengeMaster.getChallengDescription());
				//challenge.setChallengImgPath("");
				challenges.add(challenge);
			}
		} catch (Exception e) {
			//log.error("Error while retrieving the Suggested Challenges :" + e.getMessage());
			throw new GetChallengeException("Error while retriving the Suggested Challenges : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ChallengeDaoImpl.getChallenge :End");
		return challenges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Challenge> searchChallengeByTitle(SearchByKeyVO searchByKeyVO) throws SearchChallengeException {
		//log.debug("ChallengeDaoImpl.searchChallengeByTitle :Start");
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		Challenge challenge =null;
		String term = searchByKeyVO.getTerm();
		String iterationCount = searchByKeyVO.getIterationCount();
		Session session = HibernateUtil.getSessionFactory().openSession();
		int initCount = Integer.valueOf(iterationCount);
		int minIndex = (initCount*8)-8;
		int maxResultSize = 8;
		String[] termArray = term.split("[, ]");
		
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(ChallengeMaster.class);
			Disjunction disjunction = Restrictions.disjunction();
			for(int i=0;i<termArray.length;i++){
				disjunction.add(Restrictions.ilike("challengTitle", "%"+termArray[i].trim()+"%", MatchMode.ANYWHERE));
			}
			dc.add(disjunction);
			dc.setProjection(Projections.property("challengId"));
			Criteria criteria = session.createCriteria(ChallengeMaster.class);
			criteria.add(Subqueries.propertyIn("challengId", dc));
			criteria.addOrder(Order.asc("challengId"));
			criteria.setFirstResult(minIndex);
			criteria.setMaxResults(maxResultSize);
			ArrayList<ChallengeMaster> challengeMasters = (ArrayList<ChallengeMaster>) criteria.list();
			for(ChallengeMaster challengeMaster:challengeMasters){
				challenge = new Challenge();
				
				challenge.setChallengId(challengeMaster.getChallengId());
				challenge.setChallengTitle(challengeMaster.getChallengTitle());
				challenge.setChallengDescription(challengeMaster.getChallengDescription());
				//challenge.setChallengImgPath(challengeMaster.getChallengImgPath());
				challenges.add(challenge);
			}

		} catch (Exception e) {
			//log.error("Error while searching the challenge :" + e.getMessage());
			throw new SearchChallengeException("Error while searching the challenge : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();				
		}
		//log.debug("ChallengeDaoImpl.searchChallengeByTitle :End");
		return challenges;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Challenge getChallengeDetail(String ChallengeId)
			throws GetChallengeDetailException {		
		
		ChallengeMaster challengeMaster = new ChallengeMaster();
		Challenge challenge = new Challenge();
		ArrayList<ChallengeMaster> challengeMasters = new ArrayList<ChallengeMaster>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria criteria = session.createCriteria(ChallengeMaster.class);
			criteria.add(Restrictions.eq("challengId", Long.parseLong(ChallengeId)));
			challengeMasters = (ArrayList<ChallengeMaster>) criteria.list();
			if(challengeMasters.size()>0){
				challengeMaster = challengeMasters.get(0);
				challenge.setChallengAbstract(challengeMaster.getChallengAbstract());
				challenge.setChallengBenchmark(challengeMaster.getChallengBenchmark());			
				challenge.setChallengCloseDate(getDateToMilliseconds(challengeMaster.getChallengCloseDate()));
				challenge.setChallengCommentsPublish(challengeMaster.getChallengCommentsPublish());
				challenge.setChallengDelivExpctatn(challengeMaster.getChallengDelivExpctatn());
				challenge.setChallengDescription(challengeMaster.getChallengDescription());
				challenge.setChallengId(challengeMaster.getChallengId());			
				challenge.setChallengIsIncentiv(challengeMaster.getChallengIsIncentiv());
				challenge.setChallengSourceFund(challengeMaster.getChallengSourceFund());
				challenge.setChallengStartDate(getDateToMilliseconds(challengeMaster.getChallengStartDate()));
				challenge.setChallengTitle(challengeMaster.getChallengTitle());			
				challenge.setChallengTypeId(challengeMaster.getChallengTypeId());
				challenge.setChallengYear(challengeMaster.getChallengYear());
				challenge.setIsChallengActive(challengeMaster.getIsChallengActive());
				challenge.setIsChallengSuccess(challengeMaster.getIsChallengSuccess());		
				challenge.setRgstrId(challengeMaster.getRgstrId());
			}
		} catch (Exception e) {
			//log.error(Error while getting challenge details : " + e.getMessage());
			throw new GetChallengeDetailException("Error while getting challenge details : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();				
		}
		
		return challenge;
	}

	@Override
	public String uploadChallengeDocument(UploadChallDocVO uploadChallDocVO)
			throws UploadChallengeDocException {
		// TODO Auto-generated method stub
		
		String returnVal = "N";
		String fileSize = "";
		ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
		String SERVER_UPLOAD_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION");		
		String challId = String.valueOf(uploadChallDocVO.getChallengeId());
		String regstrId = String.valueOf(uploadChallDocVO.getRgstrId());
		String docName = uploadChallDocVO.getDocName();	
		String docPath = challId+"/"+regstrId+"/"+docName;
		Calendar now = Calendar.getInstance(); 
	    Date docUploadDate = now.getTime();
	    Transaction tx = null;
		Session session = null;		
		try {			
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(uploadChallDocVO.getDocByteArray());
			InputStream inputStream = new ByteArrayInputStream(decodedBytes);				
			fileSize = FileUploadDownload.saveFile(inputStream, SERVER_UPLOAD_FOLDER_LOCATION, challId, regstrId, docName);
			
			/*Start Adding into tb_tech001_txn_challng_doc_path here*/	
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ChallengeDocPathTxn.class);
			criteria.add(Restrictions.eq("regstrId", uploadChallDocVO.getRgstrId()));
	        criteria.add(Restrictions.eq("chalengId", uploadChallDocVO.getChallengeId()));
	        criteria.add(Restrictions.eq("challengPath", docPath));	        
	        ChallengeDocPathTxn docPathTxn = (ChallengeDocPathTxn) criteria.uniqueResult();
	        if(docPathTxn == null){			
	        	ChallengeDocPathTxn challengeDocPathTxn = new ChallengeDocPathTxn(uploadChallDocVO.getChallengeId(),docPath,docUploadDate,uploadChallDocVO.getRgstrId(),fileSize);		
	        	session.save(challengeDocPathTxn);			        	
	        }else{
	        	docPathTxn.setChallengDocSize(fileSize);
	        	session.update(docPathTxn);	        	
	        }
	        tx.commit();
			returnVal = "Y";
		} catch (Exception e) {		
			throw new UploadChallengeDocException("Error while uploading challenge document :"+ e.getMessage());
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
	public ArrayList<ProjectDocument> downloadChallengeDocument(
			DownChallengeDocVO challengeDocVO) throws DownloadChallengeDocException {
		//log.debug("ChallengeDaoImpl.downloadChallengeDocument :Start");
		ArrayList<ProjectDocument> projectDocuments = new ArrayList<ProjectDocument>();
		ProjectDocument projectDocument;
		ArrayList<ChallengeDocPathTxn> challengeDocPathTxns = new ArrayList<ChallengeDocPathTxn>();
		long challengeId = challengeDocVO.getChallengeId();
		long regstrId = challengeDocVO.getRegstrId();
		ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
		String SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION");
		Session session = HibernateUtil.getSessionFactory().openSession();	
		try {							
			Criteria criteria = session.createCriteria(ChallengeDocPathTxn.class);
			criteria.add(Restrictions.eq("regstrId", regstrId));
	        criteria.add(Restrictions.eq("chalengId", challengeId));
			criteria.addOrder(Order.asc("challengDocId"));				
			challengeDocPathTxns = (ArrayList<ChallengeDocPathTxn>) criteria.list();
			for(ChallengeDocPathTxn docPathTxn:challengeDocPathTxns){
				projectDocument = new ProjectDocument();
				String docPath = docPathTxn.getChallengPath();
				String docName = docPath.substring(docPath.lastIndexOf("/")+1, docPath.length());
				projectDocument.setDocName(docName);
				projectDocument.setDocLink(SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION+"/"+docPath);
				
				projectDocuments.add(projectDocument);
			}
			if(challengeDocPathTxns.size()==0)
				throw new DownloadChallengeDocException("No documents uploaded by given user for given challenge");		
		} catch (Exception e) {
			//log.error("Error while retriving the all followed projects : " + e.getMessage());
			throw new DownloadChallengeDocException("Error while downloading challenge documents : "+ e.getMessage());
		}finally{
			if(session!=null)
				session.close();
		}
		//log.debug("ChallengeDaoImpl.downloadChallengeDocument :End");
		return projectDocuments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Challenge> getChallengesByLoggedInUser(String rgstrId)
			throws ChallengesByLoggedInUserException {
		//log.debug("ChallengeDaoImpl.getChallenge :Start");
				ArrayList<Challenge> challenges = new ArrayList<Challenge>();
				Challenge challenge;
				ArrayList<ChallengeMaster> challengeMasters = new ArrayList<ChallengeMaster>();
				Session session = HibernateUtil.getSessionFactory().openSession();
				
				try {
					Criteria criteria = session.createCriteria(ChallengeMaster.class);
					criteria.add(Restrictions.eq("rgstrId", Long.parseLong(rgstrId)));
					challengeMasters = (ArrayList<ChallengeMaster>) criteria.list();
					for(ChallengeMaster challengeMaster:challengeMasters){
						challenge = new Challenge();
						challenge.setChallengId(challengeMaster.getChallengId());
						challenge.setChallengTitle(challengeMaster.getChallengTitle());
						challenge.setChallengAbstract(challengeMaster.getChallengAbstract());
						challenge.setChallengDescription(challengeMaster.getChallengDescription());
						//challenge.setChallengImgPath("");
						challenges.add(challenge);
					}
				} catch (Exception e) {
					//log.error("Error while retrieving the Suggested Challenges :" + e.getMessage());
					throw new ChallengesByLoggedInUserException("Error while retriving the Challenges : "+ e.getMessage());
				}finally{
					if(session!=null)
						session.close();
				}
				//log.debug("ChallengeDaoImpl.getChallenge :End");
				return challenges;
	}
	
	@Override
	public String acceptChallenge(Project project) throws AcceptChallengeException{
			
			//log.debug("ChallengeDaoImpl.acceptChallenge :Start");
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
			Date projectStartDate = getMillisecondsToDate(project.getProjStartDate());
			Date projectEndDate = getMillisecondsToDate(project.getProjEndDate());						
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
			String projIsForChallenge = project.getProjIsForChallenge();
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
						projIsMentorAvail, projIsFacApprove, projAdminComments, projIsForChallenge, "ACTIVE", projectFaculty);
				
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
					session.saveOrUpdate(projectKeywordMaster);
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
					session.save(projectBranchMaster);
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
					session.save(projectTeamTxn);
					if ( tranCount % 20 == 0 ) { 
				        session.flush();
				        session.clear();
				    }
					tranCount++;
				}
				/*Start Adding into tb_tech001_txn_challng_team here*/
				ChallengeTeamTxn challengTeamTxn;
				challengTeamTxn = new ChallengeTeamTxn();
				challengTeamTxn.setChallengId(project.getChallengId());
				challengTeamTxn.setProjId(projId);
				challengTeamTxn.setRegstrId(projTeamLeaderId);			
				challengTeamTxn.setProjTeamId(projectTeamId);
				session.save(challengTeamTxn);
				if ( tranCount % 20 == 0 ) { 
					session.flush();
				    session.clear();
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
					throw new AcceptChallengeException("Error while doing rollback to the failed transection : "+ e1.getMessage());
				}
				throw new AcceptChallengeException("Error while accepting Challenge : "+ e.getMessage());
			}finally{
				if(tx!=null)
					tx=null;
				if(session!=null)
					session.close();
			}
			//log.debug("ChallengeDaoImpl.acceptChallenge :End");
			return returnVal;
	}

	@Override
	public String deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO)
			throws DeleteDocumentException {
		//log.debug("ChallengeDaoImpl.deleteChallengeDocument :Start");
				String returnVal = "N";		
				long challId = deleteChallDocVO.getChallengeId();
				long regstrId = deleteChallDocVO.getRegstrId();
				String docName = deleteChallDocVO.getDocName();
				//String docLink = deleteDocVO.getDocLink();
				String docPath = challId+"/"+regstrId+"/"+docName;
				ResourceBundle rbundle = ResourceBundle.getBundle("uploadDownload");
				String SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION = rbundle.getString("SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION");	
				Session session = HibernateUtil.getSessionFactory().openSession();
				ChallengeDocPathTxn challengeDocPathTxn = new ChallengeDocPathTxn();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					Criteria criteria =session.createCriteria(ChallengeDocPathTxn.class);	
					criteria.add(Restrictions.conjunction()
					          .add(Restrictions.eq("chalengId", Long.valueOf(challId)))
					          .add(Restrictions.eq("regstrId", Long.valueOf(regstrId)))
					          .add(Restrictions.eq("challengPath", docPath)));
					challengeDocPathTxn = (ChallengeDocPathTxn) criteria.uniqueResult();
					session.delete(challengeDocPathTxn);
					returnVal = FileUploadDownload.deleteFile(SERVER_UPLOAD_CHALLENGE_FOLDER_LOCATION+"/"+docPath);
					tx.commit();					
					if(returnVal=="N")
						throw new DeleteDocumentException("Unable to delete document");		
					} catch (Exception e) {
						//log.error("Error while retriving the all followed projects : " + e.getMessage());
						throw new DeleteDocumentException("Error while deleting challenge documents : "+ e.getMessage());
					}finally{
						if(tx!=null)
							tx=null;
						if(session!=null)
							session.close();
					}
					//log.debug("ChallengeDaoImpl.deleteChallengeDocument :End");				
				return returnVal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ChallengeType> getChallengeType()
			throws GetChallengeTypeException {
		//log.debug("ChallengeDaoImpl.getChallengeType :Start");
		ChallengeType challengeType = null;
		ArrayList<ChallengeType> challengeTypes = new ArrayList<ChallengeType>();
		Session session = HibernateUtil.getSessionFactory().openSession();		
		try{
			Criteria criteria = session.createCriteria(ChallengeTypeMaster.class);
			criteria.addOrder(Order.asc("challengTypeId"));
			ArrayList<ChallengeTypeMaster> challengeTypeMasters = (ArrayList<ChallengeTypeMaster>) criteria.list();
			for(ChallengeTypeMaster challengeTypeMaster:challengeTypeMasters){
				challengeType = new ChallengeType();
				challengeType.setChallengeTypeId(challengeTypeMaster.getChallengTypeId());
				challengeType.setChallengeTypeDesc(challengeTypeMaster.getChallengTypeDesc());			
				challengeTypes.add(challengeType);
			}
			}catch (Exception e) {
				//log.debug("Error while deleting project : "+ e.getMessage());
				throw new GetChallengeTypeException("Error while getting challenge types : "+ e.getMessage());
			}finally{
				if(session!=null)
					session.close();
			}
		//log.debug("ChallengeDaoImpl.getChallengeType :End");
		return challengeTypes;
	}
}



