package bll.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.CategoryRepository;
import data.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@Override
	public Category getbyID(String id, Session session) {
		String hql = "from Category where id=:id and status=1";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Category c = (Category) query.uniqueResult();
		return c;
	}

}
