package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建微信卡券数据的对象类
 *
 * @author JunJie
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWeChatCard {

    private AbstractWeChatCard card;

    public CreateWeChatCard(AbstractWeChatCard card) {
        this.card = card;
    }

    @JsonProperty("card")
    public AbstractWeChatCard getCard() {
        return card;
    }
}
