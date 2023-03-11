package com.dcankayrak.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.dcankayrak.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String methodName = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @Around on method : "+methodName);
		// get begin timestamp
		long begin = System.currentTimeMillis();
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		// get end timestamp
		long end = System.currentTimeMillis();
		// compute duration and display it
		long duration = end - begin;
		
		myLogger.info("\n=======> Duration : "+duration / 1000 + " seconds");
		
		return result;
	}
	
	
	
	@After("execution(* com.dcankayrak.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @After(finally) on method : "+methodName);
	}
	
	
	@AfterThrowing(pointcut = "execution (* com.dcankayrak.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterThrowing on method : "+methodName);
		
		myLogger.info("\n======> The exception is : "+theExc);
	}
	
	@AfterReturning(pointcut = "execution (* com.dcankayrak.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========> Executing @AfterReturning on method : "+method);
		
		// print out the result of method call
		myLogger.info("\n========> Result is : "+result);
		
		// Post-Process the data
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			String tempName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(tempName);
		}
		
	}

	@Before("com.dcankayrak.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n=========> Executing @Before Advice on addAccount() ");
		
		
		// display the method signature
		MethodSignature theMethodSig = (MethodSignature)theJoinPoint.getSignature();
		myLogger.info("Method : "+theMethodSig);
		// display method arguments
		Object[] theArgs = theJoinPoint.getArgs();
		
		for (Object item : theArgs) {
			myLogger.info(item.toString());
			
			if(item instanceof Account) {
				Account theAccount = (Account) item;
				
				myLogger.info("account name : "+theAccount.getName());
				myLogger.info("account level : "+theAccount.getLevel());
			}
		}
		
		
	}


}
