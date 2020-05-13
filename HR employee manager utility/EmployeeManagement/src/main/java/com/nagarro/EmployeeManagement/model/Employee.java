package com.nagarro.EmployeeManagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class employee Attributes are employee's code, employee's name,
 * employee's location, employee's email, employee's date of birth
 * 
 * @author surbhiagarwal
 *
 */
@XmlRootElement
@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_code")
	private long employeeCode;
	@Column(name = "Employee_name")
	private String employeeName;
	@Column(name = "Location")
	private String location;
	@Column(name = "Email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "Date")
	private Date date;

	public Employee() {
	}

	/**
	 * 
	 * @param employeeCode
	 * @param employeeName
	 * @param location
	 * @param email
	 * @param date
	 */
	public Employee(long employeeCode, String employeeName, String location, String email, Date date) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.location = location;
		this.email = email;
		this.date = date;
	}

	public long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
