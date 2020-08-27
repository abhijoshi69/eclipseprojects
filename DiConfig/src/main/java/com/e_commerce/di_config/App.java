package com.e_commerce.di_config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Resource resource = new ClassPathResource("beans.xml");
      BeanFactory factory = new XmlBeanFactory(resource);
      //DemoClass demoClass = (DemoClass)factory.getBean("demoBean");
      //demoClass.showMsg();
    
      DemoP demoP = (DemoP)factory.getBean("demoC1");
      demoP.greet();
    }
}
