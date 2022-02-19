package com.svi.mongo.repository;

import com.svi.mongo.model.Address;
import java.util.List;

public interface AddressRepositorySupport {

  public List<Address> search(String city);

}
