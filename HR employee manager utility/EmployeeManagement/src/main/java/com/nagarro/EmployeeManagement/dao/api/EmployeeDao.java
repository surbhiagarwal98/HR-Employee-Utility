package com.nagarro.EmployeeManagement.dao.api;

import java.util.List;

import com.nagarro.EmployeeManagement.model.Employee;

/**
 * interacts with database for CRUD operations
 * 
 * @author surbhiagarwal
 *
 */
public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public Employee getEmployee(long employeeCode);

	public void addEmployee(Employee employee);

	public void updateEmployee(long employeeCode, Employee employee);

	public void deleteEmployee(long employeeCode);
}
