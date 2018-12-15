package bll.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import bll.service.BaseServices;
import data.Book;
import data.Card;
import data.Manageable;
import data.Transaction;
import data.User;
import util.AppConstrant;
import util.DateTimeUtil;
import util.MessageUtil;

@Controller
public class IssueBookController {
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseServices baseServices;

	@RequestMapping("dashboard/inquiry")
	public String issueInput() {
		return "dashboard/inquiry-card";
	}

	@RequestMapping("dashboard/issue")
	public String inquiry(@RequestParam long seri, RedirectAttributesModelMap redirectAttributes, ModelMap mm,
			HttpServletRequest request) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				String notice = "";
				Card card = (Card) baseServices.getById(String.valueOf(seri), Card.class);
				if (card == null) {
					notice = "Truy vấn thông tin thẻ thất bại";
					redirectAttributes.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				} else {
					session.setAttribute("c", card);
					if (card.getLoanTime() == 0) {
						mm.addAttribute("disable", true);
					}
				}
				url = "dashboard/inquiry-card";
			} else {
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			e.printStackTrace();
		}
		return url;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("dashboard/confirm-issue")
	public String confirm(HttpServletRequest request, RedirectAttributesModelMap re, @RequestParam String[] bookIds) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Transaction tran = new Transaction();
			if (user != null) {

				String notice = "";
				Card card = (Card) session.getAttribute("preCard");
				if (card != null) {
					int longevity = card.getCard().getLongevity();
					for (int i = 0; i < bookIds.length; i++) {
						Book book = (Book) baseServices.getById(bookIds[i], Book.class);
						int loanTime = card.getLoanTime();
						int amount = book.getAmount();
						if (book != null && loanTime > 0 && amount > 0) {
							tran.setCard(card);
							tran.setBook(book);
							tran.setDateCreate(new Date());
							int createDate = Integer
									.parseInt(DateTimeUtil.getDateTime(tran.getDateCreate(), "yyyyMMdd"));
							String dueDate = String.valueOf(createDate + longevity);
							tran.setDueDate(DateTimeUtil.parse(dueDate));
							tran.setStatus(1);
							tran.setUser(card.getUser());
							Manageable<Transaction> mng = new Manageable<>();
							mng.setUserDo(user);
							mng.setObj(tran);
							String check = baseServices.insert(mng);
							if (AppConstrant.SUCCESS_CODE.equals(check)) {
								loanTime--;
								amount--;
								card.setLoanTime(loanTime);
								book.setAmount(amount);
								Manageable<Book> m = new Manageable<>();
								m.setUserDo(user);
								m.setObj(book);
								baseServices.update(m);
							}
						}
					}
					Manageable<Card> m = new Manageable<>();
					m.setUserDo(user);
					m.setObj(card);
					baseServices.update(m);
					notice = MessageUtil.getNoticeMsg(m);
					url = "redirect:/dashboard";
					re.addFlashAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
				}
			} else {
				url = "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
