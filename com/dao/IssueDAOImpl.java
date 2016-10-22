package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.Issue;
import com.model.IssueStatus;
import com.model.IssueVO;
import com.model.UserDetails;

@Repository
public class IssueDAOImpl implements IssueDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createIssue(Issue issue) {
		Session session = sessionFactory.openSession();
		session.save(issue);
		session.close();
		System.out.println("Start");
		addIssueStatus(issue);
		return true;
	}

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.openSession();
		Criteria criteriaQuery = session.createCriteria(Department.class);
		List<Department> list = criteriaQuery.list();
		return list;
	}

	@Override
	public Issue getIssueById(int id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Issue.class);
		criteria.add(Restrictions.eq("id", id));
		Issue issue = (Issue) criteria.uniqueResult();
		session.close();
		return issue;
	}

	@Override
	public List<Issue> getIssuesByUserId(int userId) {
		Session session = sessionFactory.openSession();
		Criteria criteriaQuery = session.createCriteria(Issue.class);
		criteriaQuery
				.add(Restrictions.eq("createdBy", new UserDetails(userId)));
		return criteriaQuery.list();
	}

	@Override
	public boolean addIssueStatus(Issue issue) {
		Session session = sessionFactory.openSession();
		System.out.println("dadad");
		IssueStatus issueStatus = new IssueStatus();
		issueStatus.setId(issue.getId());
		issueStatus.setStatus("received");
		issueStatus.setUpdatedBy(issue.getCreatedBy().getId());
		issueStatus.setUpdatedOn(issue.getCreatedOn());
		session.save(issueStatus);
		System.out.println("end");
		return true;
	}
}
