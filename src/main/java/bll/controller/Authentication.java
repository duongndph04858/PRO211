package bll.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bll.service.AuthenrizationServices;
import data.User;
import util.AppConstrant;

@Controller
public class Authentication {
	@Autowired
	AuthenrizationServices autServices;

	@RequestMapping("login")
	public String isLogin(@RequestParam(name = "username", required = false, defaultValue = "") String username, @RequestParam(name = "password", required = false, defaultValue = "") String password,
			RedirectAttributes redirectAttributes, ModelMap md, HttpSession session) {
		String url = "login";
		try {
			User user = autServices.getUserByUsername(username);
			if (user != null) {
				String logUsername = user.getUsername();
				String logPassword = user.getPassword();
				if (username.equals(logUsername) && password.equals(logPassword)) {
					session.setAttribute("user", user);
					url = "redirect:/dashboard";
					redirectAttributes.addFlashAttribute("msg", "Xin chào, " + user.getFullname());
				}
			}
		} catch (Exception e) {
			md.addAttribute("error", AppConstrant.APP_ERROR_MESSAGE);
			url = AppConstrant.APP_ERROR_URL;
			e.printStackTrace();
		}
		return url;
	}

}
