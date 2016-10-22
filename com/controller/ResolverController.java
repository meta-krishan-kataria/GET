package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Comment;
import com.model.CommentVO;
import com.model.Issue;
import com.model.IssueVO;
import com.service.ResolverService;

@RestController
public class ResolverController {

	@Autowired
	private ResolverService resolverService;

	@Autowired
	private Issue issue;

	@Autowired
	private Comment comment;

	@Autowired
	private CommentVO commentVO;

	/**
	 * This method List all issues of the particular resolver by taking it's
	 * userId from the session and display all issues assign to it on Resolver
	 * DashBoard
	 * */
	@RequestMapping(value = "/NewIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getIssueListAssign(
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		int userId = (Integer) session.getAttribute("userId");

		List<IssueVO> issueList = resolverService.getIssueListAssign(userId);
		return new ResponseEntity<List<IssueVO>>(issueList, HttpStatus.FOUND);
	}

	/**
	 * This method List all issues of the particular resolver by taking it's
	 * userId from the session and display issues in progress to it on Resolver
	 * DashBoard
	 * */
	@RequestMapping(value = "/InProgessIssues", method = RequestMethod.GET)
	public ResponseEntity<List<IssueVO>> getIssueListInProgess(
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		List<IssueVO> issueList = resolverService
				.getIssueListInProgress(userId);
		return new ResponseEntity<List<IssueVO>>(issueList, HttpStatus.FOUND);
	}

	/**
	 * this method will get the list of a particular issue
	 */
	@RequestMapping(value = "/GetIssueDetail", method = RequestMethod.GET)
	public ResponseEntity<IssueVO> getIssueDetail(@RequestParam("id") String id) {
		IssueVO issue = resolverService
				.getIssueDetailById(Integer.parseInt(id));

		return new ResponseEntity<IssueVO>(issue, HttpStatus.FOUND);
	}

	/**
	 * this method is to get comment on issue
	 */
	@RequestMapping(value = "/GetComment", method = RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> getCommentOnIssue(
			@RequestParam("id") String id) {
		List<CommentVO> comment = resolverService.getCommentOnIssue(Integer
				.parseInt(id));
		return new ResponseEntity<List<CommentVO>>(comment, HttpStatus.OK);
	}

	/**
	 * this method is to delete comment on issue
	 */
	@RequestMapping(value = "/DeleteComment", method = RequestMethod.DELETE)
	public void deleteCommentOnIssue(@RequestParam("id") String id,
			ModelMap modelMap) {
		resolverService.deleteCommentOnIssue(Integer.parseInt(id));
	}

	/**
	 * this method is to add comment on issue
	 */
	@RequestMapping(value = "/AddComment", method = RequestMethod.POST)
	public void addCommentOnIssue(@RequestBody CommentVO commentVO,
			HttpServletRequest request) {
		commentVO.setUserId((int) request.getSession().getAttribute("userId"));
		System.out.println(commentVO);
		resolverService.addCommentOnIssue(commentVO);
	}

	/**
	 * this method will update the Status of assign issue to Progress when
	 * resolved will accept the issue
	 */
	@RequestMapping(value = "/UpdateStatusAssign", method = RequestMethod.POST)
	public void updateStatusAssign(HttpServletRequest request,
			@RequestParam("id") String id) {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		resolverService.updateStatusToInProgress(Integer.parseInt(id), userId);
	}

	/**
	 * this method will update the Status of Progress issue to resolved when
	 * resolved will accept the issue
	 */
	@RequestMapping(value = "/UpdateStatusInProgess", method = RequestMethod.POST)
	public void updateStatusInProgess(HttpServletRequest request,
			@RequestParam("id") String id) {
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		resolverService.updateStatusToResolved(Integer.parseInt(id), userId);
	}
}
