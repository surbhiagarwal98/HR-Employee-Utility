package com.nagarro.service.api;

import com.nagarro.model.User;

/**
 * interface class
 * 
 * @author surbhiagarwal
 *
 */
public interface UserService {
	public User getUser(String username);

	public boolean isValidUser(String username, String password);

	public boolean resetPassword(String username, String newPassword);
}
