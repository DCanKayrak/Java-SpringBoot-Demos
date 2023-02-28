package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;
import com.dcankayrak.hibernate.demo.entities.Review;
import com.dcankayrak.hibernate.demo.entities.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// starting the transaction
			session.beginTransaction();
			
			int id = 2;
			Student tempStudent = session.get(Student.class,id);
			
			Course tempCourse1 = new Course("Biologie");
			Course tempCourse2 = new Course("Geography");
			Course tempCourse3 = new Course("Physic");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}
