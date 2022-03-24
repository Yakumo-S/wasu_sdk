package com.dahuatech.icc.hrms.model.v202011.house;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.hrms.constant.HrmsConstant;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

import java.util.List;

public class HrmsHousePersonBingingRequest extends AbstractIccRequest<HrmsHousePersonBingingResponse> {

    /** 人员集合 */
    private List<HrmsHousePerson> hrmsHousePersonList;

    public HrmsHousePersonBingingRequest(Builder builder) throws ClientException {
        super(HrmsConstant.url(HrmsConstant.BRM_URL_HOUSE_PERSON_BINGING_GET), Method.POST);
        this.hrmsHousePersonList = builder.hrmsHousePersonList;
        putBodyParameter("hrmsHousePersonList",hrmsHousePersonList);
    }

    @Override
    public Class<HrmsHousePersonBingingResponse> getResponseClass() {
        return HrmsHousePersonBingingResponse.class;
    }

    private static Builder builder() {
        return new Builder();
    }

    public List<HrmsHousePerson> getHrmsHousePersonList() {
        return hrmsHousePersonList;
    }

    public void setHrmsHousePersonList(List<HrmsHousePerson> hrmsHousePersonList) {
        this.hrmsHousePersonList = hrmsHousePersonList;
        putBodyParameter("hrmsHousePersonList",hrmsHousePersonList);
    }

    private static class Builder {

        /** 人员集合 */
        private List<HrmsHousePerson> hrmsHousePersonList;

        public Builder hrmsHousePersonList(List<HrmsHousePerson> hrmsHousePersonList) {
            this.hrmsHousePersonList = hrmsHousePersonList;
            return this;
        }

        public HrmsHousePersonBingingRequest build() throws ClientException {
            return new HrmsHousePersonBingingRequest(this);
        }

    }

    private static class HrmsHousePerson {
        /** 人员部门ID */
        private String cardPersonId;
        /** 房屋ID */
        private String houseId;
        /** 人员姓名 */
        private String name;
        /** 操作(0:新增,1:修改,2:删除,3:其他(无任何操作)) */
        private String operate;
        /** 人员ID */
        private String personId;
        /** 入住房间号 */
        private String roomNumber;
        /** 开始时间 */
        private String validBeginTime;
        /** 结束时间 */
        private Long validEndTime;

        public String getCardPersonId() {
            return cardPersonId;
        }

        public void setCardPersonId(String cardPersonId) {
            this.cardPersonId = cardPersonId;
        }

        public String getHouseId() {
            return houseId;
        }

        public void setHouseId(String houseId) {
            this.houseId = houseId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOperate() {
            return operate;
        }

        public void setOperate(String operate) {
            this.operate = operate;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getValidBeginTime() {
            return validBeginTime;
        }

        public void setValidBeginTime(String validBeginTime) {
            this.validBeginTime = validBeginTime;
        }

        public Long getValidEndTime() {
            return validEndTime;
        }

        public void setValidEndTime(Long validEndTime) {
            this.validEndTime = validEndTime;
        }

        @Override
        public String toString() {
            return "HrmsHousePerson{" +
                    "cardPersonId='" + cardPersonId + '\'' +
                    ", houseId='" + houseId + '\'' +
                    ", name='" + name + '\'' +
                    ", operate='" + operate + '\'' +
                    ", personId='" + personId + '\'' +
                    ", roomNumber='" + roomNumber + '\'' +
                    ", validBeginTime='" + validBeginTime + '\'' +
                    ", validEndTime=" + validEndTime +
                    '}';
        }
    }
}

