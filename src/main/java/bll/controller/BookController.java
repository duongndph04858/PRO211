package bll.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bll.service.BaseServices;
import bll.service.CategoryServices;
import data.Book;
import data.BookCategory;
import data.BookShelf;
import data.Category;
import data.Manageable;
import data.Publisher;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class BookController {
	@Autowired
	ServletContext context;

	@SuppressWarnings("rawtypes")
	@Autowired
	BaseServices baseServices;

	@Autowired
	CategoryServices ctgServices;

	@RequestMapping("dashboard/management/book")
	public String getAll(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Book>> books = baseServices.getAll(Book.class.getName());
			mm.addAttribute("books", books);
			return "dashboard/book-management";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/book/insert-book")
	public String insertInput(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Book book = new Book();
			List<Manageable<Category>> categories = baseServices.getAllActive(Category.class.getName());
			List<Manageable<BookShelf>> shelves = baseServices.getAllActive(BookShelf.class.getName());
			mm.addAttribute("categories", categories);
			mm.addAttribute("shelves", shelves);
			mm.addAttribute("book", book);
			url = "dashboard/insert-book";
		} catch (Exception e) {
			e.printStackTrace();
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
		}
		return url;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("dashboard/book/insert")
	public String insert(HttpServletRequest request, ModelMap mm, @RequestParam String name,
			@RequestParam String author, @RequestParam long price, @RequestParam String publisher,
			@RequestParam String bookshelf, @RequestParam int amount, @RequestParam String provider,
			@RequestParam String descriptions, @RequestParam String[] ctg, @RequestParam MultipartFile image,
			RedirectAttributes redirectAttributes) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				Manageable<Book> mng = new Manageable<>();
				Book book = new Book();
				if (!image.isEmpty()) {
					String imgPath = context.getRealPath("/resources/images/" + image.getOriginalFilename());
					image.transferTo(new File(imgPath));
					book.setImages(image.getOriginalFilename());
				}
				book.setName(name);
				book.setAuthor(author);
				book.setPrice(price);
				Publisher pl = (Publisher) baseServices.getById(publisher, Publisher.class);
				if (pl == null) {
					Manageable<Publisher> m = new Manageable<>();
					m.setUserDo(user);
					pl = new Publisher();
					pl.setId(publisher);
					pl.setName(publisher);
					pl.setStatus(1);
					m.setObj(pl);
					String check = baseServices.insert(m);
					if (AppConstrant.ERROR_CODE.equals(check)) {
						notice = "Lỗi khi tự động thêm nhà xuất bản";
					}
				}
				book.setPublisher(pl);
				book.setBookshelf(bookshelf);
				book.setAmount(amount);
				book.setProvider(provider);
				book.setDescriptions(descriptions);
				if (amount > 0) {
					book.setStatus(1);
				} else {
					book.setStatus(3);
				}
				book.setInsertDate(new Date());
				mng.setObj(book);
				mng.setUserDo(user);
				String result = baseServices.insert(mng);
				List<BookCategory> categories = new ArrayList<>();
				for (int i = 0; i < ctg.length; i++) {
					Manageable<BookCategory> m2 = new Manageable<>();
					m2.setUserDo(user);
					Category c = ctgServices.getById(ctg[i]);
					BookCategory bc = new BookCategory();
					bc.setBook(book);
					bc.setCateg(c);
					bc.setStatus(1);
					categories.add(bc);
					m2.setObj(bc);
					baseServices.insert(m2);
				}
				book.setCategory(categories);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/management/book";
					notice = MessageUtil.getNoticeMsg(mng);
					if (AppConstrant.UPDATE_CODE.equals(result)) {
						notice = "Sách đã tồn tại, cập nhật số lượng thành công";
					}
					redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				}
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/book/insert-by-excel")
	public String insertByExcel(HttpServletRequest request, ModelMap mm, @RequestParam String filename) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				String result = baseServices.insertBatch(user, filename);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/home";
					notice = "Thê";
					if (AppConstrant.UPDATE_CODE.equals(result)) {
						notice = "Sách đã tồn tại, cập nhật số lượng thành công";
					}
				}
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		}
		return url;
	}

}
