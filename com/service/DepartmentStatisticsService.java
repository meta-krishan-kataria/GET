/**
 * 
 */
package com.service;

/**
 * @author admin
 *
 */
public interface DepartmentStatisticsService {
	
	public Long getCountOfNewIssues(int deptId);

	public Long getCountOfPendingissues(int deptId);

	public Long getCountOfSolvedIssues(int dept);

	public Long getCountOfIssues(int dept);

}
