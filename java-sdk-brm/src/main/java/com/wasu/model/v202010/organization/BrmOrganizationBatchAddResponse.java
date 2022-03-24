package com.wasu.model.v202010.organization;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 组织批量新增结果
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmOrganizationBatchAddResponse extends IccResponse {
  private OrganBatchData data;

  public OrganBatchData getData() {
    return data;
  }

  public void setData(OrganBatchData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmOrganizationBatchAddResponse{" + "data=" + data + '}';
  }

  public static class OrganBatchData {
    private List<OrganBatchResult> value;

    public List<OrganBatchResult> getValue() {
      return value;
    }

    public void setValue(List<OrganBatchResult> value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "OrganBatchData{" + "value=" + value + '}';
    }
  }

  public static class OrganBatchResult {
    private Long id;
    private String orgCode;
    private String orgName;
    private String orgType;
    private String orgPreCode;
    private int sort;
    private int forbidBindUser;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getOrgCode() {
      return orgCode;
    }

    public void setOrgCode(String orgCode) {
      this.orgCode = orgCode;
    }

    public String getOrgName() {
      return orgName;
    }

    public void setOrgName(String orgName) {
      this.orgName = orgName;
    }

    public String getOrgType() {
      return orgType;
    }

    public void setOrgType(String orgType) {
      this.orgType = orgType;
    }

    public String getOrgPreCode() {
      return orgPreCode;
    }

    public void setOrgPreCode(String orgPreCode) {
      this.orgPreCode = orgPreCode;
    }

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
    }

    public int getForbidBindUser() {
      return forbidBindUser;
    }

    public void setForbidBindUser(int forbidBindUser) {
      this.forbidBindUser = forbidBindUser;
    }

    @Override
    public String toString() {
      return "OrganBatchResult{"
          + "id="
          + id
          + ", orgCode='"
          + orgCode
          + '\''
          + ", orgName='"
          + orgName
          + '\''
          + ", orgType='"
          + orgType
          + '\''
          + ", orgPreCode='"
          + orgPreCode
          + '\''
          + ", sort="
          + sort
          + ", forbidBindUser="
          + forbidBindUser
          + '}';
    }
  }
}
