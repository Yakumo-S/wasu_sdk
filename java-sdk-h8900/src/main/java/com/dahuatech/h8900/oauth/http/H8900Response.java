package com.dahuatech.h8900.oauth.http;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class H8900Response extends Response {
  /** 结果原报文 */
  private String result;

  private boolean success;

  private String errMsg;

  private String code;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
