package com.lc.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lc.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	public EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Employee dbEmployee = entityManager.merge(theEmployee);

		//update with id from db
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		//delete object with primary key
		Query theQuery = entityManager.createQuery("delete from Employee where id:=employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}