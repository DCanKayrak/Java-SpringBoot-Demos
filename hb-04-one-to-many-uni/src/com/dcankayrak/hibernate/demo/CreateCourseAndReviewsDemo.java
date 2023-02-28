package com.dcankayrak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.hibernate.demo.entities.Course;
import com.dcankayrak.hibernate.demo.entities.Instructor;
import com.dcankayrak.hibernate.demo.entities.InstructorDetail;
import com.dcankayrak.hibernate.demo.entities.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// starting the transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			// add some reviews
			tempCourse.addReview(new Review("Greate Course... loved it!"));
			tempCourse.addReview(new Review("Good Job... I loved this course!"));
			tempCourse.addReview(new Review("What a dumb course."));
			
			// save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.save(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}finally {
			factory.close();
		}
	}

}
