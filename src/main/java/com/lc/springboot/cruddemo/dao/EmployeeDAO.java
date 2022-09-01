package com.lc.springboot.cruddemo.dao;

import java.util.List;

import com.lc.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
