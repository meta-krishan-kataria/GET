/**
 * 
 */
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentStatisticsDAO;

/**
 * @author Krishan Kataria
 *
 */

@Service
public class DepartmentStatisticsServiceImpl implements DepartmentStatisticsService{

	@Autowired
	DepartmentStatisticsDAO dsDAO;

	
	@Override
	public Long getCountOfNewIssues(int deptId) {
		
		return dsDAO.getCountOfIssuesByStatus(deptId, "received");
	}

	
	@Override
	public Long getCountOfPendingissues(int deptId) {
		
		return dsDAO.getCountOfIssuesByStatus(deptId, "alloted");
	}

	
	@Override
	public Long getCountOfSolvedIssues(int deptId) {
		
		return dsDAO.getCountOfIssuesByStatus(deptId, "resolved");
	}

	
	@Override
	public Long getCountOfIssues(int deptId) {
		
		return dsDAO.getCountOfIssues(deptId);
	}
	
	
	
}
