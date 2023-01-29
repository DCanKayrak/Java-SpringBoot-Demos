package com.dcankayrak.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimPropertiesDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeamName());
		
		context.close();
	}

}
