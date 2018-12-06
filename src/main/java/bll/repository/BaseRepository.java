package bll.repository;

import java.util.List;

import org.hibernate.Session;

import data.Manageable;
import data.Management;
import data.TransactionLog;

public interface BaseRepository {
	public void insert(Management object, Session session) throws Exception ;

	public void update(Management object, Session session) throws Exception ;

	public void delete(Manageable<?> object, Session session) throws Exception ;

	public List<Manageable<?>> getAll(String table, Session session) throws Exception;

	public List<Manageable<?>> getAllActive(String table, Session currentSession) throws Exception;
	
	public void insertTransactionLog(TransactionLog tran,Session session);
}
