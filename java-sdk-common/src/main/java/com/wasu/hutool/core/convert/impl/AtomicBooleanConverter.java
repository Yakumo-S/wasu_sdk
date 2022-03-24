package com.wasu.hutool.core.convert.impl;

import com.wasu.hutool.core.convert.AbstractConverter;
import com.wasu.hutool.core.util.BooleanUtil;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * {@link AtomicBoolean}转换器
 *
 * @author Looly
 * @since 3.0.8
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {
  private static final long serialVersionUID = 1L;

  @Override
  protected AtomicBoolean convertInternal(Object value) {
    if (boolean.class == value.getClass()) {
      return new AtomicBoolean((boolean) value);
    }
    if (value instanceof Boolean) {
      return new AtomicBoolean((Boolean) value);
    }
    final String valueStr = convertToStr(value);
    return new AtomicBoolean(BooleanUtil.toBoolean(valueStr));
  }
}
