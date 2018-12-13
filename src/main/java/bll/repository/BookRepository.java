package bll.repository;

import org.hibernate.Session;

import data.Book;
import data.BookCategory;
import data.Manageable;

public interface BookRepository {
	public Manageable<Book> getById(String id, Session session);

	public BookCategory getCategoryById(String id,Session session);
}
