package com.techpedia.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ReviewSystemSessionCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		/**
		 * @param request
		 * @param response
		 * @param handler
		 * @return
		 * @throws Exception
		 * @author Habibul Ali Shah
		 */	
		ArrayList<String> restrictedPagesinReviewSystem = new ArrayList<String>();
		
		restrictedPagesinReviewSystem.add("reviewDashboard");
		restrictedPagesinReviewSystem.add("reviewGYTIProjects");
		restrictedPagesinReviewSystem.add("reviewInnovation");
		restrictedPagesinReviewSystem.add("addReviewer");
		restrictedPagesinReviewSystem.add("reviewerStatus");
		restrictedPagesinReviewSystem.add("editReviewAndRating");
		restrictedPagesinReviewSystem.add("forwardProjectToReviewer");
		restrictedPagesinReviewSystem.add("getAllReviews");
		restrictedPagesinReviewSystem.add("allReviewsForLoggedInReviewer");
		restrictedPagesinReviewSystem.add("adminGetAllSuggestedReviewers");
		restrictedPagesinReviewSystem.add("suggestedReviewersByLoggedInReviewer");
		restrictedPagesinReviewSystem.add("reviewerLogout");
		restrictedPagesinReviewSystem.add("gytiArchive");
		boolean flag=true;
		String reviewSystemurl = request.getRequestURL().toString().split("/")[request.getRequestURL().toString().split("/").length - 1];
		boolean restrictAccess = false;
		for(String pageToIntercept : restrictedPagesinReviewSystem){
			if(reviewSystemurl.contains(pageToIntercept)){
				restrictAccess = true;
			}
		}
		
		
		if(restrictAccess){
			
			HttpSession session = request.getSession(false);
			if(session==null || session.getAttribute("revfirstName") == null){
				response.sendRedirect("index");
				return false;
			}
			/*else if(session.getAttribute("revfirstName") == null){
				response.sendRedirect("index");
				return false;
			}
			*/
		}
		return flag;	
		
	}

}
