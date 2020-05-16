package com.svi.mongo;

import com.svi.mongo.documents.Department;
import com.svi.mongo.repository.DepartmentRepository;
import com.svi.mongo.service.DepartmentService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MongoApplicationTests {

  DepartmentService sut;
  DepartmentRepository departmentRepository;

  @BeforeEach
  void setup() {
    departmentRepository = Mockito.mock(DepartmentRepository.class);
    sut = new DepartmentService(departmentRepository);
  }

  @Test
  void shouldGetAllDepartments() {
    // given
    Mockito.when(departmentRepository.findAll()).thenReturn(
        Arrays.asList(Department.builder().name("IT").id("1001").location("Berlin").build())
    );

    // when
    List<Department> departmentList = sut.getAllDepartment();

    Assertions.assertEquals(departmentList.get(0).getName()
        , "IT");
  }

}
