package com.dcankayrak.homework.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.homework.entities.Employee;

public class ReadEmployeeDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		int id = 2;
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee emp = session.get(Employee.class, id);
		
		System.out.println("The employee : " + emp);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
