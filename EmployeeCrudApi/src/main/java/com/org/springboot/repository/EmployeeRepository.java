package com.org.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
