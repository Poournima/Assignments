package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {
	private List<Employee> employeeList =new ArrayList<>();
	Employee employee1;
	public boolean addNewEmployee(Employee employee) {
		employeeList.add(employee);
		return false;
		
	}
	public boolean addAllEmployees(Employee[] employee)
	{
		for(Employee employees:employee) {
			addNewEmployee(employees);
		}
		return true;
		
	}
	
	public boolean updateEmployeeSalary(int employeeId,double newSalary) {
		for(Employee employees:employeeList) {
			if(employees.getEmployeeId()==employeeId) {
				employees.setEmployeeId(employeeId);
				employees.setSalary(newSalary);
				return true;
			}
		}
		return false;
		
	}
	public boolean deleteEmployee(int employeeId) {
		for(Employee employees : employeeList) {
			if(employees.getEmployeeId()==employeeId) {
				employeeList.remove(employees);
				return true;
			}
		}
		
		return false;
		
	}
	public Employee getEmployeeByEmployeeId(int employeeId) {
		for(Employee employees : employeeList) {
			if(employees != null) {
				if(employees.getEmployeeId() == employeeId) 
					return employees;
				
			}
		}
		return null;
		
	}
	public List<Employee> getAllEmployees(){
		return employeeList;
	}
}
