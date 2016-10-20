/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDAOImpl;
import com.sun.jmx.snmp.Timestamp;
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



	/*public boolean approveIssue(int issueId, int deptId){

		return  departmentDAO.updateStatusOfIssue(issueId, deptId, "approve");
	}*/



	public boolean markIssueForReview(int issueId, int deptId){

		return  departmentDAO.updateStatusOfIssue(issueId, deptId, "conflict");
	}


	public List<ResolverVO> getResolversList( int deptId ){

		List<UserDetails> resolvers=departmentDAO.getAllResolvers(deptId);

		return adapter.convertToResolverVO( resolvers );
	}




	public boolean allocateIssue(  IssueVO issueVO  ){
		//marking as "approved"
		boolean isApproved=departmentDAO.updateStatusOfIssue(issueVO.getId(), issueVO.getDeptId(), "approve");

		//assigning resolvers
		for( Integer resolverId : issueVO.getResolvers() ){
			departmentDAO.assignIssueToResolver( issueVO.getId(), resolverId, issueVO.getDeptId() );
		}

		//setting target resolution date
		//departmentDAO.setTargetResolutionDateForIssue(   issueVO.getTargetResolutionDate( ), issueId)

		return true;
	}





}
