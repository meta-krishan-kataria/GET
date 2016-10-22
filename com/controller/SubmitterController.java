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

import com.dao.IssueDAO;
import com.model.DepartmentVO;
import com.model.IssueVO;
import com.service.IssueService;
import com.service.UserService;

@RestController
public class SubmitterController {

	@Autowired
	private IssueService issueService;

	@Autowired
	private UserService userService;

	@Autowired
	private IssueDAO issueDAO;
	
	@RequestMapping(value = "/createticket", method = RequestMethod.POST)
	public ResponseEntity<String> createIssue(@RequestBody IssueVO issueVO,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return new ResponseEntity<String>("Unauthorized User",
					HttpStatus.OK);
		} else {
			issueVO.setCreatedBy(session.getAttribute("userId") + "");
			if (issueService.createIssue(issueVO)) {
				return new ResponseEntity<String>("Issue created",
						HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("An error Occurred!!",
						HttpStatus.OK);
			}
		}
	}

	@RequestMapping(value = "/getdepartments", method = RequestMethod.GET)
	public ResponseEntity<List<DepartmentVO>> getDepartments() {
		return new ResponseEntity<List<DepartmentVO>>(
				issueService.getDepartments(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getIssueById", method = RequestMethod.GET)
	public ResponseEntity<IssueVO> getIssueById(@RequestParam("id") int id) {
		IssueVO issueVO = issueService.getIssueById(id);
		return new ResponseEntity<IssueVO>(issueVO, HttpStatus.OK);
	}

	@RequestMapping(value = "/getIssuesByCreaterId", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getIssuesByCreaterId(
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println(userId);
		if (userId == null) {
			return new ResponseEntity<List<IssueVO>>(HttpStatus.OK);
		} else {
			List<IssueVO> issuesVO = issueService.getIssuesByUserId(userId);
			for (IssueVO issue : issuesVO) {
				System.out.println(issue.getBody() + "\n" + issue.getId()
						+ "\n" + issue.getPriority() + "\n" + issue.getTitle()
						+ "\n");
			}
			return new ResponseEntity<List<IssueVO>>(issuesVO, HttpStatus.OK);
		}
	}
}
