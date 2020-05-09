package com.svi.mongo.controller;

import com.svi.mongo.documents.Department;
import com.svi.mongo.documents.Employee;
import com.svi.mongo.service.DepartmentService;
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
public class DepartmentController {

  private final DepartmentService departmentService;
  private final EmployeeService employeeService;

  @GetMapping("/departments/{id}")
  public Department getDepartment(@PathVariable String id) {
    return departmentService.getDepartment(id).get();
  }

  @GetMapping("/departments")
  public List<Department> getDepartments() {
    return departmentService.getAllDepartment();
  }

  @GetMapping("/departments/{id}/employees")
  public List<Employee> getDepartments(@PathVariable String id) {
    return employeeService.getEmployeesByDepartment(id);
  }

  @PostMapping("/departments")
  public void addEmployee(@RequestBody Department department) {
    departmentService.saveDepartment(department);
  }

  @DeleteMapping("/departments/{id}")
  public void removeDepartment(@PathVariable String id) {
    departmentService.removeDepartment(id);
  }

  @PutMapping("/departments/{id}")
  public void updateDepartment(@RequestBody Department department) {
    departmentService.saveDepartment(department);
  }
}
