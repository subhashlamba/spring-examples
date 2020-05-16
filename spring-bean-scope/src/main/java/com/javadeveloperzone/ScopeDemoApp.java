package com.javadeveloperzone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemoApp
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext(new String[] {"Spring-Customer.xml"});

    	ScopeDemoService serviceA = (ScopeDemoService)context.getBean("scopeDemoService");
    	System.out.println("ServiceA Object : " + serviceA);
    	
    	//retrieve it again
    	ScopeDemoService serviceB = (ScopeDemoService)context.getBean("scopeDemoService");
    	System.out.println("ServiceB Object : " + serviceB);
    }
}
