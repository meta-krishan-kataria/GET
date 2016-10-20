/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDAOImpl;
import com.util.Adapter;
import com.model.*;

/**
 * @author admin
 *
 */

@Service
public class DepartmentService {
	
	@Autowired
	Adapter adapter;
	
	@Autowired
	DepartmentDAOImpl departmentDAO;
	
	
	//
	public List<IssueVO> getNewIssues(int deptId){
		
		List<Issue> issueList = departmentDAO.getNewIssues(deptId);
		
		return adapter.convertToVO(issueList);
	}
	
	
	
	//
	public List<IssueVO> getPendingIssues(int deptId){
		
		List<Issue> issueList = departmentDAO.getPendingIssues(deptId);
		
		return adapter.convertToVO(issueList);
	}
	
	
	
	public IssueVO getIssueById(int issueId){
		
		Issue issue=departmentDAO.getIssueById(issueId);
		
		return adapter.convertToVO(issue);
	}
	
}
