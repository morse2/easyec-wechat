package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 表示微信卡券模块中的团购券类型的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeChatGroupon extends AbstractWeChatCard {

    private static final long serialVersionUID = -4730596562717210554L;
    @JsonProperty("deal_detail")
    private String detail;

    public WeChatGroupon() {
        super("GROUPON");
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
