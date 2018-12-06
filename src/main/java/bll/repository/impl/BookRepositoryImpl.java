package bll.repository.impl;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.Session;

import bll.repository.BookRepository;
import data.Book;

public class BookRepositoryImpl implements BookRepository {

	public Book getById(String id, Session session) {

		return null;
	}

	public Book getByInfo(HashedMap<String, String> conditions, Session session) {
		Book book = null;
		try {
			StringBuilder sb = new StringBuilder("from Book where ");
			int i = 0;
			for (String x : conditions.keySet()) {
				if (i < conditions.size()) {
					sb.append(x + "=" + conditions.get(x) + " and ");
					i++;
				} else {
					sb.append(x + "=" + conditions.get(x));
				}
			}
			Query query = session.createQuery(sb.toString());
			book = (Book) query.uniqueResult();
			if (book != null) {
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
