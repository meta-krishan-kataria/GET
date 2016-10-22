package com.service;

import java.util.List;

import com.model.DepartmentVO;
import com.model.IssueVO;
import com.model.UserDetailsVO;

public interface AdminService {

	public List<DepartmentVO> getDepartmentList();
	
	public UserDetailsVO getDepartmentHead(int deptId);
	
	public void addDepartment(DepartmentVO departmentVO);
	
	public List<IssueVO> getConflictIssueList();
	
	public void closedIssue(int issueId, int userId);
	
}
