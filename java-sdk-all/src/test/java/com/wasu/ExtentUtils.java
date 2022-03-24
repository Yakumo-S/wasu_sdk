package com.wasu;

import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.http.IccHttpHttpRequest;
import com.wasu.http.IccResponse;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

@ExtendWith(ExtentUtils.class)
public class ExtentUtils implements TestWatcher {
  protected static final Log logger = LogFactory.get();

  protected static final ExtentReports extent = ExtentReportSingleton.getInstance();

  @Override
  public void testAborted(ExtensionContext context, Throwable cause) {
    ExtentTest test = extent.startTest(context.getDisplayName(), "testAborted");
    test.assignCategory(context.getTags().stream().toArray(String[]::new));
    // step log
    test.log(LogStatus.FAIL, cause);
    flushReports(extent, test);
  }

  @Override
  public void testDisabled(ExtensionContext context, Optional<String> reason) {
    ExtentTest test = extent.startTest(context.getDisplayName(), "");
    test.assignCategory(context.getTags().stream().toArray(String[]::new));
    // step log
    test.log(LogStatus.SKIP, reason.orElse("-"));
    flushReports(extent, test);
  }

  @Override
  public void testSuccessful(ExtensionContext context) {
    ExtentTest test = extent.startTest(context.getDisplayName(), "");
    test.assignCategory(context.getTags().stream().toArray(String[]::new));
    // step log
    test.log(LogStatus.PASS, "-");
    flushReports(extent, test);
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    ExtentTest test = extent.startTest(context.getDisplayName(), "Test failed");
    test.assignCategory(context.getTags().stream().toArray(String[]::new));
    // step log
    test.log(LogStatus.FAIL, cause);
    flushReports(extent, test);
  }

  private void flushReports(ExtentReports extent, ExtentTest test) {
    // ending test
    extent.endTest(test);
    // writing everything to document
    extent.flush();
  }

  protected void printLog(IccHttpHttpRequest iccHttpHttpRequest, IccResponse iccResponse) {
    logger.info(
        "\n url={} \n header={} \n requestBody={} \n requestForm={} \n result={}",
        iccHttpHttpRequest.getUrl(),
        iccHttpHttpRequest.getHeader(),
        iccHttpHttpRequest.getBody(),
        iccHttpHttpRequest.getForm(),
        iccResponse.getResult());
  }
}
