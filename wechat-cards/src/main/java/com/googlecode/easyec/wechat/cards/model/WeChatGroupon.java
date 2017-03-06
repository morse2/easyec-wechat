package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 表示微信卡券模块中的团购券类型的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGroupon extends AbstractWeChatCard<WeChatCardInfo> {

    private static final long serialVersionUID = -2953384204705746830L;
    @JsonProperty("deal_detail")
    private String detail;

    public WeChatGroupon() {
        super(new WeChatCardInfo());
        setCardType("GROUPON");
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    @JsonProperty("groupon")
    public WeChatCardInfo getCardInfo() {
        return this.cardInfo;
    }
}
