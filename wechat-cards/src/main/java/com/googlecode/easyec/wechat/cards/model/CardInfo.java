package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 管理卡券 拉取卡券概况数据 返回数据list
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
        ignoreUnknown = true,
        value = "credential"
)
public abstract class CardInfo {

    private String refDate;                //日期信息

    private String viewCnt;                //浏览次数

    private String viewUser;               //浏览人数

    private String receiveCnt;             //领取次数

    private String receiveUser;            //领取人数

    private String verifyCnt;              //使用次数

    private String verifyUser;             //使用人数

    private String givenCnt;               //转赠次数

    private String givenUser;              //转赠人数

    private String expireCnt;              //过期次数

    private String expireUser;             //过期次数

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
    @JsonProperty("given_cnt")
    public void setGivenCnt(String givenCnt) {
        this.givenCnt = givenCnt;
    }
    @JsonProperty("given_user")
    public void setGivenUser(String givenUser) {
        this.givenUser = givenUser;
    }
    @JsonProperty("expire_cnt")
    public void setExpireCnt(String expireCnt) {
        this.expireCnt = expireCnt;
    }
    @JsonProperty("expire_user")
    public void setExpireUser(String expireUser) {
        this.expireUser = expireUser;
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

    public String getGivenCnt() {
        return givenCnt;
    }

    public String getGivenUser() {
        return givenUser;
    }

    public String getExpireCnt() {
        return expireCnt;
    }

    public String getExpireUser() {
        return expireUser;
    }
}
