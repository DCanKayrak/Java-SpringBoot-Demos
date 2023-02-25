package com.dcankayrak.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// starting the transaction
			session.beginTransaction();
			
			// Query Students
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			// display the list
			for (Student s : studentList) {
				System.out.println(s);
			}
			
			// query student: lastName = "Duck"
			studentList = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			// display the list
						for (Student s : studentList) {
							System.out.println(s);
						}
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
