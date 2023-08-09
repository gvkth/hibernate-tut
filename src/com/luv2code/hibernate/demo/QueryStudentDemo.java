package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			//use the session object to save Java object
			
			//1. start a transaction
			session.beginTransaction();
			
			//2. query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//3. display students
			for (Student tempStudent: theStudents) {
				System.out.println(tempStudent);
			}
			
			
			//4. commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}