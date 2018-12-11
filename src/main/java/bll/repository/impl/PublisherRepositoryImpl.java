package bll.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bll.repository.PublisherRepository;
import data.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {
	@Autowired
	SessionFactory ssfac;

	@Override
	@Transactional
	public Publisher getById(String id) {
		Publisher publisher = null;
		try {
			Session session = ssfac.getCurrentSession();
			String hql = "from Publisher where publisher=:publisher and status=1";
			Query query = session.createQuery(hql);
			query.setParameter("publisher", id);
			publisher = (Publisher) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publisher;
	}

}
