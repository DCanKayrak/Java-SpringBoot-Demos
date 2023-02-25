package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Student;

public class PrimaryKeyDemo {

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
					Student tempStudent1 = new Student("Ahmet","Can","ahmetcan@gmail.com");
					Student tempStudent2 = new Student("Mehmet","Özdemir","mozdemir@gmail.com");
					Student tempStudent3 = new Student("Can","Kaya","kayaCan@gmail.com");
					
					// starting the transaction
					session.beginTransaction();
					
					// save the student object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					System.out.println("Saving the student");
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
					
				}finally {
					factory.close();
				}

	}

}
