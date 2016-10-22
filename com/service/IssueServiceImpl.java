package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.dao.IssueDAO;
import com.model.Department;
import com.model.DepartmentVO;
import com.model.Issue;
import com.model.IssueStatus;
import com.model.IssueVO;
import com.util.ModelAdapter;

@Component
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueDAO issueDAO;

	@Autowired
	ModelAdapter modelAdapter;

	@Autowired
	private ApplicationContext context;

	@Override
	@Transactional
	public boolean createIssue(IssueVO issueVO) {
		Date date = context.getBean(Date.class);
		issueVO.setCreatedOn(new Timestamp(date.getTime()).toString());
		issueVO.setCurrentStatus("received");
		Issue issue = modelAdapter.convert(issueVO);
		System.out.println(issueVO);
		issueDAO.createIssue(issue);
		return false;
	}

	@Override
	@Transactional
	public List<DepartmentVO> getDepartments() {
		List<Department> departmentList = issueDAO.getDepartments();
		List<DepartmentVO> departmentVOList = new ArrayList<DepartmentVO>();
		for (Department department : departmentList) {
			departmentVOList.add(modelAdapter.convert(department));
		}
		return departmentVOList;
	}

	@Override
	@Transactional
	public IssueVO getIssueById(int id) {
		return modelAdapter.convert(issueDAO.getIssueById(id));
	}

	@Override
	public List<IssueVO> getIssuesByUserId(int userId) {
		List<Issue> issues = issueDAO.getIssuesByUserId(userId);
		List<IssueVO> issueVOList = new ArrayList<IssueVO>();
		for (Issue issue : issues) {
			issueVOList.add(modelAdapter.convert(issue));
		}
		return issueVOList;
	}

	@Override
	public boolean addIssueStatus(IssueVO issueVO) {
		IssueStatus issueStatus = context.getBean(IssueStatus.class);
		
	//	issueStatus.setId(issueVO.get);
		return false;
	}
}
