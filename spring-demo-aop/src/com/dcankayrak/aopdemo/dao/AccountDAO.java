package com.dcankayrak.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.dcankayrak.aopdemo.Account;

@Component // for find the class with componentscan
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	public boolean doWork() {
		System.out.println(getClass()+" : DOWORK()");
		return false;
	}
}
