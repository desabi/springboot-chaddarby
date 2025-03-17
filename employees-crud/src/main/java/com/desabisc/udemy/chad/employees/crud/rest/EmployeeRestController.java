package com.desabisc.udemy.chad.employees.crud.rest;

import com.desabisc.udemy.chad.employees.crud.entity.Employee;
import com.desabisc.udemy.chad.employees.crud.service.EmployeeService;
import java.util.List;
import java.util.Objects;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployee(@PathVariable int employeeId) {
    Employee theEmployee = employeeService.findById(employeeId);
    if (Objects.isNull(theEmployee)) {
      throw new RuntimeException();
    }

    return theEmployee;
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee theEmployee) {
    // also, just in case they pass an id in JSON ... set the id to 0
    // this is to force a save of new item ... instead of update
    theEmployee.setId(0);

    return employeeService.save(theEmployee);
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee theEmployee) {
    return employeeService.save(theEmployee);
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
    Employee tempEmployee = employeeService.findById(employeeId);

    if (tempEmployee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    employeeService.deleteById(employeeId);

    return "Deleted employee id - " + employeeId;
  }
}
