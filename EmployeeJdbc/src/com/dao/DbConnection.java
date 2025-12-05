package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
static Connection con=null;
public static Connection getConnection()
{
	if(con==null)
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			con=DriverManager.getConnection(url,"dac85","welcome");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	return con;
}
}
