package com.nagarro.constants;

/**
 * this class declares constants to be used throughout the project
 * 
 * @author surbhiagarwal
 *
 */
public class Constants {

	public static final String REST_API_URI = "http://localhost:8080/EmployeeManagement/webapi/";
	public static final String GET_EMPLOYEES = "employees/";
	public static final String GET_EMPLOYEE = "employees/";
	public static final String POST_EMPLOYEE = "employees/";
	public static final String PUT_EMPLOYEE = "employees/";
	public static final String CSV_FILE_NAME = "EmployeeDetails.csv";
	public static final String[] HEADER = { "EmployeeCode", "EmployeeName", "Location", "Email", "Date" };
	public static final String CSV_SEPARATOR = ",";
	public static final int MAX_NAME_LETTERS = 100;
	public static final int MAX_LOCATION_LETTERS = 500;
	public static final int MAX_EMAIL_LETTERS = 100;
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String CSV_DATE_FORMAT = "E MMM dd HH:mm:ss Z yyyy";
}
