package com.dcankayrak.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return "Except heavy traffic this morning";
	}
}
