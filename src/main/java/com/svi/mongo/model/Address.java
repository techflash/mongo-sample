package com.svi.mongo.model;

import com.svi.mongo.documents.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Address.DOCUMENT_NAME)
public class Address extends BaseEntity {

  public static final String DOCUMENT_NAME = "address";
  private String city;
  private String street;

  public Address() {
    super();
  }
}
