package com.nagarro.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constants.Constants;
import com.nagarro.model.Employee;
/**
 * interface implementation class
 * @author surbhiagarwal
 *
 */
public class EmployeeClientImp implements EmployeeClient {

	@Autowired
	private RestTemplate restTemplate;

	public List<Employee> getAllEmployees() {
		String url = Constants.REST_API_URI + Constants.GET_EMPLOYEES;
		ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		List<Employee> employees = response.getBody();
		return employees;
	}

	public void updateEmployee(Employee employee) {
		System.out.println("in client" + employee.getDate());
		String url = Constants.REST_API_URI + Constants.POST_EMPLOYEE + employee.getEmployeeCode();
		restTemplate.put(url, employee);
	}


	public Employee getEmployee(String employeeCode) {
		String url = Constants.REST_API_URI + Constants.GET_EMPLOYEE + employeeCode;
		Employee employee = restTemplate.getForObject(url, Employee.class);
		return employee;
		
	}

	public void addEmployee(Employee employee) {
		String url= Constants.REST_API_URI + Constants.POST_EMPLOYEE;
		restTemplate.postForObject(url, employee, Employee.class);
		
	}

	public void addCSV(List<Employee> employees) {
		if(employees!=null) {
		for (Employee employee : employees) {
            this.addEmployee(employee);
        }
		}else {
			System.out.println("Can't upload blank file");
		}
		
	}

	

}
