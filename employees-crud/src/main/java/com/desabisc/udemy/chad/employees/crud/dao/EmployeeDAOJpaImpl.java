package com.desabisc.udemy.chad.employees.crud.dao;

import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

  // define a field for entity manager
  private EntityManager entityManager;

  // set up constructor injection
  // Here, EntityManager is automatically created by Spring Boot.
  @Autowired
  public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
    this.entityManager = theEntityManager;
  }

  @Override
  public List<Employee> findAll() {
    // create a query
    TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

    // execute query and get result list
    List<Employee> employees = theQuery.getResultList();

    // return the results
    return employees;
  }

  @Override
  public Employee findById(int theId) {
    Employee theEmployee = entityManager.find(Employee.class, theId);
    return theEmployee;
  }

  @Override
  public Employee save(Employee theEmployee) {
    // if id of the employee is zero, then insert/save
    // else, update that employee
    Employee dbEmployee = entityManager.merge(theEmployee);
    return dbEmployee;
  }

  @Override
  public void deleteById(int theId) {
    // find the employee by id
    Employee theEmployee = entityManager.find(Employee.class, theId);

    // remove employee
    entityManager.remove(theEmployee);
  }
}
