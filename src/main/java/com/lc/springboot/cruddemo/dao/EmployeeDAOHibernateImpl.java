package com.lc.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lc.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl (EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		//get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		//get employee
		Employee theEmployee = currentSession.get(Employee.class, theId);
				
		//return the results
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		//get employee
		currentSession.saveOrUpdate(theEmployee);
						
	}

	@Override
	public void deleteById(int theId) {
		
		//get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
								
		//create the query
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
