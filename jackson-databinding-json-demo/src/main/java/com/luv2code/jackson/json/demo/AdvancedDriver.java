package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AdvancedDriver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			// read JSON file and map/convert to Java POJO
			// data sample-lite.json
			Student tempStudent = mapper.readValue(new File("data/sample-full.json"),Student.class);
			
			System.out.println("Student First Name : "+tempStudent.getFirstName());
			System.out.println("Student Last Name : "+tempStudent.getLastName());
			
			Address tempAddress = tempStudent.getAddress();
			
			System.out.println("City : "+tempAddress.getCity());
			System.out.println("Country : "+tempAddress.getCountry());
			
			for (String language : tempStudent.getLanguages()) {
				System.out.println(language);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
