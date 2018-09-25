package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Users;
import com.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
//	@Resource
//	private UserService userService;
//
//	/**
//	 * 用户主页
//	 */
//	@RequestMapping("/user/index.html")
//	public ModelAndView userIndex() {
//		return new ModelAndView("user/index");
//	}
//
//	/**
//	 * 登录校验
//	 */
//	@RequestMapping("/check.html")
//	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
//			@RequestParam(name = "remember-me", required = false) boolean rememberme, HttpServletRequest request,
//			HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		HttpSession session = request.getSession();
//		Users user = new Users();
//		user.setUserLogin(username);
//		user.setUserPass(password);
//
//		Users result = userService.login(user, rememberme, response);
//		if (result != null) {
//			ModelAndView mAndView = null;
//			//登录之前地址
//			String callback = (String) session.getAttribute("callback");
//			session.removeAttribute("callback"); // 获取之后移除
//			// 基本路径
//			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//					+ request.getContextPath();
//			if (StringUtils.isNotBlank(callback)) {
//				String[] urls = callback.split(basePath);
//				if (urls.length == 2 && StringUtils.isNotBlank(urls[1])) {
//					mAndView = new ModelAndView("redirect:" + urls[1]);
//				}else{
//					mAndView = new ModelAndView("redirect:/user/index.html");
//				}
//			}else{
//				mAndView = new ModelAndView("redirect:/user/index.html");
//			}
//
//			session.setAttribute("user", result); // 登录成功之后加入session中
//			redirectAttributes.addFlashAttribute("user", result);
//
//			return mAndView;
//		} else {
//			return new ModelAndView("redirect:/login.html");
//		}
//	}
//
//	/**
//	 * 退出登录
//	 */
//	@RequestMapping("/logout.html")
//	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mAndView = new ModelAndView("redirect:/login.html");
//
//		userService.logout(request, response);
//
//		return mAndView;
//	}
}
