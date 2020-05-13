package com.nagarro.EmployeeManagement.service.api;

import java.util.List;

import com.nagarro.EmployeeManagement.model.Employee;

/**
 * Interacts with controller and Dao
 * 
 * @author surbhiagarwal
 *
 */
public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(long employeeCode);

	public void addEmployee(Employee employee);

	public void updateEmployee(long employeeCode, Employee employee);

	public void deleteEmployee(long employeeCode);

}
