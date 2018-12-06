package bll.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.impl.BaseRepositoryImpl;
import data.User;

@Component
public class UserDAO extends BaseRepositoryImpl {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public User getUserByUsername(String username) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from User where username=:username";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			User user = (User) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return new User();
		}
	}

}
