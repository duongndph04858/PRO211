package bll.repository;

import java.util.List;

import org.hibernate.Session;

import data.Manageable;
import data.TransactionLog;

public interface BaseRepository<P extends Manageable<?>> {
	public void insert(P object, Session session) throws Exception ;

	public void update(P object, Session session) throws Exception ;

	public void delete(P object, Session session) throws Exception ;

	public List<P> getAll(String table, Session session) throws Exception;

	public List<P> getAllActive(String table, Session currentSession) throws Exception;
	
	public void insertTransactionLog(TransactionLog tran,Session session);
	
}
