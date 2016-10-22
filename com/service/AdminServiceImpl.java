package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.AdminDAO;
import com.model.Department;
import com.model.DepartmentVO;
import com.model.Issue;
import com.model.IssueVO;
import com.model.UserDetails;
import com.model.UserDetailsVO;
import com.util.ModelAdapter;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private ModelAdapter modelAdapter;
	
	@Autowired
	private ApplicationContext context;

	@Override
	public List<DepartmentVO> getDepartmentList() {
		List<Department> departments = adminDAO.getAllDepartment();
		List<DepartmentVO> departmentVOList = new ArrayList<DepartmentVO>();

		for (Department department : departments) {
			departmentVOList.add(modelAdapter.convert(department));
		}

		return departmentVOList;
	}

	@Override
	public UserDetailsVO getDepartmentHead(int deptId) {

		UserDetails userDetails = adminDAO.getDepartmentHead(deptId);
		UserDetailsVO userDetailsVO = modelAdapter.convert(userDetails);
		return userDetailsVO;
	}

	@Override
	public void addDepartment(DepartmentVO departmentVO) {
		Department department = modelAdapter.convert(departmentVO);
		UserDetails userDetails = context.getBean(UserDetails.class);
		userDetails.setId(departmentVO.getDepartmentHead());
		userDetails.setDepartment(department);
		adminDAO.addDepartment(department);
		adminDAO.addDeptHead(userDetails);
	}

	@Override
	public List<IssueVO> getConflictIssueList() {
		List<Issue> issueList = adminDAO.getConflictIssueList();
		List<IssueVO> issues = new ArrayList<IssueVO>();
		for (Issue issue : issueList) {
			issues.add(modelAdapter.convert(issue));
		}
		return issues;
	}

	@Override
	public void closedIssue(int issueId, int userId) {
		adminDAO.closedIssue(issueId, userId);
	}
}
