package com.dcankayrak.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dcankayrak.aopdemo.Account;

@Component // for find the class with componentscan
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	public boolean doWork() {
		System.out.println(getClass()+" : DOWORK()");
		return false;
	}
	public String getName() {
		System.out.println(getClass()+" : in getName()");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+" : in setName()");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass()+" : in getServiceCode()");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("No soup for u");
		}
		
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1 = new Account("Jhon","Silver");
		Account temp2 = new Account("Emma","Gold");
		Account temp3 = new Account("Thomas","Diamond");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
}
