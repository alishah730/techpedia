package com.techpedia.usermanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techpedia.chiper.ChiperUtils;
import com.techpedia.logger.TechPediaLogger;
import com.techpedia.usermanagement.entity.UsrMngtPassword;
import com.techpedia.usermanagement.exception.PasswordResetException;
import com.techpedia.usermanagement.exception.UserNotFoundException;
import com.techpedia.util.HibernateUtil;

public class PasswordUtil {
	
	private static TechPediaLogger log = TechPediaLogger.getLogger(PasswordUtil.class.getName());
	
	public String passwordReset(String userId, String oldPwd,String newPwd) throws PasswordResetException, UserNotFoundException {
		String updateMessage = null;
		Transaction tx = null;
		Session ss = HibernateUtil.getSessionFactory().openSession();
		String createdDate = getCurrentTimeStamp();
		UsrMngtPassword pwdObj = null;
			try {
				String currentPassword = getCurrentPassword(userId);
				if(!currentPassword.equals(oldPwd)) {
					log.error("The current password entered was wrong");
					throw new PasswordResetException("UM-Ex005","PasswordResetException", "The current password entered was wrong");
				}
				
				if(oldPwd.equals(newPwd)) {
					log.error("old password and new passwords are same");
					throw new PasswordResetException("UM-Ex005","PasswordResetException", "old password and new passwords are same");
					
				} else 	if(userId.equals(newPwd)) {
					log.error("new password and user id are same");
					throw new PasswordResetException("UM-Ex005","PasswordResetException", "new password and user id are same");
					
				} else {
				tx = ss.beginTransaction();
				log.debug("Password Reset : Start");
				Query queryPassword = ss.createQuery("from UsrMngtPassword where USR_ID = :userid order by CREATED_DATE desc");
				queryPassword.setParameter("userid", userId);
				queryPassword.setMaxResults(5);
				@SuppressWarnings("unchecked")
				List<UsrMngtPassword> passwords = queryPassword.list();
				
				for (int i=0;i<passwords.size();i++){
					pwdObj = (UsrMngtPassword) passwords.get(i);
					String lastPassword = ChiperUtils.decrypt2(pwdObj.getUsrPasswd());
					if(lastPassword.equals(newPwd)) {
						log.error("New password entered is one of the last 5 passwords");
						throw new PasswordResetException("UM-Ex005","PasswordResetException", "New password entered is one of the last 5 passwords");
					} 
					
				}
				
				String encryPassword = ChiperUtils.encrypt2(newPwd);
				if(passwords.size() >= 5) {
					
					Date lastcreateddate = (Date) ss.createSQLQuery("select min(CREATED_DATE) from usr_mngt_passwd where USR_ID=:userid").setParameter("userid", userId).uniqueResult();
					
					Query query = ss.createQuery("update UsrMngtPassword u set u.usrPasswd = :newpwd, u.createdDate= :createddate where u.usrId = :userid and u.createdDate=:lastCreated");
					query.setParameter("userid", userId);
					query.setParameter("newpwd", encryPassword);
					query.setParameter("createddate", createdDate);
					query.setParameter("lastCreated", lastcreateddate.toString());
					query.executeUpdate();
					
					} else {
						
						UsrMngtPassword uPassword = new UsrMngtPassword(pwdObj.getRgstrId(), userId, encryPassword, createdDate);
						ss.save(uPassword); 
					}
					tx.commit();
					updateMessage = "password updated Successfully";
				
			}
			
		} catch (Exception e) {
				log.error((new StringBuilder("Error while commiting the transaction :")).append(e.getMessage()).toString());
				
				try {
					tx.rollback();
				} catch (Exception e1) {
					log.error((new StringBuilder("Error while Roll back the transaction :")).append(e.getMessage()).toString());
				}
			} 
			finally {
				tx = null;
				ss.close();
			}
			log.debug("Password Reset : End");
		return updateMessage;
		
	}
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
/*	public String getCurrentPassword(String userId) throws UserNotFoundException, PasswordResetException {
		String currentPassword =null;
		Session ss = HibernateUtil.getSessionFactory().openSession();
		try {
		Query queryPassword = ss.createQuery("from UsrMngtPassword where USR_ID = :userid order by CREATED_DATE desc");
		queryPassword.setParameter("userid", userId);
		queryPassword.setMaxResults(1);
		UsrMngtPassword passwords = (UsrMngtPassword) queryPassword.uniqueResult();
		if(passwords == null) {
			log.error("Entered User Id is not Existed in the database");
			throw new UserNotFoundException("UM-Ex006","UserNotFoundException","Entered User Id is not Existed in the database");
		}
		currentPassword = ChiperUtils.decrypt2(passwords.getUsrPasswd());
		} catch (Exception e) {
			log.error("Password Reset Exception" + e.getMessage());
			throw new PasswordResetException("UM-Ex-005","PasswordResetException",e.getMessage());
		}finally{
			ss.close();
		}
		return currentPassword;
	}*/
	
	
	public String getCurrentPassword(String emailId) throws UserNotFoundException, PasswordResetException {
		String currentPassword =null;
		Session ss = HibernateUtil.getSessionFactory().openSession();
		try {
		//Query queryPassword = ss.createQuery("from UsrMngtPassword where USR_ID = :userid order by CREATED_DATE desc");
		Query queryPassword = ss.createQuery("from UsrMngtPassword where USR_ID in(select userId from UsrMngtMaster where EMAIL_ID=:emailId) order by CREATED_DATE desc");
		queryPassword.setParameter("emailId", emailId);
		queryPassword.setMaxResults(1);
		UsrMngtPassword passwords = (UsrMngtPassword) queryPassword.uniqueResult();
		if(passwords == null) {
			log.error("Entered Email Id is not Existed in the database");
			throw new UserNotFoundException("UM-Ex006","UserNotFoundException","Entered Email ID does not exist in Techpedia database");
		}
		currentPassword = ChiperUtils.decrypt2(passwords.getUsrPasswd());
		}catch (UserNotFoundException e) {
			log.error("User Not Found Exception" + e);
			throw e;
		}catch (Exception e) {
			log.error("Password Reset Exception" + e);
			throw new PasswordResetException("UM-Ex-005","PasswordResetException",e.getMessage());
		}finally{
			ss.close();
		}
		return currentPassword;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordUtil putil = new PasswordUtil();
		
		String Result = null;
		try {
			Result = putil.passwordReset("Ronoldino7102014", "prakash1234", "prakash1234");
		} catch (PasswordResetException  | UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Result : " + Result);
		/*UserProfileDO uprofiledo = null;
		long num = 25;
		try {
			uprofiledo = new UserManagementDAOImpl().getUserProfile(num);
		} catch (ProfileNotFoundException | ProfileFetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("userprofile object:::::: " + uprofiledo.toString());*/
	}

}
