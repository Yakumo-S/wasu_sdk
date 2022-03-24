package com.wasu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 屏幕自动截图
 *
 * @author 232676
 * @since 2021/01/12 10:50
 */
public class CaptureScreen {
  public static void captureScreen(String fileName, String folder) throws Exception {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle screenRectangle = new Rectangle(screenSize);
    Robot robot = new Robot();
    BufferedImage image = robot.createScreenCapture(screenRectangle);
    // 保存路径
    File screenFile = new File(fileName);
    if (!screenFile.exists()) {
      screenFile.mkdir();
    }
    File f = new File(screenFile, folder);
    ImageIO.write(image, "png", f);
    // 自动打开
    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN))
      Desktop.getDesktop().open(f);
  }

  public static void main(String[] args) {
    try {
      captureScreen("d:\\你好", "11.png");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
