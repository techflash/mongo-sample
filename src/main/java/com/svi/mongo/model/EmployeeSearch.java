package com.svi.mongo.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Data
public class EmployeeSearch {

  private List<String> ids;
  private String query;
  private String phoneNumber;

  public Query query() {

    Criteria criteria = new Criteria();
    if (!CollectionUtils.isEmpty(ids)) {
      criteria.and("id").in(ids);
    }

    if (!StringUtils.isEmpty(query)) {
      criteria.and("name").regex(query, "i");
    }

    if (!StringUtils.isEmpty(phoneNumber)) {
      criteria.and("phoneNumbers").in(phoneNumber);
    }

    return Query.query(criteria);
  }
}
