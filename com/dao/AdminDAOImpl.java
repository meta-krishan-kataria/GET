package com.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Department;
import com.model.Issue;
import com.model.IssueStatus;
import com.model.UserDetails;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartment() {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Department.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Department> departmentList = (List<Department>) criteria
					.list();
			return departmentList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserDetails getDepartmentHead(int deptId) {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session
					.createCriteria(UserDetails.class, "userDetails")
					.createAlias("userDetails.department", "department")
					.add(Restrictions.eq("userDetails.role", "dept-head"))
					.add(Restrictions.eq("department.id", deptId));
			UserDetails userDetails = (UserDetails) criteria.uniqueResult();
			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void addDepartment(Department department) {
		try {
			Session session = sessionFactory.openSession();

			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> getResolverOrGeneralUsersList() {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UserDetails.class,
					"userDetails").add(
					Restrictions.eq("userDetails", "resolver"));
			List<UserDetails> userDetails = (List<UserDetails>) criteria.list();
			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addDeptHead(UserDetails userDetails) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query query = session
					.createQuery("UPDATE UserDetails SET role=:role WHERE id=:deptHeadId");
			query.setString("role", "dept-head");
			query.setInteger("deptHeadId", userDetails.getId());
			query.executeUpdate();
			transaction.commit();
			session.close();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE UserDetails u set  u.department.id = :deptId "
					+ "where u.id = :deptHeadId)";

			Query query1 = session.createQuery(hql);
			query1.setInteger("deptId", userDetails.getDepartment().getId());
			query1.setInteger("deptHeadId", userDetails.getId());
			query1.executeUpdate();
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Issue> getConflictIssueList() {
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Issue.class, "issue")
					.createAlias("issue.resolvers", "resolvers")
					.add(Restrictions.eq("issue.currentStatus", "conflict"));

			List<Issue> issues = (List<Issue>) criteria.list();
			return issues;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void closedIssue(int issueId, int userId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			// updating currentStatus in Issue
			Query query = session
					.createQuery("UPDATE Issue SET currentStatus= :status WHERE id= :issueId");
			query.setInteger("issueId", issueId);
			query.setString("status", "closed");
			query.executeUpdate();
			t.commit();
			session.close();
			System.out.println("Status updated");

			// updating in IssueStatus for log
			long time = System.currentTimeMillis(); // current time
			IssueStatus statusLog = new IssueStatus(issueId, "closed",
					new Timestamp(time), userId);
			storeStatusLog(statusLog);
			System.out.println("logged done");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean storeStatusLog(IssueStatus statusLog) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(statusLog);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("status logged");
		return true;
	}
}
