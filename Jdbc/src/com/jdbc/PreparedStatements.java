package com.jdbc;

import java.sql.*;
import java.time.LocalDate;

public class PreparedStatements {
	
	public static void main(String [] args) {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.117:3306/dac85?useSSL=false";
			conn= DriverManager.getConnection(url,"dac85","welcome");
			PreparedStatement pst = conn.prepareStatement("select * from students");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("student id: "+rs.getInt(1));
				System.out.println("student name: "+rs.getString(2));
				System.out.println("student city: "+rs.getString(3));
				System.out.println("student marks: "+rs.getDouble(4));
				System.out.println("student date of admission: "+rs.getDate(5));
				System.out.println(".................................");
			}
			PreparedStatement pst1 = conn.prepareStatement("insert into students values(?,?,?,?,?)");
			int studentno = 13;
			String name = "sam";
			String city = "satara";
			double marks = 67;
			LocalDate ldt = LocalDate.now();
			String sqldate = ldt.toString();
			pst1.setInt(1, studentno);
			pst1.setString(2, name);
			pst1.setString(3, city);
			pst1.setDouble(4, marks);
			pst1.setString(5, sqldate);
			
			int n = pst1.executeUpdate();
			if(n>0) {
				System.out.println("insertion done");
			}else {
				System.out.println("error!! not inserted");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
