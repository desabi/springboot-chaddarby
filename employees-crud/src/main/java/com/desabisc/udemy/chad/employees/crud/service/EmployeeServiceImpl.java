package com.desabisc.udemy.chad.employees.crud.service;

import com.desabisc.udemy.chad.employees.crud.dao.EmployeeRepository;
import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int theId) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(theId);

    Employee employee = null;
    if (optionalEmployee.isPresent()) {
      employee = optionalEmployee.get();
    } else {
      throw new RuntimeException("Dis not find employee id - " + theId);
    }

    return employee;
  }

  @Override
  public Employee save(Employee theEmployee) {
    return employeeRepository.save(theEmployee);
  }

  @Override
  public void deleteById(int theId) {
    employeeRepository.deleteById(theId);
  }

}
