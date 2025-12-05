package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn=null;
	public static Connection getConnection()
	{
		if(conn==null)
		{
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.117:3306/dac85?useSSL=false";
				conn=DriverManager.getConnection(url,"dac85","welcome");
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return conn;
	}
	

}
