package bll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import bll.repository.BookDAO;
import bll.repository.impl.BaseRepositoryImpl;
import data.Book;
import data.Manageable;
import util.AppConstrant;

@Controller
public class BookController {
	
	@Autowired
	BookDAO bookDAO;
	
	@RequestMapping("dashboard/management/book")
	public String getAll(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Book> books = bookDAO.getAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return url;
	}

	@RequestMapping("dashboard/book/insert-book")
	public String insertInput(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Book book = new Book();
			mm.addAttribute("obj", book);
			url = "dashboard/insert-book";
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		}
		return url;
	}
}
