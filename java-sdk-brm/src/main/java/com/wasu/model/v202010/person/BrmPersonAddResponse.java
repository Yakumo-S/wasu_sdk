package com.wasu.model.v202010.person;

import com.wasu.http.IccResponse;

/**
 * @author 232676
 * @since 1.0.0 2020/11/9 11:19
 */
public class BrmPersonAddResponse extends IccResponse {
  private PersonIdData data;

  public PersonIdData getData() {
    return data;
  }

  public void setData(PersonIdData data) {
    this.data = data;
  }

  public static class PersonIdData {
    private Long id;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "PersonIdData{" + "id=" + id + '}';
    }
  }
}
