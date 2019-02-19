package com.cts.employeemngt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.employeemngt.beans.Employee;
import com.cts.employeemngt.utils.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO  {
	
	private Connection connection;
	
	public String addEmployee(Employee employee)
	{
		PreparedStatement preparedStatement=null;
		String insertStatement="insert into employee " + "values(?,?,?,?)";
		connection=DBUtils.getConnection();
		try
		{
			connection.setAutoCommit(true);
			preparedStatement=connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmployeeid());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setFloat(4, employee.getSalary());
			
			preparedStatement.executeUpdate();
			return "success";
			
		
		}catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
			try 
			{
				connection.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			return "fail";
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String updateEmployee(String id, Employee employee) {
		
		
		return null;
	}
	@Override
	public String deleteEmployee(String id) {
		// TODO Auto-generated method stub
		String query="delete from employee where employeeid=? ";
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=DBUtils.getConnection();
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			return "success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return "fail";
	}
	
	@Override
	public Employee getEmployee(String id) {
		String query="select * from employee where employeeid=?";
		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection=DBUtils.getConnection();
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				String ID=resultSet.getString("employeeid");
				String firstname = resultSet.getString("firstName");
				String lastname = resultSet.getString("lastName");
				float salary=resultSet.getFloat("salary");
				Employee employee=new Employee(ID,firstname,lastname,salary);
				return employee;
			}
			
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		String query="select * from employee where firstName=?";
		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection=DBUtils.getConnection();
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet=preparedStatement.executeQuery();
			ArrayList<Employee> employees=new ArrayList<>();
			while(resultSet.next())
			{
				String ID=resultSet.getString("employeeid");
				String firstname = resultSet.getString("firstName");
				String lastname = resultSet.getString("lastName");
				float salary=resultSet.getFloat("salary");
				Employee employee=new Employee(ID,firstname,lastname,salary);
				employees.add(employee);
				
				
			}
			return employees;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		String query="select * from employee";
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		
		try {
			connection=DBUtils.getConnection();
			preparedStatement= connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			ArrayList<Employee> employees=new ArrayList<>();
			while(resultSet.next())
			{
				String ID=resultSet.getString("employeeid");
				String firstname = resultSet.getString("firstName");
				String lastname = resultSet.getString("lastName");
				float salary=resultSet.getFloat("salary");
				Employee employee=new Employee(ID,firstname,lastname,salary);
				employees.add(employee);
				
				
			}
			return employees;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	

}
