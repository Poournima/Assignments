package com.montran.pojo;

public class Employee {
	private int EmployeeId;
	private String name;
	private double salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String name, double salary) {
		super();
		EmployeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", name=" + name + ", salary=" + salary + "]";
	}
	

}
