package bll.repository;

import java.util.List;

import org.hibernate.Session;

import data.Manageable;

public interface BaseRepository {
	public void insert(Manageable<?> object, Session session) throws Exception ;

	public void update(Manageable<?> object, Session session) throws Exception ;

	public void delete(Manageable<?> object, Session session) throws Exception ;

	public List<Manageable<?>> getAll(String table, Session session) throws Exception;

	public List<Manageable<?>> getAllActive(String table, Session currentSession) throws Exception;
}
