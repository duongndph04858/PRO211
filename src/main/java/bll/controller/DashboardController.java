package bll.controller;

import javax.servlet.http.HttpServletRequest;

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
import util.AppConstrant;

@Controller
public class DashboardController {

	@Autowired
	BaseService baseService;

	@RequestMapping("insert")
	public String insert(@ModelAttribute Manageable obj, RedirectAttributes redirectAttributes,
			HttpServletRequest request, ModelMap mm) {
		String url = AppConstrant.APP_ERROR_URL;
		TransactionLog tran = new TransactionLog();
		Message msg = new Message();
		try {
			boolean insert = baseService.insert(obj);
			String type = obj.getType();
		} catch (Exception e) {
			mm.addAttribute("error", AppConstrant.APP_ERROR_MESSAGE);
		}
		return url;
	}

}
