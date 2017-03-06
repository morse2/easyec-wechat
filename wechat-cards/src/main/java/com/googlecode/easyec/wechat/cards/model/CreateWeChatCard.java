package com.googlecode.easyec.wechat.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.easyec.wechat.base.model.AbstractCredentialCtrl;
import org.springframework.util.Assert;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * 创建微信卡券数据的对象类
 *
 * @author JunJie
 */
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWeChatCard extends AbstractCredentialCtrl {

    private AbstractWeChatCard card;

    public CreateWeChatCard(AbstractWeChatCard card) {
        Assert.notNull(card);
        this.card = card;
    }

    @JsonProperty
    public AbstractWeChatCard getCard() {
        return card;
    }
}
