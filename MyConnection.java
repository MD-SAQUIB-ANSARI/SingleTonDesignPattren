package com.mypack.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {

	
	private MyConnection()
	//pvt constructer
	{
		
	}
	private static Connection conn;
	
	// ye getconnection method, Connection ka object bna kr return kr dga
	// ye getconnection mre pass ek assa factory method hai, jo Connection interface ka object bna kr apko de rha hai,
	//but deka jaye to, ye getConnection() method , Connection interface ki implemented class ka object bna kr dta hai
	/*public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException
	{
		FileReader fr=new FileReader("C:\\Users\\sagar\\Desktop\\MyConnection1.properties");
		Properties p=new Properties();
		p.load(fr);
		String dname=p.getProperty("driverName");
		String url=p.getProperty("url");
		String uname=p.getProperty("uname");
		String upass=p.getProperty("upass");
		if(conn==null)
		{
			Class.forName(dname);
			conn = DriverManager.getConnection(url, uname, upass);
			System.out.println(" Driver Load Successfully... ");
		}
		return conn;
		
	}*/

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if(conn==null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saquibdb", "root", "saqquib@12345");
			System.out.println("Load driver");
		}
		return conn;
		
	}
}
