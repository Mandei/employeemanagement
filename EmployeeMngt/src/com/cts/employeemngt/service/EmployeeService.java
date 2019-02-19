package com.cts.employeemngt.service;
import java.util.List;

import com.cts.employeemngt.beans.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	public String updateEmployee(String id,Employee employee);
	public String deleteEmployee(String id);
	public Employee getEmployee(String id);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getEmployees();
	
}
