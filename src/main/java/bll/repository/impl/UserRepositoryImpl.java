package bll.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.UserRepository;
import data.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserByUsername(String username, Session session) {
		String hql = "from User where username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

}
