package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 卡券管理中的卡券的基本信息和高级信息的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGrouponCardInfo extends AbstractWeChatCardInfo<WeChatCardBaseInfoImpl> {

    private static final long serialVersionUID = -701614691950501214L;
    @JsonProperty("deal_detail")
    private String grouponDetail;                       //团购券专用，团购详情。


    public WeChatGrouponCardInfo() {
        super(new WeChatCardBaseInfoImpl(), new WeChatCardAdvancedInfo());
    }

    public String getGrouponDetail() {
        return grouponDetail;
    }

    public void setGrouponDetail(String grouponDetail) {
        this.grouponDetail = grouponDetail;
    }
}
