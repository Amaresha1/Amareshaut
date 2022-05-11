package com.crm.practice;

import java.sql.ResultSet;

import com.crm.comcast.Genericutility.Dbutility;

public class jdbcdata {

	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
        Dbutility db=new Dbutility();
        db.connecttoDatabase();
		/*
		 * ResultSet s = db.executequery("select * from students_info"); while(s.next())
		 * {
		 * System.out.println(s.getString(1)+" "+s.getString(2)+" "+s.getString(3)+" "+s
		 * .getString(4)); }
		 */
       
        int result = db.updatequery("insert into students_info values('9','Amar','u','mdr');");
        System.out.println(result);
        db.closeDatabase();
        
	}

}
