package com.svi.mongo.documents;

import com.svi.mongo.model.Address;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Document(value = Employee.DOCUMENT_NAME)
public class Employee {

  public static final String DOCUMENT_NAME = "employee";

  @Id
  private String id;
  @Indexed
  private String name;
  private String dob;
  private Double salary;

  @TextIndexed
  private String jobTitle;
  @TextIndexed(weight = 2)
  private String jobDescription;

  @DBRef
  private List<Address> addresses;
  private Set<String> phoneNumbers;

  @DBRef
  private Department department;


}
