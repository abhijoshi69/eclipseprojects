package com.e_commerce.injectiondemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       DemoClass demoClass = (DemoClass)context.getBean("demoBean");
       demoClass.showMsg();
    }
}
