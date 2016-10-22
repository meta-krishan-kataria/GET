package com.util;

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

public interface ModelAdapter {

	UserDetails convert(UserDetailsVO userDetailVO);

	UserDetailsVO convert(UserDetails userDetails);

	Issue convert(IssueVO issueVO);

	IssueVO convert(Issue issue);

	DepartmentVO convert(Department department);

	CommentVO convert(Comment comment);

	Tag convert(TagVO tagVO);

	Comment convert(CommentVO commentVO);

	Department convert(DepartmentVO departmentVO);
}
