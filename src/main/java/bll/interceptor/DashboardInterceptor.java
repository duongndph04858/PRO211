package bll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import data.User;
import util.AppConstrant;

public class DashboardInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else if (user.getPosition().getId() > 2) {
			RedirectAttributes reAttributes = new RedirectAttributesModelMap();
			reAttributes.addFlashAttribute("access-denied", "Tài khoản này không đủ quyền truy cập");
			response.sendRedirect(request.getContextPath() + "/" + AppConstrant.ACCESS_DENIED_URL);
			return false;
		}
		return true;
	}
}
