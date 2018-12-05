package bll.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import data.Manageable;
import data.TransactionLog;

@Component
public class BaseService {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void insertLog(TransactionLog tran) {
		insert(tran);
	}

	@Transactional
	public boolean insert(Object object) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Object object) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Object object) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Manageable> getAll(String table) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from :table";
			Query query = session.createQuery(hql);
			query.setParameter("table", table);
			List<Manageable> list = query.list();
			if (list == null) {
				list = new ArrayList<Manageable>();
			}
			return list;
		} catch (Exception e) {
			return new ArrayList<Manageable>();
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Object> getByCondition(String table, String condition, String value) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from :table where :condition = :value";
			Query query = session.createQuery(hql);
			query.setParameter("table", table);
			query.setParameter("condition", condition);
			query.setParameter("value", value);
			List<Object> list = query.list();
			if (list == null) {
				list = new ArrayList<Object>();
			}
			return list;
		} catch (Exception e) {
			return new ArrayList<Object>();
		}
	}
}
