package com.wasu.model.v202010.card;

import com.wasu.hutool.http.ContentType;
import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 卡片全量数据同步
 *
 * @author 232676
 * @since 1.0.0 2020/11/12 19:27
 */
public class BrmCardSyncRequest extends AbstractIccRequest<BrmCardSyncResponse> {

  private int pageNum;
  private int pageSize;
  private String searchKey;

  public BrmCardSyncRequest() throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_CARD_SYNC_POST), Method.POST);
    // 可能参数为空，hutool使用默认application/x-www-form-urlencoded
    httpRequest.contentType(ContentType.JSON.toString());
    // 设置个空置,防止Required request body is missing
    putBodyParameter("searchKey", "");
  }

  public int getPageNum() {
    return pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
    putBodyParameter("pageNum", pageNum);
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    putBodyParameter("pageSize", pageSize);
  }

  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
    putBodyParameter("searchKey", searchKey);
  }

  @Override
  public Class<BrmCardSyncResponse> getResponseClass() {
    return BrmCardSyncResponse.class;
  }
}
