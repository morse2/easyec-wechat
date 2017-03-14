package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 表示修改微信卡券信息的对象基类

 */
@JsonIgnoreProperties(
    ignoreUnknown = true,
    value = { "cardInfo" }
)
public abstract class AbstractUpdateWeChatCard<T extends AbstractUpdateWeChatCardInfo> implements Serializable {

    private static final long serialVersionUID = 1757690989108471214L;

    protected T cardInfo;

    protected AbstractUpdateWeChatCard(T cardInfo) {
        Assert.notNull(cardInfo);
        this.cardInfo = cardInfo;
    }

    public AbstractUpdateWeChatCard() {

    }

    abstract public T getCardInfo();
}
