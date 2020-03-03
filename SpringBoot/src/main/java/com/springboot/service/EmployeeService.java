package com.springboot.service;

import java.util.List;

import com.springboot.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee createOrUpdateEmployee(Employee employee);
	Employee findEmployeeByAId(String id);
	public void deleteEmployeeById(String id);
}
