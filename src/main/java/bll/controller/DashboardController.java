package bll.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bll.service.BaseServices;
import data.Category;
import data.Manageable;
import data.User;
import util.AppConstrant;
import util.MessageUtil;

@Controller
public class DashboardController {
	@Autowired
	BaseServices<Manageable<Category>> baseServices;

	@RequestMapping("dashboard/management/category")
	public String listCategory(ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			List<Manageable<Category>> categories = baseServices.getAll("Category");
			if (categories != null) {
				mm.addAttribute("categories", categories);
			} else {
				mm.addAttribute("categories", "Danh mục thư viện trống");
			}
			url = "dashboard/category";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping("dashboard/category/insert-category")
	public String insert(@RequestParam String id, @RequestParam String name, @RequestParam String descriptions,
			ModelMap mm, HttpServletRequest request) {
		String url = AppConstrant.APP_ERROR_URL;
		try {
			Manageable<Category> mng = new Manageable<>();
			Category category = new Category();
			category.setId(id);
			category.setName(name);
			category.setStatus(1);
			category.setDescriptions(descriptions);
			mng.setObj(category);
			String notice = "";
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				mng.setUserDo(user);
				String result = baseServices.insert(mng);
				if (!AppConstrant.ERROR_CODE.equals(result)) {
					url = "redirect:/dashboard";
					notice = MessageUtil.getNoticeMsg(mng);
				}
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE, notice);
			} else {
				mm.addAttribute(AppConstrant.APP_NOTICE_MODELATTRIBUTE,
						"Phiên làm việc đã kết thúc, vui lòng đăng nhập lại");
				url = "login";
			}
		} catch (Exception e) {
			mm.addAttribute(AppConstrant.APP_ERR_MODELATTRIBUTE, AppConstrant.APP_ERROR_MESSAGE);
		}
		return url;
	}
}
