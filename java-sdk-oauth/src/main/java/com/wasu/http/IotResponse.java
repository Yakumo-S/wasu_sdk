package com.wasu.http;

/**
 * @author liulihai
 * @since 1.0.0 2020-10-24 20:59:11
 */
public abstract class IotResponse extends Response {
  /** 结果原报文 */
  private String result;
  /** 请求ID */
  private String requestId;
  /** 返回状态码 */
  private String code;
  /** 是否成功 */
  private boolean success;
  /** 错误信息 */
  private String errMsg;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

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

  @Override
  public String toString() {
    return "IccResponse{"
        + "result='"
        + result
        + '\''
        + ", requestId='"
        + requestId
        + '\''
        + ", code='"
        + code
        + '\''
        + ", success="
        + success
        + ", errMsg='"
        + errMsg
        + '\''
        + '}';
  }
}
