package bll.repository;

import org.hibernate.Session;

import data.User;

public interface UserRepository {
	User getUserByUsername(String username, Session session);
}
