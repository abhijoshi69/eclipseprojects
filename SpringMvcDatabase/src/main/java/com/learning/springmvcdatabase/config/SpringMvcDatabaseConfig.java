package com.learning.springmvcdatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.learning.springmvcdatabase")
@EnableWebMvc
public class SpringMvcDatabaseConfig 
{
	@Bean
	public InternalResourceViewResolver getViewObj()
	{
		InternalResourceViewResolver rv = new InternalResourceViewResolver();
		rv.setPrefix("/views/");
		rv.setSuffix(".jsp");
		return rv;
	}
}
