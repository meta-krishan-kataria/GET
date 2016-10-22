package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.DepartmentVO;
import com.model.IssueVO;
import com.model.UserDetailsVO;
import com.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserDetailsVO userDetailsVO;

	@RequestMapping(value = "/GetDepartment", method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentVO>> getAllDeparment() {
		System.out.println("Department");
		List<DepartmentVO> departments = adminService.getDepartmentList();
		return new ResponseEntity<List<DepartmentVO>>(departments,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/GetDepartmentHeadDetail", method = RequestMethod.GET)
	public ResponseEntity<UserDetailsVO> getDepartmentHeadDetail(
			@RequestParam("id") String id) {
		UserDetailsVO userDetailsVO = adminService.getDepartmentHead(Integer
				.parseInt(id));
		return new ResponseEntity<UserDetailsVO>(userDetailsVO,
				HttpStatus.FOUND);
	}

	@RequestMapping(value = "/AddDepartment", method = RequestMethod.POST)
	public void addDepartment(@RequestBody DepartmentVO departmentVO) {
		System.out.println(departmentVO);
		adminService.addDepartment(departmentVO);
	}

	@RequestMapping(value = "/GetConflictIssue", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> GetConflictIssue() {

		List<IssueVO> issueList = adminService.getConflictIssueList();
		return new ResponseEntity<List<IssueVO>>(issueList, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/CloseIssue", method = RequestMethod.POST)
	public void closeConflictIssue(HttpServletRequest request,
			@RequestParam("id") String id) {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		adminService.closedIssue(Integer.parseInt(id), userId);
	}
}