package com.wasu.http;

import com.wasu.hutool.http.*;
import com.wasu.hutool.log.Log;
import com.wasu.hutool.log.LogFactory;
import com.wasu.icc.exception.ClientException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * icc http request
 *
 * <p>post 如不设置body内容，方法contentType默认是application/x-www-form-urlencoded，
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class IccHttpHttpRequest extends AbstractHttpRequest {
  private static final Log logger = LogFactory.get();

  /**
   * 请求体map对象
   *
   * <p>如bodyParameters不为空，会转为json,放入body中
   */
  protected final Map<String, Object> bodyParameters = new HashMap<String, Object>();
  /** http 请求工具类 */
  protected HttpRequest httpRequest;
  /**
   * 支持常见的form表单类型
   *
   * <p>application/x-www-form-urlencoded
   *
   * <p>multipart/form-data
   */
  protected Map<String, Object> form;

  /** 请求地址 */
  private String url;
  /** 方法类型 */
  private Method method;
  /**
   * 请求体body,此处与bodyParameters 效果相辅相成的
   *
   * <p>application/json
   */
  private String body;
  /** 请求头设置 */
  private Map<String, String> header;
  /** 是否需要鉴权,默认需要 */
  private boolean needAuth = Boolean.TRUE;

  /**
   * 构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @throws ClientException 客户端类型异常
   */
  public IccHttpHttpRequest(String url, Method method) throws ClientException {
    this.url = url;
    this.method = method;
    this.form = new HashMap<>();
    this.header = new HashMap<>();
    httpRequest = new HttpRequest(url).method(method);
  }

  /**
   * 构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @param needAuth 是否需要鉴权,默认true
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url, Method method, boolean needAuth) throws ClientException {
    this.url = url;
    this.method = method;
    this.form = new HashMap<>();
    this.header = new HashMap<>();
    this.needAuth = needAuth;
    httpRequest = new HttpRequest(url).method(method);
  }

  /**
   * 附带body构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @param needAuth 是否需要鉴权,默认true
   * @param body 请求体body
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url, Method method, boolean needAuth, String body)
      throws ClientException {
    this.url = url;
    this.method = method;
    this.form = new HashMap<>();
    this.header = new HashMap<>();
    this.body = body;
    this.needAuth = needAuth;
    httpRequest =
        new HttpRequest(url).method(method).body(body).contentType(ContentType.JSON.toString());
  }

  /**
   * form表单构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @param needAuth 是否需要鉴权,默认true
   * @param form map类型
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url, Method method, boolean needAuth, Map<String, Object> form)
      throws ClientException {
    this.url = url;
    this.method = method;
    this.form = form;
    this.header = new HashMap<>();
    this.needAuth = needAuth;
    httpRequest = new HttpRequest(url).method(method).body(body);
  }

  /**
   * body请求体构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @param body 默认json字符串
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url, Method method, String body) throws ClientException {
    this.url = url;
    this.method = method;
    this.form = new HashMap<>();
    this.header = new HashMap<>();
    this.body = body;
    httpRequest =
        new HttpRequest(url).method(method).body(body).contentType(ContentType.JSON.toString());
  }

  /**
   * form表单构造器
   *
   * @param url 请求地址
   * @param method 方法类型
   * @param form map类型
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url, Method method, Map<String, Object> form)
      throws ClientException {
    this.url = url;
    this.method = method;
    this.form = form;
    this.header = new HashMap<>();
    httpRequest = new HttpRequest(url).method(method).form(form);
  }

  /**
   * 默认GET方法
   *
   * @param url 请求地址
   * @throws ClientException 请求异常
   */
  public IccHttpHttpRequest(String url) throws ClientException {
    this.url = url;
    this.method = Method.GET;
    this.form = new HashMap<>();
    this.header = new HashMap<>();
    httpRequest = new HttpRequest(url).method(method);
  }

  public static void main(String[] args) {
    System.out.println(ContentType.FORM_URLENCODED.toString());
  }

  /**
   * POST构造器
   *
   * @param url 请求地址
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest post(String url) {
    this.url = url;
    this.method = Method.POST;
    httpRequest.setUrl(url).method(method);
    return this;
  }

  /**
   * GET构造器
   *
   * @param url 请求地址
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest get(String url) {
    this.url = url;
    this.method = Method.GET;
    httpRequest.setUrl(url).method(method);
    return this;
  }

  /**
   * 设置Body
   *
   * @param body 请求体，默认json对象
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest body(String body) {
    this.body = body;
    httpRequest.body(body);
    return this;
  }

  /**
   * 请求头
   *
   * @param name 请求头name
   * @param value 请求头value
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest header(String name, String value) {
    header.put(name, value);
    httpRequest.header(name, value);
    return this;
  }

  /**
   * 添加form表单参数
   *
   * @param name form键name
   * @param value form值value
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest form(String name, Object value) {
    form.put(name, value);
    httpRequest.form(name, value);
    return this;
  }

  /**
   * 添加form表单参数
   *
   * @param formParam map
   * @return IccHttpHttpRequest对象
   */
  public IccHttpHttpRequest form(Map<String, Object> formParam) {
    form.putAll(formParam);
    httpRequest.form(formParam);
    return this;
  }

  /**
   * 执行调用
   *
   * @return 返回body
   */
  public String execute() {
    HttpResponse response = httpRequest.execute();
    String resultBody = response.body();
    if (response.getStatus() != HttpStatus.HTTP_OK) {
      logger.warn(
          "request url [{}] an unexpected error ,origin response {}",
          httpRequest.getUrl(),
          resultBody);
    }
    return resultBody;
  }

  public HttpResponse executeResponse() {
    HttpResponse httpResponse = httpRequest.execute();
    if (httpResponse.getStatus() != HttpStatus.HTTP_OK) {
      logger.warn(
          "request url [{}] an unexpected error ,result code {}",
          httpRequest.getUrl(),
          httpResponse.getStatus());
    }
    return httpResponse;
  }

  @Override
  HttpRequest signRequest(IccHttpHttpRequest request) {

    return null;
  }

  public HttpRequest getHttpRequest() {
    return httpRequest;
  }

  public void setHttpRequest(HttpRequest httpRequest) {
    this.httpRequest = httpRequest;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
    httpRequest.setUrl(url);
  }

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
    httpRequest.setMethod(method);
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
    httpRequest.body(body);
  }

  public Map<String, Object> getForm() {
    return form;
  }

  public void setForm(Map<String, Object> form) {
    this.form = form;
    httpRequest.form(form);
  }

  public Map<String, String> getHeader() {
    return header;
  }

  public void setHeader(Map<String, String> header) {
    this.header = header;
    if (header != null && !header.isEmpty()) {
      Iterator<String> it = header.keySet().iterator();
      while (it.hasNext()) {
        httpRequest.header(it.next(), header.get(it.next()));
      }
    }
  }

  public boolean isNeedAuth() {
    return needAuth;
  }

  public void setNeedAuth(boolean needAuth) {
    this.needAuth = needAuth;
  }

  public Map<String, Object> getBodyParameters() {
    return bodyParameters;
  }
}
