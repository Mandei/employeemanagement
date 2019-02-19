package com.cts.employeemngt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static final String url= "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String driverName="oracle.jdbc.driver.OracleDriver";
	public static final String userName="hr";
	public static final String password="hr";
	
	public static Connection getConnection()
	{
	Connection connection=null;
	try
	{
		Class.forName(driverName);  //class is class in java ,forName to load any class dynamically
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	
	} catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}catch(SQLException e1)
	{
		e1.printStackTrace();
	}
	
		return null;
	
	}
	
	public static void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
