package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
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
			int studentId = 19;
			
			//1. start a transaction
			session.beginTransaction();
			
			//find out the student's id: primary key
			Student myStudent2 = session.get(Student.class, studentId);
			
			System.out.println("Get complete: "+myStudent2);
			
			if (myStudent2!=null) {
				System.out.println("Delete student "+myStudent2);
				session.delete(myStudent2);
				
			}
			
			session.createQuery("delete from Student where lastName='Doe'")
			.executeUpdate();
			session.getTransaction().commit();
			
			
			//commit the transaction
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
