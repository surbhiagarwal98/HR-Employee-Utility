package com.nagarro.EmployeeManagement.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.EmployeeManagement.exceptions.InvalidInputException;

/**
 * parses String date into Date 
 * @author surbhiagarwal
 *
 */
public class DateParser {
	public static Date getValidatedDate(final String date) throws InvalidInputException {
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		Date validatedDate = null;
		if (null != date) {
			try {
				validatedDate = dateformat.parse(date);
			} catch (ParseException exception) {
				throw new InvalidInputException("Invalid Input");
			}
		} else {
			throw new InvalidInputException("Invalid input");
		}
		return validatedDate;
	}
}
