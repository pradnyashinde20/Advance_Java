package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee>lt=new LinkedList<>();
	static Connection con;
	static PreparedStatement instemp,display;
	static {
	try {
		con=DbConnection.getConnection();
		instemp=con.prepareStatement("insert into emp values(?,?,?,?");
		display=con.prepareStatement("select * from emp");
	}catch(SQLException e)
	{
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	}
	@Override
	public boolean save(Employee e) {
		// TODO Auto-generated method stub
		try {
			instemp.setInt(1,e.getEid());
			instemp.setString(2, e.getEname());
			instemp.setDouble(3, e.getSal());
			instemp.setDate(4, java.sql.Date.valueOf(e.getDate()));
			int n=instemp.executeUpdate();
			return n>0;
		}catch(SQLException e1)
		{
			System.out.println(e1.getMessage());
		}
		
		return false;
	}
	@Override
	public List<Employee> display() {
	List<Employee>li=new ArrayList<>();
	try {
		ResultSet rs=display.executeQuery();
		
	}
	
		return null;
	}
}


