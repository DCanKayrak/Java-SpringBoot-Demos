package com.dcankayrak.homework.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dcankayrak.homework.entities.Employee;

public class QueryEmployeeDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Employee> theEmployeeList = session.createQuery("from Employee").getResultList();
		
		for (Employee e : theEmployeeList) {
			System.out.println(e);
		}
		
		session.getTransaction().commit();
		
		session.close();
		
	}
}
