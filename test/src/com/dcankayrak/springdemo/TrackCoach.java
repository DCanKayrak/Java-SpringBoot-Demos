package com.dcankayrak.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	public void doMyStartupStuff() {
		System.out.println("doMyStartupStuff");
	}
	public void doMyCleanupStuff() {
		System.out.println("doMyCleanupStuff");
	}

}
