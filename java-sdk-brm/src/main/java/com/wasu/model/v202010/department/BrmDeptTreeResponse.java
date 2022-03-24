package com.wasu.model.v202010.department;

import com.wasu.http.IccResponse;

import java.util.List;

/**
 * 部门树查询
 *
 * @author 232676
 * @since 1.0.0 2020-11-06 10:59:11
 */
public class BrmDeptTreeResponse extends IccResponse {
  private DeptTreeValue data;

  public DeptTreeValue getData() {
    return data;
  }

  public void setData(DeptTreeValue data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmDeptTreeResponse{" + "data=" + data + '}';
  }

  private static class DeptTreeValue {
    private List<DeptPageData> value;

    public List<DeptPageData> getValue() {
      return value;
    }

    public void setValue(List<DeptPageData> value) {
      this.value = value;
    }
  }

  public static class DeptPageData {
    private Long id;
    private Long parentId;
    private String name;
    private int checkStat;
    private int sort;
    private int isParent;
    private int nodeType;
    private int pageNum;
    private Long personId;
    private String personCode;
    private String personName;
    private Long personIdentity;
    private String paperNumber;
    private int paperType;
    private boolean isCheck;

    public Long getId() {

      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Long getParentId() {
      return parentId;
    }

    public void setParentId(Long parentId) {
      this.parentId = parentId;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getCheckStat() {
      return checkStat;
    }

    public void setCheckStat(int checkStat) {
      this.checkStat = checkStat;
    }

    public int getSort() {
      return sort;
    }

    public void setSort(int sort) {
      this.sort = sort;
    }

    public int getIsParent() {
      return isParent;
    }

    public void setIsParent(int isParent) {
      this.isParent = isParent;
    }

    public int getNodeType() {
      return nodeType;
    }

    public void setNodeType(int nodeType) {
      this.nodeType = nodeType;
    }

    public int getPageNum() {
      return pageNum;
    }

    public void setPageNum(int pageNum) {
      this.pageNum = pageNum;
    }

    public Long getPersonId() {
      return personId;
    }

    public void setPersonId(Long personId) {
      this.personId = personId;
    }

    public String getPersonCode() {
      return personCode;
    }

    public void setPersonCode(String personCode) {
      this.personCode = personCode;
    }

    public String getPersonName() {
      return personName;
    }

    public void setPersonName(String personName) {
      this.personName = personName;
    }

    public Long getPersonIdentity() {
      return personIdentity;
    }

    public void setPersonIdentity(Long personIdentity) {
      this.personIdentity = personIdentity;
    }

    public String getPaperNumber() {
      return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
      this.paperNumber = paperNumber;
    }

    public int getPaperType() {
      return paperType;
    }

    public void setPaperType(int paperType) {
      this.paperType = paperType;
    }

    public boolean isCheck() {
      return isCheck;
    }

    public void setCheck(boolean check) {
      isCheck = check;
    }

    @Override
    public String toString() {
      return "DeptPageData{"
          + "id="
          + id
          + ", parentId="
          + parentId
          + ", name='"
          + name
          + '\''
          + ", checkStat="
          + checkStat
          + ", sort="
          + sort
          + ", isParent="
          + isParent
          + ", nodeType="
          + nodeType
          + ", pageNum="
          + pageNum
          + ", personId="
          + personId
          + ", personCode='"
          + personCode
          + '\''
          + ", personName='"
          + personName
          + '\''
          + ", personIdentity="
          + personIdentity
          + ", paperNumber='"
          + paperNumber
          + '\''
          + ", paperType="
          + paperType
          + ", isCheck="
          + isCheck
          + '}';
    }
  }
}
