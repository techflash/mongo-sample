package com.svi.mongo.config;

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
