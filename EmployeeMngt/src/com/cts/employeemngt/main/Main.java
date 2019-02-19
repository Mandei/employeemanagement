package com.cts.employeemngt.main;

import com.cts.employeemngt.beans.Employee;
import com.cts.employeemngt.service.EmployeeService;
import com.cts.employeemngt.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		EmployeeService employeeservice=new EmployeeServiceImpl();
		
		
		
		
		//String result;
		//result=employeeservice.deleteEmployee("200");
		//Employee employee=new Employee("200","Mandeep","Singh",600);
		//employeeservice.addEmployee(employee);
		 
		Employee employee=employeeservice.getEmployee("200");
		
		/*if("success".equals(result))
				System.out.println("record deleted succesfully");
		  else
				System.out.println("failure");*/
		
				
		
		if(employee!=null)
		{
		System.out.println("Emp id    : "+employee.getEmployeeid());
		System.out.println("First Name: "+employee.getFirstName());
		System.out.println("Last Name : "+employee.getLastName());
		}
		else
			System.out.println("failure");
		
		
		
	
	}
}
