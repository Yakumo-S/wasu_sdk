package com.wasu.model.v202010.person;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 人员全量数据同步,默认maxRangeId=1000L
 *
 * @author 232676
 * @since 1.0.0 2020/11/5 11:27
 */
public class BrmPersonSyncRequest extends AbstractIccRequest<BrmPersonSyncResponse> {

  private int pageSize;
  private int pageNum;
  private Long maxRangeId;
  private String searchKey;

  public BrmPersonSyncRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_SYNC_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("maxRangeId", 1000L);
  }

  @Override
  public Class<BrmPersonSyncResponse> getResponseClass() {
    return BrmPersonSyncResponse.class;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public Long getMaxRangeId() {
    return maxRangeId;
  }

  public void setMaxRangeId(Long maxRangeId) {
    this.maxRangeId = maxRangeId;
    putBodyParameter("maxRangeId", maxRangeId);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }
}
