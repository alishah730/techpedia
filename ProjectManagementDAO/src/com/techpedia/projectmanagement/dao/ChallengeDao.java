/**
 * 
 */
package com.techpedia.projectmanagement.dao;

import java.util.ArrayList;

import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.ChallengeTypeMasterVO;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.UploadChallengeDocException;

/**
 * @author nishikant.singh
 *
 */
public interface ChallengeDao {
	
	public abstract String createChallenge(Challenge challenge) throws CreateChallengeException;
  
	public ArrayList<Challenge> getAllChallenge(String iterationCount) throws GetAllChallengeException;
	
	public ArrayList<ChallengeTypeMasterVO> getSuggestedChallenges(String term)	throws SuggestedChallengeNotFoundException;

	public ArrayList<Challenge> getChallenge(String rgstrId) throws GetChallengeException;
	
	public abstract ArrayList<Challenge> searchChallengeByTitle(SearchByKeyVO searchByKeyVO)throws SearchChallengeException;
	
	public abstract Challenge getChallengeDetail(String ChallengeId) throws GetChallengeDetailException;
	
	public abstract String uploadChallengeDocument(UploadChallDocVO uploadChallDocVO) throws UploadChallengeDocException;
	
	public abstract ArrayList<ProjectDocument> downloadChallengeDocument(DownChallengeDocVO challengeDocVO) throws DownloadChallengeDocException;
	
	public abstract ArrayList<Challenge> getChallengesByLoggedInUser(String rgstrId) throws ChallengesByLoggedInUserException;
	
	public abstract String acceptChallenge(Project project) throws AcceptChallengeException;
	
	public abstract String deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO) throws DeleteDocumentException;
}
