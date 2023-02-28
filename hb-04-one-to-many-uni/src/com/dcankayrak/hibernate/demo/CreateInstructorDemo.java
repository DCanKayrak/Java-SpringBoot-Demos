package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			/*
			 * Instructor tempInstructor = new
			 * Instructor("Danyal Can","KAYRAK","dancankan@gmail.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("http://www.dcankayrak.com/youtube","Love to code");
			 */
			
Instructor tempInstructor = new Instructor("Susan","Public","susan-public@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// starting the transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note : this will also save the details object
			// because of Cascade.ALL
			session.save(tempInstructor);
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
