package cn.iotwasu.hutool.core.convert.impl;

import cn.iotwasu.hutool.core.convert.AbstractConverter;
import java.util.TimeZone;

/**
 * TimeZone转换器
 *
 * @author Looly
 */
public class TimeZoneConverter extends AbstractConverter<TimeZone> {
  private static final long serialVersionUID = 1L;

  @Override
  protected TimeZone convertInternal(Object value) {
    return TimeZone.getTimeZone(convertToStr(value));
  }
}
