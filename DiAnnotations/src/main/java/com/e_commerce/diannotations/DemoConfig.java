package com.e_commerce.diannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.e_commerce.diannotations")
public class DemoConfig 
{
	@Bean
	public DemoClass getDemoClassObj()
	{
		DemoClass demo = new DemoClass();
		return demo;
	}
}
