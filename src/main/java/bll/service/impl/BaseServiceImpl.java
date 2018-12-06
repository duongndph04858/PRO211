package bll.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.BaseRepository;
import bll.service.BaseServices;
import data.Manageable;

@Service
public class BaseServiceImpl implements BaseServices {

	public static final Logger LOG = Logger.getLogger(BaseServiceImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	BaseRepository baseDao;

	@Transactional
	public boolean insert(Manageable<?> mng) {
		try {
			baseDao.insert(mng, sessionFactory.getCurrentSession());
			return true;
		} catch (Exception e) {
			LOG.error("Fail to insert " + mng);
			return false;
		}
	}

	@Transactional
	public boolean update(Manageable<?> mng) {
		try {
			baseDao.update(mng, sessionFactory.getCurrentSession());
			return true;
		} catch (Exception e) {
			LOG.error("Fail to update " + mng);
			return false;
		}

	}

	@Transactional
	public boolean delete(Manageable<?> mng) {
		try {
			baseDao.delete(mng, sessionFactory.getCurrentSession());
			return true;
		} catch (Exception e) {
			LOG.error("Fail to delete " + mng);
			return false;
		}

	}

	@Transactional(readOnly = true)
	public List<Manageable<?>> getAll(String table) {
		try {
			List<Manageable<?>> lst = baseDao.getAll(table, sessionFactory.getCurrentSession());
			return lst;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Manageable<?>> getAllActive(String table) {
		try {
			List<Manageable<?>> lst = baseDao.getAllActive(table, sessionFactory.getCurrentSession());
			return lst;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return null;
		}
	}

}
