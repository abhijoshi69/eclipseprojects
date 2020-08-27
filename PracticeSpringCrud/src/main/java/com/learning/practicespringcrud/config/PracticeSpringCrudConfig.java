package com.learning.practicespringcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.learning.practicespringcrud")
@EnableWebMvc
public class PracticeSpringCrudConfig 
{
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver rv = new InternalResourceViewResolver();
		rv.setPrefix("/views/");
		rv.setSuffix(".jsp");
		return rv;
	}
}
