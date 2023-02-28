package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			// start a transaction
			session.beginTransaction();
		
			int id = 9;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("tempInstructorDetail : "+ theInstructorDetail);
			
			System.out.println("tempInstructorDetail's instructor : "+theInstructorDetail.getInstructor());
			
			// remove the associated object reference
			// break bi-directional link
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			
			
			session.delete(theInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
