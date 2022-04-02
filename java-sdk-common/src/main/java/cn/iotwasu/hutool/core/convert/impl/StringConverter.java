package cn.iotwasu.hutool.core.convert.impl;

import cn.iotwasu.hutool.core.convert.AbstractConverter;

/**
 * 字符串转换器
 *
 * @author Looly
 */
public class StringConverter extends AbstractConverter<String> {
  private static final long serialVersionUID = 1L;

  @Override
  protected String convertInternal(Object value) {
    return convertToStr(value);
  }
}
