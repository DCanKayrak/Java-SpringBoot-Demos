package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int id = 3;
			
			session.beginTransaction();
		
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Found Instructor :"+tempInstructor);
			
			// delete the instructor
			if(tempInstructor != null) {
				System.out.println("Deleting : "+tempInstructor);
				
				// Note : This will delete the details with it.
				// 'Cause CascadingStyle.ALL 
				session.delete(tempInstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
