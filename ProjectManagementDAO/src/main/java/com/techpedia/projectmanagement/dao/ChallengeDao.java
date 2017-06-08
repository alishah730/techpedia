/**
 * 
 */
package com.techpedia.projectmanagement.dao;

import java.util.ArrayList;

import com.techpedia.projectmanagement.bean.AddCommChallengeVO;
import com.techpedia.projectmanagement.bean.Challenge;
import com.techpedia.projectmanagement.bean.ChallengeComment;
import com.techpedia.projectmanagement.bean.ChallengeTeam;
import com.techpedia.projectmanagement.bean.ChallengeType;
import com.techpedia.projectmanagement.bean.ChallengeTypeMasterVO;
import com.techpedia.projectmanagement.bean.DeleteChallDocVO;
import com.techpedia.projectmanagement.bean.DeleteChallengeCommVO;
import com.techpedia.projectmanagement.bean.DisplayChallengeCommVO;
import com.techpedia.projectmanagement.bean.DownChallengeDocVO;
import com.techpedia.projectmanagement.bean.FollowChallengeVO;
import com.techpedia.projectmanagement.bean.Project;
import com.techpedia.projectmanagement.bean.ProjectDocument;
import com.techpedia.projectmanagement.bean.SearchByKeyVO;
import com.techpedia.projectmanagement.bean.UploadChallDocVO;
import com.techpedia.projectmanagement.exception.AcceptChallengeException;
import com.techpedia.projectmanagement.exception.AddCommentException;
import com.techpedia.projectmanagement.exception.ChallengeTeamNotFoundException;
import com.techpedia.projectmanagement.exception.ChallengesByLoggedInUserException;
import com.techpedia.projectmanagement.exception.CheckChallengeFollowException;
import com.techpedia.projectmanagement.exception.CreateChallengeException;
import com.techpedia.projectmanagement.exception.DeleteDocumentException;
import com.techpedia.projectmanagement.exception.DownloadChallengeDocException;
import com.techpedia.projectmanagement.exception.FollowTheChallengeException;
import com.techpedia.projectmanagement.exception.GetAllChallengeException;
import com.techpedia.projectmanagement.exception.GetAllFollowedChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeDetailException;
import com.techpedia.projectmanagement.exception.GetChallengeException;
import com.techpedia.projectmanagement.exception.GetChallengeTypeException;
import com.techpedia.projectmanagement.exception.RemoveChallengeFollowException;
import com.techpedia.projectmanagement.exception.RemoveCommentException;
import com.techpedia.projectmanagement.exception.SearchChallengeException;
import com.techpedia.projectmanagement.exception.SuggestedChallengeNotFoundException;
import com.techpedia.projectmanagement.exception.TeamCommentsNotFoundException;
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
	
	public abstract Challenge getChallengeDetail(String challengeId) throws GetChallengeDetailException;
	
	public abstract String uploadChallengeDocument(UploadChallDocVO uploadChallDocVO) throws UploadChallengeDocException;
	
	public abstract ArrayList<ProjectDocument> downloadChallengeDocument(DownChallengeDocVO challengeDocVO) throws DownloadChallengeDocException;
	
	public abstract ArrayList<Challenge> getChallengesByLoggedInUser(String rgstrId) throws ChallengesByLoggedInUserException;
	
	public abstract String acceptChallenge(Project project) throws AcceptChallengeException;
	
	public abstract String deleteChallengeDocument(DeleteChallDocVO deleteChallDocVO) throws DeleteDocumentException;
	
	public abstract ArrayList<ChallengeType> getChallengeType() throws GetChallengeTypeException;

	public abstract String followTheChallenge(FollowChallengeVO followChallengeVO) throws FollowTheChallengeException;

	public abstract String removeChallengeFollow(FollowChallengeVO followChallengeVO) throws RemoveChallengeFollowException;

	public abstract ArrayList<Challenge> getAllFollowedChallenges(String rgstrId) throws GetAllFollowedChallengeException;

	public abstract String checkChallengeFollow(FollowChallengeVO followChallengeVO) throws CheckChallengeFollowException;
	
	public abstract String addComment(AddCommChallengeVO addCommChallengeVO) throws AddCommentException;

	public abstract ArrayList<ChallengeComment> getComments(DisplayChallengeCommVO displayChallengeComm) throws TeamCommentsNotFoundException;

	public abstract String deleteChallengeComment(DeleteChallengeCommVO deleteChallengeCommVO) throws RemoveCommentException;

	public abstract ArrayList<ChallengeTeam> getChallengeTeamList(String challengId) throws ChallengeTeamNotFoundException;
}
