package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Issue;
import com.model.IssueStatus;

public interface IssueDAO {
	
	boolean createIssue(Issue issue);
	List<Department> getDepartments();
	Issue getIssueById(int id);
	List<Issue> getIssuesByUserId(int userId);
	boolean addIssueStatus(Issue issue);
}
