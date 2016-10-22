 package com.service;

import java.util.List;

import com.model.CommentVO;
import com.model.IssueVO;

public interface ResolverService {

	/**
	 * @param userId
	 * @return List<IssueVO>
	 * the method will get List of issues which are in progress state
	 * and not completed by the resolver
	 */
	public List<IssueVO> getIssueListInProgress(int userId);
	
	/**
	 * @param userId
	 * @return List<IssueVO>
	 * the method will get List of issues which are assigned state
	 * and not accepted by the resolver
	 */
	public List<IssueVO> getIssueListAssign(int userId);
	
	/**
	 * @param id
	 * @return IssueVO
	 * the method will get issues by id on resolver page
	 */
	public IssueVO getIssueDetailById(int issueId);
	
	/**
	 * 
	 * @param id
	 * @return List<CommentVO>
	 * the method will list comment on issue
	 */
	public List<CommentVO> getCommentOnIssue(int issueId);
	
	/**
	 * 
	 * @param id
	 * delete comment
	 */
	public void deleteCommentOnIssue(int issueId);
	
	/**
	 * Add comment on issue
	 * @param commentVO
	 */
	public void addCommentOnIssue(CommentVO commentVO);
	
	/**
	 * 
	 * @param id
	 * @param userId
	 * update status from assigned to in Progress 
	 */
	public void updateStatusToInProgress(int issueId,int userId);
	
	/**
	 * 
	 * @param id
	 * @param userId
	 * update status from in Progress to resolved
	 */
	public void updateStatusToResolved(int issueId,int userId);
}
