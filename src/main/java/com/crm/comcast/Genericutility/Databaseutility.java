package com.crm.comcast.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Databaseutility 
{
	Connection conn=null;
    /**
     * It conatins connectto database method
     * @throws Throwable
     */
	public void connecttoDatabase() throws Throwable
	{
		try {
		Driver driver=new Driver();
	    DriverManager.registerDriver(driver);
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		}
		finally 
		{
			try {
				}
			catch (Exception e) 
			{
				conn.close();
			}			
		}
		}
	/**
	 * it contains execute query method by passing below parameter
	 * @param query
	 * @return 
	 * @throws Throwable
	 */
	public String executequery(String query,int index ) throws Throwable
	{
	      String data=null;
		try {
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery(query);
	     while(resultset.next())
	     {
	    	 data=resultset.getString(index);
	     }
		}
		finally 
		{
			try {	
			}
			catch (Exception e)
			{
				conn.close();
			}
			
		}
		return data;
	   

}
	public int updatequery(String query) throws Throwable
	{
		try 
		{
		Statement stat = conn.createStatement();
		int out = stat.executeUpdate(query);
		return out;
		}
		finally
		{
			try
			{	
			}
			catch (Exception e)
			{
				conn.close();	
			}
		}
		
		}
	public void closeDatabase() throws Throwable
	{ 
		try {
			
		}
		finally {
			conn.close();
		}
		
		}
}
