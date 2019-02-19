package com.cts.employeemngt.beans;

public class Employee {
	
	private String employeeid;
	private String firstName;
	private String lastName;
	private float salary;
	
	
	public Employee() 
	{
		super();
	}

	public Employee(String employeeid, String firstName, String lastName, float salary) 
	{
		super();
		this.employeeid = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	
	public String getEmployeeid() {
		return employeeid;
	}
	
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

}
