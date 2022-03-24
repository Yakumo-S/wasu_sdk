package com.wasu.hutool.log.dialect.commons;

import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;

/**
 * Apache Commons Logging
 *
 * @author Looly
 */
public class ApacheCommonsLogFactory extends LogFactory {

  public ApacheCommonsLogFactory() {
    super("Apache Common Logging");
    checkLogExist(org.apache.commons.logging.LogFactory.class);
  }

  @Override
  public Log createLog(String name) {
    try {
      return new com.wasu.hutool.log.dialect.commons.ApacheCommonsLog4JLog(name);
    } catch (Exception e) {
      return new com.wasu.hutool.log.dialect.commons.ApacheCommonsLog(name);
    }
  }

  @Override
  public Log createLog(Class<?> clazz) {
    try {
      return new ApacheCommonsLog4JLog(clazz);
    } catch (Exception e) {
      return new ApacheCommonsLog(clazz);
    }
  }

  @Override
  protected void checkLogExist(Class<?> logClassName) {
    super.checkLogExist(logClassName);
    // Commons Logging在调用getLog时才检查是否有日志实现，在此提前检查，如果没有实现则跳过之
    getLog(ApacheCommonsLogFactory.class);
  }
}
