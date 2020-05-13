package com.nagarro.EmployeeManagement.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.nagarro.EmployeeManagement.model.Employee;
import com.nagarro.EmployeeManagement.service.EmployeeServiceImp;
import com.nagarro.EmployeeManagement.service.api.EmployeeService;

/**
 * Employee controller with basic crid operations for Employee
 * 
 * @author surbhiagarwal
 *
 */
@Path("/")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class EmployeeController implements ApplicationContextAware {

	EmployeeService employeeService = new EmployeeServiceImp();

	/**
	 * gets all the employees
	 * 
	 * @return
	 */
	@GET
	@Path("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	/**
	 * 
	 * @param employeeCode
	 * @return
	 */
	@GET
	@Path("/employees/{employeeCode}")
	public Employee getEmployee(@PathParam("employeeCode") long employeeCode) {
		return employeeService.getEmployee(employeeCode);
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	@POST
	@Path("/employees")
	public Response addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
		return Response.status(Status.CREATED).entity(employee).build();

	}

	/**
	 * 
	 * @param employeeCode
	 * @param employee
	 * @return
	 */
	@PUT
	@Path("employees/{employeeCode}")
	public Response updateEmployee(@PathParam("employeeCode") long employeeCode, Employee employee) {
		employeeService.updateEmployee(employeeCode, employee);
		return Response.ok().build();
	}

	/**
	 * 
	 * @param employeeCode
	 * @return
	 */
	@DELETE
	@Path("/employees/{employeeCode}")
	public Response deleteEmployee(@PathParam("employeeCode") long employeeCode) {
		employeeService.deleteEmployee(employeeCode);
		return Response.ok().build();
	}

	ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
