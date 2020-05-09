package com.svi.mongo.documents;

import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseEntity {

  @Id
  private String id;

  public BaseEntity(){
    this.id = UUID.randomUUID().toString();
  }
}
