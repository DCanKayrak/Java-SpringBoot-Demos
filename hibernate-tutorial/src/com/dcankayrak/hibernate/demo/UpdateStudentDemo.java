package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student");
			Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");
			
			// starting the transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
						
			//commit transaction
			session.getTransaction().commit();
			
			// new codes
			
			
			// find out the primary key : student id
			System.out.println("Saved Student. Generated Id : "+tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting Student with id : "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(myStudent);
			
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
