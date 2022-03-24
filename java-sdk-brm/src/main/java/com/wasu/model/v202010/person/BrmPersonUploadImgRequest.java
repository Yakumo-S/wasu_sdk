package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.io.File;

/**
 * 人员图片上传
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonUploadImgRequest extends AbstractIccRequest<BrmPersonUploadImgResponse> {

  public BrmPersonUploadImgRequest(File file) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_UPLOAD_IMG_POST), Method.POST);
    form("file", file);
  }

  public BrmPersonUploadImgRequest(String filePath) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_UPLOAD_IMG_POST), Method.POST);
    form("file", new File(filePath));
  }

  @Override
  public Class<BrmPersonUploadImgResponse> getResponseClass() {
    return BrmPersonUploadImgResponse.class;
  }
}
