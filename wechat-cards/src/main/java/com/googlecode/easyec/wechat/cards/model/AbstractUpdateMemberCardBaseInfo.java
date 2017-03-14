package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by admin on 2017/3/3.
 */
public abstract class AbstractUpdateMemberCardBaseInfo extends AbstractUpdateCardBaseInfo implements Serializable {

    private static final long serialVersionUID = 8675285023752564317L;

    @JsonProperty(required = true)
    private String title;                              // 卡券名，字数上限为9个汉字

    private PayInfo payInfo;                        //支付功能结构体
    private UpdateMemberDateInfo memberDateInfo;           // 使用日期

    // ----- 卡券非必填字段

    @JsonProperty("use_all_locations")
    private boolean useAllLocations;                   // 设置本卡券支持全部门店


    public String getTitle() {
        return title;
    }

    @JsonProperty("pay_info")
    public PayInfo getPayInfo() {
        return payInfo;
    }

    @JsonProperty("date_info")
    public UpdateMemberDateInfo getMemberDateInfo() {
        return memberDateInfo;
    }

    public boolean isUseAllLocations() {
        return useAllLocations;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setUseAllLocations(boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    public void setMemberDateInfo(UpdateMemberDateInfo memberDateInfo) {
        this.memberDateInfo = memberDateInfo;
    }
}
