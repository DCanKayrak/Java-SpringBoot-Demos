package com.dcankayrak.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	// ilk çalışacak metod
	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
		coursePrefix = theCourseCode.value(); // prefix'imiz Annotationdaki default değere eşitlenmiş oldu.
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		
		return result;
	}



}
