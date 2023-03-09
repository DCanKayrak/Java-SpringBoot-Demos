package com.dcankayrak.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dcankayrak.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.dcankayrak.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=========> Executing @Before Advice on addAccount() ");
		
		
		// display the method signature
		MethodSignature theMethodSig = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method : "+theMethodSig);
		// display method arguments
		Object[] theArgs = theJoinPoint.getArgs();
		
		for (Object item : theArgs) {
			System.out.println(item);
			
			if(item instanceof Account) {
				Account theAccount = (Account) item;
				
				System.out.println("account name : "+theAccount.getName());
				System.out.println("account level : "+theAccount.getLevel());
			}
		}
		
		
	}


}
