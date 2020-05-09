package com.svi.mongo.config;

import com.svi.mongo.documents.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Configuration
//@Slf4j
//public class InitializeDatabase {
//
//  @Bean
//  public CommandLineRunner initDatabase(MongoTemplate mongoTemplate) {
//    return args -> {
//      Employee e = Employee.builder()
//          .id("emp01")
//          .name("Sunil")
//          .salary(5000.00)
//          .build();
//      mongoTemplate.insert(e);
//
//    };
//  }
//}