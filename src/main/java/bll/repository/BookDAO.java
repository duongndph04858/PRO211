package bll.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import data.Book;

@Component
public class BookDAO {

	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Book> getAll() {
		Session session = factory.getCurrentSession();
		try {
			String hql = "from Book";
			Query query = session.createQuery(hql);
			List<Book> list = query.list();
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			return new ArrayList<Book>();
		}
		return null;
	}
}
