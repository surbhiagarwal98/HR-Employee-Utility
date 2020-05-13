package com.nagarro.util;

import com.nagarro.constants.Constants;

/**
 * this class validates the form data according to given restrictions
 * 
 * @author surbhiagarwal
 *
 */
public class ValidationUtil {

	/**
	 * validates name field
	 * 
	 * @param employeeName
	 * @return
	 */
	public static boolean validateNameField(String employeeName) {
		int i = 0;
		int count = 0;
		while (i <= employeeName.length()) {
			count++;
			i++;
		}
		return count <= Constants.MAX_NAME_LETTERS;
	}

	/**
	 * validates location field
	 * 
	 * @param location
	 * @return
	 */
	public static boolean validateLocationField(String location) {
		int i = 0;
		int count = 0;
		while (i <= location.length()) {
			count++;
			i++;
		}
		return count <= Constants.MAX_LOCATION_LETTERS;

	}

	/**
	 * validates email field
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmailField(String email) {

		int i = 0;
		int count = 0;
		while (i <= email.length()) {
			count++;
			i++;
		}
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		return (count <= Constants.MAX_EMAIL_LETTERS) && (email.matches(regex));
	}

}
