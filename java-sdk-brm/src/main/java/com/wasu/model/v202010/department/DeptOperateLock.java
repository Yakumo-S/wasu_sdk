package com.wasu.model.v202010.department;

/**
 * 操作权限
 *
 * @author 232676
 * @since 1.0.0 2020-10-24 20:59:11
 */
public class DeptOperateLock {
  private int add;
  private int update;
  private int delete;
  private int addDevice;

  public int getAdd() {
    return add;
  }

  public void setAdd(int add) {
    this.add = add;
  }

  public int getUpdate() {
    return update;
  }

  public void setUpdate(int update) {
    this.update = update;
  }

  public int getDelete() {
    return delete;
  }

  public void setDelete(int delete) {
    this.delete = delete;
  }

  public int getAddDevice() {
    return addDevice;
  }

  public void setAddDevice(int addDevice) {
    this.addDevice = addDevice;
  }
}
