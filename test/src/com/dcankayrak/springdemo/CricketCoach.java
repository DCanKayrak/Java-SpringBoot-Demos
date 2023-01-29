package com.dcankayrak.springdemo;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
	private String email;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: called no-arg constructor");
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: called setter method constructor");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 min";
	}

	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
