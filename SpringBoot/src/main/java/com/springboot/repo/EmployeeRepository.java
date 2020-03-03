package com.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
