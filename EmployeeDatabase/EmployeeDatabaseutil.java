package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeDatabaseutil {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "montran";
	String password = "montran";
	String sql = "";
	PreparedStatement insertPreparedStatement;
	PreparedStatement updatePreparedStatement;
	PreparedStatement deletePreparedStatement;
	ResultSet resultSet;
	Statement statement;
	Connection connection;
	private List<Employee> employeeList = new ArrayList<>();
	Employee employee1;

	public EmployeeDatabaseutil() {
		try {
			Class.forName(driver);
			System.out.println("Driver loaded successfully.");
			connection = DriverManager.getConnection(url, user, password);
			insertPreparedStatement = connection.prepareStatement("insert into employee_master values(?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean addNewEmployee(Employee employee) throws SQLException {

		// sql = "insert into employee_master values(?,?,?)";
		insertPreparedStatement.setInt(1, employee.getEmployeeId());
		insertPreparedStatement.setString(2, employee.getName());
		insertPreparedStatement.setDouble(3, employee.getSalary());
		insertPreparedStatement.executeUpdate();

		return false;

	}

	public boolean addAllEmployees(Employee[] employee) throws SQLException {
		for (Employee employees : employee) {
			addNewEmployee(employees);
		}
		return true;

	}

	public boolean updateEmployeeSalary(int employeeId, double newSalary, String name) throws SQLException {
		for (Employee employees : employeeList) {
			if (employees.getEmployeeId() == employeeId) {
				sql = "update employee_master set name=? , salary=? where employee_id=?";
				updatePreparedStatement = connection.prepareStatement(sql);
				updatePreparedStatement.setString(1, name);
				updatePreparedStatement.setDouble(2, newSalary);
				updatePreparedStatement.setInt(3, employeeId);
				updatePreparedStatement.executeUpdate();

				return true;
			}
		}
		return false;

	}

	public boolean deleteEmployee(int employeeId) throws SQLException {
		for (Employee employees : employeeList) {
			if (employees.getEmployeeId() == employeeId) {
				sql = "delete from employee_master where employee_id = ?";
				deletePreparedStatement = connection.prepareStatement(sql);
				deletePreparedStatement.setInt(1, employeeId);
				deletePreparedStatement.executeUpdate();

				return true;
			}
		}

		return false;

	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employees : employeeList) {
			if (employees != null) {
				if (employees.getEmployeeId() == employeeId)
					return employees;

			}
		}
		return null;

	}

	public List<Employee> getAllEmployees() throws SQLException {
		sql = "select * from employee_master order by employee_id";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			employee1 = new Employee();
			employee1.setEmployeeId(resultSet.getInt("employee_id"));
			employee1.setName(resultSet.getString("name"));
			employee1.setSalary(resultSet.getDouble("salary"));
			employeeList.add(employee1);
		}

		return employeeList;

	}

}
