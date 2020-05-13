package com.nagarro.exception;

/**
 * class to define custom exceptions
 * 
 * @author surbhiagarwal
 *
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception {
	public InvalidInputException(String s) {
		super(s);
	}
}
