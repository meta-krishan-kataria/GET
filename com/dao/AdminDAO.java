package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Issue;
import com.model.UserDetails;

public interface AdminDAO {

	public List<Department> getAllDepartment();
	
	public UserDetails getDepartmentHead(int deptId);
	
	public void addDepartment(Department department);
	
	public void addDeptHead(UserDetails userDetails);
	
	public List<Issue> getConflictIssueList();
	
	public void closedIssue(int issueId, int userId);
	
}
