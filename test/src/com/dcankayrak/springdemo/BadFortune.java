package com.dcankayrak.springdemo;

public class BadFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Today you have a bad luck :( Try Again another day.";
	}

}
