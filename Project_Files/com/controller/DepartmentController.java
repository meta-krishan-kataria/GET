/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class DepartmentController {

	@Autowired
	DepartmentService service;

	//----------Retrive all new Issues----------------------------------------------

	@RequestMapping(value = "/newIssues", method = RequestMethod.GET )
	public ResponseEntity<List<IssueVO>> getNewIssues(){

		//int deptId=(int) session.getAttribute("deptId");
		List<IssueVO> newIssues = service.getNewIssues(1);

		if( newIssues.isEmpty() ){
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity< List<IssueVO> >( newIssues, HttpStatus.OK);
	}


	//----------Retrive all new Issues----------------------------------------------

	@RequestMapping(value = "/pendingIssues", method = RequestMethod.GET )
	public ResponseEntity<List<IssueVO>> getPendingIssues(HttpSession session){

		//int deptId=(int) session.getAttribute("deptId");
		List<IssueVO> pendingIssues = service.getPendingIssues(1);

		if( pendingIssues.isEmpty() ){
			return new ResponseEntity<List<IssueVO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity< List<IssueVO> >( pendingIssues, HttpStatus.OK);
	}






}
