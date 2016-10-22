package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.UserDetails;

@Repository
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	private SessionFactory sessionFactory; // To create a session for the
											// database operation

	@Override
	public UserDetails userSignInSignUp(UserDetails userDetails) {
		UserDetails userNewDetails;
		try {
			userNewDetails = getUserById(userDetails.getGoogleId());
			if (userNewDetails == null) {
				saveUser(userDetails);
			} else {
				return (UserDetails) userNewDetails;
			}
		} catch (NullPointerException nPE) {
			nPE.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}

	@Override
	public UserDetails getUserById(String googleId) {
		Session session = sessionFactory.openSession();

		Criteria criteriaQuery = session.createCriteria(UserDetails.class);
		criteriaQuery.add(Restrictions.eq("googleId", googleId));
		UserDetails userDetails = (UserDetails) criteriaQuery.uniqueResult();
		session.close();
		return userDetails;
	}

	@Override
	public void saveUser(UserDetails userDetails) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UserDetails getUserById(int userId) {
		Session session = sessionFactory.openSession();
		Criteria criteriaQuery = session.createCriteria(UserDetails.class);
		criteriaQuery.add(Restrictions.eq("id", userId));
		UserDetails userDetails = (UserDetails) criteriaQuery.uniqueResult();
		session.close();
		return userDetails;
	}
}
