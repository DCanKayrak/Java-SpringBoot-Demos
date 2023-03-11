	package com.dcankayrak.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dcankayrak.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main program : AroundDemoApp");
		myLogger.info("Calling getFortune method");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("My fortune is : "+data);
		
		myLogger.info("Finished");
		
		
		
		// close the context
		context.close();
	}

}
