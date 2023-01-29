package com.dcankayrak.springdemo;

public class HappyFortune implements FortuneService{

	@Override
	public String getFortune() {
		
		return "U are on good day";
	}
	
}
