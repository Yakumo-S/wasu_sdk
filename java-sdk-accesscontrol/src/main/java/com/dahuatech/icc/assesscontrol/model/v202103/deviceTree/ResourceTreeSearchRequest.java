package com.dahuatech.icc.assesscontrol.model.v202103.deviceTree;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.assesscontrol.constant.AccessControlConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 设备树
 *
 * @author 237417
 * @since 1.0.0 2021-03-18
 */
public class ResourceTreeSearchRequest  extends AbstractIccRequest<ResourceTreeSearchResponse> {

    /** 树类型编码 */
    private String typeCode;

    /** 是否查找rfid */
    private Boolean allowRFID;

    /** 设备类型: 0 - 门禁设备，1 - 考勤机，用逗号拼接，如0,1，值为空时，表示取所有类型的设备 */
    private String deviceGenre;

    /** 过滤不展示的设备型号，多个以逗号分隔。如："7,8" */
    private String filterDeviceModel;

    /** 是否有复选框 */
    private String hasCheckBox;

    /** 如果组织节点下没有设备或通道，则不显示此组织节点 */
    private String hideEmptyOrg;

    /** 查询关键字 */
    private String searchKey;

    /** 显示节点状态 */
    private String showStatus;

    private ResourceTreeSearchRequest(Builder builder) throws ClientException {
        super(AccessControlConstant.url(AccessControlConstant.ASSESS_CONTROL_URL_RESOURCE_TREE_SEARCH_POST), Method.POST);
        this.typeCode = builder.typeCode;
        putBodyParameter("typeCode", typeCode);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<ResourceTreeSearchResponse> getResponseClass() {
        return ResourceTreeSearchResponse.class;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
        putBodyParameter("typeCode", typeCode);
    }

    public Boolean getAllowRFID() {
        return allowRFID;
    }

    public void setAllowRFID(Boolean allowRFID) {
        this.allowRFID = allowRFID;
        putBodyParameter("allowRFID", allowRFID);
    }

    public String getDeviceGenre() {
        return deviceGenre;
    }

    public void setDeviceGenre(String deviceGenre) {
        this.deviceGenre = deviceGenre;
        putBodyParameter("deviceGenre", deviceGenre);
    }

    public String getFilterDeviceModel() {
        return filterDeviceModel;
    }

    public void setFilterDeviceModel(String filterDeviceModel) {
        this.filterDeviceModel = filterDeviceModel;
        putBodyParameter("filterDeviceModel", filterDeviceModel);
    }

    public String getHasCheckBox() {
        return hasCheckBox;
    }

    public void setHasCheckBox(String hasCheckBox) {
        this.hasCheckBox = hasCheckBox;
        putBodyParameter("hasCheckBox", hasCheckBox);
    }

    public String getHideEmptyOrg() {
        return hideEmptyOrg;
    }

    public void setHideEmptyOrg(String hideEmptyOrg) {
        this.hideEmptyOrg = hideEmptyOrg;
        putBodyParameter("hideEmptyOrg", hideEmptyOrg);
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
        putBodyParameter("searchKey", searchKey);
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
        putBodyParameter("showStatus", showStatus);
    }

    @Override
    public String toString() {
        return "ResourceTreeSearchRequest{" +
                "typeCode='" + typeCode + '\'' +
                ", allowRFID=" + allowRFID +
                ", deviceGenre='" + deviceGenre + '\'' +
                ", filterDeviceModel='" + filterDeviceModel + '\'' +
                ", hasCheckBox='" + hasCheckBox + '\'' +
                ", hideEmptyOrg='" + hideEmptyOrg + '\'' +
                ", searchKey='" + searchKey + '\'' +
                ", showStatus='" + showStatus + '\'' +
                '}';
    }

    public static class Builder {
        /** 树类型编码 */
        private String typeCode;

        public Builder typeCode(String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public ResourceTreeSearchRequest build() throws ClientException {
            return new ResourceTreeSearchRequest(this);
        }
    }
}
