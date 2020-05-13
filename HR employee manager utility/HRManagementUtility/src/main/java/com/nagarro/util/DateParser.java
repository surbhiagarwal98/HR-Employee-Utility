package com.nagarro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.constants.Constants;
import com.nagarro.exception.InvalidInputException;

/**
 * this class parses date to required format
 * 
 * @author surbhiagarwal
 *
 */
public class DateParser {
	/**
	 * method to parse date
	 * 
	 * @param date
	 * @return
	 * @throws InvalidInputException
	 * @throws ParseException 
	 */
	public static Date parseDate(final String date) throws InvalidInputException {
		SimpleDateFormat dateformat = new SimpleDateFormat(Constants.CSV_DATE_FORMAT);
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
