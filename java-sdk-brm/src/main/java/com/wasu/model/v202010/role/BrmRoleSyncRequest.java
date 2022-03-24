package com.wasu.model.v202010.role;

import com.wasu.hutool.http.Method;
import com.wasu.constant.BrmConstant;
import com.wasu.icc.exception.ClientException;
import com.wasu.http.AbstractIccRequest;

/**
 * 角色全量信息同步
 *
 * @author 237417
 * @since 1.0.0 2021/02/23
 */
public class BrmRoleSyncRequest extends AbstractIccRequest<BrmRoleSyncResponse> {

    /** 当前页 */
    private Integer pageNum;
    /** 每页记录数 */
    private Integer pageSize;
    /*--------以上必填-----*/

    /** 是否获取菜单数据 默认是0 */
    private Integer menuNeed;


    public BrmRoleSyncRequest(Builder builder) throws ClientException {
        super(BrmConstant.url(BrmConstant.BRM_URL_ROLE_LIST_PAGE_POST), Method.POST);
        this.pageNum = builder.pageNum;
        this.pageSize = builder.pageSize;
        this.menuNeed = builder.menuNeed;
        putBodyParameter("pageNum", pageNum);
        putBodyParameter("pageSize", pageSize);
        putBodyParameter("menuNeed", menuNeed);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Class<BrmRoleSyncResponse> getResponseClass() {
        return BrmRoleSyncResponse.class;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        putBodyParameter("pageNum", pageNum);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        putBodyParameter("pageSize", pageSize);
    }

    public Integer getMenuNeed() {
        return menuNeed;
    }

    public void setMenuNeed(Integer menuNeed) {
        this.menuNeed = menuNeed;
        putBodyParameter("menuNeed", menuNeed);
    }

    @Override
    public String toString() {
        return "BrmRoleSyncRequest{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", menuNeed=" + menuNeed +
                '}';
    }

    public static class Builder {
        /** 当前页 */
        private Integer pageNum;
        /** 每页记录数 */
        private Integer pageSize;
        /*--------以上必填-----*/

        /** 是否获取菜单数据 默认是0 */
        private Integer menuNeed;

        public Builder pageNum(Integer pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder menuNeed(Integer menuNeed) {
            this.menuNeed = menuNeed;
            return this;
        }

        public BrmRoleSyncRequest build() throws ClientException {
            return new BrmRoleSyncRequest(this);
        }
    }
}
