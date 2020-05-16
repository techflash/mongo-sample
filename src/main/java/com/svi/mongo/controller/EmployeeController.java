package com.svi.mongo.controller;

import com.svi.mongo.documents.Employee;
import com.svi.mongo.model.EmployeeSearch;
import com.svi.mongo.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/employees/{id}")
  public Employee getEmployee(@PathVariable String id) {
    return employeeService.getEmployee(id);
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @PostMapping("/employees")
  public void addEmployee(@RequestBody Employee employee) {
    System.out.println(employee.toString());
    employeeService.addEmployee(employee);
  }

  @PostMapping("/employees/search")
  public List<Employee> searchEmployees(@RequestBody EmployeeSearch employeeSearch) {
    return employeeService.searchEmployee(employeeSearch);
  }

  @DeleteMapping("/employees/{id}")
  public void deleteEmployee(@PathVariable String id) {
    //jhkh
    employeeService.deleteEmployee(id);
  }

  @PutMapping("/employees/{id}")
  public void updateEmployee(@RequestBody Employee employee) {
    employeeService.updateEmployee(employee);
  }
}
