package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class jdbcnonselect {

	public static void main(String[] args) throws SQLException
	{
		Connection conn = null;
		try {
		// Register/connect to mysql 
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//connect to database
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//create query statement
		Statement sta = conn.createStatement();
		//update db
		 int out= sta.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('7', 'Amaresh','utkur', 'madhwar');");
		}
		 catch (Exception e) 
        {
			System.out.println("handled");
		}	
        finally 
        {
        
        	//close the connection
   		 conn.close();
   			
		}

	}}

