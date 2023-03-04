package com.dcankayrak.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dcankayrak.aopdemo.dao.AccountDAO;
import com.dcankayrak.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccount = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembership = context.getBean("membershipDAO",MembershipDAO.class);
		Account theAccountt = new Account();
		
		// call the business method
		theAccount.addAccount(theAccountt,true);
		
		theAccount.doWork();
		
		theMembership.addSillyMember();
		theMembership.goToSleep();
		
		// close the context
		context.close();
	}

}
