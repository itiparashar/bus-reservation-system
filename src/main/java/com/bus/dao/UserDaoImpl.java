package com.bus.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bus.model.Bus;
import com.bus.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	//dependency : javax.persistence.EntityManager : i/f : equivalent to org.hibernate.Session
	@PersistenceContext //JPA anno.
	private EntityManager entityManager;
			
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			String jpql="select u from User u where u.email='"+email+"'";
			return entityManager.createQuery(jpql, User.class).getSingleResult();
		}catch(Exception e) {
			System.out.println("Error findByEmail = "+e.getMessage());
			return null;
		}
	}
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		try {
			return entityManager.find(User.class, id);
		}catch(Exception e) {
			System.out.println("Error findById = "+e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public User addUserDtl(User user) {
		// TODO Auto-generated method stub
		try {
			entityManager.persist(user);
			
	//		Session session=this.sessionFactory.getCurrentSession();
	//		session.save(bus);
		}catch(Exception e) {
			System.out.println("Error while Saving the User Detail = "+e.getMessage());
			return null;
		}
		return user;
	}
	@Override
	@Transactional
	public int changePasswordDtl(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		int executeUpdateFlag=0;
		try {
		  String queryupdate = "UPDATE User SET password=?1 WHERE userId=?2 "; 
		    executeUpdateFlag= entityManager.createQuery(queryupdate).setParameter(1, newPassword).setParameter(2, userId ).executeUpdate();
		}catch(Exception e) {
			System.out.println("Error while Changing Password = "+e.getMessage());
			return 0;
		}
		return executeUpdateFlag;
	}

}
