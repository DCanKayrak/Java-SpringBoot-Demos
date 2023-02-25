package com.dcankayrak.homework.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.homework.entities.Employee;

public class CreateEmployeeDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Employee theEmployee = new Employee("Ahmet","Kaya","A101");
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(theEmployee);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
