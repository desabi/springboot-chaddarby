package com.desabisc.udemy.chad.employees.crud.service;

import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import java.util.List;

public interface EmployeeService {
  List<Employee> findAll();
  Employee findById(int theId);
  Employee save(Employee theEmployee);
  void deleteById(int theId);
}
