package com.wasu.hutool.log.dialect.console;

import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;

/**
 * 利用System.out.println()打印日志
 *
 * @author Looly
 */
public class ConsoleLogFactory extends LogFactory {

  public ConsoleLogFactory() {
    super("wasuIot Console Logging");
  }

  @Override
  public Log createLog(String name) {
    return new com.wasu.hutool.log.dialect.console.ConsoleLog(name);
  }

  @Override
  public Log createLog(Class<?> clazz) {
    return new ConsoleLog(clazz);
  }
}
