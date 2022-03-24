package com.wasu.md;

import com.wasu.icc.exception.ClientException;
import com.wasu.icc.util.SignUtil;

/**
 * @author 232676
 * @since 2020/10/29 10:35
 */
public class IccChangePwdDemo {

  public static void main(String[] args) throws ClientException {
    String pubKey =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+O3hm7VL8xnZdcaOiPv8PGcjXMI5ZTecBFhqqaFfzaPx/28dFHELoHhfET6NeWdRmMqulGqjmO0CKk6EJVtGXBGggT5Q2rZYVJTqh8Kk7aiVphpR2wsztuQvOeAerLLxinEiFgqt/FifSYqNh0khUq5oxYQYKQquwbw1g+kiCuQIDAQAB";
    String password = "dahua2006";
    System.out.println("修改密码结果  " + SignUtil.encryptRSA(password, pubKey));
  }
}
