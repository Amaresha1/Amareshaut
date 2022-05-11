package com.crm.practice;

import com.crm.comcast.Genericutility.Databaseutility;

public class Sample {

	public static void main(String[] args) throws Throwable 
	{
		Databaseutility db=new Databaseutility();
		db.connecttoDatabase();
		String data = db.executequery("select * from students_info", 2);
		System.out.println(data);
		

	}

}
