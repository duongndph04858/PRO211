package bll.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import data.TransactionLog;

public class LogTransaction {

	@Autowired
	static SessionFactory ssfac;

	public static void log(TransactionLog tran) {
		try {
			Session session = ssfac.getCurrentSession();
			session.save(tran);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
