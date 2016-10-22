/**
 * 
 */
package com.dao;

/**
 * @author admin
 *
 */
public interface DepartmentStatisticsDAO {
	
	public Long getCountOfIssuesByStatus(int deptId, String status) ;	
	
	public Long getCountOfIssues(int deptId) ;		
	
	
}
