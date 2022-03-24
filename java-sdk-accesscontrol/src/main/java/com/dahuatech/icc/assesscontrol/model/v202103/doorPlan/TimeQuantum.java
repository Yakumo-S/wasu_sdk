package com.dahuatech.icc.assesscontrol.model.v202103.doorPlan;

public class TimeQuantum {
    /** 计划详情 */
    private String detail;
    /** 计划ID */
    private Long id;
    /** 计划索引，在服务中作为唯一标识 */
    private Integer index;
    /** 描述 */
    private String memo;
    /** 计划名称 */
    private String name;
    /** 计划同步到服务的状态：0-未同步 1-已同步 */
    private Integer syncStatus;
    /** 计划类型 */
    private Integer type;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TimeQuantum{" +
                "detail='" + detail + '\'' +
                ", id=" + id +
                ", index=" + index +
                ", memo='" + memo + '\'' +
                ", name='" + name + '\'' +
                ", syncStatus=" + syncStatus +
                ", type=" + type +
                '}';
    }
}
