/**
 * 
 */
package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.model.Department;



/**
 * @author admin
 *
 */

@Repository
public class DepartmentStatisticsDAOImpl /*implements DepartmentStatisticsDAO*/ {

	private SessionFactory sessionFactory;
	
	
	
	
	
	
	//@Override
	public int getCountOfNewIssues(int deptId) {
		Session session=null;
		Department department = null;
		
		try 
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("FROM Department WHERE id= :deptId");
			query.setInteger("deptId", deptId);
			department = (Department) query.uniqueResult();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return 0;
	}

	//@Override
	public int getCountOfPendingissues(int deptId) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getCountOfSolvedIssues(int dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getCountOfIssues(int dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	
	
}
