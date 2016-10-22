/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDAO;
import com.model.DepartmentDashboardDataObject;
import com.model.Issue;
import com.model.IssueVO;
import com.model.ResolverVO;
import com.model.UserDetails;
import java.sql.Timestamp;
import com.util.Adapter;
import com.util.DateConverter;

/**
 * @author Krishan Kataria
 *
 */

@Service
public class DepartmentService {

	@Autowired
	Adapter adapter;

	@Autowired
	DepartmentDAO departmentDAO;

	@Autowired
	DepartmentStatisticsService dsService;


	//
	public List<IssueVO> getNewIssues(int deptId){

		List<Issue> issueList = departmentDAO.getIssuesByStatus(deptId, "received");

		return adapter.convertToVO(issueList);
	}



	//
	public List<IssueVO> getPendingIssues(int deptId){

		List<Issue> issueList = departmentDAO.getIssuesByStatus(deptId, "alloted");

		return adapter.convertToVO(issueList);
	}
	
	
	//
	public List<IssueVO> getOnGoingIssues(int deptId){

		List<Issue> issueList = departmentDAO.getIssuesByStatus(deptId, "inprogress");

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
		departmentDAO.updateStatusOfIssue(issueVO.getId(), issueVO.getDepartmentId(), "alloted");

		System.out.println("allocate DAO : status done");
		//assigning resolvers
		for( Integer resolverId : issueVO.getResolvers() ){
			departmentDAO.assignIssueToResolver( issueVO.getId(), resolverId, issueVO.getDepartmentId() );
		}
		
		
		//marking as "approved"
		departmentDAO.updateStatusOfIssue(issueVO.getId(), issueVO.getDepartmentId(), "alloted");

		System.out.println("allocate DAO : resolver done");
		//setting target resolution date
		setTargetResolutionDateForIssue( issueVO.getTargetResolutionDate(), issueVO.getId() );

		System.out.println("allocate DAO : date done");
		return true;
	}

	private boolean setTargetResolutionDateForIssue( String dateInString, int issueId ){

		Timestamp targetResolutionDate = DateConverter.convertToTimestamp(dateInString);

		return departmentDAO.setTargetResolutionDateForIssue(targetResolutionDate, issueId);


	}


	public DepartmentDashboardDataObject getDashboardStatistics( int deptId ){

		DepartmentDashboardDataObject data=new DepartmentDashboardDataObject();

		data.setCountOfIssues(  dsService.getCountOfIssues(deptId) );
		data.setCountOfNewIssues( dsService.getCountOfNewIssues(deptId));
		data.setCountOfPendingissues( dsService.getCountOfPendingissues(deptId) );
		data.setCountOfSolvedIssues( dsService.getCountOfSolvedIssues(deptId) );

		return data;

	}

	
	public boolean addUserToDepartment(int deptId, int userId){
		
		return departmentDAO.addUserToDepartment(deptId, userId);
	}




}
