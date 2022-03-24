package com.wasu.http;

/**
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class Versions extends IotResponse {

  private VersionData data;

  public VersionData getData() {
    return data;
  }

  public void setData(VersionData data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Versions{" + "data=" + data + '}';
  }

  public static class VersionData {

    private String version;

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    @Override
    public String toString() {
      return "Versions{" + "version='" + version + '\'' + '}';
    }
  }
}
