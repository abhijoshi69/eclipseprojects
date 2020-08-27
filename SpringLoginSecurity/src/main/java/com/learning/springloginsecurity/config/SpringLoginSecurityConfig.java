package com.learning.springloginsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.learning.springloginsecurity")
@EnableWebMvc
public class SpringLoginSecurityConfig
{
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver rv = new InternalResourceViewResolver();
		rv.setPrefix("/views/");
		rv.setSuffix(".jsp");
		return rv;
	}
	
	@Bean
	public BCrypt getBCrypt()
	{
		return new BCrypt();
	}
}
