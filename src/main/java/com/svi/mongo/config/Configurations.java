package com.svi.mongo.config;

import com.svi.mongo.model.Address;
//import com.svi.mongo.model.converter.AddressDbReadConverter;
//import com.svi.mongo.model.converter.AddressDbWriteConverter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

//@Configuration
//public class Configurations {
//
//  @Bean
//  public MongoCustomConversions mongoCustomConversions() {
//    List<Converter<?, ?>> converters = new ArrayList<>();
//    converters.add(new AddressDbReadConverter());
//    converters.add(new AddressDbWriteConverter());
//
//    return new MongoCustomConversions(converters);
//  }
//}
