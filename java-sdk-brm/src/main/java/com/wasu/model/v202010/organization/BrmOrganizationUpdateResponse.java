package com.wasu.model.v202010.organization;

import com.wasu.http.IccResponse;

/**
 * 组织更新结果
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmOrganizationUpdateResponse extends IccResponse {
  private OrganAddData data;

  @Override
  public String toString() {
    return "BrmOrganizationAddResponse{" + "data=" + data + '}';
  }

  public OrganAddData getData() {
    return data;
  }

  public void setData(OrganAddData data) {
    this.data = data;
  }

  public static class OrganAddData {
    private String orgCode;
    private int sort;
    private String orgSn;

    public String getOrgCode() {
      return orgCode;
    }

    public void setOrgCode(String orgCode) {
      this.orgCode = orgCode;
    }

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
    }

    public String getOrgSn() {
      return orgSn;
    }

    public void setOrgSn(String orgSn) {
      this.orgSn = orgSn;
    }

    @Override
    public String toString() {
      return "OrganAddData{"
          + "orgCode='"
          + orgCode
          + '\''
          + ", sort="
          + sort
          + ", orgSn='"
          + orgSn
          + '\''
          + '}';
    }
  }
}
