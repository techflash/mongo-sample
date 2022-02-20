package com.svi.mongo.config;

import com.svi.mongo.documents.Employee;
import com.svi.mongo.model.Address;
import com.svi.mongo.repository.AddressRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@RequiredArgsConstructor
public class EmployeeCascadeListener extends AbstractMongoEventListener<Employee> {

  private final AddressRepository addressRepository;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
    super.onBeforeConvert(event);
    Employee source = event.getSource();
    List<Address> addresses = source.getAddresses();
    if (CollectionUtils.isEmpty(addresses)) {
      return;
    }
    addressRepository.saveAll(addresses);
  }
}
