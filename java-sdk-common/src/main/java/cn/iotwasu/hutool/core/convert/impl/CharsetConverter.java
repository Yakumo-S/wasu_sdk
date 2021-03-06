package cn.iotwasu.hutool.core.convert.impl;

import cn.iotwasu.hutool.core.convert.AbstractConverter;
import cn.iotwasu.hutool.core.util.CharsetUtil;
import java.nio.charset.Charset;

/**
 * 编码对象转换器
 *
 * @author Looly
 */
public class CharsetConverter extends AbstractConverter<Charset> {
  private static final long serialVersionUID = 1L;

  @Override
  protected Charset convertInternal(Object value) {
    return CharsetUtil.charset(convertToStr(value));
  }
}
