package com.nagarro.service.api;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.exception.InvalidInputException;
import com.nagarro.model.Employee;

/**
 * interface class
 * 
 * @author surbhiagarwal
 *
 */
public interface EmployeeService {
	List<Employee> getEmloyees();

	Employee getEmployee(String employeeCode);

	void updateEmployee(Employee employee);

	void downloadFile(ICsvBeanWriter csvWriter) throws IOException;

	List<Employee> addCSV(MultipartFile file) throws IOException, InvalidInputException;

}
