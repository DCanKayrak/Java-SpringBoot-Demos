package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;

public class CreateCoursesDemo {

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
			// starting the transaction
			session.beginTransaction();
			
			// get instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			// Create some courses
			Course tempCourse1 = new Course("Math");
			Course tempCourse2 = new Course("Music");
			
			// add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
