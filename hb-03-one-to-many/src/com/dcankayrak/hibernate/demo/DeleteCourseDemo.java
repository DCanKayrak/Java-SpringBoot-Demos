package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;

public class DeleteCourseDemo {

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
			
			session.beginTransaction();
			
			// get the course
			int id = 11;
			
			Course tempCourse = session.get(Course.class,id);
			System.out.println(tempCourse);
			session.delete(tempCourse);
			System.out.println("Deleted!");
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
