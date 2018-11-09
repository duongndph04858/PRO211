package bll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bll.model.UserDAO;
import data.User;

@Controller
@RequestMapping("/dashboard/")
public class Authentication {
@Autowired
UserDAO userDao;

@RequestMapping("login")
public boolean isLogin(@RequestParam String username,@RequestParam String password) {
	User user = userDao.getUserByUsername(username);
	if(user!=null) {
		String logUsername = user.getUsername();
		String logPassword = user.getPassword();
		if(logUsername.equals(username)) {
			
		}
	}
	return false;
}
	
}
