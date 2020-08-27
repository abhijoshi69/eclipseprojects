package com.learning.logincheckingjsonapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.learning.logincheckingjsonapi")
@EnableWebMvc
public class LoginCheckingJsonApiConfig 
{

}
