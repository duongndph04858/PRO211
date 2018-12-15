package bll.repository.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import bll.repository.BaseRepository;
import data.Manageable;
import data.Management;
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
		String hql = "from " + table;
		Query query = session.createQuery(hql);
		List<Manageable<?>> lst = query.list();
		if (lst != null) {
			return lst;
		}
		return new ArrayList<Manageable<?>>();
	}

	@SuppressWarnings("unchecked")
	public List<Manageable<?>> getAllActive(String table, Session currentSession) throws Exception {
		String hql = "from " + table + " where status=1";
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
	public Management getByConditions(HashedMap conditions, Class mng, Session session) {
		Management result = null;
		try {
			StringBuilder sb = new StringBuilder("from " + mng.getName() + " where ");
			int i = 0;
			for (Object x : conditions.keySet()) {
				if (i < conditions.size() - 1) {
					sb.append(x + "=:" + x + " and ");
					i++;
				} else {
					sb.append(x + "=:" + x);
				}
			}
			Query query = session.createQuery(sb.toString());
			for (Object x : conditions.keySet()) {
				try {
					long param = Long.parseLong(conditions.get(x).toString());
					query.setLong(x.toString(), param);
				} catch (NumberFormatException e) {
					String param = x.toString();
					String value = conditions.get(x).toString();
					query.setParameter(param, value);
				}
			}
			result = (Management) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Management getById(String id, Class mng, Session session) {
		Management result = null;
		try {
			Class clazz = mng;
//			String[] spl = clazz.getName().split(".");

			StringBuilder sb = new StringBuilder("from " + clazz.getName() + " where ");
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				if (f.isAnnotationPresent(Id.class)) {
					sb.append(f.getName() + "=:" + f.getName());
					Query query = session.createQuery(sb.toString());
					try {
						int x = Integer.parseInt(id);
						query.setInteger(f.getName(), x);
					} catch (NumberFormatException e) {
						query.setParameter(f.getName(), id);
					}
					result = (Management) query.uniqueResult();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
