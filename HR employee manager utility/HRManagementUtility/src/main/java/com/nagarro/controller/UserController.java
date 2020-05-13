package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.User;
import com.nagarro.service.api.UserService;

/**
 * this controller is related to User(HR) for login credentials
 * 
 * @author surbhiagarwal
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * method to login to the utility
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		request.getSession().setAttribute("user", user);
		if (!userService.isValidUser(username, password)) {
			mv.setViewName("index");
			return mv;
		}
		System.out.println("Login successful!");
		mv.addObject("username", username);
		mv.setViewName("home");
		return mv;
	}

	/**
	 * method to reset password
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/reset")
	public ModelAndView reset(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (newPassword.equals(confirmPassword)) {
			if (userService.resetPassword(username, newPassword)) {
				mv.setViewName("index");
			} else {
				System.out.println("password reset failed!");
				mv.setViewName("resetPassword");
			}

		} else {
			System.out.println("Passwords matching failed!");
			mv.setViewName("resetPassword");
		}

		return mv;
	}

	/**
	 * method to logout the utility
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

}
