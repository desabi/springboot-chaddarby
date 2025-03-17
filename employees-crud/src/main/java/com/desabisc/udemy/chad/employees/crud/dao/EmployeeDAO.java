package com.desabisc.udemy.chad.employees.crud.dao;

import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
  List<Employee> findAll();
  Employee findById(int theId);
  Employee save(Employee theEmployee);
  void deleteById(int theId);
}
