package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.UserDetailsVO;
import com.model.UserToken;
import com.service.UserService;

@Controller
@RequestMapping("/login")
public class IssueController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = { "application/json" }, produces = "application/json")
	public @ResponseBody UserDetailsVO savePerson(
			@RequestBody UserToken tokenResponse, HttpServletRequest request) {
		UserDetailsVO userDetailsVO = userService
				.userSignInSignUp(tokenResponse);
		HttpSession session = request.getSession();
		session.setAttribute("userId", userDetailsVO.getId());
		System.out.println(session.getAttribute("userId"));
		session.setAttribute("role", userDetailsVO.getRole());
		session.setAttribute("deptId", userDetailsVO.getDepartment());
		session.setAttribute("userName", userDetailsVO.getName());
		
		System.out.println("Login");
		System.out.println(userDetailsVO.getRole() + userDetailsVO.getName());
		return userDetailsVO;
	}
}
