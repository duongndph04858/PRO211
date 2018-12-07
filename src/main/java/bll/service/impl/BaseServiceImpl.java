package bll.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.BaseRepository;
import bll.repository.BookRepository;
import bll.service.BaseServices;
import data.Book;
import data.Manageable;
import data.TransactionLog;
import util.AppConstrant;
import util.MessageUtil;

@SuppressWarnings("rawtypes")
@Service
public class BaseServiceImpl implements BaseServices {

	public static final Logger LOG = Logger.getLogger(BaseServiceImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	BaseRepository<Manageable<?>> baseDao;

	@Autowired
	BookRepository bookDao;

	@Transactional
	public String insert(Manageable mng) {
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.getCurrentSession();
		try {
			mng.setCommand(AppConstrant.INSERT);
			mng.setMessage(mng.getObj().getName());
			mng.setStatus(AppConstrant.SUCCESS);
			tran.setUser(mng.getUserDo());
			if (mng.getObj() instanceof Book) {
				Book book = (Book) mng.getObj();
				HashedMap<String, String> conditions = new HashedMap<>();
				Field[] fields = Book.class.getDeclaredFields();
				for (Field f : fields) {
					if (!"id".equals(f.getName())) {
						conditions.put(f.getName(), f.get(book).toString());
					}
				}
				Manageable<Book> b = bookDao.getByInfo(conditions, session);
				if (b != null) {
					mng.setCommand(AppConstrant.UPDATE);
					int currentAmount = b.getObj().getAmount();
					b.getObj().setAmount(currentAmount + book.getAmount());
					baseDao.update(b, session);
					return AppConstrant.UPDATE_CODE;
				}
			} else {
				baseDao.insert(mng, session);
			}
			return AppConstrant.SUCCESS_CODE;
		} catch (Exception e) {
			mng.setStatus(AppConstrant.FAIL);
			LOG.error("Fail to insert " + mng);
			return AppConstrant.ERROR_CODE;
		} finally {
			tran.setDescriptions(MessageUtil.getDescription(mng));
			baseDao.insertTransactionLog(tran, session);
		}
	}

	@Transactional
	public String update(Manageable mng) {
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.getCurrentSession();
		try {
			mng.setCommand(AppConstrant.UPDATE);
			mng.setMessage(mng.getObj().getName());
			mng.setStatus(AppConstrant.SUCCESS);
			tran.setUser(mng.getUserDo());
			baseDao.update(mng, session);
			return AppConstrant.SUCCESS_CODE;
		} catch (Exception e) {
			mng.setStatus(AppConstrant.FAIL);
			LOG.error("Fail to update " + mng);
			return AppConstrant.ERROR_CODE;
		} finally {
			tran.setDescriptions(MessageUtil.getDescription(mng));
			baseDao.insertTransactionLog(tran, session);
		}
	}

	@Transactional
	public String delete(Manageable mng) {
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.getCurrentSession();
		try {
			mng.setCommand(AppConstrant.UPDATE);
			mng.setMessage(mng.getObj().getName());
			mng.setStatus(AppConstrant.SUCCESS);
			tran.setUser(mng.getUserDo());
			baseDao.delete(mng, session);
			return AppConstrant.SUCCESS_CODE;
		} catch (Exception e) {
			mng.setStatus(AppConstrant.FAIL);
			LOG.error("Fail to update " + mng);
			return AppConstrant.ERROR_CODE;
		} finally {
			tran.setDescriptions(MessageUtil.getDescription(mng));
			baseDao.insertTransactionLog(tran, session);
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
