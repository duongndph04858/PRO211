package bll.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import bll.service.BaseServices;
import data.Card;
import data.CardType;
import data.Category;
import data.Manageable;
import data.Publisher;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class DashboardController {
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseServices baseServices;

	@RequestMapping("/dashboard/management/category")
	public String listCategory(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Category>> categories = baseServices.getAll(Category.class.getName());
			if (categories != null) {
				mm.addAttribute("categories", categories);
			} else {
				mm.addAttribute("categories", "Danh mục thư viện trống");
			}
			url = "dashboard/category-management";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/dashboard/category/insert-category", method = RequestMethod.POST)
	public String insert(@RequestParam String id, @RequestParam String name, @RequestParam String descriptions,
			ModelMap mm, HttpServletRequest request, RedirectAttributesModelMap re) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				Manageable<Category> mng = new Manageable<>();
				Category category = new Category();
				category.setId(id);
				category.setName(name);
				category.setStatus(1);
				category.setDescriptions(descriptions);
				mng.setObj(category);
				String notice = "";
				mng.setUserDo(user);
				String result = baseServices.insert(mng);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/management/category";
					notice = MessageUtil.getNoticeMsg(mng);
					re.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				}
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("/dashboard/category/delete-category")
	public String deleteCategory(@RequestParam String id, RedirectAttributesModelMap redirectAttributes,
			HttpServletRequest request, ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				String notice = "";
				Manageable<Category> mng = new Manageable<>();
				Category category = (Category) baseServices.getById(id, Category.class);
				if (category.getBookCategory().size() > 0) {
					notice = "Không thể xóa danh mục đang có sách";
					redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
					url = "redirect:/dashboard/management/category";
					return url;
				}
				mng.setUserDo(user);
				String result = baseServices.delete(mng);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					notice = MessageUtil.getNoticeMsg(mng);
					redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
					url = "redirect:/dashboard/management/category";
				}
			} else {
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/management/cardtype")
	public String listCardType(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<CardType>> cardtype = baseServices.getAll(CardType.class.getName());
			if (cardtype != null) {
				mm.addAttribute("cardtype", cardtype);
			} else {
				mm.addAttribute("cardtype", "Danh sách Thẻ trống");
			}
			url = "dashboard/cardtype-management";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/cardtype/insert-cardtype")
	public String insertCardType(@RequestParam String name, @RequestParam int longevity,
			@RequestParam String descriptions, RedirectAttributes redirectAttributes, ModelMap mm,
			HttpServletRequest request) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Manageable<CardType> mng = new Manageable<>();
			CardType cardtype = new CardType();
			cardtype.setName(name);
			cardtype.setStatus(1);
			cardtype.setLongevity(longevity);
			cardtype.setDescriptions(descriptions);
			mng.setObj(cardtype);
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				mng.setUserDo(user);
				String result = baseServices.insert(mng);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/management/cardtype";
					notice = MessageUtil.getNoticeMsg(mng);
				}
				redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/management/card")
	public String listCard(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Card>> card = baseServices.getAll(Card.class.getName());
			if (card != null) {
				mm.addAttribute("card", card);
			} else {
				mm.addAttribute("card", "Danh sách Thẻ trống");
			}
			url = "dashboard/card-management";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/card/insertcard")
	public String listInputCard(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Card card = new Card();
			List<Manageable<CardType>> cardtype = baseServices.getAllActive(CardType.class.getName());
			mm.addAttribute("cardtype", cardtype);
			mm.addAttribute("card", card);
			url = "dashboard/insert-card";
		} catch (Exception e) {
			e.printStackTrace();
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
		}
		return url;
	}

	@RequestMapping("dashboard/card/insert-card")
	public String insertCard(@RequestParam User user, @RequestParam String fullname, @RequestParam CardType card,
			@RequestParam Date dateCreate, @RequestParam Date dateExpire, @RequestParam int loanTime,
			@RequestParam String descriptions, RedirectAttributes redirectAttributes, ModelMap mm,
			HttpServletRequest request) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Manageable<Card> mng = new Manageable<>();
			Card cardT = new Card();
			cardT.setFullname(fullname);
			cardT.setUser(user);
			cardT.setCard(card);
			cardT.setDateCreate(dateCreate);
			cardT.setDateExpire(dateExpire);
			cardT.setStatus(1);
			cardT.setLoanTime(loanTime);
			cardT.setDescriptions(descriptions);
			mng.setObj(cardT);
			String notice = "";
			HttpSession session = request.getSession();
			User user1 = (User) session.getAttribute("user");
			if (user1 != null) {
				mng.setUserDo(user1);
				String result = baseServices.insert(mng);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/management/cardtype";
					notice = MessageUtil.getNoticeMsg(mng);
				}
				redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/management/publisher")
	public String listPublisher(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Publisher>> publisher = baseServices.getAll(Publisher.class.getName());
			if (publisher != null) {
				mm.addAttribute("publisher", publisher);
			} else {
				mm.addAttribute("publisher", "Danh sách Nhà xuất bản trống");
			}
			url = "dashboard/publisher-management";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/publisher/insert-publisher")
	public String insertpublisher(@RequestParam String id, @RequestParam String name, @RequestParam String address,
			@RequestParam String email, @RequestParam String descriptions, RedirectAttributes redirectAttributes,
			ModelMap mm, HttpServletRequest request) {
		String url = AppConstrant.APP_ERROR_URL;

		if (id.isEmpty()) {
			redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, "Nhập Mã nhà xuất bản");
			url = "redirect:/dashboard/management/publisher";
			return url;
		} else {
			try {
				Manageable<Publisher> mng = new Manageable<>();
				Publisher publisher = new Publisher();
				publisher.setId(id);
				publisher.setName(name);
				publisher.setStatus(1);
				publisher.setAddress(address);
				publisher.setEmail(email);
				publisher.setDescriptions(descriptions);
				mng.setObj(publisher);
				String notice = "";
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				if (user != null) {
					mng.setUserDo(user);
					String result = baseServices.insert(mng);
					if (!AppConstrant.ERROR_CODE.equals(result)) {
						url = "redirect:/dashboard/management/publisher";
						notice = MessageUtil.getNoticeMsg(mng);
					}
					redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				} else {
					mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
							"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
					url = "login";
				}
			} catch (Exception e) {
				mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
				e.printStackTrace();
			}
			return url;
		}
	}
}
