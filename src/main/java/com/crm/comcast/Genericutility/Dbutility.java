package com.crm.comcast.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.formula.functions.Code;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author acer
 *It contains DB connection method,executequery method,updatequery method,close DB method
 */

public class Dbutility 
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
	    conn=DriverManager.getConnection(IConstants.DBURL,IConstants.DBUSERNAME,IConstants.DBPASSWORD);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		}
	/**
	 * it contains execute query method by passing below parameter
	 * @param query
	 * @return 
	 * @throws Throwable
	 */
	public ResultSet executequery(String query ) throws Throwable
	{
	
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery(query);
	     return resultset;
       }
	public boolean verifydata(String query,int index,String expecteddata) throws Throwable
	{
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(query);
		while(result.next())
		{
			String actualdata = result.getString(index);
			if(actualdata.equals(expecteddata))
			{
				 flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expecteddata+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expecteddata+"==>data is not verified in the database");
			return flag;
		}

	
	}
	/**
	 * It is used to execute Non-sql query
	 * @param query
	 * @return 
	 * @throws Throwable
	 */
	public int updatequery(String query) throws Throwable
	{
		Statement stat = conn.createStatement();
		int out = stat.executeUpdate(query);
		return out;
		}
	/**
	 * It is used to close the DB connection
	 * @throws Throwable
	 */
	public void closeDatabase() throws Throwable
	{ 
		try
		{
			conn.close();
           }
		catch (Exception e) 
		{
			
		}
		}
	}
      		
