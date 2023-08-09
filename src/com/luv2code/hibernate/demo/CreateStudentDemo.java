package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
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
			Student tempStudent = new Student("Paul","Wall","paul@luv2code.com");
			
			//2. start a transaction
			session.beginTransaction();
			
			//3. save the student object
			System.out.println("Saving the student..");
			session.save(tempStudent);
			
			try {
				Date theDateOfBirth=DateUtils.parseDate("13/02/1998");
				Student tempStudent2 = new Student("Nam","Nguyễn","namnguye@gmail.com",theDateOfBirth);
				session.save(tempStudent2);
			}catch(ParseException pe) {
				
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
