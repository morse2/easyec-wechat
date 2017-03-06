package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 表示微信卡券信息的对象基类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = { "cardInfo" }
)
public abstract class AbstractWeChatCard<T extends AbstractWeChatCardInfo> implements Serializable {

    private static final long serialVersionUID = 1757690989108471214L;
    @JsonProperty("card_type")
    private String cardType;
    protected T cardInfo;

    protected AbstractWeChatCard(T cardInfo) {
        Assert.notNull(cardInfo);
        this.cardInfo = cardInfo;
    }

    public String getCardType() {
        return cardType;
    }

    protected void setCardType(String cardType) {
        this.cardType = cardType;
    }

    abstract public T getCardInfo();
}
