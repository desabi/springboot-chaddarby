package com.desabisc.udemy.chad.employees.crud.dao;

import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members") // localhost:8080/magic-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
