package com.dcankayrak.homework.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.homework.entities.Employee;

public class DeleteEmployeeDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		int id = 1;
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee theEmp = session.get(Employee.class,id);
		
		session.delete(theEmp);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
