package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.api.UserDao;
import com.nagarro.model.User;
import com.nagarro.service.api.UserService;

/**
 * implements user service
 * 
 * @author surbhiagarwal
 *
 */
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * method to get user
	 */
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	/**
	 * method to validate user
	 */
	public boolean isValidUser(String username, String password) {

		boolean isUser = userDao.isUser(username, password);
		if (isUser) {
			return true;
		}
		return false;
	}

	/**
	 * method to reset password
	 */
	public boolean resetPassword(String username, String newPassword) {

		boolean isSuccessfulReset = userDao.resetPassword(username, newPassword);
		if (isSuccessfulReset) {
			System.out.println("Password reset successful!");
			return true;
		} else {
			System.out.println("Could not reset,an error occured.");
		}
		return false;
	}
}
