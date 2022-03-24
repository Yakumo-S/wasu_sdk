package com.wasu.model.v202010.user;

import com.wasu.http.IccResponse;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class BrmUserAddResponse extends IccResponse {
  private UserAddData data;

  public UserAddData getData() {
    return data;
  }

  public void setData(UserAddData data) {
    this.data = data;
  }



  @Override
  public String toString() {
    return "BrmUserAddResponse{" + "data=" + data + '}';
  }

  public static class UserAddData {
    private Integer id;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "UserAddData{" + "id='" + id + '\'' + '}';
    }
  }
}
