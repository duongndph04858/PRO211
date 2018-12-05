package bll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("dashboard")
	public String dashboard() {
		return "dashboard/home";
	}
}
