package com.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {

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
		//execute query
		 ResultSet out = sta.executeQuery("select * from students_info;");
		 while(out.next())
		 {
			 System.out.println(out.getInt(1)+" "+out.getString(2)+" "+out.getString(3)+" "+out.getString(4));
		 }}
        catch (Exception e) 
        {
			System.out.println("handled");
		}	
        finally 
        {
        	//close the connection
   		 conn.close();
   			
		}
		 
	}

}
