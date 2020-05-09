/**
 * Copyright 2018. All rights reserved. All rights, titles and interest in and to this software are
 * owned by Market Logic Software AG, Berlin, Germany. Permission to use, copy, modify, distribute
 * or otherwise make this software available to any third party and for any purpose requires a
 * signed licensing agreement. Visit us at www.MarketLogicSoftware.com for commercial licensing
 * opportunities.
 */
package com.svi.mongo.config;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class OffsetDateTimeReadConverter implements Converter<Date, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(Date date) {
    return date == null ? null : date.toInstant().atOffset(ZoneOffset.UTC);
  }
}
