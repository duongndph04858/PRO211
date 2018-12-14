package bll.repository;

import org.hibernate.Session;

import data.Category;

public interface CategoryRepository {
	public Category getbyID(String id,Session session);
}
