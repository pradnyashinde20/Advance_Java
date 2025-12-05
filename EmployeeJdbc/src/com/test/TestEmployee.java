package com.test;

import java.util.List;
import java.util.Scanner;

import com.bean.Employee;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EmployeeService ser=new EmployeeServiceImpl();
Scanner sc=new Scanner(System.in);
int choice=0;
do {
	System.out.println("1.add new employee\n2.display all employee.\n3.delete employee");
	System.out.println("4.update sal\n5.update name\n6.update date\n7.sort by name\n8.sort by sal");
	System.out.println("enter choice>>>>");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1->{
		boolean status=ser.addNewEmp();
		if(status)
		{
			System.out.println("added successfully");
		}
		else {
			System.out.println("error");
		}
	}
	case 2->{
		List<Employee>li=ser.display();
		li.forEach(System.out::println);
	}
	}
}while(choice!=9);
	}

}
