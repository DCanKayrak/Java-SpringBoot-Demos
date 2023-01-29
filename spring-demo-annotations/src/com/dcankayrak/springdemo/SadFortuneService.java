package com.dcankayrak.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a very sadly";
	}

}
