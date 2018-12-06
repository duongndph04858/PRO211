package bll.service;

import java.util.List;

import data.Manageable;

public interface BaseServices {

	public String insert(Manageable<?> mng);

	public boolean update(Manageable<?> mng);

	public boolean delete(Manageable<?> mng);
	
	public List<Manageable<?>> getAll(String table);
}
