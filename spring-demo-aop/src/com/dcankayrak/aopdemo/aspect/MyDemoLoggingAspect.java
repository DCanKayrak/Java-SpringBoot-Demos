package com.dcankayrak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// @Before("execution(public void com.dcankayrak.aopdemo.dao.AccountDAO.addAccount())")
	// This code will execute for only AccountDAO class
	
	//@Before("execution(public void addAccount())")
	// This code will execute for any class on addAccount method 
	
	//@Before("execution(public void add*())")
	
	//@Before("execution(void add*())")
	
	//@Before("execution(* add*(com.dcankayrak.aopdemo.Account, ..))")
	
	@Before("execution(* com.dcankayrak.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=========> Executing @Before Advice on addAccount() ");
	}
}
