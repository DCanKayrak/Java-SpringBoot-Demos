package com.dcankayrak.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	@AfterReturning(pointcut = "execution (* com.dcankayrak.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Executing @AfterRuning on method : "+method);
		
		// print out the result of method call
		System.out.println("\n========> Result is : "+result);
		
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
