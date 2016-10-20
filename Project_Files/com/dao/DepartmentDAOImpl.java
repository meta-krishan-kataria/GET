/**
 * 
 */
package com.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;







import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.model.Department;
import com.model.Issue;
import com.model.IssueStatus;
import com.model.UserDetails;

/**
 *
 *
 */

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	
	
	/**
	 * a utility method to get user id of the dept-head
	 * 
	 * */
	@Override
	public int getUserIdOfDepartmentHead(int deptId){
		Session session=null;
		UserDetails departmentHead = null;
		
		try 
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("FROM UserDetails WHERE department.id= :deptId AND role='dept-head'");
			query.setInteger("deptId", deptId);
			departmentHead = (UserDetails) query.list().get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		System.out.println(" "+departmentHead.getName());
		
		return departmentHead.getId();
		
	}
	
	
	
	@Override
	public List<Issue> getAllIssues(int deptId) 
	{
		List<Issue> issueList = null;
		Session session=null;
		try 
		{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Issue where department.id= :deptId") ;
			query.setInteger("deptId", deptId);
			issueList=query.list();
			//
			for(Issue i : issueList){
				System.out.println("Person List::"+  i.getId()+ i.getTitle() );
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return issueList;
	}

	
	
	@Override
	public List<Issue> getNewIssues(int deptId) 
	{
		List<Issue> issueList = null;
		Session session=null;
		
		try 
		{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Issue where department.id= :deptId AND currentStatus='received'") ;
			query.setInteger("deptId", deptId);
			issueList=query.list();
			//
			for(Issue i : issueList){
				System.out.println("Person List::"+  i.getId()+ i.getTitle() );
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return issueList;
	}
	
	
	
	
	@Override
	public List<Issue> getPendingIssues(int deptId) 
	{
		List<Issue> issueList = null;
		Session session=null;
		
		try 
		{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Issue where department.id= :deptId AND currentStatus='assigned'") ;
			query.setInteger("deptId", deptId);
			issueList=query.list();
			//
			for(Issue i : issueList){
				System.out.println("Person List::"+  i.getId()+ i.getTitle() );
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return issueList;
	}

	
	@Override
	public Issue getIssueById(int id) {
		Session session = sessionFactory.openSession();
		
		Query q= session.createQuery("from Issue where id= :id");
		q.setInteger("id", id);
		Issue issue=(Issue) q.uniqueResult();		
		session.close();
		
		System.out.println( issue.getTitle()  );
		return issue;
	}	
	
	
	
	/**
	 * Updates status of the issue
	 * dept-head and change status to 'approve','conflict'
	 * */
	@Override
	public boolean updateStatusOfIssue(int issueId, int deptId, String status) 
	{
		boolean result=false;
		Session session=null;
		
		try {
			session=sessionFactory.openSession();
			Transaction t=session.beginTransaction();
			
			//updating currentStatus in Issue 
			Query query=session.createQuery("UPDATE Issue SET currentStatus= :status WHERE id= :issueId");
			query.setInteger("issueId", issueId);
			query.setString("status", status);
			query.executeUpdate();
			t.commit();
			session.close();
			System.out.println("Status updated");
			
			//updating in IssueStatus for log
			long time = System.currentTimeMillis();	//current time
			IssueStatus statusLog=new IssueStatus(issueId, status, new Timestamp(time), getUserIdOfDepartmentHead(deptId));
			result=storeStatusLog(statusLog);
			System.out.println("logged done");
			
		} catch (HibernateException e) {
			e.printStackTrace();	
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		

		return result;
	}

	
	
	/*public boolean simpleUpdate(){
		Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();                

        Query query = session.createQuery("UPDATE Issue SET currentStatus='conflict' WHERE id= 12" );

        query.executeUpdate(); //add this line
        tx.commit();
        session.close();
        
        return true;
	}*/
	
	
	public boolean storeStatusLog(IssueStatus statusLog){
		boolean result=false;
		Session session=null;
		
		try {
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(statusLog);
			transaction.commit();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		System.out.println("status logged");	
		return true;
	}
	
	

	@Override
	public List<UserDetails> getAllResolvers(int deptId) 
	{
		List<UserDetails> resolversList = null;
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Query query=session.createQuery("FROM UserDetails  WHERE department.id= :deptId AND role='resolver'") ;
			query.setInteger("deptId", deptId);
			resolversList=query.list();
			for(UserDetails user : resolversList){
				System.out.println("Resolvers List::"+  user.getName() );
			}
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}finally{
			session.close();
		}
		return resolversList;
		
	}

	
	/*not needed*/
	
	/*@Override
	public List<UserDetails> getAllAvailabeResolvers(int deptId, int issueId) {
		List<UserDetails> resolversList = null;
		try {
			Session session=sessionFactory.openSession();
			//  to be verified
			Query query=session.createQuery("FROM UserDetails  WHERE department.id= :deptId AND role='resolver' "
					+ "AND id NOT IN (SELECT Issue.resolvers.id FROM Issue WHERE id= :issueId)") ;
			query.setInteger("deptId", deptId);
			query.setInteger("issueId", issueId);
			
			resolversList=query.list();
			for(UserDetails user : resolversList){
				System.out.println("Resolvers List::"+  user );
			}
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return resolversList;
	}*/

	
	
	@Override
	/*
	 * loads the Issue object, add new resolver to resolvers list and updates the Issue
	 * */
	public boolean assignIssueToResolver(int issueId, int resolverId, int deptId) {
		
		Session session=null;
		try 
		{
			session=sessionFactory.openSession();
			
			//loading Issue
			Transaction transaction = session.beginTransaction();
			Issue issue = (Issue) session.load( Issue.class, new Integer( issueId ));
			System.out.println("Issue object loaded. " + issue.getTitle());
			transaction.commit();

			//loading resolver (UserDetails object) 
			UserDetails resolver = getResolver(resolverId);
			
			// adding resolver to  resolvers list
			List<UserDetails> resolversList=issue.getResolvers();
			if( resolversList == null ){
				resolversList=new ArrayList<UserDetails>();
			}
			resolversList.add(resolver);
			
			//updating Issue
			Transaction transaction2 = session.beginTransaction();
			session.update( issue );
			transaction2.commit();
			
			System.out.println("Issue object updated");

			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

	
	@Override
	public UserDetails getResolver(int resolverId)
	{
		
		Session session=null;
		UserDetails resolver=null;
		try 
		{
			session=sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			resolver = (UserDetails) session.load( UserDetails.class, new Integer( resolverId ));
			System.out.println("Resolver object loaded. " + resolver.getName() );
			transaction.commit();
		
			
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}finally{
			session.close();
		}
		
		return resolver;
	}
		

	
	@Override
	public boolean setTargetResolutionDateForIssue(
			Timestamp targetResolutionDate, int issueId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCommentToIssue(int issueId, int deptHeadId, String comment) {
		// TODO Auto-generated method stub
		return false;
	}

}
