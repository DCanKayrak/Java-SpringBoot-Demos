package com.dcankayrak.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dcankayrak.aopdemo.dao.AccountDAO;
import com.dcankayrak.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembership = context.getBean("membershipDAO",MembershipDAO.class);
		Account theAccount = new Account();
		
		// call the business method
		theAccountDAO.addAccount(theAccount,true);
		
		theAccountDAO.doWork();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		theMembership.addSillyMember();
		theMembership.goToSleep();
		
		// close the context
		context.close();
	}

}
