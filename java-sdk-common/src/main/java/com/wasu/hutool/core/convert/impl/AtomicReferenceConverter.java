package com.wasu.hutool.core.convert.impl;

import com.wasu.hutool.core.convert.AbstractConverter;
import com.wasu.hutool.core.convert.ConverterRegistry;
import com.wasu.hutool.core.util.TypeUtil;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

/**
 * {@link AtomicReference}转换器
 *
 * @author Looly
 * @since 3.0.8
 */
@SuppressWarnings("rawtypes")
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
  private static final long serialVersionUID = 1L;

  @Override
  protected AtomicReference<?> convertInternal(Object value) {

    // 尝试将值转换为Reference泛型的类型
    Object targetValue = null;
    final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
    if (false == TypeUtil.isUnknow(paramType)) {
      targetValue = ConverterRegistry.getInstance().convert(paramType, value);
    }
    if (null == targetValue) {
      targetValue = value;
    }

    return new AtomicReference<>(targetValue);
  }
}
