package com.dcankayrak.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Shoot to goalkeeper.";
	}

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
