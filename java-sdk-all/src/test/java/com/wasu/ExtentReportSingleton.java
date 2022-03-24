package com.wasu;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

/**
 * @author 232676
 * @since 1.0.0 2021/1/13 10:15
 */
public class ExtentReportSingleton {
  private static class SingletonHolder {
    private static final String reportPath = "reports/icc/index.html";
    private static final ExtentReports INSTANCE =
        new ExtentReports(reportPath, NetworkMode.OFFLINE);
  }

  private ExtentReportSingleton() {}

  public static synchronized ExtentReports getInstance() {
    return ExtentReportSingleton.SingletonHolder.INSTANCE;
  }

  public static void main(String[] args) {
    System.out.println(ExtentReportSingleton.getInstance());
  }
}
