package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statements {

	public static void main(String agrs[])
	{
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117:3306/dac85?useSSL=false";
			con=DriverManager.getConnection(url,"dac85","welcome");
			if(con!=null)
			{
				System.out.println("connection done");
			}
			else {
				System.out.println("connection not done");
			}
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from dept");
			while(rs.next())
			{
				System.out.println("deptno"+rs.getInt(1));
				System.out.println("name"+rs.getString(2));
				System.out.println("loc"+rs.getString(3));
				System.out.println("password"+rs.getString(4));
				System.out.println("=============");
			}
			
			int deptno=70;
			String dname="sales";
			String loc="pune";
			String pwd="123435";
			String startedon="10/02/2025";
			String query="insert into dept values("+deptno+",'"+dname+"','"+loc+"','"+pwd+"','"+startedon+")";
			System.out.println(query);
			int n=st.executeUpdate(query);
			if(n>0)
			{
				System.out.println("insertion done");
			}
			else {
				System.out.println("error");
			}
			
			
		}
		catch(SQLException e){
			
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
				
			}
		}
	}
}
