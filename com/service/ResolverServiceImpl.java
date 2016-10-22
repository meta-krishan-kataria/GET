package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ResolverDAO;
import com.model.Comment;
import com.model.CommentVO;
import com.model.Issue;
import com.model.IssueVO;
import com.util.ModelAdapter;
import com.util.ModelAdapterImpl;

@Service
public class ResolverServiceImpl implements ResolverService {

	@Autowired
	private ResolverDAO resolverDAO;
	
	/*@Autowired
	private ModelAdapter modelAdapter;*/
	
	@Override
	public List<IssueVO> getIssueListInProgress(int userId) {
		List<Issue> issueList=resolverDAO.getIssueListInProgress(userId);
		ModelAdapter modelAdapter=new ModelAdapterImpl();
		List<IssueVO> issues = new ArrayList<IssueVO>();
		for(Issue issue: issueList)
		{
				issues.add(modelAdapter.convert(issue));
		}
		return issues;
	}
	
	@Override
	public List<IssueVO> getIssueListAssign(int userId) {
		
		List<Issue> issueList=resolverDAO.getIssueListAssign(userId);
		ModelAdapter modelAdapter=new ModelAdapterImpl();
		List<IssueVO> issues = new ArrayList<IssueVO>();
		for(Issue issue: issueList)
		{
				issues.add(modelAdapter.convert(issue));
		}
		return issues;
	}

	@Override
	public IssueVO getIssueDetailById(int issueId) {
		Issue issue= resolverDAO.getIssueDetailbyId(issueId);
		ModelAdapter modelAdapter=new ModelAdapterImpl();
		
		IssueVO issueVO=modelAdapter.convert(issue);
		return issueVO;
	}

	@Override
	public List<CommentVO> getCommentOnIssue(int issueId) {
		System.out.println("cooment method");
		List<Comment> commentList=resolverDAO.getCommentOnIssue(issueId);

		ModelAdapter modelAdapter=new ModelAdapterImpl();
		List<CommentVO> commentVOList=new ArrayList<CommentVO>();
		for(Comment comment: commentList){
			commentVOList.add(modelAdapter.convert(comment));
		}
		return commentVOList;
	}

	@Override
	public void deleteCommentOnIssue(int issueId) {
		resolverDAO.deleteCommentOnIssue(issueId);	
	}

	@Override
	public void addCommentOnIssue(CommentVO commentVO) {
		ModelAdapter modelAdapter=new ModelAdapterImpl();
		Comment comment=modelAdapter.convert(commentVO);
		resolverDAO.addCommentOnIssue(comment);
	}

	@Override
	public void updateStatusToInProgress(int issueId, int userId) {
		String status="inprogess";
		resolverDAO.updateStatusOfIssue(issueId, userId, status);
	}

	@Override
	public void updateStatusToResolved(int issueId, int userId) {
		String status="resolved";
		resolverDAO.updateStatusOfIssue(issueId, userId, status);
	}

}