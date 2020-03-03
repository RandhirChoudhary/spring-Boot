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
	public Employee findEmployeeByAId(String id) {
		logger.info("get an employee by employee id-service");
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("get all employee-service");
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee createOrUpdateEmployee(Employee entity) {
		logger.info("create employee-service");
		Optional<Employee> employee = employeeRepository.findById(entity.getId());
		if (employee.isPresent()) {
			Employee newEntity = employee.get();
			newEntity.setFirstname(entity.getFirstname());
			newEntity.setLastname(entity.getLastname());
			

			newEntity = employeeRepository.save(newEntity);

			return newEntity;
		} else {
			entity = employeeRepository.save(entity);

			return entity;
		}
	}

}
