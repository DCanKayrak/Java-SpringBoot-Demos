package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;
import com.dcankayrak.hibernate.demo.entities.Review;
import com.dcankayrak.hibernate.demo.entities.Student;

public class AddCoursesForMaryDemo {

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

			// Create a course
			Course tempCourse = new Course("Pacman");
			
			//save the course
			System.out.println("\nSaving the course");
			session.save(tempCourse);
			System.out.println("Saved The Course : "+tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Can","KAYA","dancankan@gmail.com");
			Student tempStudent2 = new Student("Ahmetcan","KAYA","acankaya@gmail.com");
			
			// add students to course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("Saving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved the students : "+tempCourse.getStudents());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
