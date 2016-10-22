package com.dao;

import java.util.List;

import com.model.Comment;
import com.model.Issue;

public interface ResolverDAO {

	
	/**
	 * the method will get List of issues which are in progress state
	 * and not completed by the resolver
	 */
	public List<Issue> getIssueListInProgress(int userId);
	
	/**
	 * the method will get List of issues which are in assigned state
	 * and not accepted by the resolver
	 */
	public List<Issue> getIssueListAssign(int userId);

	/**
	 * the method will get issues by id on resolver page
	 */
	public Issue getIssueDetailbyId(int id);

	/**
	 * the method will list comment on issue
	 */
	public List<Comment> getCommentOnIssue(int id);

	/**
	 * the method will delete comment 
	 */
	public void deleteCommentOnIssue(int id);

	/**
	 *add comment on issue
	 */
	public void addCommentOnIssue(Comment comment);
	
	/**
	 * update status of issue
	 */
	public void updateStatusOfIssue(int issueId, int userId, String status);
}
