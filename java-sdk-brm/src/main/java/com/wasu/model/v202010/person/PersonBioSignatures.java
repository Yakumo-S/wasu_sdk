package com.wasu.model.v202010.person;

/**
 * 生物特征数据:人脸头像、人脸特征、指纹特征
 *
 * @author 232676
 * @since 1.0.0 2020/11/9 14:21
 */
public class PersonBioSignatures {
  /** 生物特征类型 1 普通指纹 2 胁迫指纹 3 人脸图片 4 9241d人脸 5 红外人脸 */
  private int type;

  private int index;
  private Long personId;
  private String data;
  private String path;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  @Override
  public String toString() {
    return "PersonBioSignatures{"
        + "type="
        + type
        + ", index="
        + index
        + ", personId="
        + personId
        + ", data='"
        + data
        + '\''
        + ", path='"
        + path
        + '\''
        + '}';
  }
}
