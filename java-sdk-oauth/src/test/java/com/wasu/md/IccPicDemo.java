package com.wasu.md;

import com.wasu.model.v202010.OssmConvertUtil;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccPicDemo {

  public static void main(String[] args) throws Exception {
    String host = "https://10.35.121.62";
    String path =
        "71f193ee-b2cb-11ea-a94e-000af7e4d68a/20201207/1/20d95d68-3831-11eb-a042-000af7e4d68a.jpg";

    System.out.println(OssmConvertUtil.download(path, "d:/3.jpg"));
  }
}
