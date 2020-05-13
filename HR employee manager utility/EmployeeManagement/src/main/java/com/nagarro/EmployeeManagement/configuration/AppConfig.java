package com.nagarro.EmployeeManagement.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.nagarro.EmployeeManagement.service", "com.nagarro.EmployeeManagement.dao",
		"com.nagarro.EmployeeManagement.controller" })
public class AppConfig {

}
