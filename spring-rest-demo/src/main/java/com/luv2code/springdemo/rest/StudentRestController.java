package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void LoadData() {
		theStudents = new ArrayList<>();
		
		
		theStudents.add(new Student("John","Loba"));
		theStudents.add(new Student("Martin","Lopez"));
		theStudents.add(new Student("Michael","Tex"));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		if(studentId < 0 || studentId >= theStudents.size()) {
			throw new StudentNotFoundException("This student is not exist! ->"+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
}
