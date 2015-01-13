package com.techpedia.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		ArrayList<String> restrictedPages = new ArrayList<String>();
		restrictedPages.add("dashboard");
		restrictedPages.add("manageProjects");
		restrictedPages.add("manageChallenge");
		restrictedPages.add("addProject");
		restrictedPages.add("editProfile");
		restrictedPages.add("challengeDetails");
		restrictedPages.add("addChallenge");
		restrictedPages.add("mentorDetails");
		restrictedPages.add("ideate");
		restrictedPages.add("addMentor");

		restrictedPages.add("editProject");
		restrictedPages.add("manageProjects");
		restrictedPages.add("teamDetails");
		restrictedPages.add("teams");

		String url = request.getRequestURL().toString().split("/")[request.getRequestURL().toString().split("/").length - 1];
		if (restrictedPages.contains(url)) {
			System.out.println("Inside interceptor Evaluation - " + url);
			HttpSession session = request.getSession(false);
			if (session == null) {
				System.err.println("Redirecting to index");
				response.sendRedirect("loginagain");
				return false;
			} else {
				if (session.getAttribute("username") == null) {
					System.err.println("Redirecting to index");
					response.sendRedirect("loginagain");
					return false;
				} else {
					return true;
				}
			}

		} else {
			System.out.println("Inside interceptor Free - " + url);
			return true;
		}
	}

}
