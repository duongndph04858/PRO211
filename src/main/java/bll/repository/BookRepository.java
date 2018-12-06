package bll.repository;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Session;

import data.Book;

public interface BookRepository {
	public Book getById(String id,Session session);
	public Book getByInfo(HashedMap<String, String> conditions, Session session);
}
