package com.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
private EmployeeDao edao;
Scanner sc=new Scanner(System.in);
	public EmployeeServiceImpl() {
	edao=new EmployeeDaoImpl();
}

	@Override
	public boolean addNewEmp() {
		// TODO Auto-generated method stub
		System.out.println("enter the emp id::");
		int id=sc.nextInt();
		System.out.println("enter the emp name::");
		String name=sc.nextLine();
		sc.next();
		System.out.println("enter the salary::");
		double sal=sc.nextDouble();
		System.out.println("enter the date of joining::");
		String date=sc.next();
		LocalDate dt=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Employee e=new Employee(id,name,sal,dt);
		return edao.save(e);
	}

	@Override
	public List<Employee> display() {
		// TODO Auto-generated method stub
		return edao.display();
	}

}
