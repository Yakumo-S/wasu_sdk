//package com.dahuatech.icc.test;
//
//import com.dahuatech.hutool.log.Log;
//import com.dahuatech.hutool.log.LogFactory;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author 232676
// * @since 1.0.0 2021/1/12 10:47
// */
//@ExtendWith(BaseIccTest.class)
//public class BaseIccTest implements TestWatcher {
//  private static final Log logger = LogFactory.get();
//
//  protected void saveScreen(String fileName) {
//    try {
//      TimeUnit.SECONDS.sleep(5);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    captureScreen(fileName);
//  }
//
//  private void captureScreen(String fileName) {
//    try {
//      captureScreen("", fileName);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  private void captureScreen(String fileName, String folder) throws Exception {
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    Rectangle screenRectangle = new Rectangle(screenSize);
//    Robot robot = new Robot();
//    BufferedImage image = robot.createScreenCapture(screenRectangle);
//    // 保存路径
//    File screenFile = new File(fileName);
//    if (!screenFile.exists()) {
//      screenFile.mkdir();
//    }
//    File f = new File(screenFile, folder);
//    ImageIO.write(image, "png", f);
//    // 自动打开
//    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
//      Desktop.getDesktop().open(f);
//  }
//
//  @Override
//  public void testFailed(ExtensionContext context, Throwable cause) {
//    // 截图方法。
//    logger.error(cause);
//    saveScreen(
//        context.getTestMethod().isPresent()
//            ? context.getTestMethod().get().getName()
//            : "" + "_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".png");
//  }
//}
