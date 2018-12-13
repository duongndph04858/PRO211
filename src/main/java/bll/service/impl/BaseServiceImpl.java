package bll.service.impl;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
import core.entity.Conditions;
import data.Book;
import data.BookCategory;
import data.Category;
import data.Manageable;
import data.Publisher;
import data.TransactionLog;
import data.User;
import util.AppConstrant;
import util.DateTimeUtil;
import util.MessageUtil;
import util.StringUtil;

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
		String resultCode = null;
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.getCurrentSession();
		try {
			mng.setCommand(AppConstrant.INSERT);
			mng.setMessage(mng.getObj().getName());
			mng.setStatus(AppConstrant.SUCCESS);
			tran.setUser(mng.getUserDo());
			if (mng.getObj() != null) {
				HashedMap<String, String> conditions = new HashedMap<>();
				Field[] fields = Book.class.getDeclaredFields();
				for (Field f : fields) {
					f.setAccessible(true);
					if (f.isAnnotationPresent(Conditions.class)) {
						conditions.put(f.getName(), f.get(mng.getObj()).toString());
					}
				}
				Manageable<?> b = baseDao.getByConditions(conditions, mng, session);
				if (b != null) {
					if (b.getObj() instanceof Book) {
						Book book = (Book) b.getObj();
						mng.setCommand(AppConstrant.UPDATE);
						int currentAmount = book.getAmount();
						book.setAmount(currentAmount + book.getAmount());
						baseDao.update(b, session);
						resultCode = AppConstrant.UPDATE_CODE;
					} else {
						mng.setStatus(AppConstrant.FAIL);
						mng.setCause(AppConstrant.ISEXIST);
						resultCode = AppConstrant.ISEXIST_CODE;
					}
				} else {
					baseDao.insert(mng, session);
					resultCode = AppConstrant.SUCCESS_CODE;
				}
			}
		} catch (Exception e) {
			mng.setStatus(AppConstrant.FAIL);
			LOG.error("Fail to insert " + mng);
			resultCode = AppConstrant.ERROR_CODE;
		} finally {
			tran.setStatus(Integer.parseInt(resultCode));
			tran.setDescriptions(MessageUtil.getDescription(mng));
			baseDao.insertTransactionLog(tran, session);
		}
		return resultCode;
	}

	public String insertBatch(User user, String excelFilename) {
		TransactionLog tran = new TransactionLog();
		Session session = sessionFactory.openSession();
		String msg = "";
		tran.setUser(user);
		int total=0;
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

					List<BookCategory> bookCategory = new ArrayList<>();
					String[] categories = row.getCell(11).getStringCellValue().split(",");
					if (categories.length > 0) {
						for (int x = 0; x < categories.length; x++) {
							String categoryCode = StringUtil.getCode(categories[x]);
							BookCategory category = bookDao.getCategoryById(categoryCode, session);
							if (category == null) {
								Manageable<Category> m1 = new Manageable<>();
								Category c = new Category();
								c.setId(categoryCode);
								c.setName(categories[x]);
								c.setDescriptions("auto insert by excel");
								c.setStatus(1);
								m1.setObj(c);
								BookCategory bc = new BookCategory();
								bc.setBook(book);
								bc.setCategory(c);
								bc.setStatus(1);
								bc.setDescriptions("auto insert by excel");
								baseDao.insert(m1, session);
							}
							bookCategory.add(category);
						}
					}
					book.setCategory(bookCategory);
					session.save(book);
					total++;
					if (j % 50 == 0) {
						session.flush();
						session.clear();
					}
				}
			}
			tx.commit();
			workbook.close();
			msg = "Thêm thành công "+total+" sách từ file excel: " + excelFilename;
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
