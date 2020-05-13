package com.nagarro.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.constants.Constants;
import com.nagarro.exception.InvalidInputException;
import com.nagarro.model.Employee;
import com.nagarro.service.api.EmployeeService;
import com.nagarro.util.DateParser;
import com.nagarro.util.ValidationUtil;

/**
 * this is controller class, interacts with employee related jsp pages
 * 
 * @author surbhiagarwal
 *
 */

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * method to get all employees and select view
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView();
		List<Employee> employees = employeeService.getEmloyees();
		mv.addObject("employees", employees);
		mv.setViewName("home");
		return mv;

	}

	/**
	 * method to edit employees
	 * 
	 * @param employeeCode
	 * @return
	 */
	@RequestMapping(value = "/{employeeCode}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable String employeeCode) {
		Employee employee = employeeService.getEmployee(employeeCode);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/editEmployee");
		mv.addObject("employee", employee);
		return mv;
	}

	/**
	 * method to update employees
	 * 
	 * @param employee
	 * @param model
	 * @return
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/{employeeCode}", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model)
			throws InvalidInputException {
		String page = "redirect:/employees";
		if (ValidationUtil.validateNameField(employee.getEmployeeName())
				&& ValidationUtil.validateLocationField(employee.getLocation())
				&& ValidationUtil.validateEmailField(employee.getEmail())) {
			System.out.println("Fields validated!");
			try {
				employeeService.updateEmployee(employee);
			} catch (IllegalStateException ise) {
				throw new InvalidInputException("Please enter valid values.");
			}
		} else {
			System.out.println("Invalid field values!");
			page = "../editEmployee";
		}
		return page;

	}

	/**
	 * method to download CSV files to the system
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadCSV", method = RequestMethod.POST)
	public void downloadFile(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=" + Constants.CSV_FILE_NAME);
		response.setHeader(headerKey, headerValue);
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		employeeService.downloadFile(csvWriter);
	}

	/**
	 * method to upload data from CSV file to view and database
	 * 
	 * @param file
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws InvalidInputException
	 */
	@RequestMapping(value = "/uploadCSV")
	public String uploadCSV(@RequestParam("file") MultipartFile file, Model model)
			throws IOException, InvalidInputException {
		System.out.println("here");
		employeeService.addCSV(file);
		return "redirect:/employees";
	}
}
