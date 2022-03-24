package com.wasu.model.v202104;

/**
 * 事件类型枚举类
 *
 * @author 232676
 * @since 2021/04/29 04:29
 */
public enum Category {
    /**
     * 报警类型，门禁刷卡等
     */
    alarm,
    /**
     * 业务通知。设备、人员，组织等增删改查事件
     */
    business,
    /**
     * 状态事件，设备通道上下线通知
     */
    state,
    /**
     * 感知消息，水位，温度，GPS等
     */
    perception
}
