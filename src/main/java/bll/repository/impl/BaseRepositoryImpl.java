package bll.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.BaseRepository;
import data.Manageable;
import data.TransactionLog;

@SuppressWarnings("rawtypes")
@Repository
public class BaseRepositoryImpl implements BaseRepository {

	@Override
	public void insert(Manageable object, Session session) throws Exception {
		session.save(object.getObj());

	}

	@Override
	public void delete(Manageable object, Session session) throws Exception {
		session.delete(object.getObj());

	}

	@Override
	public void update(Manageable object, Session session) throws Exception {
		session.update(object.getObj());
	}

	@SuppressWarnings("unchecked")
	public List<Manageable<?>> getAll(String table, Session session) throws Exception {
		String hql = "from "+table;
		Query query = session.createQuery(hql);
		List<Manageable<?>> lst = query.list();
		if (lst != null) {
			return lst;
		}
		return new ArrayList<Manageable<?>>();
	}

	@SuppressWarnings("unchecked")
	public List<Manageable<?>> getAllActive(String table, Session currentSession) throws Exception {
		String hql = "from "+table+" where status=1";
		Query query = currentSession.createQuery(hql);
		List<Manageable<?>> lst = query.list();
		if (lst != null) {
			return lst;
		}
		return new ArrayList<Manageable<?>>();
	}

	public void insertTransactionLog(TransactionLog tran, Session session) {
		try {
			session.save(tran);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Manageable getByConditions(HashedMap conditions, Manageable mng, Session session) {
		Manageable<?> result = null;
		try {
			StringBuilder sb = new StringBuilder("from " + mng.getObj().getClass().getName() + " where ");
			int i = 0;
			for (Object x : conditions.keySet()) {
				if (i < conditions.size()) {
					sb.append(x + "=" + conditions.get(x) + " and ");
					i++;
				} else {
					sb.append(x + "=" + conditions.get(x));
				}
			}
			Query query = session.createQuery(sb.toString());
			result = (Manageable<?>) query.uniqueResult();
			if (result != null) {
				return result;
			} else {
				return mng;
			}
		} catch (Exception e) {
			return null;
		}
	}


}
