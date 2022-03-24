package com.wasu.model.v202010;

import java.util.Map;

/**
 * 自定义字段信息
 *
 * @author 232676
 * @since 1.0.0 2020/11/6 10:53
 */
public class FieldExt {
  private String businessType;
  private Map<String, Object> useFieldNames;

  public String getBusinessType() {
    return businessType;
  }

  public void setBusinessType(String businessType) {
    this.businessType = businessType;
  }

  public Map<String, Object> getUseFieldNames() {
    return useFieldNames;
  }

  public void setUseFieldNames(Map<String, Object> useFieldNames) {
    this.useFieldNames = useFieldNames;
  }

  @Override
  public String toString() {
    return "CarFieldExt{"
        + "businessType='"
        + businessType
        + '\''
        + ", useFieldNames="
        + useFieldNames
        + '}';
  }
}
