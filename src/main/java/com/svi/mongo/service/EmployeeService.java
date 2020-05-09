package com.svi.mongo.service;

import com.svi.mongo.documents.Employee;
import com.svi.mongo.model.EmployeeSearch;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@RequiredArgsConstructor
@Service
public class EmployeeService {

  private final MongoTemplate mongoTemplate;

  public Employee getEmployee(String id) {
    return mongoTemplate.findById(id, Employee.class);
  }

  public List<Employee> getAllEmployees() {
    return mongoTemplate.findAll(Employee.class);
  }

  public void addEmployee(Employee employee) {
    employee.setId(UUID.randomUUID().toString());
    mongoTemplate.insert(employee);
  }

  public List<Employee> searchEmployee(EmployeeSearch employeeSearch) {

//    TextCriteria textCriteria = new TextCriteria()
//        .forDefaultLanguage()
//        .caseSensitive(false)
//        .matching(employeeSearch.getQuery());

    Query textQuery = employeeSearch.query()
        .with(PageRequest.of(0, 10));

    return mongoTemplate.find(textQuery, Employee.class);
  }

  public void deleteEmployee(String id) {
    Query q = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(q, Employee.class);
  }

  public List<Employee> getEmployeesByDepartment(String id) {
    Query q = Query.query(Criteria.where("department.$id").is(id));
    return mongoTemplate.find(q, Employee.class);
  }

  public void updateEmployee(Employee employee) {
    mongoTemplate.save(employee);
  }
}
