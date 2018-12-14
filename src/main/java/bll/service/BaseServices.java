package bll.service;

import java.util.List;

import data.Manageable;
import data.Management;
import data.User;

public interface BaseServices<Q extends Manageable<?>> {

	public String insert(Q mng);

	public String update(Q mng);

	public String delete(Q mng);

	public List<Q> getAll(String table);

	public List<Q> getAllActive(String table);

	public String insertBatch(User user, String filename);

	public Management getById(String id, Class mng);
}
