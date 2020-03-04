package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee findEmployeeById(String id) {
		logger.info("Get an employee by employee id-service-start");
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("Get all employee-service-start");
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee createEmployee(Employee entity) {
		logger.info("Create employee-service-start");
		/*
		 * Optional<Employee> employee = employeeRepository.findById(entity.getId()); if
		 * (employee.isPresent()) { Employee newEntity = employee.get();
		 * newEntity.setFirstname(entity.getFirstname());
		 * newEntity.setLastname(entity.getLastname());
		 */

		Employee employee = employeeRepository.save(entity);
		logger.info("Create employee-service-end");
		return employee;
	}

	public void deleteEmployeeById(String id) {
		logger.info("Delete employee-service-start");
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {

		}
		logger.info("Delete employee-service-end");
	}

	@Override
	public Employee updateEmployee(Employee entity) {
		logger.info("Update employee-service-start");
		Optional<Employee> employee = employeeRepository.findById(entity.getId());
		if (employee.isPresent()) {
			Employee newEntity = employee.get();
			newEntity.setFirstname(entity.getFirstname());
			newEntity.setLastname(entity.getLastname());
			Employee emp = employeeRepository.save(newEntity);
			return emp;
		} else {
			return null;
		}

	}

}
