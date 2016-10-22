/**
 * 
 * */
package com.dao;

import java.util.List;
import java.sql.Timestamp;

import com.model.*;

public interface DepartmentDAO {
	
	/**
	 * Retrieves all issues of the department mapped by department id
	 * */
	public List<Issue> getAllIssues(int deptId);
	/**
	 * Retrieves all new issues of the department 
	 * (issues which are newly received i.e. they are not approved by department head) 
	 *//*
	public List<Issue> getNewIssues(int deptId);*/
	
	
	/**
	 * Updates status of the issue
	 * dept-head and change status to approve,conflict
	 * */
	public boolean updateStatusOfIssue(int issueId, int deptId, String status);
	
	
	
	
	/**************/
	
	/**
	 * retrieves list of all resolvers under the particular department
	 * */
	public List<UserDetails> getAllResolvers(int deptId);
	
	/**
	 * retrieves list of all resolvers under the particular department
	 * to whom the issue can be assigned (i.e. resolvers who are not assigned
	 * under the given issue)
	 * */
	//public List<UserDetails> getAllAvailabeResolvers(int deptId,int issueId);
	
	/**
	 * assigns the issue to a resolver
	 * also updates the issue status
	 * */
	public boolean assignIssueToResolver(int issueId, int resolverId, int deptId);
	
	/**
	 * sets the target resolution date for the issue
	 * */
	public boolean setTargetResolutionDateForIssue(Timestamp targetResolutionDate,int issueId);
	
	
	
	/**
	 * a utility method to get user id of the dept-head
	 * 
	 * */
	//public int getUserIdOfDepartmentHead(int i);
	
	
	public UserDetails getResolver(int resolverId);
	public List<Issue> getPendingIssues(int deptId);
	public Issue getIssueById(int id);
	List<Issue> getIssuesByStatus(int deptId, String status);


	boolean addUserToDepartment(int deptId, int userId);
	
	
}
