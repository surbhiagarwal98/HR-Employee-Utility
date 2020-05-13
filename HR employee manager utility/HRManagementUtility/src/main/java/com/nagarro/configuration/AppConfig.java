package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.nagarro.client.EmployeeClient;
import com.nagarro.client.EmployeeClientImp;
import com.nagarro.dao.UserDaoImp;
import com.nagarro.dao.api.UserDao;
import com.nagarro.service.EmployeeServiceImp;
import com.nagarro.service.UserServiceImp;
import com.nagarro.service.api.EmployeeService;
import com.nagarro.service.api.UserService;

/**
 * configuration class for interface implementations, declaring beans
 * 
 * @author surbhiagarwal
 *
 */

@Configuration
public class AppConfig {
	@Bean
	public UserService getUserService() {
		return new UserServiceImp();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate;
	}

	@Bean
	public EmployeeClient getEmployeeClient() {
		return new EmployeeClientImp();
	}

	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImp();
	}
}
