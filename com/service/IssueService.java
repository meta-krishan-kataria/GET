
package com.service;

import java.util.List;

import com.model.DepartmentVO;
import com.model.IssueVO;

public interface IssueService {
	
	boolean createIssue(IssueVO issueVO);
	List<DepartmentVO> getDepartments();
	IssueVO getIssueById(int id);
	List<IssueVO> getIssuesByUserId(int userId);
	boolean addIssueStatus(IssueVO issueVO);

}
