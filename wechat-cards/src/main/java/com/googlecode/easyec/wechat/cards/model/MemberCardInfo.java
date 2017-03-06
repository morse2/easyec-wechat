package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 拉取会员卡数据接口 返回数据list
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public class MemberCardInfo {

    private String refDate;                //日期信息

    private String viewCnt;                //浏览次数

    private String viewUser;               //浏览人数

    private String receiveCnt;             //领取次数

    private String receiveUser;            //领取人数

    private String verifyCnt;              //使用次数

    private String verifyUser;             //使用人数

    private String activeUser;             //激活人数

    private String totalUser;              //有效会员总人数

    private String totalReceiveUser;     //历史领取会员卡总人数

    @JsonProperty("ref_date")
    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    @JsonProperty("view_cnt")
    public void setViewCnt(String viewCnt) {
        this.viewCnt = viewCnt;
    }

    @JsonProperty("view_user")
    public void setViewUser(String viewUser) {
        this.viewUser = viewUser;
    }

    @JsonProperty("receive_cnt")
    public void setReceiveCnt(String receiveCnt) {
        this.receiveCnt = receiveCnt;
    }

    @JsonProperty("receive_user")
    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    @JsonProperty("verify_cnt")
    public void setVerifyCnt(String verifyCnt) {
        this.verifyCnt = verifyCnt;
    }

    @JsonProperty("verify_user")
    public void setVerifyUser(String verifyUser) {
        this.verifyUser = verifyUser;
    }

    @JsonProperty("active_user")
    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }

    @JsonProperty("total_user")
    public void setTotalUser(String totalUser) {
        this.totalUser = totalUser;
    }

    @JsonProperty("total_receive_user")
    public void setTotalReceiveUser(String totalReceiveUser) {
        this.totalReceiveUser = totalReceiveUser;
    }

    public String getRefDate() {
        return refDate;
    }

    public String getViewCnt() {
        return viewCnt;
    }

    public String getViewUser() {
        return viewUser;
    }

    public String getReceiveCnt() {
        return receiveCnt;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public String getVerifyCnt() {
        return verifyCnt;
    }

    public String getVerifyUser() {
        return verifyUser;
    }

    public String getActiveUser() {
        return activeUser;
    }

    public String getTotalUser() {
        return totalUser;
    }

    public String getTotalReceiveUser() {
        return totalReceiveUser;
    }
}
