package com.org.springboot.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.springboot.model.Employee;
import com.org.springboot.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	/* To save an employee */
	public Employee save(Employee emp){
		return employeeRepository.save(emp);
	}
	
	/* Search all employee*/
	public List<Employee> findAll(){
		return employeeRepository.findAll();		
	}
	
	/* get employee by id */
	public Employee findOne(Long id){
		return employeeRepository.findOne(id);
	}
	
	/* delete an employee */
	public void delete(Employee emp){
		employeeRepository.delete(emp);
	}
	
}
