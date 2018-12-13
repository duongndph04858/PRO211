package bll.repository;

import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
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
	
	public P getByConditions(HashedMap<String, String> conditions,Manageable<?> mng,Session session);

}
