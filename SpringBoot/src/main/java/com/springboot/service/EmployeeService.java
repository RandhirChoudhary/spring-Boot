package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	Employee findEmployeeById(String id);
	public Employee updateEmployee(Employee entity);
	public void deleteEmployeeById(String id);
}
