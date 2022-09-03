package com.lc.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lc.springboot.cruddemo.entity.Employee;
import com.lc.springboot.cruddemo.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel){
		
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
/*
	@GetMapping("/employees/{employeeId}")
	public Employee findEmployee(@PathVariable int employeeId){

		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){

		theEmployee.setId(0);

		employeeService.save(theEmployee);

		return theEmployee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){

		employeeService.save(theEmployee);

		return theEmployee;

	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){

		Employee theEmployee = employeeService.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id: " + employeeId + " not found");
		}

		employeeService.deleteById(employeeId);

		return "Deleted employee id " + employeeId;

	}
*/

}