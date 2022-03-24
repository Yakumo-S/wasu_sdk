package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

/**
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonGenIdResponse extends IccResponse {
  private GenIdData data;

  public GenIdData getData() {
    return data;
  }

  public void setData(GenIdData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BrmPersonGenIdResponse{" + "data=" + data + '}';
  }

  public static class GenIdData {
    private Long id;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "GenIdData{" + "id=" + id + '}';
    }
  }
}
