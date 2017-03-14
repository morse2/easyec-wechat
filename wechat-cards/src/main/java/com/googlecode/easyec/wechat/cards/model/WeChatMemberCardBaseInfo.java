package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信会员卡的基础信息类
 *
 * @author JunJie
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = { "cardCodeType" }
)
public class WeChatMemberCardBaseInfo extends AbstractWeChatCardBaseInfo {

    public static final String CUSTOM_CODE_MODE_DEPOSIT = "GET_CUSTOM_CODE_MODE_DEPOSIT";

    private static final long serialVersionUID = -2055897504919895364L;
    private PayInfo payInfo;                        //支付功能结构体
    private MemberCardDateInfo dateInfo;           // 使用日期

    // ----- 卡券非必填字段
    @JsonProperty("need_push_on_view")
    private Boolean needPushOnView;               //填写true为用户点击进入会员卡时推送事件，默认为false

    @JsonProperty("get_custom_code_mode")
    private String customCodeMode;                     // 填入GET_CUSTOM_CODE_MODE_DEPOSIT，表示该卡券为预存code模式卡券  *

    @JsonProperty("pay_info")
    public PayInfo getPayInfo() {
        return payInfo;
    }

    @JsonProperty("date_info")
    public MemberCardDateInfo getDateInfo() {
        return dateInfo;
    }

    public Boolean getNeedPushOnView() {
        return needPushOnView;
    }

    public void setNeedPushOnView(Boolean needPushOnView) {
        this.needPushOnView = needPushOnView;
    }

    public void setDateInfo(MemberCardDateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    public String getCustomCodeMode() {
        return customCodeMode;
    }

    public void setCustomCodeMode(String customCodeMode) {
        this.customCodeMode = customCodeMode;
    }
}
