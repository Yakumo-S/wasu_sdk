package com.wasu.model.v202010.person;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

import java.util.List;

/**
 * 批量更新人员头像信息
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonBatchUpdateImgRequest
    extends AbstractIccRequest<BrmPersonBatchUpdateImgResponse> {

  private List<PersonBioSignatures> personBiosignatures;

  private BrmPersonBatchUpdateImgRequest(Builder builder) throws ClientException {
    super(BrmConstant.url(BrmConstant.BRM_URL_PERSON_FACE_BATCH_UPDATE_PUT), Method.PUT);
    this.personBiosignatures = builder.personBiosignatures;
    putBodyParameter("personBiosignatures", personBiosignatures);
  }

  public static Builder builder() {
    return new Builder();
  }

  public List<PersonBioSignatures> getPersonBiosignatures() {
    return personBiosignatures;
  }

  public void setPersonBiosignatures(List<PersonBioSignatures> personBiosignatures) {
    this.personBiosignatures = personBiosignatures;
    putBodyParameter("personBiosignatures", personBiosignatures);
  }

  @Override
  public Class<BrmPersonBatchUpdateImgResponse> getResponseClass() {
    return BrmPersonBatchUpdateImgResponse.class;
  }

  public static class Builder {
    private List<PersonBioSignatures> personBiosignatures;

    public Builder personBiosignatures(List<PersonBioSignatures> personBiosignatures) {
      this.personBiosignatures = personBiosignatures;
      return this;
    }

    public BrmPersonBatchUpdateImgRequest build() throws ClientException {
      return new BrmPersonBatchUpdateImgRequest(this);
    }
  }
}
