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

import bll.repository.BaseRepository;
import bll.service.BaseServices;
import core.entity.Message;
import data.Manageable;
import data.TransactionLog;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class DashboardController {

	@Autowired
	BaseServices baseService;

	@RequestMapping("dashboard/insert")
	public String insert(@ModelAttribute Manageable<?> obj, RedirectAttributes redirectAttributes,
			HttpServletRequest request, ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				obj.setUserDo(user);
				String result = baseService.insert(obj);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard/home";
					if (AppConstrant.UPDATE_CODE.equals(result)) {
						notice = "Sách đã tồn tại, cập nhật số lượng thành công";
					}
				}
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute("notice", "Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
		}
		return url;
	}
}
