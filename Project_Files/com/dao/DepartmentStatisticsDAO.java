/**
 * 
 */
package com.dao;

/**
 * @author admin
 *
 */
public interface DepartmentStatisticsDAO {
	
	public int getCountOfNewIssues(int deptId);
	
	public int getCountOfPendingissues(int deptId);
	
	public int getCountOfSolvedIssues(int dept);
	
	public int getCountOfIssues(int dept);
	
		
	
	
}
