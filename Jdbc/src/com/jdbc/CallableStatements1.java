package com.jdbc;

import java.sql.*;

public class CallableStatements1 {

	public static void main(String[] args) {
		 Connection conn = null;
		try {
	
	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://192.168.10.117:3306/dac85?useSSL=false";
		conn=DriverManager.getConnection(url,"dac85","welcome");
		CallableStatement cst = conn.prepareCall("call pro3(?,?,?)");
		cst.setInt(1, 10);
		cst.setInt(2, 20); 
		cst.registerOutParameter(3, java.sql.Types.INTEGER);
		cst.execute();
		int res = cst.getInt(3);
		System.out.println("result: "+res);

		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	 

	}

}
