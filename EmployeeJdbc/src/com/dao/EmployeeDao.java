package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeDao {

	boolean save(Employee e);

	List<Employee> display();

}
