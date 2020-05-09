package com.svi.mongo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

//@Component
//@RequiredArgsConstructor
//public class GenericCascadeWriteListener extends AbstractMongoEventListener<Object> {
//
//  private final MongoTemplate mongoTemplate;
//
//  @Override
//  public void onBeforeConvert(BeforeConvertEvent<Object> event) {
//    super.onBeforeConvert(event);
//    Object document = event.getSource();
//
//    ReflectionUtils.doWithFields(document.getClass(), docField -> {
//      ReflectionUtils.makeAccessible(docField);
//
//      if (docField.isAnnotationPresent(DBRef.class)) {
//        final Object fieldValue = docField.get(document);
//
//        mongoTemplate.save(fieldValue);
//      }
//
//    });
//
//  }
//}
