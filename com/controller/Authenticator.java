package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Authenticator implements HandlerInterceptor {

	private final String login = "/login/signin";
	private final String js = "js";
	private final String css = "css";
	private final String html = "htm";
	private final String ui = "ui";

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2) throws Exception {
		try {
			HttpSession session = request.getSession();
			String requestURL = request.getRequestURL().toString();
			if (!(requestURL.toLowerCase().contains(login)
					|| requestURL.toLowerCase().contains(js)
					|| requestURL.toLowerCase().contains(css)
					|| requestURL.toLowerCase().contains(html) || requestURL
					.toLowerCase().contains(ui))) {
				if (session == null || session.getAttribute("userId") == null) {
					arg1.sendRedirect("index.html");
					return false;
				} else {
					return true;
				}
			}
			return true;
		} catch (Exception e) {
			arg1.sendRedirect("index.html");
		}
		return true;

	}
}
