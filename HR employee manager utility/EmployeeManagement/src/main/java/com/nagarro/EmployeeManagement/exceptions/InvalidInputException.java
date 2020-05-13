package com.nagarro.EmployeeManagement.exceptions;

/**
 * Custom exception for invalid input
 * 
 * @author surbhiagarwal
 *
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String s) {
		super(s);
	}
}
