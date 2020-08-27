package com.e_commerce.projectinjection;

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
        DemoParent demoParent = (DemoParent)context.getBean("demoBean");
        demoParent.watch();
    }
}
