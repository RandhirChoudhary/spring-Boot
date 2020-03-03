package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getAllCustomerDetails() {

		List<Employee> customerDetaillist = employeeService.getAllEmployees();

		return ResponseEntity.ok().body(customerDetaillist);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable String id) {
		logger.info("get an employee by employee id-controller");
		Employee employee = employeeService.findEmployeeByAId(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("get all employee-controller");
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> createOrUpdateEmployee(Employee entity) {
		logger.info("create an employee-controller");
		Employee updated = employeeService.createOrUpdateEmployee(entity);
		return new ResponseEntity<Employee>(updated, HttpStatus.OK);

	}

}
