package bll.service.impl;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.BaseRepository;
import bll.repository.BookRepository;
import bll.repository.PublisherRepository;
import bll.service.BaseServices;
import data.Book;
import data.Manageable;
import data.Publisher;
import data.TransactionLog;
import data.User;
import util.AppConstrant;
import util.DateTimeUtil;
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

	@Autowired
	PublisherRepository publisherDao;

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

	public String insertBatch(User user, String excelFilename) {
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.openSession();
		String msg = "";
		tran.setUser(user);
		try {
			Transaction tx = session.beginTransaction();
			FileInputStream fis = new FileInputStream(excelFilename);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			for (int i = 0; i < workbook.getActiveSheetIndex(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				for (int j = 1; j < sheet.getLastRowNum(); j++) {
					Row row = sheet.getRow(j);
					Book book = new Book();
					book.setName(row.getCell(1).getStringCellValue());
					book.setAuthor(row.getCell(2).getStringCellValue());
					String publisher = row.getCell(3).getStringCellValue();
					Publisher pb = publisherDao.getById(publisher);
					if (pb == null) {
						pb = new Publisher();
						pb.setPublisher(publisher);
						pb.setStatus(1);
						pb.setDescriptions("Auto insert when insert by excel");
					}
					book.setPublisher(pb);
					book.setPrice(Long.valueOf(row.getCell(4).getStringCellValue()));
					book.setBookshelf(row.getCell(5).getStringCellValue());
					book.setAmount(Integer.parseInt(row.getCell(6).getStringCellValue()));
					book.setImages(row.getCell(7).getStringCellValue());
					Date dateInsert = DateTimeUtil.parse(row.getCell(8).getStringCellValue());
					book.setInsertDate(dateInsert);
					String provider = row.getCell(9).getStringCellValue();
					if (provider.isEmpty()) {
						provider = "Old library system";
					}
					book.setProvider(provider);
					session.save(book);
					if (j % 50 == 0) {
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			workbook.close();
			msg = "Thêm thành công từ file excel: " + excelFilename;
			return AppConstrant.SUCCESS_CODE;
		} catch (Exception e) {
			msg = "Thêm thất bại từ file excel: " + excelFilename;
			return AppConstrant.ERROR_CODE;
		} finally {
			tran.setDescriptions(msg);
			baseDao.insertTransactionLog(tran, session);
			session.close();
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
