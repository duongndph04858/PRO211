package bll.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bll.model.BaseService;
import core.entity.Message;
import data.Manageable;
import data.TransactionLog;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class DashboardController {

	@Autowired
	BaseService baseService;

	@RequestMapping("dashboard/insert")
	public String insert(@ModelAttribute Manageable obj, RedirectAttributes redirectAttributes,
			HttpServletRequest request, ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		TransactionLog tran = new TransactionLog();
		Message msg = new Message();
		String descriptions = "";
		try {
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				msg.setCommand("thêm");
				msg.setObj(obj);
				msg.setUser(user);
				boolean insert = baseService.insert(obj);
				if (insert) {
					msg.setValue(msg.getValue() + " thành công");
					notice = MessageUtil.getNoticeMsg(msg);
					descriptions = MessageUtil.getDescription(msg);
					url = "redirect:/dashboard/home";
				} else {
					msg.setValue(msg.getValue() + " thất bại");
					notice = MessageUtil.getNoticeMsg(msg);
					descriptions = MessageUtil.getDescription(msg);
					mm.addAttribute("obj", obj);
					url = "dashboard/insert-input";
				}
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute("notice", "Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		} finally {
			tran.setDateCreate(new Date());
			tran.setDescriptions(descriptions);
			baseService.insertLog(tran);
		}
		return url;
	}

	@RequestMapping("dashboard/update")
	public String update(@ModelAttribute Manageable obj, RedirectAttributes redirectAttributes,
			HttpServletRequest request, ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		TransactionLog tran = new TransactionLog();
		Message msg = new Message();
		String descriptions = "";
		try {
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				msg.setCommand("cập nhật");
				msg.setObj(obj);
				msg.setUser(user);
				boolean update = baseService.insert(obj);
				if (update) {
					msg.setValue(msg.getValue() + " thành công");
					notice = MessageUtil.getNoticeMsg(msg);
					descriptions = MessageUtil.getDescription(msg);
					url = "redirect:/dashboard/home";
				} else {
					msg.setValue(msg.getValue() + " thất bại");
					notice = MessageUtil.getNoticeMsg(msg);
					descriptions = MessageUtil.getDescription(msg);
					mm.addAttribute("obj", obj);
					url = "dashboard/insert-input";
				}
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute("notice", "Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		} finally {
			tran.setDateCreate(new Date());
			tran.setDescriptions(descriptions);
			baseService.insertLog(tran);
		}
		return url;
	}
}
