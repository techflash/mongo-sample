package com.svi.mongo.repository;

import com.svi.mongo.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>, AddressRepositorySupport {

}
