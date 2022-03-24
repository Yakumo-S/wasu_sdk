package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

/**
 * 人员图片返回结果
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonUploadImgResponse extends IccResponse {
  private UploadImgData data;

  public UploadImgData getData() {
    return data;
  }

  public void setData(UploadImgData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmPersonUploadImgResponse{" + "data=" + data + '}';
  }

  public static class UploadImgData {
    private String fileUrl;

    public String getFileUrl() {
      return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
      this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
      return "UploadImgData{" + "fileUrl='" + fileUrl + '\'' + '}';
    }
  }
}
