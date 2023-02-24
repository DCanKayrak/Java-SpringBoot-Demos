package com.dcankayrak.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // temel aldığı sınıfı belirtmek için
@Target({ElementType.METHOD,ElementType.FIELD}) // kullanılacağı yerleri belirlemek için
@Retention(RetentionPolicy.RUNTIME) // Runtime'da çalıştırmak için
public @interface CourseCode {
	
	// @CourseCode(value = "") kısmı => default kurs olarak atadık.
	public String value() default "KURS";
	
	// @CourseCode(value = ... , message = "...") kısmı => default tanımladık.
	public String message() default "must start with KURS";
	
	// default grup tanımladık.
	public Class<?>[] groups() default {};
	
	// payloads tanımladık.
	public Class<? extends Payload>[] payload() default {};
	
}
