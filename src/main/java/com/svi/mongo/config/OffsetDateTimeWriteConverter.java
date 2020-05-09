/**
 * Copyright 2018. All rights reserved. All rights, titles and interest in and to this software are
 * owned by Market Logic Software AG, Berlin, Germany. Permission to use, copy, modify, distribute
 * or otherwise make this software available to any third party and for any purpose requires a
 * signed licensing agreement. Visit us at www.MarketLogicSoftware.com for commercial licensing
 * opportunities.
 */
package com.svi.mongo.config;

import java.time.OffsetDateTime;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {

  @Override
  public Date convert(OffsetDateTime source) {
    return source == null ? null : Date.from(source.toInstant());
  }
}
