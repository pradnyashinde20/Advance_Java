package com.bean;

import java.time.LocalDate;

public class Employee {
	private int eid;
	private String ename;
	private double sal;
	private LocalDate date;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, double sal, LocalDate date) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.date = date;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", date=" + date + "]";
	}
	

}
