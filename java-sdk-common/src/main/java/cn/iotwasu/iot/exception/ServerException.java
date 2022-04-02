package cn.iotwasu.iot.exception;

/**
 * @author liulihai
 * @since 2020-10-24 20:59:11
 */
public class ServerException extends ClientException {

  public ServerException(String errorCode, String errorMessage) {
    super(errorCode, errorMessage);
    this.setErrorType(ErrorType.Server);
  }

  public ServerException(String errCode, String errMsg, String requestId) {
    this(errCode, errMsg);
    this.setRequestId(requestId);
  }

  public ServerException(String message) {
    super(message);
    this.setErrorType(ErrorType.Server);
  }
}
