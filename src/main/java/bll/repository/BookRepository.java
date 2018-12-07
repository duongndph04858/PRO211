package bll.repository;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Session;

import data.Book;
import data.Manageable;

public interface BookRepository {
	public Manageable<Book> getById(String id, Session session);

	public Manageable<Book> getByInfo(HashedMap<String, String> conditions, Session session);
}
