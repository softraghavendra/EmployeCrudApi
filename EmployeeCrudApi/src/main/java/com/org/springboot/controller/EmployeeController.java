package com.org.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springboot.dao.EmployeeDAO;
import com.org.springboot.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	/* To save an Employee object */
	@PostMapping("/employees")
	public Employee save(@Valid @RequestBody Employee emp){
		return employeeDAO.save(emp);
	}
	
	/* Get all employees */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/* get an employee by employeeId */
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empId){
		Employee emp = employeeDAO.findOne(empId);
		if(emp == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(emp);
	}
	
	/* update an employee */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId, @Valid @RequestBody Employee employeeDetails){
		Employee emp = employeeDAO.findOne(empId);
		if(emp == null)
			ResponseEntity.notFound().build();
		emp.setName(employeeDetails.getName());
		emp.setDesignation(employeeDetails.getDesignation());
		emp.setExpertise(employeeDetails.getExpertise());
		
		Employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	/* delete an employee	 */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){
		Employee emp = employeeDAO.findOne(empId);
		if(emp == null)
			return ResponseEntity.notFound().build();
		employeeDAO.delete(emp);
		return  ResponseEntity.ok().build();
		
	}
}
