package com.wasu.hutool.log.dialect.tinylog;

import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;

/**
 * <a href="http://www.tinylog.org/">TinyLog</a> log.<br>
 *
 * @author Looly
 */
public class TinyLogFactory extends LogFactory {

  /** 构造 */
  public TinyLogFactory() {
    super("TinyLog");
    checkLogExist(org.pmw.tinylog.Logger.class);
  }

  @Override
  public Log createLog(String name) {
    return new com.wasu.hutool.log.dialect.tinylog.TinyLog(name);
  }

  @Override
  public Log createLog(Class<?> clazz) {
    return new TinyLog(clazz);
  }
}
