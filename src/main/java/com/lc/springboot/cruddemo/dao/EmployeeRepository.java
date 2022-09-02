package com.lc.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lc.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
