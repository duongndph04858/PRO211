package bll.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.BookRepository;
import data.Book;
import data.BookCategory;
import data.Manageable;

@Repository
public class BookRepositoryImpl implements BookRepository {

	public Manageable<Book> getById(String id, Session session) {

		return null;
	}

	@Override
	public BookCategory getCategoryById(String id, Session session) {
		try {
			String hql = "from BookCategory b where b.category.id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			BookCategory result = (BookCategory) query.uniqueResult();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}