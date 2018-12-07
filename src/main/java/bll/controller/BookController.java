package bll.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import bll.service.BaseServices;
import data.Book;
import data.Category;
import data.Manageable;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class BookController {

	@SuppressWarnings("rawtypes")
	@Autowired
	BaseServices baseServices;

	@RequestMapping("dashboard/management/book")
	public String getAll(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Book>> books = baseServices.getAll("Book");
			if (books != null) {
				mm.addAttribute("books", books);
			} else {
				mm.addAttribute("books", "Thư viện hiện đang không có sách");
			}
			return "dashboard/book";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return url;
	}

	@RequestMapping("dashboard/book/insert-book")
	public String insertInput(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Category>> categories = baseServices.getAll(Category.class.getName());
			mm.addAttribute("categories", categories);
			url = "dashboard/insert-book";
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
		}
		return url;
	}

	@RequestMapping("dashboard/book/insert")
	public String insert(HttpServletRequest request, ModelMap mm,@ModelAttribute Manageable<Book> mng) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			if (mng != null) {
				Book book = mng.getObj();
				book.setStatus(1);
				book.setInsertDate(new Date());
				mng.setObj(book);
				String notice = "";
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				if (user != null) {
					mng.setUserDo(user);
					String result = baseServices.insert(mng);
					if (!AppConstrant.ERROR_CODE.equals(result)) {
						url = "redirect:/dashboard/home";
						notice=MessageUtil.getNoticeMsg(mng);
						if (AppConstrant.UPDATE_CODE.equals(result)) {
							notice = "Sách đã tồn tại, cập nhật số lượng thành công";
						}
					}
					mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				} else {
					mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, "Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
					url = "login";
				}
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		}
		return url;
	}

}
