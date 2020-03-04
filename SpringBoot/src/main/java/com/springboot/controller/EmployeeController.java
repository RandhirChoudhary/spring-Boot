package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
//@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	
	/*@GetMapping("/api/employees")
	public ResponseEntity<List<Employee>> getAllCustomerDetails() {

		List<Employee> customerDetaillist = employeeService.getAllEmployees();

		return ResponseEntity.ok().body(customerDetaillist);

	}*/

	@GetMapping("/api/{id}")
	public ResponseEntity<Employee> findById(@PathVariable String id) {
		logger.info("Get an employee by employee id-controller");
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/api/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Get all employee-controller");
		List<Employee> employeeList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@PostMapping("/api/create")
	public ResponseEntity<Employee> createEmployee(Employee entity) {
		logger.info("Create an employee-controller-start");
		Employee createEmployee = employeeService.createEmployee(entity);
		return new ResponseEntity<Employee>(createEmployee, HttpStatus.OK);

	}
	@DeleteMapping("/api/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") String id) {
		logger.info("Delete an employee-controller-start");
		employeeService.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
	@PutMapping("/api/update")
	public ResponseEntity<Employee> updateEmployee(Employee entity){
		logger.info("Update an employee-controller-start");
		Employee updated=employeeService.updateEmployee(entity);
		return ResponseEntity.ok().body(updated);
		
	}

}
