package com.dcankayrak.homework.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.homework.entities.Employee;

public class UpdateEmployeeDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		int id = 1;
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee theEmployee = session.get(Employee.class,id);
		
		theEmployee.setFirstName("Ahmet");
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
