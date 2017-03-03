package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 表示微信卡券信息的对象基类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractWeChatCard extends AbstractCredentialCtrl implements Serializable {

    private static final long serialVersionUID = 6186687394542476430L;
    private String cardType;
    @JsonProperty(value = "base_info", required = true)
    private WeChatCardBaseInfoImpl baseInfo;
    @JsonProperty("advanced_info")
    private WeChatCardAdvancedInfo advancedInfo;

    protected AbstractWeChatCard(String cardType) {
        Assert.notNull(cardType);
        this.cardType = cardType;
    }

    @JsonProperty("card_type")
    public String getCardType() {
        return cardType;
    }

    public WeChatCardBaseInfoImpl getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(WeChatCardBaseInfoImpl baseInfo) {
        this.baseInfo = baseInfo;
    }

    public WeChatCardAdvancedInfo getAdvancedInfo() {
        return advancedInfo;
    }

    public void setAdvancedInfo(WeChatCardAdvancedInfo advancedInfo) {
        this.advancedInfo = advancedInfo;
    }
}
