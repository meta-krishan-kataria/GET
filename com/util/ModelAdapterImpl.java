package com.util;

import java.sql.Timestamp;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.model.Comment;
import com.model.CommentVO;
import com.model.Department;
import com.model.DepartmentVO;
import com.model.Issue;
import com.model.IssueVO;
import com.model.Tag;
import com.model.TagVO;
import com.model.UserDetails;
import com.model.UserDetailsVO;

@Component
public class ModelAdapterImpl implements ModelAdapter {

	@Autowired
	private ApplicationContext context;

	@Override
	public UserDetails convert(UserDetailsVO userDetailVO) {

		return null;
	}

	@Override
	public UserDetailsVO convert(UserDetails userDetails) {
		UserDetailsVO userDetailsVO = context.getBean(UserDetailsVO.class);
		userDetailsVO.setId(userDetails.getId());
		userDetailsVO.setEmailId(userDetails.getEmailId());
		userDetailsVO.setGoogleId(userDetails.getGoogleId());
		userDetailsVO.setName(userDetails.getName());
		userDetailsVO.setDepartment(userDetails.getDepartment().getId());
		userDetailsVO.setRole(userDetails.getRole());
		userDetailsVO.setPictureURL(userDetails.getPictureURL());
		return userDetailsVO;
	}

	@Override
	public Issue convert(IssueVO issueVO) {
		Issue issue = context.getBean(Issue.class);
		Department department = context.getBean(Department.class);
		UserDetails userDetails = context.getBean(UserDetails.class);
		userDetails.setId(Integer.parseInt(issueVO.getCreatedBy()));
		issue.setCreatedBy(userDetails);
		issue.setCreatedOn(Timestamp.valueOf(issueVO.getCreatedOn()));
		issue.setTitle(issueVO.getTitle());
		department.setId(issueVO.getDepartmentId());
		issue.setDepartment(department);
		issue.setBody(issueVO.getBody());
		issue.setCurrentStatus(issueVO.getCurrentStatus());
		issue.setPriority(issueVO.getPriority());
		Set<TagVO> tagVOList = issueVO.getTags();
		Set<Tag> tagList = issue.getTags();
		tagList.clear();
		for (TagVO tagVO : tagVOList) {
			tagList.add(convert(tagVO));
		}
		return issue;
	}

	@Override
	public IssueVO convert(Issue issue) {
		IssueVO issueVO = context.getBean(IssueVO.class);
		if (issue != null) {
			issueVO.setId(issue.getId());
			issueVO.setTitle(issue.getTitle());
			issueVO.setCreatedBy(issue.getCreatedBy().getId() + "");
			issueVO.setCreatedOn(issue.getCreatedOn().toString());
			issueVO.setDepartmentId(issue.getDepartment().getId());
			issueVO.setDepartmentName(issue.getDepartment().getDepartmentName());
			issueVO.setBody(issue.getBody());
			issueVO.setCurrentStatus(issue.getCurrentStatus());
			issueVO.setPriority(issue.getPriority());
			return issueVO;
		} else {
			return null;
		}
	}

	@Override
	public DepartmentVO convert(Department department) {
		DepartmentVO departmentVO = context.getBean(DepartmentVO.class);
		departmentVO.setId(department.getId());
		departmentVO.setDepartmentName(department.getDepartmentName());
		return departmentVO;
	}

	@Override
	public CommentVO convert(Comment comment) {
		CommentVO commentVO = new CommentVO(); 
				//context.getBean(CommentVO.class);
		System.out.println(commentVO);
		commentVO.setId(comment.getId());
		commentVO.setUserId(comment.getUserId());
		commentVO.setComment(comment.getComment());
		return commentVO;
	}

	@Override
	public Tag convert(TagVO tagVO) {
		Tag tag = context.getBean(Tag.class);
		tag.setTagTitle(tagVO.getText());
		return tag;
	}

	@Override
	public Comment convert(CommentVO commentVO) {
		Comment comment = new Comment(); 
				//context.getBean(Comment.class);
		Issue issue = new Issue(); 
				//context.getBean(Issue.class);
		comment.setUserId(commentVO.getUserId());
		comment.setComment(commentVO.getComment());
		issue.setId(commentVO.getIssueId());
		comment.setIssue(issue);
		return comment;
	}

	@Override
	public Department convert(DepartmentVO departmentVO) {
		Department department = context.getBean(Department.class);
		department.setDepartmentName(departmentVO.getDepartmentName());
		return department;
	}
}
