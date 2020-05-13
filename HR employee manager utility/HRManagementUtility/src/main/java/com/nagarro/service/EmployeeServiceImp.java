package com.nagarro.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.client.EmployeeClient;
import com.nagarro.constants.Constants;
import com.nagarro.exception.InvalidInputException;
import com.nagarro.model.Employee;
import com.nagarro.service.api.EmployeeService;
import com.nagarro.util.CSVUtil;

/**
 * Implementation class of employee Service
 * 
 * @author surbhiagarwal
 *
 */
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeClient employeeClient;
	
	/**
	 *  to get all employees
	 */
	public List<Employee> getEmloyees() {
		return employeeClient.getAllEmployees();
	}

	/**
	 * get employee using employee code (Primary key)
	 */
	public Employee getEmployee(String employeeCode) {
		return employeeClient.getEmployee(employeeCode);
	}

	/**
	 * updates employee
	 */
	public void updateEmployee(Employee employee) {
		employeeClient.updateEmployee(employee);
	}

	/**
	 * downloads data into CSV file
	 */
	public void downloadFile(ICsvBeanWriter csvWriter) throws IOException {
		csvWriter.writeHeader(Constants.HEADER);
		List<Employee> employees = this.getEmloyees();
		for (Employee employee : employees) {
			csvWriter.write(employee, Constants.HEADER);
		}
		csvWriter.close();
		System.out.println("downloaded successfully");
	}

	/**
	 * add the data of chosen CSV file to database and view
	 */
	public List<Employee> addCSV(MultipartFile file) throws IOException, InvalidInputException {
		List<Employee> employees = CSVUtil.loadCSV(file);
		employeeClient.addCSV(employees);
		return employees;

	}

}
