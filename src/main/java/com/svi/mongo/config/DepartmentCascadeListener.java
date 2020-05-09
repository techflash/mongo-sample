package com.svi.mongo.config;

import com.svi.mongo.documents.Department;
import com.svi.mongo.documents.Employee;
import com.svi.mongo.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@RequiredArgsConstructor
public class DepartmentCascadeListener extends AbstractMongoEventListener<Department> {

  private final EmployeeService employeeService;

  @SneakyThrows
  @Override
  public void onBeforeDelete(BeforeDeleteEvent<Department> event) {
    super.onBeforeDelete(event);
    Department department = event.getType().cast(Department.class);
    System.out.println(department.toString());
    List<Employee> employeeList =
        employeeService.getEmployeesByDepartment(department.getId());

    if (!CollectionUtils.isEmpty(employeeList)) {
      throw new RuntimeException(
          "Can not delete department, its being reference by one or more employees");
    }
  }

  //  @Override
//  public void onBefore(BeforeConvertEvent<Employee> event) {
//    super.onBeforeConvert(event);
//    Employee source = event.getSource();
//    Department department = source.getDepartment();
//    departmentService.saveDepartment(department);
//  }
}
