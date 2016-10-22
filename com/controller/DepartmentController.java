/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.DepartmentService;
import com.service.DepartmentStatisticsService;
import com.model.*;

import java.util.List;

/**
 * @author Krishan Kataria
 *
 */
@RestController
//@RequestMapping(value = "/department")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@Autowired
	DepartmentStatisticsService dsService;

	
	//********************Temporary Login******************************
	@RequestMapping(value = "/templogin", method = RequestMethod.GET)
	public ResponseEntity<String> tempLogin(HttpServletRequest request) {

		HttpSession httpSession=request.getSession();

		httpSession.setAttribute("deptId", 1);
		httpSession.setAttribute("userId", 4);
		httpSession.setAttribute("userName", "Krishan");
		httpSession.setAttribute("role", "dept-head");


		return new ResponseEntity<String>("Logged in: "+  httpSession.getAttribute("userName")  +" " +httpSession.getAttribute("role"), HttpStatus.OK);
	}
	//********************Temporary Login******************************



	/*	@RequestMapping(value = "/test", method = RequestMethod.GET)
		public ResponseEntity testSessionAttributes(HttpServletRequest request) {

			int userId = (int) session.getAttribute("deptId");
			String role = (String) session.getAttribute("role");
			int deptId = (int) session.getAttribute("deptId");

			//int deptId = (int) session.getAttribute("deptId");




			return new ResponseEntity(HttpStatus.OK);
		}*/


	// ----------Get all new Issues------------------------------------

	@RequestMapping(value = "/newIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getNewIssues(HttpServletRequest request) {

		HttpSession httpSession=request.getSession();
		int deptId =  (Integer) httpSession.getAttribute("deptId");

		System.out.println("dept id is+++++++++++++++++++++++++  "+deptId);
		//int deptId=1;

		List<IssueVO> newIssues = service.getNewIssues(deptId);

		if (newIssues.isEmpty()) {
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<IssueVO>>(newIssues, HttpStatus.OK);
	}

	// ----------Get all pending Issues---------------------------------

	@RequestMapping(value = "/pendingIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getPendingIssues(HttpSession session) {

		int deptId = (Integer) session.getAttribute("deptId");
		List<IssueVO> pendingIssues = service.getPendingIssues(deptId);

		if (pendingIssues.isEmpty()) {
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<IssueVO>>(pendingIssues, HttpStatus.OK);
	}

	// ----------Get an Issues by id---------------------------------

	@RequestMapping(value = "/issue/{id}", method = RequestMethod.GET)
	public ResponseEntity<IssueVO> getIssueById(HttpSession session,
			@PathVariable("id") int issueId) {


		System.out.println("dep");
		IssueVO issue = service.getIssueById(issueId);

		if (issue == null) {
			return new ResponseEntity<IssueVO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<IssueVO>(issue, HttpStatus.OK);
	}

	// ----------Get all resolvers------------------------------------

	@RequestMapping(value = "/resolvers", method = RequestMethod.GET)
	public ResponseEntity<List<ResolverVO>> getResolversList(HttpSession session) {

		int deptId = (Integer) session.getAttribute("deptId");
		List<ResolverVO> resolverVOList = service.getResolversList(deptId);

		if (resolverVOList.isEmpty()) {
			return new ResponseEntity<List<ResolverVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<ResolverVO>>(resolverVOList,
				HttpStatus.OK);
	}

	// ----------Allocate Issue------------------------------------

	@RequestMapping(value = "/allocate", method = RequestMethod.POST)
	public ResponseEntity<Void> allocateIssue(@RequestBody IssueVO issueVO) {

		

		boolean result = service.allocateIssue(issueVO);
		
		//IssueVO updatedIssue=service.getIssueById(issueVO.getId());
		
		
		System.out.println("all : "+result);
		if (result == false) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("Contlr: all done");
		return new ResponseEntity<Void>( HttpStatus.CREATED);
	}



	// ----------Get dashboard stats---------------------------------

	@RequestMapping(value = "/dashboardStats", method = RequestMethod.GET)
	public ResponseEntity<DepartmentDashboardDataObject> getDepartmentDashboardData(HttpSession session) {

		int deptId = (Integer) session.getAttribute("deptId");
		System.out.println("dep");
		DepartmentDashboardDataObject data=service.getDashboardStatistics(deptId);

		if (data == null) {
			return new ResponseEntity<DepartmentDashboardDataObject>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DepartmentDashboardDataObject>(data, HttpStatus.OK);
	}
	
	// ----------add  Resolvers------------------------------------

		@RequestMapping(value = "/addResolver/{id}", method = RequestMethod.POST)
		public ResponseEntity<String> addResolversToDepartment(HttpSession session,
				@PathVariable("id") int userId) {

			int deptId = (Integer) session.getAttribute("deptId");
			
			boolean result = service.addUserToDepartment(deptId, userId);

			if ( result==false ) {
				return new ResponseEntity<String>("Unable to add", HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<String>("Added Successfully", HttpStatus.OK);
		}
	
	
	

}
