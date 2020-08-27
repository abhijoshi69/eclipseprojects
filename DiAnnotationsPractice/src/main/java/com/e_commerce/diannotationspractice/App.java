package com.e_commerce.diannotationspractice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoParent demoParent = context.getBean(DemoChild.class);
        demoParent.greet();
    }
}
