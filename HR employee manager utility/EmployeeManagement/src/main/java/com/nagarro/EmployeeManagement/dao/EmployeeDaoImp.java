package com.nagarro.EmployeeManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.nagarro.EmployeeManagement.dao.api.EmployeeDao;
import com.nagarro.EmployeeManagement.model.Employee;
import com.nagarro.EmployeeManagement.util.HibernateUtil;

/**
 * Employee dao implementation
 * 
 * @author surbhiagarwal
 *
 */
@Component
public class EmployeeDaoImp implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		session.getTransaction().commit();

		return employees;
	}

	@Override
	public Employee getEmployee(long employeeCode) {
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		Employee employee = session.get(Employee.class, employeeCode);
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			session.getTransaction().begin();
			session.save(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void updateEmployee(long employeeCode, Employee newemployee) {
		try {
			Session session = HibernateUtil.getSession();
			session.getTransaction().begin();
			Employee employee = session.get(Employee.class, employeeCode);
			employee.setEmployeeName(newemployee.getEmployeeName());
			employee.setEmail(newemployee.getEmail());
			employee.setDate(newemployee.getDate());
			employee.setLocation(newemployee.getLocation());
			session.update(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	@Override
	public void deleteEmployee(long employeeCode) {
		try {
			Session session = HibernateUtil.getSession();
			session.getTransaction().begin();
			Employee employee = session.get(Employee.class, employeeCode);
			session.delete(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
