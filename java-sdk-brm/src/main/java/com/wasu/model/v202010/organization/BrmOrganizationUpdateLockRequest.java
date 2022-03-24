package com.wasu.model.v202010.organization;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 批量更新组织操作权限，method=PUT，必填字段使用Builder
 *
 * @author 232676
 * @since 1.0.0 2020/11/4 08:49
 */
public class BrmOrganizationUpdateLockRequest
    extends AbstractIccRequest<BrmOrganizationUpdateLockResponse> {

  /** 服务唯一编码 */
  private String service;
  /** 组织编码集合 */
  private List<String> orgCodes;
  /** 操作权限锁 */
  private OperateLock operateLock;

  private BrmOrganizationUpdateLockRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_ORGAN_UPDATE_OPERATE_LOCK_PUT), Method.PUT);
    this.orgCodes = builder.orgCodes;
    this.operateLock = builder.operateLock;
    this.service = builder.service;
    putBodyParameter("operateLock", operateLock);
    putBodyParameter("orgCodes", orgCodes);
    putBodyParameter("service", service);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Class<BrmOrganizationUpdateLockResponse> getResponseClass() {
    return BrmOrganizationUpdateLockResponse.class;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    putBodyParameter("service", service);
    this.service = service;
  }

  public List<String> getOrgCodes() {
    return orgCodes;
  }

  public void setOrgCodes(List<String> orgCodes) {
    this.orgCodes = orgCodes;
    putBodyParameter("orgCodes", orgCodes);
  }

  public OperateLock getOperateLock() {
    return operateLock;
  }

  public void setOperateLock(OperateLock operateLock) {
    this.operateLock = operateLock;
    putBodyParameter("operateLock", operateLock);
  }

  @Override
  public String toString() {
    return "BrmOrganizationUpdateLockRequest{"
        + "service='"
        + service
        + '\''
        + ", orgCodes="
        + orgCodes
        + ", operateLock="
        + operateLock
        + '}';
  }

  public static class Builder {
    private List<String> orgCodes;
    private OperateLock operateLock;
    private String service;

    public Builder orgCodes(List<String> orgCodes) {
      this.orgCodes = orgCodes;
      return this;
    }

    public Builder operateLock(OperateLock operateLock) {
      this.operateLock = operateLock;
      return this;
    }

    public Builder service(String service) {
      this.service = service;
      return this;
    }

    public BrmOrganizationUpdateLockRequest build() throws ClientException {
      return new BrmOrganizationUpdateLockRequest(this);
    }
  }
}
