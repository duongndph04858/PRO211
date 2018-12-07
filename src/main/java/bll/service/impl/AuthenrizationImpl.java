package bll.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.UserRepository;
import bll.service.AuthenrizationServices;
import data.User;

@Service
public class AuthenrizationImpl implements AuthenrizationServices {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserRepository userDao;

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		try {
			return userDao.getUserByUsername(username, sessionFactory.getCurrentSession());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
