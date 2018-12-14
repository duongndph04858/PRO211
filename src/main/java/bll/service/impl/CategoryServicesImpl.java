package bll.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bll.repository.CategoryRepository;
import bll.service.CategoryServices;
import data.Category;

@Service
public class CategoryServicesImpl implements CategoryServices {
	@Autowired
	SessionFactory ssfac;

	@Autowired
	CategoryRepository catDao;

	@Override
	@Transactional(readOnly = true)
	public Category getById(String id) {
		try {
			Session session = ssfac.getCurrentSession();
			return catDao.getbyID(id, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
