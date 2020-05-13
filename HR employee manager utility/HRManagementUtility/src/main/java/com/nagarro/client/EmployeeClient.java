package com.nagarro.client;

import java.util.List;

import com.nagarro.model.Employee;

/**
 * Client interface
 * this class interacts with clients to get connectivity with database and URIs
 * @author surbhiagarwal
 *
 */
public interface EmployeeClient {

	List<Employee> getAllEmployees();

	Employee getEmployee(String employeeCode);

	void updateEmployee(Employee employee);

	void addEmployee(Employee employee);

	void addCSV(List<Employee> employees);
}
