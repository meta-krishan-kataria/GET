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

import com.model.Comment;
import com.model.Issue;
import com.model.IssueStatus;

@Repository
public class ResolverDAOImpl implements ResolverDAO {

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
	public List<Issue> getIssueListInProgress(int userId) {
		try {
			Session session = sessionFactory.openSession();
			// Criteria criteria =
			// session.createCriteria(UserDetails.class,"UserDetails");
			/*
			 * criteria.add(Restrictions.eq("id", userId));
			 * criteria.createAlias("UserDetails.assignedIssueList",
			 * "assignedIssueList");
			 * criteria.createAlias("assignedIssueList.currentStatus",
			 * "currentStatus"); criteria.add(Restrictions.eq("currentStatus",
			 * "assigned"));
			 */

			Criteria criteria = session.createCriteria(Issue.class, "issue")
					.createAlias("issue.resolvers", "resolvers")
					.add(Restrictions.eq("issue.currentStatus", "inprogress"))
					.add(Restrictions.eq("resolvers.id", userId));

			List<Issue> issues = (List<Issue>) criteria.list();
			return issues;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Issue> getIssueListAssign(int userId) {
		try {
			Session session = sessionFactory.openSession();
			// Criteria criteria =
			// session.createCriteria(UserDetails.class,"UserDetails");
			/*
			 * criteria.add(Restrictions.eq("id", userId));
			 * criteria.createAlias("UserDetails.assignedIssueList",
			 * "assignedIssueList");
			 * criteria.createAlias("assignedIssueList.currentStatus",
			 * "currentStatus"); criteria.add(Restrictions.eq("currentStatus",
			 * "assigned"));
			 */

			Criteria criteria = session.createCriteria(Issue.class, "issue")
					.createAlias("issue.resolvers", "resolvers")
					.add(Restrictions.eq("issue.currentStatus", "assigned"))
					.add(Restrictions.eq("resolvers.id", userId));

			List<Issue> issues = (List<Issue>) criteria.list();
			return issues;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Issue getIssueDetailbyId(int id) {
		try {
			Session session = sessionFactory.openSession();
			Criteria criteriaQuery = session.createCriteria(Issue.class);
			criteriaQuery.add(Restrictions.eq("id", id));
			return (Issue) criteriaQuery.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentOnIssue(int id) {
		try {
			System.out.println("inside dao");
			Session session = sessionFactory.openSession();
			Criteria criteriaQuery = session.createCriteria(Comment.class);
			criteriaQuery.add(Restrictions.eq("issue.id", id));
			criteriaQuery.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Comment> commentList = (List<Comment>) criteriaQuery.list();
			return commentList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteCommentOnIssue(int id) {
		try {
			Session session = sessionFactory.openSession();
			String hql = "delete from Comment where id= :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCommentOnIssue(Comment comment) {
		try {
			Session session = sessionFactory.openSession();

			session.beginTransaction();
			session.save(comment);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatusOfIssue(int issueId, int userId, String status) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			// updating currentStatus in Issue
			Query query = session
					.createQuery("UPDATE Issue SET currentStatus= :status WHERE id= :issueId");
			query.setInteger("issueId", issueId);
			query.setString("status", status);
			query.executeUpdate();
			t.commit();
			session.close();
			System.out.println("Status updated");

			// updating in IssueStatus for log
			long time = System.currentTimeMillis(); // current time
			IssueStatus statusLog = new IssueStatus(issueId, status,
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
