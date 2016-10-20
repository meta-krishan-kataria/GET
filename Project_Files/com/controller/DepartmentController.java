/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpSession;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.DepartmentService;
import com.model.*;

import java.util.List;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	// ----------Get all new Issues------------------------------------

	@RequestMapping(value = "/newIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getNewIssues( HttpSession session ) {

		int deptId=(int) session.getAttribute("deptId");
		List<IssueVO> newIssues = service.getNewIssues(deptId);

		if (newIssues.isEmpty()) {
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<IssueVO>>(newIssues, HttpStatus.OK);
	}



	// ----------Get all pending Issues---------------------------------

	@RequestMapping(value = "/pendingIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getPendingIssues(HttpSession session) {

		int deptId=(int) session.getAttribute("deptId");
		List<IssueVO> pendingIssues = service.getPendingIssues(deptId);

		if (pendingIssues.isEmpty()) {
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<IssueVO>>(pendingIssues, HttpStatus.OK);
	}



	// ----------Get an Issues by id---------------------------------

	@RequestMapping(value = "/issue/{id}", method = RequestMethod.GET)
	public ResponseEntity<IssueVO> getIssueById(HttpSession session, @PathParam("id") int issueId) {


		IssueVO issue = service.getIssueById( issueId );

		if ( issue == null) {
			return new ResponseEntity<IssueVO>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<IssueVO>( issue, HttpStatus.OK);
	}



	// ----------Get all resolvers------------------------------------

	@RequestMapping(value = "/resolvers", method = RequestMethod.GET)
	public ResponseEntity<List<ResolverVO>> getResolversList( HttpSession session ) {

		int deptId=(int) session.getAttribute("deptId");
		List<ResolverVO> resolverVOList = service.getResolversList(deptId);

		if ( resolverVOList.isEmpty()) {
			return new ResponseEntity<List<ResolverVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<ResolverVO>>(resolverVOList, HttpStatus.OK);
	}


	// ----------Allocate Issue------------------------------------

	@RequestMapping(value = "/allocate", method = RequestMethod.POST)
	public ResponseEntity allocateIssue( HttpSession session, @RequestBody IssueVO issueVO ) {

		boolean result=service.allocateIssue(issueVO);

		if ( result=true ) {
			return new ResponseEntity( HttpStatus.NOT_MODIFIED );
		}

		return new ResponseEntity(  HttpStatus.OK );
	}

}
