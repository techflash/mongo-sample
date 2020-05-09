package com.svi.mongo.service;

import com.svi.mongo.documents.Department;
import com.svi.mongo.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentService {

  private final DepartmentRepository departmentRepository;

  public Optional<Department> getDepartment(String id) {
    return departmentRepository.findById(id);
  }

  public void saveDepartment(Department department) {
    if (department.getId() == null) {
      department.setId(UUID.randomUUID().toString());
    }
    departmentRepository.save(department);
  }

  public void removeDepartment(String id) {
    departmentRepository.deleteById(id);
  }

  public List<Department> getAllDepartment() {
    return departmentRepository.findAll();
  }

}
