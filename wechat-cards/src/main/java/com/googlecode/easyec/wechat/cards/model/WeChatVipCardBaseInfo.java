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
        value = {"cardCodeType"}
)
public class WeChatVipCardBaseInfo extends AbstractWeChatCardBaseInfo {

    private static final long serialVersionUID = -8575178088053529965L;
    private PayInfo payInfo;                        //支付功能结构体
    private MemberCardDateInfo dateInfo;           // 使用日期

    // ----- 卡券非必填字段
    @JsonProperty("need_push_on_view")
    private Boolean needPushOnView;               //填写true为用户点击进入会员卡时推送事件，默认为false

    @JsonProperty("pay_info")
    public PayInfo getPayInfo() {
        return payInfo;
    }

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
}
