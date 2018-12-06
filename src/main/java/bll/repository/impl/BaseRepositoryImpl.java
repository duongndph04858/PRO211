package bll.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.BaseRepository;
import data.Manageable;

@Repository
public class BaseRepositoryImpl implements BaseRepository {

	public void insert(Manageable<?> object, Session session) throws Exception {
		session.save(object.getObj());
	}

	public void update(Manageable<?> object, Session session) throws Exception {
		session.update(object.getObj());
	}

	public void delete(Manageable<?> object, Session session) throws Exception {
		session.delete(object.getObj());
	}

	@SuppressWarnings("unchecked")
	public List<Manageable<?>> getAll(String table, Session session) throws Exception {
		String hql = "from :table";
		Query query = session.createQuery(hql);
		query.setParameter("table", table);
		List<Manageable<?>> lst = query.list();
		if (lst != null) {
			return lst;
		}
		return new ArrayList<Manageable<?>>();
	}

	@SuppressWarnings("unchecked")
	public List<Manageable<?>> getAllActive(String table, Session currentSession) throws Exception {
		String hql = "from :table where status=1";
		Query query = currentSession.createQuery(hql);
		query.setParameter("table", table);
		List<Manageable<?>> lst = query.list();
		if (lst != null) {
			return lst;
		}
		return new ArrayList<Manageable<?>>();
	}
}
