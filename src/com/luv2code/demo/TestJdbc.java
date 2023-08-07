package com.luv2code.demo;

import java.sql.DriverManager;



public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("Connecting to database: "+jdbcUrl);
			java.sql.Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successfull!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
