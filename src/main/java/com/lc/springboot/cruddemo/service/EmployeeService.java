package com.lc.springboot.cruddemo.service;

import java.util.List;

import com.lc.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById();

}
