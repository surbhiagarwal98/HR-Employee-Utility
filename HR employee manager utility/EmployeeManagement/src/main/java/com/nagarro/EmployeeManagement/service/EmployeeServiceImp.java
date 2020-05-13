package com.nagarro.EmployeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.EmployeeManagement.dao.EmployeeDaoImp;
import com.nagarro.EmployeeManagement.dao.api.EmployeeDao;
import com.nagarro.EmployeeManagement.model.Employee;
import com.nagarro.EmployeeManagement.service.api.EmployeeService;

/**
 * employee service implementation
 * 
 * @author surbhiagarwal
 *
 */
@Component
public class EmployeeServiceImp implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImp();

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();

	}

	@Override
	public Employee getEmployee(long employeeCode) {
		return employeeDao.getEmployee(employeeCode);
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(long employeeCode, Employee employee) {
		employeeDao.updateEmployee(employeeCode, employee);
	}

	@Override
	public void deleteEmployee(long employeeCode) {
		employeeDao.deleteEmployee(employeeCode);
	}

}
