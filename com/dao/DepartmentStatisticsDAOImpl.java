/**
 * 
 */
package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





import com.model.Department;



/**
 * @author Krishan Kataria
 *
 */

@Repository
public class DepartmentStatisticsDAOImpl implements DepartmentStatisticsDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Long getCountOfIssuesByStatus(int deptId, String status) {

		Session session=null;
		Long count = null;

		try 
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("SELECT COUNT(*) FROM Issue "
					+ "WHERE department.id= :deptId AND currentStatus= :status ");

			query.setInteger("deptId", deptId);
			query.setString("status", status.trim() );
			count =   (Long) query.uniqueResult() ;

			System.out.println( count );

		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return count;
	}


	@Override
	public Long getCountOfIssues(int deptId) {
		Session session=null;
		Long count = null;

		try 
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("SELECT COUNT(*) FROM Issue "
					+ "WHERE department.id= :deptId");

			query.setInteger("deptId", deptId);
			count =   (Long) query.uniqueResult() ;

			System.out.println( count );

		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}

		return count;
	}





}
