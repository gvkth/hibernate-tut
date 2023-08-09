package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
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
			
			//1. create a student object
			System.out.println("Creating new student object ...");
			Student tempStudent = new Student("Mary","Doe","john@luv2code.com");
			Student tempStudent2 = new Student("John","Doe","john@luv2code.com");
			Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");
			Student tempStudent4= new Student("Hat","Duck","Duck@luv2code.com");
			
			//2. start a transaction
			session.beginTransaction();
			
			//3. save the student object
			System.out.println("Saving the student..");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			
			//4. commit transaction
			//session.getTransaction().commit();
			
			
			//MY NEW CODE: READ
			
			//find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+tempStudent.getId());
			
			
			//now get a new session and start transaction
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:"+tempStudent.getId());
			
			Student myStudent2 = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+myStudent2);
			
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
