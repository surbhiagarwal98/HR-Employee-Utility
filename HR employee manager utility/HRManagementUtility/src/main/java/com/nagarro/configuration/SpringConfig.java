package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * configuration class for declaring components base package,view and multipart
 * resolvers
 * 
 * @author surbhiagarwal
 *
 */
@Configuration
@ComponentScan({ "com.nagarro" })
public class SpringConfig {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		return vr;

	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver  multipartResolver() {
		return new CommonsMultipartResolver ();
	}
}
