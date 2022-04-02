package cn.iotwasu.http;

/**
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public abstract class IotResponse extends Response {

  /**
   * 结果原报文
   */
  private String result;
  /**
   * 请求ID
   */
  private String requestId;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  @Override
  public String toString() {
    return "IotResponse{" +
        "result='" + result + '\'' +
        ", requestId='" + requestId + '\'' +
        '}';
  }
}
