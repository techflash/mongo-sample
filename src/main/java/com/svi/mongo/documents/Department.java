package com.svi.mongo.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@Document(value = Department.DOCUMENT_NAME)
public class Department {

  public static final String DOCUMENT_NAME = "department";

  @Id
  private String id;
  private String name;
  private String location;
}