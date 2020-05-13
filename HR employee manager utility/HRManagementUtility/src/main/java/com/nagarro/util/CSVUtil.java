package com.nagarro.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nagarro.constants.Constants;
import com.nagarro.exception.InvalidInputException;
import com.nagarro.model.Employee;

/**
 * util class to open csv and read data
 * 
 * @author surbhiagarwal
 *
 */
public class CSVUtil {

	/**
	 * load all csv rowwise data to list
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidInputException
	 */
	public static List<Employee> loadCSV(MultipartFile file) throws IOException, InvalidInputException {

		String row = "";
		String[] rowdata = null;

		List<Employee> employees = new ArrayList<Employee>();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			br.readLine();

			while ((row = br.readLine()) != null) {

				rowdata = row.split(Constants.CSV_SEPARATOR);
				Employee employee = new Employee();
				long employeeCode = Long.parseLong(rowdata[0]);
				String employeeName = rowdata[1];
				String location = rowdata[2];
				String email = rowdata[3];
				Date date = DateParser.parseDate(rowdata[4]);
				employee.setEmployeeCode(employeeCode);
				employee.setEmployeeName(employeeName);
				employee.setLocation(location);
				employee.setEmail(email);
				employee.setDate(date);
				employees.add(employee);
			}

			br.close();
		} catch (FileNotFoundException nfe) {
			throw new InvalidInputException("No file found");
		}

		return employees;
	}
}
